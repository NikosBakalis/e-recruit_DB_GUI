/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.database;

import javamysql.model.Applies;
import javamysql.model.AveragePersonalityScore;
import javamysql.model.Candidate;
import javamysql.model.Company;
import javamysql.model.Interview;
import javamysql.model.Job;
import javamysql.model.Recruiter;
import javamysql.model.Sectors;
import javamysql.model.User;
import javamysql.ui.AddAJob;
import javamysql.ui.AdminCreateCandidate;
import javamysql.ui.AdminCreateObject;
import javamysql.ui.AdminCreateRecruiter;
import javamysql.ui.AdminCreateSector;
import javamysql.ui.CandidateApplies;
import javamysql.ui.CandidateUI;
import javamysql.ui.CompanyUI;
import javamysql.ui.EditAJob;
import javamysql.ui.InterviewEdit;
import javamysql.ui.InterviewStart;
import javamysql.ui.RecruiterUI;

/**
 *
 * @author Nikolas
 */
public interface ICRUD {
    
    User getUser(String username, String password);
    Recruiter getRecruiter(String username);
    Candidate getCandidate(String username);
    CandidateUI getCandidateUI(String username);
    CandidateApplies getCandidateOpenApplies(String username);
    CandidateApplies getCandidateApplies(String username);
    Job getJob(String position);
    Job getJob(int ID);
    Applies getApplies(String username, int job_ID);
    Applies delApplies(String username, int job_ID);
    Company getCompany(int AFM);
    RecruiterUI getRecruiterUI(String username);
    CompanyUI getCompanyUI(int AFM);
    /* RecruiterNewPosition getNewJob(int id, String recruiter); */
    AddAJob newJob(int ID, String recruiter);
    Job delJob(int job_ID, String username);
    EditAJob editAJob(int ID);
    Object getObject();
    AdminCreateCandidate adminCreateCandidate();
    AdminCreateRecruiter adminCreateRecruiter();
    Interview getInterview(String recruiterUsername, String candidateUsername, int jobID);
    InterviewEdit interviewEdit(String recruiterUsername, String candidateUsername, int jobID);
    AveragePersonalityScore getAveragePersonalityScore(String recruiterUsername, String candidateUsername, int jobID);
    InterviewStart interviewStart(String recruiterUsername, String candidateUsername, int jobID);
    AdminCreateObject adminCreateObject();
    AdminCreateObject adminCreateObjectNull();
    Sectors getSectors();
    AdminCreateSector adminCreateSector();
    AdminCreateSector adminCreateSectorNull();
}
