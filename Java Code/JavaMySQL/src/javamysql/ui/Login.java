/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import javamysql.helper.Controller;
import javamysql.model.Candidate;
import javamysql.model.Recruiter;
import javamysql.model.User;

/**
 *
 * @author Nikolas
 */
public class Login extends javax.swing.JFrame {
    
    private final Controller controller;    

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = Controller.getController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log-In Form");
        setPreferredSize(new java.awt.Dimension(835, 409));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 170, 80, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 210, 80, 16);
        getContentPane().add(username);
        username.setBounds(390, 170, 170, 20);
        getContentPane().add(password);
        password.setBounds(390, 210, 170, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Log-In Form");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 30, 170, 59);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(390, 250, 70, 23);

        login.setText("Log-In");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(490, 250, 70, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nikolas\\Documents\\NetBeansProjects\\JavaMySQL\\images\\1.jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 830, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        User user = this.controller.login(this.username.getText(), this.password.getText());
        Recruiter recruiter = this.controller.recruiterLogin(this.username.getText());
        Candidate candidate = this.controller.candidateLogin(this.username.getText());
        
        if(candidate != null && user != null) {
            System.out.println("You have Loged-In successfully!");
            System.out.println("You are a Candidate!");
            CandidateUI candidateUI = new CandidateUI();
            candidateUI.setVisible(true);
            this.dispose();
        }

        else if(recruiter != null && user != null) {
            System.out.println("You have Loged-In successfully!");
            System.out.println("You are a Recruiter!");
        }
        
        else if(user != null) {
            System.out.println("You have Loged-In successfully!");
            System.out.println("You are the Admin!!!");
        } else {
            System.err.println("Authentication Denied!");
        }

    }//GEN-LAST:event_loginActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        this.username.setText(null);
        this.password.setText(null);
    }//GEN-LAST:event_clearActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
