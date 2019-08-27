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
public class Languages {
    
    private static String candidateUsername, languages;

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
        Languages.candidateUsername = candidateUsername;
    }

    /**
     * @return the languages
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(String languages) {
        Languages.languages = languages;
    }
    
}
