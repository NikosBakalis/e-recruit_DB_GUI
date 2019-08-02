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
public class Applies {

    private static String candidateUsername;
    private static int jobID;

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
        Applies.candidateUsername = candidateUsername;
    }

    /**
     * @return the jobID
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * @param jobID the jobID to set
     */
    public void setJobID(int jobID) {
        Applies.jobID = jobID;
    }
}
