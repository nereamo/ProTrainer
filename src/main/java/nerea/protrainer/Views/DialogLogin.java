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
        
        resaltarBotones(btnLogin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txtFieldEmail = new javax.swing.JTextField();
        fldPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        jChkMostrarContraseña = new javax.swing.JCheckBox();

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

        txtFieldEmail.setBackground(new java.awt.Color(51, 51, 51));
        txtFieldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldEmail.setText("a@b.c");
        txtFieldEmail.setToolTipText("Email");
        txtFieldEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        txtFieldEmail.setOpaque(true);
        txtFieldEmail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFieldEmail);
        txtFieldEmail.setBounds(70, 20, 260, 50);

        fldPassword.setBackground(new java.awt.Color(51, 51, 51));
        fldPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fldPassword.setForeground(new java.awt.Color(255, 255, 255));
        fldPassword.setText("string");
        fldPassword.setToolTipText("Password");
        fldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        fldPassword.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(fldPassword);
        fldPassword.setBounds(70, 80, 260, 50);

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("INICIAR SESION");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(110, 180, 160, 20);

        lblMsg.setBackground(new java.awt.Color(255, 255, 255));
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMsg);
        lblMsg.setBounds(30, 220, 340, 30);

        jChkMostrarContraseña.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jChkMostrarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jChkMostrarContraseña.setText("Ver contraseña");
        jChkMostrarContraseña.setToolTipText("Ver contraseña");
        jChkMostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkMostrarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(jChkMostrarContraseña);
        jChkMostrarContraseña.setBounds(140, 140, 110, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String email = txtFieldEmail.getText();
        Usuari usuario = UsuarisDAO.inicioSesionUsuario(email);

        if (usuario.isInstructor()) {

            if (BCrypt.verifyer().verify(fldPassword.getPassword(), usuario.getPasswordHash()).verified) {
                frameMain.setLoggedInstructor(usuario);
                frameMain.showPanel();
                dispose();
            } else {
                lblMsg.setText("La contraseña no es correcta.");
            }

        } else {
            lblMsg.setText("No se ha encontrado el usuario");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jChkMostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkMostrarContraseñaActionPerformed
        if (jChkMostrarContraseña.isSelected()) {
            fldPassword.setEchoChar((char) 0); 
        } else {
            fldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jChkMostrarContraseñaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField fldPassword;
    private javax.swing.JCheckBox jChkMostrarContraseña;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JTextField txtFieldEmail;
    // End of variables declaration//GEN-END:variables
}
