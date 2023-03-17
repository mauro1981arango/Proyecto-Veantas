package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    public boolean RegistrarCategorias(Categorias cat) {
        sql = "INSERT INTO categorias (categoria) VALUES (?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCategoria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public List ListaCategorias(String valor) {
        List<Categorias> listaCategorias = new ArrayList();
        sql = "SELECT * FROM categorias ORDER BY estado ASC";
        String buccar = "SELECT * FROM categorias WHERE categoria LIKE '%" + valor + "%'";
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
                Categorias cate = new Categorias();
                cate.setId(rs.getInt("id"));
                cate.setCategoria(rs.getString("categoria"));
                cate.setEstado(rs.getString("estado"));
                listaCategorias.add(cate);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaCategorias;
    }
    
    public boolean ModificarCategorias(Categorias ctg) {
        sql = "UPDATE categorias SET categoria=? WHERE id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ctg.getCategoria());
            ps.setInt(2, ctg.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean accion(String estado, int id) {
        sql = "UPDATE categorias SET estado=? WHERE id=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}
