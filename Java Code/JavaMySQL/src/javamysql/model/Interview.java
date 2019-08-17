/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Nikolas
 */
public class Interview {
    
    private static String recruiterUsername, candidateUsername, comments;
    private static int jobID, educationScore, experienceScore;
    private static Date interviewDate;
    private static Time startingTime, duration;

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
        Interview.recruiterUsername = recruiterUsername;
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
        Interview.candidateUsername = candidateUsername;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        Interview.comments = comments;
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
        Interview.jobID = jobID;
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
        Interview.educationScore = educationScore;
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
        Interview.experienceScore = experienceScore;
    }

    /**
     * @return the interviewDate
     */
    public Date getInterviewDate() {
        return interviewDate;
    }

    /**
     * @param interviewDate the interviewDate to set
     */
    public void setInterviewDate(Date interviewDate) {
        Interview.interviewDate = interviewDate;
    }

    /**
     * @return the startingTime
     */
    public Time getStartingTime() {
        return startingTime;
    }

    /**
     * @param startingTime the startingTime to set
     */
    public void setStartingTime(Time startingTime) {
        Interview.startingTime = startingTime;
    }

    /**
     * @return the duration
     */
    public Time getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Time duration) {
        Interview.duration = duration;
    }
    
}
