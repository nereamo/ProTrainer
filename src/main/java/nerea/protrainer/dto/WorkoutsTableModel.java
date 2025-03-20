
package nerea.protrainer.dto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
* @author Nerea
*/

public class WorkoutsTableModel extends AbstractTableModel{
    
    private List<Workouts> workouts;
    private final String[] columnNames = {"Fecha", "Comentarios"};  // Columnas de la tabla

    public WorkoutsTableModel(List<Workouts> workouts) {
        this.workouts = workouts;
    }

    @Override
    public int getRowCount() {
        return workouts.size();
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
        Workouts workout = workouts.get(rowIndex);
        switch (columnIndex) {
            case 0: return workout.getForDate();
            case 1: return workout.getComments();
            default: return null;
        }
    }

    public void setWorkouts(List<Workouts> workouts) {
        this.workouts = workouts;
        fireTableDataChanged();  // Notifica a la tabla que los datos han cambiado
    }

}
