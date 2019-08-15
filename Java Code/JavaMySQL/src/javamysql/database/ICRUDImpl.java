/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javamysql.model.Applies;
import javamysql.model.Candidate;
import javamysql.model.Company;
import javamysql.model.Job;
import javamysql.model.Object;
import javamysql.model.Recruiter;
import javamysql.model.User;
import javamysql.ui.AddAJob;
import javamysql.ui.AdminCreateCandidate;
import javamysql.ui.AdminCreateRecruiter;
import javamysql.ui.CandidateApplies;
import javamysql.ui.CandidateUI;
import javamysql.ui.CompanyUI;
import javamysql.ui.EditAJob;
import javamysql.ui.RecruiterUI;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nikolas
 */
public class ICRUDImpl implements ICRUD {

    private Connection connection;
    private DefaultListModel DLM;
    
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
        try{
            CandidateUI candidateUI = new CandidateUI();
            Statement statement = getConnection().createStatement();
            String query1 = "UPDATE user SET password = '" + candidateUI.getNewPassword() + "', name = '" + candidateUI.getNewName() + "', surname = '" + candidateUI.getNewSurname() + "', email = '" + candidateUI.getNewEmail() + "' WHERE username = '" + username + "'";
            String query2 = "UPDATE candidate SET bio = '" + candidateUI.getNewBio() + "' WHERE username = '" + username + "'";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return candidateUI;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateApplies getCandidateOpenApplies(String username) {
        openConnection();
        setDLM(new DefaultListModel());
        try{
            CandidateApplies candidateApplies = new CandidateApplies();
            Statement statement = getConnection().createStatement();
            String query = "SELECT DISTINCT position FROM job INNER JOIN applies ON job.id = applies.job_id WHERE cand_usrname != '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                String position = resultSet.getString("position");
                getDLM().addElement(position);
            }
            System.out.println(getDLM());
            return candidateApplies;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CandidateApplies getCandidateApplies(String username) {
        openConnection();
        setDLM(new DefaultListModel());
        try{
            CandidateApplies candidateApplies = new CandidateApplies();
            Statement statement = getConnection().createStatement();
            String query = "SELECT DISTINCT position FROM job INNER JOIN applies ON job.id = applies.job_id WHERE cand_usrname = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                String position = resultSet.getString("position");
                getDLM().addElement(position);
            }
            System.out.println(getDLM());
            return candidateApplies;
        } catch (SQLException e) {
            return null;
        }
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
        try{
            RecruiterUI recruiterUI = new RecruiterUI();
            Statement statement = getConnection().createStatement();
            String query1 = "UPDATE user SET password = '" + recruiterUI.getNewPassword() + "', name = '" + recruiterUI.getNewName() + "', surname = '" + recruiterUI.getNewSurname() + "', email = '" + recruiterUI.getNewEmail() + "' WHERE username = '" + username + "'";
            String query2 = "UPDATE recruiter SET exp_years = '" + recruiterUI.getNewExperienceYears()+ "' WHERE username = '" + username + "'";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return recruiterUI;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public CompanyUI getCompanyUI(int AFM) {
        openConnection();
        try{
            CompanyUI companyUI = new CompanyUI();
            Statement statement = getConnection().createStatement();
            String query = "UPDATE etaireia SET tel = " + companyUI.getNewTelephone() + ", street = '" + companyUI.getNewStreet()+ "', num = " + companyUI.getNewNumber() + ", city = '" + companyUI.getNewCity()+ "', country = '" + companyUI.getNewCountry() + "' WHERE AFM = " + AFM + "";
            statement.addBatch(query);
            statement.executeBatch();
            return companyUI;
        } catch (SQLException e) {
            return null;
        }
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
    public AddAJob newJob(int ID, String recruiter){
        openConnection();
        try{
            AddAJob addAJob = new AddAJob();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO job VALUES ('" + ID + "', '" + addAJob.getNewStartDate() + "', '" + addAJob.getNewSalary() + "', '" + addAJob.getNewPosition() + "', '" + addAJob.getNewSeat() + "', '" + recruiter + "', '" + addAJob.getNewAnnounceDate() + "', '" + addAJob.getNewSubmissionDate() + "')";
            String query2 = "INSERT INTO requires VALUES ('" + ID + "', '" + addAJob.getNewRequires() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return addAJob;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public Job delJob(int job_ID, String username){
        openConnection();
        try{
            Job job = new Job();
            Statement statement = getConnection().createStatement();
            String query = "DELETE FROM job WHERE recruiter = '" + username + "' AND id =  " + job_ID + "";
            statement.addBatch(query);
            statement.executeBatch();
            return job;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public EditAJob editAJob(int ID){
        openConnection();
        try{
            EditAJob editAJob = new EditAJob();
            Statement statement = getConnection().createStatement();
            String query = "UPDATE job SET start_date = '" + editAJob.getNewStartDate() + "', salary = '" + editAJob.getNewSalary() + "', position = '" + editAJob.getNewPosition() + "', edra = '" + editAJob.getNewSeat() + "', submission_date = '" + editAJob.getNewSubmissionDate() + "' WHERE id = '" + ID + "'";
            statement.addBatch(query);
            statement.executeBatch();
            return editAJob;
        } catch (SQLException e) {
            return null;
        }
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
        try{
            AdminCreateCandidate adminCreateCandidate = new AdminCreateCandidate();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO user VALUES ('" + adminCreateCandidate.getNewUsername() + "', '" + adminCreateCandidate.getNewPassword() + "', '" + adminCreateCandidate.getNewName() + "', '" + adminCreateCandidate.getNewSurname() + "', '" + adminCreateCandidate.getNewRegisterDate() + "', '" + adminCreateCandidate.getNewEmail() + "')";
            String query2 = "INSERT INTO candidate VALUES ('" + adminCreateCandidate.getNewUsername() + "', '" + adminCreateCandidate.getNewBio() + "', '" + adminCreateCandidate.getNewRecommendation() + "', '" + adminCreateCandidate.getNewCertificates() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return adminCreateCandidate;
        } catch (SQLException e) {
            return null;
        }
    }
    
    @Override
    public AdminCreateRecruiter adminCreateRecruiter(){
        openConnection();
        try{
            AdminCreateRecruiter adminCreateRecruiter = new AdminCreateRecruiter();
            Statement statement = getConnection().createStatement();
            String query1 = "INSERT INTO user VALUES ('" + adminCreateRecruiter.getNewUsername() + "', '" + adminCreateRecruiter.getNewPassword() + "', '" + adminCreateRecruiter.getNewName() + "', '" + adminCreateRecruiter.getNewSurname() + "', '" + adminCreateRecruiter.getNewRegisterDate() + "', '" + adminCreateRecruiter.getNewEmail() + "')";
            String query2 = "INSERT INTO recruiter VALUES ('" + adminCreateRecruiter.getNewUsername() + "', '" + adminCreateRecruiter.getNewExperienceYears() + "', '" + adminCreateRecruiter.getNewFirm() + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            return adminCreateRecruiter;
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
    
    public String getCountJob(){
        openConnection();
        int count = 0;
        String intToStringCount = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM job");
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
            intToStringCount = Integer.toString(count);
            return intToStringCount;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return intToStringCount;
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

}
