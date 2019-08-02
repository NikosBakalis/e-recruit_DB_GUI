/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Nikolas
 */
public class Job {
    
    private static String position, country, recruiter;
    private static int id, salary;
    private static Timestamp announceDate;
    private static Date startDate, submissionDate;

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        Job.position = position;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        Job.country = country;
    }

    /**
     * @return the recruiter
     */
    public String getRecruiter() {
        return recruiter;
    }

    /**
     * @param recruiter the recruiter to set
     */
    public void setRecruiter(String recruiter) {
        Job.recruiter = recruiter;
    }

    /**
     * @return the announceDate
     */
    public Timestamp getAnnounceDate() {
        return announceDate;
    }
    
    /**
     * @param announceDate the announceDate to set
     */
    public void setAnnounceDate(Timestamp announceDate) {
        Job.announceDate = announceDate;
    }

    /**
     * @return the submissionDate
     */
    public Date getSubmissionDate() {
        return submissionDate;
    }

    /**
     * @param submissionDate the submissionDate to set
     */
    public void setSubmissionDate(Date submissionDate) {
        Job.submissionDate = submissionDate;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        Job.salary = salary;
    }

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
        Job.id = id;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        Job.startDate = startDate;
    }
    
}
