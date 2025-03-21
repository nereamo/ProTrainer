package nerea.protrainer.jDialogs;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import nerea.protrainer.dao.ExercicisDAO;
import nerea.protrainer.dto.Exercicis;
import static nerea.protrainer.eventosVisuales.EventosMouse.cambiarCursorEnJList;
import static nerea.protrainer.eventosVisuales.EventosMouse.resaltarBotones;

/**
 *
 * @author Nerea
 */
public class EliminarEjercicio extends javax.swing.JDialog {

    private List<Exercicis> ejerciciosList = new ArrayList<>();

    public EliminarEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(this);
        
        listaEjercicios();
        
        resaltarBotones(jBttnEliminar);
        cambiarCursorEnJList(jLstEjercicios);
    }

    //----------Método para mostrar una lista de ejercicios de la base de datos----------
    private void listaEjercicios() {
        ArrayList<Exercicis> ejercicios = ExercicisDAO.exercicisBD();

        this.ejerciciosList = ejercicios;

        DefaultListModel<Exercicis> listModel = new DefaultListModel<>();

        for (Exercicis ejercicio : ejercicios) {
            listModel.addElement(ejercicio);
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
        jLblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("ELIMINAR EJERCICIO");
        jPanel1.add(jLblTitulo);
        jLblTitulo.setBounds(0, 10, 400, 50);

        jLstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        jLstEjercicios.setBorder(null);
        jLstEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLstEjercicios.setToolTipText("Entrenamiento");
        jLstEjercicios.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(jLstEjercicios);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(80, 80, 240, 150);

        jBttnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        jBttnEliminar.setBorder(null);
        jBttnEliminar.setContentAreaFilled(false);
        jBttnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBttnEliminar);
        jBttnEliminar.setBounds(180, 310, 30, 40);

        jLblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblMsg.setForeground(new java.awt.Color(255, 255, 255));
        jLblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLblMsg);
        jLblMsg.setBounds(30, 280, 330, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEliminarActionPerformed

        int seleccionarEjercicio = jLstEjercicios.getSelectedIndex();


        if (seleccionarEjercicio != -1) {

            Exercicis ejercicios = ejerciciosList.get(seleccionarEjercicio);
            ejercicios.getId();  
            
            int ejercicioIndex = jLstEjercicios.getSelectedIndex();


            if (ejercicioIndex <= 0) {
                jLblMsg.setText("Por favor, selecciona un entrenamiento");
                return;
            }
            
            if (ejercicioIndex <= 0) {
                jLblMsg.setText("Por favor, selecciona un ejercicio.");
                return;
            }

         
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el ejercicio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                boolean success = ExercicisDAO.eliminaExercicis(ejercicios.getId());

                    if (success) {

                        ejerciciosList.remove(seleccionarEjercicio);
                        javax.swing.JOptionPane.showMessageDialog(this, "Ejercicio eliminado correctamente!");
                        dispose();
                    } else {

                        javax.swing.JOptionPane.showMessageDialog(this, "No es posible eliminar un ejercicio asociado a un entrenamiento.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            

        } else {
           
            jLblMsg.setText("Por favor, selecciona un ejercicio de la lista.");
        }

    }//GEN-LAST:event_jBttnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnEliminar;
    private javax.swing.JLabel jLblMsg;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList<Exercicis> jLstEjercicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
