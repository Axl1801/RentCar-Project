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

import Controllers.HomeController;
import Utilities.Alerts;
import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class ClientView {

	public ClientView() {

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

		JLabel total = new JLabel("50");//Etitqueta de total vehiculos num
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

		JLabel disp = new JLabel("20");//Etitqueta de total disponibles num
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

		JLabel rent = new JLabel("25");//Etitqueta de totalrentados  num
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

		JLabel mant = new JLabel("5");//Etitqueta de mantenimiento num
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
		//Creacion de una matriz para los datos de una tabla 
		Object [][] table_content = {
				{"C-001", "Diego Ramirez", "diego.ramirez23@gmail.com", "612-145-7823", "7", ""},
				{"C-002", "Sofia Torres", "sofia.torres21@gmail.com", "624-987-3345", "4", ""},
				{"C-003", "Luis Mendoza", "luis.mendoza31@gmail.com", "613-556-1298", "2", ""},
				{"C-004", "Valeria Cruz", "valeria.cruz25@gmail.com", "622-341-7765", "6", ""},
				{"C-005", "Axel Garcia", "axel.garcia18@gmail.com", "624-381-9678", "16", ""},
				{"C-006", "Esau Hernandez", "esau.garcia13@gmail.com", "615-778-9021", "9", ""},
				{"C-007", "Osmin Ojeda", "osita.cariñosita15@gmail.com", "615-778-9021", "5", ""},
				{"C-008", "Ronaldo Centeno", "ronaldo.click41@gmail.com", "615-778-9021", "8", ""},
				{"C-009", "Fabian Green", "fuck.boy45cm@gmail.com", "615-778-9021", "2", "Editar"},
				{"C-010", "Cereneo Manzanares", "cereno.manzanarez01@gmail.com", "615-778-9021", "7", ""},
				{"C-011", "Fernanda Jacome", "fernanda.jacome14@gmail.com", "615-778-9021", "9", ""},
				{"C-012", "Isbeth Cortez", "isbeth.cortez02@gmail.com", "615-778-9021", "14", ""},
				{"C-013", "Jonathan Soto", "osito.cariñosito16@gmail.com", "615-778-9021", "17", ""},
				{"C-014", "Israel Duran", "oso.pardo3@gmail.com", "615-778-9021", "18", ""},
				{"C-015", "Arturo Decasso", "oso.pardo4@gmail.com", "615-778-9021", "15", ""}
		};
		
		//Creacion de modelo de tabla para poder filtrar y evitar que el usuario edite las columnas diferentes del boton
		DefaultTableModel modeloClientes = new DefaultTableModel(table_content,table_head) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 5; 
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
		clientes_table.getColumnModel().getColumn(5).setCellEditor(new ButtonRoundedEditor(new JCheckBox(), btnPrincipal,btnVer,btnEditar,btnEliminar,btnDescargar,"Clientes"));
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

		return clientPanel;
	}
	
	public void addClient() {
        // Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(720, 500);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
		//Panel sobre el cual se trabajara
		PanelRounded añadirCliente = new PanelRounded(10,true,true,true,true);
		añadirCliente.setLayout(new BorderLayout());
		añadirCliente.setPreferredSize(new Dimension(600,600));
		añadirCliente.setBackground(Color.white);
		añadirCliente.setOpaque(false);
		ventana.add(añadirCliente, BorderLayout.CENTER);
		//Label superior con nombre de pestaña
		JLabel tituloAñadir = new JLabel("Añadir Cliente");
		tituloAñadir.setOpaque(true);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		tituloAñadir.setBackground(Color.decode("#000D56"));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.PLAIN,25));
		añadirCliente.add(tituloAñadir, BorderLayout.NORTH);
		//Panel izq para los datos
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.setOpaque(false);
		añadirCliente.add(panelDatos, BorderLayout.WEST);
		//Label nombre y su respectivo campo de texto
		JLabel nombre = new JLabel("Nombre");
		nombre.setOpaque(false);
		nombre.setForeground(Color.black);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		nombre.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(nombre);
		
		TextFieldRounded campoNombre = new TextFieldRounded(20,20,true);
		campoNombre.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoNombre.setForeground(Color.decode("#8B8B8B"));
		campoNombre.setOpaque(false);
		campoNombre.setText("---");
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
		panelDatos.add(campoNombre);
		//Label correo y su respectivo campo de texto
		JLabel correo = new JLabel("Correo");
		correo.setOpaque(false);
		correo.setForeground(Color.black);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(correo);
		
		TextFieldRounded campoCorreo = new TextFieldRounded(20,20,true);
		campoCorreo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCorreo.setForeground(Color.decode("#8B8B8B"));
		campoCorreo.setOpaque(false);
		campoCorreo.setText("---");
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
		panelDatos.add(campoCorreo);
		//Label telefono y su respectivo campo de texto
		JLabel telefono = new JLabel("Teléfono");
		telefono.setOpaque(false);
		telefono.setForeground(Color.black);
		telefono.setHorizontalAlignment(JLabel.LEFT);
		telefono.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(telefono);
		
		TextFieldRounded campoTelefono = new TextFieldRounded(20,20,true);
		campoTelefono.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoTelefono.setForeground(Color.decode("#8B8B8B"));
		campoTelefono.setOpaque(false);
		campoTelefono.setText("---");
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
		panelDatos.add(campoTelefono);
		//Panel DER donde colocar el campo de la foto
		JPanel fotoCont = new JPanel();
		fotoCont.setLayout(new BoxLayout(fotoCont, BoxLayout.Y_AXIS));
		fotoCont.setOpaque(false);
		añadirCliente.add(fotoCont, BorderLayout.CENTER);
		
		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(titulofoto);
		
		//Contorno redondeado
		LabelRounded foto = new LabelRounded("",10,Color.decode("#FFFFFF"));
		foto.setPreferredSize(new Dimension(500,500));
		foto.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(
		                Color.black,3,true),
		            BorderFactory.createEmptyBorder(10,20,10,00)
		        ));
		fotoCont.add(foto);
		
		//Panel de botones
		JPanel botonesCont = new JPanel();
		botonesCont.setLayout(new FlowLayout());
		botonesCont.setOpaque(false);
        
		ButtonRounded registrarCliente = new ButtonRounded("Registrar Cliente",10,1);
		registrarCliente.setOpaque(false);
		registrarCliente.setForeground(Color.white);
		registrarCliente.setHorizontalAlignment(JLabel.CENTER);
		registrarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCliente.addActionListener(e->{
        	ventana.dispose();
     
		});
		botonesCont.add(registrarCliente);
		
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
        	ventana.dispose();
		});
		botonesCont.add(cancelarCliente);
		añadirCliente.add(botonesCont,BorderLayout.SOUTH);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void editClient() {
        // Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(720, 500);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
		//Panel sobre el cual se trabajara
		PanelRounded editarCliente = new PanelRounded(10,true,true,true,true);
		editarCliente.setLayout(new BorderLayout());
		editarCliente.setPreferredSize(new Dimension(600,600));
		editarCliente.setBackground(Color.white);
		editarCliente.setOpaque(false);
		ventana.add(editarCliente, BorderLayout.CENTER);
		//Label superior con nombre de pestaña
		JLabel tituloEditar = new JLabel("Editar Cliente");
		tituloEditar.setOpaque(true);
		tituloEditar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		tituloEditar.setBackground(Color.decode("#000D56"));
		tituloEditar.setForeground(Color.WHITE);
		tituloEditar.setHorizontalAlignment(JLabel.LEFT);
		tituloEditar.setFont(new Font("Poppins",Font.PLAIN,25));
		editarCliente.add(tituloEditar, BorderLayout.NORTH);
		//Panel izq para los datos
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.setOpaque(false);
		editarCliente.add(panelDatos, BorderLayout.WEST);
		//Label nombre y su respectivo campo de texto
		JLabel nombre = new JLabel("Nombre");
		nombre.setOpaque(false);
		nombre.setForeground(Color.black);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		nombre.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(nombre);
		
		TextFieldRounded campoNombre = new TextFieldRounded(20,20,true);
		campoNombre.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoNombre.setForeground(Color.decode("#8B8B8B"));
		campoNombre.setOpaque(false);
		campoNombre.setText("---");
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
		panelDatos.add(campoNombre);
		//Label correo y su respectivo campo de texto
		JLabel correo = new JLabel("Correo");
		correo.setOpaque(false);
		correo.setForeground(Color.black);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(correo);
		
		TextFieldRounded campoCorreo = new TextFieldRounded(20,20,true);
		campoCorreo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCorreo.setForeground(Color.decode("#8B8B8B"));
		campoCorreo.setOpaque(false);
		campoCorreo.setText("---");
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
		panelDatos.add(campoCorreo);
		//Label telefono y su respectivo campo de texto
		JLabel telefono = new JLabel("Teléfono");
		telefono.setOpaque(false);
		telefono.setForeground(Color.black);
		telefono.setHorizontalAlignment(JLabel.LEFT);
		telefono.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(telefono);
		
		TextFieldRounded campoTelefono = new TextFieldRounded(20,20,true);
		campoTelefono.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoTelefono.setForeground(Color.decode("#8B8B8B"));
		campoTelefono.setOpaque(false);
		campoTelefono.setText("---");
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
		panelDatos.add(campoTelefono);
		//Panel DER donde colocar el campo de la foto
		JPanel fotoCont = new JPanel();
		fotoCont.setLayout(new BoxLayout(fotoCont, BoxLayout.Y_AXIS));
		fotoCont.setOpaque(false);
		editarCliente.add(fotoCont, BorderLayout.CENTER);
		
		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(titulofoto);
		
		//Contorno redondeado
		LabelRounded foto = new LabelRounded("",10,Color.decode("#FFFFFF"));
		foto.setPreferredSize(new Dimension(500,500));
		foto.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(
		                Color.black,3,true),
		            BorderFactory.createEmptyBorder(10,20,10,00)
		        ));
		fotoCont.add(foto);
		
		//Panel de botones
		JPanel botonesCont = new JPanel();
		botonesCont.setLayout(new FlowLayout());
		botonesCont.setOpaque(false);
        
		ButtonRounded guardarCambios = new ButtonRounded("Guardar Cambios",10,1);
		guardarCambios.setOpaque(false);
		guardarCambios.setForeground(Color.white);
		guardarCambios.setHorizontalAlignment(JLabel.CENTER);
		guardarCambios.setFont(new Font("Poppins",Font.BOLD,20));
		guardarCambios.addActionListener(e->{
        	ventana.dispose();
     
		});
		botonesCont.add(guardarCambios);
		
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
        	ventana.dispose();
		});
		botonesCont.add(cancelarCliente);
		editarCliente.add(botonesCont,BorderLayout.SOUTH);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void detailClient() {
		 // Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(720, 500);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
		//Panel sobre el cual se trabajara
		PanelRounded editarCliente = new PanelRounded(10,true,true,true,true);
		editarCliente.setLayout(new BorderLayout());
		editarCliente.setPreferredSize(new Dimension(600,600));
		editarCliente.setBackground(Color.white);
		editarCliente.setOpaque(false);
		ventana.add(editarCliente, BorderLayout.CENTER);
		//Label superior con nombre de pestaña
		JLabel tituloEditar = new JLabel("Detalles de Cliente");
		tituloEditar.setOpaque(true);
		tituloEditar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		tituloEditar.setBackground(Color.decode("#000D56"));
		tituloEditar.setForeground(Color.WHITE);
		tituloEditar.setHorizontalAlignment(JLabel.LEFT);
		tituloEditar.setFont(new Font("Poppins",Font.PLAIN,25));
		editarCliente.add(tituloEditar, BorderLayout.NORTH);
		//Panel izq para los datos
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.setOpaque(false);
		editarCliente.add(panelDatos, BorderLayout.WEST);
		//Label nombre y su respectivo campo de texto
		JLabel nombre = new JLabel("Nombre");
		nombre.setOpaque(false);
		nombre.setForeground(Color.black);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		nombre.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(nombre);
		
		TextFieldRounded campoNombre = new TextFieldRounded(20,20,true);
		campoNombre.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoNombre.setForeground(Color.decode("#8B8B8B"));
		campoNombre.setOpaque(false);
		campoNombre.setText("---");
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
		panelDatos.add(campoNombre);
		//Label correo y su respectivo campo de texto
		JLabel correo = new JLabel("Correo");
		correo.setOpaque(false);
		correo.setForeground(Color.black);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(correo);
		
		TextFieldRounded campoCorreo = new TextFieldRounded(20,20,true);
		campoCorreo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCorreo.setForeground(Color.decode("#8B8B8B"));
		campoCorreo.setOpaque(false);
		campoCorreo.setText("---");
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
		panelDatos.add(campoCorreo);
		//Label telefono y su respectivo campo de texto
		JLabel telefono = new JLabel("Teléfono");
		telefono.setOpaque(false);
		telefono.setForeground(Color.black);
		telefono.setHorizontalAlignment(JLabel.LEFT);
		telefono.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatos.add(telefono);
		
		TextFieldRounded campoTelefono = new TextFieldRounded(20,20,true);
		campoTelefono.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoTelefono.setForeground(Color.decode("#8B8B8B"));
		campoTelefono.setOpaque(false);
		campoTelefono.setText("---");
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
		panelDatos.add(campoTelefono);
		//Panel DER donde colocar el campo de la foto
		JPanel fotoCont = new JPanel();
		fotoCont.setLayout(new BoxLayout(fotoCont, BoxLayout.Y_AXIS));
		fotoCont.setOpaque(false);
		editarCliente.add(fotoCont, BorderLayout.CENTER);
		
		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(titulofoto);
		
		//Contorno redondeado
		LabelRounded foto = new LabelRounded("",10,Color.decode("#FFFFFF"));
		foto.setPreferredSize(new Dimension(500,500));
		foto.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(
		                Color.black,3,true),
		            BorderFactory.createEmptyBorder(10,20,10,00)
		        ));
		fotoCont.add(foto);
		
		//Panel de botones
		JPanel botonesCont = new JPanel();
		botonesCont.setLayout(new FlowLayout());
		botonesCont.setOpaque(false);
		
		ButtonRounded cancelarCliente = new ButtonRounded("Volver",10,5);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
        	ventana.dispose();
		});
		botonesCont.add(cancelarCliente);
		editarCliente.add(botonesCont,BorderLayout.SOUTH);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}
}
