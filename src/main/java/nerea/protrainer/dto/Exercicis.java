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

    public Exercicis(int id, String NomExercici, String Descripcio) {
        this.id = id;
        this.nomExercici = NomExercici;
        this.descripcio = Descripcio;
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

    public void setNomExercici(String NomExercici) {
        this.nomExercici = NomExercici;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String Descripcio) {
        this.descripcio = Descripcio;
    }

    public byte[] getDemoFoto() {
        return demoFoto;
    }

    public void setDemoFoto(byte[] DemoFoto) {
        this.demoFoto = DemoFoto;
    }
    
    @Override
    public String toString() {
        return this.nomExercici;
    }
}
