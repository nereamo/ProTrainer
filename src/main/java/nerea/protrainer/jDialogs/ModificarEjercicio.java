package nerea.protrainer.jDialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dao.ExercicisDAO;
import nerea.protrainer.dto.Exercicis;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 *
 * @author Nerea
 */
public class ModificarEjercicio extends javax.swing.JDialog {

    private List<Exercicis> ejerciciosList;
    private Exercicis ejercicios;

    public ModificarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(this);
        
        this.ejercicios = new Exercicis();

        comboBoxEjercicios();
        resaltarBotones(btnGuardar);  
    }

    //----------Método que carga el combobox al iniciar----------
    private void comboBoxEjercicios() {
        ejerciciosList = ExercicisDAO.exercicisBD();
        
        DefaultComboBoxModel<Exercicis> dcm = new DefaultComboBoxModel<>();
        
        Exercicis placeholder = new Exercicis();
        placeholder.setNomExercici("Selecciona un Ejercicio...");
        placeholder.setDescripcion("");
        dcm.addElement(placeholder);

        for (Exercicis ejercicios : ejerciciosList) {
            dcm.addElement(ejercicios);
        }

        cmbBoxEjercicios.setModel(dcm);
        cmbBoxEjercicios.setSelectedIndex(0);

        cmbBoxEjercicios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectIndex = cmbBoxEjercicios.getSelectedIndex();
                if (selectIndex > 0) {
                    ejercicios = ejerciciosList.get(selectIndex - 1);

                    txtFieldNombre.setText(ejercicios.getNomEjercicio());
                    txtFieldDescripcion.setText(ejercicios.getDescripcion());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        cmbBoxEjercicios = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        txtFieldNombre = new javax.swing.JTextField();
        txtFieldDescripcion = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("MODIFICAR EJERCICIO");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 400, 50);

        cmbBoxEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        cmbBoxEjercicios.setEditable(true);
        cmbBoxEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbBoxEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        cmbBoxEjercicios.setToolTipText("Ejercicio");
        jPanel1.add(cmbBoxEjercicios);
        cmbBoxEjercicios.setBounds(80, 70, 230, 30);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(170, 300, 40, 30);

        txtFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtFieldNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtFieldNombre.setText("Nuevo nombre");
        txtFieldNombre.setToolTipText("Nuevo nombre ejercicio");
        txtFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusLost(evt);
            }
        });
        jPanel1.add(txtFieldNombre);
        txtFieldNombre.setBounds(80, 140, 230, 30);

        txtFieldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtFieldDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        txtFieldDescripcion.setText("Nueva descripción");
        txtFieldDescripcion.setToolTipText("Descripción");
        txtFieldDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldDescripcionFocusLost(evt);
            }
        });
        jPanel1.add(txtFieldDescripcion);
        txtFieldDescripcion.setBounds(80, 200, 230, 30);

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripción:");
        jPanel1.add(lblDescripcion);
        lblDescripcion.setBounds(80, 180, 100, 20);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre Ejercicio:");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(80, 120, 120, 20);

        lblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMsg);
        lblMsg.setBounds(80, 240, 230, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusGained
        if (txtFieldNombre.getText().equals(ejercicios.getNomEjercicio())) {
            txtFieldNombre.setText("");
        }
    }//GEN-LAST:event_txtFieldNombreFocusGained

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        if (txtFieldNombre.getText().isEmpty()) {
            txtFieldNombre.setText(ejercicios.getNomEjercicio());
        }
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDescripcionFocusGained
        if (txtFieldDescripcion.getText().equals(ejercicios.getDescripcion())) {
            txtFieldDescripcion.setText("");
        }
    }//GEN-LAST:event_txtFieldDescripcionFocusGained

    private void txtFieldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDescripcionFocusLost
        if (txtFieldDescripcion.getText().isEmpty()) {
            txtFieldDescripcion.setText(ejercicios.getDescripcion());
        }
    }//GEN-LAST:event_txtFieldDescripcionFocusLost

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int selectEjercicio = cmbBoxEjercicios.getSelectedIndex();

        if (selectEjercicio <= 0) {

            lblMsg.setText("Por favor, selecciona un ejercicio.");
            return;
        }
        
        try {
            String nuevoNombre = txtFieldNombre.getText().trim();
            String nuevaDescripcion = txtFieldDescripcion.getText().trim();

            if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty() || nuevoNombre.equals("Nuevo nombre") || nuevaDescripcion.equals("Nueva descripción")) {
                lblMsg.setText("El nombre y la descripción no pueden estar vacíos.");
                return;
            }

            ejercicios.setNomExercici(nuevoNombre);
            ejercicios.setDescripcion(nuevaDescripcion);

            if (ExercicisDAO.editarEjerciciosBD(ejercicios)) {
                JOptionPane.showMessageDialog(this, "Ejercicio modificado correctamente!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar, vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Exercicis> cmbBoxEjercicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFieldDescripcion;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}
