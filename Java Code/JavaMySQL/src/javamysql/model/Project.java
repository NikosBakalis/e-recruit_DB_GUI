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
public class Project {
    
    private static String candidateUsername, desciption, url;
    private static int number;

    /**
     * @return the candidateUsername
     */
    public String getCandidateUsername() {
        return candidateUsername;
    }

    /**
     * @param candidateUsername the candidateUsername to set
     */
    public void setCandidateUsername(String candidateUsername) {
        Project.candidateUsername = candidateUsername;
    }

    /**
     * @return the desciption
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * @param desciption the desciption to set
     */
    public void setDesciption(String desciption) {
        Project.desciption = desciption;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        Project.url = url;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        Project.number = number;
    }
    
}
