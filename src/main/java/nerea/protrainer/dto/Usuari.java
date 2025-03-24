package nerea.protrainer.dto;

/**
 * @author Nerea
 */
public class Usuari {

    private int Id;
    private String nom;
    private String email;
    private String passwordHash;
    private byte[] foto;
    private boolean instructor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] Foto) {
        this.foto = Foto;
    }

    public boolean isInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return this.nom;
    }

}
