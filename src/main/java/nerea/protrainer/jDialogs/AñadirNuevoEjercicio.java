package nerea.protrainer.jDialogs;

import nerea.protrainer.dao.ExercicisDAO;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 * @author Nerea
 */
public class AñadirNuevoEjercicio extends javax.swing.JDialog {

    public AñadirNuevoEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400,400);
        setLocationRelativeTo(this);
        
        resaltarBotones(btnGuardar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtFieldNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtFieldDescripcion = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("NUEVO EJERCICIO");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 400, 50);

        txtFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtFieldNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtFieldNombre.setText("Nombre ejercicio...");
        txtFieldNombre.setToolTipText("Nombre ejercicio");
        txtFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusLost(evt);
            }
        });
        jPanel1.add(txtFieldNombre);
        txtFieldNombre.setBounds(90, 100, 230, 30);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(180, 310, 40, 40);

        txtFieldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtFieldDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFieldDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        txtFieldDescripcion.setText("Añade una descripcion...");
        txtFieldDescripcion.setToolTipText("Descripcion");
        txtFieldDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldDescripcionFocusLost(evt);
            }
        });
        jPanel1.add(txtFieldDescripcion);
        txtFieldDescripcion.setBounds(90, 190, 230, 30);

        lblDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripción:");
        jPanel1.add(lblDescripcion);
        lblDescripcion.setBounds(90, 160, 110, 30);

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre Ejercicio:");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(90, 70, 110, 30);

        lblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMsg);
        lblMsg.setBounds(40, 250, 320, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtFieldNombre.getText().trim();
        String descripcion = txtFieldDescripcion.getText().trim();

        if (nombre.isEmpty() || nombre.equals("Nombre ejercicio...") || descripcion.isEmpty() || descripcion.equals("Añade una descripcion...")) {
            lblMsg.setText("Debe ingresar un nombre y una descripción.");
        } else {
            ExercicisDAO.insertarEjerciciosBD(nombre, descripcion);
            dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFieldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusGained
        if (txtFieldNombre.getText().equals("Nombre ejercicio...")) {
            txtFieldNombre.setText("");
        }
    }//GEN-LAST:event_txtFieldNombreFocusGained

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        if (txtFieldNombre.getText().isEmpty()) {
            txtFieldNombre.setText("Nombre ejercicio...");
        }
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDescripcionFocusGained
        if (txtFieldDescripcion.getText().equals("Añade una descripcion...")) {
            txtFieldDescripcion.setText("");
        }
    }//GEN-LAST:event_txtFieldDescripcionFocusGained

    private void txtFieldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDescripcionFocusLost
        if (txtFieldDescripcion.getText().isEmpty()) {
            txtFieldDescripcion.setText("Añade una descripcion...");
        }
    }//GEN-LAST:event_txtFieldDescripcionFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFieldDescripcion;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}
