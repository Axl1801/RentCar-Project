package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.ComboBoxRounded;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class VehicleView {
	public VehicleView() {
		
	}
	
	public JPanel vistaVehiculos() {
		JPanel VehiculosPanel = new JPanel();
		VehiculosPanel.setOpaque(true);
		VehiculosPanel.setBackground(Color.decode("#EAEAEA"));
		VehiculosPanel.setVisible(true);
		VehiculosPanel.setLayout(new GridBagLayout());

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
		VehiculosPanel.add(totalVehiculos, gbc);
		VehiculosPanel.add(totalVehiculos, gbc);

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
		VehiculosPanel.add(totalDisponibles, gbc);

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
		VehiculosPanel.add(totalRentados, gbc);

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
		VehiculosPanel.add(totalMantenimiento, gbc);
		
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
		VehiculosPanel.add(barraBusqueda, gbc);
		
		//Panel para el ordenamiento
		PanelRounded panelOrdenar = new PanelRounded(10, true, true, true, true);
		panelOrdenar.setOpaque(false);
		panelOrdenar.setVisible(true);
		panelOrdenar.setBackground(Color.white);
		panelOrdenar.setBorder(null);
		panelOrdenar.setLayout(new BorderLayout());
		
		//Creacion de un arreglo para introducir cada copcion dentro de un ComboBox
		String[] Ordenamientos = {"TODOS", "Modelo Reciente", "Precio", "Orden Alfabetico"};
		ComboBoxRounded<String> list = new ComboBoxRounded<>(Ordenamientos);
		
		//Personalizacion del comboBox
		list.setFont(new Font("Poppins", Font.BOLD, 15));
		panelOrdenar.add(list);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 10, 20);
		VehiculosPanel.add(panelOrdenar, gbc);
		
		//Panel para filtros avanzados
		PanelRounded panelFiltros = new PanelRounded(10, true, true, true, true);
		panelFiltros.setOpaque(false);
		panelFiltros.setVisible(true);
		panelFiltros.setBackground(Color.white);
		panelFiltros.setBorder(null);
		panelFiltros.setLayout(new BorderLayout());
		
		//Creacion boton filtros con icono
		ButtonRounded filtros = new ButtonRounded("Filtros",10,4);
        URL url = getClass().getResource("/iconos/adicionales/filtros.png");//Carga ubi imagen
	    
	    if (url != null) {
	    	filtros.setIcon(new ImageIcon(url));
	    }
	    //Personalizacion
		filtros.setFont(new Font("Poppins",Font.BOLD,15));
		filtros.setHorizontalAlignment(JLabel.CENTER);  
		filtros.setIconTextGap(10);                      
		filtros.setHorizontalTextPosition(JLabel.LEFT);
		filtros.addActionListener(e->{
			filtrosAvanzados();
		});
		panelFiltros.add(filtros);	
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 10, 20);
		VehiculosPanel.add(panelFiltros, gbc);
		
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
		ButtonRounded añadirVehiculo = new ButtonRounded("Añadir Vehiculo",10,1);
		añadirVehiculo.setOpaque(false);
		añadirVehiculo.setBackground(Color.decode("#000D56"));
		añadirVehiculo.setForeground(Color.white);
		añadirVehiculo.setFont(new Font("Poppins",Font.BOLD,20));
		añadirVehiculo.setIcon(añadirEscalada);
		añadirVehiculo.addActionListener(e->{
			addVehicle();
		});
		//Posicionamiento del boton en el GridBagLayout
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10, 20, 10, 20);
		VehiculosPanel.add(añadirVehiculo, gbc);
		//Panel con la tabla de clientes
		PanelRounded tablaClientes = new PanelRounded(10, true, true, true, true);
		tablaClientes.setOpaque(false);
		tablaClientes.setVisible(true);
		tablaClientes.setBackground(Color.decode("#D9D9D9"));
		//Creacion del panel para la tabla de clientes
		tablaClientes.setLayout(new BorderLayout());
		
		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"ID","Foto","Modelo","Marca","Año","Precio (Dia)", "Estado","Acciones"};
		//Creacion de una matriz para los datos de una tabla 
		Object [][] table_content = {
				{"V-001", "foto", "Corolla", "Toyota", "2024", "$850","Disponible", ""},
				{"V-002", "foto", "CR-V", "Honda", "2023", "$1200","Rentado", ""},
				{"V-003", "foto", "Sentra", "Nissan", "2023", "$750","Mantenimiento", ""},
				{"V-004", "foto", "Tacoma", "Toyota", "2021", "$1500","Disponible", ""},
				{"V-005", "foto", "Mazda 3", "Mazda", "2025", "$950","Rentado", ""},
				{"V-006", "foto", "CR-V", "Honda", "2023", "$1200","Disponible", ""},
				{"V-007", "foto", "Sentra", "Nissan", "2023", "$750","Rentado", ""},
				{"V-008", "foto", "Corolla", "Toyota", "2024", "$850","Rentado", ""},
				{"V-009", "foto", "CR-V", "Honda", "2023", "$1200","Disponible", ""},
				{"V-010", "foto", "Tacoma", "Toyota", "2021", "$1500","Mantenimiento", ""},
				{"V-011", "foto", "Sentra", "Nissan", "2023", "$750","Disponible", ""},
				{"V-012", "foto", "Mazda 3", "Mazda", "2025", "$950","Disponible", ""},
				{"V-013", "foto", "Corolla", "Toyota", "2024", "$850","Mantenimiento", ""},
				{"V-014", "foto", "Mazda 3", "Mazda", "2025", "$950","Rentado", ""},
				{"V-015", "foto", "Corolla", "Toyota", "2024", "$850","Rentado", ""}
		};
		
		//Creacion de modelo de tabla para poder filtrar y evitar que el usuario edite las columnas diferentes del boton
		DefaultTableModel modeloClientes = new DefaultTableModel(table_content,table_head) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 7; 
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
		            busqueda.setText(""); // Vaciamos la caja
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (busqueda.getText().isEmpty()) {
		            busqueda.setText("Buscar Cliente"); // Restauramos el mensaje
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
		clientes_table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRoundedRenderer(btnPrincipal));
		clientes_table.getColumnModel().getColumn(7).setCellEditor(new ButtonRoundedEditor(new JCheckBox(), btnPrincipal,btnVer,btnEditar,btnEliminar,btnDescargar,"Vehiculos"));
		clientes_table.setRowHeight(40);
		clientes_table.getColumnModel().getColumn(7).setPreferredWidth(60);
		clientes_table.setBackground(Color.decode("#D9D9D9"));
		clientes_table.setShowVerticalLines(false);
		clientes_table.setShowHorizontalLines(true);
		tablaClientes.add(scrollPane, BorderLayout.CENTER);
		
		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < 7; i++) {//Ciclo para aplicar el centrado solo a los campos de datos
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
		VehiculosPanel.add(tablaClientes, gbc);

		return VehiculosPanel;
	}

	public void addVehicle() {
        // Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(720, 500);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
		//Panel sobre el cual se trabajara
		PanelRounded añadirVehiculo = new PanelRounded(10,true,true,true,true);
		añadirVehiculo.setLayout(new BorderLayout());
		añadirVehiculo.setPreferredSize(new Dimension(600,600));
		añadirVehiculo.setBackground(Color.white);
		añadirVehiculo.setOpaque(false);
		ventana.add(añadirVehiculo, BorderLayout.CENTER);
		//Label superior con nombre de pestaña
		JLabel tituloAñadir = new JLabel("Añadir Vehículo");
		tituloAñadir.setOpaque(true);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		tituloAñadir.setBackground(Color.decode("#000D56"));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.PLAIN,25));
		añadirVehiculo.add(tituloAñadir, BorderLayout.NORTH);
		//Panel izq para los datos
		JPanel panelDatosVehiculo = new JPanel();
		panelDatosVehiculo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelDatosVehiculo.setLayout(new BoxLayout(panelDatosVehiculo, BoxLayout.Y_AXIS));
		panelDatosVehiculo.setOpaque(false);
		añadirVehiculo.add(panelDatosVehiculo, BorderLayout.WEST);
		//Label nombre y su respectivo campo de texto
		JLabel marca = new JLabel("Marca");
		marca.setOpaque(false);
		marca.setForeground(Color.black);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(marca);
		
		TextFieldRounded campoMarca = new TextFieldRounded(20,20,true);
		campoMarca.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoMarca.setForeground(Color.decode("#8B8B8B"));
		campoMarca.setOpaque(false);
		campoMarca.setText("Toyota");
		campoMarca.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoMarca.getText().equals("Toyota")) {
		        	campoMarca.setText(""); // Vaciar la caja
		        	campoMarca.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoMarca.getText().isEmpty()) {
		        	campoMarca.setText("Toyota"); // Restaurar el mensaje
		        	campoMarca.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		panelDatosVehiculo.add(campoMarca);
		//Label correo y su respectivo campo de texto
		JLabel modelo = new JLabel("Modelo");
		modelo.setOpaque(false);
		modelo.setForeground(Color.black);
		modelo.setHorizontalAlignment(JLabel.LEFT);
		modelo.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(modelo);
		
		TextFieldRounded campoModelo = new TextFieldRounded(20,20,true);
		campoModelo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoModelo.setForeground(Color.decode("#8B8B8B"));
		campoModelo.setOpaque(false);
		campoModelo.setText("---");
		campoModelo.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoModelo.getText().equals("---")) {
		        	campoModelo.setText(""); // Vaciar la caja
		        	campoModelo.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoModelo.getText().isEmpty()) {
		        	campoModelo.setText("---"); // Restaurar el mensaje
		        	campoModelo.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		panelDatosVehiculo.add(campoModelo);
		//Label telefono y su respectivo campo de texto
		JLabel categoria = new JLabel("Categoria");
		categoria.setOpaque(false);
		categoria.setForeground(Color.black);
		categoria.setHorizontalAlignment(JLabel.LEFT);
		categoria.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(categoria);
		
		TextFieldRounded campoCategoria = new TextFieldRounded(20,20,true);
		campoCategoria.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCategoria.setForeground(Color.decode("#8B8B8B"));
		campoCategoria.setOpaque(false);
		campoCategoria.setText("Sedan");
		campoCategoria.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoCategoria.getText().equals("Sedan")) {
		        	campoCategoria.setText(""); // Vaciar la caja
		        	campoCategoria.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoCategoria.getText().isEmpty()) {
		        	campoCategoria.setForeground(Color.decode("#8B8B8B"));
		        	campoCategoria.setText("Sedan"); // Restaurar el mensaje
		        }
		    }
		});
		panelDatosVehiculo.add(campoCategoria);
		//Panel DER donde colocar el campo de la foto
		JPanel fotoCont = new JPanel();
		fotoCont.setLayout(new BoxLayout(fotoCont, BoxLayout.Y_AXIS));
		fotoCont.setOpaque(false);
		añadirVehiculo.add(fotoCont, BorderLayout.EAST);
		
		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(titulofoto);
		
		//Contorno redondeado
		TextFieldRounded foto = new TextFieldRounded(20,20,true);
		foto.setFont(new Font("Poppins", Font.PLAIN, 15));
		foto.setForeground(Color.decode("#8B8B8B"));
		foto.setOpaque(false);
		foto.setText("Link Foto");
		foto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (foto.getText().equals("Link Foto")) {
					foto.setText(""); // Vaciar la caja
					foto.setForeground(Color.decode("#000000"));
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (foto.getText().isEmpty()) {
					foto.setText("Link Foto"); // Restaurar el mensaje
					foto.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		fotoCont.add(foto);
		
		
		JLabel año = new JLabel("Año");
		año.setOpaque(false);
		año.setForeground(Color.black);
		año.setHorizontalAlignment(JLabel.LEFT);
		año.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(año);
		
		TextFieldRounded campoAño = new TextFieldRounded(20,20,true);
		campoAño.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoAño.setForeground(Color.decode("#8B8B8B"));
		campoAño.setOpaque(false);
		campoAño.setText("---");
		campoAño.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoAño.getText().equals("---")) {
		        	campoAño.setText(""); // Vaciar la caja
		        	campoAño.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoAño.getText().isEmpty()) {
		        	campoAño.setText("---"); // Restaurar el mensaje
		        	campoAño.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		fotoCont.add(campoAño);
		
		JLabel precio = new JLabel("Precio P/Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(precio);
		
		TextFieldRounded campoPrecio = new TextFieldRounded(20,20,true);
		campoPrecio.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoPrecio.setForeground(Color.decode("#8B8B8B"));
		campoPrecio.setOpaque(false);
		campoPrecio.setText("$");
		campoPrecio.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoPrecio.getText().equals("$")) {
		        	campoPrecio.setText(""); // Vaciar la caja
		        	campoPrecio.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoPrecio.getText().isEmpty()) {
		        	campoPrecio.setText("$"); // Restaurar el mensaje
		        	campoPrecio.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		fotoCont.add(campoPrecio);
		
		
		//Panel de botones
		JPanel botonesCont = new JPanel();
		botonesCont.setLayout(new FlowLayout());
		botonesCont.setOpaque(false);
        
		ButtonRounded registrarCliente = new ButtonRounded("Registrar Vehiculo",10,1);
		registrarCliente.setOpaque(false);
		registrarCliente.setForeground(Color.white);
		registrarCliente.setHorizontalAlignment(JLabel.CENTER);
		registrarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCliente.addActionListener(e->{
        	ventana.dispose();
     
		});
		panelDatosVehiculo.add(registrarCliente);
		
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
        	ventana.dispose();
		});
		botonesCont.add(cancelarCliente);
		fotoCont.add(botonesCont,BorderLayout.SOUTH);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void filtrosAvanzados() {
		// Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(720, 500);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
		//Panel sobre el cual se trabajara
		PanelRounded añadirVehiculo = new PanelRounded(10,true,true,true,true);
		añadirVehiculo.setLayout(new BorderLayout());
		añadirVehiculo.setPreferredSize(new Dimension(600,600));
		añadirVehiculo.setBackground(Color.white);
		añadirVehiculo.setOpaque(false);
		ventana.add(añadirVehiculo, BorderLayout.CENTER);
		//Label superior con nombre de pestaña
		JLabel tituloAñadir = new JLabel("Filtros Avanzados - Vehiculos");
		tituloAñadir.setOpaque(true);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		tituloAñadir.setBackground(Color.decode("#000D56"));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.PLAIN,25));
		añadirVehiculo.add(tituloAñadir, BorderLayout.NORTH);
		//Panel izq para los datos
		JPanel panelDatosVehiculo = new JPanel();
		panelDatosVehiculo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelDatosVehiculo.setLayout(new BoxLayout(panelDatosVehiculo, BoxLayout.Y_AXIS));
		panelDatosVehiculo.setOpaque(false);
		añadirVehiculo.add(panelDatosVehiculo, BorderLayout.WEST);
		//Label nombre y su respectivo campo de texto
		JLabel marca = new JLabel("Marca");
		marca.setOpaque(false);
		marca.setForeground(Color.black);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(marca);
		
		TextFieldRounded campoMarca = new TextFieldRounded(20,20,true);
		campoMarca.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoMarca.setForeground(Color.decode("#8B8B8B"));
		campoMarca.setOpaque(false);
		campoMarca.setText("Toyota");
		campoMarca.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoMarca.getText().equals("Toyota")) {
		        	campoMarca.setText(""); // Vaciar la caja
		        	campoMarca.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoMarca.getText().isEmpty()) {
		        	campoMarca.setText("Toyota"); // Restaurar el mensaje
		        	campoMarca.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		panelDatosVehiculo.add(campoMarca);
		//Label correo y su respectivo campo de texto
		JLabel categoria = new JLabel("Categoria");
		categoria.setOpaque(false);
		categoria.setForeground(Color.black);
		categoria.setHorizontalAlignment(JLabel.LEFT);
		categoria.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(categoria);
		
		TextFieldRounded campoCategoria = new TextFieldRounded(20,20,true);
		campoCategoria.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCategoria.setForeground(Color.decode("#8B8B8B"));
		campoCategoria.setOpaque(false);
		campoCategoria.setText("Sedan");
		campoCategoria.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoCategoria.getText().equals("Sedan")) {
		        	campoCategoria.setText(""); // Vaciar la caja
		        	campoCategoria.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoCategoria.getText().isEmpty()) {
		        	campoCategoria.setText("Sedan"); // Restaurar el mensaje
		        	campoCategoria.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		panelDatosVehiculo.add(campoCategoria);
		//Label telefono y su respectivo campo de texto
		JLabel idRenta = new JLabel("ID Renta");
		idRenta.setOpaque(false);
		idRenta.setForeground(Color.black);
		idRenta.setHorizontalAlignment(JLabel.LEFT);
		idRenta.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(idRenta);
		
		TextFieldRounded campoId = new TextFieldRounded(20,20,true);
		campoId.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoId.setForeground(Color.decode("#8B8B8B"));
		campoId.setOpaque(false);
		campoId.setText("Activo/Finalizado");
		campoId.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoId.getText().equals("Activo/Finalizado")) {
		        	campoId.setText(""); // Vaciar la caja
		        	campoId.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoId.getText().isEmpty()) {
		        	campoId.setForeground(Color.decode("#8B8B8B"));
		        	campoId.setText("Activo/Finalizado"); // Restaurar el mensaje
		        }
		    }
		});
		panelDatosVehiculo.add(campoId);
		//Panel DER donde colocar el campo de la foto
		JPanel contDer = new JPanel();
		contDer.setLayout(new BoxLayout(contDer, BoxLayout.Y_AXIS));
		contDer.setOpaque(false);
		añadirVehiculo.add(contDer, BorderLayout.EAST);
		
		JLabel año = new JLabel("Año");
		año.setOpaque(false);
		año.setForeground(Color.black);
		año.setHorizontalAlignment(JLabel.LEFT);
		año.setFont(new Font("Poppins",Font.PLAIN,15));
		contDer.add(año);
		
		TextFieldRounded campoAño = new TextFieldRounded(20,20,true);
		campoAño.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoAño.setForeground(Color.decode("#8B8B8B"));
		campoAño.setOpaque(false);
		campoAño.setText("---");
		campoAño.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoAño.getText().equals("---")) {
		        	campoAño.setText(""); // Vaciar la caja
		        	campoAño.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoAño.getText().isEmpty()) {
		        	campoAño.setText("---"); // Restaurar el mensaje
		        	campoAño.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		contDer.add(campoAño);
		
		JLabel precio = new JLabel("Precio P/Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		contDer.add(precio);
		
		TextFieldRounded campoPrecio = new TextFieldRounded(20,20,true);
		campoPrecio.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoPrecio.setForeground(Color.decode("#8B8B8B"));
		campoPrecio.setOpaque(false);
		campoPrecio.setText("$");
		campoPrecio.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoPrecio.getText().equals("$")) {
		        	campoPrecio.setText(""); // Vaciar la caja
		        	campoPrecio.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoPrecio.getText().isEmpty()) {
		        	campoPrecio.setText("$"); // Restaurar el mensaje
		        	campoPrecio.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		contDer.add(campoPrecio);
		
		
		//Panel de botones
		JPanel botonesCont = new JPanel();
		botonesCont.setLayout(new FlowLayout());
		botonesCont.setOpaque(false);
        
		ButtonRounded registrarCliente = new ButtonRounded("Aplicar Filtros",10,1);
		registrarCliente.setOpaque(false);
		registrarCliente.setForeground(Color.white);
		registrarCliente.setHorizontalAlignment(JLabel.CENTER);
		registrarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCliente.addActionListener(e->{
        	ventana.dispose();
     
		});
		panelDatosVehiculo.add(registrarCliente);
		
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
        	ventana.dispose();
		});
		botonesCont.add(cancelarCliente);
		contDer.add(botonesCont,BorderLayout.SOUTH);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void editVehicle() {

        // Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(720, 500);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
		//Panel sobre el cual se trabajara
		PanelRounded añadirVehiculo = new PanelRounded(10,true,true,true,true);
		añadirVehiculo.setLayout(new BorderLayout());
		añadirVehiculo.setPreferredSize(new Dimension(600,600));
		añadirVehiculo.setBackground(Color.white);
		añadirVehiculo.setOpaque(false);
		ventana.add(añadirVehiculo, BorderLayout.CENTER);
		//Label superior con nombre de pestaña
		JLabel tituloAñadir = new JLabel("Editar Vehículo");
		tituloAñadir.setOpaque(true);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		tituloAñadir.setBackground(Color.decode("#000D56"));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.PLAIN,25));
		añadirVehiculo.add(tituloAñadir, BorderLayout.NORTH);
		//Panel izq para los datos
		JPanel panelDatosVehiculo = new JPanel();
		panelDatosVehiculo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelDatosVehiculo.setLayout(new BoxLayout(panelDatosVehiculo, BoxLayout.Y_AXIS));
		panelDatosVehiculo.setOpaque(false);
		añadirVehiculo.add(panelDatosVehiculo, BorderLayout.WEST);
		//Label nombre y su respectivo campo de texto
		JLabel marca = new JLabel("Marca");
		marca.setOpaque(false);
		marca.setForeground(Color.black);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(marca);
		
		TextFieldRounded campoMarca = new TextFieldRounded(20,20,true);
		campoMarca.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoMarca.setForeground(Color.decode("#8B8B8B"));
		campoMarca.setOpaque(false);
		campoMarca.setText("Toyota");
		campoMarca.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoMarca.getText().equals("Toyota")) {
		        	campoMarca.setText(""); // Vaciar la caja
		        	campoMarca.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoMarca.getText().isEmpty()) {
		        	campoMarca.setText("Toyota"); // Restaurar el mensaje
		        	campoMarca.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		panelDatosVehiculo.add(campoMarca);
		//Label correo y su respectivo campo de texto
		JLabel modelo = new JLabel("Modelo");
		modelo.setOpaque(false);
		modelo.setForeground(Color.black);
		modelo.setHorizontalAlignment(JLabel.LEFT);
		modelo.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(modelo);
		
		TextFieldRounded campoModelo = new TextFieldRounded(20,20,true);
		campoModelo.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoModelo.setForeground(Color.decode("#8B8B8B"));
		campoModelo.setOpaque(false);
		campoModelo.setText("---");
		campoModelo.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoModelo.getText().equals("---")) {
		        	campoModelo.setText(""); // Vaciar la caja
		        	campoModelo.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoModelo.getText().isEmpty()) {
		        	campoModelo.setText("---"); // Restaurar el mensaje
		        	campoModelo.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		panelDatosVehiculo.add(campoModelo);
		//Label telefono y su respectivo campo de texto
		JLabel categoria = new JLabel("Categoria");
		categoria.setOpaque(false);
		categoria.setForeground(Color.black);
		categoria.setHorizontalAlignment(JLabel.LEFT);
		categoria.setFont(new Font("Poppins",Font.PLAIN,15));
		panelDatosVehiculo.add(categoria);
		
		TextFieldRounded campoCategoria = new TextFieldRounded(20,20,true);
		campoCategoria.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCategoria.setForeground(Color.decode("#8B8B8B"));
		campoCategoria.setOpaque(false);
		campoCategoria.setText("Sedan");
		campoCategoria.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoCategoria.getText().equals("Sedan")) {
		        	campoCategoria.setText(""); // Vaciar la caja
		        	campoCategoria.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoCategoria.getText().isEmpty()) {
		        	campoCategoria.setForeground(Color.decode("#8B8B8B"));
		        	campoCategoria.setText("Sedan"); // Restaurar el mensaje
		        }
		    }
		});
		panelDatosVehiculo.add(campoCategoria);
		//Panel DER donde colocar el campo de la foto
		JPanel fotoCont = new JPanel();
		fotoCont.setLayout(new BoxLayout(fotoCont, BoxLayout.Y_AXIS));
		fotoCont.setOpaque(false);
		añadirVehiculo.add(fotoCont, BorderLayout.EAST);
		
		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(titulofoto);
		
		//Contorno redondeado
		TextFieldRounded foto = new TextFieldRounded(20,20,true);
		foto.setFont(new Font("Poppins", Font.PLAIN, 15));
		foto.setForeground(Color.decode("#8B8B8B"));
		foto.setOpaque(false);
		foto.setText("Link Foto");
		foto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (foto.getText().equals("Link Foto")) {
					foto.setText(""); // Vaciar la caja
					foto.setForeground(Color.decode("#000000"));
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (foto.getText().isEmpty()) {
					foto.setText("Link Foto"); // Restaurar el mensaje
					foto.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		fotoCont.add(foto);
		
		
		JLabel año = new JLabel("Año");
		año.setOpaque(false);
		año.setForeground(Color.black);
		año.setHorizontalAlignment(JLabel.LEFT);
		año.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(año);
		
		TextFieldRounded campoAño = new TextFieldRounded(20,20,true);
		campoAño.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoAño.setForeground(Color.decode("#8B8B8B"));
		campoAño.setOpaque(false);
		campoAño.setText("---");
		campoAño.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoAño.getText().equals("---")) {
		        	campoAño.setText(""); // Vaciar la caja
		        	campoAño.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoAño.getText().isEmpty()) {
		        	campoAño.setText("---"); // Restaurar el mensaje
		        	campoAño.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		fotoCont.add(campoAño);
		
		JLabel precio = new JLabel("Precio P/Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCont.add(precio);
		
		TextFieldRounded campoPrecio = new TextFieldRounded(20,20,true);
		campoPrecio.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoPrecio.setForeground(Color.decode("#8B8B8B"));
		campoPrecio.setOpaque(false);
		campoPrecio.setText("$");
		campoPrecio.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoPrecio.getText().equals("$")) {
		        	campoPrecio.setText(""); // Vaciar la caja
		        	campoPrecio.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoPrecio.getText().isEmpty()) {
		        	campoPrecio.setText("$"); // Restaurar el mensaje
		        	campoPrecio.setForeground(Color.decode("#8B8B8B"));
		        }
		    }
		});
		fotoCont.add(campoPrecio);
		
		
		//Panel de botones
		JPanel botonesCont = new JPanel();
		botonesCont.setLayout(new FlowLayout());
		botonesCont.setOpaque(false);
        
		ButtonRounded registrarCliente = new ButtonRounded("Aplicar Cambios",10,1);
		registrarCliente.setOpaque(false);
		registrarCliente.setForeground(Color.white);
		registrarCliente.setHorizontalAlignment(JLabel.CENTER);
		registrarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCliente.addActionListener(e->{
        	ventana.dispose();
     
		});
		panelDatosVehiculo.add(registrarCliente);
		
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
        	ventana.dispose();
		});
		botonesCont.add(cancelarCliente);
		fotoCont.add(botonesCont,BorderLayout.SOUTH);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	
	}

}
