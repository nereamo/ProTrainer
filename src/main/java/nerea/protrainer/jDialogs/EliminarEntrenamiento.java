package nerea.protrainer.jDialogs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import nerea.protrainer.dao.UsuarisDAO;
import nerea.protrainer.dao.WorkoutsDAO;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.dto.Workouts;
import static nerea.protrainer.eventosVisuales.EventosMouse.cambiarCursorEnJList;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 *
 * @author Nerea
 */
public class EliminarEntrenamiento extends javax.swing.JDialog {

    private List<Usuari> usuariosList = new ArrayList<>();
    private List<Integer> workoutList = new ArrayList<>();
    private int usuarioId;
    private Point mousePos = null;

    public EliminarEntrenamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(this);

        usuariosDeInstructor();
        comboBoxUsuarios();
        
        cambiarCursorEnJList(lstWorkouts);
        resaltarBotones(btnEliminar);
    }

    //----------Método que carga los usuarios en el comboBox----------
    private void usuariosDeInstructor() {

        usuariosList = UsuarisDAO.usuariosAsignadosInstructor();
        DefaultComboBoxModel<Usuari> dcbm = new DefaultComboBoxModel<>();

        for (Usuari usuario : usuariosList) {
            dcbm.addElement(usuario);
        }

        cmbBoxUsuario.setModel(dcbm);
    }

    //----------Método que mustre los entrenamientos asignado a un usuario en la lista----------
    private void listaEntrenamientos(int userId) {

        ArrayList<Workouts> workouts = WorkoutsDAO.workoutUsuari(userId);

        workoutList.clear();

        DefaultListModel<Workouts> dlm = new DefaultListModel<>();

        for (Workouts workout : workouts) {
            workoutList.add(workout.getId());
            dlm.addElement(workout);
        }

        lstWorkouts.setModel(dlm);

    }

    //----------Método que inicia el comboBox----------
    private void comboBoxUsuarios() {
        DefaultComboBoxModel<Usuari> dcm = new DefaultComboBoxModel<>();
        
        Usuari placeholder = new Usuari();
        placeholder.setNom("Selecciona un Usuario...");
        dcm.addElement(placeholder);

        for (Usuari usuario : usuariosList) {
            dcm.addElement(usuario);
        }

        cmbBoxUsuario.setModel(dcm);
        cmbBoxUsuario.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        cmbBoxUsuario = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstWorkouts = new javax.swing.JList<>();
        lblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ELIMINAR ENTRENAMIENTO");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 400, 50);

        cmbBoxUsuario.setBackground(new java.awt.Color(255, 255, 255));
        cmbBoxUsuario.setEditable(true);
        cmbBoxUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbBoxUsuario.setForeground(new java.awt.Color(0, 0, 0));
        cmbBoxUsuario.setToolTipText("Usuario");
        cmbBoxUsuario.setBorder(null);
        cmbBoxUsuario.setName(""); // NOI18N
        cmbBoxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(cmbBoxUsuario);
        cmbBoxUsuario.setBounds(30, 70, 330, 30);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(164, 310, 40, 40);

        lstWorkouts.setBackground(new java.awt.Color(255, 255, 255));
        lstWorkouts.setBorder(null);
        lstWorkouts.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lstWorkouts.setForeground(new java.awt.Color(0, 0, 0));
        lstWorkouts.setToolTipText("Entrenamiento");
        lstWorkouts.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(lstWorkouts);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 130, 330, 120);

        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMsg);
        lblMsg.setBounds(40, 270, 320, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBoxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxUsuarioActionPerformed

        int selectIndex = cmbBoxUsuario.getSelectedIndex();

        if (selectIndex > 0 && selectIndex - 1 < usuariosList.size()) {

            Usuari selectUsuario = usuariosList.get(selectIndex - 1);
            usuarioId = selectUsuario.getId();
            listaEntrenamientos(usuarioId);
        }
    }//GEN-LAST:event_cmbBoxUsuarioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int selectUsuario = cmbBoxUsuario.getSelectedIndex();

        if (selectUsuario <= 0) {
           lblMsg.setText("Por favor, selecciona un usuario.");
           return;
        }

        int selectWorkout = lstWorkouts.getSelectedIndex();

        if (selectWorkout == -1) {
            lblMsg.setText("Por favor, selecciona un entrenamiento." );
            return;
        }

        int workoutId = workoutList.get(selectWorkout);

        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar el Workout?", "Confirm Deletion", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {

            boolean completado = WorkoutsDAO.eliminarWorkoutBD(workoutId);

            if (completado) {

                workoutList.remove(selectWorkout);
                javax.swing.JOptionPane.showMessageDialog(this, "Entrenamiento eliminado correctamente!");
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No puede eliminarse un entrenamiento que tiene ejercicios asignados.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<Usuari> cmbBoxUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Workouts> lstWorkouts;
    // End of variables declaration//GEN-END:variables
}
