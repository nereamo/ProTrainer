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
        setSize(1000, 700);

        this.frameMain = frameMain;

        frameMain.showCalendarMenu();
        listaUsuarios();
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

        jPanelBlue = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLstUsuario = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblEjercicios = new javax.swing.JTable();
        jScrllPnEntrenamientos = new javax.swing.JScrollPane();
        jTblEntrenamientos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jBttnAñadirEntrenamiento = new javax.swing.JButton();
        jBttnEliminarEntrenamiento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBttnEditarEjercicio = new javax.swing.JButton();
        jBttnAsignarEjercicio = new javax.swing.JButton();
        jBttnEliminaerEjercicio = new javax.swing.JButton();
        jBttnAñadirEjercicio = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(950, 620));
        setLayout(null);

        jPanelBlue.setBackground(new java.awt.Color(51, 51, 51));
        jPanelBlue.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Usuario.png"))); // NOI18N
        jPanelBlue.add(jLabel1);
        jLabel1.setBounds(150, 80, 110, 100);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 0));

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
        jScrollPane3.setViewportView(jLstUsuario);

        jPanelBlue.add(jScrollPane3);
        jScrollPane3.setBounds(110, 210, 190, 210);

        add(jPanelBlue);
        jPanelBlue.setBounds(0, 0, 410, 620);

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
        jTblEjercicios.setRowHeight(25);
        jTblEjercicios.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jTblEjercicios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTblEjercicios.getTableHeader().setResizingAllowed(false);
        jTblEjercicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTblEjercicios);

        add(jScrollPane2);
        jScrollPane2.setBounds(470, 310, 420, 200);

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
        jScrllPnEntrenamientos.setBounds(470, 70, 420, 190);

        jLabel2.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Entrenamientos");
        add(jLabel2);
        jLabel2.setBounds(470, 40, 220, 40);

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
        jBttnAñadirEntrenamiento.setBounds(830, 40, 30, 30);

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
        jBttnEliminarEntrenamiento.setBounds(860, 40, 30, 30);

        jLabel3.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ejercicios");
        add(jLabel3);
        jLabel3.setBounds(470, 280, 170, 40);

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
        jBttnEditarEjercicio.setBounds(830, 280, 30, 30);

        jBttnAsignarEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconAssigned.png"))); // NOI18N
        jBttnAsignarEjercicio.setToolTipText("Asignar ejercicio");
        jBttnAsignarEjercicio.setContentAreaFilled(false);
        jBttnAsignarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAsignarEjercicioActionPerformed(evt);
            }
        });
        add(jBttnAsignarEjercicio);
        jBttnAsignarEjercicio.setBounds(860, 280, 30, 30);

        jBttnEliminaerEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon Eliminar.png"))); // NOI18N
        jBttnEliminaerEjercicio.setToolTipText("Eliminar ejercicio");
        jBttnEliminaerEjercicio.setContentAreaFilled(false);
        jBttnEliminaerEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminaerEjercicioActionPerformed(evt);
            }
        });
        add(jBttnEliminaerEjercicio);
        jBttnEliminaerEjercicio.setBounds(800, 280, 30, 30);

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
        jBttnAñadirEjercicio.setBounds(770, 280, 30, 30);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jLstUsuario;
    private javax.swing.JPanel jPanelBlue;
    private javax.swing.JScrollPane jScrllPnEntrenamientos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTblEjercicios;
    private javax.swing.JTable jTblEntrenamientos;
    // End of variables declaration//GEN-END:variables
}
