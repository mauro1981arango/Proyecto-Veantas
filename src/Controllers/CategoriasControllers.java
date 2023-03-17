package Controllers;

import Models.Tables;
import Models.Categorias;
import Models.CategoriasDAO;
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

public final class CategoriasControllers implements ActionListener, MouseListener, KeyListener {
    
    private final Categorias cat;
    private final CategoriasDAO catDao;
    private final PanelAdmin views;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public CategoriasControllers(Categorias cat, CategoriasDAO catDao, PanelAdmin views) {
        this.cat = cat;
        this.catDao = catDao;
        this.views = views;
        this.views.btnRegistrarCategoria.addActionListener(this);
        this.views.btnModificarCategoria.addActionListener(this);
        this.views.btnNuevaCategoria.addActionListener(this);
        this.views.jMenuEliminarCategoria.addActionListener(this);
        this.views.jMenuReingresarCategoria.addActionListener(this);
        this.views.lblCatagorias.addMouseListener(this);
        this.views.tblCategoria.addMouseListener(this);
        this.views.txtBuscarCategoria.addKeyListener(this);
        listarCategorias();
        this.views.txtIdCategoria.setVisible(false);
        LlenarComboCategorias();
        AutoCompleteDecorator.decorate(views.cbxCategorias);
    }  
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarCategoria) {
            // Se valida que las cajas de texto no estén vacías
            if (views.txtNombreCategoria.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Inserte el nombre de una categoría");
            } else {
                // Se hace la inserción
                cat.setCategoria(views.txtNombreCategoria.getText());
                // Se llama el método RegistrarCategoria de la clase CategoriasDAO
                if(catDao.RegistrarCategorias(cat)){
                    LimpiarTable();
                    listarCategorias();
                    LimpiarCategoria();
                    JOptionPane.showMessageDialog(null, "Categoría registrada");
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        }else if (e.getSource() == views.btnModificarCategoria) {
            // Se valida que las cajas de texto no estén vacías
            if (views.txtIdCategoria.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una categoría");
            } else {
                // Se hace la modificación de la categoría
                cat.setCategoria(views.txtNombreCategoria.getText());
                cat.setId(Integer.parseInt(views.txtIdCategoria.getText()));
                // Se llama el método RegistrarCategoria de la clase CategoriasDAO
                if(catDao.ModificarCategorias(cat)){
                    LimpiarTable();
                    listarCategorias();
                    LimpiarCategoria();
                    JOptionPane.showMessageDialog(null, "Categoría Modificada");
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        }else if(e.getSource() == views.jMenuEliminarCategoria){
            // Se valida que la caja de texto txtIdCategoria no está vacía
            if(views.txtIdCategoria.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            }else{
                /// Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdCategoria.getText());
                // Se llama el método ModificarCliente de la clase ClienteDAO
                if(catDao.accion("Inactivo", id)){
                    LimpiarTable();
                    listarCategorias();
                    LimpiarCategoria();
                    // Si devuelve true cuando se ha dato de baja la categoria
                    JOptionPane.showMessageDialog(null, "Categoría dada de baja");
                }else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        }else if(e.getSource() == views.jMenuReingresarCategoria){
            // Se valida que la caja de texto txtIdCategoria no está vacía
            if(views.txtIdCategoria.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            }else{
                /// Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdCategoria.getText());
                // Se llama el método ModificarCliente de la clase ClienteDAO
                if(catDao.accion("Activo", id)){
                    LimpiarTable();
                    listarCategorias();
                    LimpiarCategoria();
                    // Si devuelve true cuando se ha dato de baja la categoria
                    JOptionPane.showMessageDialog(null, "Categoría Reingresada");
                }else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        }else{
           LimpiarCategoria();
           views.txtNombreCategoria.requestFocus();
        }
    }
    
    public void listarCategorias() {
        Tables color = new Tables();
        views.tblCategoria.setDefaultRenderer(views.tblCategoria.getColumnClass(0), color);
        List<Categorias> listaCategorias = catDao.ListaCategorias(views.txtBuscarCategoria.getText());
        modelo = (DefaultTableModel) views.tblCategoria.getModel();
        Object[] obj = new Object[3];
        for (int i = 0; i < listaCategorias.size(); i++) {
            obj[0] = listaCategorias.get(i).getId();
            obj[1] = listaCategorias.get(i).getCategoria();
            obj[2] = listaCategorias.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblCategoria.setModel(modelo);
        JTableHeader header = views.tblCategoria.getTableHeader();
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
    
    public void LimpiarCategoria(){
         views.txtIdCategoria.setText("");
         views.txtNombreCategoria.setText("");
         views.txtBuscarCategoria.setText("");
     }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.tblCategoria){
            int fila = views.tblCategoria.rowAtPoint(e.getPoint());
            views.txtIdCategoria.setText(views.tblCategoria.getValueAt(fila, 0).toString());
            views.txtNombreCategoria.setText(views.tblCategoria.getValueAt(fila, 1).toString());
        }else if(e.getSource() == views.lblCatagorias){
            // Al dar clip en categorías del menú principal se abre la vista Categoría
            views.jTabbedPane1.setSelectedIndex(2);
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
        if(e.getSource() == views.txtBuscarCategoria){
            LimpiarTable();
            listarCategorias();
        }
    }
   
     private void LlenarComboCategorias(){
         List<Categorias> lista = catDao.ListaCategorias(views.txtBuscarCategoria.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getCategoria();
            views.cbxCategorias.addItem(new Combo(id, nombre));
        }
    }
}
