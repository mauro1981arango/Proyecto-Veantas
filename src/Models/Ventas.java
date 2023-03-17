package Models;

public class Ventas {

    private int id_venta;
    private double total;
    private int pago_con;
    private int devolucion;
    private String fecha;
    private int id_det_venta;
    private double precio_unitario;
    private int cantidad;
    private double subtotal;
    private int id_producto;
    private int id_cliente;
    private int id_usuario;
    private String descripcion;
    private double precio_venta;
    private String codigo;
    private String caja;
    private String nombre;
    private String nombre_cliente;
    private String telefono;
    private String direccion;
    private String rol;
    private String estado;
    private String Cliente;
    private int id_caja;
    private String nombre_caja;

    public Ventas() {
    }

    public Ventas(int id_venta, double total, int pago_con, int devolucion, String fecha, int id_det_venta, double precio_unitario, int cantidad, double subtotal, int id_producto, int id_cliente, int id_usuario, String descripcion, double precio_venta, String codigo, String caja, String nombre, String nombre_cliente, String telefono, String direccion, String rol, String estado, String Cliente, int id_caja, String nombre_caja) {
        this.id_venta = id_venta;
        this.total = total;
        this.pago_con = pago_con;
        this.devolucion = devolucion;
        this.fecha = fecha;
        this.id_det_venta = id_det_venta;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.id_producto = id_producto;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.codigo = codigo;
        this.caja = caja;
        this.nombre = nombre;
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.estado = estado;
        this.Cliente = Cliente;
        this.id_caja = id_caja;
        this.nombre_caja = nombre_caja;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPago_con() {
        return pago_con;
    }

    public void setPago_con(int pago_con) {
        this.pago_con = pago_con;
    }

    public int getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(int devolucion) {
        this.devolucion = devolucion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_det_venta() {
        return id_det_venta;
    }

    public void setId_det_venta(int id_det_venta) {
        this.id_det_venta = id_det_venta;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getNombre_caja() {
        return nombre_caja;
    }

    public void setNombre_caja(String nombre_caja) {
        this.nombre_caja = nombre_caja;
    }

   
}
