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

public class CajasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public boolean RegistrarCaja(Cajas caj) {
        sql = "INSERT INTO cajas (nombre_caja) VALUES (?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, caj.getNombre_caja());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List ListaCajas(String valor) {
        List<Cajas> listaCajas = new ArrayList();
        sql = "SELECT * FROM cajas ORDER BY estado ASC";
        String buccar = "SELECT * FROM cajas WHERE nombre_caja LIKE '%" + valor + "%'";
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
                Cajas caj = new Cajas();
                caj.setId_caja(rs.getInt("id_caja"));
                caj.setNombre_caja(rs.getString("nombre_caja"));
                caj.setEstado(rs.getString("estado"));
                listaCajas.add(caj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaCajas;
    }

    public boolean ModificarCajas(Cajas cj) {
        sql = "UPDATE cajas SET nombre_caja=? WHERE id_caja=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cj.getNombre_caja());
            ps.setInt(2, cj.getId_caja());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean accion(String estado, int id_caja) {
        sql = "UPDATE cajas SET estado=? WHERE id_caja=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_caja);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public String AbrirCaja(double monto, int id_usuario, int id_caja) {
        String consulta = "SELECT dc.fecha_apertura, dc.fecha_cierre, dc.monto_inicial, dc.monto_final, dc.total_ventas, u.nombre, cj.nombre_caja FROM detalle_cajas dc INNER JOIN usuarios u ON dc.id_usuario = u.id_usuario INNER JOIN cajas cj ON dc.id_caja = cj.id_caja WHERE dc.estado = 1";
        sql = "INSERT INTO detalle_cajas (monto_inicial, id_usuario, id_caja) VALUES (?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                return "Ya existe";
            } else {
                ps = con.prepareStatement(sql);
                ps.setDouble(1, monto);
                ps.setInt(2, id_usuario);
                ps.setInt(3, id_caja);
                ps.execute();
                return "Registrado";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return "Un error";
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CajasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List ListaAperturas(String valor) {
        List<Cajas> listaAperturaCajas = new ArrayList();
        sql = "SELECT dc.fecha_apertura, dc.fecha_cierre, dc.monto_inicial, dc.monto_final, dc.total_ventas, u.nombre, cj.nombre_caja FROM detalle_cajas dc INNER JOIN usuarios u ON dc.id_usuario = u.id_usuario INNER JOIN cajas cj ON dc.id_caja = cj.id_caja ORDER BY dc.fecha_apertura DESC";
        String buccar = "SELECT dc.fecha_apertura, dc.fecha_cierre, dc.monto_inicial, dc.monto_final, dc.total_ventas, u.nombre, cj.nombre_caja FROM detalle_cajas dc INNER JOIN usuarios u ON dc.id_usuario = u.id_usuario INNER JOIN cajas cj ON dc.id_caja = cj.id_caja WHERE nombre_caja LIKE '%" + valor + "%' u.nombre LIKE '%" + valor + "%' cj.nombre LIKE '%" + valor + "%' dc.fecha_apertura LIKE '%" + valor + "%'";
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
                Cajas caj = new Cajas();
                caj.setFecha_apertura(rs.getString("fecha_apertura"));
                caj.setFecha_cierre(rs.getString("fecha_cierre"));
                caj.setMonto_inicial(rs.getDouble("monto_inicial"));
                caj.setMonto_final(rs.getDouble("monto_final"));
                caj.setTotal_ventas(rs.getInt("total_ventas"));
                caj.setNombre(rs.getString("nombre"));
                caj.setNombre_caja(rs.getString("nombre_caja"));
                listaAperturaCajas.add(caj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaAperturaCajas;
    }
    
    public double MontoFinal(int id_usuario) {
         double monto = 0.0;
        sql = "SELECT SUM(total) AS monto_total FROM ventas WHERE id_usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            rs = ps.executeQuery();
            if (rs.next()){
               monto = rs.getDouble("monto_total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return monto;
    }
    
    public int TotalVentas(int id_usuario) {
         int total = 0;
        sql = "SELECT COUNT(*) AS total FROM ventas WHERE id_usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            rs = ps.executeQuery();
            if (rs.next()){
               total = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return total;
    }
    
     public boolean cerrarCaja(Cajas apert) {
        sql = "UPDATE detalle_cajas SET fecha_cierre=?, monto_final=?, total_ventas=?, estado=? WHERE id_usuario=? AND estado=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, apert.getFecha_cierre());
            ps.setDouble(2, apert.getMonto_final());
            ps.setInt(3, apert.getTotal_ventas());
            ps.setInt(4, 0);
            ps.setInt(5, apert.getId_usuario());
            ps.setInt(6, 1);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}
