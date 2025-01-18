package nerea.protrainer;

import javax.swing.JOptionPane;
import nerea.protrainer.Views.DialogAbout;
import nerea.protrainer.Views.LoginDialog;
import nerea.protrainer.Views.PanelMenu;
import nerea.protrainer.dto.Usuari;
/**
 *
 * @author Nerea
 */
public class ProTrainer extends javax.swing.JFrame {
    
    private PanelMenu panelMenu;
    private static Usuari loggedInstructor;
    
    public ProTrainer() {
        initComponents();
        setSize(950, 620);
        setLocationRelativeTo(this);

        panelMenu = new PanelMenu(this); //Instancia del JPanelUSers
        getContentPane().add(panelMenu);
        panelMenu.setVisible(false); //Ocultar inicialmente   
        
    }
    
    public void setLoggedInstructor(Usuari instructor) {
        this.loggedInstructor = instructor; 
    }

    public static Usuari getLoggedInstructor() {
        return loggedInstructor; 
    }
    
    public void showPanel() {

        PanelMenu pnlWorkouts = new PanelMenu(this);
        this.getContentPane().removeAll();
        this.getContentPane().add(pnlWorkouts);
        this.revalidate();
        this.repaint();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPnlMain = new javax.swing.JPanel();
        jLblWeb = new javax.swing.JLabel();
        jBttnAccess = new javax.swing.JButton();
        jLblIcon = new javax.swing.JLabel();
        jMnuBar = new javax.swing.JMenuBar();
        jMnuMenu = new javax.swing.JMenu();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMnuAbout = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPnlMain.setBackground(new java.awt.Color(255, 255, 255));
        jPnlMain.setMinimumSize(new java.awt.Dimension(950, 620));
        jPnlMain.setLayout(null);

        jLblWeb.setBackground(new java.awt.Color(0, 0, 0));
        jLblWeb.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLblWeb.setForeground(new java.awt.Color(0, 0, 0));
        jLblWeb.setText("Visita nuestro sitio Web");
        jLblWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblWebMouseClicked(evt);
            }
        });
        jPnlMain.add(jLblWeb);
        jLblWeb.setBounds(740, 500, 170, 20);

        jBttnAccess.setForeground(new java.awt.Color(0, 0, 0));
        jBttnAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario1.png"))); // NOI18N
        jBttnAccess.setBorder(null);
        jBttnAccess.setBorderPainted(false);
        jBttnAccess.setContentAreaFilled(false);
        jBttnAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAccessActionPerformed(evt);
            }
        });
        jPnlMain.add(jBttnAccess);
        jBttnAccess.setBounds(400, 450, 140, 90);

        jLblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PRO.png"))); // NOI18N
        jPnlMain.add(jLblIcon);
        jLblIcon.setBounds(210, 80, 510, 210);

        getContentPane().add(jPnlMain);
        jPnlMain.setBounds(0, 0, 950, 590);

        jMnuBar.setBackground(new java.awt.Color(0, 0, 0));
        jMnuBar.setBorder(null);
        jMnuBar.setForeground(new java.awt.Color(255, 255, 255));
        jMnuBar.setBorderPainted(false);
        jMnuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMnuBar.setEnabled(false);
        jMnuBar.setOpaque(true);

        jMnuMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list.png"))); // NOI18N
        jMnuMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuMenu.setMaximumSize(new java.awt.Dimension(60, 60));
        jMnuMenu.setPreferredSize(new java.awt.Dimension(38, 38));

        jMenuItemLogout.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItemLogout.setText("LogOut");
        jMenuItemLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMnuMenu.add(jMenuItemLogout);

        jMenuItemExit.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMnuMenu.add(jMenuItemExit);

        jMnuBar.add(jMnuMenu);

        jMnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        jMnuAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMnuAbout.setMinimumSize(new java.awt.Dimension(38, 38));
        jMnuAbout.setPreferredSize(new java.awt.Dimension(38, 38));

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMnuAbout.add(jMenuItemAbout);

        jMnuBar.add(jMnuAbout);

        setJMenuBar(jMnuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        this.getContentPane().removeAll();
        this.getContentPane().add(jPnlMain);

        jPnlMain.setVisible(true);

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jBttnAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnAccessActionPerformed
        LoginDialog buttonAcces = new LoginDialog(this, true); 
        buttonAcces.setVisible(true);
    }//GEN-LAST:event_jBttnAccessActionPerformed

    private void jLblWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblWebMouseClicked
         try {
           
            String url = "http://www.ejemplo.com"; 
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url)); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLblWebMouseClicked

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar la aplicación?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        
        DialogAbout aboutDialog = new DialogAbout(this, true);
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    
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
    private javax.swing.JButton jBttnAccess;
    private javax.swing.JLabel jLblIcon;
    private javax.swing.JLabel jLblWeb;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenu jMnuAbout;
    private javax.swing.JMenuBar jMnuBar;
    private javax.swing.JMenu jMnuMenu;
    private javax.swing.JPanel jPnlMain;
    // End of variables declaration//GEN-END:variables
}
