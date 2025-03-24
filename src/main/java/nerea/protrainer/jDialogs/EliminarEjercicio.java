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
        
        resaltarBotones(btnEliminar);
        cambiarCursorEnJList(lstEjercicios);
    }

    //----------Método para mostrar una lista de ejercicios de la base de datos----------
    private void listaEjercicios() {
        ArrayList<Exercicis> ejercicios = ExercicisDAO.exercicisBD();

        this.ejerciciosList = ejercicios;

        DefaultListModel<Exercicis> dlm = new DefaultListModel<>();

        for (Exercicis ejercicio : ejercicios) {
            dlm.addElement(ejercicio);
        }

        lstEjercicios.setModel(dlm);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEjercicios = new javax.swing.JList<>();
        btnEliminar = new javax.swing.JButton();
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
        lblTitulo.setText("ELIMINAR EJERCICIO");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(0, 10, 400, 50);

        lstEjercicios.setBackground(new java.awt.Color(255, 255, 255));
        lstEjercicios.setBorder(null);
        lstEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lstEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        lstEjercicios.setToolTipText("Entrenamiento");
        lstEjercicios.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(lstEjercicios);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(80, 80, 240, 150);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(180, 300, 30, 40);

        lblMsg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMsg);
        lblMsg.setBounds(30, 250, 330, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int selectEjercicio = lstEjercicios.getSelectedIndex();


        if (selectEjercicio != -1) {

            Exercicis ejercicios = ejerciciosList.get(selectEjercicio);
            ejercicios.getId();  
            
            int selectIndex = lstEjercicios.getSelectedIndex();


            if (selectIndex <= 0) {
                lblMsg.setText("Por favor, selecciona un entrenamiento");
                return;
            }
            
            if (selectIndex <= 0) {
                lblMsg.setText("Por favor, selecciona un ejercicio.");
                return;
            }

         
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el ejercicio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                boolean completado = ExercicisDAO.eliminaExercicis(ejercicios.getId());

                    if (completado) {

                        ejerciciosList.remove(selectEjercicio);
                        javax.swing.JOptionPane.showMessageDialog(this, "Ejercicio eliminado correctamente!");
                        dispose();
                    } else {

                        javax.swing.JOptionPane.showMessageDialog(this, "No es posible eliminar un ejercicio asociado a un entrenamiento.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            
        } else {
           
            lblMsg.setText("Por favor, selecciona un ejercicio de la lista.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Exercicis> lstEjercicios;
    // End of variables declaration//GEN-END:variables
}
