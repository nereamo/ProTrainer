package nerea.protrainer.Formularios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dataAccess.AccionesBD;
import nerea.protrainer.dataAccess.ConsultasBD;
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
        setSize(300, 300);
        setLocationRelativeTo(this);

        comboBoxEntrenamientos();
        iniciarComboBox();
        listaEjercicios();
    }

    //----------Método que inicia el comboBox----------
    private void iniciarComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        model.addElement("---Entrenamiento---");

        for (Workouts workout : workoutList) {
            model.addElement(workout.getComments());
        }

        jCmbBxEntrenamientos.setModel(model);
        jCmbBxEntrenamientos.setSelectedIndex(0);
    }

    //----------Método que muestra los entrenamientos en el comboBox----------
    private void comboBoxEntrenamientos() {

        workoutList = ConsultasBD.workoutsBD();
    }

    //----------Método que muestra una lista de los ejercicios de la base de datos----------
    private void listaEjercicios() {

        ArrayList<Exercicis> ejercicios = ConsultasBD.exercicisBD();

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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("ASIGNAR EJERCICIO");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(0, -2, 300, 50);

        jBttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Save.png"))); // NOI18N
        jBttnGuardar.setBorder(null);
        jBttnGuardar.setContentAreaFilled(false);
        jBttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnGuardar);
        jBttnGuardar.setBounds(140, 210, 24, 24);

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
        jCmbBxEntrenamientos.setBounds(30, 70, 240, 30);

        jScrollPane1.setToolTipText("Ejercicios");

        jLstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jLstEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLstEjercicios.setToolTipText("Ejercicios");
        jLstEjercicios.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jLstEjercicios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 240, 90);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 300, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed

        try {

            if (selectedWorkoutId <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un entrenamiento", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if (selectedExerciseId <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un ejercicio.", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            AccionesBD.asignarEjercicioAWorkout(selectedWorkoutId, selectedExerciseId);
            JOptionPane.showMessageDialog(this, "Ejercicio asignado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al asignar el ejercicio al workout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
