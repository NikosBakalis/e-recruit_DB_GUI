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
import javamysql.model.Evaluation;
import javamysql.model.HasDegree;
import javamysql.model.Interview;
import javamysql.model.Job;
import javamysql.model.Languages;
import javamysql.model.Project;
import javamysql.model.Recruiter;
import javamysql.model.Sectors;
import javamysql.model.User;
import javamysql.ui.RecruiterAddAJob;
import javamysql.ui.AdminCreateCandidate;
import javamysql.ui.AdminCreateObject;
import javamysql.ui.AdminCreateRecruiter;
import javamysql.ui.AdminCreateSector;
import javamysql.ui.CandidateAddANewDegree;
import javamysql.ui.CandidateAddANewProject;
import javamysql.ui.CandidateDegrees;
import javamysql.ui.CandidateEditADegree;
import javamysql.ui.CandidateEditAProject;
import javamysql.ui.CandidateLanguages;
import javamysql.ui.CandidateProject;
import javamysql.ui.CandidateUI;
import javamysql.ui.RecruiterCompanyUI;
import javamysql.ui.RecruiterEditAJob;
import javamysql.ui.RecruiterInterviewEdit;
import javamysql.ui.RecruiterInterviewStart;
import javamysql.ui.Login;
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
    Job getJob(String position);
    Job getJob(int ID);
    Applies getApplies(String username, int job_ID);
    Applies delApplies(String username, int job_ID);
    Company getCompany(int AFM);
    RecruiterUI getRecruiterUI(String username);
    RecruiterCompanyUI getCompanyUI(int AFM);
    RecruiterAddAJob newJob(int ID, String recruiter);
    Job delJob(int job_ID, String username);
    RecruiterEditAJob editAJob(int ID);
    Object getObject();
    AdminCreateCandidate adminCreateCandidate();
    AdminCreateRecruiter adminCreateRecruiter();
    Interview getInterview(String recruiterUsername, String candidateUsername, int jobID);
    RecruiterInterviewEdit interviewEdit(String recruiterUsername, String candidateUsername, int jobID);
    AveragePersonalityScore getAveragePersonalityScore(String recruiterUsername, String candidateUsername, int jobID);
    RecruiterInterviewStart interviewStart(String recruiterUsername, String candidateUsername, int jobID);
    AdminCreateObject adminCreateObject();
    AdminCreateObject adminCreateObjectNull();
    Sectors getSectors();
    AdminCreateSector adminCreateSector();
    AdminCreateSector adminCreateSectorNull();
    Evaluation evaluation(int jobID);
    Login login(String username);
    Languages getLanguages(String candidateUsername);
    CandidateLanguages newCandidateLanguages(String candidateUsername);
    Project getProject(String candidateUsername, int numberOfProject);
    CandidateProject delCandidateProject(String candidateUsername, int numberOfProject);
    CandidateAddANewProject candidateAddANewProject();
    CandidateEditAProject candidateEditAProject(String candidateUsername, int numberOfProject);
    HasDegree hasDegree(String title, String institution, String candidateUsername);
    CandidateDegrees delCandidateDegrees(String title, String institution, String candidateUsername);
    CandidateEditADegree candidateEditADegree(String title, String institution, String candidateUsername);
    CandidateAddANewDegree candidateAddANewDegree(String candidateUsername);
}
