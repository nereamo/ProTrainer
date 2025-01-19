package nerea.protrainer.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import nerea.protrainer.dataAccess.DataAccess;
import static nerea.protrainer.dataAccess.DataAccess.getConnection;

/**
 * @author Nerea
 */
public class Exercicis {

    private int id;
    private String NomExercici;
    private String Descripcio;
    private byte[] DemoFoto;

    public Exercicis() {
    }

    public Exercicis(int id, String NomExercici, String Descripcio) {
        this.id = id;
        this.NomExercici = NomExercici;
        this.Descripcio = Descripcio;
    }

    public String toString() {
        return this.NomExercici;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomExercici() {
        return NomExercici;
    }

    public void setNomExercici(String NomExercici) {
        this.NomExercici = NomExercici;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String Descripcio) {
        this.Descripcio = Descripcio;
    }

    public byte[] getDemoFoto() {
        return DemoFoto;
    }

    public void setDemoFoto(byte[] DemoFoto) {
        this.DemoFoto = DemoFoto;
    }

    public static ArrayList<Exercicis> exercicisDelWorkout(int workoutId) {
        ArrayList<Exercicis> exercicis = new ArrayList<>();
        
        String sql = """
        SELECT * FROM ExercicisWorkouts ew
        JOIN Exercicis e ON ew.IdExercici = e.Id
        WHERE ew.IdWorkout = ?
        """;
        
        try (Connection conn = DataAccess.getConnection(); 
            PreparedStatement selectStatement = conn.prepareStatement(sql)) {

            selectStatement.setInt(1, workoutId);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercicis exercise = new Exercicis(
                        resultSet.getInt("Id"),
                        resultSet.getString("NomExercici"),
                        resultSet.getString("Descripcio")
                );
                exercicis.add(exercise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercicis;
    }

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercises;
    }

    public boolean actualitzaExercicis() {
        String sql = "UPDATE exercises SET nomExercici = ?, descripcio = ?, demoFoto = ? WHERE id = ?";

        try (Connection conn = DataAccess.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, this.NomExercici);
                ps.setString(2, this.Descripcio);
                ps.setBytes(3, this.DemoFoto);
                ps.setInt(4, this.id);

                int rowsUpdated = ps.executeUpdate();
                return rowsUpdated > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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
}
