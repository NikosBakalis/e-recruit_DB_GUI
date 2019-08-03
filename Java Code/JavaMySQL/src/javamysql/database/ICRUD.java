/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.database;

import javamysql.model.Applies;
import javamysql.model.Candidate;
import javamysql.model.Job;
import javamysql.model.Recruiter;
import javamysql.model.User;
import javamysql.ui.CandidateApplies;
import javamysql.ui.CandidateUI;
import javamysql.ui.JobMoreInfo;

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
    Applies getApplies(String username, int job_ID);
    Applies delApplies(String username, int job_ID);
    
}
