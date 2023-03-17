package Models;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class VentasDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    Configuracion conf = new Configuracion();
    ConfiguracionDAO confDAO = new ConfiguracionDAO();
    Productos prod = new Productos();
    ProductosDAO proDAO =new ProductosDAO();
    
    public List ListaVentas(String valor) {
        List<Ventas> listaVentas = new ArrayList();
        sql = "SELECT v.id_venta, p.descripcion, dv.cantidad, v.total, c.nombre_cliente, c.telefono, u.nombre, cj.nombre_caja, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN productos p ON dv.id_producto = p.id_producto INNER JOIN usuarios u ON dv.id_usuario = u.id_usuario INNER JOIN ventas v ON dv.id_venta = v.id_venta INNER JOIN cajas cj ON u.id_caja = cj.id_caja ORDER BY v.id_venta DESC";
        String buccar = "SELECT v.id_venta, p.descripcion, dv.cantidad, v.total, c.nombre_cliente, c.telefono, u.nombre, cj.nombre_caja, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN productos p ON dv.id_producto = p.id_producto INNER JOIN usuarios u ON dv.id_usuario = u.id_usuario INNER JOIN ventas v ON dv.id_venta = v.id_venta INNER JOIN cajas cj ON u.id_caja = cj.id_caja WHERE p.descripcion LIKE '%" + valor + "%' OR c.nombre_cliente LIKE '%" + valor + "%' OR u.nombre LIKE '%" + valor + "%' OR v.fecha LIKE'%" + valor + "%'";
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
                Ventas v = new Ventas();
                v.setId_venta(rs.getInt("id_venta"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setTotal(Double.parseDouble(rs.getString("total")));
                v.setNombre_cliente(rs.getString("nombre_cliente"));
                v.setTelefono(rs.getString("telefono"));
                v.setNombre(rs.getString("nombre"));
                v.setNombre_caja(rs.getString("nombre_caja"));
                v.setFecha(rs.getString("fecha"));
                listaVentas.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaVentas;
    }
    
    public void consultarReporteVentas(int idVenta) {
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
            File salida = new File(url + File.separator + "Venta_" + idVenta + ".pdf");
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
            sql = "SELECT c.nombre_cliente, c.telefono, c.direccion, v.total, u.nombre, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN ventas v ON dv.id_venta = v.id_venta INNER JOIN usuarios u ON dv.id_usuario = u.id_usuario WHERE v.id_venta =" + idVenta;

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
            empresa.addCell("Venta Nro : " + idVenta + "\nVendedor: " + nombreUsuario + "\nFecha: " + fecha);
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
            sql = "SELECT c.nombre_cliente, c.telefono, c.direccion, v.total, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN ventas v ON dv.id_venta = v.id_venta WHERE v.id_venta =" + idVenta;

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
            sql = "SELECT dv.cantidad, p.descripcion, p.precio_venta, dv.subtotal, v.fecha FROM detalle_venta dv INNER JOIN productos p ON dv.id_producto = p.id_producto INNER JOIN ventas v ON dv.id_venta = v.id_venta WHERE v.id_venta =" + idVenta;

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
            File salida = new File(url + File.separator + "Venta_" + idVenta + ".pdf");
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
            sql = "SELECT c.nombre_cliente, c.telefono, c.direccion, v.total, u.nombre, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN ventas v ON dv.id_venta = v.id_venta INNER JOIN usuarios u ON dv.id_usuario = u.id_usuario WHERE v.id_venta =" + idVenta;

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
            empresa.addCell("Venta Nro : " + idVenta + "\nVendedor: " + nombreUsuario + "\nFecha: " + fecha);
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
            sql = "SELECT c.nombre_cliente, c.telefono, c.direccion, v.total, v.fecha FROM detalle_venta dv INNER JOIN clientes c ON dv.id_cliente = c.id_cliente INNER JOIN ventas v ON dv.id_venta = v.id_venta WHERE v.id_venta =" + idVenta;

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
            sql = "SELECT dv.cantidad, p.descripcion, p.precio_venta, dv.subtotal, v.fecha FROM detalle_venta dv INNER JOIN productos p ON dv.id_producto = p.id_producto INNER JOIN ventas v ON dv.id_venta = v.id_venta WHERE v.id_venta =" + idVenta;

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
