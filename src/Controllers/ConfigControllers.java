package Controllers;

import Models.Configuracion;
import Models.ConfiguracionDAO;
import Views.PanelAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ConfigControllers implements MouseListener {

    private Configuracion conf;
    private ConfiguracionDAO confiDAO;
    private PanelAdmin views;

    public ConfigControllers(Configuracion conf, ConfiguracionDAO confiDAO, PanelAdmin views) {
        this.conf = conf;
        this.confiDAO = confiDAO;
        this.views = views;
        // Ponemos la escucha del mouseListener a todos los label del menú.
        this.views.lblCatagorias.addMouseListener(this);
        this.views.lblClientes.addMouseListener(this);
        this.views.lblConfiguracion.addMouseListener(this);
        this.views.lblMedidas.addMouseListener(this);
        this.views.lblNuevaVenta.addMouseListener(this);
        this.views.lblNuevaCompra.addMouseListener(this);
        this.views.lblProductos.addMouseListener(this);
        this.views.lblProveedor.addMouseListener(this);
        this.views.lblUsuarios.addMouseListener(this);
        this.views.lblAperturaCierre.addMouseListener(this);
        this.views.lblCaja.addMouseListener(this);
        this.views.lblReporteVentas.addMouseListener(this);
        this.views.lblReporCompras.addMouseListener(this);
        this.views.txtIdDatosEmpresa.setVisible(false);
        conf = confiDAO.getDatosEmpresa();
        views.txtIdDatosEmpresa.setText("" + conf.getId_conf());
        views.txtNitNegocio.setText("" + conf.getNit());
        views.txtNombreEmpresa.setText("" + conf.getNombreEmpresa());
        views.txxTelefonoEmpresa.setText("" + conf.getTelefono());
        views.txtDireccionEmpresa1.setText("" + conf.getDireccion());
        views.txtMensajeEmpresa.setText("" + conf.getMensaje());
        this.views.btnModificarDatosEmpresa.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Verificamos en qué label está el mouse.
        if (e.getSource() == views.lblCatagorias) {
            views.jPanelCategorias.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblClientes) {
            views.jPanelClientes.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblConfiguracion) {
            views.jPanelConfiguracion.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblMedidas) {
            views.jPanelMedidas.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblNuevaCompra) {
            views.jPanelNuevaCompra.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblNuevaVenta) {
            views.jPanelNuevaVenta.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblProductos) {
            views.jPanelProductos.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblProveedor) {
            views.jPanelProveedor.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblUsuarios) {
            views.jPanelUsuarios.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblConfiguracion) {
            views.jPanelConfiguracion.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblCaja) {
            views.panelCaja.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblReporCompras) {
            views.panelReporteCompras.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblReporteVentas) {
            views.panelReporteVentas.setBackground(Color.ORANGE);
        } else if (e.getSource() == views.lblAperturaCierre) {
            views.jPanelAperturaCierre.setBackground(Color.ORANGE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Verificamos en qué label está el mouse y quitamos el BagoungColor.
        if (e.getSource() == views.lblCatagorias) {
            views.jPanelCategorias.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblClientes) {
            views.jPanelClientes.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblConfiguracion) {
            views.jPanelConfiguracion.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblMedidas) {
            views.jPanelMedidas.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblNuevaCompra) {
            views.jPanelNuevaCompra.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblNuevaVenta) {
            views.jPanelNuevaVenta.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblProductos) {
            views.jPanelProductos.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblProveedor) {
            views.jPanelProveedor.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblUsuarios) {
            views.jPanelUsuarios.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblConfiguracion) {
            views.jPanelConfiguracion.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblCaja) {
            views.panelCaja.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblReporCompras) {
            views.panelReporteCompras.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblReporteVentas) {
            views.panelReporteVentas.setBackground(new Color(0, 102, 51));
        } else if (e.getSource() == views.lblAperturaCierre) {
            views.jPanelAperturaCierre.setBackground(new Color(0, 102, 51));
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnModificarDatosEmpresa) {
            if (views.txtIdDatosEmpresa.getText().equals("") || views.txtNitNegocio.getText().equals("") || views.txtNombreEmpresa.getText().equals("") || views.txxTelefonoEmpresa.getText().equals("") || views.txtDireccionEmpresa1.getText().equals("") || views.txtMensajeEmpresa.getText().equals("")) {
            } else {
                conf.setId_conf(Integer.parseInt(views.txtIdDatosEmpresa.getText()));
                conf.setNit(views.txtNitNegocio.getText());
                conf.setNombreEmpresa(views.txtNombreEmpresa.getText());
                conf.setTelefono(views.txxTelefonoEmpresa.getText());
                conf.setDireccion(views.txtDireccionEmpresa1.getText());
                conf.setMensaje(views.txtMensajeEmpresa.getText());
            }
            if (confiDAO.ModificarDatosEmpresa(conf)) {
                JOptionPane.showMessageDialog(null, "Datos de la tienda Modificados");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modidficar ningún dato de la tienda");
            }
        } // JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
    }
}
