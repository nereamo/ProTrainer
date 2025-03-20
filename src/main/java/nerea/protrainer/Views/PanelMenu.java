package nerea.protrainer.Views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import nerea.protrainer.Formularios.AsignarEjercicio;
import nerea.protrainer.Formularios.AñadirEjercicio;
import nerea.protrainer.Formularios.AñadirEntrenamiento;
import nerea.protrainer.Formularios.EliminarEjercicio;
import nerea.protrainer.Formularios.EliminarEntrenamiento;
import nerea.protrainer.Formularios.ModificarEjercicio;
import nerea.protrainer.ProTrainer;
import nerea.protrainer.dataAccess.ConsultasBD;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.ExercicisTableModel;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.dto.Workouts;
import nerea.protrainer.dto.WorkoutsTableModel;
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
        add(jBttnEliminarEjercicio,"cell 6 2, wrap");
        add(jBttnEditarEjercicio,"cell 7 2, wrap");
        add(jBttnAsignarEjercicio, "cell 8 2, wrap");
        
        
        eventosMouse();
        resaltarBotones(jBttnAñadirEntrenamiento, jBttnEliminarEntrenamiento, jBttnAñadirEjercicio, jBttnEliminarEjercicio, jBttnEditarEjercicio, jBttnAsignarEjercicio);
    }
    
    //Fragmento extraído de chatGPT
    //----------Método resaltar los botones----------
    private void resaltarBotones(JButton... botones) {
        for (JButton boton : botones) {
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    boton.setBorder(BorderFactory.createEtchedBorder(4, Color.lightGray, Color.BLACK));
                    boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de mano
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    boton.setBackground(UIManager.getColor("Button.background")); 
                    boton.setBorder(UIManager.getBorder("Button.border")); 
                    boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
                }
            });
        }
    }
    
    //Fragmento extraído de chatGPT
    //----------Método cambia el cursor al pasar por las tablas----------
    private void eventosMouse() {
        jTblEntrenamientos.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = jTblEntrenamientos.rowAtPoint(e.getPoint());
                int col = jTblEntrenamientos.columnAtPoint(e.getPoint());
                if (row > -1 && col > -1) {
                    // Cambiar el cursor a una mano
                    jTblEntrenamientos.setRowSelectionInterval(row, row); // Resaltar la fila
                    jTblEntrenamientos.setColumnSelectionInterval(col, col);
                    jTblEntrenamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                }
            }
        });

        jTblEjercicios.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = jTblEjercicios.rowAtPoint(e.getPoint());
                int col = jTblEjercicios.columnAtPoint(e.getPoint());
                if (row > -1 && col > -1) {
                    // Cambiar el cursor a una mano
                    jTblEjercicios.setRowSelectionInterval(row, row); // Resaltar la fila
                    jTblEjercicios.setColumnSelectionInterval(col, col);
                    jTblEjercicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                }
            }
        });

        jLstUsuario.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = jLstUsuario.locationToIndex(e.getPoint()); // Obtener índice del elemento debajo del cursor
                if (index > -1) {
                    jLstUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor a mano

                    // Actualizar el índice del elemento resaltado y forzar la actualización del JList
                    jLstUsuario.setSelectedIndex(index);
                    jLstUsuario.ensureIndexIsVisible(index);
                }
            }
        });
    }

    //----------Método que muestra los usuarios asignados al instructor en una lista----------
    private void listaUsuarios() {

        userList = ConsultasBD.usuariosAsignadosInstructor();

        DefaultListModel<Usuari> listModel = new DefaultListModel<>();

        for (Usuari user : userList) {
            listModel.addElement(user);
        }

        jLstUsuario.setModel(listModel);

        jLstUsuario.revalidate();
        jLstUsuario.repaint();
    }

    //----------Método que muestra los entrenamientos asignados a un usuario----------
    private void tblEntrenamientosUsuario(int userId) {

        try {
            ArrayList<Workouts> workouts = ConsultasBD.workoutUsuari(userId);

            workoutList.clear();
            for (Workouts w : workouts) {
                workoutList.add(w.getId());
            }

            WorkoutsTableModel tblModel = new WorkoutsTableModel(workouts);
            jTblEntrenamientos.setModel(tblModel);
            jTblEntrenamientos.setRowHeight(25);

            JScrollPane scrollPane = (JScrollPane) jTblEntrenamientos.getParent().getParent();
            scrollPane.setPreferredSize(new Dimension(225, 160));

            int filasMinimas = 8;
            while (tblModel.getRowCount() < filasMinimas) {

                workouts.add(new Workouts());
                tblModel.setWorkouts(workouts);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------Método que muestra los ejercicios asignados a un entrenamiento----------
    private void tblEjerciciosUsuario(int workoutId) {

        try {
            ArrayList<Exercicis> exercicis = ConsultasBD.exercicisDelWorkout(workoutId);
            
            ExercicisTableModel tblModel = new ExercicisTableModel(exercicis);
            
            jTblEjercicios.setModel(tblModel);
            
            jTblEjercicios.setRowHeight(25);
            
            JScrollPane scrollPane = (JScrollPane) jTblEjercicios.getParent().getParent();
            scrollPane.setPreferredSize(new Dimension(225, 160));

            

            int filasMinimas = 8;
            while (tblModel.getRowCount() < filasMinimas) {
                exercicis.add(new Exercicis());
                tblModel.setExercicis(exercicis);
            }

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
        jBttnEliminarEjercicio = new javax.swing.JButton();
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

        jLblEntrenamientos.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jLblEntrenamientos.setForeground(new java.awt.Color(0, 0, 0));
        jLblEntrenamientos.setText("Entrenamientos");
        add(jLblEntrenamientos);
        jLblEntrenamientos.setBounds(500, 40, 220, 40);

        jBttnAñadirEntrenamiento.setBackground(new java.awt.Color(255, 255, 255));
        jBttnAñadirEntrenamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Añadir.png"))); // NOI18N
        jBttnAñadirEntrenamiento.setToolTipText("Nuevo entrenamiento");
        jBttnAñadirEntrenamiento.setContentAreaFilled(false);
        jBttnAñadirEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAñadirEntrenamientoActionPerformed(evt);
            }
        });
        add(jBttnAñadirEntrenamiento);
        jBttnAñadirEntrenamiento.setBounds(850, 40, 40, 40);

        jBttnEliminarEntrenamiento.setBackground(new java.awt.Color(255, 255, 255));
        jBttnEliminarEntrenamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar.png"))); // NOI18N
        jBttnEliminarEntrenamiento.setToolTipText("Eliminar entrenamiento");
        jBttnEliminarEntrenamiento.setContentAreaFilled(false);
        jBttnEliminarEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminarEntrenamientoActionPerformed(evt);
            }
        });
        add(jBttnEliminarEntrenamiento);
        jBttnEliminarEntrenamiento.setBounds(890, 40, 40, 40);

        jBttnAsignarEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Asignar.png"))); // NOI18N
        jBttnAsignarEjercicio.setToolTipText("Asignar ejercicio");
        jBttnAsignarEjercicio.setContentAreaFilled(false);
        jBttnAsignarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAsignarEjercicioActionPerformed(evt);
            }
        });
        add(jBttnAsignarEjercicio);
        jBttnAsignarEjercicio.setBounds(890, 330, 40, 40);

        jBttnEliminarEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar.png"))); // NOI18N
        jBttnEliminarEjercicio.setToolTipText("Eliminar ejercicio");
        jBttnEliminarEjercicio.setContentAreaFilled(false);
        jBttnEliminarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEliminarEjercicioActionPerformed(evt);
            }
        });
        add(jBttnEliminarEjercicio);
        jBttnEliminarEjercicio.setBounds(810, 330, 40, 40);

        jBttnEditarEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editar.png"))); // NOI18N
        jBttnEditarEjercicio.setToolTipText("Editar ejercicio");
        jBttnEditarEjercicio.setContentAreaFilled(false);
        jBttnEditarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnEditarEjercicioActionPerformed(evt);
            }
        });
        add(jBttnEditarEjercicio);
        jBttnEditarEjercicio.setBounds(850, 330, 40, 40);

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

        jLblEjercicios.setFont(new java.awt.Font("Anton", 0, 24)); // NOI18N
        jLblEjercicios.setForeground(new java.awt.Color(0, 0, 0));
        jLblEjercicios.setText("Ejercicios");
        add(jLblEjercicios);
        jLblEjercicios.setBounds(500, 320, 170, 40);

        jPanelDarkGrey.setBackground(new java.awt.Color(51, 51, 51));
        jPanelDarkGrey.setLayout(null);
        add(jPanelDarkGrey);
        jPanelDarkGrey.setBounds(0, 0, 410, 700);

        jBttnAñadirEjercicio.setBackground(new java.awt.Color(255, 255, 255));
        jBttnAñadirEjercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Añadir.png"))); // NOI18N
        jBttnAñadirEjercicio.setToolTipText("Nuevo ejercicio");
        jBttnAñadirEjercicio.setContentAreaFilled(false);
        jBttnAñadirEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnAñadirEjercicioActionPerformed(evt);
            }
        });
        add(jBttnAñadirEjercicio);
        jBttnAñadirEjercicio.setBounds(780, 330, 30, 40);

        jScrollUsr.setBackground(new java.awt.Color(255, 255, 255));
        jScrollUsr.setForeground(new java.awt.Color(0, 0, 0));
        jScrollUsr.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jScrollUsrMouseMoved(evt);
            }
        });

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
        jScrollEjercicios.setBounds(500, 370, 420, 200);
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

    private void jBttnEliminarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnEliminarEjercicioActionPerformed
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
    }//GEN-LAST:event_jBttnEliminarEjercicioActionPerformed

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

    private void jScrollUsrMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollUsrMouseMoved
        jLstUsuario.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_jScrollUsrMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnAsignarEjercicio;
    private javax.swing.JButton jBttnAñadirEjercicio;
    private javax.swing.JButton jBttnAñadirEntrenamiento;
    private javax.swing.JButton jBttnEditarEjercicio;
    private javax.swing.JButton jBttnEliminarEjercicio;
    private javax.swing.JButton jBttnEliminarEntrenamiento;
    private javax.swing.JLabel jLblEjercicios;
    private javax.swing.JLabel jLblEntrenamientos;
    private javax.swing.JLabel jLblUsr;
    private javax.swing.JList<Usuari> jLstUsuario;
    private javax.swing.JPanel jPanelDarkGrey;
    private javax.swing.JScrollPane jScrllPnEntrenamientos;
    private javax.swing.JScrollPane jScrollEjercicios;
    private javax.swing.JScrollPane jScrollUsr;
    private javax.swing.JTable jTblEjercicios;
    private javax.swing.JTable jTblEntrenamientos;
    // End of variables declaration//GEN-END:variables
}
