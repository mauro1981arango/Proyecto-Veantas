package Controllers;

import Models.Tables;
import Models.Compras;
import Models.ComprasDAO;
import Models.ProductosDAO;
import Views.PanelAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class ComprasControllers implements ActionListener, MouseListener, KeyListener {
    
    private final Compras compras;
    private final ComprasDAO compDao;
    private final PanelAdmin views;
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ComprasControllers(Compras compras, ComprasDAO compDao, PanelAdmin views) {
        this.compras = compras;
        this.compDao = compDao;
        this.views = views;
        this.views.tblHistorialCompras.addMouseListener(this);
        this.views.lblReporCompras.addMouseListener(this);
        this.views.btnBuscarCompra.addActionListener(this);
        this.views.txtHistorialCompras.addKeyListener(this);
        
        listarCompras();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnBuscarCompra) { // Trae una compra del historial en pdf
            if (views.txtIdHistorialCompras.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila" + e.toString());
            } else {
                int IdCompra = Integer.parseInt(views.txtIdHistorialCompras.getText());
                String fecha = views.txtfechaRepCompra.getText();
                ProductosDAO proDAO = new ProductosDAO();
                proDAO.consultarReporteCompra(IdCompra);
            }
        }
    }
    
    public void listarCompras() {
        //Tables color = new Tables();
        //views.tblHistorialCompras.setDefaultRenderer(views.tblHistorialCompras.getColumnClass(0), color);
        List<Compras> listacompras = compDao.ListaCompras(views.txtHistorialCompras.getText());
        modelo = (DefaultTableModel) views.tblHistorialCompras.getModel();
        Object[] obj = new Object[5];
        for (int i = 0; i < listacompras.size(); i++) {
            obj[0] = listacompras.get(i).getId_compra();
            obj[1] = listacompras.get(i).getProveedor();
            obj[2] = listacompras.get(i).getNombre();
            obj[3] = listacompras.get(i).getTotal();
            obj[4] = listacompras.get(i).getFecha();
            modelo.addRow(obj);
        }
        views.tblHistorialCompras.setModel(modelo);
        JTableHeader header = views.tblHistorialCompras.getTableHeader();
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblHistorialCompras) {
            int fila = views.tblHistorialCompras.rowAtPoint(e.getPoint());
            views.txtIdHistorialCompras.setText(views.tblHistorialCompras.getValueAt(fila, 0).toString());
            views.txtfechaRepCompra.setText(views.tblHistorialCompras.getValueAt(fila, 3).toString());
            //views.btnBuscarCompra.setEnabled(false); // Desabilita el botón btnBuscarCompra
        } else if (e.getSource() == views.lblReporCompras) {
            // Al dar clip en Reporte compras del menú principal se abre la vista Reporte Compras
            views.jTabbedPane1.setSelectedIndex(5);
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
        if (e.getSource() == views.txtHistorialCompras) { // Buscar una compra dentro del historial
            LimpiarTable();
            listarCompras();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
