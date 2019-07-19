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
    
    private String userName, bio, sistatikes, certificates;

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
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
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
        this.sistatikes = sistatikes;
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
        this.certificates = certificates;
    }
    
    @Override
    public String toString() {
        return this.userName + ", " + this.bio + ", " + this.sistatikes + ", " + this.certificates;
    }
    
}
