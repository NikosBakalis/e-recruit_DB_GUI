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
import javamysql.model.User;

/**
 *
 * @author Nikolas
 */
public class ICRUDImpl implements ICRUD {

    private Connection connection;

    /*
    @Override
    public boolean insert(User user) {
        try {
            String query = "INSERT INTO `user` VALUES ('" + user.getUserName() + "','" + user.getPassword() + "','" + user.getName() + "','" + user.getSurname() + "','" + user.getReg_date() + "','" + user.getEmail() + "')";
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    */

    @Override
    public User getUser(String userName, String password) {
        try {
            String query = "SELECT * FROM user where username = '" + userName + "' AND password = '" + password + "'";
            
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            User user = null;
            
            if(resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setReg_date(resultSet.getTimestamp("reg_date"));
                user.setEmail(resultSet.getString("email"));
            }
            // System.out.println("TEST");
            preparedStatement.close();
            resultSet.close();
            return user;
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
}
