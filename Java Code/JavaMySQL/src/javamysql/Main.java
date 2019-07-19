/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql;

import javamysql.ui.Login;

/**
 *
 * @author Nikolas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        // Login recruiterLogin = new Login();
        // Login candidateLogin = new Login();
        login.setVisible(true);
        // recruiterLogin.setVisible(true);
        // candidateLogin.setVisible(true);
    }
    
}
