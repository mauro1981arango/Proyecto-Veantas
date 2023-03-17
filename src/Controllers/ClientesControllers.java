package Controllers;

import Models.Tables;
import Models.Clientes;
import Models.ClientesDAO;
import Models.Combo;
import Views.PanelAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class ClientesControllers implements ActionListener, MouseListener, KeyListener {

    private final Clientes cli;
    private final ClientesDAO cliDao;
    private final PanelAdmin views;

    DefaultTableModel modelo = new DefaultTableModel();

    public ClientesControllers(Clientes cli, ClientesDAO cliDao, PanelAdmin views) {
        this.cli = cli;
        this.cliDao = cliDao;
        this.views = views;
        this.views.btnRegistrarCliente.addActionListener(this);
        this.views.btnModificarCliente.addActionListener(this);
        this.views.btnNuevoCliente.addActionListener(this);
        this.views.jMenuEliminarCliente.addActionListener(this);
        this.views.jMenuReingresarCliente.addActionListener(this);
        this.views.lblClientes.addMouseListener(this);
        this.views.tblClientes.addMouseListener(this);
        this.views.txtBuscarCliente.addKeyListener(this);
        listarClientes();
        LlenarComboClientes();
        this.views.txtIdCliente.setVisible(false);
        AutoCompleteDecorator.decorate(views.cbxClienteVenta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarCliente) {
            // Se valida que la caja de texto nombre del cliente no está vacía
            if (views.txtNombreCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Inserte el nombre del cliente");
            } else {
                // Se hace la inserción
                cli.setNombre_cliente(views.txtNombreCliente.getText());
                cli.setTelefono(views.txtTelefonoCliente.getText());
                cli.setDireccion(views.txtDireccionCliente.getText());
                // Se llama el método RegistrarCliente de la clase ClienteDAO
                if (cliDao.RegistrarCliente(cli)) {
                    LimpiarTable();
                    listarClientes();
                    LimpiarCliente();
                    // Si devuelve true se ha registrado dato el cliente
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.btnModificarCliente) {
            // Se valida que la caja de texto txtIdCliente no está vacía
            if (views.txtIdCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe selecionar un cliente");
            } else {
                // Se muestran los daotos dle cliente selecionado en las cajas de texto
                cli.setNombre_cliente(views.txtNombreCliente.getText());
                cli.setTelefono(views.txtTelefonoCliente.getText());
                cli.setDireccion(views.txtDireccionCliente.getText());
                cli.setId_cliente(Integer.parseInt(views.txtIdCliente.getText()));
                // Se llama el método ModificarCliente de la clase ClienteDAO
                if (cliDao.ModificarCliente(cli)) {
                    LimpiarTable();
                    listarClientes();
                    LimpiarCliente();
                    // Si devuelve true se ha registrado dato el cliente
                    JOptionPane.showMessageDialog(null, "Cliente Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuEliminarCliente) {
            // Se valida que la caja de texto txtIdCliente no está vacía
            if (views.txtIdCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdCliente.getText());
                // Se llama el método ModificarCliente de la clase ClienteDAO
                if (cliDao.accion("Inactivo", id)) {
                    LimpiarTable();
                    listarClientes();
                    LimpiarCliente();
                    // Si devuelve true se ha registrado dato el cliente
                    JOptionPane.showMessageDialog(null, "Cliente dado de baja");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuReingresarCliente) {
            // Se valida que la caja de texto txtIdCliente no está vacía
            if (views.txtIdCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila para reingresar");
            } else {
                /// Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdCliente.getText());
                // Se llama el método ModificarCliente de la clase ClienteDAO
                if (cliDao.accion("Activo", id)) {
                    LimpiarTable();
                    listarClientes();
                    LimpiarCliente();
                    // Si devuelve true se ha registrado dato el cliente
                    JOptionPane.showMessageDialog(null, "Cliente Reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else {
            LimpiarCliente();
            views.txtNombreCliente.requestFocus();
            views.btnRegistrarCliente.setEnabled(true);
        }
    }

    public void listarClientes() {
        Tables color = new Tables();
        views.tblClientes.setDefaultRenderer(views.tblClientes.getColumnClass(0), color);
        List<Clientes> listaClientes = cliDao.ListaClientes(views.txtBuscarCliente.getText());
        modelo = (DefaultTableModel) views.tblClientes.getModel();
        Object[] obj = new Object[5];
        for (int i = 0; i < listaClientes.size(); i++) {
            obj[0] = listaClientes.get(i).getId_cliente();
            obj[1] = listaClientes.get(i).getNombre_cliente();
            obj[2] = listaClientes.get(i).getTelefono();
            obj[3] = listaClientes.get(i).getDireccion();
            obj[4] = listaClientes.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblClientes.setModel(modelo);
        JTableHeader header = views.tblClientes.getTableHeader();
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

    public void LimpiarCliente() {
        views.txtIdCliente.setText("");
        views.txtNombreCliente.setText("");
        views.txtTelefonoCliente.setText("");
        views.txtDireccionCliente.setText("");
        views.txtBuscarCliente.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblClientes) {
            int fila = views.tblClientes.rowAtPoint(e.getPoint());
            views.txtIdCliente.setText(views.tblClientes.getValueAt(fila, 0).toString());
            views.txtNombreCliente.setText(views.tblClientes.getValueAt(fila, 1).toString());
            views.txtTelefonoCliente.setText(views.tblClientes.getValueAt(fila, 2).toString());
            views.txtDireccionCliente.setText(views.tblClientes.getValueAt(fila, 3).toString());
            views.btnRegistrarCliente.setEnabled(false);
        } else if (e.getSource() == views.lblClientes) {
            // Al dar clip en clentes del menú principal se abre la vista cilentes
            views.jTabbedPane1.setSelectedIndex(0);
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
        if (e.getSource() == views.txtBuscarCliente) {
            LimpiarTable();
            listarClientes();
        }
    }

    private void LlenarComboClientes() {
        List<Clientes> lista = cliDao.ListaClientes(views.txtBuscarCliente.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId_cliente();
            String nombre = lista.get(i).getNombre_cliente();
            views.cbxClienteVenta.addItem(new Combo(id, nombre));
        }
    }
}
