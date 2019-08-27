/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamysql.database.ICRUDImpl;

/**
 *
 * @author Nikolas
 */
public class AdminCreateRecruiter extends javax.swing.JFrame {
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    
    private static String newUsername, newPassword, newName, newSurname, newEmail;
    private static int newExperienceYears, newFirm;
    private static Date newRegisterDate;
    private static Time newRegisterTime;
    private static String newRegisterDateTime;
    
    SimpleDateFormat dateFormatTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    long newRegisterTimeTest;

    /**
     * Creates new form AdminCreateRecruiter
     */
    public AdminCreateRecruiter() {
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
        LabelWelcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        changeUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        changePassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        changeName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        changeSurname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        changeRegisterDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        changeEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        changeExperienceYears = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        changeFirm = new javax.swing.JTextField();
        ButtonCreate = new javax.swing.JButton();
        ButtonDismiss = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        LabelWelcome.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelWelcome.setText("Create New Recruiter");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Name");

        jLabel4.setText("Surname");

        jLabel5.setText("Register Date");

        jLabel6.setText("e-mail");

        jLabel7.setText("Experience Years");

        jLabel8.setText("Firm");

        ButtonCreate.setText("Create");
        ButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateActionPerformed(evt);
            }
        });

        ButtonDismiss.setText("Dismiss");
        ButtonDismiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDismissActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Format: yyyy-MM-dd HH:mm:ss");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(LabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(ButtonCreate)
                                .addGap(197, 197, 197)
                                .addComponent(ButtonDismiss)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changeName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changeSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changeRegisterDate))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeExperienceYears, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeFirm)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changeUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changeName)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(changeSurname))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeRegisterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeExperienceYears, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeFirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCreate)
                    .addComponent(ButtonDismiss))
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

    private void ButtonDismissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDismissActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonDismissActionPerformed

    private void ButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateActionPerformed
        setNewUsername(changeUsername.getText());
        setNewPassword(changePassword.getText());
        setNewName(changeName.getText());
        setNewSurname(changeSurname.getText());
        try {
            newRegisterDate = dateFormatTimestamp.parse(changeRegisterDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AdminCreateRecruiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlNewRegisterDate = new java.sql.Date(newRegisterDate.getTime());
        setNewRegisterDate(sqlNewRegisterDate);
        try {
            newRegisterTimeTest = dateFormatTimestamp.parse(changeRegisterDate.getText()).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(AdminCreateRecruiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        setNewRegisterTime(new Time(newRegisterTimeTest));
        setNewRegisterDateTime(getNewRegisterDate() + " " + getNewRegisterTime());
        setNewEmail(changeEmail.getText());
        int stringToIntExperienceYears = Integer.parseInt(changeExperienceYears.getText());
        setNewExperienceYears(stringToIntExperienceYears);
        int stringToIntFirm = Integer.parseInt(changeFirm.getText());
        setNewFirm(stringToIntFirm);
        iCRUDImpl.adminCreateRecruiter();
        this.dispose();
    }//GEN-LAST:event_ButtonCreateActionPerformed

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
            java.util.logging.Logger.getLogger(AdminCreateRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminCreateRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminCreateRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminCreateRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminCreateRecruiter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCreate;
    private javax.swing.JButton ButtonDismiss;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JTextField changeEmail;
    private javax.swing.JTextField changeExperienceYears;
    private javax.swing.JTextField changeFirm;
    private javax.swing.JTextField changeName;
    private javax.swing.JPasswordField changePassword;
    private javax.swing.JTextField changeRegisterDate;
    private javax.swing.JTextField changeSurname;
    private javax.swing.JTextField changeUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
        AdminCreateRecruiter.newUsername = newUsername;
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
        AdminCreateRecruiter.newPassword = newPassword;
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
        AdminCreateRecruiter.newName = newName;
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
        AdminCreateRecruiter.newSurname = newSurname;
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
        AdminCreateRecruiter.newEmail = newEmail;
    }

    /**
     * @return the newExperienceYears
     */
    public int getNewExperienceYears() {
        return newExperienceYears;
    }

    /**
     * @param newExperienceYears the newExperienceYears to set
     */
    public void setNewExperienceYears(int newExperienceYears) {
        AdminCreateRecruiter.newExperienceYears = newExperienceYears;
    }

    /**
     * @return the newFirm
     */
    public int getNewFirm() {
        return newFirm;
    }

    /**
     * @param newFirm the newFirm to set
     */
    public void setNewFirm(int newFirm) {
        AdminCreateRecruiter.newFirm = newFirm;
    }

    /**
     * @return the newRegisterDate
     */
    public Date getNewRegisterDate() {
        return newRegisterDate;
    }

    /**
     * @param newRegisterDate the newRegisterDate to set
     */
    public void setNewRegisterDate(Date newRegisterDate) {
        AdminCreateRecruiter.newRegisterDate = newRegisterDate;
    }
    
    /**
     * @return the newRegisterTime
     */
    public Time getNewRegisterTime() {
        return newRegisterTime;
    }

    /**
     * @param newRegisterTime the newRegisterTime to set
     */
    public void setNewRegisterTime(Time newRegisterTime) {
        AdminCreateRecruiter.newRegisterTime = newRegisterTime;
    }
    
    /**
     * @return the newRegisterDateTime
     */
    public String getNewRegisterDateTime() {
        return newRegisterDateTime;
    }

    /**
     * @param newRegisterDateTime the newDateTime to set
     */
    public void setNewRegisterDateTime(String newRegisterDateTime) {
        AdminCreateRecruiter.newRegisterDateTime = newRegisterDateTime;
    }
}
