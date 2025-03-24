package nerea.protrainer.dto;

/**
 * @author Nerea
 */
public class Exercicis {

    private int id;
    private String nomEjercicio;
    private String descripcion;
    private byte[] demoFoto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEjercicio() {
        return nomEjercicio;
    }

    public void setNomExercici(String nomEjercicio) {
        this.nomEjercicio = nomEjercicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getDemoFoto() {
        return demoFoto;
    }

    public void setDemoFoto(byte[] demoFoto) {
        this.demoFoto = demoFoto;
    }

    @Override
    public String toString() {
        return getNomEjercicio() + " " + getDescripcion();
    }
}
