package Utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Controllers.ClientController;
import Controllers.HomeController;
import Controllers.PDFController;
import Controllers.RentController;
import Controllers.VehicleController;

public class ButtonRoundedEditor extends DefaultCellEditor {
	private ButtonRounded button;
	private JPopupMenu popupMenu;
	private int currentRow;
	private PanelRounded panelMenu;
	private ClientController cc = new ClientController();
	private VehicleController vc = new VehicleController();
	private RentController rc = new RentController();
	private PDFController pc = new PDFController();

	// Ahora pedimos 4 iconos: El principal (los 3 puntitos) y los 3 del submenú
	public ButtonRoundedEditor(JCheckBox checkBox, 
			Icon iconPrincipal, Icon iconVer, Icon iconEditar, Icon iconEliminar, Icon iconDescargar, 
			String accion,JTable table,ClientController cc, VehicleController vc, RentController rc) {
		
		super(checkBox);
		this.cc = cc;
		this.vc = vc;
		this.rc = rc;
		
		button = new ButtonRounded("", 15, 3);
		button.setIcon(iconPrincipal);

		// POPUP invisible
		popupMenu = new JPopupMenu();
		popupMenu.setOpaque(false); // Fondo transparente
		popupMenu.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes nativos
		popupMenu.setBackground(new Color(0, 0, 0, 0)); // Color invisible

		//Panel redondeado para que se vea horizontal y asignamos un flowLayout para que muestre en orden las opcioens
		panelMenu = new PanelRounded(20, true, true, true, true);
		panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panelMenu.setBackground(Color.decode("#FFFFFF"));
		panelMenu.setBorder(BorderFactory.createLineBorder(Color.decode("#EAEAEA"), 1));

		//Crear botones de los iconos
		JButton btnVer = crearBotonIcono(iconVer);
		JButton btnEditar = crearBotonIcono(iconEditar);
		JButton btnEliminar = crearBotonIcono(iconEliminar);
		JButton btnDescargar = crearBotonIcono(iconDescargar);

		//ActionListeners temporales
		btnVer.addActionListener(e -> {
			popupMenu.setVisible(false); // Oculta el menú
			fireEditingStopped(); //Evita la edicion de la zelda
			SwingUtilities.invokeLater(()->{
				int modelRow = table.convertRowIndexToModel(currentRow);
				int idRow = Integer.parseInt(table.getModel().getValueAt(modelRow, 0).toString().replaceAll("[^0-9]", ""));
				if(accion.equals("Clientes")) {
					cc.showHistorial(idRow);
				}
				else if(accion.equals("Vehiculos")) {
					vc.showHistorial();
				}
				else if(accion.equals("Rentas")) {
					rc.showHistorial();
				}

			});
		});

		btnEditar.addActionListener(e -> {
			popupMenu.setVisible(false);
			fireEditingStopped();
			int modelRow = table.convertRowIndexToModel(currentRow);
			int idRow = Integer.parseInt(table.getModel().getValueAt(modelRow, 0).toString().replaceAll("[^0-9]", ""));
			SwingUtilities.invokeLater(()->{
				if(accion.equals("Clientes")) {
					String nombre = table.getModel().getValueAt(modelRow, 1).toString();
				    String correo = table.getModel().getValueAt(modelRow, 2).toString();
				    String telefono = table.getModel().getValueAt(modelRow, 3).toString();
				    
					cc.showEdit(idRow,nombre,correo,telefono);
				}
				else if(accion.equals("Vehiculos")) {
					vc.EditVehicleView();
				}
				else if(accion.equals("Rentas")) {
					rc.editRent();
				}

			});
		});

		btnEliminar.addActionListener(e -> {
			popupMenu.setVisible(false);
			if (currentRow != -1) {

				int modelRow = table.convertRowIndexToModel(currentRow);
				int idRow = Integer.parseInt(table.getModel().getValueAt(modelRow, 0).toString().replaceAll("[^0-9]", ""));
				cc.Eliminar_cliente(idRow);
				((DefaultTableModel) table.getModel()).removeRow(modelRow);
			}

			fireEditingStopped();
		});

		btnDescargar.addActionListener(e -> {
			popupMenu.setVisible(false);
			fireEditingStopped();
			int modelRow = table.convertRowIndexToModel(currentRow);
			int idRow = Integer.parseInt(table.getModel().getValueAt(modelRow, 0).toString().replaceAll("[^0-9]", ""));
			pc.imprimirExpedienteCliente(idRow);
			JOptionPane.showMessageDialog(null, "PDF descargado Exitosamente: ");
			JOptionPane.showMessageDialog(null, "No se pudo descargar el PDF");
		});

		// Agregamos los botones al panel redondeado, y el panel al popup
		panelMenu.add(btnVer);
		panelMenu.add(btnEditar);
		panelMenu.add(btnEliminar);
		panelMenu.add(btnDescargar);
		popupMenu.add(panelMenu);

		//ActionListener para mostrar el submenu 
		button.addActionListener(e -> {
			//Posicionamiento del lado izq del boton principal
			int x = -panelMenu.getPreferredSize().width - 5;
			int y = (button.getHeight() - panelMenu.getPreferredSize().height) / 2;
			//Mostramos el menu popUp
			popupMenu.show(button, x, y);
		});
	}

	//botones que solo muestran el icono
	private JButton crearBotonIcono(Icon icon) {
		JButton btn = new JButton(icon);
		btn.setContentAreaFilled(false); // Sin fondo
		btn.setBorderPainted(false); // Sin borde
		btn.setFocusPainted(false); // Sin línea de focus
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Manita al pasar el ratón
		return btn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		this.currentRow = row;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return "";
	}
}