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

public class UsuariosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public Usuarios login(String usuario, String clave) {
        sql = "SELECT * FROM `usuarios` WHERE usuario=? AND clave=?";
        Usuarios usu = new Usuarios();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if (rs.next()) {
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setClave(rs.getString("clave"));
                usu.setId_caja(rs.getInt("id_caja"));
                usu.setId_rol(rs.getInt("id_rol"));
                usu.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return usu;
    }

    public boolean RegistrarUsuario(Usuarios usuario) {
        sql = "INSERT INTO usuarios (usuario, nombre, clave, id_caja, id_rol) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getClave());
            ps.setInt(4, usuario.getId_caja());
            ps.setInt(5, usuario.getId_rol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List ListaUsuarios(String valor) {
        List<Usuarios> listaUsuarios = new ArrayList();
        sql = "SELECT * FROM usuarios u INNER JOIN cajas cj ON u.id_caja = cj.id_caja INNER JOIN roles r on u.id_rol = r.id_rol ORDER BY u.estado ASC";
        String buccar = "SELECT * FROM usuarios WHERE usuario LIKE '%" + valor + "%' OR nombre LIKE'%" + valor + "%'";
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
                Usuarios usu = new Usuarios();
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setId_caja(rs.getInt("id_caja"));
                usu.setNombre_caja(rs.getString("nombre_caja"));
                usu.setId_rol(rs.getInt("id_rol"));
                usu.setNombre_rol(rs.getString("nombre_rol"));
                usu.setEstado(rs.getString("estado"));
                listaUsuarios.add(usu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaUsuarios;
    }

    public boolean ModificarUsuario(Usuarios usuario) {
        sql = "UPDATE usuarios SET usuario=?, nombre=?, id_caja=?, id_rol=? WHERE id_usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setInt(3, usuario.getId_caja());
            ps.setInt(4, usuario.getId_rol());
            ps.setInt(5, usuario.getId_usuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean accion(String estado, int id_usuario) {
        sql = "UPDATE usuarios SET estado=? WHERE id_usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean DatosUsuarioLogiado(int id, String nombre) {
        sql = "SELECT * FROM `usuarios` WHERE id_usuario=? AND nombre=?";
        Usuarios usuLogiado = new Usuarios();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuLogiado.setId_usuario(rs.getInt("id_usuario"));
                usuLogiado.setUsuario(rs.getString("usuario"));
                usuLogiado.setNombre(rs.getString("nombre"));
                usuLogiado.setClave(rs.getString("clave"));
                usuLogiado.setId_caja(rs.getInt("id_caja"));
                usuLogiado.setId_rol(rs.getInt("id_rol"));
                usuLogiado.setEstado(rs.getString("estado"));
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
