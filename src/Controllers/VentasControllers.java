package Controllers;

import Models.CambiarColorCeldasTabla;
import Models.Tables;
import Models.Compras;
import Models.ComprasDAO;
import Models.ProductosDAO;
import Models.Ventas;
import Models.VentasDAO;
import Views.PanelAdmin;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class VentasControllers implements ActionListener, MouseListener, KeyListener {

    private Ventas venta;
    private VentasDAO vDAO;
    private PanelAdmin views;
    DefaultTableModel modelo = new DefaultTableModel();
    CambiarColorCeldasTabla r = new CambiarColorCeldasTabla();
    
    public VentasControllers(Ventas venta, VentasDAO vDAO, PanelAdmin views) {
        this.venta = venta;
        this.vDAO = vDAO;
        this.views = views;
        this.views.tblHistorialVentas.addMouseListener(this);
        this.views.lblReporteVentas.addMouseListener(this);
        this.views.btnBuscarVenta.addActionListener(this);
        this.views.txtHistorialVentas.addKeyListener(this);
        listarVentas();
        views.tblHistorialVentas.setDefaultRenderer(Object.class, r);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnBuscarVenta) { // Trae una compra del historial en pdf
            if (views.txtIdHistorialVentas.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila" + e.toString());
            } else {
                int IdVenta = Integer.parseInt(views.txtIdHistorialVentas.getText());
                vDAO.consultarReporteVentas(IdVenta);
            }
        }
    }
    
     public void listarVentas() {
        //Tables color = new Tables();
        //views.tblHistorialCompras.setDefaultRenderer(views.tblHistorialCompras.getColumnClass(0), color);
        List<Ventas> listaVentas = vDAO.ListaVentas(views.txtHistorialVentas.getText());
        modelo = (DefaultTableModel) views.tblHistorialVentas.getModel();
        Object[] obj = new Object[9];
        for (int i = 0; i < listaVentas.size(); i++) {
            obj[0] = listaVentas.get(i).getId_venta();
            obj[1] = listaVentas.get(i).getDescripcion();
            obj[2] = listaVentas.get(i).getCantidad();
            obj[3] = listaVentas.get(i).getTotal();
            obj[4] = listaVentas.get(i).getNombre_cliente();
            obj[5] = listaVentas.get(i).getTelefono();
            obj[6] = listaVentas.get(i).getNombre();
            obj[7] = listaVentas.get(i).getNombre_caja();
            obj[8] = listaVentas.get(i).getFecha();
            modelo.addRow(obj);
        }
        views.tblHistorialVentas.setModel(modelo);
        JTableHeader header = views.tblHistorialVentas.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        views.tblHistorialVentas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Agrega barra horizontal en la parte inferior de la tabla
        views.tblHistorialVentas.getTableHeader().setFont(new Font("Cooper Black",1,14)); // Cambia el tipo de letra del encabezado de la tabla
    }
       
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tblHistorialVentas) {
            int fila = views.tblHistorialVentas.rowAtPoint(e.getPoint());
            views.txtIdHistorialVentas.setText(views.tblHistorialVentas.getValueAt(fila, 0).toString());
            //views.btnBuscarCompra.setEnabled(false); // Desabilita el botón btnBuscarCompra
        } else if (e.getSource() == views.lblReporteVentas) {
            // Al dar clip en Reporte compras del menú principal se abre la vista Reporte Compras
            views.jTabbedPane1.setSelectedIndex(4);
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
         if (e.getSource() == views.txtHistorialVentas) { // Buscar una venta dentro del historial
            LimpiarTable();
            listarVentas();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
