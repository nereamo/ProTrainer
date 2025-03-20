
package nerea.protrainer.dto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
* @author Nerea
*/

public class ExercicisTableModel extends AbstractTableModel{
    
    private List<Exercicis> exercicis;
    private final String[] columnNames = {"Nombre", "Descripción", "Foto Demo"};

    public ExercicisTableModel(List<Exercicis> exercicis) {
        this.exercicis = exercicis;
    }

    @Override
    public int getRowCount() {
        return exercicis.size();
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
        Exercicis exercici = exercicis.get(rowIndex);
        switch (columnIndex) {
            case 0: return exercici.getNomExercici();
            case 1: return exercici.getDescripcio();
            case 2: return exercici.getDemoFoto();
            default: return null;
        }
    }

    public void setExercicis(List<Exercicis> exercicis) {
        this.exercicis = exercicis;
        fireTableDataChanged();
    }
}
