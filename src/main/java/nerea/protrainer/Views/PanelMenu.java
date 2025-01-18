package nerea.protrainer.Views;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import nerea.protrainer.ProTrainer;
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
        setSize(950, 620);

        this.frameMain = frameMain;

        listaUsuarios();
    }

    private void listaUsuarios() {

        userList = Usuari.usuariosAsignadosInstructor();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Usuari user : userList) {
            listModel.addElement(user.getNom());
        }

        jLstUsuario.setModel(listModel);
        jLstUsuario.revalidate();
        jLstUsuario.repaint();
    }

    private void tblEntrenamientosUsuario(int userId) {

        try {
            ArrayList<Workouts> workouts = Workouts.getWorkoutsUser(userId);

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
    
    
    private void tblEjerciciosUsuario(int workoutId) {

        try {
            ArrayList<Exercicis> exercicis = Exercicis.getExercisesInWorkout(workoutId);

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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLstUsuario = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblEjercicios = new javax.swing.JTable();
        jScrllPnEntrenamientos = new javax.swing.JScrollPane();
        jTblEntrenamientos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jBttnAñadirEntrenamiento = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(950, 620));
        setMinimumSize(new java.awt.Dimension(950, 620));
        setPreferredSize(new java.awt.Dimension(950, 620));
        setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(160, 30, 130, 130);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 0));

        jLstUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLstUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLstUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jLstUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLstUsuario.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jLstUsuario.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jLstUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLstUsuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jLstUsuario);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(140, 190, 170, 290);

        add(jPanel3);
        jPanel3.setBounds(0, 0, 440, 620);

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
        jTblEjercicios.setGridColor(new java.awt.Color(0, 153, 153));
        jTblEjercicios.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTblEjercicios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTblEjercicios.getTableHeader().setResizingAllowed(false);
        jTblEjercicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTblEjercicios);

        add(jScrollPane2);
        jScrollPane2.setBounds(470, 330, 420, 190);

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
        jTblEntrenamientos.setGridColor(new java.awt.Color(0, 153, 153));
        jTblEntrenamientos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTblEntrenamientos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTblEntrenamientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblEntrenamientosMouseClicked(evt);
            }
        });
        jScrllPnEntrenamientos.setViewportView(jTblEntrenamientos);

        add(jScrllPnEntrenamientos);
        jScrllPnEntrenamientos.setBounds(470, 90, 420, 190);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Entrenamientos");
        add(jLabel2);
        jLabel2.setBounds(470, 60, 220, 20);

        jBttnAñadirEntrenamiento.setBackground(new java.awt.Color(255, 255, 255));
        jBttnAñadirEntrenamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas-simbolo-negro.png"))); // NOI18N
        jBttnAñadirEntrenamiento.setBorder(null);
        jBttnAñadirEntrenamiento.setBorderPainted(false);
        jBttnAñadirEntrenamiento.setContentAreaFilled(false);
        add(jBttnAñadirEntrenamiento);
        jBttnAñadirEntrenamiento.setBounds(820, 60, 30, 23);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-de-eliminacion-de-linea-horizontal.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        add(jButton5);
        jButton5.setBounds(860, 60, 30, 23);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ejercicios");
        add(jLabel3);
        jLabel3.setBounds(470, 300, 170, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-subrayado.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        add(jButton2);
        jButton2.setBounds(860, 300, 30, 24);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista-de-tres-elementos-sobre-fondo-negro.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(820, 300, 30, 31);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-de-eliminacion-de-linea-horizontal.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        add(jButton4);
        jButton4.setBounds(780, 300, 30, 31);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas-simbolo-negro.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(740, 300, 30, 24);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnAñadirEntrenamiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jLstUsuario;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrllPnEntrenamientos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTblEjercicios;
    private javax.swing.JTable jTblEntrenamientos;
    // End of variables declaration//GEN-END:variables
}
