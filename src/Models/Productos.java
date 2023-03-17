package Models;


public class Productos {
    private int id_producto;
    private String codigo;
    private String Descripcion;
    private int cantidad;
    private double precio_compra;
    private double precio_venta;
    private int id_proveedor;
    private int id_medida;
    private int id_categoria;
    private String estado;
    private String proveedor;
    private String medida;
    private String categoria;
    private int id_venta;
    private int id_compra;
    private int id_det_venta;
    private double precio_unitario;
    private double subtotal;
    private int id_cliente;
    private int id_usuario;
    private double total;
    private int pago_con;
    private int devolucion;
    private String fecha;
    
    public Productos() {
    }

    public Productos(int id_producto, String codigo, String Descripcion, int cantidad, double precio_compra, double precio_venta, int id_proveedor, int id_medida, int id_categoria, String estado, String proveedor, String medida, String categoria, int id_venta, int id_compra, int id_det_venta, double precio_unitario, double subtotal, int id_cliente, int id_usuario, double total, int pago_con, int devolucion, String fecha) {
        this.id_producto = id_producto;
        this.codigo = codigo;
        this.Descripcion = Descripcion;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.id_proveedor = id_proveedor;
        this.id_medida = id_medida;
        this.id_categoria = id_categoria;
        this.estado = estado;
        this.proveedor = proveedor;
        this.medida = medida;
        this.categoria = categoria;
        this.id_venta = id_venta;
        this.id_compra = id_compra;
        this.id_det_venta = id_det_venta;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.total = total;
        this.pago_con = pago_con;
        this.devolucion = devolucion;
        this.fecha = fecha;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_medida() {
        return id_medida;
    }

    public void setId_medida(int id_medida) {
        this.id_medida = id_medida;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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

    
}
