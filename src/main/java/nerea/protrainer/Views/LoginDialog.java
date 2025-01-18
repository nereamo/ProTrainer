/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package nerea.protrainer.Views;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javax.swing.JOptionPane;
import nerea.protrainer.ProTrainer;
import nerea.protrainer.dto.Usuari;

/**
 *
 * @author Nerea
 */
public class LoginDialog extends javax.swing.JDialog {
    
    private ProTrainer frameMain;
    
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.frameMain = (ProTrainer) parent;
        initComponents();
        setSize(500,300);
        setLocationRelativeTo(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTxtFldEmail = new javax.swing.JTextField();
        jPsswrd = new javax.swing.JPasswordField();
        jBttnLogIn = new javax.swing.JButton();
        jLblError = new javax.swing.JLabel();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel1.setLayout(null);

        jTxtFldEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtFldEmail.setForeground(new java.awt.Color(0, 0, 0));
        jTxtFldEmail.setText("a@b.c");
        jTxtFldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTxtFldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFldEmailActionPerformed(evt);
            }
        });
        jPanel1.add(jTxtFldEmail);
        jTxtFldEmail.setBounds(100, 60, 270, 30);

        jPsswrd.setBackground(new java.awt.Color(255, 255, 255));
        jPsswrd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPsswrd.setForeground(new java.awt.Color(0, 0, 0));
        jPsswrd.setText("string");
        jPsswrd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jPsswrd);
        jPsswrd.setBounds(100, 110, 270, 30);

        jBttnLogIn.setBackground(new java.awt.Color(0, 0, 0));
        jBttnLogIn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBttnLogIn.setForeground(new java.awt.Color(255, 255, 255));
        jBttnLogIn.setText("INICIAR SESION");
        jBttnLogIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBttnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogInActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnLogIn);
        jBttnLogIn.setBounds(150, 160, 150, 24);

        jLblError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLblError);
        jLblError.setBounds(110, 210, 240, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFldEmailActionPerformed

    }//GEN-LAST:event_jTxtFldEmailActionPerformed

    private void jBttnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogInActionPerformed

        String loggedInEmail = jTxtFldEmail.getText();
        Usuari usuari = Usuari.loggedUsuari(loggedInEmail);

        if(usuari.isInstructor()){

            if(BCrypt.verifyer().verify(jPsswrd.getPassword(), usuari.getPasswordHash()).verified){
                frameMain.setLoggedInstructor(usuari);
                JOptionPane.showMessageDialog(this, "Login successful. Welcome " + usuari.getNom() + "!");
                frameMain.showPanel();
                dispose();
            } else {
                jLblError.setText("Error: La contraseña no es correcta.");
            }

        }else {
            jLblError.setText("Error: user not found");
        }
    }//GEN-LAST:event_jBttnLogInActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnLogIn;
    private javax.swing.JLabel jLblError;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPsswrd;
    private javax.swing.JTextField jTxtFldEmail;
    // End of variables declaration//GEN-END:variables
}
