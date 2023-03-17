package Models;


public class Medidas {
    private int id;
    private String medida;
    private String nombre_corto;
    private String estado;

    public Medidas() {
    }

    public Medidas(int id, String medida, String nombre_corto, String estado) {
        this.id = id;
        this.medida = medida;
        this.nombre_corto = nombre_corto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
