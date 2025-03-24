
package nerea.protrainer.dto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
* @author Nerea
*/

public class WorkoutsTableModel extends AbstractTableModel{
    
    private List<Workouts> workoutsList;
    private final String[] columnNames = {"Fecha", "Comentarios"};

    public WorkoutsTableModel(List<Workouts> workoutsList) {
        this.workoutsList = workoutsList;
    }
    
    @Override
    public int getRowCount() {
        return workoutsList.size();
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
        Workouts workout = workoutsList.get(rowIndex);
        switch (columnIndex) {
            case 0: return workout.getForDate();
            case 1: return workout.getComments();
            default: return null;
        }
    }

    public void setWorkouts(List<Workouts> workoutsList) {
        this.workoutsList = workoutsList;
        fireTableDataChanged();
    }
}
