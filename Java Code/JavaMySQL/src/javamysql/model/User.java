/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

import java.sql.Timestamp;

/**
 *
 * @author Nikolas
 */
public class User {
    
    private static String username, password, name, surname, email;
    private static Timestamp reg_date;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        User.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        User.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        User.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        User.surname = surname;
    }

    /**
     * @return the reg_date
     */
    public Timestamp getReg_date() {
        return reg_date;
    }

    /**
     * @param reg_date the reg_date to set
     */
    public void setReg_date(Timestamp reg_date) {
        User.reg_date = reg_date;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        User.email = email;
    }
    
    //@Override
    //public String toString() {
    //    return this.username + ", " + this.name + ", " + this.surname + ", " + this.reg_date + ", " + this.email;
    //}
}
