
package nerea.protrainer.dto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author Nerea
 */

public class ExercicisTableModel extends AbstractTableModel{
    
    private List<Exercicis> ejerciciosList;
    private final String[] columnNames = {"Nombre", "Descripción", "Foto Demo"};

    public ExercicisTableModel(List<Exercicis> ejercicios) {
        this.ejerciciosList = ejercicios;
    }

    @Override
    public int getRowCount() {
        return ejerciciosList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exercicis exercici = ejerciciosList.get(rowIndex);
        switch (columnIndex) {
            case 0: return exercici.getNomEjercicio();
            case 1: return exercici.getDescripcion();
            case 2: return exercici.getDemoFoto();
            default: return null;
        }
    }

    public void setEjercicios(List<Exercicis> ejercicios) {
        this.ejerciciosList = ejercicios;
        fireTableDataChanged();
    }
}
