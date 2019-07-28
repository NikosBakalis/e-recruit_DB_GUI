/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.database;

import javamysql.model.Candidate;
import javamysql.model.Recruiter;
import javamysql.model.User;
import javamysql.ui.CandidateUI;

/**
 *
 * @author Nikolas
 */
public interface ICRUD {
    
    User getUser(String username, String password);
    Recruiter getRecruiter(String username);
    Candidate getCandidate(String username);
    CandidateUI getCandidateUI(String username);
    
}
