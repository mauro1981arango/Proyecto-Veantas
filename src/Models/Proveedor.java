package Models;


public class Proveedor {
    private int id;
    private String nit;
    private String proveedor;
    private String telefono;
    private String direccion;
    private String estado;

    public Proveedor() {
    }

    public Proveedor(int id) {
        this.id = id;
    }

    public Proveedor(int id, String proveedor) {
        this.id = id;
        this.proveedor = proveedor;
    }

    public Proveedor(int id, String nit, String proveedor, String telefono, String direccion, String estado) {
        this.id = id;
        this.nit = nit;
        this.proveedor = proveedor;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   @Override
    public String toString(){
        return this.getProveedor();
    } 
    
//    @Override
//    public boolean equals(Object obj){
//        return this.getId() == ((Proveedor) obj).id;
//    }
}
