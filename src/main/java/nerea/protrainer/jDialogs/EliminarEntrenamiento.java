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

    private List<Usuari> userList = new ArrayList<>();
    private List<Integer> workoutList = new ArrayList<>();
    private int userId;
    private Point mousePos = null;

    public EliminarEntrenamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(this);

        usuariosDeInstructor();
        iniciarComboBox();
        
        cambiarCursorEnJList(jLstEntrenamientos);
        resaltarBotones(jBttnEliminar);
    }

    //----------Método que carga los usuarios en el comboBox----------
    private void usuariosDeInstructor() {

        userList = UsuarisDAO.usuariosAsignadosInstructor();
        DefaultComboBoxModel<Usuari> dcbm = new DefaultComboBoxModel<>();

        for (Usuari usuario : userList) {
            dcbm.addElement(usuario);
        }

        jCmbBxUsuario.setModel(dcbm);
    }

    //----------Método que mustre los entrenamientos asignado a un usuario en la lista----------
    private void listaEntrenamientos(int userId) {

        ArrayList<Workouts> workouts = WorkoutsDAO.workoutUsuari(userId);

        workoutList.clear();

        DefaultListModel<Workouts> listModel = new DefaultListModel<>();

        for (Workouts workout : workouts) {
            workoutList.add(workout.getId());
            listModel.addElement(workout);
        }

        jLstEntrenamientos.setModel(listModel);

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

        jPanel1 = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jCmbBxUsuario = new javax.swing.JComboBox<>();
        jBttnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstEntrenamientos = new javax.swing.JList<>();
        jLblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("ELIMINAR ENTRENAMIENTO");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(0, 10, 400, 50);

        jCmbBxUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxUsuario.setEditable(true);
        jCmbBxUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCmbBxUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxUsuario.setToolTipText("Usuario");
        jCmbBxUsuario.setBorder(null);
        jCmbBxUsuario.setName(""); // NOI18N
        jCmbBxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBxUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jCmbBxUsuario);
        jCmbBxUsuario.setBounds(90, 70, 210, 30);

        jBttnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        jBttnEliminar.setBorder(null);
        jBttnEliminar.setContentAreaFilled(false);
        jBttnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnEliminar);
        jBttnEliminar.setBounds(164, 310, 40, 40);

        jLstEntrenamientos.setBackground(new java.awt.Color(255, 255, 255));
        jLstEntrenamientos.setBorder(null);
        jLstEntrenamientos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLstEntrenamientos.setForeground(new java.awt.Color(0, 0, 0));
        jLstEntrenamientos.setToolTipText("Entrenamiento");
        jLstEntrenamientos.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(jLstEntrenamientos);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 130, 330, 120);

        jLblMsg.setForeground(new java.awt.Color(255, 255, 255));
        jLblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLblMsg);
        jLblMsg.setBounds(40, 270, 320, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbBxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbBxUsuarioActionPerformed

        int selectedIndex = jCmbBxUsuario.getSelectedIndex();

        if (selectedIndex > 0) {

            Usuari selectedUser = userList.get(selectedIndex - 1);  // Ajustar el índice si "Usuario" está en la primera posición
            userId = selectedUser.getId();
            listaEntrenamientos(userId);
        }
    }//GEN-LAST:event_jCmbBxUsuarioActionPerformed

    private void jBttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEliminarActionPerformed

        int seleccionarUsario = jCmbBxUsuario.getSelectedIndex();

        if (seleccionarUsario <= 0) {

           jLblMsg.setText("Por favor, selecciona un usuario.");
            return;
        }
        
        userList.get(seleccionarUsario - 1);

        int selectedWorkoutIndex = jLstEntrenamientos.getSelectedIndex();

        if (selectedWorkoutIndex == -1) {
            jLblMsg.setText("Por favor, selecciona un entrenamiento." );
            return;
        }

        int woorkoutId = workoutList.get(selectedWorkoutIndex);

        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar el Workout?", "Confirm Deletion", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {

            boolean success = WorkoutsDAO.eliminarWorkoutBD(woorkoutId);

            if (success) {

                workoutList.remove(selectedWorkoutIndex);
                javax.swing.JOptionPane.showMessageDialog(this, "Entrenamiento eliminado correctamente!");
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el entrenamiento.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBttnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnEliminar;
    private javax.swing.JComboBox<Usuari> jCmbBxUsuario;
    private javax.swing.JLabel jLblMsg;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList<Workouts> jLstEntrenamientos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
