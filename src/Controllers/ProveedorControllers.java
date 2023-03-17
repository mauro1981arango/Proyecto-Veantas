package Controllers;

import Models.Combo;
import Models.Tables;
import Models.Proveedor;
import Models.ProveedorDAO;
import Views.PanelAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class ProveedorControllers implements ActionListener, MouseListener, KeyListener {

    private final Proveedor prov;
    private final ProveedorDAO provDao;
    private final PanelAdmin views;

    DefaultTableModel modelo = new DefaultTableModel();

    public ProveedorControllers(Proveedor prov, ProveedorDAO provDao, PanelAdmin views) {
        this.prov = prov;
        this.provDao = provDao;
        this.views = views;
        this.views.btnRegistrarProveedor.addActionListener(this);
        this.views.btnModificarProveedor.addActionListener(this);
        this.views.btnNuevoProveedor.addActionListener(this);
        this.views.jMenuEliminarProveedor.addActionListener(this);
        this.views.jMenuReingresarProveedor.addActionListener(this);
        this.views.lblProveedor.addMouseListener(this);
        this.views.tblProveedor.addMouseListener(this);
        this.views.txtBuscarProveedor.addKeyListener(this);
        listarProveedores();
        this.views.txtIdPrveedor.setVisible(false);
        LlenarComboProveedor();
        //LlenarProveedor();
        AutoCompleteDecorator.decorate(views.cbxProveedor);
        AutoCompleteDecorator.decorate(views.cbxProveedorCompra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarProveedor) {
            // Se valida que las cajas de texto no están vacías
            if (views.txtNitEmpresa.getText().equals("") || views.txtNombreProveedor.getText().equals("") || views.txtTelefonoProveedor.getText().equals("") || views.txtDireccionProveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los  campos son obligatorios");
            } else {
                // Se hace la inserción
                prov.setNit(views.txtNitEmpresa.getText());
                prov.setProveedor(views.txtNombreProveedor.getText());
                prov.setTelefono(views.txtTelefonoProveedor.getText());
                prov.setDireccion(views.txtDireccionProveedor.getText());
                if (provDao.RegistrarProveedor(prov)) {
                    LimpiarTable();
                    listarProveedores();
                    LimpiarProveedor();
                    //int opcion = views.cbxProveedor.getSelectedIndex();
                    //JOptionPane.showMessageDialog(null, "Opción " + opcion);
                    // Si devuelve true se ha registrado el proveedor
                    JOptionPane.showMessageDialog(null, "Proveedor registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.btnModificarProveedor) {
            // Se valida que la caja de texto txtIdPrveedor no está vacía
            if (views.txtIdPrveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione un proveedor");
            } else {
                // Se hace la inserción
                prov.setNit(views.txtNitEmpresa.getText());
                prov.setProveedor(views.txtNombreProveedor.getText());
                prov.setTelefono(views.txtTelefonoProveedor.getText());
                prov.setDireccion(views.txtDireccionProveedor.getText());
                prov.setId(Integer.parseInt(views.txtIdPrveedor.getText()));
                if (provDao.ModificarProveedor(prov)) {
                    LimpiarTable();
                    listarProveedores();
                    LimpiarProveedor();
                    // Si devuelve true se ha modificado el proveedor
                    JOptionPane.showMessageDialog(null, "Proveedor Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                    LimpiarProveedor();
                }
            }
        } else if (e.getSource() == views.jMenuEliminarProveedor) {
            // Se valida que la caja de texto txtIdPrveedor no está vacía
            if (views.txtIdPrveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdPrveedor.getText());
                // Se llama el método accion de la clase ProveedorDAO
                if (provDao.accion("Inactivo", id)) {
                    LimpiarTable();
                    listarProveedores();
                    LimpiarProveedor();
                    // Si devuelve true se ha dado de baja el proveedor
                    JOptionPane.showMessageDialog(null, "Proveedor dado de baja");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuReingresarProveedor) {
            // Se valida que la caja de texto txtIdPrveedor no está vacía
            if (views.txtIdPrveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdPrveedor.getText());
                // Se llama el método accion de la clase ProveedorDAO
                if (provDao.accion("Activo", id)) {
                    LimpiarTable();
                    listarProveedores();
                    LimpiarProveedor();
                    // Si devuelve true se ha dado de baja el proveedor
                    JOptionPane.showMessageDialog(null, "Proveedor Reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else {
            LimpiarProveedor();
            views.txtNitEmpresa.requestFocus();
            views.btnRegistrarProveedor.setEnabled(true);
        }
    }

    public void listarProveedores() {
        Tables color = new Tables();
        views.tblProveedor.setDefaultRenderer(views.tblProveedor.getColumnClass(0), color);
        List<Proveedor> listaProveedores = provDao.ListaProveedor(views.txtBuscarProveedor.getText());
        modelo = (DefaultTableModel) views.tblProveedor.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < listaProveedores.size(); i++) {
            obj[0] = listaProveedores.get(i).getId();
            obj[1] = listaProveedores.get(i).getNit();
            obj[2] = listaProveedores.get(i).getProveedor();
            obj[3] = listaProveedores.get(i).getTelefono();
            obj[4] = listaProveedores.get(i).getDireccion();
            obj[5] = listaProveedores.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblProveedor.setModel(modelo);
        JTableHeader header = views.tblProveedor.getTableHeader();
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

    public void LimpiarProveedor() {
        views.txtIdPrveedor.setText("");
        views.txtNitEmpresa.setText("");
        views.txtNombreProveedor.setText("");
        views.txtTelefonoProveedor.setText("");
        views.txtDireccionProveedor.setText("");
        views.txtBuscarProveedor.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblProveedor) {
            int fila = views.tblProveedor.rowAtPoint(e.getPoint());
            views.txtIdPrveedor.setText(views.tblProveedor.getValueAt(fila, 0).toString());
            views.txtNitEmpresa.setText(views.tblProveedor.getValueAt(fila, 1).toString());
            views.txtNombreProveedor.setText(views.tblProveedor.getValueAt(fila, 2).toString());
            views.txtTelefonoProveedor.setText(views.tblProveedor.getValueAt(fila, 3).toString());
            views.txtDireccionProveedor.setText(views.tblProveedor.getValueAt(fila, 4).toString());
            views.btnRegistrarProveedor.setEnabled(false);
        } else if (e.getSource() == views.lblProveedor) {
            // Al dar clip en proveedores del menú principal se abre la vista Proveedores
            views.jTabbedPane1.setSelectedIndex(1);
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
        if (e.getSource() == views.txtBuscarProveedor) {
            LimpiarTable();
            listarProveedores();
        }
    }

    private void LlenarComboProveedor(){
         List<Proveedor> lista = provDao.ListaProveedor(views.txtBuscarProveedor.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getProveedor();
            views.cbxProveedor.addItem(new Combo(id, nombre));
            views.cbxProveedorCompra.addItem(new Combo(id, nombre));
        }
    }
//    private void LlenarProveedor() {
//        //int idSelecionado = 0;
//        ProveedorDAO pDao = new ProveedorDAO();
//        ArrayList<Proveedor> listaProvedor = pDao.getProveedor();
//        views.cbxProveedorCompra.removeAllItems();
//        for (int i = 0; i < listaProvedor.size(); i++) {
//            views.cbxProveedorCompra.addItem(new Proveedor(listaProvedor.get(i).getId(), listaProvedor.get(i).getProveedor()));
//        }
//        views.cbxProveedorCompra.setSelectedItem();
//    }
}
