package nerea.protrainer.Formularios;

/**
 *
 * @author Nerea
 */
public class AsignarEjercicio extends javax.swing.JDialog {

    public AsignarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400,300);
        setLocationRelativeTo(this);
        
        
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
       
    }//GEN-LAST:event_jBttnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnGuardar;
    private javax.swing.JComboBox<String> jCmbBxEntrenamientos;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList<String> jLstEjercicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
