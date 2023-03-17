/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Productos;
import Models.ProductosDAO;
import Models.Tables;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author godie
 */
public class Print extends javax.swing.JFrame {

    Productos pro = new Productos();
    ProductosDAO proDao = new ProductosDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public Print(int id_compra) {
        initComponents(); 
        this.setLocationRelativeTo(null);
        lblFolio.setText(""+id_compra);
        listarCompras(id_compra);
        CalcularCompra();
    }

    public void listarCompras(int id_compra) {
        List<Productos> listaproductos = proDao.ListaDetalleCompra(id_compra);
        modelo = (DefaultTableModel) tblPrintCompra.getModel();
        Object[] obj = new Object[4];
        for (int i = 0; i < listaproductos.size(); i++) {
            obj[0] = listaproductos.get(i).getCantidad();
            obj[1] = listaproductos.get(i).getDescripcion();
            obj[2] = listaproductos.get(i).getPrecio_compra();
            obj[3] = listaproductos.get(i).getPrecio_venta();
            modelo.addRow(obj);
        }
        tblPrintCompra.setModel(modelo);
        JTableHeader header = tblPrintCompra.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.GREEN);
        header.setForeground(Color.BLACK);
    }
    
    private void CalcularCompra() {
        Double total = 0.0;
        int numFilas = tblPrintCompra.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            total = total + Double.parseDouble(String.valueOf(tblPrintCompra.getValueAt(i, 3)));
        }
        lblTotal.setText("" + total);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrint = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrintCompra = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrint.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPrintCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant", "Descripcion", "Precio", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(tblPrintCompra);
        if (tblPrintCompra.getColumnModel().getColumnCount() > 0) {
            tblPrintCompra.getColumnModel().getColumn(0).setMinWidth(40);
            tblPrintCompra.getColumnModel().getColumn(0).setMaxWidth(15);
            tblPrintCompra.getColumnModel().getColumn(1).setMinWidth(250);
        }

        jPanelPrint.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 520, 290));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Datos del Proveedor");
        jPanelPrint.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Nit:");
        jPanelPrint.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 210, 25));

        jTextField3.setBackground(new java.awt.Color(204, 204, 255));
        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Folio");
        jPanelPrint.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 210, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Desarrollo de Software Java");
        jPanelPrint.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanelPrint.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Dirección:");
        jPanelPrint.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setText("Total a Pagar:");
        jPanelPrint.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        lblTotal.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jPanelPrint.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, -1, -1));

        lblFolio.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblFolio.setText("1");
        jPanelPrint.add(lblFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        getContentPane().add(jPanelPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 560, 540));

        jButton1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Toolkit tk = jPanelPrint.getToolkit();
        PrintJob pj = tk.getPrintJob(this, null, null);
        Graphics g = pj.getGraphics();
        jPanelPrint.print(g);
        g.dispose();
        pj.end();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblPrintCompra;
    // End of variables declaration//GEN-END:variables
}
