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
public class Candidate {
    
    private static String username, bio, sistatikes, certificates;
    
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
        Candidate.username = username;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        Candidate.bio = bio;
    }

    /**
     * @return the sistatikes
     */
    public String getSistatikes() {
        return sistatikes;
    }

    /**
     * @param sistatikes the sistatikes to set
     */
    public void setSistatikes(String sistatikes) {
        Candidate.sistatikes = sistatikes;
    }

    /**
     * @return the certificates
     */
    public String getCertificates() {
        return certificates;
    }

    /**
     * @param certificates the certificates to set
     */
    public void setCertificates(String certificates) {
        Candidate.certificates = certificates;
    }
    
    @Override
    public String toString() {
        return Candidate.username + ", " + Candidate.bio + ", " + Candidate.sistatikes + ", " + Candidate.certificates;
    }
    
}
