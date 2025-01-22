package nerea.protrainer.Views;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javax.swing.JOptionPane;
import nerea.protrainer.ProTrainer;
import nerea.protrainer.dataAccess.ConsultasBD;
import nerea.protrainer.dto.Usuari;

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
        setSize(400, 270);
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
        setMinimumSize(new java.awt.Dimension(400, 270));
        setPreferredSize(new java.awt.Dimension(400, 270));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 270));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 270));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 270));
        jPanel1.setLayout(null);

        jTxtFldEmail.setBackground(new java.awt.Color(0, 0, 0));
        jTxtFldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldEmail.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFldEmail.setText("a@b.c");
        jTxtFldEmail.setToolTipText("Email");
        jTxtFldEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Anton", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jTxtFldEmail.setOpaque(true);
        jTxtFldEmail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTxtFldEmail);
        jTxtFldEmail.setBounds(70, 30, 260, 50);

        jPsswrd.setBackground(new java.awt.Color(0, 0, 0));
        jPsswrd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPsswrd.setForeground(new java.awt.Color(255, 255, 255));
        jPsswrd.setText("string");
        jPsswrd.setToolTipText("Password");
        jPsswrd.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Anton", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPsswrd.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jPsswrd);
        jPsswrd.setBounds(70, 90, 260, 50);

        jBttnLogIn.setBackground(new java.awt.Color(255, 255, 0));
        jBttnLogIn.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jBttnLogIn.setForeground(new java.awt.Color(0, 0, 0));
        jBttnLogIn.setText("INICIAR SESION");
        jBttnLogIn.setBorder(null);
        jBttnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnLogInActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnLogIn);
        jBttnLogIn.setBounds(120, 150, 150, 40);

        jLblError.setBackground(new java.awt.Color(255, 255, 255));
        jLblError.setForeground(new java.awt.Color(255, 255, 255));
        jLblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLblError);
        jLblError.setBounds(30, 200, 330, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnLogInActionPerformed

        String loggedInEmail = jTxtFldEmail.getText();
        Usuari usuari = ConsultasBD.inicioSesionUsuario(loggedInEmail);

        if (usuari.isInstructor()) {

            if (BCrypt.verifyer().verify(jPsswrd.getPassword(), usuari.getPasswordHash()).verified) {
                frameMain.setLoggedInstructor(usuari);
                JOptionPane.showMessageDialog(this, "Bienvenido " + usuari.getNom() + "!");
                frameMain.showPanel();
                dispose();
            } else {
                jLblError.setText("Error: La contraseña no es correcta.");
            }

        } else {
            jLblError.setText("Error: No se ha encontrado el usuario");
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
