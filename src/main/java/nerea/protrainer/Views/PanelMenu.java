package nerea.protrainer.Views;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import nerea.protrainer.Formularios.AsignarEjercicio;
import nerea.protrainer.Formularios.AñadirEjercicio;
import nerea.protrainer.Formularios.AñadirEntrenamiento;
import nerea.protrainer.Formularios.EliminarEjercicio;
import nerea.protrainer.Formularios.EliminarEntrenamiento;
import nerea.protrainer.Formularios.ModificarEjercicio;
import nerea.protrainer.ProTrainer;
import nerea.protrainer.dataAccess.ConsultasBD;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.dto.Workouts;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Nerea
 */
public class PanelMenu extends javax.swing.JPanel {

    private ProTrainer frameMain;
    private List<Usuari> userList = new ArrayList<>();
    private List<Integer> workoutList = new ArrayList<>();
    private List<Integer> exercises = new ArrayList<>();

    public PanelMenu(ProTrainer frameMain) {
        
        initComponents();
        setSize(1200, 700);

        this.frameMain = frameMain;

        frameMain.showCalendarMenu();
        listaUsuarios();
        
        setLayout(new MigLayout("fill, insets 10", "[grow 30][grow 20][grow 10][grow 10][grow 10][grow 5][grow 5][grow 5][grow 5]", "[][][][]")); // 6 columnas
        
        //JPanel DarkGrey con JLblUsr y JScrollUsr
        jPanelDarkGrey.setLayout(new MigLayout("fill, insets 10", "[grow]", "[grow]"));
        jPanelDarkGrey.add(jLblUsr, "align center, wrap");
        jPanelDarkGrey.add(jScrollUsr, "grow, align center");

        add(jPanelDarkGrey, "grow, cell 0 0 3 5"); 
        add(jLblEntrenamientos, "cell 3 0, wrap"); 
        add(jScrllPnEntrenamientos, "grow, cell 3 1 8 1, wrap"); 
        add(jBttnAñadirEntrenamiento, "cell 7 0,wrap"); 
        add(jBttnEliminarEntrenamiento, "cell 8 0, wrap");
        
        add(jLblEjercicios, "cell 3 2, wrap"); 
        add(jScrollEjercicios, "grow, cell 3 3 8 3, wrap"); 
        add(jBttnAñadirEjercicio,"cell 5 2, wrap");
        add(jBttnEliminaerEjercicio,"cell 6 2, wrap");
        add(jBttnEditarEjercicio,"cell 7 2, wrap");
        add(jBttnAsignarEjercicio, "cell 8 2, wrap");
        
    }

    //----------Método que muestra los usuarios asignados al instructor en una lista----------
    private void listaUsuarios() {

        userList = ConsultasBD.usuariosAsignadosInstructor();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Usuari user : userList) {
            listModel.addElement(user.getNom());
        }

        jLstUsuario.setModel(listModel);
        jLstUsuario.revalidate();
        jLstUsuario.repaint();
    }

    //----------Método que muestra los entrenamientos asignados a un usuario----------
    private void tblEntrenamientosUsuario(int userId) {

        try {
            ArrayList<Workouts> workouts = ConsultasBD.workoutUsuari(userId);

            DefaultTableModel tblmodel = (DefaultTableModel) jTblEntrenamientos.getModel();
            tblmodel.setRowCount(0);

            for (Workouts workout : workouts) {
                workoutList.add(workout.getId());
                tblmodel.addRow(new Object[]{
                    workout.getForDate(),
                    workout.getComments()
                });
            }

            int filasMinimas = 8;
            while (tblmodel.getRowCount() < filasMinimas) {
                tblmodel.addRow(new Object[]{"", ""});
            }

            jTblEntrenamientos.setRowHeight(25);

            JScrollPane scrollPane = (JScrollPane) jTblEntrenamientos.getParent().getParent();
            scrollPane.setPreferredSize(new Dimension(225, 160));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------Método que muestra los ejercicios asignados a un entrenamiento----------
    private void tblEjerciciosUsuario(int workoutId) {

        try {
            ArrayList<Exercicis> exercicis = ConsultasBD.exercicisDelWorkout(workoutId);

            DefaultTableModel tblmodel = (DefaultTableModel) jTblEjercicios.getModel();
            tblmodel.setRowCount(0);

            for (Exercicis exercici : exercicis) {
                exercises.add(exercici.getId());
                tblmodel.addRow(new Object[]{
                    exercici.getNomExercici(),
                    exercici.getDescripcio(),
                    exercici.getDemoFoto()
                });
            }

            int filasMinimas = 8;
            while (tblmodel.getRowCount() < filasMinimas) {
                tblmodel.addRow(new Object[]{"", ""});
            }

            jTblEjercicios.setRowHeight(25);

            JScrollPane scrollPane = (JScrollPane) jTblEjercicios.getParent().getParent();
            scrollPane.setPreferredSize(new Dimension(225, 160));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------Método que actualiza las tablas----------
    public void actualizarTablas(int userId, int workoutId) {
        tblEntrenamientosUsuario(userId);
        tblEjerciciosUsuario(workoutId);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblEntrenamientos = new javax.swing.JLabel();
        jBttnAñadirEntrenamiento = new javax.swing.JButton();
        jBttnEliminarEntrenamiento = new javax.swing.JButton();
        jBttnAsignarEjercicio = new javax.swing.JButton();
        jBttnEliminaerEjercicio = new javax.swing.JButton();
        jBttnEditarEjercicio = new javax.swing.JButton();
        jScrllPnEntrenamientos = new javax.swing.JScrollPane();
        jTblEntrenamientos = new javax.swing.JTable();
        jLblEjercicios = new javax.swing.JLabel();
        jPanelDarkGrey = new javax.swing.JPanel();
        jBttnAñadirEjercicio = new javax.swing.JButton();
        jScrollUsr = new javax.swing.JScrollPane();
        jLstUsuario = new javax.swing.JList<>();
        jLblUsr = new javax.swing.JLabel();
        jScrollEjercicios = new javax.swing.JScrollPane();
        jTblEjercicios = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setLayout(null);

        jLblEntrenamientos.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLblEntrenamientos.setForeground(new java.awt.Color(0, 0, 0));
        jLblEntrenamientos.setText("Entrenamientos");
        add(jLblEntrenamientos);
        jLblEntrenamientos.setBounds(500, 50, 220, 40);

        jBttnAñadirEntrenamiento.setBackground(new java.awt.Color(255, 255, 255));
        jBttnAñadirEntrenamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Nuevo.png"))); // NOI18N
        jBttnAñadirEntrenamiento.setToolTipText("Nuevo entrenamiento");
        jBttnAñadirEntrenamiento.setBorder(null);
        jBttnAñadirEntrenamiento.setBorderPainted(false);
        jBttnAñadirEntrenamiento.setContentAreaFilled(false);
        jBttnAñadirEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAñadirEntrenamientoActionPerformed(evt);
            }
        });
        add(jBttnAñadirEntrenamiento);
        jBttnAñadirEntrenamiento.setBounds(860, 50, 30, 30);

        jBttnEliminarEntrenamiento.setBackground(new java.awt.Color(255, 255, 255));
        jBttnEliminarEntrenamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Eliminar.png"))); // NOI18N
        jBttnEliminarEntrenamiento.setToolTipText("Eliminar entrenamiento");
        jBttnEliminarEntrenamiento.setBorder(null);
        jBttnEliminarEntrenamiento.setBorderPainted(false);
        jBttnEliminarEntrenamiento.setContentAreaFilled(false);
        jBttnEliminarEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminarEntrenamientoActionPerformed(evt);
            }
        });
        add(jBttnEliminarEntrenamiento);
        jBttnEliminarEntrenamiento.setBounds(890, 50, 30, 30);

        jBttnAsignarEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconAssigned.png"))); // NOI18N
        jBttnAsignarEjercicio.setToolTipText("Asignar ejercicio");
        jBttnAsignarEjercicio.setContentAreaFilled(false);
        jBttnAsignarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAsignarEjercicioActionPerformed(evt);
            }
        });
        add(jBttnAsignarEjercicio);
        jBttnAsignarEjercicio.setBounds(890, 330, 30, 30);

        jBttnEliminaerEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Eliminar.png"))); // NOI18N
        jBttnEliminaerEjercicio.setToolTipText("Eliminar ejercicio");
        jBttnEliminaerEjercicio.setContentAreaFilled(false);
        jBttnEliminaerEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminaerEjercicioActionPerformed(evt);
            }
        });
        add(jBttnEliminaerEjercicio);
        jBttnEliminaerEjercicio.setBounds(830, 330, 30, 30);

        jBttnEditarEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Edit.png"))); // NOI18N
        jBttnEditarEjercicio.setToolTipText("Editar ejercicio");
        jBttnEditarEjercicio.setBorder(null);
        jBttnEditarEjercicio.setBorderPainted(false);
        jBttnEditarEjercicio.setContentAreaFilled(false);
        jBttnEditarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEditarEjercicioActionPerformed(evt);
            }
        });
        add(jBttnEditarEjercicio);
        jBttnEditarEjercicio.setBounds(860, 330, 30, 30);

        jTblEntrenamientos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTblEntrenamientos.setForeground(new java.awt.Color(0, 0, 0));
        jTblEntrenamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Comentario"
            }
        ));
        jTblEntrenamientos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTblEntrenamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTblEntrenamientos.setDropMode(javax.swing.DropMode.ON);
        jTblEntrenamientos.setMinimumSize(new java.awt.Dimension(150, 300));
        jTblEntrenamientos.setRowHeight(25);
        jTblEntrenamientos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jTblEntrenamientos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTblEntrenamientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblEntrenamientosMouseClicked(evt);
            }
        });
        jScrllPnEntrenamientos.setViewportView(jTblEntrenamientos);

        add(jScrllPnEntrenamientos);
        jScrllPnEntrenamientos.setBounds(500, 80, 420, 190);

        jLblEjercicios.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLblEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLblEjercicios.setText("Ejercicios");
        add(jLblEjercicios);
        jLblEjercicios.setBounds(500, 330, 170, 40);

        jPanelDarkGrey.setBackground(new java.awt.Color(51, 51, 51));
        jPanelDarkGrey.setLayout(null);
        add(jPanelDarkGrey);
        jPanelDarkGrey.setBounds(0, 0, 410, 700);

        jBttnAñadirEjercicio.setBackground(new java.awt.Color(255, 255, 255));
        jBttnAñadirEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Nuevo.png"))); // NOI18N
        jBttnAñadirEjercicio.setToolTipText("Nuevo ejercicio");
        jBttnAñadirEjercicio.setBorder(null);
        jBttnAñadirEjercicio.setBorderPainted(false);
        jBttnAñadirEjercicio.setContentAreaFilled(false);
        jBttnAñadirEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAñadirEjercicioActionPerformed(evt);
            }
        });
        add(jBttnAñadirEjercicio);
        jBttnAñadirEjercicio.setBounds(800, 330, 30, 30);

        jScrollUsr.setBackground(new java.awt.Color(255, 255, 255));
        jScrollUsr.setForeground(new java.awt.Color(0, 0, 0));

        jLstUsuario.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLstUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jLstUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLstUsuario.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jLstUsuario.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jLstUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLstUsuarioMouseClicked(evt);
            }
        });
        jScrollUsr.setViewportView(jLstUsuario);

        add(jScrollUsr);
        jScrollUsr.setBounds(110, 260, 190, 260);

        jLblUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Usuario.png"))); // NOI18N
        add(jLblUsr);
        jLblUsr.setBounds(150, 80, 110, 100);

        jTblEjercicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTblEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jTblEjercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Imagen"
            }
        ));
        jTblEjercicios.setGridColor(new java.awt.Color(0, 102, 153));
        jTblEjercicios.setMinimumSize(new java.awt.Dimension(150, 300));
        jTblEjercicios.setPreferredSize(new java.awt.Dimension(150, 300));
        jTblEjercicios.setRowHeight(25);
        jTblEjercicios.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jTblEjercicios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTblEjercicios.getTableHeader().setResizingAllowed(false);
        jTblEjercicios.getTableHeader().setReorderingAllowed(false);
        jScrollEjercicios.setViewportView(jTblEjercicios);

        add(jScrollEjercicios);
        jScrollEjercicios.setBounds(500, 360, 420, 200);
    }// </editor-fold>//GEN-END:initComponents

    private void jLstUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLstUsuarioMouseClicked
        int selectedIndex = jLstUsuario.getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < userList.size()) {
            Usuari selectedUser = userList.get(selectedIndex);

            tblEntrenamientosUsuario(selectedUser.getId());

        }
    }//GEN-LAST:event_jLstUsuarioMouseClicked

    private void jTblEntrenamientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblEntrenamientosMouseClicked
        int selectedRow = jTblEntrenamientos.getSelectedRow();

        if (selectedRow >= 0 && selectedRow < workoutList.size()) {

            int workoutId = workoutList.get(selectedRow);

            tblEjerciciosUsuario(workoutId);
        } else {
            System.out.println("Fila no válida");
        }
    }//GEN-LAST:event_jTblEntrenamientosMouseClicked

    private void jBttnAñadirEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnAñadirEntrenamientoActionPerformed
        try {
            AñadirEntrenamiento añadirEntrenamiento = new AñadirEntrenamiento(frameMain, true);
            añadirEntrenamiento.setVisible(true); // Muestra el JDialog

            int selectedIndex = jLstUsuario.getSelectedIndex();
            if (selectedIndex >= 0) {
                int userId = userList.get(selectedIndex).getId();

                actualizarTablas(userId, -1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnAñadirEntrenamientoActionPerformed

    private void jBttnEliminarEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEliminarEntrenamientoActionPerformed
        try {
            EliminarEntrenamiento eliminarEntrenamiento = new EliminarEntrenamiento(frameMain, true);
            eliminarEntrenamiento.setVisible(true);

            int selectedIndex = jLstUsuario.getSelectedIndex();
            if (selectedIndex >= 0) {
                int userId = userList.get(selectedIndex).getId();

                actualizarTablas(userId, -1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnEliminarEntrenamientoActionPerformed

    private void jBttnAñadirEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnAñadirEjercicioActionPerformed
        try {
            AñadirEjercicio añadirEjercicio = new AñadirEjercicio(frameMain, true);
            añadirEjercicio.setVisible(true);

            int selectedIndex = jLstUsuario.getSelectedIndex();
            if (selectedIndex >= 0) {
                int userId = userList.get(selectedIndex).getId();

                actualizarTablas(userId, -1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnAñadirEjercicioActionPerformed

    private void jBttnEliminaerEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEliminaerEjercicioActionPerformed
        try {
            EliminarEjercicio eliminarEjercicio = new EliminarEjercicio(frameMain, true);
            eliminarEjercicio.setVisible(true);

            int selectedIndex = jLstUsuario.getSelectedIndex();
            if (selectedIndex >= 0) {
                int userId = userList.get(selectedIndex).getId();

                actualizarTablas(userId, -1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnEliminaerEjercicioActionPerformed

    private void jBttnEditarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEditarEjercicioActionPerformed
        try {
            ModificarEjercicio modificarEjercicio = new ModificarEjercicio(frameMain, true);
            modificarEjercicio.setVisible(true);

            int selectedIndex = jLstUsuario.getSelectedIndex();
            if (selectedIndex >= 0) {
                int userId = userList.get(selectedIndex).getId();

                actualizarTablas(userId, -1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnEditarEjercicioActionPerformed

    private void jBttnAsignarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnAsignarEjercicioActionPerformed
        try {
            AsignarEjercicio asignarEjercicio = new AsignarEjercicio(frameMain, true);
            asignarEjercicio.setVisible(true);

            int selectedIndex = jLstUsuario.getSelectedIndex();
            if (selectedIndex >= 0) {
                int userId = userList.get(selectedIndex).getId();

                actualizarTablas(userId, -1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBttnAsignarEjercicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnAsignarEjercicio;
    private javax.swing.JButton jBttnAñadirEjercicio;
    private javax.swing.JButton jBttnAñadirEntrenamiento;
    private javax.swing.JButton jBttnEditarEjercicio;
    private javax.swing.JButton jBttnEliminaerEjercicio;
    private javax.swing.JButton jBttnEliminarEntrenamiento;
    private javax.swing.JLabel jLblEjercicios;
    private javax.swing.JLabel jLblEntrenamientos;
    private javax.swing.JLabel jLblUsr;
    private javax.swing.JList<String> jLstUsuario;
    private javax.swing.JPanel jPanelDarkGrey;
    private javax.swing.JScrollPane jScrllPnEntrenamientos;
    private javax.swing.JScrollPane jScrollEjercicios;
    private javax.swing.JScrollPane jScrollUsr;
    private javax.swing.JTable jTblEjercicios;
    private javax.swing.JTable jTblEntrenamientos;
    // End of variables declaration//GEN-END:variables
}
