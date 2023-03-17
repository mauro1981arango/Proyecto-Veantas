package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public boolean RegistrarCliente(Clientes cli) {
        sql = "INSERT INTO clientes (nombre_cliente, telefono, direccion) VALUES (?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre_cliente());
            ps.setString(2, cli.getTelefono());
            ps.setString(3, cli.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List ListaClientes(String valor) {
        List<Clientes> listaClientes = new ArrayList();
        sql = "SELECT * FROM clientes ORDER BY estado ASC";
        String buccar = "SELECT * FROM clientes WHERE nombre_cliente LIKE '%" + valor + "%' OR telefono LIKE'%" + valor + "%'";
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
                Clientes cli = new Clientes();
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombre_cliente(rs.getString("nombre_cliente"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setEstado(rs.getString("estado"));
                listaClientes.add(cli);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaClientes;
    }

    public boolean ModificarCliente(Clientes cliente) {
        sql = "UPDATE clientes SET nombre_cliente=?, telefono=?, direccion=? WHERE id_cliente=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre_cliente());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getId_cliente());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean accion(String estado, int id_cliente) {
        sql = "UPDATE clientes SET estado=? WHERE id_cliente=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_cliente);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

}
