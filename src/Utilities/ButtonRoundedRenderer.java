package Utilities;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRoundedRenderer implements TableCellRenderer{

	private ButtonRounded button;

    public ButtonRoundedRenderer(Icon icon) {
        // Usamos tu clase: Texto vacío, radio de 15, y ver=1 (Azul)
        button = new ButtonRounded("", 15, 3); 
        button.setIcon(icon); // Le ponemos el icono
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
}
