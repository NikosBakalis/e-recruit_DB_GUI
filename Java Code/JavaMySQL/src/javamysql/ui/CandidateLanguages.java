/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import javamysql.database.ICRUDImpl;
import javamysql.model.Languages;

/**
 *
 * @author Nikolas
 */
public class CandidateLanguages extends javax.swing.JFrame {
    
    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Languages languages = new Languages();
    CandidateUI candidateUI = new CandidateUI();
    
    private static String languagesCombinations;

    /**
     * Creates new form CandidateLanguages
     */
    public CandidateLanguages() {
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
        ButtonSave = new javax.swing.JButton();
        ButtonDismiss = new javax.swing.JButton();
        english = new javax.swing.JCheckBox();
        france = new javax.swing.JCheckBox();
        spanish = new javax.swing.JCheckBox();
        greek = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        languageResults = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Languages");

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

        english.setText("Engish");

        france.setText("France");

        spanish.setText("Spanish");

        greek.setText("Greek");

        jLabel2.setText("Select the Languages you know");

        languageResults.setEditable(false);
        iCRUDImpl.getLanguages(candidateUI.getNewUsername());
        languageResults.setText(languages.getLanguages());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(ButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonDismiss)
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(english)
                            .addComponent(greek)
                            .addComponent(france)
                            .addComponent(spanish))))
                .addGap(2, 2, 2)
                .addComponent(languageResults, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(english)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(france)
                        .addGap(20, 20, 20)
                        .addComponent(spanish)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(languageResults, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addComponent(greek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSave)
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

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        if(english.isSelected() && !france.isSelected() && !spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("EN");
        } else if(!english.isSelected() && france.isSelected() && !spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("FR");
        } else if(!english.isSelected() && !france.isSelected() && spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("SP");
        } else if(!english.isSelected() && !france.isSelected() && !spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("GR");
        } else if(english.isSelected() && france.isSelected() && !spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("EN,FR");
        } else if(english.isSelected() && !france.isSelected() && spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("EN,SP");
        } else if(english.isSelected() && !france.isSelected() && !spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("EN,GR");
        } else if(english.isSelected() && france.isSelected() && spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("EN,FR,SP");
        } else if(english.isSelected() && france.isSelected() && !spanish.isSelected() && greek.isSelected()) {
            setLanguagesCombinations("EN,FR,GR");
        } else if(english.isSelected() && !france.isSelected() && spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("EN,SP,GR");
        } else if(english.isSelected() && france.isSelected() && spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("EN,FR,SP,GR");
        } else if(!english.isSelected() && france.isSelected() && spanish.isSelected() && !greek.isSelected()){
            setLanguagesCombinations("FR,SP");
        } else if(!english.isSelected() && france.isSelected() && !spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("FR,GR");
        } else if(!english.isSelected() && france.isSelected() && spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("FR,SP,GR");
        } else if(!english.isSelected() && !france.isSelected() && spanish.isSelected() && greek.isSelected()){
            setLanguagesCombinations("SP,GR");
        } else {
            setLanguagesCombinations("EN");
        }
        this.dispose();
        iCRUDImpl.newCandidateLanguages(candidateUI.getNewUsername());
    }//GEN-LAST:event_ButtonSaveActionPerformed

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
            java.util.logging.Logger.getLogger(CandidateLanguages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandidateLanguages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandidateLanguages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandidateLanguages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandidateLanguages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDismiss;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JCheckBox english;
    private javax.swing.JCheckBox france;
    private javax.swing.JCheckBox greek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField languageResults;
    private javax.swing.JCheckBox spanish;
    // End of variables declaration//GEN-END:variables


    /**
     * @return the languagesCombinations
     */
    public String getLanguagesCombinations() {
        return languagesCombinations;
    }

    /**
     * @param languagesCombinations the languagesCombinations to set
     */
    public void setLanguagesCombinations(String languagesCombinations) {
        CandidateLanguages.languagesCombinations = languagesCombinations;
    }

}
