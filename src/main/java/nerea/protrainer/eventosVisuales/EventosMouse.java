package nerea.protrainer.eventosVisuales;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 * @author Nerea
 */
public class EventosMouse {

    public static void configurarEventos(JButton jBttnAccess, JLabel jLblWeb) {
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

    public static void resaltarBotones(JButton... botones) {
        for (JButton boton : botones) {
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    boton.setFont(boton.getFont().deriveFont(16f));
                    boton.setPreferredSize(new Dimension(boton.getWidth() + 5, boton.getHeight() + 5));
                    boton.revalidate();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    boton.setBorder(UIManager.getBorder("Button.border"));
                    boton.setFont(boton.getFont().deriveFont(14f));
                    boton.setPreferredSize(new Dimension(boton.getWidth() - 5, boton.getHeight() - 5));
                    boton.revalidate();
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

    public static void cambiarCursorEnJList(JList<?> list) {
        final Point[] mousePos = {null};

        list.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePos[0] = e.getPoint();
                list.setCursor(new Cursor(Cursor.HAND_CURSOR));
                list.repaint();
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                mousePos[0] = null; 
                list.repaint();
            }
        });

        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (mousePos[0] != null) {
                    int hoverIndex = list.locationToIndex(mousePos[0]);
                    Rectangle rect = list.getCellBounds(hoverIndex, hoverIndex);

                    if (hoverIndex == index && rect != null && rect.contains(mousePos[0])) {
                        c.setBackground(Color.LIGHT_GRAY);
                    } else if (isSelected) {
                        c.setBackground(Color.DARK_GRAY);
                        c.setForeground(Color.WHITE);
                    } else {
                        c.setBackground(list.getBackground());
                        c.setForeground(list.getForeground());
                    }
                }

                return c;
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = list.locationToIndex(e.getPoint());
                if (selectedIndex > -1) {
                    System.out.println("Elemento seleccionado: " + list.getModel().getElementAt(selectedIndex));
                }
            }
        });
    }
}
