package nerea.protrainer.jDialogs;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dao.UsuarisDAO;
import nerea.protrainer.dao.WorkoutsDAO;
import nerea.protrainer.dto.Usuari;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 *
 * @author Nerea
 */
public class AñadirEntrenamiento extends javax.swing.JDialog {

    private List<Usuari> usuarioList = new ArrayList<>();
    private int selectUsuarioId;

    public AñadirEntrenamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(this);

        usuariosDelInstructor();
        comboBoxUsuarios();
        
        resaltarBotones(btnGuardar);
    }
    
    //----------Método que carga los usuarios en el comboBox----------
    private void usuariosDelInstructor() {

        usuarioList = UsuarisDAO.usuariosAsignadosInstructor();
        DefaultComboBoxModel<Usuari> dcbm = new DefaultComboBoxModel<>();

        for (Usuari u : usuarioList) {
            dcbm.addElement(u);
        }

        cmbBoxUsuario.setModel(dcbm);
    }
    
    //----------Método que inicia el comboBox----------
    private void comboBoxUsuarios() {
        DefaultComboBoxModel<Usuari> dcm = new DefaultComboBoxModel<>();

        Usuari placeholder = new Usuari();
        placeholder.setNom("Selecciona un Usuario...");

        dcm.addElement(placeholder);

        for (Usuari usuario : usuarioList) {
            dcm.addElement(usuario);
        }

        cmbBoxUsuario.setModel(dcm);
        cmbBoxUsuario.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlNuevoEntrenamiento = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        cmbBoxUsuario = new javax.swing.JComboBox<>();
        spnrFecha = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();
        txtFieldComentario = new javax.swing.JTextField();
        lblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPnlNuevoEntrenamiento.setBackground(new java.awt.Color(51, 51, 51));
        jPnlNuevoEntrenamiento.setMinimumSize(new java.awt.Dimension(400, 400));
        jPnlNuevoEntrenamiento.setPreferredSize(new java.awt.Dimension(400, 400));
        jPnlNuevoEntrenamiento.setLayout(null);

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("NUEVO ENTRENAMIENTO");
        jPnlNuevoEntrenamiento.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 400, 60);

        cmbBoxUsuario.setBackground(new java.awt.Color(255, 255, 255));
        cmbBoxUsuario.setEditable(true);
        cmbBoxUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbBoxUsuario.setForeground(new java.awt.Color(0, 0, 0));
        cmbBoxUsuario.setToolTipText("Usuario");
        cmbBoxUsuario.setBorder(null);
        cmbBoxUsuario.setName("Usuari"); // NOI18N
        cmbBoxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxUsuarioActionPerformed(evt);
            }
        });
        jPnlNuevoEntrenamiento.add(cmbBoxUsuario);
        cmbBoxUsuario.setBounds(90, 80, 220, 30);

        spnrFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spnrFecha.setModel(new javax.swing.SpinnerDateModel());
        spnrFecha.setToolTipText("Fecha");
        spnrFecha.setBorder(null);
        jPnlNuevoEntrenamiento.add(spnrFecha);
        spnrFecha.setBounds(90, 140, 220, 30);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPnlNuevoEntrenamiento.add(btnGuardar);
        btnGuardar.setBounds(170, 300, 40, 40);

        txtFieldComentario.setBackground(new java.awt.Color(255, 255, 255));
        txtFieldComentario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldComentario.setForeground(new java.awt.Color(102, 102, 102));
        txtFieldComentario.setText("Añade un comentario...");
        txtFieldComentario.setToolTipText("Comentario");
        txtFieldComentario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldComentarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldComentarioFocusLost(evt);
            }
        });
        jPnlNuevoEntrenamiento.add(txtFieldComentario);
        txtFieldComentario.setBounds(90, 210, 220, 30);

        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPnlNuevoEntrenamiento.add(lblMsg);
        lblMsg.setBounds(50, 260, 290, 30);

        getContentPane().add(jPnlNuevoEntrenamiento);
        jPnlNuevoEntrenamiento.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBoxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxUsuarioActionPerformed

        int selectIndex = cmbBoxUsuario.getSelectedIndex();

        if (selectIndex > 0) {

            Usuari selectUsuario = usuarioList.get(selectIndex - 1);
            selectUsuarioId = selectUsuario.getId();
        }
    }//GEN-LAST:event_cmbBoxUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int selectUsuario = cmbBoxUsuario.getSelectedIndex();

        if (selectUsuario <= 0) {

            lblMsg.setText("Por favor, selecciona un usuario.");
            return;
        }

        Usuari usuario = usuarioList.get(selectUsuario - 1);
        usuario.getId();

        String comentario = txtFieldComentario.getText().trim();

        if (comentario.isEmpty() || comentario.equals("Añade un comentario...")) {
            lblMsg.setText("Debe ingresar un comentario.");
        } else {
            try {

                Date fechaWorkout = (Date) spnrFecha.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaFormateada = sdf.format(fechaWorkout);

                WorkoutsDAO.insertarWorkoutBD(selectUsuarioId, comentario, fechaFormateada);
                JOptionPane.showMessageDialog(this, "Nuevo entrenamiento añadido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el entrenamiento en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFieldComentarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldComentarioFocusGained
        if (txtFieldComentario.getText().equals("Añade un comentario...")) {
            txtFieldComentario.setText("");
        }
    }//GEN-LAST:event_txtFieldComentarioFocusGained

    private void txtFieldComentarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldComentarioFocusLost
        if (txtFieldComentario.getText().isEmpty()) {
            txtFieldComentario.setText("Añade un comentario...");
        }
    }//GEN-LAST:event_txtFieldComentarioFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Usuari> cmbBoxUsuario;
    private javax.swing.JPanel jPnlNuevoEntrenamiento;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spnrFecha;
    private javax.swing.JTextField txtFieldComentario;
    // End of variables declaration//GEN-END:variables
}
