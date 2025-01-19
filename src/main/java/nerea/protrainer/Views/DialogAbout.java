package nerea.protrainer.Views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nerea
 */
public class DialogAbout extends javax.swing.JDialog {

    public DialogAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(450,200);
        setLocationRelativeTo(this);
        
        //Texto que se mostrará en el 'About'
        String aboutText = "<html><h2>Nerea Montoya</h2>" +
                           "<p>Curso: DAM</p>" +
                           "<p>Módulo: Desarrollo de Interfaces</p>" +
                           "<p>TrainMaster, aplicación que permite gestionar entrenamientos y ejercicios.</p></html>";
        
       jLblAbout.setText(aboutText);
       jLblAbout.setVerticalAlignment(JLabel.TOP);
        

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(closeButton);
        add(panel, BorderLayout.SOUTH);
        
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlAbout = new javax.swing.JPanel();
        jLblAbout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 150));
        setPreferredSize(new java.awt.Dimension(450, 150));
        getContentPane().setLayout(null);

        jPnlAbout.setBackground(new java.awt.Color(0, 204, 204));
        jPnlAbout.setMinimumSize(new java.awt.Dimension(450, 200));
        jPnlAbout.setPreferredSize(new java.awt.Dimension(450, 200));
        jPnlAbout.setLayout(null);

        jLblAbout.setForeground(new java.awt.Color(51, 51, 51));
        jPnlAbout.add(jLblAbout);
        jLblAbout.setBounds(19, 21, 420, 160);

        getContentPane().add(jPnlAbout);
        jPnlAbout.setBounds(0, 0, 450, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblAbout;
    private javax.swing.JPanel jPnlAbout;
    // End of variables declaration//GEN-END:variables
}
