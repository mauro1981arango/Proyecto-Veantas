package Views;

import Controllers.CajasControllers;
import Controllers.CategoriasControllers;
import Controllers.ClientesControllers;
import Controllers.ComprasControllers;
import Controllers.ConfigControllers;
import Controllers.MedidasControllers;
import Controllers.ProductosControllers;
import Controllers.ProveedorControllers;
import Controllers.UsuariosControllers;
import Controllers.VentasControllers;
import Models.Cajas;
import Models.CajasDAO;
import Models.Categorias;
import Models.CategoriasDAO;
import Models.Clientes;
import Models.ClientesDAO;
import Models.Compras;
import Models.ComprasDAO;
import Models.Configuracion;
import Models.ConfiguracionDAO;
import Models.Medidas;
import Models.MedidasDAO;
import Models.Productos;
import Models.ProductosDAO;
import Models.Proveedor;
import Models.ProveedorDAO;
import Models.Usuarios;
import Models.UsuariosDAO;
import Models.Ventas;
import Models.VentasDAO;


public class PanelAdmin extends javax.swing.JFrame {

    Usuarios usu = new Usuarios();
    UsuariosDAO usuDao = new UsuariosDAO();
    Clientes cl = new Clientes();
    ClientesDAO cliDao = new ClientesDAO();
    Categorias categoria =new Categorias();
    CategoriasDAO catDao = new CategoriasDAO();
    Medidas medida = new Medidas();
    MedidasDAO medDao = new MedidasDAO();
    Proveedor prov = new Proveedor();
    ProveedorDAO provDao = new ProveedorDAO();
    Productos prod = new Productos();
    ProductosDAO prodDao = new ProductosDAO();
    Configuracion conf = new Configuracion();
    ConfiguracionDAO cnfDAO = new ConfiguracionDAO();
    Compras compras = new Compras();
    ComprasDAO compDao = new ComprasDAO();
    Ventas venta = new Ventas();
    VentasDAO vDAO = new VentasDAO();
    Cajas cj = new Cajas();
    CajasDAO cDao = new CajasDAO();
    public PanelAdmin() {
     
    }

    public PanelAdmin(int id_usuario, String nombre) {
        initComponents();
        ConfigControllers controller = new ConfigControllers(conf, cnfDAO, this);
        // Se llama la clase UsuariosControllers
        UsuariosControllers ctrUsuarios = new UsuariosControllers(usu, usuDao, this);
        ClientesControllers ctrClientes = new ClientesControllers(cl, cliDao, this);
        CategoriasControllers ctrlCategorias = new CategoriasControllers(categoria, catDao, this);
        MedidasControllers ctrMedidas = new MedidasControllers(medida, medDao, this);
        ProveedorControllers ctrProveedor = new ProveedorControllers(prov, provDao, this);
        ProductosControllers ctrProductos = new ProductosControllers(prod, prodDao, this);
        ComprasControllers ctrlCompras =new ComprasControllers(compras, compDao, this);
        VentasControllers ctrlVentas =new VentasControllers(venta, vDAO, this);
        CajasControllers ctrlCajas = new CajasControllers(cj, cDao, this);
        // Captura el id de usuario logiado y el nombre.
        lblIdUsuario.setText("" + id_usuario);
        lblNombreUsuario.setText(nombre);
        lblIdUsuario.setVisible(false);
        jTabbedPane1.setSelectedIndex(10);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuUsuarios = new javax.swing.JPopupMenu();
        jMenuEliminarUsuario = new javax.swing.JMenuItem();
        jMenuReingresarUsuario = new javax.swing.JMenuItem();
        jPopupMenuClientes = new javax.swing.JPopupMenu();
        jMenuEliminarCliente = new javax.swing.JMenuItem();
        jMenuReingresarCliente = new javax.swing.JMenuItem();
        jPopupMenuCategorias = new javax.swing.JPopupMenu();
        jMenuEliminarCategoria = new javax.swing.JMenuItem();
        jMenuReingresarCategoria = new javax.swing.JMenuItem();
        jPopupMenuMedidas = new javax.swing.JPopupMenu();
        jMenuEliminarMedida = new javax.swing.JMenuItem();
        jMenuReingresarMedida = new javax.swing.JMenuItem();
        jPopupMenuProveedor = new javax.swing.JPopupMenu();
        jMenuEliminarProveedor = new javax.swing.JMenuItem();
        jMenuReingresarProveedor = new javax.swing.JMenuItem();
        jPopupMenuProducto = new javax.swing.JPopupMenu();
        jMenuEliminarProducto = new javax.swing.JMenuItem();
        jMenuReingresarProducto = new javax.swing.JMenuItem();
        jPopupMenuCajas = new javax.swing.JPopupMenu();
        jMenuEliminarCaja = new javax.swing.JMenuItem();
        jMenuReingresarCaja = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanelClientes = new javax.swing.JPanel();
        lblClientes = new javax.swing.JLabel();
        jPanelNuevaVenta = new javax.swing.JPanel();
        lblNuevaVenta = new javax.swing.JLabel();
        jPanelNuevaCompra = new javax.swing.JPanel();
        lblNuevaCompra = new javax.swing.JLabel();
        jPanelProductos = new javax.swing.JPanel();
        lblProductos = new javax.swing.JLabel();
        jPanelProveedor = new javax.swing.JPanel();
        lblProveedor = new javax.swing.JLabel();
        jPanelMedidas = new javax.swing.JPanel();
        lblMedidas = new javax.swing.JLabel();
        jPanelCategorias = new javax.swing.JPanel();
        lblCatagorias = new javax.swing.JLabel();
        jPanelConfiguracion = new javax.swing.JPanel();
        lblConfiguracion = new javax.swing.JLabel();
        jPanelUsuarios = new javax.swing.JPanel();
        lblUsuarios = new javax.swing.JLabel();
        panelCaja = new java.awt.Panel();
        lblCaja = new javax.swing.JLabel();
        panelReporteCompras = new javax.swing.JPanel();
        lblReporCompras = new javax.swing.JLabel();
        panelReporteVentas = new javax.swing.JPanel();
        lblReporteVentas = new javax.swing.JLabel();
        jPanelAperturaCierre = new javax.swing.JPanel();
        lblAperturaCierre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarUsuarios = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lblIdUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        btnNuevoCliente = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btnModificarCliente = new javax.swing.JButton();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        paginadorCliente = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        paginadorProveedor = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        btnNuevoProveedor = new javax.swing.JButton();
        btnRegistrarProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNitEmpresa = new javax.swing.JTextField();
        txtBuscarProveedor = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtIdPrveedor = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        btnNuevaCategoria = new javax.swing.JButton();
        btnRegistrarCategoria = new javax.swing.JButton();
        btnModificarCategoria = new javax.swing.JButton();
        txtIdCategoria = new javax.swing.JTextField();
        txtBuscarCategoria = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        paginadorCategoria = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtNombreMedida = new javax.swing.JTextField();
        btnNuevaMedida = new javax.swing.JButton();
        btnRegistrarMedida = new javax.swing.JButton();
        btnModificarMedida = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtabreviadoMedida = new javax.swing.JTextField();
        txtBuscarMedida = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtIdMedida = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMedida = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        txtHistorialVentas = new javax.swing.JTextField();
        btnBuscarVenta = new javax.swing.JButton();
        txtIdHistorialVentas = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblHistorialVentas = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHistorialCompras = new javax.swing.JTable();
        txtHistorialCompras = new javax.swing.JTextField();
        btnBuscarCompra = new javax.swing.JButton();
        txtIdHistorialCompras = new javax.swing.JTextField();
        txtfechaRepCompra = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtMensajeEmpresa = new javax.swing.JTextField();
        btnModificarDatosEmpresa = new javax.swing.JButton();
        txxTelefonoEmpresa = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtNitNegocio = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtDireccionEmpresa1 = new javax.swing.JTextField();
        txtIdDatosEmpresa = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblNuevaCompra = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtCodProCompra = new javax.swing.JTextField();
        txtNombreProCompra = new javax.swing.JTextField();
        txtCantidadCompra = new javax.swing.JTextField();
        txtPrecCompra = new javax.swing.JTextField();
        txtTotalCompra = new javax.swing.JTextField();
        btnGenerarCompra = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        cbxProveedorCompra = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtPagarConLaCompra = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtDevueltaNuevaCompra = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        lblTotalPagarCompra = new javax.swing.JLabel();
        txtIdProdCompra = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btnNuevoUsuario = new javax.swing.JButton();
        btnRegistrarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtBuscarUsuario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbxCaja = new javax.swing.JComboBox<>();
        cbxRol = new javax.swing.JComboBox<>();
        txtClave = new javax.swing.JPasswordField();
        txtIdUsuario = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        paginadorUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNuevaVenta = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtCodProVenta = new javax.swing.JTextField();
        txtNombreProVenta = new javax.swing.JTextField();
        txtCantidadProVenta = new javax.swing.JTextField();
        txtPrecioVentaProducto = new javax.swing.JTextField();
        txtStockProVenta = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cbxClienteVenta = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        txtPagarCon = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtDevolucionCliente = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        lblTotalPagarVenta = new javax.swing.JLabel();
        txtIdProductoVenta = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxCategorias = new javax.swing.JComboBox<>();
        cbxMedidas = new javax.swing.JComboBox<>();
        cbxProveedor = new javax.swing.JComboBox<>();
        btnNuevoProducto = new javax.swing.JButton();
        btnRegistrarProducto = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        txtBuscarProduct = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jPanelCaja = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtNombreCaja = new javax.swing.JTextField();
        btnNuevaCaja = new javax.swing.JButton();
        btnRegistrarCaja = new javax.swing.JButton();
        btnModificarCaja = new javax.swing.JButton();
        txtIdCaja = new javax.swing.JTextField();
        txtBuscarCaja = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblCaja = new javax.swing.JTable();
        paginadorCategoria1 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanelApertura = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txtMontoInicial = new javax.swing.JTextField();
        btnNuevaApertura = new javax.swing.JButton();
        btnRegistrarApertura = new javax.swing.JButton();
        btnCerrarCaja = new javax.swing.JButton();
        txtIdApertura = new javax.swing.JTextField();
        txtBuscarApertura = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableAperturaYCierre = new javax.swing.JTable();
        lblFechaDelSistema = new javax.swing.JLabel();

        jMenuEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarUsuario.setText("Eliminar");
        jPopupMenuUsuarios.add(jMenuEliminarUsuario);

        jMenuReingresarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarUsuario.setText("Reingresar");
        jPopupMenuUsuarios.add(jMenuReingresarUsuario);

        jMenuEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarCliente.setText("Eliminar");
        jPopupMenuClientes.add(jMenuEliminarCliente);

        jMenuReingresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarCliente.setText("Reingresar");
        jPopupMenuClientes.add(jMenuReingresarCliente);

        jMenuEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarCategoria.setText("Eliminar");
        jPopupMenuCategorias.add(jMenuEliminarCategoria);

        jMenuReingresarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarCategoria.setText("Reingresar");
        jPopupMenuCategorias.add(jMenuReingresarCategoria);

        jMenuEliminarMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarMedida.setText("Eliminar");
        jPopupMenuMedidas.add(jMenuEliminarMedida);

        jMenuReingresarMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarMedida.setText("Reingresar");
        jPopupMenuMedidas.add(jMenuReingresarMedida);

        jPopupMenuProveedor.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        jMenuEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarProveedor.setText("Eliminar");
        jPopupMenuProveedor.add(jMenuEliminarProveedor);

        jMenuReingresarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarProveedor.setText("Reingresar");
        jPopupMenuProveedor.add(jMenuReingresarProveedor);

        jMenuEliminarProducto.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jMenuEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarProducto.setText("Eliminar");
        jPopupMenuProducto.add(jMenuEliminarProducto);

        jMenuReingresarProducto.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jMenuReingresarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarProducto.setText("Reingresar");
        jMenuReingresarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReingresarProductoActionPerformed(evt);
            }
        });
        jPopupMenuProducto.add(jMenuReingresarProducto);

        jMenuEliminarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jMenuEliminarCaja.setText("Eliminar");
        jPopupMenuCajas.add(jMenuEliminarCaja);

        jMenuReingresarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        jMenuReingresarCaja.setText("Reingresar");
        jPopupMenuCajas.add(jMenuReingresarCaja);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 850));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelClientes.setBackground(new java.awt.Color(0, 102, 51));

        lblClientes.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        lblClientes.setText("Clientes");
        lblClientes.setAlignmentY(0.1F);
        lblClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClientes.setIconTextGap(2);

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 30));

        jPanelNuevaVenta.setBackground(new java.awt.Color(0, 102, 51));

        lblNuevaVenta.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevaVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        lblNuevaVenta.setText("Nueva Venta");
        lblNuevaVenta.setAlignmentY(0.1F);
        lblNuevaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNuevaVenta.setIconTextGap(2);

        javax.swing.GroupLayout jPanelNuevaVentaLayout = new javax.swing.GroupLayout(jPanelNuevaVenta);
        jPanelNuevaVenta.setLayout(jPanelNuevaVentaLayout);
        jPanelNuevaVentaLayout.setHorizontalGroup(
            jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNuevaVentaLayout.setVerticalGroup(
            jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                .addComponent(lblNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanelNuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        jPanelNuevaCompra.setBackground(new java.awt.Color(0, 102, 51));

        lblNuevaCompra.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblNuevaCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevaCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/compras.png"))); // NOI18N
        lblNuevaCompra.setText("Nueva Compra");
        lblNuevaCompra.setAlignmentY(0.1F);
        lblNuevaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNuevaCompra.setIconTextGap(2);

        javax.swing.GroupLayout jPanelNuevaCompraLayout = new javax.swing.GroupLayout(jPanelNuevaCompra);
        jPanelNuevaCompra.setLayout(jPanelNuevaCompraLayout);
        jPanelNuevaCompraLayout.setHorizontalGroup(
            jPanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNuevaCompraLayout.setVerticalGroup(
            jPanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelNuevaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 30));

        jPanelProductos.setBackground(new java.awt.Color(0, 102, 51));

        lblProductos.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        lblProductos.setText("Productos");
        lblProductos.setAlignmentY(0.1F);
        lblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductos.setIconTextGap(2);

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 30));

        jPanelProveedor.setBackground(new java.awt.Color(0, 102, 51));

        lblProveedor.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        lblProveedor.setText("Proveedores");
        lblProveedor.setAlignmentY(0.1F);
        lblProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProveedor.setIconTextGap(2);

        javax.swing.GroupLayout jPanelProveedorLayout = new javax.swing.GroupLayout(jPanelProveedor);
        jPanelProveedor.setLayout(jPanelProveedorLayout);
        jPanelProveedorLayout.setHorizontalGroup(
            jPanelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelProveedorLayout.setVerticalGroup(
            jPanelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 30));

        jPanelMedidas.setBackground(new java.awt.Color(0, 102, 51));

        lblMedidas.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblMedidas.setForeground(new java.awt.Color(255, 255, 255));
        lblMedidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/detallista.png"))); // NOI18N
        lblMedidas.setText("Medidas");
        lblMedidas.setAlignmentY(0.1F);
        lblMedidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMedidas.setIconTextGap(2);

        javax.swing.GroupLayout jPanelMedidasLayout = new javax.swing.GroupLayout(jPanelMedidas);
        jPanelMedidas.setLayout(jPanelMedidasLayout);
        jPanelMedidasLayout.setHorizontalGroup(
            jPanelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelMedidasLayout.setVerticalGroup(
            jPanelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 30));

        jPanelCategorias.setBackground(new java.awt.Color(0, 102, 51));

        lblCatagorias.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblCatagorias.setForeground(new java.awt.Color(255, 255, 255));
        lblCatagorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCatagorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cajero.png"))); // NOI18N
        lblCatagorias.setText("Categorías");
        lblCatagorias.setAlignmentY(0.1F);
        lblCatagorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCatagorias.setIconTextGap(2);

        javax.swing.GroupLayout jPanelCategoriasLayout = new javax.swing.GroupLayout(jPanelCategorias);
        jPanelCategorias.setLayout(jPanelCategoriasLayout);
        jPanelCategoriasLayout.setHorizontalGroup(
            jPanelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCatagorias, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelCategoriasLayout.setVerticalGroup(
            jPanelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCatagorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 30));

        jPanelConfiguracion.setBackground(new java.awt.Color(0, 102, 51));

        lblConfiguracion.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        lblConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        lblConfiguracion.setText("Configuración");
        lblConfiguracion.setAlignmentY(0.1F);
        lblConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblConfiguracion.setIconTextGap(2);

        javax.swing.GroupLayout jPanelConfiguracionLayout = new javax.swing.GroupLayout(jPanelConfiguracion);
        jPanelConfiguracion.setLayout(jPanelConfiguracionLayout);
        jPanelConfiguracionLayout.setHorizontalGroup(
            jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelConfiguracionLayout.setVerticalGroup(
            jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 30));

        jPanelUsuarios.setBackground(new java.awt.Color(0, 102, 51));

        lblUsuarios.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/users.png"))); // NOI18N
        lblUsuarios.setText("Usuarios");
        lblUsuarios.setAlignmentY(0.1F);
        lblUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsuarios.setIconTextGap(2);

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addComponent(lblUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanelUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 30));

        panelCaja.setBackground(new java.awt.Color(0, 102, 51));
        panelCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCaja.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblCaja.setForeground(new java.awt.Color(255, 255, 255));
        lblCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/box.png"))); // NOI18N
        lblCaja.setText("Cajas");
        lblCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaja.setName("Cajas"); // NOI18N
        panelCaja.add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));
        lblCaja.getAccessibleContext().setAccessibleName("Caja");

        jPanel1.add(panelCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 30));

        panelReporteCompras.setBackground(new java.awt.Color(0, 102, 51));
        panelReporteCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblReporCompras.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblReporCompras.setForeground(new java.awt.Color(255, 255, 255));
        lblReporCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReporCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/edit.png"))); // NOI18N
        lblReporCompras.setText("Reporte Compras");
        lblReporCompras.setAlignmentY(0.1F);
        lblReporCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReporCompras.setIconTextGap(2);
        panelReporteCompras.add(lblReporCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        jPanel1.add(panelReporteCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 200, 30));

        panelReporteVentas.setBackground(new java.awt.Color(0, 102, 51));
        panelReporteVentas.setName("PanelReporteVentas"); // NOI18N

        lblReporteVentas.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblReporteVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblReporteVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReporteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/detallista.png"))); // NOI18N
        lblReporteVentas.setText("Reporte Ventas");
        lblReporteVentas.setAlignmentY(0.1F);
        lblReporteVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReporteVentas.setIconTextGap(2);

        javax.swing.GroupLayout panelReporteVentasLayout = new javax.swing.GroupLayout(panelReporteVentas);
        panelReporteVentas.setLayout(panelReporteVentasLayout);
        panelReporteVentasLayout.setHorizontalGroup(
            panelReporteVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReporteVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panelReporteVentasLayout.setVerticalGroup(
            panelReporteVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReporteVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(panelReporteVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 200, 30));

        jPanelAperturaCierre.setBackground(new java.awt.Color(0, 102, 51));

        lblAperturaCierre.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblAperturaCierre.setForeground(new java.awt.Color(255, 255, 255));
        lblAperturaCierre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAperturaCierre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        lblAperturaCierre.setText("Apertura y Cierre");
        lblAperturaCierre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelAperturaCierreLayout = new javax.swing.GroupLayout(jPanelAperturaCierre);
        jPanelAperturaCierre.setLayout(jPanelAperturaCierreLayout);
        jPanelAperturaCierreLayout.setHorizontalGroup(
            jPanelAperturaCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAperturaCierre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelAperturaCierreLayout.setVerticalGroup(
            jPanelAperturaCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAperturaCierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelAperturaCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 540));

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pos Venta");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 194, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 70));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarUsuarios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscarUsuarios.setText("Buscar");
        jPanel3.add(btnBuscarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 120, 35));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 30, 40));

        jLabel49.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Programación en Java MVC");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        lblIdUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblIdUsuario.setText("Usuario:");
        jPanel3.add(lblIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 200, -1));

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Soy ");
        jPanel3.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        txtBuscarProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 210, 35));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1200, 70));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel9.setText("Nombre");
        jPanel17.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel10.setText("Teléfono");
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel11.setText("Dirección");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreCliente.setPreferredSize(null);
        txtNombreCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 200, 30));

        txtDireccionCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDireccionCliente.setPreferredSize(null);
        txtDireccionCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 200, 30));

        btnNuevoCliente.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(btnNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, 30));

        btnRegistrarCliente.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.setPreferredSize(null);
        btnRegistrarCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 100, 30));

        btnModificarCliente.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarCliente.setText("Modificar");
        btnModificarCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(btnModificarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 100, 30));

        txtTelefonoCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefonoCliente.setPreferredSize(null);
        txtTelefonoCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 200, 30));

        jLabel51.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel17.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        txtBuscarCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarCliente.setPreferredSize(null);
        txtBuscarCliente.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(txtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 200, 30));
        jPanel17.add(txtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 40, -1));

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 460));

        tblClientes.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Teléfono", "Dirección", "Estado"
            }
        ));
        tblClientes.setComponentPopupMenu(jPopupMenuClientes);
        tblClientes.setRowHeight(25);
        jScrollPane2.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setMinWidth(10);
            tblClientes.getColumnModel().getColumn(0).setMaxWidth(30);
            tblClientes.getColumnModel().getColumn(1).setMinWidth(230);
            tblClientes.getColumnModel().getColumn(3).setMinWidth(170);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 700, 400));

        javax.swing.GroupLayout paginadorClienteLayout = new javax.swing.GroupLayout(paginadorCliente);
        paginadorCliente.setLayout(paginadorClienteLayout);
        paginadorClienteLayout.setHorizontalGroup(
            paginadorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        paginadorClienteLayout.setVerticalGroup(
            paginadorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel5.add(paginadorCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 700, -1));

        jTabbedPane1.addTab("Clientes", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout paginadorProveedorLayout = new javax.swing.GroupLayout(paginadorProveedor);
        paginadorProveedor.setLayout(paginadorProveedorLayout);
        paginadorProveedorLayout.setHorizontalGroup(
            paginadorProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        paginadorProveedorLayout.setVerticalGroup(
            paginadorProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel6.add(paginadorProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 700, -1));

        tblProveedor.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nit", "Nombre", "Teléfono", "Dirección", "Estado"
            }
        ));
        tblProveedor.setComponentPopupMenu(jPopupMenuProveedor);
        tblProveedor.setRowHeight(25);
        jScrollPane3.setViewportView(tblProveedor);
        if (tblProveedor.getColumnModel().getColumnCount() > 0) {
            tblProveedor.getColumnModel().getColumn(0).setMinWidth(15);
            tblProveedor.getColumnModel().getColumn(0).setMaxWidth(25);
            tblProveedor.getColumnModel().getColumn(1).setMinWidth(120);
            tblProveedor.getColumnModel().getColumn(2).setMinWidth(185);
            tblProveedor.getColumnModel().getColumn(3).setMinWidth(100);
            tblProveedor.getColumnModel().getColumn(4).setMinWidth(210);
            tblProveedor.getColumnModel().getColumn(5).setMinWidth(65);
        }

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 26, 700, 400));

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel12.setText("Nombre");
        jPanel18.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel13.setText("Teléfono");
        jPanel18.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel14.setText("Dirección");
        jPanel18.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txtNombreProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreProveedor.setPreferredSize(null);
        txtNombreProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 30));

        txtDireccionProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDireccionProveedor.setPreferredSize(null);
        txtDireccionProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(txtDireccionProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 30));

        btnNuevoProveedor.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevoProveedor.setText("Nuevo");
        btnNuevoProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(btnNuevoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 100, 30));

        btnRegistrarProveedor.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarProveedor.setText("Registrar");
        btnRegistrarProveedor.setPreferredSize(null);
        btnRegistrarProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(btnRegistrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 100, 30));

        btnModificarProveedor.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarProveedor.setText("Modificar");
        btnModificarProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(btnModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 100, 30));

        txtTelefonoProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefonoProveedor.setPreferredSize(null);
        txtTelefonoProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 200, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel15.setText("Nit");
        jPanel18.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtNitEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNitEmpresa.setPreferredSize(null);
        txtNitEmpresa.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(txtNitEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, 30));

        txtBuscarProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarProveedor.setPreferredSize(null);
        txtBuscarProveedor.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(txtBuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, 30));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel18.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
        jPanel18.add(txtIdPrveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 260, 80, -1));

        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 460));

        jTabbedPane1.addTab("Proveedores", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Categoría", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel21.setText("Nombre");
        jPanel20.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtNombreCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreCategoria.setPreferredSize(null);
        txtNombreCategoria.setVerifyInputWhenFocusTarget(false);
        jPanel20.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 200, 30));

        btnNuevaCategoria.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevaCategoria.setText("Nuevo");
        btnNuevaCategoria.setVerifyInputWhenFocusTarget(false);
        jPanel20.add(btnNuevaCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 100, 30));

        btnRegistrarCategoria.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarCategoria.setText("Registrar");
        btnRegistrarCategoria.setPreferredSize(null);
        btnRegistrarCategoria.setVerifyInputWhenFocusTarget(false);
        jPanel20.add(btnRegistrarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 100, 30));

        btnModificarCategoria.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarCategoria.setText("Modificar");
        btnModificarCategoria.setVerifyInputWhenFocusTarget(false);
        jPanel20.add(btnModificarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 100, 30));
        jPanel20.add(txtIdCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 50, -1));

        txtBuscarCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarCategoria.setPreferredSize(null);
        txtBuscarCategoria.setVerifyInputWhenFocusTarget(false);
        jPanel20.add(txtBuscarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 200, 30));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel20.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jPanel8.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 460));

        tblCategoria.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Caqtegoría", "Estado"
            }
        ));
        tblCategoria.setComponentPopupMenu(jPopupMenuCategorias);
        tblCategoria.setRowHeight(25);
        jScrollPane5.setViewportView(tblCategoria);
        if (tblCategoria.getColumnModel().getColumnCount() > 0) {
            tblCategoria.getColumnModel().getColumn(0).setMinWidth(15);
            tblCategoria.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        jPanel8.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 700, 390));

        javax.swing.GroupLayout paginadorCategoriaLayout = new javax.swing.GroupLayout(paginadorCategoria);
        paginadorCategoria.setLayout(paginadorCategoriaLayout);
        paginadorCategoriaLayout.setHorizontalGroup(
            paginadorCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        paginadorCategoriaLayout.setVerticalGroup(
            paginadorCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel8.add(paginadorCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 700, -1));

        jTabbedPane1.addTab("Categorias", jPanel8);

        jPanel9.setBackground(new java.awt.Color(153, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Medida", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel22.setText("Nombre");
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtNombreMedida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreMedida.setPreferredSize(null);
        txtNombreMedida.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(txtNombreMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 200, 30));

        btnNuevaMedida.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevaMedida.setText("Nuevo");
        btnNuevaMedida.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(btnNuevaMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 100, 30));

        btnRegistrarMedida.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarMedida.setText("Registrar");
        btnRegistrarMedida.setPreferredSize(null);
        btnRegistrarMedida.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(btnRegistrarMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 100, 30));

        btnModificarMedida.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarMedida.setText("Modificar");
        btnModificarMedida.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(btnModificarMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel23.setText("Iniciales");
        jPanel21.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtabreviadoMedida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtabreviadoMedida.setPreferredSize(null);
        txtabreviadoMedida.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(txtabreviadoMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 200, 30));

        txtBuscarMedida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarMedida.setPreferredSize(null);
        txtBuscarMedida.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(txtBuscarMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 200, 30));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel21.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));
        jPanel21.add(txtIdMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jPanel9.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 490));

        tblMedida.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        tblMedida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Medida", "Abreviado", "Estado"
            }
        ));
        tblMedida.setComponentPopupMenu(jPopupMenuMedidas);
        tblMedida.setRowHeight(25);
        jScrollPane6.setViewportView(tblMedida);
        if (tblMedida.getColumnModel().getColumnCount() > 0) {
            tblMedida.getColumnModel().getColumn(0).setMinWidth(15);
            tblMedida.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 700, 470));

        jTabbedPane1.addTab("Medidas", jPanel9);

        jPanel11.setBackground(new java.awt.Color(204, 51, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHistorialVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel11.add(txtHistorialVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 35));

        btnBuscarVenta.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnBuscarVenta.setText("Buscar Venta");
        btnBuscarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(btnBuscarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 35));
        jPanel11.add(txtIdHistorialVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 100, -1));

        tblHistorialVentas.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tblHistorialVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Cant", "Total", "Cliente", "Telefono", "Vendedor", "Caja", "Fecha"
            }
        ));
        tblHistorialVentas.setAutoscrolls(false);
        tblHistorialVentas.setRowHeight(23);
        jScrollPane9.setViewportView(tblHistorialVentas);
        if (tblHistorialVentas.getColumnModel().getColumnCount() > 0) {
            tblHistorialVentas.getColumnModel().getColumn(0).setMinWidth(30);
            tblHistorialVentas.getColumnModel().getColumn(0).setMaxWidth(35);
            tblHistorialVentas.getColumnModel().getColumn(1).setMinWidth(300);
            tblHistorialVentas.getColumnModel().getColumn(1).setMaxWidth(350);
            tblHistorialVentas.getColumnModel().getColumn(2).setMinWidth(60);
            tblHistorialVentas.getColumnModel().getColumn(2).setMaxWidth(80);
            tblHistorialVentas.getColumnModel().getColumn(3).setMinWidth(120);
            tblHistorialVentas.getColumnModel().getColumn(3).setMaxWidth(150);
            tblHistorialVentas.getColumnModel().getColumn(4).setMinWidth(210);
            tblHistorialVentas.getColumnModel().getColumn(4).setMaxWidth(230);
            tblHistorialVentas.getColumnModel().getColumn(5).setMinWidth(120);
            tblHistorialVentas.getColumnModel().getColumn(5).setMaxWidth(150);
            tblHistorialVentas.getColumnModel().getColumn(6).setMinWidth(190);
            tblHistorialVentas.getColumnModel().getColumn(6).setMaxWidth(200);
            tblHistorialVentas.getColumnModel().getColumn(7).setMinWidth(100);
            tblHistorialVentas.getColumnModel().getColumn(7).setMaxWidth(120);
            tblHistorialVentas.getColumnModel().getColumn(8).setMinWidth(200);
            tblHistorialVentas.getColumnModel().getColumn(8).setMaxWidth(250);
        }

        jPanel11.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1020, 440));

        jTabbedPane1.addTab("Ventas", jPanel11);

        jPanel12.setBackground(new java.awt.Color(204, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHistorialCompras.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        tblHistorialCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Proveedor", "Comprador", "Total", "Fecha"
            }
        ));
        tblHistorialCompras.setRowHeight(23);
        jScrollPane10.setViewportView(tblHistorialCompras);
        if (tblHistorialCompras.getColumnModel().getColumnCount() > 0) {
            tblHistorialCompras.getColumnModel().getColumn(2).setMinWidth(250);
            tblHistorialCompras.getColumnModel().getColumn(2).setMaxWidth(270);
        }

        jPanel12.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, 450));

        txtHistorialCompras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel12.add(txtHistorialCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 35));

        btnBuscarCompra.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnBuscarCompra.setText("Generar Reporte");
        btnBuscarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.add(btnBuscarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 180, 35));

        txtIdHistorialCompras.setText(",,,");
        jPanel12.add(txtIdHistorialCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));
        jPanel12.add(txtfechaRepCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 20, 150, -1));

        jTabbedPane1.addTab("Compras", jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 153, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Empresa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel39.setText("Nombre");
        jPanel22.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel44.setText("Teléfono");
        jPanel22.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel45.setText("Mensaje");
        jPanel22.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtNombreEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreEmpresa.setPreferredSize(null);
        txtNombreEmpresa.setVerifyInputWhenFocusTarget(false);
        jPanel22.add(txtNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 30));

        txtMensajeEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMensajeEmpresa.setPreferredSize(null);
        txtMensajeEmpresa.setVerifyInputWhenFocusTarget(false);
        jPanel22.add(txtMensajeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, 30));

        btnModificarDatosEmpresa.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarDatosEmpresa.setText("Modificar");
        btnModificarDatosEmpresa.setVerifyInputWhenFocusTarget(false);
        jPanel22.add(btnModificarDatosEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 100, 30));

        txxTelefonoEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txxTelefonoEmpresa.setPreferredSize(null);
        txxTelefonoEmpresa.setVerifyInputWhenFocusTarget(false);
        jPanel22.add(txxTelefonoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 200, 30));

        jLabel46.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel46.setText("Nit");
        jPanel22.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtNitNegocio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNitNegocio.setPreferredSize(null);
        txtNitNegocio.setVerifyInputWhenFocusTarget(false);
        jPanel22.add(txtNitNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, 30));

        jLabel47.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel47.setText("Dirección");
        jPanel22.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txtDireccionEmpresa1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDireccionEmpresa1.setPreferredSize(null);
        txtDireccionEmpresa1.setVerifyInputWhenFocusTarget(false);
        jPanel22.add(txtDireccionEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 30));

        txtIdDatosEmpresa.setText("...");
        jPanel22.add(txtIdDatosEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jPanel13.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 460));

        jTabbedPane1.addTab("Empresa", jPanel13);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(153, 255, 153));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNuevaCompra.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        tblNuevaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Cantidad", "Precio", "Total"
            }
        ));
        tblNuevaCompra.setRowHeight(25);
        jScrollPane8.setViewportView(tblNuevaCompra);
        if (tblNuevaCompra.getColumnModel().getColumnCount() > 0) {
            tblNuevaCompra.getColumnModel().getColumn(0).setMinWidth(10);
            tblNuevaCompra.getColumnModel().getColumn(0).setMaxWidth(30);
            tblNuevaCompra.getColumnModel().getColumn(1).setMinWidth(300);
        }

        jPanel16.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1030, 330));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setText("Código");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setText("Producto");
        jPanel16.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setText("Cant");
        jPanel16.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setText("Precio");
        jPanel16.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("Total");
        jPanel16.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        txtCodProCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.add(txtCodProCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 30));

        txtNombreProCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.add(txtNombreProCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 300, 30));

        txtCantidadCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.add(txtCantidadCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 60, 30));

        txtPrecCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.add(txtPrecCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 80, 30));

        txtTotalCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.add(txtTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 110, 30));

        btnGenerarCompra.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnGenerarCompra.setText("Generar Compra");
        jPanel16.add(btnGenerarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, -1, 30));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setText("Proveedor");
        jPanel16.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        cbxProveedorCompra.setEditable(true);
        cbxProveedorCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel16.add(cbxProveedorCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 300, 30));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setText("Paga Con");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        txtPagarConLaCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel16.add(txtPagarConLaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 130, 30));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("Devuelta");
        jPanel16.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, -1, -1));

        txtDevueltaNuevaCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel16.add(txtDevueltaNuevaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 440, 120, 30));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("Total Pagar");
        jPanel16.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        lblTotalPagarCompra.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel16.add(lblTotalPagarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 130, -1));
        jPanel16.add(txtIdProdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 510));

        jTabbedPane1.addTab("Nueva Compra", jPanel14);

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel16.setText("Nombre");
        jPanel19.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel17.setText("Clave");
        jPanel19.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel18.setText("Caja");
        jPanel19.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txtNombreUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreUsuario.setPreferredSize(null);
        txtNombreUsuario.setVerifyInputWhenFocusTarget(false);
        jPanel19.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 30));

        btnNuevoUsuario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevoUsuario.setText("Nuevo");
        btnNuevoUsuario.setVerifyInputWhenFocusTarget(false);
        jPanel19.add(btnNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 100, 30));

        btnRegistrarUsuario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarUsuario.setText("Registrar");
        btnRegistrarUsuario.setPreferredSize(null);
        btnRegistrarUsuario.setVerifyInputWhenFocusTarget(false);
        jPanel19.add(btnRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 100, 30));

        btnModificarUsuario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.setVerifyInputWhenFocusTarget(false);
        jPanel19.add(btnModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 100, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel19.setText("Usuaro");
        jPanel19.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtBuscarUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarUsuario.setPreferredSize(null);
        txtBuscarUsuario.setVerifyInputWhenFocusTarget(false);
        jPanel19.add(txtBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel20.setText("Rol");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        cbxCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxCaja.setVerifyInputWhenFocusTarget(false);
        cbxCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCajaActionPerformed(evt);
            }
        });
        jPanel19.add(cbxCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 30));

        cbxRol.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxRol.setVerifyInputWhenFocusTarget(false);
        cbxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolActionPerformed(evt);
            }
        });
        jPanel19.add(cbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, 30));

        txtClave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel19.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 200, 30));
        jPanel19.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 90, -1));

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuario.setPreferredSize(null);
        txtUsuario.setVerifyInputWhenFocusTarget(false);
        jPanel19.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, 30));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel19.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel7.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 460));

        javax.swing.GroupLayout paginadorUsuariosLayout = new javax.swing.GroupLayout(paginadorUsuarios);
        paginadorUsuarios.setLayout(paginadorUsuariosLayout);
        paginadorUsuariosLayout.setHorizontalGroup(
            paginadorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        paginadorUsuariosLayout.setVerticalGroup(
            paginadorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel7.add(paginadorUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 700, -1));

        tblUsuarios.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Nombre", "Caja", "Rol", "Estado"
            }
        ));
        tblUsuarios.setComponentPopupMenu(jPopupMenuUsuarios);
        tblUsuarios.setRowHeight(25);
        jScrollPane4.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setMinWidth(10);
            tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(30);
            tblUsuarios.getColumnModel().getColumn(1).setMinWidth(90);
            tblUsuarios.getColumnModel().getColumn(2).setMinWidth(250);
            tblUsuarios.getColumnModel().getColumn(3).setMinWidth(110);
            tblUsuarios.getColumnModel().getColumn(4).setMinWidth(115);
        }

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 700, 400));

        jTabbedPane1.addTab("Usuarios", jPanel7);

        jPanel10.setBackground(new java.awt.Color(153, 255, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNuevaVenta.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tblNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Cantidad", "Precio", "Total"
            }
        ));
        tblNuevaVenta.setRowHeight(23);
        jScrollPane7.setViewportView(tblNuevaVenta);
        if (tblNuevaVenta.getColumnModel().getColumnCount() > 0) {
            tblNuevaVenta.getColumnModel().getColumn(0).setMinWidth(40);
            tblNuevaVenta.getColumnModel().getColumn(0).setMaxWidth(60);
            tblNuevaVenta.getColumnModel().getColumn(1).setMinWidth(350);
            tblNuevaVenta.getColumnModel().getColumn(1).setMaxWidth(370);
        }

        jPanel10.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1020, 330));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setText("Código");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Producto");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Cant");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setText("Precio");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setText("Stock");
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 50, -1));

        txtCodProVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.add(txtCodProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 30));

        txtNombreProVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.add(txtNombreProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 300, 30));

        txtCantidadProVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.add(txtCantidadProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 60, 30));

        txtPrecioVentaProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.add(txtPrecioVentaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 80, 30));

        txtStockProVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.add(txtStockProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 100, 30));

        btnGenerarVenta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnGenerarVenta.setText("Generar Venta");
        jPanel10.add(btnGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Cliente");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        cbxClienteVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel10.add(cbxClienteVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 320, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setText("Paga Con");
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        txtPagarCon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel10.add(txtPagarCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 130, 30));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Devuelta");
        jPanel10.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, -1, -1));

        txtDevolucionCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel10.add(txtDevolucionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 120, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setText("Total Pagar");
        jPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        lblTotalPagarVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalPagarVenta.setText("------");
        jPanel10.add(lblTotalPagarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 130, -1));

        txtIdProductoVenta.setText("Id Producto");
        jPanel10.add(txtIdProductoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        jTabbedPane1.addTab("Nueva Venta", jPanel10);

        jPanel4.setBackground(new java.awt.Color(102, 255, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Código");
        jPanel15.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Descripción");
        jPanel15.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Precio Compra");
        jPanel15.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel5.setText("PrecioVenta");
        jPanel15.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 196, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel6.setText("Proveedor");
        jPanel15.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 237, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setText("Medida");
        jPanel15.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 278, -1, -1));

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodigo.setPreferredSize(null);
        txtCodigo.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, 30));

        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescripcion.setPreferredSize(null);
        txtDescripcion.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 170, 30));

        txtPrecioCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecioCompra.setPreferredSize(null);
        txtPrecioCompra.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, 30));

        txtPrecioVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecioVenta.setPreferredSize(null);
        txtPrecioVenta.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 170, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel8.setText("Categoría");
        jPanel15.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 319, -1, -1));

        cbxCategorias.setEditable(true);
        cbxCategorias.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cbxCategorias.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(cbxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 170, 30));

        cbxMedidas.setEditable(true);
        cbxMedidas.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cbxMedidas.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(cbxMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 170, 30));

        cbxProveedor.setEditable(true);
        cbxProveedor.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cbxProveedor.setVerifyInputWhenFocusTarget(false);
        cbxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorActionPerformed(evt);
            }
        });
        jPanel15.add(cbxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 170, 30));

        btnNuevoProducto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevoProducto.setText("Nuevo");
        btnNuevoProducto.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(btnNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 100, 30));

        btnRegistrarProducto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarProducto.setText("Registrar");
        btnRegistrarProducto.setPreferredSize(null);
        btnRegistrarProducto.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(btnRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 100, 30));

        btnModificarProducto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(btnModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 100, 30));
        jPanel15.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        txtBuscarProduct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarProduct.setPreferredSize(null);
        txtBuscarProduct.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(txtBuscarProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 170, 30));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanel15.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jPanel4.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 450));

        tblProductos.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Còdigo", "Descripción", "Precio", "Stock", "Estado"
            }
        ));
        tblProductos.setComponentPopupMenu(jPopupMenuProducto);
        tblProductos.setRowHeight(25);
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setMinWidth(15);
            tblProductos.getColumnModel().getColumn(0).setMaxWidth(25);
            tblProductos.getColumnModel().getColumn(1).setMinWidth(70);
            tblProductos.getColumnModel().getColumn(2).setMinWidth(200);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 750, 450));

        jTabbedPane1.addTab("Productos", jPanel4);

        jPanel23.setBackground(new java.awt.Color(255, 255, 204));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Abrir Caja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanelCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel29.setText("Nombre");
        jPanelCaja.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtNombreCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreCaja.setPreferredSize(null);
        txtNombreCaja.setVerifyInputWhenFocusTarget(false);
        jPanelCaja.add(txtNombreCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 200, 30));

        btnNuevaCaja.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevaCaja.setText("Nuevo");
        btnNuevaCaja.setVerifyInputWhenFocusTarget(false);
        jPanelCaja.add(btnNuevaCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 100, 30));

        btnRegistrarCaja.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarCaja.setText("Registrar");
        btnRegistrarCaja.setPreferredSize(null);
        btnRegistrarCaja.setVerifyInputWhenFocusTarget(false);
        jPanelCaja.add(btnRegistrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 100, 30));

        btnModificarCaja.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnModificarCaja.setText("Modificar");
        btnModificarCaja.setVerifyInputWhenFocusTarget(false);
        jPanelCaja.add(btnModificarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 100, 30));
        jPanelCaja.add(txtIdCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 50, -1));

        txtBuscarCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarCaja.setPreferredSize(null);
        txtBuscarCaja.setVerifyInputWhenFocusTarget(false);
        jPanelCaja.add(txtBuscarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 200, 30));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanelCaja.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jPanel23.add(jPanelCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 460));

        tblCaja.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        tblCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Caja", "Estado"
            }
        ));
        tblCaja.setComponentPopupMenu(jPopupMenuCategorias);
        tblCaja.setRowHeight(25);
        jScrollPane11.setViewportView(tblCaja);
        if (tblCaja.getColumnModel().getColumnCount() > 0) {
            tblCaja.getColumnModel().getColumn(0).setMinWidth(15);
            tblCaja.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        jPanel23.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 700, 390));

        javax.swing.GroupLayout paginadorCategoria1Layout = new javax.swing.GroupLayout(paginadorCategoria1);
        paginadorCategoria1.setLayout(paginadorCategoria1Layout);
        paginadorCategoria1Layout.setHorizontalGroup(
            paginadorCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        paginadorCategoria1Layout.setVerticalGroup(
            paginadorCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel23.add(paginadorCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 700, -1));

        jTabbedPane1.addTab("Caja", jPanel23);

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelApertura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apertura y Cierre de Caja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanelApertura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel57.setText("Monto Inicial");
        jPanelApertura.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        txtMontoInicial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMontoInicial.setPreferredSize(null);
        txtMontoInicial.setVerifyInputWhenFocusTarget(false);
        jPanelApertura.add(txtMontoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 200, 30));

        btnNuevaApertura.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnNuevaApertura.setText("Nuevo");
        btnNuevaApertura.setVerifyInputWhenFocusTarget(false);
        jPanelApertura.add(btnNuevaApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 110, 30));

        btnRegistrarApertura.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnRegistrarApertura.setText("Abrir Caja");
        btnRegistrarApertura.setVerifyInputWhenFocusTarget(false);
        jPanelApertura.add(btnRegistrarApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 110, 30));

        btnCerrarCaja.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnCerrarCaja.setText("Cerrar Caja");
        btnCerrarCaja.setVerifyInputWhenFocusTarget(false);
        jPanelApertura.add(btnCerrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 110, 30));
        jPanelApertura.add(txtIdApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 50, -1));

        txtBuscarApertura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscarApertura.setPreferredSize(null);
        txtBuscarApertura.setVerifyInputWhenFocusTarget(false);
        jPanelApertura.add(txtBuscarApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 200, 30));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jPanelApertura.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jPanel24.add(jPanelApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 460));

        jTableAperturaYCierre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fwcha Apertura", "Fecha Cierre", "Monto Inicial", "Monto Final", "Total Ventas", "Vendedor", "Caja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTableAperturaYCierre);

        jPanel24.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 710, -1));

        lblFechaDelSistema.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jPanel24.add(lblFechaDelSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 360, 20));

        jTabbedPane1.addTab("Apertura Y Cierre", jPanel24);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 1040, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedorActionPerformed

    private void cbxCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCajaActionPerformed

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

    private void jMenuReingresarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReingresarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuReingresarProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarCompra;
    public javax.swing.JButton btnBuscarUsuarios;
    public javax.swing.JButton btnBuscarVenta;
    public javax.swing.JButton btnCerrarCaja;
    public javax.swing.JButton btnGenerarCompra;
    public javax.swing.JButton btnGenerarVenta;
    public javax.swing.JButton btnModificarCaja;
    public javax.swing.JButton btnModificarCategoria;
    public javax.swing.JButton btnModificarCliente;
    public javax.swing.JButton btnModificarDatosEmpresa;
    public javax.swing.JButton btnModificarMedida;
    public javax.swing.JButton btnModificarProducto;
    public javax.swing.JButton btnModificarProveedor;
    public javax.swing.JButton btnModificarUsuario;
    public javax.swing.JButton btnNuevaApertura;
    public javax.swing.JButton btnNuevaCaja;
    public javax.swing.JButton btnNuevaCategoria;
    public javax.swing.JButton btnNuevaMedida;
    public javax.swing.JButton btnNuevoCliente;
    public javax.swing.JButton btnNuevoProducto;
    public javax.swing.JButton btnNuevoProveedor;
    public javax.swing.JButton btnNuevoUsuario;
    public javax.swing.JButton btnRegistrarApertura;
    public javax.swing.JButton btnRegistrarCaja;
    public javax.swing.JButton btnRegistrarCategoria;
    public javax.swing.JButton btnRegistrarCliente;
    public javax.swing.JButton btnRegistrarMedida;
    public javax.swing.JButton btnRegistrarProducto;
    public javax.swing.JButton btnRegistrarProveedor;
    public javax.swing.JButton btnRegistrarUsuario;
    public javax.swing.JComboBox<Object> cbxCaja;
    public javax.swing.JComboBox<Object> cbxCategorias;
    public javax.swing.JComboBox<Object> cbxClienteVenta;
    public javax.swing.JComboBox<Object> cbxMedidas;
    public javax.swing.JComboBox<Object> cbxProveedor;
    public javax.swing.JComboBox<Object> cbxProveedorCompra;
    public javax.swing.JComboBox<Object> cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JMenuItem jMenuEliminarCaja;
    public javax.swing.JMenuItem jMenuEliminarCategoria;
    public javax.swing.JMenuItem jMenuEliminarCliente;
    public javax.swing.JMenuItem jMenuEliminarMedida;
    public javax.swing.JMenuItem jMenuEliminarProducto;
    public javax.swing.JMenuItem jMenuEliminarProveedor;
    public javax.swing.JMenuItem jMenuEliminarUsuario;
    public javax.swing.JMenuItem jMenuReingresarCaja;
    public javax.swing.JMenuItem jMenuReingresarCategoria;
    public javax.swing.JMenuItem jMenuReingresarCliente;
    public javax.swing.JMenuItem jMenuReingresarMedida;
    public javax.swing.JMenuItem jMenuReingresarProducto;
    public javax.swing.JMenuItem jMenuReingresarProveedor;
    public javax.swing.JMenuItem jMenuReingresarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelApertura;
    public javax.swing.JPanel jPanelAperturaCierre;
    private javax.swing.JPanel jPanelCaja;
    public javax.swing.JPanel jPanelCategorias;
    public javax.swing.JPanel jPanelClientes;
    public javax.swing.JPanel jPanelConfiguracion;
    public javax.swing.JPanel jPanelMedidas;
    public javax.swing.JPanel jPanelNuevaCompra;
    public javax.swing.JPanel jPanelNuevaVenta;
    public javax.swing.JPanel jPanelProductos;
    public javax.swing.JPanel jPanelProveedor;
    public transient javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JPopupMenu jPopupMenuCajas;
    private javax.swing.JPopupMenu jPopupMenuCategorias;
    private javax.swing.JPopupMenu jPopupMenuClientes;
    private javax.swing.JPopupMenu jPopupMenuMedidas;
    private javax.swing.JPopupMenu jPopupMenuProducto;
    private javax.swing.JPopupMenu jPopupMenuProveedor;
    private javax.swing.JPopupMenu jPopupMenuUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableAperturaYCierre;
    public javax.swing.JLabel lblAperturaCierre;
    public javax.swing.JLabel lblCaja;
    public javax.swing.JLabel lblCatagorias;
    public javax.swing.JLabel lblClientes;
    public javax.swing.JLabel lblConfiguracion;
    public javax.swing.JLabel lblFechaDelSistema;
    public javax.swing.JLabel lblIdUsuario;
    public javax.swing.JLabel lblMedidas;
    public javax.swing.JLabel lblNombreUsuario;
    public javax.swing.JLabel lblNuevaCompra;
    public javax.swing.JLabel lblNuevaVenta;
    public javax.swing.JLabel lblProductos;
    public javax.swing.JLabel lblProveedor;
    public javax.swing.JLabel lblReporCompras;
    public javax.swing.JLabel lblReporteVentas;
    public javax.swing.JLabel lblTotalPagarCompra;
    public javax.swing.JLabel lblTotalPagarVenta;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JLabel lblUsuarios;
    public javax.swing.JPanel paginadorCategoria;
    public javax.swing.JPanel paginadorCategoria1;
    public javax.swing.JPanel paginadorCliente;
    private javax.swing.JPanel paginadorProveedor;
    public javax.swing.JPanel paginadorUsuarios;
    public java.awt.Panel panelCaja;
    public javax.swing.JPanel panelReporteCompras;
    public javax.swing.JPanel panelReporteVentas;
    public javax.swing.JTable tblCaja;
    public javax.swing.JTable tblCategoria;
    public javax.swing.JTable tblClientes;
    public javax.swing.JTable tblHistorialCompras;
    public javax.swing.JTable tblHistorialVentas;
    public javax.swing.JTable tblMedida;
    public javax.swing.JTable tblNuevaCompra;
    public javax.swing.JTable tblNuevaVenta;
    public javax.swing.JTable tblProductos;
    public javax.swing.JTable tblProveedor;
    public javax.swing.JTable tblUsuarios;
    public javax.swing.JTextField txtBuscarApertura;
    public javax.swing.JTextField txtBuscarCaja;
    public javax.swing.JTextField txtBuscarCategoria;
    public javax.swing.JTextField txtBuscarCliente;
    public javax.swing.JTextField txtBuscarMedida;
    public javax.swing.JTextField txtBuscarProduct;
    public javax.swing.JTextField txtBuscarProducto;
    public javax.swing.JTextField txtBuscarProveedor;
    public javax.swing.JTextField txtBuscarUsuario;
    public javax.swing.JTextField txtCantidadCompra;
    public javax.swing.JTextField txtCantidadProVenta;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JTextField txtCodProCompra;
    public javax.swing.JTextField txtCodProVenta;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtDevolucionCliente;
    public javax.swing.JTextField txtDevueltaNuevaCompra;
    public javax.swing.JTextField txtDireccionCliente;
    public javax.swing.JTextField txtDireccionEmpresa1;
    public javax.swing.JTextField txtDireccionProveedor;
    public javax.swing.JTextField txtHistorialCompras;
    public javax.swing.JTextField txtHistorialVentas;
    public javax.swing.JTextField txtIdApertura;
    public javax.swing.JTextField txtIdCaja;
    public javax.swing.JTextField txtIdCategoria;
    public javax.swing.JTextField txtIdCliente;
    public javax.swing.JTextField txtIdDatosEmpresa;
    public javax.swing.JTextField txtIdHistorialCompras;
    public javax.swing.JTextField txtIdHistorialVentas;
    public javax.swing.JTextField txtIdMedida;
    public javax.swing.JTextField txtIdProdCompra;
    public javax.swing.JTextField txtIdProducto;
    public javax.swing.JTextField txtIdProductoVenta;
    public javax.swing.JTextField txtIdPrveedor;
    public javax.swing.JTextField txtIdUsuario;
    public javax.swing.JTextField txtMensajeEmpresa;
    public javax.swing.JTextField txtMontoInicial;
    public javax.swing.JTextField txtNitEmpresa;
    public javax.swing.JTextField txtNitNegocio;
    public javax.swing.JTextField txtNombreCaja;
    public javax.swing.JTextField txtNombreCategoria;
    public javax.swing.JTextField txtNombreCliente;
    public javax.swing.JTextField txtNombreEmpresa;
    public javax.swing.JTextField txtNombreMedida;
    public javax.swing.JTextField txtNombreProCompra;
    public javax.swing.JTextField txtNombreProVenta;
    public javax.swing.JTextField txtNombreProveedor;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JTextField txtPagarCon;
    public javax.swing.JTextField txtPagarConLaCompra;
    public javax.swing.JTextField txtPrecCompra;
    public javax.swing.JTextField txtPrecioCompra;
    public javax.swing.JTextField txtPrecioVenta;
    public javax.swing.JTextField txtPrecioVentaProducto;
    public javax.swing.JTextField txtStockProVenta;
    public javax.swing.JTextField txtTelefonoCliente;
    public javax.swing.JTextField txtTelefonoProveedor;
    public javax.swing.JTextField txtTotalCompra;
    public javax.swing.JTextField txtUsuario;
    public javax.swing.JTextField txtabreviadoMedida;
    public javax.swing.JTextField txtfechaRepCompra;
    public javax.swing.JTextField txxTelefonoEmpresa;
    // End of variables declaration//GEN-END:variables
}
