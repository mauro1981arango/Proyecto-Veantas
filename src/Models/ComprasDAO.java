package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ComprasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public List ListaCompras(String valor) {
        List<Compras> listaCompras = new ArrayList();
        sql = "SELECT c.*, p.proveedor, u.nombre FROM compras c INNER JOIN proveedor p ON c.id_proveedor = p.id INNER JOIN usuarios u ON c.id_usuario = u.id_usuario ORDER BY c.id_compra DESC";
        String buccar = "SELECT c.*, p.proveedor, u.nombre FROM compras c INNER JOIN proveedor p ON c.id_proveedor = p.id INNER JOIN usuarios u ON c.id_usuario WHERE p.proveedor LIKE '%" + valor + "%' OR u.nombre LIKE'%" + valor + "%' OR c.fecha LIKE'%" + valor + "%'";
        try {
            con = cn.getConexion();
            if (valor.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
                //rs = ps.executeQuery();
            } else {
                ps = con.prepareStatement(buccar);

            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Compras c = new Compras();
                c.setId_compra(rs.getInt("id_compra"));
                c.setId_proveedor(rs.getInt("id_proveedor"));
                c.setId_usuario(rs.getInt("id_usuario"));
                c.setTotal(Double.parseDouble(rs.getString("total")));
                c.setFecha(rs.getString("fecha"));
                c.setProveedor(rs.getString("proveedor"));
                c.setNombre(rs.getString("nombre"));
                listaCompras.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaCompras;
    }

    public String fechaCompra() {
        String fecchaCompra = "";
        Compras compra = new Compras();
        sql = "SELECT fecha FROM compras WHERE id_compra =?";
        try {
            //Utilizamos la Conexion a la base de datos.
            con = cn.getConexion();
            //Hacemos uso del PreparedStatement con su variable ps.
            ps = con.prepareStatement(sql);
            // Ejecutamos la consulta guardamos el resultado en la variable rs
            rs = ps.executeQuery();
            // Usamos un if
            if (rs.next()) {
                // Se agrega el id en la variable rs.
                fecchaCompra = rs.getString("fecha");
            }
        } catch (SQLException e) {
            // Se imprime la excepcion.
            System.err.println(e.toString());
        }
        return fecchaCompra;
    }

}
