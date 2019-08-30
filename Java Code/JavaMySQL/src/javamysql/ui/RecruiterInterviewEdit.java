/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javamysql.ui;

import java.awt.Component;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamysql.database.ICRUDImpl;
import javamysql.model.AveragePersonalityScore;
import javamysql.model.Interview;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikolas
 */
public class RecruiterInterviewEdit extends javax.swing.JFrame {
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Interview interview = new Interview();
    RecruiterInterviewUI interviewUI = new RecruiterInterviewUI();
    AveragePersonalityScore averagePersonalityScore = new AveragePersonalityScore();
    
    private static String newRecruiterUsername, newCandidateUsername, newComments;
    private static int newJobID, newEducationScore, newExperienceScore;
    private static double newPersonalityScore;
    private static java.util.Date newInterviewDate;
    private static Time newStartingTime, newDuration;
    
    long newStartingTimeTest, newDurationTest;
    
    protected int stringToIntJobID, stringToIntEducationScore, stringToIntExperienceScore;
    protected double stringToDoublePersonalityScore;
    protected Date stringToDateInterviewDate;
    
    
    SimpleDateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss");
    
    protected String intToStringJobID = Integer.toString(interview.getJobID());
    protected String dateToStringInterviewDate = dateFormatDate.format(interview.getInterviewDate());
    protected String timeToStringStartingTime = dateFormatTime.format(interview.getStartingTime());
    protected String timeToStringDuration = dateFormatTime.format(interview.getDuration());
    protected String doubleToStringPersonalityScore = Double.toString(averagePersonalityScore.getAveragePersonalityScore());
    protected String intToStringEducationScore = Integer.toString(interview.getEducationScore());
    protected String intToStringExperienceScore = Integer.toString(interview.getExperienceScore());
    
    private int AvgPersonalityScore;

    /** Creates new form InterviewEdit */
    public RecruiterInterviewEdit() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        changeRecruiterUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        changeCandidateUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        changeJobID = new javax.swing.JTextField();
        changeInterviewDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        changeStartingTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        changePersonalityScore = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        changeComments = new javax.swing.JTextArea();
        ButtonSave = new javax.swing.JButton();
        ButtonDismiss = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        changeDuration = new javax.swing.JTextField();
        changeEducationScore = new javax.swing.JComboBox<>();
        changeExperienceScore = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Interview");

        jLabel2.setText("Recruiter Username");

        changeRecruiterUsername.setEditable(false);
        changeRecruiterUsername.setText(interview.getRecruiterUsername());

        jLabel3.setText("Candidate Username");

        changeCandidateUsername.setEditable(false);
        changeCandidateUsername.setText(interview.getCandidateUsername());

        jLabel4.setText("Job ID");

        changeJobID.setEditable(false);
        changeJobID.setText(intToStringJobID);

        changeInterviewDate.setText(dateToStringInterviewDate);

        jLabel5.setText("Interview Date");

        jLabel6.setText("Starting Time");

        changeStartingTime.setText(timeToStringStartingTime);

        jLabel7.setText("Comments");

        jLabel8.setText("Personality Score");

        changePersonalityScore.setEditable(false);
        changePersonalityScore.setText(doubleToStringPersonalityScore);

        jLabel9.setText("Education Score");

        jLabel10.setText("Experience Score");

        changeComments.setColumns(20);
        changeComments.setRows(5);
        jScrollPane1.setViewportView(changeComments);
        changeComments.setText(interview.getComments());

        ButtonSave.setText("Save");
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        ButtonDismiss.setText("Dismiss");
        ButtonDismiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDismissActionPerformed(evt);
            }
        });

        jLabel11.setText("Duration");

        changeDuration.setText(timeToStringDuration);

        changeEducationScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        changeEducationScore.setSelectedIndex(interview.getEducationScore());

        changeExperienceScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        changeExperienceScore.setSelectedIndex(interview.getExperienceScore());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(changePersonalityScore, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(changeEducationScore, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(changeExperienceScore, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(changeRecruiterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(changeCandidateUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(changeStartingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(changeJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(changeInterviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(changeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(114, 114, 114))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(ButtonSave)
                                        .addGap(118, 118, 118)))
                                .addComponent(ButtonDismiss))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(229, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changeRecruiterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeCandidateUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeEducationScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeExperienceScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(changeJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeInterviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeStartingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(changePersonalityScore, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(changeDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSave)
                    .addComponent(ButtonDismiss))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        setNewRecruiterUsername(changeRecruiterUsername.getText());
        setNewCandidateUsername(changeCandidateUsername.getText());
        stringToIntJobID = Integer.parseInt(changeJobID.getText());
        setNewJobID(stringToIntJobID);
        try {
            newInterviewDate = dateFormatDate.parse(changeInterviewDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlNewInterviewDate = new java.sql.Date(newInterviewDate.getTime());
        setNewInterviewDate(sqlNewInterviewDate);
        try {
            newStartingTimeTest = dateFormatTime.parse(changeStartingTime.getText()).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        setNewStartingTime(new Time(newStartingTimeTest));
        
        try {
            newDurationTest = dateFormatTime.parse(changeDuration.getText()).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        setNewDuration(new Time(newDurationTest));
        setNewComments(changeComments.getText());
        stringToDoublePersonalityScore = Double.parseDouble(changePersonalityScore.getText());
        setNewPersonalityScore(stringToDoublePersonalityScore);
        setNewEducationScore(changeEducationScore.getSelectedIndex());
        setNewExperienceScore(changeExperienceScore.getSelectedIndex());
        iCRUDImpl.interviewEdit(getNewRecruiterUsername(), getNewCandidateUsername(), getNewJobID());
        this.dispose();
        iCRUDImpl.getInterview(interview.getRecruiterUsername(), interview.getCandidateUsername(), interview.getJobID());
    }//GEN-LAST:event_ButtonSaveActionPerformed

    private void ButtonDismissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDismissActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonDismissActionPerformed

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
            java.util.logging.Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecruiterInterviewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecruiterInterviewEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDismiss;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JTextField changeCandidateUsername;
    private javax.swing.JTextArea changeComments;
    private javax.swing.JTextField changeDuration;
    private javax.swing.JComboBox<String> changeEducationScore;
    private javax.swing.JComboBox<String> changeExperienceScore;
    private javax.swing.JTextField changeInterviewDate;
    private javax.swing.JTextField changeJobID;
    private javax.swing.JTextField changePersonalityScore;
    private javax.swing.JTextField changeRecruiterUsername;
    private javax.swing.JTextField changeStartingTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    /**
     * @return the newRecruiterUsername
     */
    public String getNewRecruiterUsername() {
        return newRecruiterUsername;
    }

    /**
     * @param newRecruiterUsername the newRecruiterUsername to set
     */
    public void setNewRecruiterUsername(String newRecruiterUsername) {
        RecruiterInterviewEdit.newRecruiterUsername = newRecruiterUsername;
    }

    /**
     * @return the newCandidateUsername
     */
    public String getNewCandidateUsername() {
        return newCandidateUsername;
    }

    /**
     * @param newCandidateUsername the newCandidateUsername to set
     */
    public void setNewCandidateUsername(String newCandidateUsername) {
        RecruiterInterviewEdit.newCandidateUsername = newCandidateUsername;
    }

    /**
     * @return the newComments
     */
    public String getNewComments() {
        return newComments;
    }

    /**
     * @param newComments the newComments to set
     */
    public void setNewComments(String newComments) {
        RecruiterInterviewEdit.newComments = newComments;
    }

    /**
     * @return the newJobID
     */
    public int getNewJobID() {
        return newJobID;
    }

    /**
     * @param newJobID the newJobID to set
     */
    public void setNewJobID(int newJobID) {
        RecruiterInterviewEdit.newJobID = newJobID;
    }

    /**
     * @return the newPersonalityScore
     */
    public double getNewPersonalityScore() {
        return newPersonalityScore;
    }

    /**
     * @param newPersonalityScore the newPersonalityScore to set
     */
    public void setNewPersonalityScore(double newPersonalityScore) {
        RecruiterInterviewEdit.newPersonalityScore = newPersonalityScore;
    }

    /**
     * @return the newEducationScore
     */
    public int getNewEducationScore() {
        return newEducationScore;
    }

    /**
     * @param newEducationScore the newEducationScore to set
     */
    public void setNewEducationScore(int newEducationScore) {
        RecruiterInterviewEdit.newEducationScore = newEducationScore;
    }

    /**
     * @return the newExperienceScore
     */
    public int getNewExperienceScore() {
        return newExperienceScore;
    }

    /**
     * @param newExperienceScore the newExperienceScore to set
     */
    public void setNewExperienceScore(int newExperienceScore) {
        RecruiterInterviewEdit.newExperienceScore = newExperienceScore;
    }

    /**
     * @return the newInterviewDate
     */
    public java.util.Date getNewInterviewDate() {
        return newInterviewDate;
    }

    /**
     * @param newInterviewDate the newInterviewDate to set
     */
    public void setNewInterviewDate(Date newInterviewDate) {
        RecruiterInterviewEdit.newInterviewDate = newInterviewDate;
    }

    /**
     * @return the newStartingTime
     */
    public Time getNewStartingTime() {
        return newStartingTime;
    }

    /**
     * @param newStartingTime the newStartingTime to set
     */
    public void setNewStartingTime(Time newStartingTime) {
        RecruiterInterviewEdit.newStartingTime = newStartingTime;
    }
    
    /**
     * @return the newDuration
     */
    public Time getNewDuration() {
        return newDuration;
    }

    /**
     * @param newDuration the newDuration to set
     */
    public void setNewDuration(Time newDuration) {
        RecruiterInterviewEdit.newDuration = newDuration;
    }
    
    /**
     * @return the AvgPersonalityScore
     */
    public int getAvgPersonalityScore() {
        return AvgPersonalityScore;
    }

    /**
     * @param AvgPersonalityScore the AvgPersonalityScore to set
     */
    public void setAvgPersonalityScore(int AvgPersonalityScore) {
        this.AvgPersonalityScore = AvgPersonalityScore;
    }

}
