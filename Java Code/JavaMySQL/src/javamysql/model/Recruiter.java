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
    
    private String userName, firm;
    private int exp_years;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
    
    @Override
    public String toString() {
        return this.userName + ", " + this.firm + ", " + this.exp_years;
    }
    
}
