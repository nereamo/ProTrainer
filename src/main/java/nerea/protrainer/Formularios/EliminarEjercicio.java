package nerea.protrainer.Formularios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import nerea.protrainer.dto.Exercicis;

/**
 *
 * @author Nerea
 */
public class EliminarEjercicio extends javax.swing.JDialog {
    
    private List<Exercicis> ejerciciosList;

    public EliminarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400,300);
        setLocationRelativeTo(this);
        
        listaEjercicios();
    }
    
    private void listaEjercicios() {

        ArrayList<Exercicis> ejercicios = Exercicis.exercicisBD();
        
        this.ejerciciosList = ejercicios;

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Exercicis ejercicio : ejercicios) {
            listModel.addElement(ejercicio.getNomExercici() + " - " + ejercicio.getDescripcio());
        }
        
        jLstEjercicios.setModel(listModel);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstEjercicios = new javax.swing.JList<>();
        jBttnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLblTitulo.setText("Eliminar Ejercicio");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(10, 10, 270, 28);

        jLstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jLstEjercicios.setBorder(null);
        jLstEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLstEjercicios.setToolTipText("Entrenamiento");
        jLstEjercicios.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(jLstEjercicios);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(70, 60, 258, 130);

        jBttnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        jBttnEliminar.setBorder(null);
        jBttnEliminar.setContentAreaFilled(false);
        jBttnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnEliminar);
        jBttnEliminar.setBounds(180, 210, 25, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEliminarActionPerformed

        int seleccionarEjercicio = jLstEjercicios.getSelectedIndex();

        if (seleccionarEjercicio != -1) {

            Exercicis ejercicios = ejerciciosList.get(seleccionarEjercicio);
            ejercicios.getId();

            int ejercicioIndex = jLstEjercicios.getSelectedIndex();

            if (ejercicioIndex != -1) {

                int confirm = javax.swing.JOptionPane.showConfirmDialog(
                        this,
                        "Estas seguro de eliminar el Ejercicio?",
                        "Confirm Deletion",
                        javax.swing.JOptionPane.YES_NO_OPTION
                );

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {

                    boolean success = Exercicis.eliminaExercicis(ejercicios.getId());

                    if (success) {

                        ejerciciosList.remove(seleccionarEjercicio);

                        javax.swing.JOptionPane.showMessageDialog(this, "Ejercicio eliminado correctamente!");
                         dispose();
                    } else {

                        javax.swing.JOptionPane.showMessageDialog(this, "No es posible eliminar un ejercicio asociado a un entrenamiento.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } else {

            javax.swing.JOptionPane.showMessageDialog(this, "Porfavor, selecciona un ejercicio de la tabla.", "No Selection", javax.swing.JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jBttnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnEliminar;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList<String> jLstEjercicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
