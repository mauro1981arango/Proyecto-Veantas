package Controllers;

import Models.Cajas;
import Models.CajasDAO;
import Models.Combo;
import Models.Roles;
import Models.RolesDAO;
import Models.Tables;
import Models.Usuarios;
import Models.UsuariosDAO;
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

public final class UsuariosControllers implements ActionListener, MouseListener, KeyListener {

    private final Usuarios usu;
    private final UsuariosDAO usuDao;
    private final PanelAdmin views;

    DefaultTableModel modelo = new DefaultTableModel();
    
    Cajas cj = new Cajas();
    CajasDAO cjDAO = new CajasDAO();
    Roles rol = new Roles();
    RolesDAO rolDAO =new RolesDAO();

    public UsuariosControllers(Usuarios usu, UsuariosDAO usuDao, PanelAdmin views) {
        this.usu = usu;
        this.usuDao = usuDao;
        this.views = views;
        this.views.btnRegistrarUsuario.addActionListener(this);
        this.views.btnModificarUsuario.addActionListener(this);
        this.views.btnNuevoUsuario.addActionListener(this);
        this.views.jMenuEliminarUsuario.addActionListener(this);
        this.views.jMenuReingresarUsuario.addActionListener(this);
        this.views.lblUsuarios.addMouseListener(this);
        this.views.txtBuscarUsuario.addKeyListener(this);
        this.views.tblUsuarios.addMouseListener(this);
        listarUsuarios();
        views.txtIdUsuario.setVisible(false);
        views.lblNombreUsuario.setVisible(true);
        views.lblNombreUsuario.setText(usu.getNombre());
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Primero se valida que los campos de texto no estén vacíos.
        if (e.getSource() == views.btnRegistrarUsuario) {
            if (views.txtUsuario.getText().equals("") || views.txtNombreUsuario.getText().equals("") || String.valueOf(views.txtClave.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Tdos los campos son obligatorios");
            } else {
                // Si los campoe no están vacíos hacemos la inserción de los datos
                usu.setUsuario(views.txtUsuario.getText());
                usu.setNombre(views.txtNombreUsuario.getText());
                usu.setClave(String.valueOf(views.txtClave.getPassword()));
                Combo itemCaja = (Combo) views.cbxCaja.getSelectedItem();
                Combo itemRoles = (Combo) views.cbxRol.getSelectedItem();
                cj.setId_caja(itemCaja.getId());
                rol.setId_rol(itemRoles.getId());
                // Llamamos  el método RegistrarUsuario de la clase UsuariosDAO
                if (usuDao.RegistrarUsuario(usu)) {
                    // Si devuelve true se han registrado datos
                    LimpiarTable();
                    LimpiarCajasTexto();
                    listarUsuarios();
                    views.txtBuscarUsuario.requestFocus();
                    JOptionPane.showMessageDialog(null, "Usuario Registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.btnModificarUsuario) {
            if (views.txtIdUsuario.getText().equals("") || views.txtBuscarUsuario.getText().equals("") || views.txtNombreUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tdos los campos son obligatorios");
            } else {
                // Si los campoe no están vacíos hacemos la actualización de los datos
                usu.setUsuario(views.txtBuscarUsuario.getText());
                usu.setNombre(views.txtNombreUsuario.getText());
                Combo itemCaja = (Combo) views.cbxCaja.getSelectedItem();
                Combo itemRoles = (Combo) views.cbxRol.getSelectedItem();
                cj.setId_caja(itemCaja.getId());
                rol.setId_rol(itemRoles.getId());
                usu.setId_usuario(Integer.parseInt(views.txtIdUsuario.getText()));
                // Llamamos  el método ModificarUsuario de la clase UsuariosDAO
                if (usuDao.ModificarUsuario(usu)) {
                    // Si devuelve true se han actualizado datos
                    LimpiarTable();
                    LimpiarCajasTexto();
                    listarUsuarios();
                    views.txtBuscarUsuario.requestFocus();
                    JOptionPane.showMessageDialog(null, "Usuario Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuEliminarUsuario) {
            // Se verifica si la fila está seleconada
            if (views.txtIdUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdUsuario.getText());
                if (usuDao.accion("Inactivo", id)) {
                    LimpiarTable();
                    LimpiarCajasTexto();
                    listarUsuarios();
                    JOptionPane.showMessageDialog(null, "Usuario eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar el Usuario");
                }
            }
        } else if (e.getSource() == views.jMenuReingresarUsuario) {
            // Se verifica si la fila está seleconada
            if (views.txtIdUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila para reingresar");
            } else {
                // Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdUsuario.getText());
                if (usuDao.accion("Activo", id)) {
                    LimpiarTable();
                    LimpiarCajasTexto();
                    listarUsuarios();
                    JOptionPane.showMessageDialog(null, "Usuario Reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error, no se pudo Reingresar el Usuario");
                }
            }
        }else{
            views.txtUsuario.requestFocus();
            LimpiarCajasTexto();
            views.btnRegistrarUsuario.setEnabled(true);
        }
    }

    public void listarUsuarios() {
        Tables color = new Tables();
        views.tblUsuarios.setDefaultRenderer(views.tblUsuarios.getColumnClass(0), color);
        List<Usuarios> listaUsuarios = usuDao.ListaUsuarios(views.txtBuscarUsuario.getText());
        modelo = (DefaultTableModel) views.tblUsuarios.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < listaUsuarios.size(); i++) {
            obj[0] = listaUsuarios.get(i).getId_usuario();
            obj[1] = listaUsuarios.get(i).getUsuario();
            obj[2] = listaUsuarios.get(i).getNombre();
            obj[3] = listaUsuarios.get(i).getNombre_caja();
            obj[4] = listaUsuarios.get(i).getNombre_rol();
            obj[5] = listaUsuarios.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblUsuarios.setModel(modelo);
        JTableHeader header = views.tblUsuarios.getTableHeader();
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
    
    public void LimpiarCajasTexto(){
        views.txtIdUsuario.setText("");
        views.txtUsuario.setText("");
        views.txtBuscarUsuario.setText("");
        views.txtNombreUsuario.setText("");
        views.txtClave.setText("");
        views.cbxCaja.setSelectedIndex(0);
        views.cbxRol.setSelectedIndex(0);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblUsuarios) {
            int fila = views.tblUsuarios.rowAtPoint(e.getPoint());
            views.txtIdUsuario.setText(views.tblUsuarios.getValueAt(fila, 0).toString());
            views.txtUsuario.setText(views.tblUsuarios.getValueAt(fila, 1).toString());
            views.txtNombreUsuario.setText(views.tblUsuarios.getValueAt(fila, 2).toString());
            //views.cbxCaja.setSelectedItem(views.tblUsuarios.getValueAt(fila, 3).toString());
            views.cbxCaja.setSelectedItem(new Combo(cj.getId_caja(), cj.getNombre_caja()));
            //views.cbxRol.setSelectedItem(views.tblUsuarios.getValueAt(fila, 4).toString());
            views.cbxRol.setSelectedItem(new Combo(rol.getId_rol(), rol.getNombre_rol()));
            views.txtClave.setEnabled(false);
            views.btnRegistrarUsuario.setEnabled(false);
        }else if(e.getSource() == views.lblUsuarios){
             // Al dar clip en usuarios del menú principal se abre la vista Usuarios
            views.jTabbedPane1.setSelectedIndex(8);
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
        if(e.getSource() == views.txtBuscarUsuario){
            // Se llama el método limpiar Table
            LimpiarTable();
            listarUsuarios();
        }
    }
}
