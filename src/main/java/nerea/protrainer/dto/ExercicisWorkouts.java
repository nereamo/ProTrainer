package nerea.protrainer.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nerea.protrainer.dataAccess.DataAccess;

/**
 * @author Nerea
 */
public class ExercicisWorkouts {

    private int id;
    private int idWorkout;
    private int idExercici;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdWorkout() {
        return idWorkout;
    }

    public void setIdWorkout(int idWorkout) {
        this.idWorkout = idWorkout;
    }

    public int getIdExercici() {
        return idExercici;
    }

    public void setIdExercici(int idExercici) {
        this.idExercici = idExercici;
    }

    public List<Exercicis> exercicisDelWorkout(int workoutId) {
        List<Exercicis> exercises = new ArrayList<>();
        
        String sql = "SELECT e.Id, e.NomExercici, e.Descripcio "
                + "FROM Exercicis e "
                + "JOIN ExercicisWorkouts ew ON e.Id = ew.IdExercici "
                + "WHERE ew.IdWorkout = ?";
        
        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, workoutId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Exercicis exercici = new Exercicis(
                        rs.getInt("Id"),
                        rs.getString("NomExercici"),
                        rs.getString("Descripcio")
                );
                exercises.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }

    public List<Workouts> WorkoutDelExercici(int exerciciId) {
        List<Workouts> workouts = new ArrayList<>();
        
        String sql = "SELECT w.* FROM Workouts w "
                + "JOIN EjercicisWorkouts ew ON w.Id = ew.IdWorkout "
                + "WHERE ew.IdExercici = ?";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, exerciciId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Workouts workout = new Workouts();
                workout.setId(rs.getInt("Id"));
                workout.setForDate(rs.getString("ForDate"));
                workout.setComments(rs.getString("Comments"));
                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workouts;
    }

    public void asignarExerciciWorkout(ExercicisWorkouts workoutExercici) throws SQLException {

        String sql = "INSERT INTO ExercicisWorkouts (idWorkout, idExercici) VALUES (?, ?)";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, workoutExercici.getIdWorkout());
            ps.setInt(2, workoutExercici.getIdExercici());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ejercicio añadido al workout con éxito.");
            } else {
                System.out.println("No se pudo añadir el ejercicio al workout.");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
