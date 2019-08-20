/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamysql.database.ICRUDImpl;
import javamysql.model.Job;
import javamysql.model.Recruiter;

/**
 *
 * @author Nikolas
 */
public class EditAJob extends javax.swing.JFrame {
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    RecruiterNewPosition recruiterNewPosition = new RecruiterNewPosition();
    Job job = new Job();
    
    DateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    private static  String newPosition, newSeat;
    private static int newSalary;
    private static java.util.Date newStartDate, newSubmissionDate;
    
    protected int stringToIntSalary;
    
    RecruiterUI recruiterUI = new RecruiterUI();
    Recruiter recruiter = new Recruiter();

    /**
     * Creates new form EditAJob
     */
    public EditAJob() {
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
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        changeID = new javax.swing.JTextField();
        StartDate = new javax.swing.JLabel();
        changeStartDate = new javax.swing.JTextField();
        Salary = new javax.swing.JLabel();
        changeSalary = new javax.swing.JTextField();
        changePosition = new javax.swing.JTextField();
        Position = new javax.swing.JLabel();
        Seat = new javax.swing.JLabel();
        changeSeat = new javax.swing.JTextField();
        Recruiter = new javax.swing.JLabel();
        changeRecruiter = new javax.swing.JTextField();
        AnnounceDate = new javax.swing.JLabel();
        changeAnnounceDate = new javax.swing.JTextField();
        SubmissionDate = new javax.swing.JLabel();
        changeSubmissionDate = new javax.swing.JTextField();
        ButtonAdd = new javax.swing.JButton();
        ButtonDismiss = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT JOB");

        ID.setText("ID");

        changeID.setEditable(false);
        String intToStringID = Integer.toString(job.getId());
        System.out.println(intToStringID);
        changeID.setText(intToStringID);

        StartDate.setText("Start Date");

        String dateToStringStartDate = dateFormatDate.format(job.getStartDate());
        changeStartDate.setText(dateToStringStartDate);

        Salary.setText("Salary");

        String intToStringSalary = Integer.toString(job.getSalary());
        changeSalary.setText(intToStringSalary);

        changePosition.setText(job.getPosition());

        Position.setText("Position");

        Seat.setText("Seat");

        changeSeat.setText(job.getCountry());

        Recruiter.setText("Recruiter");

        changeRecruiter.setEditable(false);
        changeRecruiter.setText(job.getRecruiter());

        AnnounceDate.setText("Annaounce Date");

        changeAnnounceDate.setEditable(false);
        String dateToStringAnnounceDate = dateFormatDate.format(job.getAnnounceDate());
        changeAnnounceDate.setText(dateToStringAnnounceDate);

        SubmissionDate.setText("Submission Date");

        String dateToStringSubmissionDate = dateFormatDate.format(job.getSubmissionDate());
        changeSubmissionDate.setText(dateToStringSubmissionDate);

        ButtonAdd.setText("Save");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonDismiss.setText("Dismiss");
        ButtonDismiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDismissActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeID))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeStartDate))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeSalary))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changePosition, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(339, 339, 339)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Recruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeRecruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeAnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeSubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Seat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeSeat))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonDismiss))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Recruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeRecruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeAnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeSubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changePosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAdd)
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
        dateFormatDate.format(System.currentTimeMillis());
    }//GEN-LAST:event_ButtonDismissActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        try {
            newStartDate = dateFormatDate.parse(changeStartDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AddAJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlNewStartDate = new java.sql.Date(newStartDate.getTime());
        setNewStartDate(sqlNewStartDate);
        stringToIntSalary = Integer.parseInt(changeSalary.getText());
        newSalary = stringToIntSalary;
        newPosition = changePosition.getText();
        newSeat = changeSeat.getText();
        try {
            newSubmissionDate = dateFormatDate.parse(changeSubmissionDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AddAJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlNewSubmissionDate = new java.sql.Date(newSubmissionDate.getTime());
        setNewSubmissionDate(sqlNewSubmissionDate);
        //newSubmissionDate = changeSubmissionDate.getText();
        iCRUDImpl.editAJob(job.getId());
        this.dispose();
    }//GEN-LAST:event_ButtonAddActionPerformed

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
            java.util.logging.Logger.getLogger(EditAJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnnounceDate;
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonDismiss;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel Position;
    private javax.swing.JLabel Recruiter;
    private javax.swing.JLabel Salary;
    private javax.swing.JLabel Seat;
    private javax.swing.JLabel StartDate;
    private javax.swing.JLabel SubmissionDate;
    private javax.swing.JTextField changeAnnounceDate;
    private javax.swing.JTextField changeID;
    private javax.swing.JTextField changePosition;
    private javax.swing.JTextField changeRecruiter;
    private javax.swing.JTextField changeSalary;
    private javax.swing.JTextField changeSeat;
    private javax.swing.JTextField changeStartDate;
    private javax.swing.JTextField changeSubmissionDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the newPosition
     */
    public String getNewPosition() {
        return newPosition;
    }

    /**
     * @param newPosition the newPosition to set
     */
    public void setNewPosition(String newPosition) {
        EditAJob.newPosition = newPosition;
    }

    /**
     * @return the newSeat
     */
    public String getNewSeat() {
        return newSeat;
    }

    /**
     * @param newSeat the newSeat to set
     */
    public void setNewSeat(String newSeat) {
        EditAJob.newSeat = newSeat;
    }

    /**
     * @return the newSalary
     */
    public int getNewSalary() {
        return newSalary;
    }

    /**
     * @param newSalary the newSalary to set
     */
    public void setNewSalary(int newSalary) {
        EditAJob.newSalary = newSalary;
    }

    /**
     * @return the newStartDate
     */
    public java.util.Date getNewStartDate() {
        return newStartDate;
    }

    /**
     * @param newStartDate the newStartDate to set
     */
    public void setNewStartDate(java.util.Date newStartDate) {
        EditAJob.newStartDate = newStartDate;
    }

    /**
     * @return the newSubmissionDate
     */
    public java.util.Date getNewSubmissionDate() {
        return newSubmissionDate;
    }

    /**
     * @param newSubmissionDate the newSubmissionDate to set
     */
    public void setNewSubmissionDate(java.util.Date newSubmissionDate) {
        EditAJob.newSubmissionDate = newSubmissionDate;
    }

    /**
     * @return the changeRecruiter
     */
    public javax.swing.JTextField getChangeRecruiter() {
        return changeRecruiter;
    }

    /**
     * @param changeRecruiter the changeRecruiter to set
     */
    public void setChangeRecruiter(javax.swing.JTextField changeRecruiter) {
        this.changeRecruiter = changeRecruiter;
    }
}