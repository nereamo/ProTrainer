
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


    public static Usuari loginUsuari(String emailInstructor) {
        Usuari user = new Usuari();
        String sql = "SELECT * FROM Usuaris WHERE Email=?"; 

        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
  
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

}
