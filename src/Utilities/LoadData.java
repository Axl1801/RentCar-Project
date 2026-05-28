package Utilities;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoadData {
	 public static void refreshTable(JTable table, DefaultTableModel modelo, ArrayList<? extends FilaTabla> lista) {
		 modelo.setRowCount(0);
		 for (FilaTabla obj : lista) {
			 modelo.addRow(obj.toFila());
		 }
		 table.revalidate();
		 table.repaint();
    }
}
