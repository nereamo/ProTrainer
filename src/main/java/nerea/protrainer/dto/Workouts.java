package nerea.protrainer.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import nerea.protrainer.dataAccess.DataAccess;
import static nerea.protrainer.dataAccess.DataAccess.getConnection;

/**
* @author Nerea
*/

public class Workouts {
    
    private int id;
    private String ForDate;
    private String Comments;
    private int userId;
    private List<Exercicis> exercises;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForDate() {
        return ForDate;
    }

    public void setForDate(String ForDate) {
        this.ForDate = ForDate;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }
    
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

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workoutsUser;
    }
    
    public static ArrayList<Workouts> workoutsBD() {
        ArrayList<Workouts> allWorkouts = new ArrayList<>();
        String sql = "SELECT * FROM Workouts";

        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Workouts workout = new Workouts();
                workout.setId(rs.getInt("Id"));
                workout.setForDate(rs.getString("ForDate"));
                workout.setUserId(rs.getInt("UserId"));
                workout.setComments(rs.getString("Comments"));
                allWorkouts.add(workout);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allWorkouts;
    }
    
    public static void guardarWorkout(int userId, String comments, String forDate) throws SQLException {

        String query = "INSERT INTO Workouts (ForDate, UserId, Comments) VALUES (?, ?, ?)";

        try (Connection conn = DataAccess.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            // Asignar valores a la declaración preparada
            stmt.setString(1, forDate);  // Asigna ForDate como String en formato "yyyy-MM-dd HH:mm:ss"
            stmt.setInt(2, userId);  // Asigna UserId
            stmt.setString(3, comments);  // Asigna Comments
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Workouts.class.getName()).log(Level.SEVERE, "Error al guardar el workout", ex);
            throw ex;
        }
    }
    

    public static boolean eliminarWorkout(int workoutId) {

        String query = "DELETE FROM Workouts WHERE id = ?";
        try (Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, workoutId);
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
