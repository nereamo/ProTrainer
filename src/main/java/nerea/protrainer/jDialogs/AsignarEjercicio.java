package nerea.protrainer.jDialogs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dao.ExerciciesWorkoutsDAO;
import nerea.protrainer.dao.ExercicisDAO;
import nerea.protrainer.dao.UsuarisDAO;
import nerea.protrainer.dao.WorkoutsDAO;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.dto.Workouts;
import static nerea.protrainer.eventosVisuales.EventosMouse.cambiarCursorEnJList;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 *
 * @author Nerea
 */
public class AsignarEjercicio extends javax.swing.JDialog {

    private List<Exercicis> ejerciciosList = new ArrayList<>();
    private List<Workouts> workoutList = new ArrayList<>();
    private List<Usuari> usuariosList = new ArrayList<>();
    private int selectedWorkoutId;
    private int selectedExerciseId;
    private int selectedUser;
    

    public AsignarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400,400);
        setLocationRelativeTo(this);

        iniciarComboBoxUsuarios();
        listaEjercicios();

        resaltarBotones(jBttnGuardar);
        cambiarCursorEnJList(jLstEjercicios);
    }

    //----------Método que inicia el comboBox de usuarios----------
    private void iniciarComboBoxUsuarios() {

        usuariosList = UsuarisDAO.usuariosAsignadosInstructor();
        
        DefaultComboBoxModel<Usuari> model = new DefaultComboBoxModel<>();
        
        Usuari placeholder = new Usuari();
        placeholder.setNom("Selecciona un usuario...");

        model.addElement(placeholder);

        for (Usuari usuari : usuariosList) {
            model.addElement(usuari);
        }

        jCmbBxUser.setModel(model);
        jCmbBxUser.setSelectedIndex(0);
    }

    //----------Método que inicia el comboBox de Workouts----------
    private void iniciarComboBoxWokouts(int userId) {

        ArrayList<Workouts> workouts = WorkoutsDAO.workoutUsuari(userId);

        workoutList.clear();
        workoutList.addAll(workouts);

        DefaultComboBoxModel<Workouts> model = new DefaultComboBoxModel<>();

        Workouts placeholder = new Workouts();
        placeholder.setComments("Selecciona un workout...");

        model.addElement(placeholder);

        for (Workouts workout : workoutList) {
            model.addElement(workout);
        }

        jCmbBxEntrenamientos.setModel(model);
        jCmbBxEntrenamientos.setSelectedIndex(0);
    }
    

    //----------Método que muestra una lista de los ejercicios de la base de datos----------
    private void listaEjercicios() {

        ArrayList<Exercicis> ejercicios = ExercicisDAO.exercicisBD();

        ejerciciosList.clear();

        DefaultListModel<Exercicis> listModel = new DefaultListModel<>();

        for (Exercicis ejercicio : ejercicios) {
            ejerciciosList.add(ejercicio);
            listModel.addElement(ejercicio);
        }

        jLstEjercicios.setModel(listModel);

        //Fragmento extraído de chatGPT
        jLstEjercicios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = jLstEjercicios.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Exercicis selectedExercise = ejerciciosList.get(selectedIndex);
                        selectedExerciseId = selectedExercise.getId();
                    } else {
                        selectedExerciseId = -1;
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jBttnGuardar = new javax.swing.JButton();
        jCmbBxEntrenamientos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstEjercicios = new javax.swing.JList<>();
        jLblMsg = new javax.swing.JLabel();
        jCmbBxUser = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("ASIGNAR EJERCICIO");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(0, 10, 400, 50);

        jBttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        jBttnGuardar.setBorder(null);
        jBttnGuardar.setContentAreaFilled(false);
        jBttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnGuardar);
        jBttnGuardar.setBounds(170, 310, 40, 40);

        jCmbBxEntrenamientos.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxEntrenamientos.setEditable(true);
        jCmbBxEntrenamientos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCmbBxEntrenamientos.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxEntrenamientos.setToolTipText("Entrenamiento");
        jCmbBxEntrenamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBxEntrenamientosActionPerformed(evt);
            }
        });
        jPanel1.add(jCmbBxEntrenamientos);
        jCmbBxEntrenamientos.setBounds(70, 110, 260, 30);

        jScrollPane1.setToolTipText("Ejercicios");

        jLstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jLstEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLstEjercicios.setToolTipText("Ejercicios");
        jLstEjercicios.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jLstEjercicios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 160, 260, 90);

        jLblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblMsg.setForeground(new java.awt.Color(255, 255, 255));
        jLblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLblMsg);
        jLblMsg.setBounds(40, 260, 310, 40);

        jCmbBxUser.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxUser.setEditable(true);
        jCmbBxUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCmbBxUser.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxUser.setToolTipText("Usuario");
        jCmbBxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBxUserActionPerformed(evt);
            }
        });
        jPanel1.add(jCmbBxUser);
        jCmbBxUser.setBounds(70, 60, 260, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed

        try {
            
            if (selectedUser <= 0) {
                jLblMsg.setText("Por favor, selecciona un usuario");
                return;
            }

            if (selectedWorkoutId <= 0) {
                jLblMsg.setText("Por favor, selecciona un entrenamiento");
                return;
            }
            
            if (selectedExerciseId <= 0) {
                jLblMsg.setText("Por favor, selecciona un ejercicio.");
                return;
            }

            ExerciciesWorkoutsDAO.asignarEjercicioAWorkout(selectedWorkoutId, selectedExerciseId);
            JOptionPane.showMessageDialog(this, "Ejercicio asignado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al asignar el ejercicio al workout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnGuardarActionPerformed

    private void jCmbBxEntrenamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbBxEntrenamientosActionPerformed

        int selectedIndex = jCmbBxEntrenamientos.getSelectedIndex();

        if (selectedIndex > 0) { // Evita seleccionar el placeholder
            Workouts selectedWorkout = (Workouts) jCmbBxEntrenamientos.getSelectedItem();
            selectedWorkoutId = selectedWorkout.getId();
        } else {
            selectedWorkoutId = -1; // Valor inválido si no se seleccionó uno real
        }
    }//GEN-LAST:event_jCmbBxEntrenamientosActionPerformed

    private void jCmbBxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbBxUserActionPerformed
        int selectedIndex = jCmbBxUser.getSelectedIndex();

        if (selectedIndex > 0) {

            Usuari selectedUserId = usuariosList.get(selectedIndex - 1);
            selectedUser = selectedUserId.getId();

            iniciarComboBoxWokouts(selectedUser);

        }
    }//GEN-LAST:event_jCmbBxUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnGuardar;
    private javax.swing.JComboBox<Workouts> jCmbBxEntrenamientos;
    private javax.swing.JComboBox<Usuari> jCmbBxUser;
    private javax.swing.JLabel jLblMsg;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList<Exercicis> jLstEjercicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
