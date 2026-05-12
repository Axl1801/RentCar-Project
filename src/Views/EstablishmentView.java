package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ui.HorizontalAlignment;

import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.ButtonSimpleEditor;
import Utilities.ComboBoxRounded;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class EstablishmentView {
	public EstablishmentView(){

	}

	public JPanel showEstablishment() {
		JPanel EstablishmentPanel = new JPanel();
		EstablishmentPanel.setOpaque(true);
		EstablishmentPanel.setBackground(Color.decode("#EAEAEA"));
		EstablishmentPanel.setVisible(true);
		EstablishmentPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// Panel total de vehiculos
		JPanel mapPanel = new JPanel();
		mapPanel.setOpaque(true);
		mapPanel.setVisible(true);
		mapPanel.setLayout(new BorderLayout());
		mapPanel.setBackground(Color.decode("#FFFFFF"));

		ImageIcon imagenMap = new ImageIcon(
				getClass().getResource("/Imagenes-sprites/mapa.png")
				);

		//Label contenedor de la imagen con metodo para escalarla
		JLabel mapContenedor = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imagenMap.getImage(), 10, 10, getWidth(), getHeight(), this);
			}
		};

		mapPanel.add(mapContenedor, BorderLayout.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 4;
		gbc.weighty = 3;
		gbc.gridwidth = 4;
		gbc.gridheight = 3;
		gbc.insets = new Insets(0, 50, 0, 50); // 
		gbc.fill = GridBagConstraints.BOTH;
		EstablishmentPanel.add(mapPanel,gbc);

		//Icono y escalador del boton añadir
		ImageIcon ubicacionIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/ubicacion.png"));
		Image ubicacionEscalar = ubicacionIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon ubicacionEscalada = new ImageIcon(ubicacionEscalar);

		//Boton Añadir
		ButtonRounded seleccionarUbi = new ButtonRounded("Seleccionar Ubicacion",10,1);
		seleccionarUbi.setOpaque(false);
		seleccionarUbi.setBackground(Color.decode("#FFFFFF"));
		seleccionarUbi.setForeground(Color.white);
		seleccionarUbi.setFont(new Font("Poppins",Font.PLAIN,20));
		seleccionarUbi.setHorizontalTextPosition(JLabel.LEFT);
		seleccionarUbi.addActionListener(e->{
			seleccionarUbi();
		});

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 0, 0, 0); // 
		gbc.fill = GridBagConstraints.NONE;
		EstablishmentPanel.add(seleccionarUbi,gbc);

		//Icono y escalador del boton añadir
		ImageIcon añadirIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/agregar_white.png"));
		Image añadirEscalar = añadirIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon añadirEscalada = new ImageIcon(añadirEscalar);

		//Boton Añadir
		ButtonRounded añadirUbi = new ButtonRounded("Añadir Locación",10,1);
		añadirUbi.setOpaque(false);
		añadirUbi.setBackground(Color.decode("#FFFFFF"));
		añadirUbi.setForeground(Color.white);
		añadirUbi.setFont(new Font("Poppins",Font.PLAIN,20));
		añadirUbi.setHorizontalTextPosition(JLabel.LEFT);
		añadirUbi.addActionListener(e->{
			addLocacion();
		});
		añadirUbi.setIcon(añadirEscalada);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 0, 0, 0); // 
		gbc.fill = GridBagConstraints.NONE;
		EstablishmentPanel.add(añadirUbi,gbc);

		return EstablishmentPanel;
	}

	public void seleccionarUbi() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);

		PanelRounded panelCat = new PanelRounded(10,true,true,true,true);
		panelCat.setVisible(true);
		panelCat.setLayout(new BorderLayout());
		panelCat.setBackground(Color.decode("#FFFFFF"));
		panelCat.setBounds(635,365,650,500);
		ventana.add(panelCat);

		PanelRounded panelSupCat = new PanelRounded(10,true,true,false,false);
		panelSupCat.setVisible(true);
		panelSupCat.setLayout(new BorderLayout());
		panelSupCat.setBackground(Color.decode("#000D56"));
		panelSupCat.setPreferredSize(new Dimension(0,120));
		panelCat.add(panelSupCat,BorderLayout.NORTH);

		JLabel tituloCat = new JLabel("AGREGAR CATEGORIA");
		tituloCat.setBorder(new EmptyBorder(0, 0, 0, 30));
		tituloCat.setForeground(Color.white);
		tituloCat.setOpaque(false);
		tituloCat.setHorizontalAlignment(JLabel.CENTER);
		tituloCat.setFont(new Font("Poppins",Font.BOLD,30));
		tituloCat.setHorizontalTextPosition(JLabel.CENTER);
		panelSupCat.add(tituloCat,BorderLayout.CENTER);

		JButton regresar = new JButton();
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		URL url = getClass().getResource("/iconos/adicionales/anterior.png");
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSupCat.add(regresar,BorderLayout.WEST);
		regresar.addActionListener(e->{
			ventana.dispose();
		});

		PanelRounded contCat = new PanelRounded(10,true,true,true,true);
		contCat.setBackground(Color.white);
		contCat.setLayout(new BorderLayout());
		contCat.setVisible(true);
		panelCat.add(contCat,BorderLayout.CENTER);

		PanelRounded barraBusqueda = new PanelRounded(10,true,true,true,true);
		barraBusqueda.setBackground(Color.white);
		barraBusqueda.setLayout(new BorderLayout());
		barraBusqueda.setVisible(true);
		contCat.add(barraBusqueda,BorderLayout.NORTH);

		//Icono de la barra de busqueda
		ImageIcon busquedaIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/buscar.png"));
		//Escalamos la imagen y la asignamos a un ImageIcon
		Image imagenEscalada = busquedaIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

		JLabel labelIcono = new JLabel(iconoEscalado);

		barraBusqueda.add(labelIcono, BorderLayout.WEST);
		//Creacion del campo de texto para la barra de busqueda de clientes
		TextFieldRounded busqueda = new TextFieldRounded(10, 10,false);
		busqueda.setFont(new Font("Poppins", Font.PLAIN, 15));
		busqueda.setForeground(Color.decode("#8B8B8B"));
		busqueda.setOpaque(false);
		busqueda.setText("Buscar Cliente");
		barraBusqueda.add(busqueda,BorderLayout.CENTER);

		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"Sucursal","Seleccionar","Eliminar"};
		//Creacion de una matriz para los datos de una tabla 
		Object [][] table_content = {
				{"8 de octubre", null, null},
				{"Camino Real", null,null},
				{"Chametla", null, null},
				{"Malecón", null, null},
		};

		//Creacion de modelo de tabla para poder filtrar y evitar que el usuario edite las columnas diferentes del boton
		DefaultTableModel modeloClientes = new DefaultTableModel(table_content,table_head) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 1 || column == 2; 
			}
		};
		//Creacion de la tabla para usuario con el modelo y agregamos el filtrador
		JTable clientes_table = new JTable(modeloClientes);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloClientes);
		clientes_table.setRowSorter(sorter);

		/*Agregamos el metodo para que el campo de texto busqueda filtre en tiempo real la tabla 
				mediante un DocumentListener*/
		busqueda.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) { buscar(); }
			@Override
			public void removeUpdate(DocumentEvent e) { buscar(); }
			@Override
			public void changedUpdate(DocumentEvent e) { buscar(); }

			private void buscar() {
				String textoBusqueda = busqueda.getText();

				// Si la barra está vacía o tiene el texto por defecto, mostramos toda la tabla
				if (textoBusqueda.trim().length() == 0 || textoBusqueda.equals("Buscar Cliente")) {
					sorter.setRowFilter(null);
				} else {
					// El "(?i)" sirve para que la búsqueda ignore mayúsculas y minúsculas
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda));
				}
			}
		});

		//Agregamos un Focus listener para que al ingresar texto se desaparezca el texto por defecto como un placeHolder
		busqueda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (busqueda.getText().equals("Buscar Cliente")) {
					busqueda.setText(""); // Vaciar la caja
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (busqueda.getText().isEmpty()) {
					busqueda.setText("Buscar Sucursal"); // Restaurar el mensaje
				}
			}
		});

		//creacion y customización del scroll pane
		JScrollPane scrollPane = new JScrollPane(clientes_table);
		scrollPane.getVerticalScrollBar().setUI(new ScrollBarCustom());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		ImageIcon iconEliminar = new ImageIcon(
				getClass().getResource("/iconos/acciones/eliminar.png"));

		ImageIcon iconSeleccionar = new ImageIcon(
				getClass().getResource("/iconos/acciones/seleccionar.png"));

		clientes_table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRoundedRenderer(iconEliminar));
		clientes_table.getColumnModel().getColumn(2).setCellEditor(new ButtonSimpleEditor(new JCheckBox(),iconEliminar,clientes_table,"Eliminar"));

		clientes_table.getColumnModel().getColumn(1).setCellRenderer( new ButtonRoundedRenderer(iconSeleccionar));

		clientes_table.getColumnModel().getColumn(1).setCellEditor(new ButtonSimpleEditor(new JCheckBox(),iconSeleccionar,clientes_table,"Seleccionar"));

		clientes_table.setRowHeight(40);
		clientes_table.getColumnModel().getColumn(2).setPreferredWidth(60);
		clientes_table.setBackground(Color.decode("#D9D9D9"));
		clientes_table.setShowVerticalLines(false);
		clientes_table.setShowHorizontalLines(true);
		contCat.add(scrollPane, BorderLayout.CENTER);

		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		clientes_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		JTableHeader header = clientes_table.getTableHeader();
		header.setBackground(Color.decode("#AFAFAF"));
		header.setFont(new Font("Poppins", Font.BOLD, 18));
		DefaultTableCellRenderer headerRenderer =(DefaultTableCellRenderer) header.getDefaultRenderer();
		headerRenderer.setOpaque(true);
		headerRenderer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setOpaque(true);

		ventana.setVisible(true);
	}

	public void addLocacion() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120));
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		// Panel sobre el cual se trabajara
		PanelRounded addLocation = new PanelRounded(20, true, true, true, true);
		addLocation.setLayout(null);
		addLocation.setSize(700, 750);
		addLocation.setLocation(610, 140);
		addLocation.setBackground(Color.white);
		addLocation.setOpaque(false);
		ventana.add(addLocation);
		// Label superior con nombre de pestaña
		LabelRounded tituloAñadirLoc = new LabelRounded("Añadir Locacion", 20, Color.decode("#000D56"));
		tituloAñadirLoc.setOpaque(false);
		tituloAñadirLoc.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloAñadirLoc.setForeground(Color.WHITE);
		tituloAñadirLoc.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadirLoc.setFont(new Font("Poppins", Font.BOLD, 25));
		tituloAñadirLoc.setSize(700, 100);
		tituloAñadirLoc.setLocation(0, 0);
		addLocation.add(tituloAñadirLoc);

		// Label nombre y su respectivo campo de texto
		JLabel colonia = new JLabel("Colonia");
		colonia.setOpaque(false);
		colonia.setForeground(Color.black);
		colonia.setHorizontalAlignment(JLabel.LEFT);
		colonia.setFont(new Font("Poppins", Font.PLAIN, 15));
		colonia.setSize(70, 25);
		colonia.setLocation(210, 130);
		addLocation.add(colonia);

		TextFieldRounded campoCol = new TextFieldRounded(20, 10, true);
		campoCol.setFont(new Font("Poppins", Font.BOLD, 15));
		campoCol.setForeground(Color.black);
		campoCol.setOpaque(false);
		campoCol.setSize(280, 40);
		campoCol.setLocation(210, 160);
		campoCol.setText("---");
		campoCol.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoCol.getText().equals("---")) {
					campoCol.setText(""); // Vaciar la caja
					campoCol.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoCol.getText().isEmpty()) {
					campoCol.setText("---");// Restaurar el mensaje
					campoCol.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		addLocation.add(campoCol);

		// Label telefono y su respectivo campo de texto
		JLabel calles = new JLabel("Calles");
		calles.setOpaque(false);
		calles.setForeground(Color.black);
		calles.setHorizontalAlignment(JLabel.LEFT);
		calles.setFont(new Font("Poppins", Font.PLAIN, 15));
		calles.setSize(70, 25);
		calles.setLocation(210, 230);
		addLocation.add(calles);

		TextFieldRounded campoCalle = new TextFieldRounded(20, 10, true);
		campoCalle.setFont(new Font("Poppins", Font.BOLD, 15));
		campoCalle.setForeground(Color.black);
		campoCalle.setOpaque(false);
		campoCalle.setSize(280, 40);
		campoCalle.setLocation(210, 260);
		campoCalle.setText("---");
		campoCalle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoCol.getText().equals("---")) {
					campoCol.setText(""); // Vaciar la caja
					campoCol.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoCol.getText().isEmpty()) {
					campoCol.setText("---");// Restaurar el mensaje
					campoCol.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		addLocation.add(campoCalle);

		// Label telefono y su respectivo campo de texto
		JLabel codigoPostal = new JLabel("Codigo Postal");
		codigoPostal.setOpaque(false);
		codigoPostal.setForeground(Color.black);
		codigoPostal.setHorizontalAlignment(JLabel.LEFT);
		codigoPostal.setFont(new Font("Poppins", Font.PLAIN, 15));
		codigoPostal.setSize(70, 25);
		codigoPostal.setLocation(210, 330);
		addLocation.add(codigoPostal);

		TextFieldRounded campoCP = new TextFieldRounded(20, 10, true);
		campoCP.setFont(new Font("Poppins", Font.BOLD, 15));
		campoCP.setForeground(Color.black);
		campoCP.setOpaque(false);
		campoCP.setSize(280, 40);
		campoCP.setLocation(210, 360);
		campoCP.setText("---");
		campoCP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoCP.getText().equals("---")) {
					campoCP.setText(""); // Vaciar la caja
					campoCP.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoCP.getText().isEmpty()) {
					campoCP.setText("---");// Restaurar el mensaje
					campoCP.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		addLocation.add(campoCP);

		JLabel tituloSuc = new JLabel("Nombre de Sucursal");
		tituloSuc.setOpaque(false);
		tituloSuc.setForeground(Color.black);
		tituloSuc.setHorizontalAlignment(JLabel.LEFT);
		tituloSuc.setFont(new Font("Poppins", Font.PLAIN, 15));
		tituloSuc.setSize(70, 25);
		tituloSuc.setLocation(210, 430);
		addLocation.add(tituloSuc);

		TextFieldRounded campoSuc = new TextFieldRounded(20, 10, true);
		campoSuc.setFont(new Font("Poppins", Font.BOLD, 15));
		campoSuc.setForeground(Color.black);
		campoSuc.setOpaque(false);
		campoSuc.setSize(280, 40);
		campoSuc.setLocation(210, 460);
		campoSuc.setText("---");
		campoSuc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoSuc.getText().equals("---")) {
					campoSuc.setText(""); // Vaciar la caja
					campoSuc.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoSuc.getText().isEmpty()) {
					campoSuc.setText("---");// Restaurar el mensaje
					campoSuc.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		addLocation.add(campoSuc);

		// Botones
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar", 10, 5);
		cancelarCliente.setSize(150, 60);
		cancelarCliente.setLocation(150, 600);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins", Font.BOLD, 20));
		cancelarCliente.addActionListener(e -> {
			ventana.dispose();

		});
		addLocation.add(cancelarCliente);

		ButtonRounded crear = new ButtonRounded("Crear", 10, 1);
		crear.setOpaque(false);
		crear.setForeground(Color.white);
		crear.setHorizontalAlignment(JLabel.CENTER);
		crear.setFont(new Font("Poppins", Font.BOLD, 20));
		crear.setHorizontalTextPosition(JLabel.RIGHT);
		crear.addActionListener(e -> {
			ventana.dispose();
		});
		crear.setSize(150, 60);
		crear.setLocation(400, 600);

		addLocation.add(crear);

		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);

	}
}
