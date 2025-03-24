package nerea.protrainer.jDialogs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dao.ExercicisWorkoutsDAO;
import nerea.protrainer.dao.ExercicisDAO;
import nerea.protrainer.dao.UsuarisDAO;
import nerea.protrainer.dao.WorkoutsDAO;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.dto.Workouts;
import static nerea.protrainer.eventosVisuales.EventosMouse.cambiarCursorEnJList;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 * @author Nerea
 */
public class AsignarEjercicio extends javax.swing.JDialog {

    private List<Exercicis> ejerciciosList = new ArrayList<>();
    private List<Workouts> workoutList = new ArrayList<>();
    private List<Usuari> usuariosList = new ArrayList<>();
    private int seleccionarWorkoutId;
    private int seleccionarEjercicioId;
    private int seleccionarUsuarioId;
    
    public AsignarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400,400);
        setLocationRelativeTo(this);

        comboBoxUsuarios();
        listaEjercicios();

        resaltarBotones(btnGuardar);
        cambiarCursorEnJList(lstEjercicios);
    }

    //----------Método que inicia el comboBox de usuarios----------
    private void comboBoxUsuarios() {

        usuariosList = UsuarisDAO.usuariosAsignadosInstructor();
        
        DefaultComboBoxModel<Usuari> dcm = new DefaultComboBoxModel<>();
        
        Usuari placeholder = new Usuari();
        placeholder.setNom("Selecciona un usuario...");

        dcm.addElement(placeholder);

        for (Usuari usuari : usuariosList) {
            dcm.addElement(usuari);
        }

        cmbBoxUsuarios.setModel(dcm);
        cmbBoxUsuarios.setSelectedIndex(0);
    }

    //----------Método que inicia el comboBox de Workouts----------
    private void comboBoxWokouts(int userId) {

        ArrayList<Workouts> workoutsList = WorkoutsDAO.workoutUsuari(userId);

        workoutList.clear();
        workoutList.addAll(workoutsList);

        DefaultComboBoxModel<Workouts> dcm = new DefaultComboBoxModel<>();

        Workouts placeholder = new Workouts();
        placeholder.setComments("Selecciona un workout...");

        dcm.addElement(placeholder);

        for (Workouts workout : workoutList) {
            dcm.addElement(workout);
        }

        cmbBoxWorkouts.setModel(dcm);
        cmbBoxWorkouts.setSelectedIndex(0);
    }
    
    //----------Método que muestra una lista de los ejercicios de la base de datos----------
    private void listaEjercicios() {

        ArrayList<Exercicis> ejercicios = ExercicisDAO.exercicisBD();

        ejerciciosList.clear();

        DefaultListModel<Exercicis> dlm = new DefaultListModel<>();

        for (Exercicis ejercicio : ejercicios) {
            ejerciciosList.add(ejercicio);
            dlm.addElement(ejercicio);
        }

        lstEjercicios.setModel(dlm);

        //Fragmento extraído de chatGPT
        lstEjercicios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = lstEjercicios.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Exercicis selectedExercise = ejerciciosList.get(selectedIndex);
                        seleccionarEjercicioId = selectedExercise.getId();
                    } else {
                        seleccionarEjercicioId = -1;
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        cmbBoxWorkouts = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEjercicios = new javax.swing.JList<>();
        lblMsg = new javax.swing.JLabel();
        cmbBoxUsuarios = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ASIGNAR EJERCICIO");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 400, 50);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(170, 310, 40, 40);

        cmbBoxWorkouts.setBackground(new java.awt.Color(255, 255, 255));
        cmbBoxWorkouts.setEditable(true);
        cmbBoxWorkouts.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbBoxWorkouts.setForeground(new java.awt.Color(0, 0, 0));
        cmbBoxWorkouts.setToolTipText("Entrenamiento");
        cmbBoxWorkouts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxWorkoutsActionPerformed(evt);
            }
        });
        jPanel1.add(cmbBoxWorkouts);
        cmbBoxWorkouts.setBounds(70, 110, 260, 30);

        jScrollPane1.setToolTipText("Ejercicios");

        lstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        lstEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        lstEjercicios.setToolTipText("Ejercicios");
        lstEjercicios.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(lstEjercicios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 160, 260, 90);

        lblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMsg);
        lblMsg.setBounds(40, 260, 310, 40);

        cmbBoxUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        cmbBoxUsuarios.setEditable(true);
        cmbBoxUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbBoxUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        cmbBoxUsuarios.setToolTipText("Usuario");
        cmbBoxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(cmbBoxUsuarios);
        cmbBoxUsuarios.setBounds(70, 60, 260, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            
            if (seleccionarUsuarioId <= 0) {
                lblMsg.setText("Por favor, selecciona un usuario");
                return;
            }

            if (seleccionarWorkoutId <= 0) {
                lblMsg.setText("Por favor, selecciona un entrenamiento");
                return;
            }
            
            if (seleccionarEjercicioId <= 0) {
                lblMsg.setText("Por favor, selecciona un ejercicio.");
                return;
            }

            ExercicisWorkoutsDAO.asignarEjercicioAWorkout(seleccionarWorkoutId, seleccionarEjercicioId);
            JOptionPane.showMessageDialog(this, "Ejercicio asignado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al asignar el ejercicio al workout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbBoxWorkoutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxWorkoutsActionPerformed

        int selectIndex = cmbBoxWorkouts.getSelectedIndex();

        if (selectIndex > 0) {
            Workouts selectWorkout = (Workouts) cmbBoxWorkouts.getSelectedItem();
            seleccionarWorkoutId = selectWorkout.getId();
        } else {
            seleccionarWorkoutId = -1;
        }
    }//GEN-LAST:event_cmbBoxWorkoutsActionPerformed

    private void cmbBoxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxUsuariosActionPerformed
        int selectIndex = cmbBoxUsuarios.getSelectedIndex();

        if (selectIndex > 0) {

            Usuari selectUsuario = usuariosList.get(selectIndex - 1);
            seleccionarUsuarioId = selectUsuario.getId();

            comboBoxWokouts(seleccionarUsuarioId);

        }
    }//GEN-LAST:event_cmbBoxUsuariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Usuari> cmbBoxUsuarios;
    private javax.swing.JComboBox<Workouts> cmbBoxWorkouts;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Exercicis> lstEjercicios;
    // End of variables declaration//GEN-END:variables
}
