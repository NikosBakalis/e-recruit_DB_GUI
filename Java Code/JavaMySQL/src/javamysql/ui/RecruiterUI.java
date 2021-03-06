/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import java.awt.Component;
import javamysql.database.ICRUDImpl;
import javamysql.model.Company;
import javamysql.model.Recruiter;
import javamysql.model.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikolas
 */
public class RecruiterUI extends javax.swing.JFrame {
    
    protected int counter = 0;
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Recruiter recruiter = new Recruiter();
    User user = new User();
    Company company = new Company();
    
    private static String newUsername, newPassword, newName, newSurname, newEmail, newExperienceYears;
    protected String intToStringExperienceYears = Integer.toString(recruiter.getExp_years());

    /**
     * Creates new form RecruiterUI
     */
    public RecruiterUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        WelcomeName = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        changeUsername = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        changeName = new javax.swing.JTextField();
        changeSurname = new javax.swing.JTextField();
        Surname = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        changeEmail = new javax.swing.JTextField();
        changePassword = new javax.swing.JPasswordField();
        ExperienceYears = new javax.swing.JLabel();
        changeExperienceYears = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        changeCompany = new javax.swing.JTextField();
        ButtonMyCompany = new javax.swing.JButton();
        ButtonEditAndSave = new javax.swing.JButton();
        ButtonLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        WelcomeName.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        WelcomeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeName.setText("Welcome " + user.getName());

        Username.setText("Username");

        changeUsername.setEditable(false);
        changeUsername.setText(recruiter.getUsername());

        Password.setText("Password");

        Name.setText("Name");

        changeName.setEditable(false);
        changeName.setText(user.getName());

        changeSurname.setEditable(false);
        changeSurname.setText(user.getSurname());

        Surname.setText("Surname");

        Email.setText("Email");

        changeEmail.setEditable(false);
        changeEmail.setText(user.getEmail());

        changePassword.setEditable(false);
        changePassword.setText(user.getPassword());

        ExperienceYears.setText("Experience Years");

        changeExperienceYears.setEditable(false);
        changeExperienceYears.setText(intToStringExperienceYears);

        jLabel1.setText("Company");

        changeCompany.setEditable(false);
        changeCompany.setText(iCRUDImpl.getCompany(recruiter.getFirm()).getName());

        ButtonMyCompany.setText("My Company");
        ButtonMyCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMyCompanyActionPerformed(evt);
            }
        });

        ButtonEditAndSave.setText("Edit");
        ButtonEditAndSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditAndSaveActionPerformed(evt);
            }
        });

        ButtonLogout.setText("Log-out");
        ButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changeSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changeName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ExperienceYears, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(changeExperienceYears)
                                    .addComponent(changeCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(ButtonMyCompany)
                                .addGap(59, 59, 59)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(WelcomeName, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)))
                .addComponent(ButtonLogout)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonEditAndSave, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WelcomeName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonLogout))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExperienceYears, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeExperienceYears, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(ButtonMyCompany))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(ButtonEditAndSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonLogoutActionPerformed

    private void ButtonEditAndSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditAndSaveActionPerformed
        counter++;
        if(counter%2 == 1){
            changePassword.setEditable(true);
            changeName.setEditable(true);
            changeSurname.setEditable(true);
            changeEmail.setEditable(true);
            changeExperienceYears.setEditable(true);
            ButtonEditAndSave.setText("Save");
        } else {
            changePassword.setEditable(false);
            changeName.setEditable(false);
            changeSurname.setEditable(false);
            changeEmail.setEditable(false);
            changeExperienceYears.setEditable(false);
            ButtonEditAndSave.setText("Edit");
            setNewUsername(changeUsername.getText());
            newPassword = changePassword.getText();
            newName = changeName.getText();
            newSurname = changeSurname.getText();
            newEmail = changeEmail.getText();
            newExperienceYears = changeExperienceYears.getText();
            iCRUDImpl.getRecruiterUI(getChangeUsername().getText());
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Logout and Login again to see the changes");
        }
    }//GEN-LAST:event_ButtonEditAndSaveActionPerformed

    private void ButtonMyCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMyCompanyActionPerformed
        RecruiterCompanyUI companyUI = new RecruiterCompanyUI();
        companyUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonMyCompanyActionPerformed

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecruiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecruiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecruiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecruiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecruiterUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEditAndSave;
    private javax.swing.JButton ButtonLogout;
    private javax.swing.JButton ButtonMyCompany;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel ExperienceYears;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Surname;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel WelcomeName;
    private javax.swing.JTextField changeCompany;
    private javax.swing.JTextField changeEmail;
    private javax.swing.JTextField changeExperienceYears;
    private javax.swing.JTextField changeName;
    private javax.swing.JPasswordField changePassword;
    private javax.swing.JTextField changeSurname;
    private javax.swing.JTextField changeUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the newUsername
     */
    public String getNewUsername() {
        return newUsername;
    }

    /**
     * @param newUsername the newUsername to set
     */
    public void setNewUsername(String newUsername) {
        RecruiterUI.newUsername = newUsername;
    }
    
    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        RecruiterUI.newPassword = newPassword;
    }

    /**
     * @return the newName
     */
    public String getNewName() {
        return newName;
    }

    /**
     * @param newName the newName to set
     */
    public void setNewName(String newName) {
        RecruiterUI.newName = newName;
    }

    /**
     * @return the newSurname
     */
    public String getNewSurname() {
        return newSurname;
    }

    /**
     * @param newSurname the newSurname to set
     */
    public void setNewSurname(String newSurname) {
        RecruiterUI.newSurname = newSurname;
    }

    /**
     * @return the newEmail
     */
    public String getNewEmail() {
        return newEmail;
    }

    /**
     * @param newEmail the newEmail to set
     */
    public void setNewEmail(String newEmail) {
        RecruiterUI.newEmail = newEmail;
    }

    /**
     * @return the newExperienceYears
     */
    public String getNewExperienceYears() {
        return newExperienceYears;
    }

    /**
     * @param newExperienceYears the newExperienceYears to set
     */
    public void setNewExperienceYears(String newExperienceYears) {
        RecruiterUI.newExperienceYears = newExperienceYears;
    }

    /**
     * @return the changeUsername
     */
    public javax.swing.JTextField getChangeUsername() {
        return changeUsername;
    }

    /**
     * @param changeUsername the changeUsername to set
     */
    public void setChangeUsername(javax.swing.JTextField changeUsername) {
        this.changeUsername = changeUsername;
    }

}
