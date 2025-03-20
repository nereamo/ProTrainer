package nerea.protrainer.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static nerea.protrainer.dataAccess.DataAccess.getConnection;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.ExercicisWorkouts;
import nerea.protrainer.dto.Workouts;

/**
 * @author Nerea
 */
public class AccionesBD {

    //----------Método para insertar nuevos entrenamientos en la base de datos----------
    public static void insertarWorkoutBD(int userId, String comments, String forDate) throws SQLException {

        String sql = "INSERT INTO Workouts (ForDate, UserId, Comments) VALUES (?, ?, ?)";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, forDate);
            ps.setInt(2, userId);
            ps.setString(3, comments);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Workouts.class.getName()).log(Level.SEVERE, "Error al guardar el workout", ex);
            throw ex;
        }
    }

    //----------Método para eliminar entrenamientos de la base de datos----------
    public static boolean eliminarWorkoutBD(int workoutId) {

        String sql = "DELETE FROM Workouts WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, workoutId);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                
                System.out.println("No se pudo eliminar el workout con ID: " + workoutId);
                
                return false;
            }
            return true;

        } catch (SQLException e) {
             Logger.getLogger(Workouts.class.getName()).log(Level.SEVERE, "Error al eliminar el workout", e);
            return false;
        }
    }

    //----------Método para insertar nuevos ejercicios en la base de datos----------
    public static void insertarEjerciciosBD(String nombre, String descripcion) {
        String sql = "INSERT INTO Exercicis (NomExercici, Descripcio) VALUES (?, ?)";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ejercicio creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el ejercicio en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //----------Método para eliminar ejercicios de la base de datos----------
    public static boolean eliminaExercicis(int exerciseId) {
        String sql = "DELETE FROM Exercicis WHERE Id = ?";

        try (Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, exerciseId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //----------Método para editar un ejercicio de la base de datos----------
    public static boolean actualizarEjerciciosBD(Exercicis exercise) {
        String sql = "UPDATE Exercicis SET NomExercici = ?, Descripcio = ? WHERE Id = ?";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, exercise.getNomExercici());
            ps.setString(2, exercise.getDescripcio());
            ps.setInt(3, exercise.getId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

     //----------Método para asignar un ejercicio a un entrenamiento----------
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
