
package nerea.protrainer.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nerea.protrainer.ProTrainer;
import nerea.protrainer.dataAccess.DataAccess;
import static nerea.protrainer.dataAccess.DataAccess.getConnection;

/**
* @author Nerea
*/

public class Usuari {
    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private byte[] Foto;
    private boolean Instructor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public boolean isInstructor() {
        return Instructor;
    }

    public void setInstructor(boolean Instructor) {
        this.Instructor = Instructor;
    }

    //Metodo compara el email introducido con la BD
    public static Usuari loggedUsuari(String emailInstructor) {
        Usuari user = new Usuari();
        String sql = "SELECT * FROM Usuaris WHERE Email=?"; 

        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
  
            ps.setString(1, emailInstructor); 
            ResultSet resultSet = ps.executeQuery();   

            while (resultSet.next()) {

                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

   
    public static List<Usuari> usuariosAsignadosInstructor() {
        List<Usuari> usuaris = new ArrayList<>();
        Usuari instructor = ProTrainer.getLoggedInstructor();

        if (instructor == null) {
            return usuaris;
        }
        int instructorId = instructor.getId();

        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor = ? AND Instructor != 1";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {  // Cierre del paréntesis corregido

            stmt.setInt(1, instructorId);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setFoto(resultSet.getBytes("Foto"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuaris;
    }

}
