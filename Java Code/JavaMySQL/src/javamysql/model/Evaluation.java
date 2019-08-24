/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

/**
 *
 * @author Nikos
 */
public class Evaluation {
    
    private static String message, candidateUsername, denyUsername, explanation;
    private static int finalScore, personalityScore, educationScore, experienceScore, numberOfInterviews;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        Evaluation.message = message;
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
        Evaluation.candidateUsername = candidateUsername;
    }

    /**
     * @return the denyUsername
     */
    public String getDenyUsername() {
        return denyUsername;
    }

    /**
     * @param denyUsername the denyUsername to set
     */
    public void setDenyUsername(String denyUsername) {
        Evaluation.denyUsername = denyUsername;
    }

    /**
     * @return the explanation
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * @param explanation the explanation to set
     */
    public void setExplanation(String explanation) {
        Evaluation.explanation = explanation;
    }

    /**
     * @return the finalScore
     */
    public int getFinalScore() {
        return finalScore;
    }

    /**
     * @param finalScore the finalScore to set
     */
    public void setFinalScore(int finalScore) {
        Evaluation.finalScore = finalScore;
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
        Evaluation.personalityScore = personalityScore;
    }

    /**
     * @return the educationScore
     */
    public int getEducationScore() {
        return educationScore;
    }

    /**
     * @param educationScore the educationScore to set
     */
    public void setEducationScore(int educationScore) {
        Evaluation.educationScore = educationScore;
    }

    /**
     * @return the experienceScore
     */
    public int getExperienceScore() {
        return experienceScore;
    }

    /**
     * @param experienceScore the experienceScore to set
     */
    public void setExperienceScore(int experienceScore) {
        Evaluation.experienceScore = experienceScore;
    }
    
    /**
     * @return the numberOfInterviews
     */
    public int getNumberOfInterviews() {
        return numberOfInterviews;
    }

    /**
     * @param numberOfInterviews the numberOfInterviews to set
     */
    public void setNumberOfInterviews(int numberOfInterviews) {
        Evaluation.numberOfInterviews = numberOfInterviews;
    }
    
}
