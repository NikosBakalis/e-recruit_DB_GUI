/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

import java.sql.Date;

/**
 *
 * @author Nikolas
 */
public class HasDegree {
    
    private static String title, insitution, candidateUsername;
    private static Date year;
    private static double grade;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        HasDegree.title = title;
    }

    /**
     * @return the insitution
     */
    public String getInsitution() {
        return insitution;
    }

    /**
     * @param insitution the insitution to set
     */
    public void setInsitution(String insitution) {
        HasDegree.insitution = insitution;
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
        HasDegree.candidateUsername = candidateUsername;
    }

    /**
     * @return the year
     */
    public Date getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Date year) {
        HasDegree.year = year;
    }

    /**
     * @return the grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        HasDegree.grade = grade;
    }
    
}
