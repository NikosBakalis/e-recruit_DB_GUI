/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

/**
 *
 * @author Nikolas
 */
public class Recruiter {
    
    private static String username, firm;
    private static int exp_years;

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
        this.username = username;
    }

    /**
     * @return the firm
     */
    public String getFirm() {
        return firm;
    }

    /**
     * @param firm the firm to set
     */
    public void setFirm(String firm) {
        this.firm = firm;
    }

    /**
     * @return the exp_years
     */
    public int getExp_years() {
        return exp_years;
    }

    /**
     * @param exp_years the exp_years to set
     */
    public void setExp_years(int exp_years) {
        this.exp_years = exp_years;
    }
    
    //@Override
    //public String toString() {
    //    return this.username + ", " + this.firm + ", " + this.exp_years;
    //}
    
}
