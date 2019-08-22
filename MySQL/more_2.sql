/* 3.a */
SELECT `user`.`name` AS 'Recruiters Name', `user`.surname AS 'Recruiters Surname', etaireia.name AS 'Companies Name', job.id AS 'Jobs ID', job.salary AS 'Salary', COUNT(applies.job_id) AS 'Number of Applicants' FROM job
INNER JOIN `user` ON job.recruiter = `user`.username
INNER JOIN recruiter ON recruiter.username = job.recruiter
INNER JOIN etaireia ON etaireia.AFM = recruiter.firm
INNER JOIN applies ON job.id = applies.job_id
WHERE job.salary > 1900
GROUP BY job.id;

/* 3.b */
SELECT candidate.username AS 'Candidates Username', candidate.certificates AS 'Certificates Name', COUNT(has_degree.degr_title) AS 'Number of degrees', /*COUNT(has_degree.degr_idryma), */AVG(has_degree.grade) AS 'Average Grade' FROM candidate
INNER JOIN has_degree ON has_degree.cand_usrname = candidate.username
GROUP BY candidate.username;

/* 3.c */
SELECT candidate.username AS 'Candidates Username', COUNT(applies.job_id) AS 'Number of Applicants', AVG(job.salary) AS 'Average Salary' FROM job
INNER JOIN applies ON job.id = applies.job_id
INNER JOIN candidate ON candidate.username = applies.cand_usrname
WHERE job.salary > 1800
GROUP BY candidate.username;

/* 3.d */
SELECT etaireia.name AS 'Companies Name' FROM etaireia
INNER JOIN recruiter ON recruiter.firm = etaireia.AFM
INNER JOIN job ON recruiter.username = job.recruiter
INNER JOIN requires ON job.id = requires.job_id
INNER JOIN antikeim ON antikeim.title = requires.antikeim_title
WHERE etaireia.city = 'Patra' AND requires.antikeim_title LIKE '%Program%';

/* 3.e */
SELECT recruiter.username AS 'Recruiters Name',co AS 'Number of Interviews',COUNT(*) AS 'Number of Jobs', AVG(job.salary) AS 'Average Salary' FROM recruiter
LEFT JOIN job ON recruiter.username=job.recruiter 
INNER JOIN (SELECT recruiter.username, COUNT(*) AS co FROM recruiter 
			LEFT JOIN interview ON recruiter.username=interview.recruiter_username
			GROUP BY recruiter.username) s ON s.username = recruiter.username 
GROUP BY s.username HAVING COUNT(*) >= 2 ORDER BY AVG(job.salary) DESC;

/*
SELECT recruiter.username, COUNT(job.recruiter), COUNT(interview.recruiter_username),
SUM(CASE WHEN HAVING COUNT(job.recruiter) > 2 THEN 1 ELSE 0 END) Count1,
SUM(CASE WHEN HAVING COUNT(job.recruiter) > 2 THEN 1 ELSE 0 END) Count2,
AVG(job.salary) FROM recruiter
INNER JOIN job ON job.recruiter = recruiter.username
INNER JOIN interview ON interview.recruiter_username = recruiter.username
GROUP BY job.salary
HAVING COUNT(job.recruiter) > 2
ORDER BY AVG(job.salary);
*/

/* 4.a */
DELIMITER $$
CREATE PROCEDURE evaluation (in id INT(4))
BEGIN 
	DECLARE recruiter VARCHAR(12);
	DECLARE per_sc INT(1);
	DECLARE edu_sc INT(1);
	DECLARE xp_sc INT(1);
	DECLARE message VARCHAR(100);
	DECLARE fin INT DEFAULT 0;
	DECLARE eval INT DEFAULT 1;
	DECLARE fail INT DEFAULT 0;
	DECLARE the_date DATE;
	DECLARE message_1 CHAR(20);
	DECLARE message_2 CHAR(20);
	DECLARE message_3 CHAR(20);
		
	DECLARE score_cur CURSOR FOR
	SELECT AVG(average_personality_score.per_sc) AS 'Personality Score', interview.edu_sc, interview.xp_sc
	FROM interview
	INNER JOIN applies ON applies.job_id = interview.job_id
	INNER JOIN job ON job.id = interview.job_id
	INNER JOIN average_personality_score ON average_personality_score.job_id = interview.job_id AND average_personality_score.recruiter_username = interview.recruiter_username AND average_personality_score.candidate_username = interview.candidate_username
	WHERE job.id = id
	/*GROUP BY interview.candidate_username*/;
	
	DECLARE submission_date CURSOR FOR
	SELECT job.submission_date
	FROM job;
	
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
	
	SELECT job.recruiter
	INTO recruiter
	FROM job
	WHERE job.id = id;
	
	OPEN score_cur;
	OPEN submission_date;
	
	score_check: LOOP
		FETCH score_cur INTO per_sc, edu_sc, xp_sc;
		FETCH submission_date INTO the_date;
		IF (the_date > CURRENT_DATE()) THEN
			SET eval = 0;
			LEAVE score_check;
		END IF;
		IF (per_sc = 0 OR edu_sc = 0 OR xp_sc = 0) THEN
			SET fail = 1;
			LEAVE score_check;
		END IF;
		IF fin = 1 THEN
			LEAVE score_check;
		END IF;
	END LOOP score_check;    
	CLOSE score_cur;
	
	IF eval = 0 THEN
		SET message = 'The evaluation of this job is incomplete.';
		SELECT message;
	ELSE
		SET message = 'The evaluation of this job is completed.';
		SELECT message;
		
		SELECT cand_usrname AS Candidate, 
		(AVG(average_personality_score.per_sc) + interview.edu_sc + interview.xp_sc - 2) AS Final_Score,
		/*(per_sc + edu_sc + xp_sc) AS Final_Score,*/
		AVG(average_personality_score.per_sc) AS Personality_Score, 
		interview.edu_sc AS Education_Score, 
		interview.xp_sc AS Experience_Score,
		COUNT(interview.candidate_username) AS Number_of_Interviews
		FROM applies
		INNER JOIN candidate ON applies.cand_usrname = candidate.username
		INNER JOIN interview ON candidate.username = interview.candidate_username
		INNER JOIN average_personality_score ON interview.candidate_username = average_personality_score.candidate_username
		WHERE applies.job_id = id AND interview.job_id = id
		GROUP BY Candidate
		HAVING (AVG(average_personality_score.per_sc) > 0 AND interview.edu_sc > 0 AND interview.xp_sc > 0)
		ORDER BY Final_Score DESC;
		
		IF fail = 1 THEN
			SELECT Candidate, Explanation
			FROM(
			SELECT interview.candidate_username AS Candidate, CONCAT_WS(', ',@message_3,@message_2,@message_1) AS Explanation,
			IF (per_sc = 0, @message_1 := 'failed the interview', @message_1 := ''),
			IF (edu_sc = 0, @message_2 := 'inadequate education', @message_2 :=''),
			IF (xp_sc = 0, @message_3 := 'no prior experience', @message_3 := '')
			FROM interview
			WHERE interview.job_id = id AND (per_sc = 0 OR edu_sc = 0 OR xp_sc = 0)) AS SOURCE;
		END IF;
	END IF;
END$$
DELIMITER ;

/* 4.b */

/* CANDIDATE */

DELIMITER $$
CREATE TRIGGER cand_insert AFTER INSERT ON candidate FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','INSERT','candidate');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER cand_delete AFTER DELETE ON candidate FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','DELETE','candidate');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER cand_update AFTER UPDATE ON candidate FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','UPDATE','candidate');
	END $$
DELIMITER ;

/* RECRUITER */

DELIMITER $$
CREATE TRIGGER rec_insert AFTER INSERT ON recruiter FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','INSERT','recruiter');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER rec_delete AFTER DELETE ON recruiter FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','DELETE','recruiter');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER rec_update AFTER UPDATE ON recruiter FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','UPDATE','recruiter');
	END $$
DELIMITER ;

/* USER */

DELIMITER $$
CREATE TRIGGER user_insert AFTER INSERT ON `user` FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','INSERT','user');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER user_delete AFTER DELETE ON `user` FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','DELETE','user');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER user_update AFTER UPDATE ON `user` FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','UPDATE','user');
	END $$
DELIMITER ;

/* JOB */

DELIMITER $$
CREATE TRIGGER job_insert AFTER INSERT ON job FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','INSERT','job');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER job_delete AFTER DELETE ON job FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','DELETE','job');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER job_update AFTER UPDATE ON job FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','UPDATE','job');
	END $$
DELIMITER ;


/* ETAIREIA */

DELIMITER $$
CREATE TRIGGER etaireia_insert AFTER INSERT ON etaireia FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','INSERT','etaireia');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER etaireia_delete AFTER DELETE ON etaireia FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','DELETE','etaireia');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER etaireia_update AFTER UPDATE ON etaireia FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES (user(), now(),'SUCCESS','UPDATE','etaireia');
	END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER etaireia_update_bef BEFORE UPDATE ON etaireia FOR EACH ROW
	BEGIN
		SET NEW.AFM = OLD.AFM;
		SET NEW.DOY = OLD.DOY;
		SET NEW.name = OLD.name;
	END $$
DELIMITER ;


/* 4.c */

DELIMITER $$
CREATE TRIGGER apply_delete BEFORE DELETE ON applies FOR EACH ROW
	BEGIN
		DECLARE sub_date DATE;
        SELECT job.submission_date
        INTO sub_date
        FROM job;
        SET date_check=datediff(job_date, current_date());
        IF ABS(date_check) < 0 then
			SIGNAL SQLSTATE '45000' /* Για καποιο λογο μου πετα error με την εκδοση εδω. Εκανα κι εναν ελεγχο με τον κωδικα των παιδιων, τα ιδια. */
			SET MESSAGE_TEXT = 'Submission date has passed. Deletion denied.';
		END IF;
	END $$
DELIMITER ;
