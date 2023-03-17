package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MedidasDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    public boolean RegistrarMedidas(Medidas md) {
        sql = "INSERT INTO medidas (medida, nombre_corto) VALUES (?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, md.getMedida());
            ps.setString(2, md.getNombre_corto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public List ListaMedidas(String valor) {
        List<Medidas> listaMedidas = new ArrayList();
        sql = "SELECT * FROM medidas ORDER BY estado ASC";
        String buccar = "SELECT * FROM medidas WHERE medida LIKE '%" + valor + "%' OR nombre_corto LIKE'%" + valor + "%'";
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
                Medidas mds = new Medidas();
                mds.setId(rs.getInt("id"));
                mds.setMedida(rs.getString("medida"));
                mds.setNombre_corto(rs.getString("nombre_corto"));
                mds.setEstado(rs.getString("estado"));
                listaMedidas.add(mds);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaMedidas;
    }
    
    public boolean ModificarMedeida(Medidas medidas) {
        sql = "UPDATE medidas SET medida=?, nombre_corto=? WHERE id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, medidas.getMedida());
            ps.setString(2, medidas.getNombre_corto());
            ps.setInt(3, medidas.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean accion(String estado, int id_medida) {
        sql = "UPDATE medidas SET estado=? WHERE id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_medida);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}
