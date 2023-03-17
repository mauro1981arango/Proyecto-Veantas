package Controllers;

import Models.Cajas;
import Models.CajasDAO;
import Models.Combo;
import Models.FechaYhora;
import Models.Roles;
import Models.RolesDAO;
import Models.Tables;
import Views.PanelAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class CajasControllers implements ActionListener, MouseListener, KeyListener {

    private Cajas cj;
    private CajasDAO cjDao;
    private final PanelAdmin views;

    private Roles rol = new Roles();
    private RolesDAO rolDAO = new RolesDAO();

    DefaultTableModel modelo = new DefaultTableModel();

    public CajasControllers(Cajas cj, CajasDAO cjDao, PanelAdmin views) {
        this.cj = cj;
        this.cjDao = cjDao;
        this.views = views;
        this.views.btnRegistrarCaja.addActionListener(this);
        this.views.btnModificarCaja.addActionListener(this);
        this.views.btnNuevaCaja.addActionListener(this);
        this.views.btnRegistrarApertura.addActionListener(this);
        this.views.btnNuevaApertura.addActionListener(this);
        this.views.btnCerrarCaja.addActionListener(this);
        this.views.jMenuEliminarCaja.addActionListener(this);
        this.views.jMenuReingresarCaja.addActionListener(this);
        this.views.jTabbedPane1.addMouseListener(this);
        this.views.lblCaja.addMouseListener(this);
        this.views.tblCaja.addMouseListener(this);
        this.views.lblAperturaCierre.addMouseListener(this);
        listarCajas();
        this.views.txtIdCaja.setVisible(false);
        LlenarComboCajas();
        AutoCompleteDecorator.decorate(views.cbxCategorias);
        LlenarComboRoles();
        AutoCompleteDecorator.decorate(views.cbxCategorias);
        listarAperturas();
        //mostrarFechaHora();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarCaja) {
            registrarCaja();
        } else if (e.getSource() == views.btnModificarCaja) {
            modificarCaja();
        } else if (e.getSource() == views.jMenuEliminarCaja) {
            eliminarCaja();
        } else if (e.getSource() == views.jMenuReingresarCaja) {
            reingresarCaja();
        } else if (e.getSource() == views.btnRegistrarApertura) {
            abrirCaja();
            listarAperturas();
            limpiarApertura();
            views.txtMontoInicial.requestFocus();
        } else if (e.getSource() == views.btnCerrarCaja) {
            mostrarFechaHora();
            cerrarCaja();
            //listarAperturas();
            limpiarApertura();
        } else if (e.getSource() == views.btnNuevaCaja) {
            //limpiarApertura();
            views.txtNombreCaja.requestFocus();
        }
        if (e.getSource() == views.lblAperturaCierre) {
            views.jTabbedPane1.setSelectedIndex(12);
        }
    }

    public void listarCajas() {
        Tables color = new Tables();
        views.tblCaja.setDefaultRenderer(views.tblCaja.getColumnClass(0), color);
        List<Cajas> listaCajas = cjDao.ListaCajas(views.txtBuscarCaja.getText());
        modelo = (DefaultTableModel) views.tblCaja.getModel();
        Object[] obj = new Object[3];
        for (int i = 0; i < listaCajas.size(); i++) {
            obj[0] = listaCajas.get(i).getId_caja();
            obj[1] = listaCajas.get(i).getNombre_caja();
            obj[2] = listaCajas.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblCaja.setModel(modelo);
        JTableHeader header = views.tblCaja.getTableHeader();
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

    public void LimpiarCaja() {
        views.txtIdCaja.setText("");
        views.txtNombreCaja.setText("");
        views.txtBuscarCaja.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblCaja) {
            int fila = views.tblCaja.rowAtPoint(e.getPoint());
            views.txtIdCaja.setText(views.tblCaja.getValueAt(fila, 0).toString());
            views.txtNombreCaja.setText(views.tblCaja.getValueAt(fila, 1).toString());
        } else if (e.getSource() == views.lblCaja) {
            // Al dar clip en categorías del menú principal se abre la vista Cajas
            views.jTabbedPane1.setSelectedIndex(11);
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

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCaja) {
            LimpiarTable();
            listarCajas();
        }
    }

    private void LlenarComboCajas() {
        List<Cajas> lista = cjDao.ListaCajas(views.txtBuscarUsuario.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId_caja();
            String nombre = lista.get(i).getNombre_caja();
            views.cbxCaja.addItem(new Combo(id, nombre));
        }
    }

    private void LlenarComboRoles() {
        List<Roles> lista = rolDAO.ListaRoles(views.txtBuscarUsuario.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId_rol();
            String nombre = lista.get(i).getNombre_rol();
            views.cbxRol.addItem(new Combo(id, nombre));
        }
    }

    private void registrarCaja() {
        // Se valida que las cajas de texto no estén vacías
        if (views.txtNombreCaja.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Inserte el nombre de una caja");
        } else {
            // Se hace la inserción
            cj.setNombre_caja(views.txtNombreCaja.getText());
            // Se llama el método RegistrarCategoria de la clase CategoriasDAO
            if (cjDao.RegistrarCaja(cj)) {
                LimpiarTable();
                listarCajas();
                LimpiarCaja();

                JOptionPane.showMessageDialog(null, "Caja registrada");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        }
    }

    private void modificarCaja() {
        if (views.txtNombreCaja.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione una caja");
        } else {
            cj.setNombre_caja(views.txtNombreCaja.getText());
            cj.setId_caja(Integer.parseInt(views.txtIdCaja.getText()));
            if (cjDao.ModificarCajas(cj)) {
                LimpiarTable();
                listarCajas();
                LimpiarCaja();
                JOptionPane.showMessageDialog(null, "Caja Modificada");
            }
        }
    }

    private void eliminarCaja() {
        // Se valida que la caja de texto txtIdCaja no está vacía
        if (views.txtIdCaja.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione una fila");
        } else {
            /// Se realiza el seteo del estado
            int id = Integer.parseInt(views.txtIdCaja.getText());
            // Se llama el método ModificarCaja de la clase CajasDAO
            if (cjDao.accion("Inactivo", id)) {
                LimpiarTable();
                listarCajas();
                LimpiarCaja();
                // Si devuelve true cuando se ha dato de baja la caja
                JOptionPane.showMessageDialog(null, "Medida dada de baja");
            }
        }
    }

    private void reingresarCaja() {
        // Se valida que la caja de texto txtIdCaja no está vacía
        if (views.txtIdCaja.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione una fila");
        } else {
            /// Se realiza el seteo del estado
            int id = Integer.parseInt(views.txtIdCaja.getText());
            // Se llama el método ModificarCaja de la clase CajasDAO
            if (cjDao.accion("Activo", id)) {
                LimpiarTable();
                listarCajas();
                LimpiarCaja();
                // Si devuelve true cuando se ha dato de baja la categoria
                JOptionPane.showMessageDialog(null, "Caja Reingresada");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        }
    }

    private void abrirCaja() {
        // Se valida que las cajas de texto no estén vacías
        if (views.txtMontoInicial.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Inserte el monto inicial");
        } else {
            double monto = Double.parseDouble(views.txtMontoInicial.getText());
            int id_usuario = Integer.parseInt(views.lblIdUsuario.getText());
            int id_caja = 1;
            String resultado = cjDao.AbrirCaja(monto, id_usuario, id_caja);
            if ("Ya existe".equalsIgnoreCase(resultado)) {
                JOptionPane.showMessageDialog(null, "La caja ya está abierta");
                LimpiarTable();
                //listarAperturas();
            } else if ("Registrado".equalsIgnoreCase(resultado)) {
                LimpiarTable();
                listarAperturas();
                JOptionPane.showMessageDialog(null, "Caja abierta");
            }
        }
    }

    private void cerrarCaja() {
        int pregunta = JOptionPane.showConfirmDialog(null, "Está seguro de cerrar la caja?");
        if (pregunta == 0) {
            double montoFinal = cjDao.MontoFinal(Integer.parseInt(views.lblIdUsuario.getText()));
            System.out.println("El monto final es : " + montoFinal);
            int totalVentas = cjDao.TotalVentas(Integer.parseInt(views.lblIdUsuario.getText()));
            System.out.println(totalVentas);
            Cajas apert = new Cajas();
            LocalDateTime fechaActual = LocalDateTime.now();
            apert.setFecha_cierre(views.lblFechaDelSistema.getText());
            //apert.setFecha_cierre("2023-03-13 14:20:35");
            apert.setMonto_final(montoFinal);
            apert.setTotal_ventas(totalVentas);
            apert.setId_usuario(Integer.parseInt(views.lblIdUsuario.getText()));
            if (cjDao.cerrarCaja(apert)) {
                JOptionPane.showMessageDialog(null, "Caja Cerrada");
            } else {
                JOptionPane.showMessageDialog(null, "Eerror cerrando la caja");
            }
        }
    }

    private void limpiarApertura() {
        views.txtBuscarApertura.setText("");
        views.txtMontoInicial.setText("");
        views.txtIdApertura.setText("");

    }

    public void listarAperturas() {
        List<Cajas> listaAperturas = cjDao.ListaAperturas(views.txtBuscarApertura.getText());
        modelo = (DefaultTableModel) views.jTableAperturaYCierre.getModel();
        Object[] obj = new Object[7];
        for (int i = 0; i < listaAperturas.size(); i++) {
            obj[0] = listaAperturas.get(i).getFecha_apertura();
            obj[1] = listaAperturas.get(i).getFecha_cierre();
            obj[2] = listaAperturas.get(i).getMonto_inicial();
            obj[3] = listaAperturas.get(i).getMonto_final();
            obj[4] = listaAperturas.get(i).getTotal_ventas();
            obj[5] = listaAperturas.get(i).getNombre();
            obj[6] = listaAperturas.get(i).getNombre_caja();
            modelo.addRow(obj);
        }
        views.jTableAperturaYCierre.setModel(modelo);
        JTableHeader header = views.jTableAperturaYCierre.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.GREEN);
        header.setForeground(Color.BLACK);
    }

    public void mostrarFechaHora() {
        LocalDateTime fechaActual = LocalDateTime.now();
        views.lblFechaDelSistema.setText(""+fechaActual);
    }
}
