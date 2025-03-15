package nerea.protrainer.Formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dataAccess.AccionesBD;
import nerea.protrainer.dataAccess.ConsultasBD;
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
        setSize(300, 300);
        setLocationRelativeTo(this);
        
        this.exercise = new Exercicis();

        comboBoxEjercicios();
        iniciarComboBox();
    }

    //----------Método que carga el combobox al iniciar----------
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
                }
            }
        });
    }

    //----------Metodo que muestra los ejercicios en el combobox----------
    private void comboBoxEjercicios() {

        ejerciciosList = ConsultasBD.exercicisBD();
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
        setModal(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jLblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        jLblTitulo.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("MODIFICAR EJERCICIO");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(0, 0, 300, 50);

        jCmbBxEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jCmbBxEjercicios.setEditable(true);
        jCmbBxEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCmbBxEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jCmbBxEjercicios.setToolTipText("Ejercicio");
        jPanel1.add(jCmbBxEjercicios);
        jCmbBxEjercicios.setBounds(30, 60, 230, 30);

        jBttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Save.png"))); // NOI18N
        jBttnGuardar.setBorder(null);
        jBttnGuardar.setContentAreaFilled(false);
        jBttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnGuardar);
        jBttnGuardar.setBounds(130, 210, 25, 25);

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
        jTxtFldNombreEjercicio.setBounds(30, 110, 230, 30);

        jTxtFldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        jTxtFldDescripcion.setText("Nueva descripcion");
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
        jTxtFldDescripcion.setBounds(30, 160, 230, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 300, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFldNombreEjercicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldNombreEjercicioFocusGained
        if (jTxtFldNombreEjercicio.getText().equals(exercise.getNomExercici())) {
            jTxtFldNombreEjercicio.setText("");
        }
    }//GEN-LAST:event_jTxtFldNombreEjercicioFocusGained

    private void jTxtFldNombreEjercicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldNombreEjercicioFocusLost
        if (jTxtFldNombreEjercicio.getText().isEmpty()) {
            jTxtFldNombreEjercicio.setText(exercise.getNomExercici());
        }
    }//GEN-LAST:event_jTxtFldNombreEjercicioFocusLost

    private void jTxtFldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldDescripcionFocusGained
        if (jTxtFldDescripcion.getText().equals(exercise.getDescripcio())) {
            jTxtFldDescripcion.setText("");
        }
    }//GEN-LAST:event_jTxtFldDescripcionFocusGained

    private void jTxtFldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldDescripcionFocusLost
        if (jTxtFldDescripcion.getText().isEmpty()) {
            jTxtFldDescripcion.setText(exercise.getDescripcio());
        }
    }//GEN-LAST:event_jTxtFldDescripcionFocusLost

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed
        int seleccionarEjercicio = jCmbBxEjercicios.getSelectedIndex();

        if (seleccionarEjercicio <= 0) {

            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un ejercicio.", "Ejercicio no seleccionado", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String nuevoNombre = jTxtFldNombreEjercicio.getText().trim();
            String nuevaDescripcion = jTxtFldDescripcion.getText().trim();

            if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty() || 
                nuevoNombre.equals("Nuevo nombre") || nuevaDescripcion.equals("Nueva descripción")) {
                JOptionPane.showMessageDialog(this, "Nombre y descripción no pueden estar vacíos", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            exercise.setNomExercici(nuevoNombre);
            exercise.setDescripcio(nuevaDescripcion);

            if (AccionesBD.actualizarEjerciciosBD(exercise)) {
                JOptionPane.showMessageDialog(this, "Ejercicio modificado correctamente!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar, vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime cualquier excepción inesperada
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
