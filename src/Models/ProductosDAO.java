package Models;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class ProductosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    Configuracion conf = new Configuracion();
    ConfiguracionDAO confDAO = new ConfiguracionDAO();
    Proveedor prov = new Proveedor();
    ProveedorDAO provDAO = new ProveedorDAO();
    Compras compra = new Compras();
    ComprasDAO compraDAO = new ComprasDAO();

    public boolean RegistrarProducto(Productos prod) {
        sql = "INSERT INTO productos (`codigo`, `descripcion`, `precio_compra`, `precio_venta`, `id_proveedor`, `id_medida`, `id_categoria`) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getDescripcion());
            ps.setDouble(3, prod.getPrecio_compra());
            ps.setDouble(4, prod.getPrecio_venta());
            ps.setInt(5, prod.getId_proveedor());
            ps.setInt(6, prod.getId_medida());
            ps.setInt(7, prod.getId_categoria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List ListaProductos(String valor) {
        List<Productos> listaProductos = new ArrayList();
        sql = "SELECT * FROM productos ORDER BY estado ASC";
        String buccar = "SELECT * FROM productos WHERE codigo LIKE '%" + valor + "%' OR descripcion LIKE '%" + valor + "%' OR estado LIKE'%" + valor + "%'";
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
                Productos pro = new Productos();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio_venta(Double.parseDouble(rs.getString("precio_venta")));
                pro.setCantidad(rs.getInt("cantidad"));
//                pro.setPrecio_compra(rs.getDouble("precio_compra"));
//                pro.setPrecio_venta(rs.getDouble("precio_venta"));
//                pro.setId_proveedor(rs.getInt("id_proveedor"));
//                pro.setId_medida(rs.getInt("id_medida"));
//                pro.setId_categoria(rs.getInt("id_categoria"));
                pro.setEstado(rs.getString("estado"));
                listaProductos.add(pro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProductos;
    }

    public boolean ModificarProducto(Productos pro) {
        sql = "UPDATE `productos` SET `codigo`=?,`descripcion`=?,`precio_compra`=?,`precio_venta`=?,`id_proveedor`=?,`id_medida`=?,`id_categoria`=? WHERE `id_producto`=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio_compra());
            ps.setDouble(4, pro.getPrecio_venta());
            ps.setInt(5, pro.getId_proveedor());
            ps.setInt(6, pro.getId_medida());
            ps.setInt(7, pro.getId_categoria());
            ps.setInt(8, pro.getId_producto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean accion(String estado, int id_producto) {
        sql = "UPDATE productos SET estado=? WHERE id_producto=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_producto);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Productos BuscarProducto(int id_producto) {
        sql = "SELECT p.*, pr.proveedor, m.id, m.medida, c.id, c.categoria FROM productos p INNER JOIN proveedor pr ON p.id_proveedor=pr.id INNER JOIN medidas m ON p.id_medida=m.id INNER JOIN categorias c ON p.id_categoria=c.id WHERE p.id_producto=?";
        Productos prod = new Productos();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setCodigo(rs.getString("codigo"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio_compra(Double.parseDouble(rs.getString("precio_compra")));
                prod.setPrecio_venta(Double.parseDouble(rs.getString("precio_venta")));
                prod.setId_proveedor(Integer.parseInt(rs.getString("id")));
                prod.setId_medida(Integer.parseInt(rs.getString("id")));
                prod.setId_categoria(Integer.parseInt(rs.getString("id")));
                prod.setProveedor(rs.getString("proveedor"));
                prod.setMedida(rs.getString("medida"));
                prod.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return prod;
    }

    public Productos BuscarCodigo(String codigo) {
        sql = "SELECT * FROM `productos` WHERE codigo=? AND estado = 'Activo'";
        Productos prod = new Productos();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setId_producto(rs.getInt("id_producto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio_compra(Double.parseDouble(rs.getString("precio_compra")));
                prod.setPrecio_venta(Double.parseDouble(rs.getString("precio_venta")));
                prod.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return prod;
    }

    public Productos BuscarId(int id_producto) {
        sql = "SELECT * FROM `productos` WHERE id_producto=?";
        Productos prod = new Productos();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return prod;
    }

    public boolean RegistrarCompra(int id_proveedor, int id_usuario, String total) {
        sql = "INSERT INTO `compras`(`id_proveedor`, `id_usuario`, `total`) VALUES (?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_proveedor);
            ps.setInt(2, id_usuario);
            ps.setString(3, total);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean RegistrarVenta(double total, int pagoCon, String devuelta, int id_usuario) {
        sql = "INSERT INTO `ventas`(`total`, `pago_con`, `devolucion`, `id_usuario`) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, total);
            ps.setInt(2, pagoCon);
            ps.setString(3, devuelta);
            ps.setInt(4, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean RegistrarDetalleCompra(int id_compra, int id_producto, double precio, int cantidad, double sub_total) {
        sql = "INSERT INTO `detalle_compra`(`id_compra`, `id_producto`, `precio`, `cantidad`, `sub_total`) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_compra);
            ps.setInt(2, id_producto);
            ps.setDouble(3, precio);
            ps.setInt(4, cantidad);
            ps.setDouble(5, sub_total);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el detalle " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean ActualizarStock(int cantidad, int id_producto) {
        sql = "UPDATE `productos` SET `cantidad`=? WHERE `id_producto`=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, id_producto);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    // Creamos un método que nos permite obtener el id(max) de la compra, y poder hacer usu de este para guardar el id de la venta en la tabla detalle.
    public int idCompra() {
        // Creamos una variable de tipo int para almacenar el id, lo inicializamos en 0.
        int id = 0;
        // Usamos la variable sql para realizar la condulta.
        sql = "SELECT MAX(id_compra) FROM `compras`";
        // Usamostry ctch 
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
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            // Se imprime la excepcion.
            System.err.println(e.toString());
        }
        return id;
    }

    public int idVenta() {
        // Creamos una variable de tipo int para almacenar el id, lo inicializamos en 0.
        int id = 0;
        // Usamos la variable sql para realizar la condulta.
        sql = "SELECT MAX(id_venta) FROM `ventas`";
        // Usamostry ctch 
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
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            // Se imprime la excepcion.
            System.err.println(e.toString());
        }
        return id;
    }

    public List ListaDetalleCompra(int id_compra) {
        List<Productos> listaProductos = new ArrayList();
        sql = "SELECT d.*, c.*, p.id_producto, p.descripcion FROM detalle_compra d INNER JOIN compras c ON D.id_compra=c.id_compra INNER JOIN productos p ON d.id_producto=p.id_producto WHERE c.id_compra=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_compra);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio_compra(Double.parseDouble(rs.getString("precio")));
                pro.setPrecio_venta(Double.parseDouble(rs.getString("sub_total")));
                listaProductos.add(pro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProductos;
    }

    public boolean RegistrarDetalleventa(int id_venta, double precio, int cantidad, double sub_total, int idProducto, int id_cliente, int id_usuario) {
        sql = "INSERT INTO `detalle_venta`(`id_venta`, `precio_unitario`, `cantidad`, `subtotal`, `id_producto`, `id_cliente`, `id_usuario`) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_venta);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.setDouble(4, sub_total);
            ps.setInt(5, idProducto);
            ps.setInt(6, id_cliente);
            ps.setInt(7, id_usuario);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el detalle de la venta " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void generarReporteCompra(int idCompra) {
        //double totalGeneral = 0.0;
        double totalGeneral = 4874647.0 / 3; // Formatea el totalGeneral a formato moneda de Colombia
        NumberFormat formatoNumero = NumberFormat.getNumberInstance();
        String fecha = "";
        String cantidad = "";
        String descripcion = "";
        String precioCompra = "";
        String subtotal = "";
        String mensaje = "";
        String vendedor = "";
        try {
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            FileOutputStream archivo;
            File salida = new File(url + File.separator + "Compra_" + idCompra + ".pdf");
            archivo = new FileOutputStream(salida);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            // Contenido de la compra
            PdfPTable empresa = new PdfPTable(3);
            // Indica que va va ocupar el 100% de la página
            empresa.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioEncabezado = new float[]{15f, 40f, 30f};
            empresa.setWidths(tamanioEncabezado);
            // Se indica la posición del texto a la izquierda
            empresa.setHorizontalAlignment(Element.ALIGN_LEFT);
            empresa.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Selecciona el logo de la empresa
            Image img = Image.getInstance(getClass().getResource("/Img/logo_pdf.png"));
            empresa.addCell(img);
            // Agregar los datos de la empresa al encabezado
            conf = confDAO.getDatosEmpresa();
            mensaje = conf.getMensaje();
            empresa.addCell("Nit: " + conf.getNit() + "\nNombre: " + conf.getNombreEmpresa() + "\nTeléfono: " + conf.getTelefono() + "\nDirección: " + conf.getDireccion());
            doc.add(empresa);
            // Toma la fecha de la compra para agregarla al encabezado del documento
            sql = "SELECT p.nit, p.proveedor, p.telefono, p.direccion, c.total, u.nombre, c.fecha FROM compras c INNER JOIN proveedor p ON c.id_proveedor=p.id INNER JOIN usuarios u ON c.id_usuario = u.id_usuario WHERE c.id_compra =" + idCompra();

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    vendedor = rs.getString("nombre");
                    fecha = rs.getString("fecha");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            // Datos del vendedor
            empresa.addCell("Nro Compra: " + idCompra() + "\nVendedor: " + vendedor + "\nFecha: " + fecha);
            doc.add(empresa);
            doc.add(Chunk.NEWLINE); // Titulo proveedor
            Paragraph tituloProveedor = new Paragraph();
            tituloProveedor.add("Datos Proveedor");
            tituloProveedor.setFont(negrita);
            tituloProveedor.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloProveedor);
            doc.add(Chunk.NEWLINE);
            // Fin encabezado
            // Datos del proveedor
            PdfPTable proveedor = new PdfPTable(4); // Agrega el número de columnas
            // Indica que va va ocupar el 100% de la página
            proveedor.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioProveedor = new float[]{18f, 35f, 16f, 31f}; // Ancho de columnas proveedor
            proveedor.setWidths(tamanioProveedor);
            // Se indica la posición del texto a la izquierda
            proveedor.setHorizontalAlignment(Element.ALIGN_LEFT);
            proveedor.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Agrega los encabezados del proveedor
            PdfPCell nitProveedor = new PdfPCell(new Phrase("Nit:", negrita));
            PdfPCell nomProveedor = new PdfPCell(new Phrase("Nombre:", negrita));
            PdfPCell telProveedor = new PdfPCell(new Phrase("Teléfono: ", negrita));
            PdfPCell dirProveedor = new PdfPCell(new Phrase("Dirección: ", negrita));
            // Quitar bordes de los encabezados del proveedor
            nitProveedor.setBorder(0);
            nomProveedor.setBorder(0);
            telProveedor.setBorder(0);
            dirProveedor.setBorder(0);
            // Se pone el background del encabezado
            nitProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            nomProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            telProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            dirProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            // Agregar los datos del proveedor a la compra
            proveedor.addCell(nitProveedor);
            proveedor.addCell(nomProveedor);
            proveedor.addCell(telProveedor);
            proveedor.addCell(dirProveedor);
            sql = "SELECT p.nit, p.proveedor, p.telefono, p.direccion, c.total, c.fecha FROM compras c INNER JOIN proveedor p ON c.id_proveedor=p.id WHERE c.id_compra =" + idCompra();

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    proveedor.addCell(rs.getString("nit"));
                    proveedor.addCell(rs.getString("proveedor"));
                    proveedor.addCell(rs.getString("telefono"));
                    proveedor.addCell(rs.getString("direccion"));
                    totalGeneral = (Double.parseDouble(rs.getString("total")));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            doc.add(proveedor);
            // Fin proveedor
            doc.add(Chunk.NEWLINE); // Titulo Compra
            Paragraph tituloCompra = new Paragraph();
            tituloCompra.add("Detalle de la Compra");
            tituloCompra.setFont(negrita);
            tituloCompra.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloCompra);
            doc.add(Chunk.NEWLINE);

            //Detalles de la compra
            PdfPTable productosCompra = new PdfPTable(4); // Agrega el número de columnas
            // Indica que va va ocupar el 100% de la página
            productosCompra.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioCompra = new float[]{8f, 63f, 15f, 15f}; // Ancho de columnas de la compra
            productosCompra.setWidths(tamanioCompra);
            // Se indica la posición del texto a la izquierda
            productosCompra.setHorizontalAlignment(Element.ALIGN_LEFT);
            productosCompra.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Encabezados de los detalles de los productos agregados a la tabla compras
            PdfPCell cantCompra = new PdfPCell(new Phrase("Cant:", negrita));
            PdfPCell desccripCompra = new PdfPCell(new Phrase("Descripción:", negrita));
            PdfPCell preCompra = new PdfPCell(new Phrase("V_Unitario: ", negrita));
            PdfPCell subTotalCompra = new PdfPCell(new Phrase("Sub Total: ", negrita));
            // Quitar bordes de los encabezados
            cantCompra.setBorder(0);
            desccripCompra.setBorder(0);
            preCompra.setBorder(0);
            subTotalCompra.setBorder(0);
            // Se pone el background del encabezado
            cantCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            desccripCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            preCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            subTotalCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            // Agrega los productos a la compra
            productosCompra.addCell(cantCompra);
            productosCompra.addCell(desccripCompra);
            productosCompra.addCell(preCompra);
            productosCompra.addCell(subTotalCompra);
            // Agregar los datos a la compra
            sql = "SELECT d.cantidad, p.descripcion, p.precio_compra, d.sub_total, c.total, c.fecha FROM detalle_compra d INNER JOIN compras c ON d.id_compra=c.id_compra INNER JOIN productos p ON d.id_producto= p.id_producto WHERE c.id_compra =" + idCompra();

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cantidad = (rs.getString("cantidad"));
                    descripcion = (rs.getString("descripcion"));
                    precioCompra = (rs.getString("precio_compra"));
                    subtotal = (rs.getString("sub_total"));
                    // Se agrega el contenido de los productos a la tabla compra
                    productosCompra.addCell(cantidad);
                    productosCompra.addCell(descripcion);
                    productosCompra.addCell(precioCompra);
                    productosCompra.addCell(subtotal);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            doc.add(productosCompra);

            doc.add(Chunk.NEWLINE); // Total a pagar de la compra
            Paragraph total = new Paragraph();
            total.add("Total a pagar: $ " + (formatoNumero.format(totalGeneral)));
            //total.add("Total a pagar: " + String.format("$%.1f ", +totalGeneral));
            total.setFont(negrita);
            total.setAlignment(Element.ALIGN_RIGHT); // alinea el total de la compra a la derecha
            doc.add(total);

            doc.add(Chunk.NEWLINE); // Mensaje de la compra
            Paragraph agradecimiento = new Paragraph();
            agradecimiento.add(mensaje);
            agradecimiento.setFont(negrita);
            agradecimiento.setAlignment(Element.ALIGN_CENTER); // alinea el mensaje en el centro
            doc.add(agradecimiento);
            doc.add(Chunk.NEWLINE);
            // Creamos un Paragraph para la firma.
            Paragraph firma = new Paragraph();
            // Agregamos este Paragraph en una nueva línea
            firma.add(Chunk.NEWLINE);
            // Título para la firma del documento.
            firma.add("Cancelación y Firma");
            // Espacio para que el vendedor ponga su firma, usamos saltos de línea \n\n.
            firma.add("\n\n--------------------------------------------------");
            // Alineamos la firma al centro del documento pdf.
            firma.setAlignment(Element.ALIGN_CENTER);
            // Lo agregamos al documento el espacio de la firma.
            doc.add(firma);
            Desktop.getDesktop().open(salida); // Abre el pdf de la compra automaticamente
            // Fin Compra
            doc.close();
            archivo.close();
        } catch (DocumentException | IOException e) {
            System.out.println("No se pudo Imprimir la Compra " + e.toString());
        }

    }

    public void consultarReporteCompra(int idCompra) {
        //double totalGeneral = 0.0;
        double totalGeneral = 4874647.0 / 3; // Formatea el totalGeneral a formato moneda de Colombia
        NumberFormat formatoNumero = NumberFormat.getNumberInstance();
        String fecha = "";
        String cantidad = "";
        String descripcion = "";
        String precioCompra = "";
        String subtotal = "";
        String mensaje = "";
        try {
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            FileOutputStream archivo;
            File salida = new File(url + File.separator + "Compra_" + idCompra() + ".pdf");
            archivo = new FileOutputStream(salida);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            // Contenido de la compra
            PdfPTable empresa = new PdfPTable(3);
            // Indica que va va ocupar el 100% de la página
            empresa.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioEncabezado = new float[]{15f, 40f, 30f};
            empresa.setWidths(tamanioEncabezado);
            // Se indica la posición del texto a la izquierda
            empresa.setHorizontalAlignment(Element.ALIGN_LEFT);
            empresa.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Selecciona el logo de la empresa
            Image img = Image.getInstance(getClass().getResource("/Img/logo_pdf.png"));
            empresa.addCell(img);
            // Agregar los datos de la empresa al encabezado
            conf = confDAO.getDatosEmpresa();
            mensaje = conf.getMensaje();
            empresa.addCell("Nit: " + conf.getNit() + "\nNombre: " + conf.getNombreEmpresa() + "\nTeléfono: " + conf.getTelefono() + "\nDirección: " + conf.getDireccion());
            doc.add(empresa);
            // Toma la fecha de la compra para agregarla al encabezado del documento
            sql = "SELECT p.nit, p.proveedor, p.telefono, p.direccion, c.total, c.fecha FROM compras c INNER JOIN proveedor p ON c.id_proveedor=p.id WHERE c.id_compra =" + idCompra;

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    fecha = rs.getString("fecha");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

            // Datos del vendedor
            empresa.addCell("Nro Compra: " + idCompra + "\nVendedor: " + "Desarrollo Java" + "\nFecha: " + fecha);
            doc.add(empresa);
            doc.add(Chunk.NEWLINE); // Titulo proveedor
            Paragraph tituloProveedor = new Paragraph();
            tituloProveedor.add("Datos Proveedor");
            tituloProveedor.setFont(negrita);
            tituloProveedor.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloProveedor);
            doc.add(Chunk.NEWLINE);
            // Fin encabezado
            // Datos del proveedor
            PdfPTable proveedor = new PdfPTable(4); // Agrega el número de columnas
            // Indica que va va ocupar el 100% de la página
            proveedor.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioProveedor = new float[]{18f, 35f, 16f, 31f}; // Ancho de columnas proveedor
            proveedor.setWidths(tamanioProveedor);
            // Se indica la posición del texto a la izquierda
            proveedor.setHorizontalAlignment(Element.ALIGN_LEFT);
            proveedor.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Agrega los encabezados del proveedor
            PdfPCell nitProveedor = new PdfPCell(new Phrase("Nit:", negrita));
            PdfPCell nomProveedor = new PdfPCell(new Phrase("Nombre:", negrita));
            PdfPCell telProveedor = new PdfPCell(new Phrase("Teléfono: ", negrita));
            PdfPCell dirProveedor = new PdfPCell(new Phrase("Dirección: ", negrita));
            // Quitar bordes de los encabezados del proveedor
            nitProveedor.setBorder(0);
            nomProveedor.setBorder(0);
            telProveedor.setBorder(0);
            dirProveedor.setBorder(0);
            // Se pone el background del encabezado
            nitProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            nomProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            telProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            dirProveedor.setBackgroundColor(BaseColor.DARK_GRAY);
            // Agregar los datos del proveedor a la compra
            proveedor.addCell(nitProveedor);
            proveedor.addCell(nomProveedor);
            proveedor.addCell(telProveedor);
            proveedor.addCell(dirProveedor);
            sql = "SELECT p.nit, p.proveedor, p.telefono, p.direccion, c.total, c.fecha FROM compras c INNER JOIN proveedor p ON c.id_proveedor=p.id WHERE c.id_compra =" + idCompra;

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    proveedor.addCell(rs.getString("nit"));
                    proveedor.addCell(rs.getString("proveedor"));
                    proveedor.addCell(rs.getString("telefono"));
                    proveedor.addCell(rs.getString("direccion"));
                    totalGeneral = (Double.parseDouble(rs.getString("total")));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            doc.add(proveedor);
            // Fin proveedor
            doc.add(Chunk.NEWLINE); // Titulo Compra
            Paragraph tituloCompra = new Paragraph();
            tituloCompra.add("Detalle de la Compra");
            tituloCompra.setFont(negrita);
            tituloCompra.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloCompra);
            doc.add(Chunk.NEWLINE);

            //Detalles de la compra
            PdfPTable productosCompra = new PdfPTable(4); // Agrega el número de columnas
            // Indica que va va ocupar el 100% de la página
            productosCompra.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioCompra = new float[]{8f, 63f, 15f, 15f}; // Ancho de columnas de la compra
            productosCompra.setWidths(tamanioCompra);
            // Se indica la posición del texto a la izquierda
            productosCompra.setHorizontalAlignment(Element.ALIGN_LEFT);
            productosCompra.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Encabezados de los detalles de los productos agregados a la tabla compras
            PdfPCell cantCompra = new PdfPCell(new Phrase("Cant:", negrita));
            PdfPCell desccripCompra = new PdfPCell(new Phrase("Descripción:", negrita));
            PdfPCell preCompra = new PdfPCell(new Phrase("V_Unitario: ", negrita));
            PdfPCell subTotalCompra = new PdfPCell(new Phrase("Sub Total: ", negrita));
            // Quitar bordes de los encabezados
            cantCompra.setBorder(0);
            desccripCompra.setBorder(0);
            preCompra.setBorder(0);
            subTotalCompra.setBorder(0);
            // Se pone el background del encabezado
            cantCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            desccripCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            preCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            subTotalCompra.setBackgroundColor(BaseColor.DARK_GRAY);
            // Agrega los productos a la compra
            productosCompra.addCell(cantCompra);
            productosCompra.addCell(desccripCompra);
            productosCompra.addCell(preCompra);
            productosCompra.addCell(subTotalCompra);
            // Agregar los datos a la compra
            sql = "SELECT d.cantidad, p.descripcion, p.precio_compra, d.sub_total, c.total, c.fecha FROM detalle_compra d INNER JOIN compras c ON d.id_compra=c.id_compra INNER JOIN productos p ON d.id_producto= p.id_producto WHERE c.id_compra =" + idCompra;

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cantidad = (rs.getString("cantidad"));
                    descripcion = (rs.getString("descripcion"));
                    precioCompra = (rs.getString("precio_compra"));
                    subtotal = (rs.getString("sub_total"));
                    // Se agrega el contenido de los productos a la tabla compra
                    productosCompra.addCell(cantidad);
                    productosCompra.addCell(descripcion);
                    productosCompra.addCell(precioCompra);
                    productosCompra.addCell(subtotal);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            doc.add(productosCompra);

            doc.add(Chunk.NEWLINE); // Total a pagar de la compra
            Paragraph total = new Paragraph();
            total.add("Total a pagar: $ " + (formatoNumero.format(totalGeneral)));
            //total.add("Total a pagar: " + String.format("$%.1f ", +totalGeneral));
            total.setFont(negrita);
            total.setAlignment(Element.ALIGN_RIGHT); // alinea el total de la compra a la derecha
            doc.add(total);

            doc.add(Chunk.NEWLINE); // Mensaje de la compra
            Paragraph agradecimiento = new Paragraph();
            agradecimiento.add(mensaje);
            agradecimiento.setFont(negrita);
            agradecimiento.setAlignment(Element.ALIGN_CENTER); // alinea el mensaje en el centro
            doc.add(agradecimiento);
            doc.add(Chunk.NEWLINE);
            // Creamos un Paragraph para la firma.
            Paragraph firma = new Paragraph();
            // Agregamos este Paragraph en una nueva línea
            firma.add(Chunk.NEWLINE);
            // Título para la firma del documento.
            firma.add("Cancelación y Firma");
            // Espacio para que el vendedor ponga su firma, usamos saltos de línea \n\n.
            firma.add("\n\n--------------------------------------------------");
            // Alineamos la firma al centro del documento pdf.
            firma.setAlignment(Element.ALIGN_CENTER);
            // Lo agregamos al documento el espacio de la firma.
            doc.add(firma);
            Desktop.getDesktop().open(salida); // Abre el pdf de la compra automaticamente
            // Fin Compra
            doc.close();
            archivo.close();
        } catch (DocumentException | IOException e) {
            System.out.println("No se pudo Imprimir la venta " + e.toString());
        }

    }
    
    public void generarReporteVentas(int idVenta) {
        //double totalGeneral = 0.0;
        double totalGeneral = 4874647.0 / 3; // Formatea el totalGeneral a formato moneda de Colombia
        NumberFormat formatoNumero = NumberFormat.getNumberInstance();
        String fecha = "";
        String cantidad = "";
        String descripcion = "";
        String precioCompra = "";
        String subtotal = "";
        String mensaje = "";
        String nombreUsuario = "";
        try {
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            FileOutputStream archivo;
            File salida = new File(url + File.separator + "Venta_" + idVenta() + ".pdf");
            archivo = new FileOutputStream(salida);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            // Contenido de la compra
            PdfPTable empresa = new PdfPTable(3);
            // Indica que va va ocupar el 100% de la página
            empresa.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioEncabezado = new float[]{15f, 40f, 30f};
            empresa.setWidths(tamanioEncabezado);
            // Se indica la posición del texto a la izquierda
            empresa.setHorizontalAlignment(Element.ALIGN_LEFT);
            empresa.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Selecciona el logo de la empresa
            Image img = Image.getInstance(getClass().getResource("/Img/logo_pdf.png"));
            empresa.addCell(img);
            // Agregar los datos de la empresa al encabezado
            conf = confDAO.getDatosEmpresa();
            mensaje = conf.getMensaje();
            empresa.addCell("Nit: " + conf.getNit() + "\nNombre: " + conf.getNombreEmpresa() + "\nTeléfono: " + conf.getTelefono() + "\nDirección: " + conf.getDireccion());
            doc.add(empresa);
            // Toma la fecha de la venta para agregarla al encabezado del documento
            sql = "SELECT c.nombre_cliente, c.telefono, c.direccion, v.total, u.nombre, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN ventas v ON dv.id_venta = v.id_venta INNER JOIN usuarios u ON dv.id_usuario = u.id_usuario WHERE v.id_venta =" + idVenta();

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    fecha = rs.getString("fecha");
                    nombreUsuario = rs.getString("nombre");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

            // Datos del vendedor
            empresa.addCell("Venta Nro : " + idVenta() + "\nVendedor: " + nombreUsuario + "\nFecha: " + fecha);
            doc.add(empresa);
            doc.add(Chunk.NEWLINE); // Titulo clente
            Paragraph tituloProveedor = new Paragraph();
            tituloProveedor.add("Datos del Cliente");
            tituloProveedor.setFont(negrita);
            tituloProveedor.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloProveedor);
            doc.add(Chunk.NEWLINE);
            // Fin encabezado
            // Datos del clente
            PdfPTable cliente = new PdfPTable(3); // Agrega el número de columnas
            // Indica que va va ocupar el 100% de la página
            cliente.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioCliente = new float[]{40f, 20f, 40f}; // Ancho de columnas cliente
            cliente.setWidths(tamanioCliente);
            // Se indica la posición del texto a la izquierda
            cliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            cliente.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Agrega los encabezados del cliente
            
            PdfPCell nomCliente = new PdfPCell(new Phrase("Nombre:", negrita));
            PdfPCell telCliente = new PdfPCell(new Phrase("Teléfono: ", negrita));
            PdfPCell dirCliente = new PdfPCell(new Phrase("Dirección: ", negrita));
            // Quitar bordes de los encabezados del cliente
            
            nomCliente.setBorder(0);
            telCliente.setBorder(0);
            dirCliente.setBorder(0);
            // Se pone el background del encabezado
            
            nomCliente.setBackgroundColor(BaseColor.DARK_GRAY);
            telCliente.setBackgroundColor(BaseColor.DARK_GRAY);
            dirCliente.setBackgroundColor(BaseColor.DARK_GRAY);
            // Agregar los datos del cliente a la compra
           
            cliente.addCell(nomCliente);
            cliente.addCell(telCliente);
            cliente.addCell(dirCliente);
            sql = "SELECT c.nombre_cliente, c.telefono, c.direccion, v.total, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN ventas v ON dv.id_venta = v.id_venta WHERE v.id_venta =" + idVenta();

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    cliente.addCell(rs.getString("nombre_cliente"));
                    cliente.addCell(rs.getString("telefono"));
                    cliente.addCell(rs.getString("direccion"));
                    totalGeneral = (Double.parseDouble(rs.getString("total")));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            doc.add(cliente);
            // Fin proveedor
            doc.add(Chunk.NEWLINE); // Titulo Venta
            Paragraph tituloVenta = new Paragraph();
            tituloVenta.add("Detalles de la Venta");
            tituloVenta.setFont(negrita);
            tituloVenta.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloVenta);
            doc.add(Chunk.NEWLINE);

            //Detalles de la venta
            PdfPTable productosVenta = new PdfPTable(4); // Agrega el número de columnas
            // Indica que va va ocupar el 100% de la página
            productosVenta.setWidthPercentage(100);
            // Indica el tamaño de los encabezados
            float[] tamanioVenta = new float[]{8f, 63f, 15f, 15f}; // Ancho de columnas de la venta
            productosVenta.setWidths(tamanioVenta);
            // Se indica la posición del texto a la izquierda
            productosVenta.setHorizontalAlignment(Element.ALIGN_LEFT);
            productosVenta.getDefaultCell().setBorder(0); // Se quita el borde a la celda del encabezado
            // Encabezados de los detalles de los productos agregados a la tabla ventas
            PdfPCell cantVenta = new PdfPCell(new Phrase("Cant:", negrita));
            PdfPCell desccripVenta = new PdfPCell(new Phrase("Descripción:", negrita));
            PdfPCell preVenta = new PdfPCell(new Phrase("V_Unitario: ", negrita));
            PdfPCell subTotalVenta = new PdfPCell(new Phrase("Sub Total: ", negrita));
            // Quitar bordes de los encabezados
            cantVenta.setBorder(0);
            desccripVenta.setBorder(0);
            preVenta.setBorder(0);
            subTotalVenta.setBorder(0);
            // Se pone el background del encabezado
            cantVenta.setBackgroundColor(BaseColor.DARK_GRAY);
            desccripVenta.setBackgroundColor(BaseColor.DARK_GRAY);
            preVenta.setBackgroundColor(BaseColor.DARK_GRAY);
            subTotalVenta.setBackgroundColor(BaseColor.DARK_GRAY);
            // Agrega los productos a la venta
            productosVenta.addCell(cantVenta);
            productosVenta.addCell(desccripVenta);
            productosVenta.addCell(preVenta);
            productosVenta.addCell(subTotalVenta);
            // Agregar los datos a la venta
            sql = "SELECT dv.cantidad, p.descripcion, p.precio_venta, dv.subtotal, v.fecha FROM detalle_venta dv INNER JOIN productos p ON dv.id_producto = p.id_producto INNER JOIN ventas v ON dv.id_venta = v.id_venta WHERE v.id_venta =" + idVenta();

            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cantidad = (rs.getString("cantidad"));
                    descripcion = (rs.getString("descripcion"));
                    precioCompra = (rs.getString("precio_venta"));
                    subtotal = (rs.getString("subtotal"));
                    // Se agrega el contenido de los productos a la tabla venta
                    productosVenta.addCell(cantidad);
                    productosVenta.addCell(descripcion);
                    productosVenta.addCell(precioCompra);
                    productosVenta.addCell(subtotal);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            doc.add(productosVenta);

            doc.add(Chunk.NEWLINE); // Total a pagar de la venta
            Paragraph total = new Paragraph();
            total.add("Total a pagar: $ " + (formatoNumero.format(totalGeneral)));
            total.setFont(negrita);
            total.setAlignment(Element.ALIGN_RIGHT); // alinea el total de la venta a la derecha
            doc.add(total);

            doc.add(Chunk.NEWLINE); // Mensaje de la venta
            Paragraph agradecimiento = new Paragraph();
            agradecimiento.add(mensaje);
            agradecimiento.setFont(negrita);
            agradecimiento.setAlignment(Element.ALIGN_CENTER); // alinea el mensaje en el centro
            doc.add(agradecimiento);
            doc.add(Chunk.NEWLINE);
            // Creamos un Paragraph para la firma.
            Paragraph firma = new Paragraph();
            // Agregamos este Paragraph en una nueva línea
            firma.add(Chunk.NEWLINE);
            // Título para la firma del documento.
            firma.add("Cancelación y Firma");
            // Espacio para que el vendedor ponga su firma, usamos saltos de línea \n\n.
            firma.add("\n\n--------------------------------------------------");
            // Alineamos la firma al centro del documento pdf.
            firma.setAlignment(Element.ALIGN_CENTER);
            // Lo agregamos al documento el espacio de la firma.
            doc.add(firma);
            Desktop.getDesktop().open(salida); // Abre el pdf de la compra automaticamente
            // Fin Compra
            doc.close();
            archivo.close();
        } catch (DocumentException | IOException e) {
            System.out.println("No se pudo Imprimir la venta " + e.toString());
        }

    }

}
