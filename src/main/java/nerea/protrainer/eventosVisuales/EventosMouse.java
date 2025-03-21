package nerea.protrainer.eventosVisuales;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 * @author Nerea
 */
public class EventosMouse {

    public static void configurarEventos(JFrame frame, JButton jBttnAccess, JLabel jLblWeb, JMenu jMnuCalendar, JMenu jMnuMenu, JMenu jMnuAbout) {
        //Resalta botón login
        jBttnAccess.addMouseListener(new MouseAdapter() {
            Color originalColor = jBttnAccess.getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                jBttnAccess.setBackground(new Color(220, 220, 220));
                jBttnAccess.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                jBttnAccess.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jBttnAccess.setBackground(originalColor);
                jBttnAccess.setBorder(UIManager.getBorder("Button.border"));
                jBttnAccess.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        //Resalta enlace Web
        jLblWeb.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                jLblWeb.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    //Método para resaltar botones
    public static void resaltarBotones(JButton... botones) {
        for (JButton boton : botones) {
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    boton.setBorder(BorderFactory.createEtchedBorder(4, Color.lightGray, Color.BLACK));
                    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

    public static void cambiarCursorEnTablas(JTable... tablas) {
        for (JTable tabla : tablas) {
            tabla.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int row = tabla.rowAtPoint(e.getPoint());
                    int col = tabla.columnAtPoint(e.getPoint());
                    if (row > -1 && col > -1) {
                        tabla.setRowSelectionInterval(row, row);
                        tabla.setColumnSelectionInterval(col, col);
                        tabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
            });
        }
    }

    public static void cambiarCursorEnJList(javax.swing.JList<?> list) {
        // Variable para almacenar la posición del ratón
        final Point[] mousePos = new Point[1];

        // MouseMotionListener para el movimiento del ratón
        list.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePos[0] = e.getPoint();  // Actualizar la posición del ratón
                list.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Cambiar cursor a mano

                // Realizar el repaint para actualizar el renderizado
                list.repaint();
            }
        });

        // Configuración del renderizador de celdas para resaltar el elemento debajo del ratón
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (mousePos[0] != null) {
                    int hoverIndex = list.locationToIndex(mousePos[0]); // Obtener el índice del ítem debajo del ratón
                    if (index == hoverIndex) {
                        // Cambiar el fondo del ítem cuando el ratón pasa por encima
                        c.setBackground(Color.LIGHT_GRAY);
                    } else if (isSelected) {
                        c.setBackground(Color.DARK_GRAY);  // Mantener el color de fondo para los elementos seleccionados
                        c.setForeground(Color.WHITE);
                    } else {
                        c.setBackground(list.getBackground());  // Mantener el fondo normal si no está seleccionado ni en hover
                        c.setForeground(list.getForeground());
                    }
                }

                return c;
            }
        });

        // MouseListener para manejar la selección solo al hacer clic
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = list.locationToIndex(e.getPoint());
                if (selectedIndex > -1) {
                    // Aquí puedes manejar la acción de seleccionar un ítem
                    System.out.println("Ítem seleccionado: " + list.getModel().getElementAt(selectedIndex));
                }
            }
        });
    }

}
