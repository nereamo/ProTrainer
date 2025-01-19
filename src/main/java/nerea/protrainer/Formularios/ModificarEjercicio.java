package nerea.protrainer.Formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dataAccess.DataAccess;
import nerea.protrainer.dto.Exercicis;

/**
 *
 * @author Nerea
 */
public class ModificarEjercicio extends javax.swing.JDialog {

    private List<Exercicis> ejerciciosList;
    private Exercicis exercise;

    public ModificarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(this);

        comboBoxEjercicios();
        iniciarComboBox();
    }

    private void iniciarComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        model.addElement("---Ejercicio---");

        for (Exercicis ejercicios : ejerciciosList) {
            model.addElement(ejercicios.getNomExercici() + " - " + ejercicios.getDescripcio());
        }

        jCmbBxEjercicios.setModel(model);
        jCmbBxEjercicios.setSelectedIndex(0);

        jCmbBxEjercicios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedIndex = jCmbBxEjercicios.getSelectedIndex();
                if (selectedIndex > 0) {
                    exercise = ejerciciosList.get(selectedIndex - 1);

                    jTxtFldNombreEjercicio.setText(exercise.getNomExercici());
                    jTxtFldDescripcion.setText(exercise.getDescripcio());
                } else {
                    exercise = null;
                    jTxtFldNombreEjercicio.setText("Nuevo nombre");
                    jTxtFldDescripcion.setText("Descripcion");
                }
            }
        });
    }
    
    private void comboBoxEjercicios() {

        ejerciciosList = Exercicis.exercicisBD();
    }

    private boolean updateExerciseInDatabase(Exercicis exercise) {

        try (Connection conn = DataAccess.getConnection()) {
            String sql = "UPDATE Exercicis SET NomExercici = ?, Descripcio = ? WHERE Id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, exercise.getNomExercici());
                pstmt.setString(2, exercise.getDescripcio());
                pstmt.setInt(3, exercise.getId()); // Suponiendo que el ID está en el objeto exercise
                int affectedRows = pstmt.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jCmbBxEjercicios = new javax.swing.JComboBox<>();
        jBttnGuardar = new javax.swing.JButton();
        jTxtFldNombreEjercicio = new javax.swing.JTextField();
        jTxtFldDescripcion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLblTitulo.setText("Modificar Ejercicio");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(10, 10, 270, 28);

        jCmbBxEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxEjercicios.setEditable(true);
        jCmbBxEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCmbBxEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxEjercicios.setToolTipText("Ejercicio");
        jPanel1.add(jCmbBxEjercicios);
        jCmbBxEjercicios.setBounds(70, 60, 230, 30);

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

        jTxtFldNombreEjercicio.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldNombreEjercicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldNombreEjercicio.setForeground(new java.awt.Color(102, 102, 102));
        jTxtFldNombreEjercicio.setText("Nuevo nombre");
        jTxtFldNombreEjercicio.setToolTipText("Nuevo nombre ejercicio");
        jTxtFldNombreEjercicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtFldNombreEjercicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFldNombreEjercicioFocusLost(evt);
            }
        });
        jPanel1.add(jTxtFldNombreEjercicio);
        jTxtFldNombreEjercicio.setBounds(70, 110, 230, 30);

        jTxtFldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        jTxtFldDescripcion.setText("Descripcion");
        jTxtFldDescripcion.setToolTipText("Descripcion");
        jTxtFldDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtFldDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFldDescripcionFocusLost(evt);
            }
        });
        jPanel1.add(jTxtFldDescripcion);
        jTxtFldDescripcion.setBounds(70, 160, 230, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFldNombreEjercicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldNombreEjercicioFocusGained
        if (jTxtFldNombreEjercicio.getText().equals("Nuevo nombre")) {
            jTxtFldNombreEjercicio.setText("");
        }
    }//GEN-LAST:event_jTxtFldNombreEjercicioFocusGained

    private void jTxtFldNombreEjercicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldNombreEjercicioFocusLost
        if (jTxtFldNombreEjercicio.getText().isEmpty()) {
            jTxtFldNombreEjercicio.setText("Nuevo nombre");
        }
    }//GEN-LAST:event_jTxtFldNombreEjercicioFocusLost

    private void jTxtFldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldDescripcionFocusGained
        if (jTxtFldDescripcion.getText().equals("Descripcion")) {
            jTxtFldDescripcion.setText("");
        }
    }//GEN-LAST:event_jTxtFldDescripcionFocusGained

    private void jTxtFldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldDescripcionFocusLost
        if (jTxtFldDescripcion.getText().isEmpty()) {
            jTxtFldDescripcion.setText("Descripcion");
        }
    }//GEN-LAST:event_jTxtFldDescripcionFocusLost

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed
        String nuevoNombre = jTxtFldNombreEjercicio.getText();
        String nuevaDescripcion = jTxtFldDescripcion.getText();

        if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y descripción no pueden estar vacíos", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        exercise.setNomExercici(nuevoNombre);
        exercise.setDescripcio(nuevaDescripcion);

        if (updateExerciseInDatabase(exercise)) {
            JOptionPane.showMessageDialog(this, "Ejercicio Modificado correctamente!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar, vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBttnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnGuardar;
    private javax.swing.JComboBox<String> jCmbBxEjercicios;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtFldDescripcion;
    private javax.swing.JTextField jTxtFldNombreEjercicio;
    // End of variables declaration//GEN-END:variables
}
