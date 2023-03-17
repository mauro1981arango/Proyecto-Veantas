package Controllers;

import Models.Combo;
import Models.Tables;
import Models.Medidas;
import Models.MedidasDAO;
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

public final class MedidasControllers implements ActionListener, MouseListener, KeyListener {

    private final Medidas medida;
    private final MedidasDAO mediDao;
    private final PanelAdmin views;

    DefaultTableModel modelo = new DefaultTableModel();

    public MedidasControllers(Medidas medida, MedidasDAO mediDao, PanelAdmin views) {
        this.medida = medida;
        this.mediDao = mediDao;
        this.views = views;
        this.views.btnRegistrarMedida.addActionListener(this);
        this.views.btnModificarMedida.addActionListener(this);
        this.views.btnNuevaMedida.addActionListener(this);
        this.views.jMenuEliminarMedida.addActionListener(this);
        this.views.jMenuReingresarMedida.addActionListener(this);
        this.views.lblMedidas.addMouseListener(this);
        this.views.tblMedida.addMouseListener(this);
        this.views.txtBuscarMedida.addKeyListener(this);
        this.views.txtIdMedida.setVisible(false);
        listarMedidas();
        LlenarComboMedidas();
        AutoCompleteDecorator.decorate(views.cbxMedidas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarMedida) {
            // Se valida que las cajas de texto no estén vacías
            if (views.txtNombreMedida.getText().equals("") || views.txtabreviadoMedida.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Se hace la inserción
                medida.setMedida(views.txtNombreMedida.getText());
                medida.setNombre_corto(views.txtabreviadoMedida.getText());
                // Se llama el método RegistrarMedidas de la clase MedidasDAO
                if (mediDao.RegistrarMedidas(medida)) {
                    LimpiarTable();
                    listarMedidas();
                    LimpiarMedidas();
                    JOptionPane.showMessageDialog(null, "Medida registrada");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.btnModificarMedida) {
            // Se valida que las cajas de texto no estén vacías
            if (views.txtIdMedida.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una medida");
            } else {
                // Se hace la modificación de la medida
                medida.setMedida(views.txtNombreMedida.getText());
                medida.setNombre_corto(views.txtabreviadoMedida.getText());
                medida.setId(Integer.parseInt(views.txtIdMedida.getText()));
                // Se llama el método ModificarMedeida de la clase MedidasDAO
                if (mediDao.ModificarMedeida(medida)) {
                    LimpiarTable();
                    listarMedidas();
                    LimpiarMedidas();
                    JOptionPane.showMessageDialog(null, "Medida Modificada");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuEliminarMedida) {
            // Se valida que la caja de texto txtIdMedida no está vacía
            if (views.txtIdMedida.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                /// Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdMedida.getText());
                // Se llama el método ModificarMedida de la clase MedidasDAO
                if (mediDao.accion("Inactivo", id)) {
                    LimpiarTable();
                    listarMedidas();
                    LimpiarMedidas();
                    // Si devuelve true cuando se ha dato de baja la medida
                    JOptionPane.showMessageDialog(null, "Medida dada de baja");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else if (e.getSource() == views.jMenuReingresarMedida) {
            // Se valida que la caja de texto txtIdMedida no está vacío
            if (views.txtIdMedida.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione una fila");
            } else {
                /// Se realiza el seteo del estado
                int id = Integer.parseInt(views.txtIdMedida.getText());
                // Se llama el método ModificarMedida de la clase MedidaDAO
                if (mediDao.accion("Activo", id)) {
                    LimpiarTable();
                    listarMedidas();
                    LimpiarMedidas();
                    // Si devuelve true se ha Reingresado la medida
                    JOptionPane.showMessageDialog(null, "Medida Reingresada");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
            }
        } else {
            LimpiarMedidas();
            views.txtNombreMedida.requestFocus();
            views.btnRegistrarCategoria.setEnabled(true);
        }
    }
    
    public void listarMedidas() {
        Tables color = new Tables();
        views.tblMedida.setDefaultRenderer(views.tblMedida.getColumnClass(0), color);
        List<Medidas> listaMedidas = mediDao.ListaMedidas(views.txtBuscarMedida.getText());
        modelo = (DefaultTableModel) views.tblMedida.getModel();
        Object[] obj = new Object[4];
        for (int i = 0; i < listaMedidas.size(); i++) {
            obj[0] = listaMedidas.get(i).getId();
            obj[1] = listaMedidas.get(i).getMedida();
            obj[2] = listaMedidas.get(i).getNombre_corto();
            obj[3] = listaMedidas.get(i).getEstado();
            modelo.addRow(obj);
        }
        views.tblMedida.setModel(modelo);
        JTableHeader header = views.tblMedida.getTableHeader();
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
    
     public void LimpiarMedidas(){
         views.txtIdMedida.setText("");
         views.txtNombreMedida.setText("");
         views.txtabreviadoMedida.setText("");
         views.txtBuscarMedida.setText("");
     }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.tblMedida){
            int fila = views.tblMedida.rowAtPoint(e.getPoint());
            views.txtIdMedida.setText(views.tblMedida.getValueAt(fila, 0).toString());
            views.txtNombreMedida.setText(views.tblMedida.getValueAt(fila, 1).toString());
            views.txtabreviadoMedida.setText(views.tblMedida.getValueAt(fila, 2).toString());
            views.btnRegistrarCategoria.setEnabled(false);
        }else if(e.getSource() == views.lblMedidas){
            // Al dar clip en medidas del menú principal se abre la vista Medidas
            views.jTabbedPane1.setSelectedIndex(3);
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
        if(e.getSource() == views.txtBuscarMedida){
            LimpiarTable();
            listarMedidas();
        }
    }

    private void LlenarComboMedidas(){
         List<Medidas> lista = mediDao.ListaMedidas(views.txtBuscarMedida.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getMedida();
            views.cbxMedidas.addItem(new Combo(id,nombre));
        }
    }
}
