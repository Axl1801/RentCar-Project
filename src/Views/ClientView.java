package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import Controllers.ClientController;
import Models.ClientModel;
import Utilities.Alerts;
import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.ComboBoxRounded;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class ClientView {

	ClientController control;
	
	public ClientView() {

	}
	
	public void setControlador(ClientController c) {
	    this.control = c;
	}

	public JPanel showClient() {
		JPanel clientPanel = new JPanel();
		clientPanel.setOpaque(true);
		clientPanel.setBackground(Color.decode("#EAEAEA"));
		clientPanel.setVisible(true);
		clientPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// Panel total de vehiculos
		PanelRounded totalVehiculos = new PanelRounded(10, true, true, true, true);
		totalVehiculos.setOpaque(false);
		totalVehiculos.setVisible(true);
		totalVehiculos.setLayout(new BorderLayout());
		totalVehiculos.setBackground(Color.decode("#FFFFFF"));

		JLabel total_titulo = new JLabel("Total Vehiculos");//Etitqueta de total vehiculos
		total_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		total_titulo.setBackground(Color.white);
		total_titulo.setForeground(Color.BLACK);
		total_titulo.setHorizontalAlignment(JLabel.CENTER);
		total_titulo.setFont(new Font("Poppins", Font.PLAIN, 25));
		totalVehiculos.add(total_titulo, BorderLayout.NORTH);

		JLabel total = new JLabel(Integer.toString(control.numeroVehiculos_total()));//Etitqueta de total vehiculos num
		total.setBackground(Color.white);
		total.setForeground(Color.BLACK);
		total.setHorizontalAlignment(JLabel.CENTER);
		total.setFont(new Font("Poppins", Font.PLAIN, 50));
		totalVehiculos.add(total, BorderLayout.CENTER);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);
		clientPanel.add(totalVehiculos, gbc);
		clientPanel.add(totalVehiculos, gbc);

		// Panel Vehiculso Disponibles
		PanelRounded totalDisponibles = new PanelRounded(10, true, true, true, true);
		totalDisponibles.setOpaque(false);
		totalDisponibles.setVisible(true);
		totalDisponibles.setLayout(new BorderLayout());
		totalDisponibles.setBackground(Color.decode("#FFFFFF"));

		JLabel disp_titulo = new JLabel("Disponibles");//Etitqueta de Disponibles
		disp_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		disp_titulo.setBackground(Color.white);
		disp_titulo.setForeground(Color.BLACK);
		disp_titulo.setHorizontalAlignment(JLabel.CENTER);
		disp_titulo.setFont(new Font("Poppins", Font.PLAIN, 25));
		totalDisponibles.add(disp_titulo, BorderLayout.NORTH);

		JLabel disp = new JLabel(Integer.toString(control.numeroVehiculos_dispo()));//Etitqueta de total disponibles num
		disp.setBackground(Color.white);
		disp.setForeground(Color.BLACK);
		disp.setHorizontalAlignment(JLabel.CENTER);
		disp.setFont(new Font("Poppins", Font.PLAIN, 50));
		totalDisponibles.add(disp, BorderLayout.CENTER);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);
		clientPanel.add(totalDisponibles, gbc);

		// Panel Vehiculso Rentados
		PanelRounded totalRentados = new PanelRounded(10, true, true, true, true);
		totalRentados.setOpaque(false);
		totalRentados.setVisible(true);
		totalRentados.setLayout(new BorderLayout());
		totalRentados.setBackground(Color.decode("#FFFFFF"));

		JLabel rentado_titulo = new JLabel("Rentados");//Etitqueta de total rentados
		rentado_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		rentado_titulo.setBackground(Color.white);
		rentado_titulo.setForeground(Color.BLACK);
		rentado_titulo.setHorizontalAlignment(JLabel.CENTER);
		rentado_titulo.setFont(new Font("Poppins", Font.PLAIN, 25));
		totalRentados.add(rentado_titulo, BorderLayout.NORTH);

		JLabel rent = new JLabel(Integer.toString(control.numeroVehiculos_renta()));//Etitqueta de totalrentados  num
		rent.setBackground(Color.white);
		rent.setForeground(Color.BLACK);
		rent.setHorizontalAlignment(JLabel.CENTER);
		rent.setFont(new Font("Poppins", Font.PLAIN, 50));
		totalRentados.add(rent, BorderLayout.CENTER);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);
		clientPanel.add(totalRentados, gbc);

		// Panel Vehiculos en Mantenimiento
		PanelRounded totalMantenimiento = new PanelRounded(10, true, true, true, true);
		totalMantenimiento.setOpaque(false);
		totalMantenimiento.setVisible(true);
		totalMantenimiento.setLayout(new BorderLayout());
		totalMantenimiento.setBackground(Color.decode("#FFFFFF"));

		JLabel mantenimiento_titulo = new JLabel("En Mantenimiento");//Etitqueta de mantenimiento
		mantenimiento_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		mantenimiento_titulo.setBackground(Color.white);
		mantenimiento_titulo.setForeground(Color.BLACK);
		mantenimiento_titulo.setHorizontalAlignment(JLabel.CENTER);
		mantenimiento_titulo.setFont(new Font("Poppins", Font.PLAIN, 25));
		totalMantenimiento.add(mantenimiento_titulo, BorderLayout.NORTH);

		JLabel mant = new JLabel(Integer.toString(control.numeroVehiculos_manteni()));//Etitqueta de mantenimiento num
		mant.setBackground(Color.white);
		mant.setForeground(Color.BLACK);
		mant.setHorizontalAlignment(JLabel.CENTER);
		mant.setFont(new Font("Poppins", Font.PLAIN, 50));
		totalMantenimiento.add(mant, BorderLayout.CENTER);

		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0; 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);
		clientPanel.add(totalMantenimiento, gbc);

		//Panel para la barra de busqueda
		PanelRounded barraBusqueda = new PanelRounded(10, true, true, true, true);
		barraBusqueda.setOpaque(false);
		barraBusqueda.setVisible(true);
		barraBusqueda.setBackground(Color.white);
		barraBusqueda.setBorder(null);
		barraBusqueda.setLayout(new BorderLayout());

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

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 10, 20);
		clientPanel.add(barraBusqueda, gbc);
		//Panel para el botonde añadir
		PanelRounded panelboton = new PanelRounded(10, true, true, true, true);
		panelboton.setOpaque(false);
		panelboton.setVisible(true);
		panelboton.setLayout(new BorderLayout());

		//Icono y escalador del boton añadir
		ImageIcon añadirIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/agregar_white.png"));
		Image añadirEscalar = añadirIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon añadirEscalada = new ImageIcon(añadirEscalar);

		//Boton Añadir
		ButtonRounded añadirCliente = new ButtonRounded("Añadir Cliente",10,1);
		añadirCliente.setOpaque(false);
		añadirCliente.setBackground(Color.decode("#000D56"));
		añadirCliente.setForeground(Color.white);
		añadirCliente.setFont(new Font("Poppins",Font.BOLD,20));
		añadirCliente.setIcon(añadirEscalada);
		añadirCliente.addActionListener(e->{
			addClient();
		});
		//Posicionamiento del boton en el GridBagLayout
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10, 20, 10, 20);
		clientPanel.add(añadirCliente, gbc);
		//Panel con la tabla de clientes
		PanelRounded tablaClientes = new PanelRounded(10, true, true, true, true);
		tablaClientes.setOpaque(false);
		tablaClientes.setVisible(true);
		tablaClientes.setBackground(Color.decode("#D9D9D9"));
		//Creacion del panel para la tabla de clientes
		tablaClientes.setLayout(new BorderLayout());

		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"ID","Nombre","Correo Electronico","Teléfono","Rentas","Acciones"};
		//Creacion de modelo de tabla para poder filtrar y evitar que el usuario edite las columnas diferentes del boton
		DefaultTableModel modeloClientes = new DefaultTableModel(null,table_head) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5; 
			}
		};
		// Pide la lista al controlador
		ArrayList<ClientModel> listaClientes = control.obtenerClientes();
		// La imprime por fila 
		for (ClientModel cliente : listaClientes) {
		    Object[] fila = new Object[6];
		    fila[0] = cliente.getIdLetra();
		    fila[1] = cliente.getName();
		    fila[2] = cliente.getEmail();
		    fila[3] = cliente.getPhone();
		    fila[4] = String.valueOf(cliente.getTotalRentas());
		    fila[5] = "";		    
		    modeloClientes.addRow(fila);
		}
		
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
					busqueda.setText("Buscar Cliente"); // Restaurar el mensaje
				}
			}
		});


		//creacion y customización del scroll pane
		JScrollPane scrollPane = new JScrollPane(clientes_table);
		scrollPane.getVerticalScrollBar().setUI(new ScrollBarCustom());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//BotonPrincipal con su icono
		ImageIcon iconOpciones = new ImageIcon(getClass().getResource("/Iconos/acciones/acciones.png"));
		Image imgOpciones = iconOpciones.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon btnPrincipal = new ImageIcon(imgOpciones);

		//Cargamos los iconos del submenu (editar,descargar pdf y mostrar el historial del cliente, ademas de eliminar)
		ImageIcon iconVer = new ImageIcon(getClass().getResource("/Iconos/acciones/historial.png"));
		ImageIcon iconEditar = new ImageIcon(getClass().getResource("/Iconos/acciones/editar.png"));
		ImageIcon iconEliminar = new ImageIcon(getClass().getResource("/Iconos/acciones/eliminar.png"));
		ImageIcon iconDescargar = new ImageIcon(getClass().getResource("/Iconos/acciones/descargar.png"));
		// Escalar los 3 íconos
		ImageIcon btnVer = new ImageIcon(iconVer.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		ImageIcon btnEditar = new ImageIcon(iconEditar.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		ImageIcon btnEliminar = new ImageIcon(iconEliminar.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		ImageIcon btnDescargar = new ImageIcon(iconDescargar.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		//Agregamos botones customizados con popup a la 5ta columna de la tabla y personalizamos la columna	
		clientes_table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRoundedRenderer(btnPrincipal));
		clientes_table.getColumnModel().getColumn(5).setCellEditor(new ButtonRoundedEditor(new JCheckBox(), btnPrincipal,btnVer,btnEditar,btnEliminar,btnDescargar,"Clientes",clientes_table));
		clientes_table.setRowHeight(40);
		clientes_table.getColumnModel().getColumn(5).setPreferredWidth(60);
		clientes_table.setBackground(Color.decode("#D9D9D9"));
		clientes_table.setShowVerticalLines(false);
		clientes_table.setShowHorizontalLines(true);
		tablaClientes.add(scrollPane, BorderLayout.CENTER);

		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < 5; i++) {//Ciclo para aplicar el centrado solo a los campos de datos
			clientes_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		JTableHeader header = clientes_table.getTableHeader();
		header.setBackground(Color.decode("#AFAFAF"));
		header.setFont(new Font("Poppins", Font.BOLD, 18));
		DefaultTableCellRenderer headerRenderer =(DefaultTableCellRenderer) header.getDefaultRenderer();
		headerRenderer.setOpaque(true);
		headerRenderer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setOpaque(true);


		//Posicionamiento del boton en el GridBagLayout
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 4; 
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);
		clientPanel.add(tablaClientes, gbc);
		
		//Creacion de Label de error en caso de que la verificacion sea incorrecta
		LabelRounded Alert = new LabelRounded("",10,Color.decode("#BD4747"));
		Alert.setVisible(false);
		Alert.setOpaque(false);
		Alert.setFont(new Font("Poppins",Font.BOLD,15));
		Alert.setForeground(Color.decode("#FFFFFF"));
		
		//Posicionamiento de la alerta
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2; 
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);
		clientPanel.add(Alert, gbc);

		return clientPanel;
	}

	public void addClient() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		//Panel sobre el cual se trabajara
		PanelRounded añadirCliente = new PanelRounded(20,true,true,true,true);
		añadirCliente.setLayout(null);
		añadirCliente.setSize(700,600);
		añadirCliente.setLocation(610,240);
		añadirCliente.setBackground(Color.white);
		añadirCliente.setOpaque(false);
		ventana.add(añadirCliente);
		//Label superior con nombre de pestaña
		LabelRounded tituloAñadir = new LabelRounded("AÑADIR CLIENTE",20,Color.decode("#000D56"));
		tituloAñadir.setOpaque(false);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.BOLD,25));
		tituloAñadir.setSize(700,100);
		tituloAñadir.setLocation(0, 0);
		añadirCliente.add(tituloAñadir);

		//Label nombre y su respectivo campo de texto
		JLabel nombre = new JLabel("Nombre");
		nombre.setOpaque(false);
		nombre.setForeground(Color.black);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		nombre.setFont(new Font("Poppins",Font.PLAIN,15));
		nombre.setSize(70,25);
		nombre.setLocation(80,130);
		añadirCliente.add(nombre);

		TextFieldRounded campoNombre = new TextFieldRounded(20,20,true);
		campoNombre.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoNombre.setForeground(Color.decode("#8B8B8B"));
		campoNombre.setOpaque(false);
		campoNombre.setText("---");
		campoNombre.setSize(280,40);
		campoNombre.setLocation(80,160);
		campoNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoNombre.getText().equals("---")) {
					campoNombre.setText(""); // Vaciar la caja
					campoNombre.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoNombre.getText().isEmpty()) {
					campoNombre.setText("---"); // Restaurar el mensaje
					campoNombre.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		añadirCliente.add(campoNombre);
		//Label correo y su respectivo campo de texto
		JLabel correo = new JLabel("Correo");
		correo.setOpaque(false);
		correo.setForeground(Color.black);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setFont(new Font("Poppins",Font.PLAIN,15));
		correo.setSize(70,25);
		correo.setLocation(80,230);
		añadirCliente.add(correo);

		TextFieldRounded campoCorreo = new TextFieldRounded(20,20,true);
		campoCorreo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCorreo.setForeground(Color.decode("#8B8B8B"));
		campoCorreo.setOpaque(false);
		campoCorreo.setText("---");
		campoCorreo.setSize(280,40);
		campoCorreo.setLocation(80,260);
		campoCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoCorreo.getText().equals("---")) {
					campoCorreo.setText(""); // Vaciar la caja
					campoCorreo.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoCorreo.getText().isEmpty()) {
					campoCorreo.setText("---"); // Restaurar el mensaje
					campoCorreo.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		añadirCliente.add(campoCorreo);
		//Label telefono y su respectivo campo de texto
		JLabel telefono = new JLabel("Teléfono");
		telefono.setOpaque(false);
		telefono.setForeground(Color.black);
		telefono.setHorizontalAlignment(JLabel.LEFT);
		telefono.setFont(new Font("Poppins",Font.PLAIN,15));
		telefono.setSize(70,25);
		telefono.setLocation(80,330);
		añadirCliente.add(telefono);

		TextFieldRounded campoTelefono = new TextFieldRounded(20,20,true);
		campoTelefono.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoTelefono.setForeground(Color.decode("#8B8B8B"));
		campoTelefono.setOpaque(false);
		campoTelefono.setText("---");
		campoTelefono.setSize(280,40);
		campoTelefono.setLocation(80,360);
		campoTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoTelefono.getText().equals("---")) {
					campoTelefono.setText(""); // Vaciar la caja
					campoTelefono.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoTelefono.getText().isEmpty()) {
					campoTelefono.setForeground(Color.decode("#8B8B8B"));
					campoTelefono.setText("---"); // Restaurar el mensaje
				}
			}
		});
		añadirCliente.add(campoTelefono);

		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		titulofoto.setSize(70,25);
		titulofoto.setLocation(400,130);
		añadirCliente.add(titulofoto);

		//Contorno redondeado
		LabelRounded foto = new LabelRounded("",20,Color.decode("#FFFFFF"));
		foto.setOpaque(false);
		foto.setSize(255,255);
		foto.setLocation(400,160);
		foto.setPreferredSize(new Dimension(500,500));
		foto.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(
						Color.black,3,true),
				BorderFactory.createEmptyBorder(10,20,10,00)
				));
		añadirCliente.add(foto);

		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setSize(150,60);
		cancelarCliente.setLocation(150,500);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
			ventana.dispose();

		});
		añadirCliente.add(cancelarCliente);

		ButtonRounded registrarCliente = new ButtonRounded("Registrar cliente",10,1);
		registrarCliente.setOpaque(false);
		registrarCliente.setForeground(Color.white);
		registrarCliente.setHorizontalAlignment(JLabel.CENTER);
		registrarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCliente.addActionListener(e->{
			control.addClient(campoCorreo.getText(), campoNombre.getText(), campoTelefono.getText());
			ventana.dispose();
		});
		registrarCliente.setSize(200,60);
		registrarCliente.setLocation(350,500);
		añadirCliente.add(registrarCliente);

		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void editClient(int idCliente, String nombreActual, String correoActual, String telefonoActual) {
		// Crear Ventana
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		//Panel sobre el cual se trabajara
		PanelRounded editarCliente = new PanelRounded(20,true,true,true,true);
		editarCliente.setLayout(null);
		editarCliente.setSize(700,600);
		editarCliente.setLocation(610,240);
		editarCliente.setBackground(Color.white);
		editarCliente.setOpaque(false);
		ventana.add(editarCliente);
		//Label superior con nombre de pestaña
		LabelRounded tituloEditar = new LabelRounded("EDITAR CLIENTE",20,Color.decode("#000D56"));
		tituloEditar.setOpaque(false);
		tituloEditar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloEditar.setForeground(Color.WHITE);
		tituloEditar.setHorizontalAlignment(JLabel.LEFT);
		tituloEditar.setFont(new Font("Poppins",Font.BOLD,25));
		tituloEditar.setSize(700,100);
		tituloEditar.setLocation(0, 0);
		editarCliente.add(tituloEditar);

		//Label nombre y su respectivo campo de texto
		JLabel nombre = new JLabel("Nombre");
		nombre.setOpaque(false);
		nombre.setForeground(Color.black);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		nombre.setFont(new Font("Poppins",Font.PLAIN,15));
		nombre.setSize(70,25);
		nombre.setLocation(80,130);
		editarCliente.add(nombre);

		TextFieldRounded campoNombre = new TextFieldRounded(20,20,true);
		campoNombre.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoNombre.setForeground(Color.decode("#8B8B8B"));
		campoNombre.setOpaque(false);
		campoNombre.setText("---");
		campoNombre.setSize(280,40);
		campoNombre.setLocation(80,160);
		campoNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoNombre.getText().equals("---")) {
					campoNombre.setText(""); // Vaciar la caja
					campoNombre.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoNombre.getText().isEmpty()) {
					campoNombre.setText("---"); // Restaurar el mensaje
					campoNombre.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		editarCliente.add(campoNombre);
		//Label correo y su respectivo campo de texto
		JLabel correo = new JLabel("Correo");
		correo.setOpaque(false);
		correo.setForeground(Color.black);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setFont(new Font("Poppins",Font.PLAIN,15));
		correo.setSize(70,25);
		correo.setLocation(80,230);
		editarCliente.add(correo);

		TextFieldRounded campoCorreo = new TextFieldRounded(20,20,true);
		campoCorreo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCorreo.setForeground(Color.decode("#8B8B8B"));
		campoCorreo.setOpaque(false);
		campoCorreo.setText("---");
		campoCorreo.setSize(280,40);
		campoCorreo.setLocation(80,260);
		campoCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoCorreo.getText().equals("---")) {
					campoCorreo.setText(""); // Vaciar la caja
					campoCorreo.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoCorreo.getText().isEmpty()) {
					campoCorreo.setText("---"); // Restaurar el mensaje
					campoCorreo.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		editarCliente.add(campoCorreo);
		//Label telefono y su respectivo campo de texto
		JLabel telefono = new JLabel("Teléfono");
		telefono.setOpaque(false);
		telefono.setForeground(Color.black);
		telefono.setHorizontalAlignment(JLabel.LEFT);
		telefono.setFont(new Font("Poppins",Font.PLAIN,15));
		telefono.setSize(70,25);
		telefono.setLocation(80,330);
		editarCliente.add(telefono);

		TextFieldRounded campoTelefono = new TextFieldRounded(20,20,true);
		campoTelefono.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoTelefono.setForeground(Color.decode("#8B8B8B"));
		campoTelefono.setOpaque(false);
		campoTelefono.setText("---");
		campoTelefono.setSize(280,40);
		campoTelefono.setLocation(80,360);
		campoTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoTelefono.getText().equals("---")) {
					campoTelefono.setText(""); // Vaciar la caja
					campoTelefono.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoTelefono.getText().isEmpty()) {
					campoTelefono.setForeground(Color.decode("#8B8B8B"));
					campoTelefono.setText("---"); // Restaurar el mensaje
				}
			}
		});
		editarCliente.add(campoTelefono);

		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		titulofoto.setSize(70,25);
		titulofoto.setLocation(400,130);
		editarCliente.add(titulofoto);

		//Contorno redondeado
		LabelRounded foto = new LabelRounded("",20,Color.decode("#FFFFFF"));
		foto.setOpaque(false);
		foto.setSize(255,255);
		foto.setLocation(400,160);
		foto.setPreferredSize(new Dimension(500,500));
		foto.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(
						Color.black,3,true),
				BorderFactory.createEmptyBorder(10,20,10,00)
				));
		editarCliente.add(foto);

		ButtonRounded cancelarCambios = new ButtonRounded("Cancelar",10,5);
		cancelarCambios.setSize(150,60);
		cancelarCambios.setLocation(150,500);
		cancelarCambios.setOpaque(false);
		cancelarCambios.setForeground(Color.white);
		cancelarCambios.setHorizontalAlignment(JLabel.CENTER);
		cancelarCambios.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCambios.addActionListener(e->{
			ventana.dispose();

		});
		editarCliente.add(cancelarCambios);
		
	    //Prellenar campos con datos actuales
	    campoNombre.setText(nombreActual);
	    campoCorreo.setText(correoActual);
	    campoTelefono.setText(telefonoActual);

		ButtonRounded registrarCambios = new ButtonRounded("Guardar Cambios",10,1);
		registrarCambios.setOpaque(false);
		registrarCambios.setForeground(Color.white);
		registrarCambios.setHorizontalAlignment(JLabel.CENTER);
		registrarCambios.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCambios.addActionListener(e->{
	        String nuevoNombre = campoNombre.getText();
	        String nuevoCorreo = campoCorreo.getText();
	        String nuevoTelefono = campoTelefono.getText();
	        
	        control.update(idCliente, nuevoCorreo, nuevoNombre, nuevoTelefono);
			ventana.dispose();
		});
		registrarCambios.setSize(200,60);
		registrarCambios.setLocation(350,500);
		editarCliente.add(registrarCambios);

		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void detailClient() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		//Panel sobre el cual se trabajara
		PanelRounded detallesCliente = new PanelRounded(20,true,true,true,true);
		detallesCliente.setLayout(null);
		detallesCliente.setSize(700,600);
		detallesCliente.setLocation(610,240);
		detallesCliente.setBackground(Color.white);
		detallesCliente.setOpaque(false);
		ventana.add(detallesCliente);
		//Label superior con nombre de pestaña
		LabelRounded tituloDetalles = new LabelRounded("DETALLES DE CLIENTE",20,Color.decode("#000D56"));
		tituloDetalles.setOpaque(false);
		tituloDetalles.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloDetalles.setForeground(Color.WHITE);
		tituloDetalles.setHorizontalAlignment(JLabel.LEFT);
		tituloDetalles.setFont(new Font("Poppins",Font.BOLD,25));
		tituloDetalles.setSize(700,100);
		tituloDetalles.setLocation(0, 0);
		detallesCliente.add(tituloDetalles);

		//Label nombre y su respectivo campo de texto
		JLabel nombre = new JLabel("Nombre");
		nombre.setOpaque(false);
		nombre.setForeground(Color.black);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		nombre.setFont(new Font("Poppins",Font.PLAIN,15));
		nombre.setSize(70,25);
		nombre.setLocation(80,130);
		detallesCliente.add(nombre);

		TextFieldRounded campoNombre = new TextFieldRounded(20,20,true);
		campoNombre.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoNombre.setForeground(Color.black);
		campoNombre.setOpaque(false);
		campoNombre.setText("Jonathan Soto");
		campoNombre.setEditable(false);
		campoNombre.setSize(280,40);
		campoNombre.setLocation(80,160);
		detallesCliente.add(campoNombre);

		//Label correo y su respectivo campo de texto
		JLabel correo = new JLabel("Correo");
		correo.setOpaque(false);
		correo.setForeground(Color.black);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setFont(new Font("Poppins",Font.PLAIN,15));
		correo.setSize(70,25);
		correo.setLocation(80,230);
		detallesCliente.add(correo);

		TextFieldRounded campoCorreo = new TextFieldRounded(20,20,true);
		campoCorreo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCorreo.setForeground(Color.black);
		campoCorreo.setOpaque(false);
		campoCorreo.setEditable(false);
		campoCorreo.setText("jsoto@uabcs.mx");
		campoCorreo.setSize(280,40);
		campoCorreo.setLocation(80,260);
		detallesCliente.add(campoCorreo);

		//Label telefono y su respectivo campo de texto
		JLabel telefono = new JLabel("Teléfono");
		telefono.setOpaque(false);
		telefono.setForeground(Color.black);
		telefono.setHorizontalAlignment(JLabel.LEFT);
		telefono.setFont(new Font("Poppins",Font.PLAIN,15));
		telefono.setSize(70,25);
		telefono.setLocation(80,330);
		detallesCliente.add(telefono);

		TextFieldRounded campoTelefono = new TextFieldRounded(20,20,true);
		campoTelefono.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoTelefono.setForeground(Color.black);
		campoTelefono.setOpaque(false);
		campoTelefono.setEditable(false);
		campoTelefono.setText("6123480678");
		campoTelefono.setSize(280,40);
		campoTelefono.setLocation(80,360);
		detallesCliente.add(campoTelefono);

		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		titulofoto.setSize(70,25);
		titulofoto.setLocation(400,130);
		detallesCliente.add(titulofoto);

		//Contorno redondeado
		LabelRounded foto = new LabelRounded("",20,Color.decode("#FFFFFF"));
		foto.setOpaque(false);
		foto.setSize(255,255);
		foto.setLocation(400,160);
		foto.setPreferredSize(new Dimension(500,500));
		foto.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(
						Color.black,3,true),
				BorderFactory.createEmptyBorder(10,20,10,00)
				));
		detallesCliente.add(foto);

		ButtonRounded volver = new ButtonRounded("Volver",10,5);
		volver.setSize(150,60);
		volver.setLocation(275,500);
		volver.setOpaque(false);
		volver.setForeground(Color.white);
		volver.setHorizontalAlignment(JLabel.CENTER);
		volver.setFont(new Font("Poppins",Font.BOLD,20));
		volver.addActionListener(e->{
			ventana.dispose();

		});
		detallesCliente.add(volver);

		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void historialCliente() {
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		//Panel sobre el cual se trabajara
		PanelRounded detallesCliente = new PanelRounded(20,true,true,true,true);
		detallesCliente.setLayout(null);
		detallesCliente.setSize(1720,990);
		detallesCliente.setLocation(100,50);
		detallesCliente.setBackground(Color.white);
		detallesCliente.setOpaque(false);
		ventana.add(detallesCliente);

		LabelRounded etiquetaHistorial = new LabelRounded("HISTORIAL DEL CLIENTE", 10, Color.decode("#000D56"));
		etiquetaHistorial.setBounds(0, 0, 1720, 50);
		etiquetaHistorial.setOpaque(false);
		etiquetaHistorial.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		etiquetaHistorial.setForeground(Color.WHITE);
		etiquetaHistorial.setHorizontalAlignment(JLabel.LEFT);
		etiquetaHistorial.setFont(new Font("Poppins",Font.BOLD,25));
		detallesCliente.add(etiquetaHistorial);

		PanelRounded barraBusqueda = new PanelRounded(10,true,true,true,true);
		barraBusqueda.setLayout(new BorderLayout());
		barraBusqueda.setSize(200,50);
		barraBusqueda.setLocation(100,100);
		barraBusqueda.setBackground(Color.white);
		barraBusqueda.setOpaque(false);
		detallesCliente.add(barraBusqueda);

		//Icono de la barra de busqueda
		ImageIcon busquedaIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/buscar.png"));
		//Escalamos la imagen y la asignamos a un ImageIcon
		Image imagenEscalada = busquedaIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		JLabel labelIcono = new JLabel(iconoEscalado);
		labelIcono.setBounds(100, 100, 18, 18);
		barraBusqueda.add(labelIcono, BorderLayout.WEST);

		//Creacion del campo de texto para la barra de busqueda de clientes
		TextFieldRounded busqueda = new TextFieldRounded(10, 10,true);
		busqueda.setFont(new Font("Poppins", Font.PLAIN, 15));
		busqueda.setBounds(120, 100, 150, 50);
		busqueda.setForeground(Color.decode("#8B8B8B"));
		busqueda.setOpaque(false);
		busqueda.setText("Buscar");
		busqueda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (busqueda.getText().equals("Buscar")) {
					busqueda.setText(""); // Vaciar la caja
					busqueda.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (busqueda.getText().isEmpty()) {
					busqueda.setText("Buscar"); // Restaurar el mensaje
					busqueda.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		barraBusqueda.add(busqueda,BorderLayout.CENTER);

		PanelRounded panelOrdenar = new PanelRounded(10, true, true, true, true);
		panelOrdenar.setBackground(Color.decode("#AFAFAF"));
		panelOrdenar.setOpaque(false);
		panelOrdenar.setBounds(1420, 100, 200, 50);
		panelOrdenar.setBorder(null);
		panelOrdenar.setLayout(new BorderLayout());
		detallesCliente.add(panelOrdenar);

		//Creacion de un arreglo para introducir cada copcion dentro de un ComboBox
		String[] Ordenamientos = {"TODOS", "Fecha Inicio", "Fecha Final", "Estado"};
		ComboBoxRounded<String> list = new ComboBoxRounded<>(Ordenamientos);
		//Personalizacion del comboBox
		list.setFont(new Font("Poppins", Font.BOLD, 15));
		panelOrdenar.add(list, BorderLayout.CENTER);

		PanelRounded panelTabla = new PanelRounded(10, true, true, true, true);
		panelTabla.setOpaque(false);
		panelTabla.setBounds(100, 180, 1520, 700);
		panelTabla.setBackground(Color.white);
		panelTabla.setBorder(null);
		panelTabla.setLayout(new BorderLayout());
		detallesCliente.add(panelTabla);

		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"ID renta","Vehiculo","Feha Inicio","Fecha Fin"};
		//Creacion de una matriz para los datos de una tabla 
		Object [][] table_content = {
				{"Corolla", "01/03/2024", "05/03/2024", "Finalizado"},
				{"CR-V", "04/05/2024", "18/05/2024", "Finalizado"},
				{"Sentra", "12/04/2024", "15/04/2024", "Finalizado"},
		};

		DefaultTableModel modeloCliente = new DefaultTableModel(table_content,table_head){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Ninguna celda será editable
			}
		};
		//Creacion de la tabla para usuario con el modelo y agregamos el filtrador
		JTable clientes_table = new JTable(modeloCliente);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloCliente);
		clientes_table.setRowSorter(sorter);

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
				if (textoBusqueda.trim().length() == 0 || textoBusqueda.equals("Buscar")) {
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
				if (busqueda.getText().equals("Buscar")) {
					busqueda.setText(""); // Vaciamos la caja
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (busqueda.getText().isEmpty()) {
					busqueda.setText("Buscar"); // Restauramos el mensaje
				}
			}
		});

		//creacion y customización del scroll pane
		JScrollPane scrollPane = new JScrollPane(clientes_table);
		scrollPane.getVerticalScrollBar().setUI(new ScrollBarCustom());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		clientes_table.setRowHeight(40);
		clientes_table.setBackground(Color.decode("#D9D9D9"));
		clientes_table.setShowVerticalLines(false);
		clientes_table.setShowHorizontalLines(true);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < 4; i++) {//Ciclo para aplicar el centrado solo a los campos de datos
			clientes_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		JTableHeader header = clientes_table.getTableHeader();
		header.setBackground(Color.decode("#AFAFAF"));
		header.setFont(new Font("Poppins", Font.BOLD, 18));
		DefaultTableCellRenderer headerRenderer =(DefaultTableCellRenderer) header.getDefaultRenderer();
		headerRenderer.setOpaque(true);
		headerRenderer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setOpaque(true);

		ButtonRounded volver = new ButtonRounded("Salir",10,5);
		volver.setBounds(785, 900,150, 50);
		volver.setOpaque(false);
		volver.setForeground(Color.WHITE);
		volver.setHorizontalAlignment(JLabel.CENTER);
		volver.setFont(new Font("Poppins",Font.BOLD,15));
		volver.addActionListener(e->{
			ventana.dispose();
		});
		detallesCliente.add(volver);

		ventana.setVisible(true);
	}

}
