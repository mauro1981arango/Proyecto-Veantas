package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConfiguracionDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public Configuracion getDatosEmpresa() {
        sql = "SELECT * FROM `configuracion`";
        Configuracion confi = new Configuracion();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                confi.setId_conf(rs.getInt("id_conf"));
                confi.setNit(rs.getString("nit"));
                confi.setNombreEmpresa(rs.getString("nombreEmpresa"));
                confi.setTelefono(rs.getString("telefono"));
                confi.setDireccion(rs.getString("direccion"));
                confi.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return confi;
    }

    public boolean ModificarDatosEmpresa(Configuracion conf) {
        sql = "UPDATE configuracion SET nit=?, nombreEmpresa=?, telefono=?, direccion=?, mensaje=? WHERE id_conf=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, conf.getNit());
            ps.setString(2, conf.getNombreEmpresa());
            ps.setString(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setString(5, conf.getMensaje());
            ps.setInt(6, conf.getId_conf());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConfiguracionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
