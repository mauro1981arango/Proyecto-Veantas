package Models;

public class Categorias {
   
    private int id;
    private String categoria;
    private String estado;

    public Categorias() {
    }

    public Categorias(int id, String categoria, String estado) {
        this.id = id;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
