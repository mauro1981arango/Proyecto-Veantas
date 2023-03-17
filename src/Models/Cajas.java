package Models;

public class Cajas {
    private int id_caja;
    private int id_detalle_cajas;
    private String nombre_caja;
    private String fecha_apertura;
    private String fecha_cierre;
    private Double monto_inicial;
    private Double monto_final;
    private int total_ventas;
    private int id_usuario;
    private String nombre;
    private String estado;

    public Cajas() {
    }

    public Cajas(int id_caja, int id_detalle_cajas, String nombre_caja, String fecha_apertura, String fecha_cierre, Double monto_inicial, Double monto_final, int total_ventas, int id_usuario, String nombre, String estado) {
        this.id_caja = id_caja;
        this.id_detalle_cajas = id_detalle_cajas;
        this.nombre_caja = nombre_caja;
        this.fecha_apertura = fecha_apertura;
        this.fecha_cierre = fecha_cierre;
        this.monto_inicial = monto_inicial;
        this.monto_final = monto_final;
        this.total_ventas = total_ventas;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public int getId_detalle_cajas() {
        return id_detalle_cajas;
    }

    public void setId_detalle_cajas(int id_detalle_cajas) {
        this.id_detalle_cajas = id_detalle_cajas;
    }

    public String getNombre_caja() {
        return nombre_caja;
    }

    public void setNombre_caja(String nombre_caja) {
        this.nombre_caja = nombre_caja;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public Double getMonto_inicial() {
        return monto_inicial;
    }

    public void setMonto_inicial(Double monto_inicial) {
        this.monto_inicial = monto_inicial;
    }

    public Double getMonto_final() {
        return monto_final;
    }

    public void setMonto_final(Double monto_final) {
        this.monto_final = monto_final;
    }

    public int getTotal_ventas() {
        return total_ventas;
    }

    public void setTotal_ventas(int total_ventas) {
        this.total_ventas = total_ventas;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
