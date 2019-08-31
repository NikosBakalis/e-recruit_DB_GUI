/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javamysql.database.ICRUDImpl;
import javamysql.model.Company;
import javamysql.model.Evaluation;
import javamysql.model.Job;

/**
 *
 * @author Nikolas
 */
public class CandidateJobMoreInfo extends javax.swing.JFrame {
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Job job = new Job();
    CandidateNewApplies candidateAppliesNew = new CandidateNewApplies();
    Company company = new Company();
    Evaluation evaluation = new Evaluation();
    
    SimpleDateFormat dateFormatTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    String intToStringSalary = null;
    String timestampToStringAnnounceDate;
    String dateToStringSubmissionDate;
    String intToStringID = null;
    String dateToStringStartDate;
    String dateToStringLastInterviewDate;
    
    Date now = new Date(System.currentTimeMillis());

    /**
     * Creates new form JobMoreInfo
     */
    public CandidateJobMoreInfo() {
        initComponents();
        iCRUDImpl.getJob(candidateAppliesNew.getValueID());
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
        Position = new javax.swing.JLabel();
        LastInterviewDate = new javax.swing.JLabel();
        Seat = new javax.swing.JLabel();
        TextLastInterviewDate = new javax.swing.JTextField();
        TextSeat = new javax.swing.JTextField();
        Recruiter = new javax.swing.JLabel();
        TextRecruiter = new javax.swing.JTextField();
        Salary = new javax.swing.JLabel();
        TextSalary = new javax.swing.JTextField();
        AnnounceDate = new javax.swing.JLabel();
        TextAnnounceDate = new javax.swing.JTextField();
        SubmissionDate = new javax.swing.JLabel();
        TextSubmissionDate = new javax.swing.JTextField();
        StartDate = new javax.swing.JLabel();
        TextStartDate = new javax.swing.JTextField();
        JobID = new javax.swing.JLabel();
        TextJobID = new javax.swing.JTextField();
        Results = new javax.swing.JLabel();
        TextResults = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Position.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        Position.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Position.setText(job.getPosition());
        Position.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PositionAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        LastInterviewDate.setText("Last Interview Date");

        Seat.setText("Seat");

        TextLastInterviewDate.setEditable(false);
        TextLastInterviewDate.setText(dateToStringLastInterviewDate);
        TextLastInterviewDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextLastInterviewDateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        TextSeat.setEditable(false);
        TextSeat.setText(job.getCountry());
        // System.out.println(job.getCountry());
        TextSeat.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextSeatAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Recruiter.setText("Recruiter");

        TextRecruiter.setEditable(false);
        TextRecruiter.setText(job.getRecruiter());
        // System.out.println(job.getCountry());
        TextRecruiter.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextRecruiterAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Salary.setText("Salary");

        TextSalary.setEditable(false);
        TextSalary.setText(intToStringSalary);
        TextSalary.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextSalaryAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        AnnounceDate.setText("Announce Date");

        TextAnnounceDate.setEditable(false);
        TextAnnounceDate.setText(timestampToStringAnnounceDate);
        TextAnnounceDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextAnnounceDateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        SubmissionDate.setText("Submission Date");

        TextSubmissionDate.setEditable(false);
        TextSubmissionDate.setText(dateToStringSubmissionDate);
        TextSubmissionDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextSubmissionDateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        StartDate.setText("Start Date");

        TextStartDate.setEditable(false);
        TextStartDate.setText(dateToStringStartDate);
        TextStartDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextStartDateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JobID.setText("Job ID");

        TextJobID.setEditable(false);
        TextJobID.setText(intToStringID);
        TextJobID.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextJobIDAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Results.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Results.setText("Results");

        TextResults.setEditable(false);
        TextResults.setText("Your Ranking is " + iCRUDImpl.getMyPlacement() + " out of " + iCRUDImpl.getAllCandidates() + " candidates");
        TextResults.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TextResultsAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JobID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LastInterviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextLastInterviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextAnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextSubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Recruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextRecruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Seat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(TextResults))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Results, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LastInterviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextLastInterviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JobID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Seat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Results, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Recruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextRecruiter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextResults, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextAnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnnounceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSubmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextResultsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextResultsAncestorAdded
        if(job.getLastInterviewDate().before(now)){
            iCRUDImpl.evaluation(job.getId());
            TextResults.setText("Your ranking is " + iCRUDImpl.getMyPlacement() + " out of " + iCRUDImpl.getAllCandidates() + " candidates");
        } else {
            TextResults.setText("Results still in progress...");
        }
    }//GEN-LAST:event_TextResultsAncestorAdded

    private void TextLastInterviewDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextLastInterviewDateAncestorAdded
        dateToStringLastInterviewDate = dateFormatDate.format(job.getLastInterviewDate());
        TextLastInterviewDate.setText(dateToStringLastInterviewDate);
    }//GEN-LAST:event_TextLastInterviewDateAncestorAdded

    private void TextStartDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextStartDateAncestorAdded
        dateToStringStartDate = dateFormatDate.format(job.getStartDate());
        TextStartDate.setText(dateToStringStartDate);
    }//GEN-LAST:event_TextStartDateAncestorAdded

    private void TextSubmissionDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextSubmissionDateAncestorAdded
        dateToStringSubmissionDate = dateFormatDate.format(job.getSubmissionDate());
        TextSubmissionDate.setText(dateToStringSubmissionDate);
    }//GEN-LAST:event_TextSubmissionDateAncestorAdded

    private void TextAnnounceDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextAnnounceDateAncestorAdded
        timestampToStringAnnounceDate = dateFormatTimestamp.format(job.getAnnounceDate());
        TextAnnounceDate.setText(timestampToStringAnnounceDate);
    }//GEN-LAST:event_TextAnnounceDateAncestorAdded

    private void TextSalaryAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextSalaryAncestorAdded
        intToStringSalary = Integer.toString(job.getSalary());
        TextSalary.setText(intToStringSalary);
    }//GEN-LAST:event_TextSalaryAncestorAdded

    private void TextRecruiterAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextRecruiterAncestorAdded
        TextRecruiter.setText(job.getRecruiter());
    }//GEN-LAST:event_TextRecruiterAncestorAdded

    private void TextSeatAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextSeatAncestorAdded
        TextSeat.setText(job.getCountry());
    }//GEN-LAST:event_TextSeatAncestorAdded

    private void TextJobIDAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TextJobIDAncestorAdded
        intToStringID = Integer.toString(job.getId());
        TextJobID.setText(intToStringID);
    }//GEN-LAST:event_TextJobIDAncestorAdded

    private void PositionAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PositionAncestorAdded
        Position.setText(job.getPosition());
    }//GEN-LAST:event_PositionAncestorAdded

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
            java.util.logging.Logger.getLogger(CandidateJobMoreInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandidateJobMoreInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandidateJobMoreInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandidateJobMoreInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandidateJobMoreInfo().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnnounceDate;
    private javax.swing.JLabel JobID;
    private javax.swing.JLabel LastInterviewDate;
    private javax.swing.JLabel Position;
    private javax.swing.JLabel Recruiter;
    private javax.swing.JLabel Results;
    private javax.swing.JLabel Salary;
    private javax.swing.JLabel Seat;
    private javax.swing.JLabel StartDate;
    private javax.swing.JLabel SubmissionDate;
    private javax.swing.JTextField TextAnnounceDate;
    private javax.swing.JTextField TextJobID;
    private javax.swing.JTextField TextLastInterviewDate;
    private javax.swing.JTextField TextRecruiter;
    private javax.swing.JTextField TextResults;
    private javax.swing.JTextField TextSalary;
    private javax.swing.JTextField TextSeat;
    private javax.swing.JTextField TextStartDate;
    private javax.swing.JTextField TextSubmissionDate;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}