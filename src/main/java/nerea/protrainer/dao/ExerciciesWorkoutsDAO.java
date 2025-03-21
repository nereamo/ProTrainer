
package nerea.protrainer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nerea.protrainer.dataAccess.DataAccess;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.Workouts;

/**
* @author Nerea
*/

public class ExerciciesWorkoutsDAO {
    
    //----------ArrayList que almacena los ejercicios pertenecientes a un entrenamiento----------
    public static ArrayList<Exercicis> exercicisDelWorkout(int workoutId) {
        ArrayList<Exercicis> exercicis = new ArrayList<>();

        String sql = """
        SELECT * FROM ExercicisWorkouts ew
        JOIN Exercicis e ON ew.IdExercici = e.Id
        WHERE ew.IdWorkout = ?
        """;

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, workoutId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Exercicis exercise = new Exercicis(
                        rs.getInt("Id"),
                        rs.getString("NomExercici"),
                        rs.getString("Descripcio")
                );
                exercicis.add(exercise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercicis;
    }
    
    //----------Método para asignar un ejercicio a un entrenaminto----------
    public static void asignarEjercicioAWorkout(int workoutId, int exerciseId) throws SQLException {
        String sql = "INSERT INTO ExercicisWorkouts (IdWorkout, IdExercici) VALUES (?, ?)";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, workoutId);
            ps.setInt(2, exerciseId);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Workouts.class.getName()).log(Level.SEVERE, "Error al guardar el ejercicio en el workout", ex);
            throw ex;
        }
    }
}
