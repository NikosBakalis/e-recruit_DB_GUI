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
public class Job {
    
    private static String position, country, recruiter, announceDate, submissionDate;
    private static int salary;

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
    public String getAnnounceDate() {
        return announceDate;
    }

    /**
     * @param announceDate the announceDate to set
     */
    public void setAnnounceDate(String announceDate) {
        Job.announceDate = announceDate;
    }

    /**
     * @return the submissionDate
     */
    public String getSubmissionDate() {
        return submissionDate;
    }

    /**
     * @param submissionDate the submissionDate to set
     */
    public void setSubmissionDate(String submissionDate) {
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
    
}
