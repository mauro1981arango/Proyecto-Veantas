package Models;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CambiarColorCeldasTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (row % 2 == 0) {
            setBackground(Color.WHITE); // Color fondo de celda
            setForeground(Color.BLACK); // Color de la letra
        } else {
            setBackground(Color.lightGray); // Color fondo de celda
            setForeground(Color.BLACK); // Color de la letra
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
