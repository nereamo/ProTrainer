package nerea.protrainer.views;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nerea.protrainer.ProTrainer;
import nerea.protrainer.dao.UsuarisDAO;
import nerea.protrainer.dto.Usuari;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 *
 * @author Nerea
 */
public class DialogLogin extends javax.swing.JDialog {

    private ProTrainer frameMain;

    public DialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.frameMain = (ProTrainer) parent;
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(this);
        resaltarBotones(jBttnLogIn);
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
        jCheckBox1 = new javax.swing.JCheckBox();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 270));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(null);

        jTxtFldEmail.setBackground(new java.awt.Color(51, 51, 51));
        jTxtFldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldEmail.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFldEmail.setText("a@b.c");
        jTxtFldEmail.setToolTipText("Email");
        jTxtFldEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jTxtFldEmail.setOpaque(true);
        jTxtFldEmail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTxtFldEmail);
        jTxtFldEmail.setBounds(70, 20, 260, 50);

        jPsswrd.setBackground(new java.awt.Color(51, 51, 51));
        jPsswrd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPsswrd.setForeground(new java.awt.Color(255, 255, 255));
        jPsswrd.setText("string");
        jPsswrd.setToolTipText("Password");
        jPsswrd.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPsswrd.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jPsswrd);
        jPsswrd.setBounds(70, 80, 260, 50);

        jBttnLogIn.setBackground(new java.awt.Color(255, 255, 255));
        jBttnLogIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBttnLogIn.setForeground(new java.awt.Color(0, 0, 0));
        jBttnLogIn.setText("INICIAR SESION");
        jBttnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogInActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnLogIn);
        jBttnLogIn.setBounds(110, 180, 160, 20);

        jLblError.setBackground(new java.awt.Color(255, 255, 255));
        jLblError.setForeground(new java.awt.Color(255, 255, 255));
        jLblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLblError);
        jLblError.setBounds(30, 220, 340, 30);

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Ver password");
        jCheckBox1.setToolTipText("Ver password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(140, 140, 110, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogInActionPerformed

        String loggedInEmail = jTxtFldEmail.getText();
        Usuari usuari = UsuarisDAO.inicioSesionUsuario(loggedInEmail);

        if (usuari.isInstructor()) {

            if (BCrypt.verifyer().verify(jPsswrd.getPassword(), usuari.getPasswordHash()).verified) {
                frameMain.setLoggedInstructor(usuari);
                frameMain.showPanel();
                dispose();
            } else {
                jLblError.setText("La contraseña no es correcta.");
            }

        } else {
            jLblError.setText("No se ha encontrado el usuario");
        }
    }//GEN-LAST:event_jBttnLogInActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
        jPsswrd.setEchoChar((char) 0); // Muestra la contraseña
    } else {
        jPsswrd.setEchoChar('*'); // Oculta la contraseña
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnLogIn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLblError;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPsswrd;
    private javax.swing.JTextField jTxtFldEmail;
    // End of variables declaration//GEN-END:variables
}
