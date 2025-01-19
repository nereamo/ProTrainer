package nerea.protrainer.Formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nerea.protrainer.dataAccess.DataAccess;

/**
 *
 * @author Nerea
 */
public class AñadirEjercicio extends javax.swing.JDialog {

    public AñadirEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400,250);
        setLocationRelativeTo(this);
    }

    public String getExerciseDescription() {
        return jTxtFldDescripcion.getText();
    }
    
    private void saveExerciseBD(String nombre, String descripcion) {
        String query = "INSERT INTO Exercicis (NomExercici, Descripcio) VALUES (?, ?)";

        try (Connection conn = DataAccess.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre);  
            stmt.setString(2, descripcion);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Ejercicio creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();  

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el ejercicio en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jTxtFldNombre = new javax.swing.JTextField();
        jBttnGuardar = new javax.swing.JButton();
        jTxtFldDescripcion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLblTitulo.setText("Nuevo Ejercicio");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(10, 10, 270, 28);

        jTxtFldNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldNombre.setForeground(new java.awt.Color(102, 102, 102));
        jTxtFldNombre.setText("Nombre ejercicio...");
        jTxtFldNombre.setToolTipText("Nombre ejercicio");
        jTxtFldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtFldNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFldNombreFocusLost(evt);
            }
        });
        jPanel1.add(jTxtFldNombre);
        jTxtFldNombre.setBounds(90, 80, 210, 30);

        jBttnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        jBttnGuardar.setBorder(null);
        jBttnGuardar.setContentAreaFilled(false);
        jBttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnGuardar);
        jBttnGuardar.setBounds(170, 200, 25, 25);

        jTxtFldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        jTxtFldDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFldDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        jTxtFldDescripcion.setText("Añade una descripcion...");
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
        jTxtFldDescripcion.setBounds(90, 140, 210, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnGuardarActionPerformed
        String nombre = jTxtFldNombre.getText().trim();
        String descripcion = jTxtFldDescripcion.getText().trim();

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre y una descripción.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            saveExerciseBD(nombre, descripcion); 
        }
    }//GEN-LAST:event_jBttnGuardarActionPerformed

    private void jTxtFldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldNombreFocusGained
        if (jTxtFldNombre.getText().equals("Nombre ejercicio...")) {
            jTxtFldNombre.setText("");
        }
    }//GEN-LAST:event_jTxtFldNombreFocusGained

    private void jTxtFldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldNombreFocusLost
        if (jTxtFldNombre.getText().isEmpty()) {
            jTxtFldNombre.setText("Nombre ejercicio...");
        }
    }//GEN-LAST:event_jTxtFldNombreFocusLost

    private void jTxtFldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldDescripcionFocusGained
        if (jTxtFldDescripcion.getText().equals("Añade una descripcion...")) {
            jTxtFldDescripcion.setText("");
        }
    }//GEN-LAST:event_jTxtFldDescripcionFocusGained

    private void jTxtFldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFldDescripcionFocusLost
        if (jTxtFldDescripcion.getText().isEmpty()) {
            jTxtFldDescripcion.setText("Añade una descripcion...");
        }
    }//GEN-LAST:event_jTxtFldDescripcionFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnGuardar;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtFldDescripcion;
    private javax.swing.JTextField jTxtFldNombre;
    // End of variables declaration//GEN-END:variables
}
