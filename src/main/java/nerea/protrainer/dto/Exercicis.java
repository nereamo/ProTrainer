package nerea.protrainer.dto;


/**
 * @author Nerea
 */
public class Exercicis {

    private int id;
    private String nomExercici;
    private String descripcio;
    private byte[] demoFoto;

    public Exercicis() {
    }

    public Exercicis(int id, String nomExercici, String descripcio) {
        this.id = id;
        this.nomExercici = nomExercici;
        this.descripcio = descripcio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomExercici() {
        return nomExercici;
    }

    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public byte[] getDemoFoto() {
        return demoFoto;
    }

    public void setDemoFoto(byte[] demoFoto) {
        this.demoFoto = demoFoto;
    }
    
    @Override
    public String toString() {
        return getNomExercici() + " " + getDescripcio();
    }
}
