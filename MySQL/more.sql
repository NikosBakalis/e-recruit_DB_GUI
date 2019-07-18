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
CREATE PROCEDURE GetIDKY @applies.job_id AS INT
AS
SELECT applies.cand_usrname FROM applies
WHERE id = @applies.job_id
GO;
EXECUTE GetIDKY;


CREATE PROCEDURE procedure_name
AS
SELECT applies.cand_usrname FROM applies
GO;

/* 4.b */
DROP TRIGGER IF EXISTS history_trigger;
DELIMITER $$
CREATE
	TRIGGER history_trigger AFTER INSERT
	ON candidate
	FOR EACH ROW
	BEGIN
		INSERT INTO history VALUES ('user','2019-06-24 13:12:34','1','INSERT','candidate');
	END $$
DELIMITER ;