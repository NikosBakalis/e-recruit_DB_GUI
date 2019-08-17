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
public class AveragePersonalityScore {
    
    private static int id, jobID, personalityScore;
    private static String recruiterUsername, candidateUsername;
    private static double averagePersonalityScore;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        AveragePersonalityScore.id = id;
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
        AveragePersonalityScore.jobID = jobID;
    }
    
    /**
     * @return the personalityScore
     */
    public int getPersonalityScore() {
        return personalityScore;
    }

    /**
     * @param personalityScore the personalityScore to set
     */
    public void setPersonalityScore(int personalityScore) {
        AveragePersonalityScore.personalityScore = personalityScore;
    }

    /**
     * @return the recruiterUsername
     */
    public String getRecruiterUsername() {
        return recruiterUsername;
    }

    /**
     * @param recruiterUsername the recruiterUsername to set
     */
    public void setRecruiterUsername(String recruiterUsername) {
        AveragePersonalityScore.recruiterUsername = recruiterUsername;
    }

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
        AveragePersonalityScore.candidateUsername = candidateUsername;
    }
    
        /**
     * @return the averagePersonalityScore
     */
    public double getAveragePersonalityScore() {
        return averagePersonalityScore;
    }

    /**
     * @param averagePersonalityScore the averagePersonalityScore to set
     */
    public void setAveragePersonalityScore(double averagePersonalityScore) {
        AveragePersonalityScore.averagePersonalityScore = averagePersonalityScore;
    }
    
}
