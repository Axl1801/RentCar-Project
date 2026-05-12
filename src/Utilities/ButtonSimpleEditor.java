package Utilities;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ButtonSimpleEditor extends DefaultCellEditor {

	private ButtonRounded button;
	private String accion;
	private JTable table;

	// GUARDAR FILA ACTUAL
	private int currentRow;

	public ButtonSimpleEditor(JCheckBox checkBox,Icon icon,JTable table,String accion) {
		super(checkBox);

		this.table = table;
		this.accion = accion;

		button = new ButtonRounded("", 15, 3);
		button.setIcon(icon);

		button.addActionListener(e -> {

			SwingUtilities.invokeLater(() -> {

				int modelRow =
						table.convertRowIndexToModel(currentRow);

				String sucursal =
						table.getModel().getValueAt(modelRow, 0).toString();

				if (accion.equals("Seleccionar")) {

					System.out.println(
							"Sucursal seleccionada: "+ sucursal);

				} else if (accion.equals("Eliminar")) {

					((DefaultTableModel)
							table.getModel()).removeRow(modelRow);
				}

				fireEditingStopped();
			});
		});
	}

	@Override
	public Component getTableCellEditorComponent(
			JTable table,
			Object value,
			boolean isSelected,
			int row,
			int column) {

		// GUARDAMOS LA FILA VISUAL
		currentRow = row;

		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return "";
	}
}
