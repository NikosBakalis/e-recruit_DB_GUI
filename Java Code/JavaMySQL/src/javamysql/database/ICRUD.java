/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.database;

import javamysql.model.Candidate;
import javamysql.model.Recruiter;
import javamysql.model.User;

/**
 *
 * @author Nikolas
 */
public interface ICRUD {
    
    User getUser(String userName, String password);
    Recruiter getRecruiter(String userName);
    Candidate getCandidate(String userName);
    
}
