package nerea.protrainer.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nerea.protrainer.ProTrainer;
import static nerea.protrainer.dataAccess.DataAccess.getConnection;
import nerea.protrainer.dto.Exercicis;
import nerea.protrainer.dto.Usuari;
import nerea.protrainer.dto.Workouts;

/**
 * @author Nerea
 */
public class ConsultasBD {

    //----------Método para verificar el usuario que inicia sesión----------
    public static Usuari inicioSesionUsuario(String emailInstructor) {
        Usuari user = new Usuari();
        String sql = "SELECT * FROM Usuaris WHERE Email=?";

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emailInstructor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                user.setId(rs.getInt("Id"));
                user.setNom(rs.getString("Nom"));
                user.setEmail(rs.getString("Email"));
                user.setPasswordHash(rs.getString("PasswordHash"));
                user.setInstructor(rs.getBoolean("Instructor"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    //----------Lista que almacena los usuarios asignados a un instructor----------
    public static List<Usuari> usuariosAsignadosInstructor() {
        List<Usuari> usuaris = new ArrayList<>();
        Usuari instructor = ProTrainer.getLoggedInstructor();

        if (instructor == null) {
            return usuaris;
        }

        int instructorId = instructor.getId();

        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor = ? AND Instructor != 1";

        try (Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {  // Cierre del paréntesis corregido

            ps.setInt(1, instructorId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuari user = new Usuari();
                user.setId(rs.getInt("Id"));
                user.setNom(rs.getString("Nom"));
                user.setEmail(rs.getString("Email"));
                user.setPasswordHash(rs.getString("PasswordHash"));
                user.setFoto(rs.getBytes("Foto"));
                user.setInstructor(rs.getBoolean("Instructor"));
                usuaris.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuaris;
    }

    //----------ArrayList que almacena los entrenamientos de la base de datos----------
    public static ArrayList<Workouts> workoutsBD() {
        ArrayList<Workouts> allWorkouts = new ArrayList<>();
        String sql = "SELECT * FROM Workouts";

        try (Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Workouts workout = new Workouts();
                workout.setId(rs.getInt("Id"));
                workout.setForDate(rs.getString("ForDate"));
                workout.setUserId(rs.getInt("UserId"));
                workout.setComments(rs.getString("Comments"));
                allWorkouts.add(workout);
            }
            
            if (allWorkouts.isEmpty()) {
            
            System.out.println("No se encontraron entrenamientos en la base de datos.");
        }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allWorkouts;
    }

    //----------ArrayList que almacena los entrenamientos asignados a un usuario----------
    public static ArrayList<Workouts> workoutUsuari(int userId) {
        ArrayList<Workouts> workoutsUser = new ArrayList<>();
        String sql = "SELECT * FROM Workouts WHERE UserId = ?";

        try (Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Workouts workout = new Workouts();
                workout.setId(rs.getInt("Id"));
                workout.setForDate(rs.getString("ForDate"));
                workout.setComments(rs.getString("Comments"));
                workoutsUser.add(workout);
            }
            
            if (workoutsUser.isEmpty()) {
           
            System.out.println("Este usuario no tiene entrenamientos asignados.");
           
        }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workoutsUser;
    }

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

    //----------ArrayList que almacena los ejercicios de la base de datos----------
    public static ArrayList<Exercicis> exercicisBD() {
        ArrayList<Exercicis> exercises = new ArrayList<>();
        String sql = "SELECT * FROM Exercicis";

        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Exercicis exercise = new Exercicis(
                        rs.getInt("Id"),
                        rs.getString("NomExercici"),
                        rs.getString("Descripcio")
                );
                exercises.add(exercise);
            }
            
            if (exercises.isEmpty()) {
            
            System.out.println("No hay ejercicios disponibles.");
            
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercises;
    }

    //----------List que almacena los wokouts asignados a un ejercicio----------
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

}
