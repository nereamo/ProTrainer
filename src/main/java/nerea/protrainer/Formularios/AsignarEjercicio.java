package nerea.protrainer.Formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dataAccess.DataAccess;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.Workouts;

/**
 *
 * @author Nerea
 */
public class AsignarEjercicio extends javax.swing.JDialog {

    private List<Exercicis> ejerciciosList = new ArrayList<>();
    private List<Workouts> workoutList = new ArrayList<>();
    private int selectedWorkoutId;
    private int selectedExerciseId;

    public AsignarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(this);

        comboBoxEntrenamientos();
        iniciarComboBox();
        listaEjercicios();
    }

    private void iniciarComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        model.addElement("---Entrenamiento---");

        for (Workouts workout : workoutList) {
            model.addElement(workout.getComments());
        }

        jCmbBxEntrenamientos.setModel(model);
        jCmbBxEntrenamientos.setSelectedIndex(0);
    }

    private void comboBoxEntrenamientos() {

        workoutList = Workouts.workoutsBD();
    }

    private void listaEjercicios() {

        ArrayList<Exercicis> ejercicios = Exercicis.exercicisBD();

        ejerciciosList.clear();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Exercicis ejercicio : ejercicios) {
            ejerciciosList.add(ejercicio);
            listModel.addElement(ejercicio.getDescripcio());
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

    public static void saveExerciseInWorkout(int workoutId, int exerciseId) throws SQLException {
        String query = "INSERT INTO ExercicisWorkouts (IdWorkout, IdExercici) VALUES (?, ?)";

        try (Connection conn = DataAccess.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, workoutId);
            stmt.setInt(2, exerciseId);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Workouts.class.getName()).log(Level.SEVERE, "Error al guardar el ejercicio en el workout", ex);
            throw ex;
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLblTitulo.setText("Asignar Ejercicio");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(10, 10, 270, 28);

        jBttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        jBttnGuardar.setBorder(null);
        jBttnGuardar.setContentAreaFilled(false);
        jBttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnGuardar);
        jBttnGuardar.setBounds(170, 210, 25, 25);

        jCmbBxEntrenamientos.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxEntrenamientos.setEditable(true);
        jCmbBxEntrenamientos.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxEntrenamientos.setToolTipText("Entrenamiento");
        jCmbBxEntrenamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBxEntrenamientosActionPerformed(evt);
            }
        });
        jPanel1.add(jCmbBxEntrenamientos);
        jCmbBxEntrenamientos.setBounds(80, 70, 220, 30);

        jScrollPane1.setToolTipText("Ejercicios");

        jLstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jLstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLstEjercicios.setToolTipText("Ejercicios");
        jLstEjercicios.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jLstEjercicios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(80, 110, 220, 90);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed

        try {

            if (selectedWorkoutId <= 0 || selectedExerciseId <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un Workout y un Ejercicio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            saveExerciseInWorkout(selectedWorkoutId, selectedExerciseId);
            JOptionPane.showMessageDialog(this, "Ejercicio añadido al workout correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al añadir el ejercicio al workout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnGuardarActionPerformed

    private void jCmbBxEntrenamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbBxEntrenamientosActionPerformed
        int selectedIndex = jCmbBxEntrenamientos.getSelectedIndex();

        if (selectedIndex > 0 && selectedIndex <= workoutList.size()) {
            Workouts selectedWorkout = workoutList.get(selectedIndex - 1);
            selectedWorkoutId = selectedWorkout.getId();
        } else {
            selectedWorkoutId = -1;
        }
    }//GEN-LAST:event_jCmbBxEntrenamientosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnGuardar;
    private javax.swing.JComboBox<String> jCmbBxEntrenamientos;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList<String> jLstEjercicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
