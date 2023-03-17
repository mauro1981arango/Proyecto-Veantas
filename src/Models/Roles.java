package Models;


public class Roles {
  
    private int id_rol;
    private String nombre_rol;
    private String estado;

    public Roles() {
    }

    public Roles(int id_rol, String nombre_rol, String estado) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.estado = estado;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
