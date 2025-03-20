package nerea.protrainer.Formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import nerea.protrainer.dataAccess.AccionesBD;
import nerea.protrainer.dataAccess.ConsultasBD;
import nerea.protrainer.dto.Exercicis;

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
        resaltarBotones();
        eventosMouse();
    }
    
    //Fragmento extraído de chatGPT
    //----------Método resaltar los botones----------
    private void resaltarBotones() {
        jBttnEliminar.addMouseListener(new MouseAdapter() {
            Color originalColor = jBttnEliminar.getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                jBttnEliminar.setBackground(new Color(220, 220, 220)); // Un gris claro
                jBttnEliminar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                jBttnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jBttnEliminar.setBackground(originalColor);
                jBttnEliminar.setBorder(UIManager.getBorder("Button.border"));
                jBttnEliminar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
    
    //Fragmento extraído de chatGPT
    //----------Método muestra la fila por donde pasa el cursor----------
    private void eventosMouse() {
        
        jLstEjercicios.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                jLstEjercicios.setCursor(new Cursor(Cursor.HAND_CURSOR));
                jLstEjercicios.repaint();
            }
        });

        jLstEjercicios.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Point mousePos = list.getMousePosition();
                int hoverIndex = (mousePos != null) ? list.locationToIndex(mousePos) : -1;

                if (index == hoverIndex) {
                    c.setBackground(Color.LIGHT_GRAY);
                } else if (isSelected) {
                    c.setBackground(Color.DARK_GRAY);
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(list.getBackground());
                    c.setForeground(list.getForeground());
                }

                return c;
            }
        });
    }

    //----------Método para mostrar una lista de ejercicios de la base de datos----------
    private void listaEjercicios() {
        ArrayList<Exercicis> ejercicios = ConsultasBD.exercicisBD();

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
        setPreferredSize(new java.awt.Dimension(300, 300));
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

                boolean success = AccionesBD.eliminaExercicis(ejercicios.getId());

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
