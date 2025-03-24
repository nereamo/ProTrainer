package nerea.protrainer;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import nerea.protrainer.views.DialogAbout;
import nerea.protrainer.views.DialogCalendar;
import nerea.protrainer.views.DialogLogin;
import nerea.protrainer.views.PanelMenu;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.eventosVisuales.EventosMouse;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Nerea
 */
public class ProTrainer extends javax.swing.JFrame {

    private static Usuari loggedInstructor;

    public ProTrainer() {
        initComponents();
        setSize(1200, 700);
        setLocationRelativeTo(this);

        PanelMenu panelMenu = new PanelMenu(this);

        pnlMain.setLayout(new MigLayout("fill", "[grow]", "[grow]"));

        pnlMain.add(lblLogo, "align center, wrap");
        pnlMain.add(lblMsg, "align center, wrap");
        pnlMain.add(btnAcceso, "align center, wrap");
        pnlMain.add(lblUrl, "dock north, align right");

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(pnlMain, BorderLayout.CENTER);

        mnuCalendario.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/dumbbell Icon.png"));
        setIconImage(icon);
        
        EventosMouse.configurarEventos(btnAcceso, lblUrl);
    }

    public void setLoggedInstructor(Usuari instructor) {
        this.loggedInstructor = instructor;
    }

    public static Usuari getLoggedInstructor() {
        return loggedInstructor;
    }

    //----------Método que hace visible el panel----------
    public void showPanel() {

        PanelMenu pnlMenu = new PanelMenu(this);
        this.getContentPane().removeAll();
        this.getContentPane().add(pnlMenu, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    //----------Método que hace visible el calendar----------
    public void showCalendarMenu() {
        mnuCalendario.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        pnlMain = new javax.swing.JPanel();
        lblMsg = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnAcceso = new javax.swing.JButton();
        lblUrl = new javax.swing.JLabel();
        jMnuBar = new javax.swing.JMenuBar();
        mnuOpciones = new javax.swing.JMenu();
        mnuItmLogout = new javax.swing.JMenuItem();
        mnuItmSalir = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenu();
        mnuCalendario = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROTrainer");
        getContentPane().setLayout(null);

        pnlMain.setBackground(new java.awt.Color(0, 0, 0));
        pnlMain.setMinimumSize(new java.awt.Dimension(1200, 700));
        pnlMain.setLayout(null);

        lblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsg.setToolTipText("");
        pnlMain.add(lblMsg);
        lblMsg.setBounds(410, 330, 360, 30);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.png"))); // NOI18N
        pnlMain.add(lblLogo);
        lblLogo.setBounds(230, 100, 689, 210);

        btnAcceso.setForeground(new java.awt.Color(0, 0, 0));
        btnAcceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Login.png"))); // NOI18N
        btnAcceso.setToolTipText("Login");
        btnAcceso.setContentAreaFilled(false);
        btnAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccesoActionPerformed(evt);
            }
        });
        pnlMain.add(btnAcceso);
        btnAcceso.setBounds(520, 490, 140, 67);

        lblUrl.setBackground(new java.awt.Color(0, 0, 0));
        lblUrl.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        lblUrl.setForeground(new java.awt.Color(0, 0, 0));
        lblUrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Web.png"))); // NOI18N
        lblUrl.setToolTipText("Web");
        lblUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUrlMouseClicked(evt);
            }
        });
        pnlMain.add(lblUrl);
        lblUrl.setBounds(1150, 570, 35, 30);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(0, 0, 1200, 700);

        jMnuBar.setBackground(new java.awt.Color(0, 0, 0));
        jMnuBar.setBorder(null);
        jMnuBar.setForeground(new java.awt.Color(255, 255, 255));
        jMnuBar.setBorderPainted(false);
        jMnuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMnuBar.setEnabled(false);
        jMnuBar.setOpaque(true);

        mnuOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Menu.png"))); // NOI18N
        mnuOpciones.setToolTipText("Salir");
        mnuOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuOpciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuOpciones.setMaximumSize(new java.awt.Dimension(60, 60));
        mnuOpciones.setPreferredSize(new java.awt.Dimension(38, 38));

        mnuItmLogout.setBackground(new java.awt.Color(255, 255, 255));
        mnuItmLogout.setText("LogOut");
        mnuItmLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnuItmLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmLogoutActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuItmLogout);

        mnuItmSalir.setBackground(new java.awt.Color(255, 255, 255));
        mnuItmSalir.setText("Exit");
        mnuItmSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnuItmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmSalirActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuItmSalir);

        jMnuBar.add(mnuOpciones);

        mnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Info.png"))); // NOI18N
        mnuAbout.setToolTipText("Informacion");
        mnuAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuAbout.setMinimumSize(new java.awt.Dimension(38, 38));
        mnuAbout.setPreferredSize(new java.awt.Dimension(38, 38));
        mnuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAboutMouseClicked(evt);
            }
        });
        jMnuBar.add(mnuAbout);

        mnuCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Calendar.png"))); // NOI18N
        mnuCalendario.setToolTipText("Calendario");
        mnuCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCalendario.setMinimumSize(new java.awt.Dimension(38, 38));
        mnuCalendario.setPreferredSize(new java.awt.Dimension(38, 38));
        mnuCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCalendarioMouseClicked(evt);
            }
        });
        jMnuBar.add(mnuCalendario);

        setJMenuBar(jMnuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItmLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmLogoutActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().add(pnlMain);
        
        mnuCalendario.setVisible(false);
        pnlMain.setVisible(true);
        lblMsg.setText("Se ha cerrado sesión.");

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_mnuItmLogoutActionPerformed

    private void btnAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoActionPerformed
        DialogLogin dl = new DialogLogin(this, true);
        dl.setVisible(true);
    }//GEN-LAST:event_btnAccesoActionPerformed

    private void lblUrlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUrlMouseClicked
        try {

            String url = "http://www.ejemplo.com";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblUrlMouseClicked

    private void mnuItmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmSalirActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar la aplicación?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnuItmSalirActionPerformed

    private void mnuCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCalendarioMouseClicked
        DialogCalendar dc = new DialogCalendar(this, true);
        dc.setVisible(true);
    }//GEN-LAST:event_mnuCalendarioMouseClicked

    private void mnuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAboutMouseClicked
        DialogAbout da = new DialogAbout(this, true);
        da.setVisible(true);
    }//GEN-LAST:event_mnuAboutMouseClicked

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
            java.util.logging.Logger.getLogger(ProTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceso;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMnuBar;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JMenu mnuAbout;
    private javax.swing.JMenu mnuCalendario;
    private javax.swing.JMenuItem mnuItmLogout;
    private javax.swing.JMenuItem mnuItmSalir;
    private javax.swing.JMenu mnuOpciones;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
