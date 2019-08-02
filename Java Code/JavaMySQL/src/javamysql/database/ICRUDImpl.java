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
import javamysql.model.Candidate;
import javamysql.model.Job;
import javamysql.model.Recruiter;
import javamysql.model.User;
import javamysql.ui.CandidateApplies;
import javamysql.ui.CandidateUI;
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
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
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
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                recruiter = null;
                if(resultSet.next()) {
                    recruiter = new Recruiter();
                    recruiter.setUsername(resultSet.getString("username"));
                    recruiter.setExp_years(resultSet.getInt("exp_years"));
                    recruiter.setFirm(resultSet.getString("firm"));
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
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
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
            Statement statement = connection.createStatement();
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
            Statement statement = connection.createStatement();
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
            Statement statement = connection.createStatement();
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
            System.out.println(position);
            // String query = "SELECT * FROM job WHERE position = 'data analyst'";
            
            ResultSet resultSet;
            Job job;
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                job = null;
                if(resultSet.next()) {
                    job = new Job();
                    job.setSalary(resultSet.getInt("salary"));
                    job.setPosition(resultSet.getString("position"));
                    job.setCountry(resultSet.getString("edra"));
                    job.setRecruiter(resultSet.getString("recruiter"));
                    job.setAnnounceDate(resultSet.getString("announce_date"));
                    job.setSubmissionDate(resultSet.getString("submission_date"));
                }
            }
            resultSet.close();
            return job;
        } catch (SQLException e) {
            return null;
        }
    }

    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/erecruit", "root", "");
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
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

}
