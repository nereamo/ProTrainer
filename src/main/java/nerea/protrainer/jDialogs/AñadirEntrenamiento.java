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

    private List<Usuari> userList = new ArrayList<>();
    private int selectedUserId;

    public AñadirEntrenamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(this);

        usuariosInstructor();
        iniciarComboBox();
        
        resaltarBotones(jBttnGuardar);
    }
    
    //----------Método que carga los usuarios en el comboBox----------
    private void usuariosInstructor() {

        userList = UsuarisDAO.usuariosAsignadosInstructor();
        DefaultComboBoxModel<Usuari> dcbm = new DefaultComboBoxModel<>();

        for (Usuari u : userList) {
            dcbm.addElement(u);
        }

        jCmbBxUsuario.setModel(dcbm);
    }
    
    //----------Método que inicia el comboBox----------
    private void iniciarComboBox() {
        DefaultComboBoxModel<Usuari> model = new DefaultComboBoxModel<>();

        Usuari placeholder = new Usuari();
        placeholder.setNom("Selecciona un Usuario...");

        model.addElement(placeholder);

        for (Usuari usuario : userList) {
            model.addElement(usuario);
        }

        jCmbBxUsuario.setModel(model);
        jCmbBxUsuario.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlNuevoEntrenamiento = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jCmbBxUsuario = new javax.swing.JComboBox<>();
        jSpnnrFecha = new javax.swing.JSpinner();
        jBttnGuardar = new javax.swing.JButton();
        jTxtFldComentario = new javax.swing.JTextField();
        jLblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPnlNuevoEntrenamiento.setBackground(new java.awt.Color(51, 51, 51));
        jPnlNuevoEntrenamiento.setMinimumSize(new java.awt.Dimension(400, 400));
        jPnlNuevoEntrenamiento.setPreferredSize(new java.awt.Dimension(400, 400));
        jPnlNuevoEntrenamiento.setLayout(null);

        jLblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        jLblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("NUEVO ENTRENAMIENTO");
        jPnlNuevoEntrenamiento.add(jLblTitulo);
        jLblTitulo.setBounds(0, 10, 400, 60);

        jCmbBxUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxUsuario.setEditable(true);
        jCmbBxUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCmbBxUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxUsuario.setToolTipText("Usuario");
        jCmbBxUsuario.setBorder(null);
        jCmbBxUsuario.setName("Usuari"); // NOI18N
        jCmbBxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBxUsuarioActionPerformed(evt);
            }
        });
        jPnlNuevoEntrenamiento.add(jCmbBxUsuario);
        jCmbBxUsuario.setBounds(90, 80, 220, 30);

        jSpnnrFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jSpnnrFecha.setModel(new javax.swing.SpinnerDateModel());
        jSpnnrFecha.setToolTipText("Fecha");
        jSpnnrFecha.setBorder(null);
        jPnlNuevoEntrenamiento.add(jSpnnrFecha);
        jSpnnrFecha.setBounds(90, 140, 220, 30);

        jBttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        jBttnGuardar.setBorder(null);
        jBttnGuardar.setContentAreaFilled(false);
        jBttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnGuardarActionPerformed(evt);
            }
        });
        jPnlNuevoEntrenamiento.add(jBttnGuardar);
        jBttnGuardar.setBounds(170, 300, 40, 40);

        jTxtFldComentario.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldComentario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldComentario.setForeground(new java.awt.Color(102, 102, 102));
        jTxtFldComentario.setText("Añade un comentario...");
        jTxtFldComentario.setToolTipText("Comentario");
        jTxtFldComentario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtFldComentarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFldComentarioFocusLost(evt);
            }
        });
        jPnlNuevoEntrenamiento.add(jTxtFldComentario);
        jTxtFldComentario.setBounds(90, 210, 220, 30);

        jLblMsg.setForeground(new java.awt.Color(255, 255, 255));
        jLblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPnlNuevoEntrenamiento.add(jLblMsg);
        jLblMsg.setBounds(50, 260, 290, 30);

        getContentPane().add(jPnlNuevoEntrenamiento);
        jPnlNuevoEntrenamiento.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbBxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbBxUsuarioActionPerformed

        int selectedIndex = jCmbBxUsuario.getSelectedIndex();

        if (selectedIndex > 0) {

            Usuari selectedUser = userList.get(selectedIndex - 1);
            selectedUserId = selectedUser.getId();
        }
    }//GEN-LAST:event_jCmbBxUsuarioActionPerformed

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed
        int seleccionarUsario = jCmbBxUsuario.getSelectedIndex();

        if (seleccionarUsario <= 0) {

            jLblMsg.setText("Por favor, selecciona un usuario.");
            return;
        }

        Usuari usuario = userList.get(seleccionarUsario - 1);
        usuario.getId();

        String comment = jTxtFldComentario.getText().trim();

        if (comment.isEmpty() || comment.equals("Añade un comentario...")) {
            jLblMsg.setText("Debe ingresar un comentario.");
        } else {
            try {

                Date dateWork = (Date) jSpnnrFecha.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaFormateada = dateFormat.format(dateWork);

                WorkoutsDAO.insertarWorkoutBD(selectedUserId, comment, fechaFormateada);
                JOptionPane.showMessageDialog(this, "Nuevo entrenamiento añadido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el entrenamiento en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBttnGuardarActionPerformed

    private void jTxtFldComentarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldComentarioFocusGained
        if (jTxtFldComentario.getText().equals("Añade un comentario...")) {
            jTxtFldComentario.setText("");
        }
    }//GEN-LAST:event_jTxtFldComentarioFocusGained

    private void jTxtFldComentarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldComentarioFocusLost
        if (jTxtFldComentario.getText().isEmpty()) {
            jTxtFldComentario.setText("Añade un comentario...");
        }
    }//GEN-LAST:event_jTxtFldComentarioFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnGuardar;
    private javax.swing.JComboBox<Usuari> jCmbBxUsuario;
    private javax.swing.JLabel jLblMsg;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPnlNuevoEntrenamiento;
    private javax.swing.JSpinner jSpnnrFecha;
    private javax.swing.JTextField jTxtFldComentario;
    // End of variables declaration//GEN-END:variables
}
