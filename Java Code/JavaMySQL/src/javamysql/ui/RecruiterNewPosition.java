/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

// import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javamysql.database.ICRUDImpl;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Nikolas
 */
public class RecruiterNewPosition extends javax.swing.JFrame {
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    
    private static int valueID = 0;
    private static String valueRecruiter = null;

    /**
     * Creates new form RecruiterNewPosition
     */
    public RecruiterNewPosition() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableJob = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ButtonBack = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ButtonDeleteJob = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ButtonInterview = new javax.swing.JButton();
        ButtonEvaluation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TableJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Start Date", "Salary", "Position", "Seat", "recruiter", "Announce Date", "Submission Date"
            }
        ));
        TableJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableJobMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableJob);

        jButton1.setText("See All Jobs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Job");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ButtonBack.setText("Back");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        jButton3.setText("See My Jobs");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ButtonDeleteJob.setText("Delete Job");
        ButtonDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteJobActionPerformed(evt);
            }
        });

        jButton5.setText("Edit Job");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ButtonInterview.setText("Interview");
        ButtonInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInterviewActionPerformed(evt);
            }
        });

        ButtonEvaluation.setText("Evaluation");
        ButtonEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEvaluationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonDeleteJob)
                                .addGap(413, 413, 413)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonInterview)
                                .addGap(212, 212, 212)
                                .addComponent(jButton1)
                                .addGap(105, 105, 105)
                                .addComponent(ButtonEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(220, 220, 220)
                                .addComponent(ButtonBack)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonDeleteJob)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(ButtonBack)
                    .addComponent(jButton3)
                    .addComponent(ButtonInterview)
                    .addComponent(ButtonEvaluation))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RecruiterCompanyUI companyUI = new RecruiterCompanyUI();
        int stringToIntAFM = Integer.parseInt(companyUI.getChangeAFM().getText());
        getAllJobs(stringToIntAFM);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        RecruiterCompanyUI companyUI = new RecruiterCompanyUI();
        companyUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        RecruiterUI recruiterUI = new RecruiterUI();
        getMyJobs(recruiterUI.getChangeUsername().getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RecruiterAddAJob addAJob = new RecruiterAddAJob();
        addAJob.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TableJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableJobMouseClicked
        int row = TableJob.getSelectedRow();
        TableModel model = TableJob.getModel();
        setValueID(Integer.parseInt(model.getValueAt(row, 0).toString()));
        setValueRecruiter(TableJob.getModel().getValueAt(row, 5).toString());
    }//GEN-LAST:event_TableJobMouseClicked

    private void ButtonDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteJobActionPerformed
        RecruiterUI recruiterUI = new RecruiterUI();
        if(recruiterUI.getChangeUsername().getText().equals(getValueRecruiter())){
            iCRUDImpl.delJob(getValueID(), recruiterUI.getChangeUsername().getText());
        } else {
            System.err.println("Sorry this is not your job!!!");
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Sorry this is not your job!");
        }
    }//GEN-LAST:event_ButtonDeleteJobActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        iCRUDImpl.getJob(getValueID());
        RecruiterEditAJob editAJob = new RecruiterEditAJob();
        System.out.println("TEST 1");
        RecruiterUI recruiterUI = new RecruiterUI();
        if(recruiterUI.getChangeUsername().getText().equals(getValueRecruiter())){
            editAJob.setVisible(true);
        } else {
            System.err.println("Sorry this is not your job!!!");
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Sorry this is not your job!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ButtonInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInterviewActionPerformed
        RecruiterInterviewUI interviewUI = new RecruiterInterviewUI();
        RecruiterUI recruiterUI = new RecruiterUI();
        if(recruiterUI.getChangeUsername().getText().equals(getValueRecruiter())){
            interviewUI.setVisible(true);
            this.dispose();
        } else {
            System.err.println("Sorry this is not your job!!!");
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Sorry this is not your job!");
        }
    }//GEN-LAST:event_ButtonInterviewActionPerformed

    private void ButtonEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEvaluationActionPerformed
        RecruiterUI recruiterUI = new RecruiterUI();
        if(recruiterUI.getChangeUsername().getText().equals(getValueRecruiter())){
            iCRUDImpl.evaluation(getValueID());
            RecruiterEvaluation recruiterEvaluation = new RecruiterEvaluation();
            recruiterEvaluation.setVisible(true);
        } else {
            System.out.println("Sorry this is not your job!!!");
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Sorry this is not your job!");
        }
    }//GEN-LAST:event_ButtonEvaluationActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecruiterNewPosition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecruiterNewPosition().setVisible(true);
            }
        });
    }
    
    /* ΑΥΤΟ ΤΟ ΚΟΜΜΑΤΙ ΝΑ ΓΙΝΕΙ ΜΕ GETTER / SETTER ΣΤΟ TableJob ΚΑΙ ΝΑ ΤΟ ΠΑΙΡΝΩ ΑΠΟ ΤΗΝ ICRUDImpl*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public RecruiterNewPosition getAllJobs(int AFM) {
        iCRUDImpl.openConnection();
        try{
            RecruiterNewPosition recruiterNewPosition = new RecruiterNewPosition();
            String query = "SELECT job.* FROM job INNER JOIN recruiter ON job.recruiter = recruiter.username WHERE firm = '" + AFM + "'";
            PreparedStatement preparedStatement = iCRUDImpl.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            TableJob.setModel(DbUtils.resultSetToTableModel(resultSet));
            return recruiterNewPosition;
        } catch (SQLException e) {
            return null;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public RecruiterNewPosition getMyJobs(String recruiter) {
        iCRUDImpl.openConnection();
        try{
            RecruiterNewPosition recruiterNewPosition = new RecruiterNewPosition();
            String query = "SELECT * FROM job WHERE recruiter = '" + recruiter + "'";
            PreparedStatement preparedStatement = iCRUDImpl.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            TableJob.setModel(DbUtils.resultSetToTableModel(resultSet));
            return recruiterNewPosition;
        } catch (SQLException e) {
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonDeleteJob;
    private javax.swing.JButton ButtonEvaluation;
    private javax.swing.JButton ButtonInterview;
    private javax.swing.JTable TableJob;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the valueID
     */
    public int getValueID() {
        return valueID;
    }

    /**
     * @param valueID the valueID to set
     */
    public void setValueID(int valueID) {
        RecruiterNewPosition.valueID = valueID;
    }

    /**
     * @return the valueRecruiter
     */
    public String getValueRecruiter() {
        return valueRecruiter;
    }

    /**
     * @param valueRecruiter the valueRecruiter to set
     */
    public void setValueRecruiter(String valueRecruiter) {
        RecruiterNewPosition.valueRecruiter = valueRecruiter;
    }
}
