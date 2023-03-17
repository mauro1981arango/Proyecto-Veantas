package Controllers;

import Models.Combo;
import Models.Tables;
import Models.Productos;
import Models.ProductosDAO;
import Views.PanelAdmin;
import Views.Print;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class ProductosControllers implements ActionListener, MouseListener, KeyListener {

    private Productos pro;
    private final ProductosDAO proDao;
    private final PanelAdmin views;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel dft;

    public ProductosControllers(Productos pro, ProductosDAO proDao, PanelAdmin views) {
        this.pro = pro;
        this.proDao = proDao;
        this.views = views;
        this.views.btnRegistrarProducto.addActionListener(this);
        this.views.btnModificarProducto.addActionListener(this);
        this.views.btnNuevoProducto.addActionListener(this);
        this.views.btnGenerarCompra.addActionListener(this);
        this.views.jMenuEliminarProducto.addActionListener(this);
        this.views.jMenuReingresarProducto.addActionListener(this);
        this.views.lblProductos.addMouseListener(this);
        this.views.tblProductos.addMouseListener(this);
        this.views.lblNuevaCompra.addMouseListener(this);
        this.views.lblNuevaVenta.addMouseListener(this);
        this.views.lblConfiguracion.addMouseListener(this);
        this.views.txtCodProCompra.addKeyListener(this);
        this.views.txtCantidadCompra.addKeyListener(this);
        this.views.txtPagarConLaCompra.addKeyListener(this);

        this.views.btnGenerarVenta.addActionListener(this);
        this.views.btnBuscarUsuarios.addActionListener(this);
        this.views.txtCodProVenta.addKeyListener(this);
        this.views.txtNombreProVenta.addActionListener(this);
        this.views.txtPrecioVentaProducto.addActionListener(this);
//        this.views.txtTotalVenta.addActionListener(this);
        this.views.txtStockProVenta.addActionListener(this);
        this.views.cbxClienteVenta.addActionListener(this);
        this.views.txtPagarCon.addKeyListener(this);
        this.views.txtDevolucionCliente.addKeyListener(this);
        this.views.lblTotalPagarVenta.addKeyListener(this);
        this.views.tblNuevaVenta.addMouseListener(this);
        this.views.txtIdProductoVenta.setVisible(true);
        this.views.txtCantidadProVenta.addKeyListener(this);
        listarProductos();
        this.views.txtIdProducto.setVisible(false);
        this.views.txtIdProdCompra.setVisible(false);
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarProducto) {
            // Se valida que las cajas de texto no están vacías
            if (views.txtCodigo.getText().equals("") || views.txtDescripcion.getText().equals("") || views.txtPrecioCompra.getText().equals("") || views.txtPrecioVenta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Se hace la inserción
                pro.setCodigo(views.txtCodigo.getText());
                pro.setDescripcion(views.txtDescripcion.getText());
                pro.setPrecio_compra(Double.parseDouble(views.txtPrecioCompra.getText()));
                pro.setPrecio_venta(Double.parseDouble(views.txtPrecioVenta.getText()));
                //pro.setId_proveedor(views.cbxProveedor.getSelectedIndex());
                Combo itemProveedor = (Combo) views.cbxProveedor.getSelectedItem();
                Combo itemMedidas = (Combo) views.cbxMedidas.getSelectedItem();
                Combo itemCategorias = (Combo) views.cbxCategorias.getSelectedItem();
                pro.setId_proveedor(itemProveedor.getId());
                pro.setId_medida(itemMedidas.getId());
                pro.setId_categoria(itemCategorias.getId());
                if (proDao.RegistrarProducto(pro)) {
                    LimpiarTable();
                    listarProductos();
                    LimpiarProductos();
                    // Si devuelve true se ha registrado el producto.
                    JOptionPane.showMessageDialog(null, "Producto registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.btnModificarProducto) {
            // Se valida que la caja de texto txtIdProducto no está vacía
            if (views.txtIdProducto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Primero debe selecionar un producto");
            } else {
                // Se hace la inserción
                pro.setCodigo(views.txtCodigo.getText());
                pro.setDescripcion(views.txtDescripcion.getText());
                pro.setPrecio_compra(Double.parseDouble(views.txtPrecioCompra.getText()));
                pro.setPrecio_venta(Double.parseDouble(views.txtPrecioVenta.getText()));
                //pro.setId_proveedor(views.cbxProveedor.getSelectedIndex());
                Combo itemProveedor = (Combo) views.cbxProveedor.getSelectedItem();
                Combo itemMedidas = (Combo) views.cbxMedidas.getSelectedItem();
                Combo itemCategorias = (Combo) views.cbxCategorias.getSelectedItem();
                pro.setId_proveedor(itemProveedor.getId());
                pro.setId_medida(itemMedidas.getId());
                pro.setId_categoria(itemCategorias.getId());
                pro.setId_producto(Integer.parseInt(views.txtIdProducto.getText()));
                if (proDao.ModificarProducto(pro)) {
                    LimpiarTable();
                    listarProductos();
                    LimpiarProductos();
                    // Si devuelve true se ha modificado el producto
                    JOptionPane.showMessageDialog(null, "Producto Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuEliminarProducto) {
            // Se valida que la caja de texto txtIdProducto no está vacía
            if (views.txtIdProducto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdProducto.getText());
                // Se llama el método accion de la clase ProductoDAO
                if (proDao.accion("Inactivo", id)) {
                    LimpiarTable();
                    listarProductos();
                    LimpiarProductos();
                    // Si devuelve true se ha dado de baja el producto
                    JOptionPane.showMessageDialog(null, "Producto dado de baja");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuReingresarProducto) {
            // Se valida que la caja de texto txtIdProducto no está vacía
            if (views.txtIdProducto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {

                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdProducto.getText());
                // Se llama el método accion de la clase ProveedorDAO
                if (proDao.accion("Activo", id)) {
                    LimpiarTable();
                    listarProductos();
                    // Si devuelve true se ha dado de baja el proveedor
                    JOptionPane.showMessageDialog(null, "Producto Reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.btnGenerarCompra) {
            InsertarCompra();
            LimpiarProductos();
            LimpiarVistaCompra();
            views.txtCodigo.requestFocus();
            views.btnRegistrarProducto.setEnabled(true);
            proDao.generarReporteCompra(0);
        } else if (e.getSource() == views.btnGenerarVenta) {
            Combo itemCliente = (Combo) views.cbxClienteVenta.getSelectedItem();
            pro.setId_cliente(itemCliente.getId());
            GuardarVenta();
            LimpiarVistaVenta();
            LimpiarVenta();
            views.txtCodProVenta.requestFocus();
            views.btnGenerarVenta.setEnabled(true);
            proDao.generarReporteVentas(0);
        } else {
            LimpiarProductos();
            //JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }

    public void listarProductos() {
        Tables color = new Tables();
        views.tblProductos.setDefaultRenderer(views.tblProductos.getColumnClass(0), color);
        List<Productos> listaProductos = proDao.ListaProductos(views.txtBuscarProduct.getText());
        modelo = (DefaultTableModel) views.tblProductos.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < listaProductos.size(); i++) {
            obj[0] = listaProductos.get(i).getId_producto();
            obj[1] = listaProductos.get(i).getCodigo();
            obj[2] = listaProductos.get(i).getDescripcion();
            obj[3] = listaProductos.get(i).getPrecio_venta();
            obj[4] = listaProductos.get(i).getCantidad();
            obj[5] = listaProductos.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblProductos.setModel(modelo);
        JTableHeader header = views.tblProductos.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.GREEN);
        header.setForeground(Color.BLACK);
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void LimpiarTableDetalle() {
        for (int i = 0; i < dft.getRowCount(); i++) {
            dft.removeRow(i);
            i = i - 1;
        }
    }

    public void LimpiarProductos() {
        views.txtIdProducto.setText("");
        views.txtCodigo.setText("");
        views.txtDescripcion.setText("");
        views.txtPrecioCompra.setText("");
        views.txtPrecioVenta.setText("");
        views.txtBuscarProduct.setText("");
        views.cbxProveedor.setSelectedIndex(0);
        views.cbxMedidas.setSelectedIndex(0);
        views.cbxCategorias.setSelectedIndex(0);
        views.txtCodigo.requestFocus();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblProductos) {
            int fila = views.tblProductos.rowAtPoint(e.getPoint());
            views.txtIdProducto.setText(views.tblProductos.getValueAt(fila, 0).toString());
            pro = proDao.BuscarProducto(Integer.parseInt(views.txtIdProducto.getText()));
            views.txtCodigo.setText(pro.getCodigo());
            views.txtDescripcion.setText(pro.getDescripcion());
            views.txtPrecioCompra.setText("" + pro.getPrecio_compra());
            views.txtPrecioVenta.setText("" + pro.getPrecio_venta());
            views.cbxProveedor.setSelectedItem(new Combo(pro.getId_proveedor(), pro.getProveedor()));
            views.cbxMedidas.setSelectedItem(new Combo(pro.getId_medida(), pro.getMedida()));
            views.cbxCategorias.setSelectedItem(new Combo(pro.getId_categoria(), pro.getCategoria()));
            views.btnRegistrarProducto.setEnabled(false);
        } else if (e.getSource() == views.lblProductos) {
            // Al dar clip en proveedores del menú principal se abre la vista Proveedores
            views.jTabbedPane1.setSelectedIndex(10);
        } else if (e.getSource() == views.lblNuevaCompra) {
            // Al dar clip en Nueva Venta del menú principal se abre la vista Compra
            views.jTabbedPane1.setSelectedIndex(7);
            views.txtCodProCompra.requestFocus();
        } else if (e.getSource() == views.lblNuevaVenta) {
            // Al dar clip en Nueva Venta del menú principal se abre la vista Nueva Venta
            views.jTabbedPane1.setSelectedIndex(9);
            views.txtCodProVenta.requestFocus();
        } else if (e.getSource() == views.lblConfiguracion) {
            // Al dar clip en Nueva Venta del menú principal se abre la vista Configuracion
            views.jTabbedPane1.setSelectedIndex(6);
            views.txtNitNegocio.requestFocus();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == views.txtCodProCompra) { // Agregar productos temporales a la compra
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String cod = views.txtCodProCompra.getText();
                buscarProductos(views.txtCodProCompra, cod, views.txtIdProdCompra, views.txtNombreProCompra, views.txtPrecCompra, views.txtCantidadCompra);

            }
        } // Agregar productos temporales a la venta
        else if (e.getSource() == views.txtCodProVenta) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String cod = views.txtCodProVenta.getText();
                buscarProductosVenta(views.txtCodProVenta, cod, views.txtIdProductoVenta, views.txtNombreProVenta, views.txtPrecioVentaProducto, views.txtCantidadProVenta, views.txtStockProVenta);
// Captura de algunos item del producto para realizar una compra
            }
        } else if (e.getSource() == views.txtCantidadCompra) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int cant = Integer.parseInt(views.txtCantidadCompra.getText());
                String descripcion = views.txtNombreProCompra.getText();
                Double precio = Double.parseDouble(views.txtPrecCompra.getText());
                int idProd = Integer.parseInt(views.txtIdProdCompra.getText());
                agregarTemp(cant, descripcion, precio, idProd, views.tblNuevaCompra, views.txtCodProCompra);
                LimpiarCompra();
                CalcularTotal(views.tblNuevaCompra, views.lblTotalPagarCompra);
            } // Captura elementos del producto para realizar una venta
        } else if (e.getSource() == views.txtCantidadProVenta) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (views.txtCantidadProVenta.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad");
                } else {
                    int cant = Integer.parseInt(views.txtCantidadProVenta.getText());
                    int stock = Integer.parseInt(views.txtStockProVenta.getText());
                    if (cant > stock) {
                        JOptionPane.showMessageDialog(null, "Stock no disponible");
                    } else {
                        String descripcion = views.txtNombreProVenta.getText();
                        double precio = Double.parseDouble(views.txtPrecioVentaProducto.getText());
                        int idProd = Integer.parseInt(views.txtIdProductoVenta.getText());
                        views.txtCantidadProVenta.setText("" + cant);
                        agregarTemp(cant, descripcion, precio, idProd, views.tblNuevaVenta, views.txtCodProVenta);
                        LimpiarVenta();
                        CalcularTotal(views.tblNuevaVenta, views.lblTotalPagarVenta);
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int cantidad;
        Double precio;
        if (e.getSource() == views.txtBuscarProduct || e.getSource() == views.txtCantidadCompra) {
            if (views.txtCantidadCompra.getText().equals("")) {
                LimpiarTable();
                listarProductos();
                precio = Double.parseDouble(views.txtPrecCompra.getText());
                views.txtTotalCompra.setText("" + precio);
            } else {
                cantidad = Integer.parseInt(views.txtCantidadCompra.getText());
                precio = Double.parseDouble(views.txtPrecCompra.getText());
                views.txtTotalCompra.setText("" + cantidad * precio);
            }
        } else if (e.getSource() == views.txtPagarConLaCompra) {
            int pagarCon;
            if (views.txtPagarConLaCompra.getText().equals("")) {
                views.txtDevueltaNuevaCompra.setText("");
            } else {
                pagarCon = Integer.parseInt(views.txtPagarConLaCompra.getText());
                double total = Double.parseDouble(views.lblTotalPagarCompra.getText());
                views.txtDevueltaNuevaCompra.setText("" + (pagarCon - total));
            }
            if (views.txtPagarConLaCompra.getText().equals("")) {
                views.txtDevueltaNuevaCompra.setText("");
            } else {
                pagarCon = Integer.parseInt(views.txtPagarConLaCompra.getText());
                double total = Double.parseDouble(views.lblTotalPagarCompra.getText());
                views.txtDevueltaNuevaCompra.setText("" + (pagarCon - total));
            }
        } else if (e.getSource() == views.txtHistorialCompras) {
            views.jTabbedPane1.setSelectedIndex(0);
            LimpiarTable();
            listarProductos();
        } else if (e.getSource() == views.txtPagarCon) {
            int pagarCon;
            if (views.txtPagarCon.getText().equals("")) {
                views.txtDevolucionCliente.setText("");
            } else {
                pagarCon = Integer.parseInt(views.txtPagarCon.getText());
                double total = Double.parseDouble(views.lblTotalPagarVenta.getText());
                views.txtDevolucionCliente.setText("" + (pagarCon - total));
            }
        } else if (e.getSource() == views.txtBuscarProduct) {
            views.jTabbedPane1.setSelectedIndex(0);
            LimpiarTable();
            listarProductos();
        } else if (e.getSource() == views.btnBuscarUsuarios) {
            listarProductos();
        }
    }

    private void LimpiarCompra() {
        views.txtIdProdCompra.setText("");
        views.txtCodProCompra.setText("");
        views.txtNombreProCompra.setText("");
        views.txtCantidadCompra.setText("");
        views.txtPrecCompra.setText("");
        views.txtTotalCompra.setText("");
    }

    private void LimpiarVistaCompra() {
        views.cbxProveedorCompra.setSelectedIndex(0);
        views.txtPagarConLaCompra.setText("");
        views.txtDevueltaNuevaCompra.setText("");
        views.lblTotalPagarCompra.setText("");
        views.txtCodProCompra.requestFocus();
    }

    private void LimpiarVenta() {
        views.txtIdProductoVenta.setText("");
        views.txtCodProVenta.setText("");
        views.txtNombreProVenta.setText("");
        views.txtCantidadProVenta.setText("");
        views.txtPrecioVentaProducto.setText("");
        views.txtStockProVenta.setText("");
    }

    private void LimpiarVistaVenta() {
        views.cbxClienteVenta.setSelectedIndex(0);
        views.txtPagarCon.setText("");
        views.txtDevolucionCliente.setText("");
        views.lblTotalPagarVenta.setText("");
        views.txtCodProVenta.requestFocus();
    }

    private void CalcularTotal(JTable tabla, JLabel totalPagar) {
        Double total = 0.0;
        int numFilas = tabla.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            total = total + Double.valueOf(String.valueOf(tabla.getValueAt(i, 4)));
        }
        totalPagar.setText("" + total);
    }

    private void InsertarCompra() {
        Combo idP = (Combo) views.cbxProveedorCompra.getSelectedItem();
        int Id_proveedor = idP.getId();
        int id_usuario = Integer.parseInt(views.lblIdUsuario.getText());
        String total = views.lblTotalPagarCompra.getText();

        if (proDao.RegistrarCompra(Id_proveedor, id_usuario, total)) {
            int id_compra = proDao.idCompra();
            for (int i = 0; i < views.tblNuevaCompra.getRowCount(); i++) {
                int idProducto = Integer.parseInt(views.tblNuevaCompra.getValueAt(i, 0).toString());
                double precio = Double.parseDouble(views.tblNuevaCompra.getValueAt(i, 3).toString());
                int cantidad = Integer.parseInt(views.tblNuevaCompra.getValueAt(i, 2).toString());
                double sub_total = precio * cantidad;
                proDao.RegistrarDetalleCompra(id_compra, idProducto, precio, cantidad, sub_total);
                pro = proDao.BuscarId(idProducto);
                int stockActual = pro.getCantidad() + cantidad;
                proDao.ActualizarStock(stockActual, idProducto);
            }
            LimpiarTableDetalle();
            views.txtCodProCompra.requestFocus();
            JOptionPane.showMessageDialog(null, "Compra Generada");
//            Print p = new Print(id_compra);
//            p.setVisible(true);
        }
    }

//    Se inserta la venta
    private void GuardarVenta() {
        double totalVenta = Double.parseDouble(views.lblTotalPagarVenta.getText());
        int pagoCon = Integer.parseInt(views.txtPagarCon.getText());
        String devuelta = views.txtDevolucionCliente.getText();
        int idUsuario = Integer.parseInt(views.lblIdUsuario.getText());
        if (proDao.RegistrarVenta(totalVenta, pagoCon, devuelta, idUsuario)) {
            int id_venta = proDao.idVenta();
            Combo id_cliente = (Combo) views.cbxClienteVenta.getSelectedItem();
            int Id_cliente = id_cliente.getId();
            idUsuario = Integer.parseInt(views.lblIdUsuario.getText());
            for (int i = 0; i < views.tblNuevaVenta.getRowCount(); i++) {
                int idProducto = Integer.parseInt(views.tblNuevaVenta.getValueAt(i, 0).toString());
                double precio = Double.parseDouble(views.tblNuevaVenta.getValueAt(i, 3).toString());
                int cantidad = Integer.parseInt(views.tblNuevaVenta.getValueAt(i, 2).toString());
                double sub_total = precio * cantidad;
                proDao.RegistrarDetalleventa(id_venta, precio, cantidad, sub_total, idProducto, Id_cliente, idUsuario);
                pro = proDao.BuscarId(idProducto);
                int stockActual = pro.getCantidad() - cantidad;
                proDao.ActualizarStock(stockActual, idProducto);
            }
            LimpiarTableDetalle();
            views.txtCodProVenta.requestFocus();
            JOptionPane.showMessageDialog(null, "Venta Generada");
            Print p = new Print(id_venta);
            //p.setVisible(true);
        }
    }
//    Agregar productos para la compra y venta

    private void agregarTemp(int cant, String descripcion, Double precio, int idProd, JTable tabla, JTextField codigo) {
        if (cant > 0) {
            dft = (DefaultTableModel) tabla.getModel();
            ArrayList lista = new ArrayList();
            int item = 1;
            lista.add(item);
            lista.add(idProd);
            lista.add(descripcion);
            lista.add(cant);
            lista.add(precio);
            lista.add(cant * precio);
            Object[] obj = new Object[5];
            obj[0] = lista.get(1);
            obj[1] = lista.get(2);
            obj[2] = lista.get(3);
            obj[3] = lista.get(4);
            obj[4] = lista.get(5);
            dft.addRow(obj);
            tabla.setModel(dft);
            codigo.requestFocus();

        }
    }
//    Buscar producto para la compra y venta

    private void buscarProductos(JTextField codigo, String cod, JTextField Id, JTextField producto, JTextField precio, JTextField cantidad) {
        if (codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe selecionar un código de un producto");
        } else {
            pro = proDao.BuscarCodigo(cod);
            Id.setText("" + pro.getId_producto());
            producto.setText(pro.getDescripcion());
            precio.setText("" + pro.getPrecio_compra());
            cantidad.requestFocus();
        }
    }

    private void buscarProductosVenta(JTextField codigo, String cod, JTextField Id, JTextField producto, JTextField precio, JTextField cantidad, JTextField stock) {
        if (codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe selecionar un código de un producto");
        } else {
            pro = proDao.BuscarCodigo(cod);
            if (pro.getId_producto() > 0) {
                Id.setText("" + pro.getId_producto());
                producto.setText(pro.getDescripcion());
                precio.setText("" + pro.getPrecio_venta());
                stock.setText("" + pro.getCantidad());
                cantidad.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe o está Inactivo");
            }
        }
    }
}
