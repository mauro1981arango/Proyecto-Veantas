package Models;


public class Configuracion {
   
    private int id_conf;
    private String nit;
    private String nombreEmpresa;
    private String telefono;
    private String direccion;
    private String mensaje;

    public Configuracion() {
    }

    public Configuracion(int id_conf, String nit, String nombreEmpresa, String telefono, String direccion, String mensaje) {
        this.id_conf = id_conf;
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mensaje = mensaje;
    }

    public int getId_conf() {
        return id_conf;
    }

    public void setId_conf(int id_conf) {
        this.id_conf = id_conf;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
