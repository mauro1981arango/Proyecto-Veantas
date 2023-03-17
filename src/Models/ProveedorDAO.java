package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProveedorDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public boolean RegistrarProveedor(Proveedor provedor) {
        sql = "INSERT INTO proveedor (nit, proveedor, telefono, direccion) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, provedor.getNit());
            ps.setString(2, provedor.getProveedor());
            ps.setString(3, provedor.getTelefono());
            ps.setString(4, provedor.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List ListaProveedor(String valor) {
        List<Proveedor> listaProveedor = new ArrayList();
        sql = "SELECT * FROM proveedor ORDER BY estado ASC";
        String buccar = "SELECT * FROM proveedor WHERE nit LIKE '%" + valor + "%' OR proveedor LIKE '%" + valor + "%' OR telefono LIKE'%" + valor + "%'";
        try {
            con = cn.getConexion();
            if (valor.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            } else {
                ps = con.prepareStatement(buccar);
                rs = ps.executeQuery();
            }

            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setId(rs.getInt("id"));
                prov.setNit(rs.getString("nit"));
                prov.setProveedor(rs.getString("proveedor"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setEstado(rs.getString("estado"));
                listaProveedor.add(prov);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProveedor;
    }

    public boolean ModificarProveedor(Proveedor prove) {
        sql = "UPDATE `proveedor` SET `nit`=?,`proveedor`=?,`telefono`=?,`direccion`=? WHERE `id`=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prove.getNit());
            ps.setString(2, prove.getProveedor());
            ps.setString(3, prove.getTelefono());
            ps.setString(4, prove.getDireccion());
            ps.setInt(5, prove.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean accion(String estado, int id_proveedor) {
        sql = "UPDATE proveedor SET estado=? WHERE id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_proveedor);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public ArrayList<Proveedor> getProveedor() {
        ArrayList<Proveedor> listaProv = new ArrayList<>();
        sql = "SELECT * FROM proveedor ORDER BY estado ASC";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setId(rs.getInt("id"));
                prov.setNit(rs.getString("nit"));
                prov.setProveedor(rs.getString("proveedor"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setEstado(rs.getString("estado"));
                listaProv.add(prov);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProv;
    }
}
