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
import javamysql.model.Candidate;
import javamysql.model.Recruiter;
import javamysql.model.User;

/**
 *
 * @author Nikolas
 */
public class ICRUDImpl implements ICRUD {

    private Connection connection;

    @Override
    public User getUser(String userName, String password) {
        try {
            String query = "SELECT * FROM user WHERE user.username = '" + userName + "' AND password = '" + password + "'";
            
            ResultSet resultSet;
            User user;
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                user = null;
                if(resultSet.next()) {
                    user = new User();
                    user.setUserName(resultSet.getString("username"));
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
    public Recruiter getRecruiter(String userName) {
        try {
            String query = "SELECT * FROM recruiter WHERE recruiter.username = '" + userName + "'";
            
            ResultSet resultSet;
            Recruiter recruiter;
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                recruiter = null;
                if(resultSet.next()) {
                    recruiter = new Recruiter();
                    recruiter.setUserName(resultSet.getString("username"));
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
    public Candidate getCandidate(String userName) {
        try {
            String query = "SELECT * FROM candidate WHERE candidate.username = '" + userName + "'";
            
            ResultSet resultSet;
            Candidate candidate;
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
                resultSet = preparedStatement.executeQuery();
                candidate = null;
                if(resultSet.next()) {
                    candidate = new Candidate();
                    candidate.setUserName(resultSet.getString("username"));
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

    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/erecruit", "root", "");
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Recruiter getRecruiter(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Candidate getCandidate(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
