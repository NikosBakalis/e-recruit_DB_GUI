/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.database;

import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamysql.model.Applies;
import javamysql.model.AveragePersonalityScore;
import javamysql.model.Candidate;
import javamysql.model.Company;
import javamysql.model.Evaluation;
import javamysql.model.HasDegree;
import javamysql.model.Interview;
import javamysql.model.Job;
import javamysql.model.Languages;
import javamysql.model.Object;
import javamysql.model.Project;
import javamysql.model.Recruiter;
import javamysql.model.Sectors;
import javamysql.model.User;
import javamysql.ui.RecruiterAddAJob;
import javamysql.ui.AdminCreateCandidate;
import javamysql.ui.AdminCreateObject;
import javamysql.ui.AdminCreateRecruiter;
import javamysql.ui.AdminCreateSector;
import javamysql.ui.CandidateAddANewDegree;
import javamysql.ui.CandidateAddANewProject;
import javamysql.ui.CandidateDegrees;
import javamysql.ui.CandidateEditADegree;
import javamysql.ui.CandidateEditAProject;
import javamysql.ui.CandidateLanguages;
import javamysql.ui.CandidateProject;
import javamysql.ui.CandidateUI;
import javamysql.ui.RecruiterCompanyUI;
import javamysql.ui.RecruiterEditAJob;
import javamysql.ui.RecruiterInterviewEdit;
import javamysql.ui.RecruiterInterviewStart;
import javamysql.ui.Login;
import javamysql.ui.RecruiterUI;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nikolas
 */
public class ICRUDImpl implements ICRUD {

    private Connection connection;
    private DefaultListModel DLM;
    private int myPlacement = 1, allCandidates = 1;
    
    @Override
    public User getUser(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE user.username = '" + username + "' AND password = '" + password + "'";
            
            ResultSet resultSet;
            User user;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                user = null;
                if(resultSet.next()) {
                    user = new User();
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setReg_date(resultSet.getTimestamp("reg_date"));
                    user.setEmail(resultSet.getString("email"));
                }
            }
            resultSet.close();
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
    
    
    @Override
    public Recruiter getRecruiter(String username) {
        try {
            String query = "SELECT * FROM recruiter WHERE recruiter.username = '" + username + "'";
            
            ResultSet resultSet;
            Recruiter recruiter;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                recruiter = null;
                if(resultSet.next()) {
                    recruiter = new Recruiter();
                    recruiter.setUsername(resultSet.getString("username"));
                    recruiter.setExp_years(resultSet.getInt("exp_years"));
                    recruiter.setFirm(resultSet.getInt("firm"));
                }
            }
            resultSet.close();
            return recruiter;
        } catch (SQLException e) {
            return null;
        }
    }
    
    
    @Override
    public Candidate getCandidate(String username) {
        try {
            String query = "SELECT * FROM candidate WHERE candidate.username = '" + username + "'";
            
            ResultSet resultSet;
            Candidate candidate;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                candidate = null;
                if(resultSet.next()) {
                    candidate = new Candidate();
                    candidate.setUsername(resultSet.getString("username"));
                    candidate.setBio(resultSet.getString("bio"));
                    candidate.setSistatikes(resultSet.getString("sistatikes"));
                    candidate.setCertificates(resultSet.getString("certificates"));
                }
            }
            resultSet.close();
            return candidate;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateUI getCandidateUI(String username) {
        openConnection();
        CandidateUI candidateUI = new CandidateUI();
        try{
            Statement statement = getConnection().createStatement();
            String query1 = "UPDATE user SET password = '" + candidateUI.getNewPassword() + "', name = '" + candidateUI.getNewName() + "', surname = '" + candidateUI.getNewSurname() + "', email = '" + candidateUI.getNewEmail() + "' WHERE username = '" + username + "'";
            String query2 = "UPDATE candidate SET bio = '" + candidateUI.getNewBio() + "' WHERE username = '" + username + "'";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return candidateUI;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('" + username + "', NOW(), 'FAIL', 'UPDATE', 'user')";
                String query4 = "INSERT INTO history VALUES ('" + username + "', NOW(), 'FAIL', 'UPDATE', 'candidate')";
                statement.addBatch(query3);
                statement.addBatch(query4);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return candidateUI;
    }
    
    @Override
    public Job getJob(String position) {
        openConnection();
        try {
            String query = "SELECT * FROM job WHERE job.position = '" + position + "'";
            
            ResultSet resultSet;
            Job job;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                job = null;
                if(resultSet.next()) {
                    job = new Job();
                    job.setId(resultSet.getInt("id"));
                    job.setStartDate(resultSet.getDate("start_date"));
                    job.setSalary(resultSet.getInt("salary"));
                    job.setPosition(resultSet.getString("position"));
                    job.setCountry(resultSet.getString("edra"));
                    job.setRecruiter(resultSet.getString("recruiter"));
                    job.setAnnounceDate(resultSet.getTimestamp("announce_date"));
                    job.setSubmissionDate(resultSet.getDate("submission_date"));
                    job.setLastInterviewDate(resultSet.getDate("last_interview_date"));
                }
            }
            resultSet.close();
            return job;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Job getJob(int ID) {
        openConnection();
        try {
            String query = "SELECT * FROM job WHERE job.id = '" + ID + "'";
            
            ResultSet resultSet;
            Job job;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                job = null;
                if(resultSet.next()) {
                    job = new Job();
                    job.setId(resultSet.getInt("id"));
                    job.setStartDate(resultSet.getDate("start_date"));
                    job.setSalary(resultSet.getInt("salary"));
                    job.setPosition(resultSet.getString("position"));
                    job.setCountry(resultSet.getString("edra"));
                    job.setRecruiter(resultSet.getString("recruiter"));
                    job.setAnnounceDate(resultSet.getTimestamp("announce_date"));
                    job.setSubmissionDate(resultSet.getDate("submission_date"));
                    job.setLastInterviewDate(resultSet.getDate("last_interview_date")); 
                }
            }
            resultSet.close();
            return job;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Applies getApplies(String username, int job_ID){
        openConnection();
        try{
            Applies applies = new Applies();
            Statement statement = getConnection().createStatement();
            String query = "INSERT INTO applies VALUES ('" + username + "', " + job_ID + ")";
            statement.addBatch(query);
            statement.executeBatch();
            return applies;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Applies delApplies(String username, int job_ID){
        openConnection();
        try{
            Applies applies = new Applies();
            Statement statement = getConnection().createStatement();
            String query = "DELETE FROM applies WHERE cand_usrname = '" + username + "' AND job_id =  " + job_ID + "";
            statement.addBatch(query);
            statement.executeBatch();
            return applies;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Company getCompany(int AFM) {
        openConnection();
        try {
            String query = "SELECT * FROM etaireia WHERE AFM = '" + AFM + "'";
            
            ResultSet resultSet;
            Company company;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                company = null;
                if(resultSet.next()) {
                    company = new Company();
                    company.setAFM(resultSet.getInt("AFM"));
                    company.setDOY(resultSet.getString("DOY"));
                    company.setName(resultSet.getString("name"));
                    company.setTelephone(resultSet.getInt("tel"));
                    company.setStreet(resultSet.getString("street"));
                    company.setNumber(resultSet.getInt("num"));
                    company.setCity(resultSet.getString("city"));
                    company.setCountry(resultSet.getString("country"));
                }
            }
            resultSet.close();
            return company;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public RecruiterUI getRecruiterUI(String username) {
        openConnection();
        RecruiterUI recruiterUI = new RecruiterUI();
        try{
            Statement statement = getConnection().createStatement();
            String query1 = "UPDATE user SET password = '" + recruiterUI.getNewPassword() + "', name = '" + recruiterUI.getNewName() + "', surname = '" + recruiterUI.getNewSurname() + "', email = '" + recruiterUI.getNewEmail() + "' WHERE username = '" + username + "'";
            String query2 = "UPDATE recruiter SET exp_years = '" + recruiterUI.getNewExperienceYears()+ "' WHERE username = '" + username + "'";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return recruiterUI;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('" + username + "', NOW(), 'FAIL', 'UPDATE', 'user')";
                String query4 = "INSERT INTO history VALUES ('" + username + "', NOW(), 'FAIL', 'UPDATE', 'recruiter')";
                statement.addBatch(query3);
                statement.addBatch(query4);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return recruiterUI;
    }
    
    @Override
    public RecruiterCompanyUI getCompanyUI(int AFM) {
        openConnection();
        RecruiterCompanyUI companyUI = new RecruiterCompanyUI();
        try{
            Statement statement = getConnection().createStatement();
            String query = "UPDATE etaireia SET tel = " + companyUI.getNewTelephone() + ", street = '" + companyUI.getNewStreet()+ "', num = " + companyUI.getNewNumber() + ", city = '" + companyUI.getNewCity()+ "', country = '" + companyUI.getNewCountry() + "' WHERE AFM = " + AFM + "";
            statement.addBatch(query);
            statement.executeBatch();
            return companyUI;
        } catch (SQLException e) {
            try {
                RecruiterUI recruiterUI = new RecruiterUI();
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('" + recruiterUI.getNewUsername() + "', NOW(), 'FAIL', 'UPDATE', 'etaireia')";
                statement.addBatch(query3);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return companyUI;
    }
    
    /* ΕΔΩ ΝΑ ΕΡΘΕΙ Ο ΚΩΔΙΚΑ ΑΠΟ ΤΟ RecruiterNewPosition ΑΦΟΥ ΦΤΙΑΞΩ GETTER / SETTER ΓΙΑ ΤΟ TableJob */
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    @Override
    public RecruiterNewPosition getNewJob(int id, String recruiter) {
        openConnection();
        // setDLM(new DefaultListModel());
        try{
            RecruiterNewPosition recruiterNewPosition = new RecruiterNewPosition();
            String query = "SELECT * FROM job";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            recruiterNewPosition.TableJob.setModel(DbUtils.resultSetToTableModel(resultSet));
            System.out.println(id + " " + recruiter);
            return recruiterNewPosition;
        } catch (SQLException e) {
            return null;
        }
    }
    */
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public RecruiterAddAJob newJob(int ID, String recruiter){
        openConnection();
        RecruiterAddAJob addAJob = new RecruiterAddAJob();
        try{
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO job VALUES ('" + ID + "', '" + addAJob.getNewStartDate() + "', '" + addAJob.getNewSalary() + "', '" + addAJob.getNewPosition() + "', '" + addAJob.getNewSeat() + "', '" + recruiter + "', '" + addAJob.getNewAnnounceDate() + "', '" + addAJob.getNewSubmissionDate() + "', '" + addAJob.getNewLastInterviewDate() + "')";
            String query2 = "INSERT INTO requires VALUES ('" + ID + "', '" + addAJob.getNewRequires() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return addAJob;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('" + recruiter + "', NOW(), 'FAIL', 'INSERT', 'job')";
                statement.addBatch(query3);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return addAJob;
    }
    
    @Override
    public Job delJob(int job_ID, String username){
        openConnection();
        Job job = new Job();
        try{
            Statement statement = getConnection().createStatement();
            String query = "DELETE FROM job WHERE recruiter = '" + username + "' AND id =  " + job_ID + "";
            statement.addBatch(query);
            statement.executeBatch();
            return job;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('" + username + "', NOW(), 'FAIL', 'DELETE', 'job')";
                statement.addBatch(query3);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return job;
    }
    
    @Override
    public RecruiterEditAJob editAJob(int ID){
        openConnection();
        RecruiterEditAJob editAJob = new RecruiterEditAJob();
        try{
            Statement statement = getConnection().createStatement();
            String query = "UPDATE job SET start_date = '" + editAJob.getNewStartDate() + "', salary = '" + editAJob.getNewSalary() + "', position = '" + editAJob.getNewPosition() + "', edra = '" + editAJob.getNewSeat() + "', submission_date = '" + editAJob.getNewSubmissionDate() + "', last_interview_date = '" + editAJob.getNewLastInterviewDate() + "' WHERE id = '" + ID + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return editAJob;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('" + editAJob.getNewRecruiter() + "', NOW(), 'FAIL', 'UPDATE', 'job')";
                statement.addBatch(query3);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return editAJob;
    }
    
    @Override
    public Object getObject(){
        openConnection();
        try {
            String query = "SELECT * FROM antikeim";
            ResultSet resultSet;
            Object object;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                object = null;
                
                while(resultSet.next()) {
                    object = new Object();
                    object.setTitle(resultSet.getString("title"));
                    object.setDescription(resultSet.getString("descr"));
                    object.setBelongsTo(resultSet.getString("belongs_to"));
                }
            }
            resultSet.close();
            return object;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AdminCreateCandidate adminCreateCandidate(){
        openConnection();
        AdminCreateCandidate adminCreateCandidate = new AdminCreateCandidate();
        User user = new User();
        try{
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO user VALUES ('" + adminCreateCandidate.getNewUsername() + "', '" + adminCreateCandidate.getNewPassword() + "', '" + adminCreateCandidate.getNewName() + "', '" + adminCreateCandidate.getNewSurname() + "', '" + adminCreateCandidate.getNewRegisterDate() + "', '" + adminCreateCandidate.getNewEmail() + "')";
            String query2 = "INSERT INTO candidate VALUES ('" + adminCreateCandidate.getNewUsername() + "', '" + adminCreateCandidate.getNewBio() + "', '" + adminCreateCandidate.getNewRecommendation() + "', '" + adminCreateCandidate.getNewCertificates() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return adminCreateCandidate;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('admin', NOW(), 'FAIL', 'INSERT', 'user')";
                String query4 = "INSERT INTO history VALUES ('" + user.getUsername() + "', NOW(), 'FAIL', 'INSERT', 'candidate')";
                statement.addBatch(query3);
                statement.addBatch(query4);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return adminCreateCandidate;
    }
    
    @Override
    public AdminCreateRecruiter adminCreateRecruiter(){
        openConnection();
        AdminCreateRecruiter adminCreateRecruiter = new AdminCreateRecruiter();
        User user = new User();
        try{
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO user VALUES ('" + adminCreateRecruiter.getNewUsername() + "', '" + adminCreateRecruiter.getNewPassword() + "', '" + adminCreateRecruiter.getNewName() + "', '" + adminCreateRecruiter.getNewSurname() + "', '" + adminCreateRecruiter.getNewRegisterDateTime() + "', '" + adminCreateRecruiter.getNewEmail() + "')";
            String query2 = "INSERT INTO recruiter VALUES ('" + adminCreateRecruiter.getNewUsername() + "', '" + adminCreateRecruiter.getNewExperienceYears() + "', '" + adminCreateRecruiter.getNewFirm() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return adminCreateRecruiter;
        } catch (SQLException e) {
            try {
                Statement statement = getConnection().createStatement();
                String query3 = "INSERT INTO history VALUES ('admin', NOW(), 'FAIL', 'INSERT', 'user')";
                String query4 = "INSERT INTO history VALUES ('" + user.getUsername() + "', NOW(), 'FAIL', 'INSERT', 'recruiter')";
                statement.addBatch(query3);
                statement.addBatch(query4);
                statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return adminCreateRecruiter;
    }
    
    @Override
    public Interview getInterview(String recruiterUsername, String candidateUsername, int jobID) {
        openConnection();
        try {
            String query = "SELECT * FROM interview WHERE recruiter_username = '" + recruiterUsername + "' AND candidate_username = '" + candidateUsername + "' AND job_id = '" + jobID + "'";
            
            ResultSet resultSet;
            Interview interview;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                interview  = null;
                if(resultSet.next()) {
                    interview = new Interview();
                    interview.setRecruiterUsername(resultSet.getString("recruiter_username"));
                    interview.setCandidateUsername(resultSet.getString("candidate_username"));
                    interview.setJobID(resultSet.getInt("job_id"));
                    interview.setInterviewDate(resultSet.getDate("interview_date"));
                    interview.setStartingTime(resultSet.getTime("starting_time"));
                    interview.setDuration(resultSet.getTime("duration"));
                    interview.setComments(resultSet.getString("comments"));
                    interview.setEducationScore(resultSet.getInt("edu_sc"));
                    interview.setExperienceScore(resultSet.getInt("xp_sc"));
                }
            }
            resultSet.close();
            return interview;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public RecruiterInterviewEdit interviewEdit(String recruiterUsername, String candidateUsername, int jobID) {
        openConnection();
        try{
            RecruiterInterviewEdit interviewEdit = new RecruiterInterviewEdit();
            Statement statement = getConnection().createStatement();
            String query = "UPDATE interview SET interview_date = '" + interviewEdit.getNewInterviewDate() + "', starting_time = '" + interviewEdit.getNewStartingTime() + "', duration = '" + interviewEdit.getNewDuration() + "', comments = '" + interviewEdit.getNewComments() + "', edu_sc = '" + interviewEdit.getNewEducationScore() + "', xp_sc = '" + interviewEdit.getNewExperienceScore() + "' WHERE recruiter_username = '" + interviewEdit.getNewRecruiterUsername() + "' AND candidate_username = '" + interviewEdit.getNewCandidateUsername() + "' AND job_id = '" + interviewEdit.getNewJobID() + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return interviewEdit;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AveragePersonalityScore getAveragePersonalityScore(String recruiterUsername, String candidateUsername, int jobID) {
        openConnection();
        try {
            String query = "SELECT id, recruiter_username, candidate_username, job_id, per_sc, AVG(per_sc) AS 'Average Personality Score' FROM average_personality_score WHERE recruiter_username = '" + recruiterUsername + "' AND candidate_username = '" + candidateUsername + "' AND job_id = '" + jobID + "'";

            ResultSet resultSet;
            AveragePersonalityScore averagePersonalityScore;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                averagePersonalityScore  = null;
                if(resultSet.next()) {
                    averagePersonalityScore = new AveragePersonalityScore();
                    averagePersonalityScore.setId(resultSet.getInt("id"));
                    averagePersonalityScore.setRecruiterUsername(resultSet.getString("recruiter_username"));
                    averagePersonalityScore.setCandidateUsername(resultSet.getString("candidate_username"));
                    averagePersonalityScore.setJobID(resultSet.getInt("job_id"));
                    averagePersonalityScore.setPersonalityScore(resultSet.getInt("per_sc"));
                    averagePersonalityScore.setAveragePersonalityScore(resultSet.getDouble("Average Personality Score")); // TO SEE
                }
            }
            resultSet.close();
            return averagePersonalityScore;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public RecruiterInterviewStart interviewStart(String recruiterUsername,String candidateUsername, int jobID) {
        openConnection();
        try{
            RecruiterInterviewStart interviewStart = new RecruiterInterviewStart();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO interview VALUES ('" + interviewStart.getNewRecruiterUsername() + "', '" + interviewStart.getNewCandidateUsername() + "', '" + interviewStart.getNewJobID() + "', '" + interviewStart.getNewInterviewDate() + "', '" + interviewStart.getNewStartingTime() + "', '" + interviewStart.getNewDuration() + "', '" + interviewStart.getNewComments() + "', '" + interviewStart.getNewEducationScore() + "', '" + interviewStart.getNewExperienceScore() + "')";
            String query2 = "INSERT INTO average_personality_score (recruiter_username, candidate_username, job_id, per_sc) VALUES ('" + interviewStart.getNewRecruiterUsername() + "', '" + interviewStart.getNewCandidateUsername() + "', '" + interviewStart.getNewJobID() + "', '" + interviewStart.getNewPersonalityScore() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return interviewStart;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AdminCreateObject adminCreateObject() {
        openConnection();
        try{
            AdminCreateObject adminCreateObject = new AdminCreateObject();
            Statement statement = getConnection().createStatement();
            String query = "INSERT INTO antikeim VALUES ('" + adminCreateObject.getNewTitle() + "', '" + adminCreateObject.getNewDescription() + "', '" + adminCreateObject.getNewBelongsTo() + "')";
            statement.addBatch(query);
            statement.executeBatch();
            return adminCreateObject;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AdminCreateObject adminCreateObjectNull() {
        openConnection();
        try{
            AdminCreateObject adminCreateObject = new AdminCreateObject();
            Statement statement = getConnection().createStatement();
            String query = "INSERT INTO antikeim VALUES ('" + adminCreateObject.getNewTitle() + "', '" + adminCreateObject.getNewDescription() + "', NULL)";
            statement.addBatch(query);
            statement.executeBatch();
            return adminCreateObject;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Sectors getSectors(){
        openConnection();
        try {
            String query = "SELECT * FROM sectors_levels";
            ResultSet resultSet;
            Sectors sectors;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                sectors = null;
                
                while(resultSet.next()) {
                    sectors = new Sectors();
                    sectors.setTitle(resultSet.getString("sectors_title"));
                    sectors.setDescription(resultSet.getString("description"));
                    sectors.setBelongsTo(resultSet.getString("belongs_to"));
                }
            }
            resultSet.close();
            return sectors;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AdminCreateSector adminCreateSector() {
        openConnection();
        try{
            AdminCreateSector adminCreateSector = new AdminCreateSector();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO sectors VALUES ('" + adminCreateSector.getNewCompanysAFM() + "', '" + adminCreateSector.getNewTitle() + "')";
            String query2 = "INSERT INTO sectors_levels VALUES ('" + adminCreateSector.getNewTitle() + "', '" + adminCreateSector.getNewDescription() + "', '" + adminCreateSector.getNewBelongsTo() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return adminCreateSector;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AdminCreateSector adminCreateSectorNull() {
        openConnection();
        try{
            AdminCreateSector adminCreateSector = new AdminCreateSector();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO sectors VALUES ('" + adminCreateSector.getNewCompanysAFM() + "', '" + adminCreateSector.getNewTitle() + "')";
            String query2 = "INSERT INTO sectors_levels VALUES ('" + adminCreateSector.getNewTitle() + "', '" + adminCreateSector.getNewDescription() + "', NULL)";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return adminCreateSector;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Evaluation evaluation(int jobID){
        openConnection();
        String query = "{CALL evaluation(?)}";
        Evaluation evaluation = new Evaluation();
        Candidate candidate = new Candidate();
        int counter = 1;
        try {
            CallableStatement callableStatement = getConnection().prepareCall(query);
            callableStatement.setInt(1, jobID);
            callableStatement.execute();
            ResultSet resultSet1, resultSet2, resultSet3;
            resultSet1 = callableStatement.getResultSet();
            while (resultSet1.next()) {
                evaluation.setMessage(resultSet1.getString(1));
            }
            resultSet1.close();
            if(callableStatement.getMoreResults()){
                resultSet2 = callableStatement.getResultSet();
                while(resultSet2.next()){
                    evaluation.setCandidateUsername(resultSet2.getString(1));
                    evaluation.setFinalScore(resultSet2.getInt(2));
                    evaluation.setPersonalityScore(resultSet2.getInt(3));
                    evaluation.setEducationScore(resultSet2.getInt(4));
                    evaluation.setExperienceScore(resultSet2.getInt(5));
                    evaluation.setNumberOfInterviews(resultSet2.getInt(6));
                    if(evaluation.getCandidateUsername().equals(candidate.getUsername())){
                        setMyPlacement(counter);
                    }
                    setAllCandidates(counter);
                    counter++;
                }
                resultSet2.close();
            }
            if(callableStatement.getMoreResults()){
                resultSet3 = callableStatement.getResultSet();
                while(resultSet3.next()){
                    evaluation.setDenyUsername(resultSet3.getString(1));
                    evaluation.setExplanation(resultSet3.getString(2));
                }
                resultSet3.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ICRUDImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evaluation;
    }
    
    @Override
    public Login login(String username) {
        openConnection();
        try{
            Login login = new Login();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO login VALUES ('" + username + "', NOW())";
            statement.addBatch(query1);
            statement.executeBatch();
            return login;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Languages getLanguages(String candidateUsername){
        openConnection();
        try {
            String query = "SELECT * FROM languages WHERE candid = '" + candidateUsername + "'";
            ResultSet resultSet;
            Languages languages;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                languages = null;
                
                while(resultSet.next()) {
                    languages = new Languages();
                    languages.setCandidateUsername(resultSet.getString(1));
                    languages.setLanguages(resultSet.getString(2));
                }
            }
            resultSet.close();
            return languages;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateLanguages newCandidateLanguages(String candidateUsername) {
        openConnection();
        try{
            CandidateLanguages candidateLanguages = new CandidateLanguages();
            Statement statement = getConnection().createStatement();
            String query1 = "DELETE FROM languages WHERE candid = '" + candidateUsername + "'";
            String query2 = "INSERT INTO languages VALUES ('" + candidateUsername + "', '" + candidateLanguages.getLanguagesCombinations()+ "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return candidateLanguages;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Project getProject(String candidateUsername, int numberOfProject){
        openConnection();
        try {
            String query = "SELECT * FROM project WHERE candid = '" + candidateUsername + "' AND num = '" + numberOfProject + "'";
            ResultSet resultSet;
            Project project;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                project = null;
                
                while(resultSet.next()) {
                    project = new Project();
                    project.setCandidateUsername(resultSet.getString(1));
                    project.setNumber(resultSet.getInt(2));
                    project.setDesciption(resultSet.getString(3));
                    project.setUrl(resultSet.getString(4));
                }
            }
            resultSet.close();
            return project;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateProject delCandidateProject(String candidateUsername, int numberOfProject) {
        openConnection();
        try{
            CandidateProject candidateProject = new CandidateProject();
            Statement statement = getConnection().createStatement();
            String query = "DELETE FROM project WHERE candid = '" + candidateUsername + "' AND num = '" + numberOfProject + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return candidateProject;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateAddANewProject candidateAddANewProject() {
        openConnection();
        try{
            CandidateAddANewProject candidateAddANewProject = new CandidateAddANewProject();
            Statement statement = getConnection().createStatement();
            String query = "INSERT INTO project VALUES('" + candidateAddANewProject.getNewCandidateUsername() + "', '" + candidateAddANewProject.getNewNumber() + "', '" + candidateAddANewProject.getNewDescription() + "', '" + candidateAddANewProject.getNewURL() + "')";
            statement.addBatch(query);
            statement.executeBatch();
            return candidateAddANewProject;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateEditAProject candidateEditAProject(String candidateUsername, int numberOfProject) {
        openConnection();
        try{
            CandidateEditAProject candidateEditAProject = new CandidateEditAProject();
            Statement statement = getConnection().createStatement();
            String query = "UPDATE project SET descr = '" + candidateEditAProject.getNewDescription() + "', url = '" + candidateEditAProject.getNewURL() + "' WHERE candid = '" + candidateUsername + "' AND num = '" + numberOfProject + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return candidateEditAProject;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public HasDegree hasDegree(String title, String institution, String candidateUsername){
        openConnection();
        try {
            String query = "SELECT * FROM has_degree WHERE degr_title = '" + title + "' AND degr_idryma = '" + institution + "' AND cand_usrname = '" + candidateUsername + "'";
            ResultSet resultSet;
            HasDegree hasDegree;
            try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                hasDegree = null;
                while(resultSet.next()) {
                    hasDegree = new HasDegree();
                    hasDegree.setTitle(resultSet.getString(1));
                    hasDegree.setInsitution(resultSet.getString(2));
                    hasDegree.setCandidateUsername(resultSet.getString(3));
                    hasDegree.setYear(resultSet.getDate(4));
                    hasDegree.setGrade(resultSet.getDouble(5));
                }
            }
            resultSet.close();
            return hasDegree;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateDegrees delCandidateDegrees(String title, String institution, String candidateUsername) {
        openConnection();
        try{
            CandidateDegrees candidateDegrees = new CandidateDegrees();
            Statement statement = getConnection().createStatement();
            String query = "DELETE FROM has_degree WHERE degr_title = '" + title + "' AND degr_idryma = '" + institution + "' AND cand_usrname = '" + candidateUsername + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return candidateDegrees;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateEditADegree candidateEditADegree(String title, String institution, String candidateUsername) {
        openConnection();
        try{
            CandidateEditADegree candidateEditADegree = new CandidateEditADegree();
            Statement statement = getConnection().createStatement();
            String query = "UPDATE has_degree SET etos = '" + candidateEditADegree.getIntNewYear()+ "', grade = '" + candidateEditADegree.getNewGrade() + "' WHERE degr_title = '" + title + "' AND degr_idryma = '" + institution + "' AND cand_usrname = '" + candidateUsername + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return candidateEditADegree;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateAddANewDegree candidateAddANewDegree(String candidateUsername) {
        openConnection();
        try{
            CandidateAddANewDegree candidateAddANewDegree = new CandidateAddANewDegree();
            Statement statement = getConnection().createStatement();
            String query = "INSERT INTO has_degree VALUES('" + candidateAddANewDegree.getNewTitle() + "', '" + candidateAddANewDegree.getNewInstitution()+ "', '" + candidateUsername + "', '" + candidateAddANewDegree.getNewYear() + "', '" + candidateAddANewDegree.getNewGrade() + "')";
            statement.addBatch(query);
            statement.executeBatch();
            return candidateAddANewDegree;
        } catch (SQLException e) {
            return null;
        }
    }

    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.setConnection((Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/erecruit", "root", ""));
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getCountJob(){
        openConnection();
        int jobID = 0;
        String intToStringCount = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM job ORDER BY id ASC;");
            while(resultSet.next()){
                jobID = resultSet.getInt("id");
            }
            intToStringCount = Integer.toString(jobID);
            return intToStringCount;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return intToStringCount;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getProjectNumber(String candidateUsername){
        openConnection();
        int projectNumber = 0;
        String intToStringProjectNumber = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT num FROM project WHERE candid = '" + candidateUsername + "' ORDER BY num ASC;");
            while(resultSet.next()){
                projectNumber = resultSet.getInt("num");
            }
            intToStringProjectNumber = Integer.toString(projectNumber);
            return intToStringProjectNumber;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return intToStringProjectNumber;
    }
    
    /**
     * @return the DLM
     */
    public DefaultListModel getDLM() {
        return DLM;
    }

    /**
     * @param DLM the DLM to set
     */
    public void setDLM(DefaultListModel DLM) {
        this.DLM = DLM;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the myPlacement
     */
    public int getMyPlacement() {
        return myPlacement;
    }

    /**
     * @param myPlacement the myPlacement to set
     */
    public void setMyPlacement(int myPlacement) {
        this.myPlacement = myPlacement;
    }

    /**
     * @return the allCandidates
     */
    public int getAllCandidates() {
        return allCandidates;
    }

    /**
     * @param allCandidates the allCandidates to set
     */
    public void setAllCandidates(int allCandidates) {
        this.allCandidates = allCandidates;
    }
}
