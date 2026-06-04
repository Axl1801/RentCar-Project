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
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import Controllers.ClientController;
import Controllers.VehicleController;
import Models.ClientModel;
import Models.VehicleModel;
import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.ComboBoxRounded;
import Utilities.LabelRounded;
import Utilities.LoadData;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class VehicleView {
	VehicleController control;
	private JTable Vehicle_table;
	private DefaultTableModel modeloVehiculos;
	
	public VehicleView() {
	}
	
	public void setControlador(VehicleController c) {
	    this.control = c;
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
		String[] Ordenamientos = {"TODOS", "Modelo", "Marca", "Año", "Precio", "Estado"};
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

		//Creacion del panel para la tabla de vehiculos
		PanelRounded tablaVehiculos = new PanelRounded(10, true, true, true, true);
		tablaVehiculos.setOpaque(false);
		tablaVehiculos.setVisible(true);
		tablaVehiculos.setBackground(Color.decode("#D9D9D9"));
		tablaVehiculos.setLayout(new BorderLayout());
		//Panel con la tabla de Vehiculos
		
		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"ID","Foto","Modelo","Marca","Año","Precio (Dia)", "Estado","Acciones"};
		
		//Creacion de modelo de tabla para poder filtrar y evitar que el usuario edite las columnas diferentes del boton
		modeloVehiculos = new DefaultTableModel(null,table_head) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 7; 
			}
		};
		
		// Pide la lista al controlador
		ArrayList<VehicleModel> listaClientes = control.obtenerVehiculos();
		// La imprime por fila 
		for (VehicleModel Vehiculo : listaClientes) {
		    Object[] fila = new Object[8];
		    fila[0] = Vehiculo.getIdLetra();
		    fila[1] = Vehiculo.getfoto();
		    fila[2] = Vehiculo.getmodelo();
		    fila[3] = Vehiculo.getmarca();
		    fila[4] = Vehiculo.getanio();
		    fila[5] = Vehiculo.getprecio_dia();
		    fila[6] = Vehiculo.getestado();
		    fila[7] = "";	    
		    modeloVehiculos.addRow(fila);
		}
		//Creacion de la tabla para usuario con el modelo y agregamos el filtrador
		Vehicle_table = new JTable(modeloVehiculos);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloVehiculos);
		Vehicle_table.setRowSorter(sorter);
		
		list.addActionListener(e -> {
		    String seleccion = (String) list.getSelectedItem();
		    
		    switch (seleccion) {
		        case "TODOS":
		            sorter.setSortKeys(null);
		            break;
		        case "Modelo":
		        	sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.DESCENDING)));
		        	break;
		        case "Marca":
		            sorter.setSortKeys(List.of(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
		            break;
		        case "Año":
		            sorter.setSortKeys(List.of(new RowSorter.SortKey(4, SortOrder.DESCENDING)));
		            break;
		        case "Precio":
		            sorter.setSortKeys(List.of(new RowSorter.SortKey(5, SortOrder.DESCENDING)));
		            break;
		        case "Estado":
		            sorter.setSortKeys(List.of(new RowSorter.SortKey(6, SortOrder.DESCENDING)));
		            break;
		    }
		});
		
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
		
		//Agregamos el ActionListener como parametro a la vista de filtros para usarla
		filtros.addActionListener(e->{
			filtrosAvanzados(sorter);
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
		JScrollPane scrollPane = new JScrollPane(Vehicle_table);
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
		Vehicle_table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRoundedRenderer(btnPrincipal));
		Vehicle_table.getColumnModel().getColumn(7).setCellEditor(new ButtonRoundedEditor(new JCheckBox(), btnPrincipal,btnVer,btnEditar,btnEliminar,btnDescargar,"Vehiculos",Vehicle_table, null,control,null));
		Vehicle_table.setRowHeight(40);
		Vehicle_table.getColumnModel().getColumn(7).setPreferredWidth(60);
		Vehicle_table.setBackground(Color.decode("#D9D9D9"));
		Vehicle_table.setShowVerticalLines(false);
		Vehicle_table.setShowHorizontalLines(true);
		tablaVehiculos.add(scrollPane, BorderLayout.CENTER);
		
		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < 7; i++) {//Ciclo para aplicar el centrado solo a los campos de datos
			Vehicle_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		JTableHeader header = Vehicle_table.getTableHeader();
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
		VehiculosPanel.add(tablaVehiculos, gbc);

		return VehiculosPanel;
	}

	public void addVehicle() {
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
		PanelRounded añadirVehiculo = new PanelRounded(20,true,true,true,true);
		añadirVehiculo.setLayout(null);
		añadirVehiculo.setSize(700,600);
		añadirVehiculo.setLocation(610,240);
		añadirVehiculo.setBackground(Color.white);
		añadirVehiculo.setOpaque(false);
		ventana.add(añadirVehiculo);
		//Label superior con nombre de pestaña
		LabelRounded tituloAñadir = new LabelRounded("AÑADIR VEHICULO",20,Color.decode("#000D56"));
		tituloAñadir.setOpaque(false);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.BOLD,25));
		tituloAñadir.setSize(700,100);
		tituloAñadir.setLocation(0, 0);
		añadirVehiculo.add(tituloAñadir);

		//Label nombre y su respectivo campo de texto
		JLabel marca = new JLabel("Marca");
		marca.setOpaque(false);
		marca.setForeground(Color.black);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setFont(new Font("Poppins",Font.PLAIN,15));
		marca.setSize(70,25);
		marca.setLocation(50,130);
		añadirVehiculo.add(marca);
		
		String[] marcas = {"Elegir", "Chevrolet Ford", "Honda", "Hyundai","Jeep","Kia","Land Rover", "Mazda", "Mercedes-Benz", "BMW",
				"Nissan", "Subaru", "Suzuki","Toyota","Volkswagen"};
		ComboBoxRounded<String> listMarcas = new ComboBoxRounded<>(marcas);
		listMarcas.setFont(new Font("Poppins", Font.BOLD, 15));
		listMarcas.setForeground(Color.black);
		listMarcas.setOpaque(false);
		listMarcas.setSize(280,40);
		listMarcas.setLocation(50,160);
		añadirVehiculo.add(listMarcas);
		
		//Label correo y su respectivo campo de texto
		JLabel modelo = new JLabel("Modelo");
		modelo.setOpaque(false);
		modelo.setForeground(Color.black);
		modelo.setHorizontalAlignment(JLabel.LEFT);
		modelo.setFont(new Font("Poppins",Font.PLAIN,15));
		modelo.setSize(70,25);
		modelo.setLocation(50,230);
		añadirVehiculo.add(modelo);
		
		String[] modelos = {"Elegir", "Chevrolet Express Passebger", "Bronco Sport", "Ford Transit","Honda Accord","Honda Civic",
				"Honda CR-V", "Honda Fit", "Honda Oddyssey", "Honda Pilot",
				"Hyundai Accent", "Hyundai Elantra", "Jeep Renegade","Jeep Wrangler","Kia K4",
				"Kia Rio","Land Rover Defender 110","Mazda 3","Mazda CX-5","Mercedes-Benz Vito Tourer","Mini Cooper 5 Door",
				"Nissan Centra","Nissan Versa","Subaru Forester","Suzuki Jimny","Toyota Camry","Toyota Corolla","Toyota RAV4","Volkswagen Jetta"};
		ComboBoxRounded<String> listModeloss = new ComboBoxRounded<>(modelos);
		listModeloss.setFont(new Font("Poppins", Font.BOLD, 15));
		listModeloss.setForeground(Color.black);
		listModeloss.setOpaque(false);
		listModeloss.setSize(280,40);
		listModeloss.setLocation(50,260);
		añadirVehiculo.add(listModeloss);
		
		//Label telefono y su respectivo campo de texto
		JLabel categoria = new JLabel("Categoria");
		categoria.setOpaque(false);
		categoria.setForeground(Color.black);
		categoria.setHorizontalAlignment(JLabel.LEFT);
		categoria.setFont(new Font("Poppins",Font.PLAIN,15));
		categoria.setSize(70,25);
		categoria.setLocation(50,330);
		añadirVehiculo.add(categoria);
		
		String[] categorias = {"Sedan", "SUV", "4X4", "Sport","HatchBack","Pick Up","Monovolumen", "Minivan", "Crossover", "Convertible"};
		ComboBoxRounded<String> listCategorias = new ComboBoxRounded<>(categorias);
		listCategorias.setFont(new Font("Poppins", Font.BOLD, 15));
		listCategorias.setForeground(Color.black);
		listCategorias.setOpaque(false);
		listCategorias.setSize(280,40);
		listCategorias.setLocation(50,360);
		añadirVehiculo.add(listCategorias);
		
		JLabel titulofoto = new JLabel("foto");
		titulofoto.setOpaque(false);
		titulofoto.setForeground(Color.black);
		titulofoto.setHorizontalAlignment(JLabel.LEFT);
		titulofoto.setFont(new Font("Poppins",Font.PLAIN,15));
		titulofoto.setSize(70,25);
		titulofoto.setLocation(370,130);
		añadirVehiculo.add(titulofoto);
		
		//Contorno redondeado 280 40 400 160
		TextFieldRounded campoFoto = new TextFieldRounded(20,20,true);
		campoFoto.setFont(new Font("Poppins", Font.BOLD, 15));
		campoFoto.setForeground(Color.decode("#8B8B8B"));
		campoFoto.setOpaque(false);
		campoFoto.setText("URL foto del Automovil");
		campoFoto.setSize(280,40);
		campoFoto.setLocation(370,160);
		campoFoto.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // Cuando el usuario hace clic en la caja
		        if (campoFoto.getText().equals("URL foto del Automovil")) {
		        	campoFoto.setText(""); // Vaciar la caja
		        	campoFoto.setForeground(Color.decode("#000000"));
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Cuando el usuario hace clic en otro lado
		        if (campoFoto.getText().isEmpty()) {
		        	campoFoto.setForeground(Color.decode("#8B8B8B"));
		        	campoFoto.setText("URL foto del Automovil"); // Restaurar el mensaje
		        }
		    }
		});
		añadirVehiculo.add(campoFoto);
		
		JLabel tituloAño = new JLabel("Año");
		tituloAño.setOpaque(false);
		tituloAño.setForeground(Color.black);
		tituloAño.setHorizontalAlignment(JLabel.LEFT);
		tituloAño.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloAño.setSize(70,25);
		tituloAño.setLocation(370,230);
		añadirVehiculo.add(tituloAño);
		
		String[] años = {"2025", "2024", "2023", "2022","2021","2020","2019", "2018", "2017", "2016", "2015"};
		ComboBoxRounded<String> listAños = new ComboBoxRounded<>(años);
		listAños.setFont(new Font("Poppins", Font.BOLD, 15));
		listAños.setForeground(Color.black);
		listAños.setOpaque(false);
		listAños.setSize(280,40);
		listAños.setLocation(370,260);
		añadirVehiculo.add(listAños);
		
		JLabel precio = new JLabel("Precio P/Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		precio.setSize(70,25);
		precio.setLocation(370,330);
		añadirVehiculo.add(precio);
		
		String[] precios = {"$", "750", "850", "950","1200","1500","1800", "2000"};
		ComboBoxRounded<String> listPrecios = new ComboBoxRounded<>(precios);
		listPrecios.setFont(new Font("Poppins", Font.BOLD, 15));
		listPrecios.setForeground(Color.black);
		listPrecios.setOpaque(false);
		listPrecios.setSize(280,40);
		listPrecios.setLocation(370,360);
		añadirVehiculo.add(listPrecios);
		
		//Botones
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
		añadirVehiculo.add(cancelarCliente);
		
		ButtonRounded registrarVehiculo = new ButtonRounded("Registrar Vehiculo",10,1);
		registrarVehiculo.setOpaque(false);
		registrarVehiculo.setForeground(Color.white);
		registrarVehiculo.setHorizontalAlignment(JLabel.CENTER);
		registrarVehiculo.setFont(new Font("Poppins",Font.BOLD,15));
		registrarVehiculo.addActionListener(e->{
        	ventana.dispose();
		});
		registrarVehiculo.setSize(200,60);
		registrarVehiculo.setLocation(350,500);
		añadirVehiculo.add(registrarVehiculo);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void filtrosAvanzados(TableRowSorter<DefaultTableModel> sorter) {
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
		PanelRounded filtrosAvanzados = new PanelRounded(20,true,true,true,true);
		filtrosAvanzados.setLayout(null);
		filtrosAvanzados.setSize(700,600);
		filtrosAvanzados.setLocation(610,240);
		filtrosAvanzados.setBackground(Color.white);
		filtrosAvanzados.setOpaque(false);
		ventana.add(filtrosAvanzados);
		//Label superior con nombre de pestaña
		LabelRounded tituloFiltros = new LabelRounded("FILTROS AVANZADOS - VEHICULOS",20,Color.decode("#000D56"));
		tituloFiltros.setOpaque(false);
		tituloFiltros.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloFiltros.setForeground(Color.WHITE);
		tituloFiltros.setHorizontalAlignment(JLabel.LEFT);
		tituloFiltros.setFont(new Font("Poppins",Font.BOLD,25));
		tituloFiltros.setSize(700,100);
		tituloFiltros.setLocation(0, 0);
		filtrosAvanzados.add(tituloFiltros);

		//Label nombre y su respectivo campo de texto
		JLabel marca = new JLabel("Marca");
		marca.setOpaque(false);
		marca.setForeground(Color.black);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setFont(new Font("Poppins",Font.PLAIN,15));
		marca.setSize(70,25);
		marca.setLocation(50,130);
		filtrosAvanzados.add(marca);
		
		String[] marcas = {"Todos", "Chevrolet","Ford", "Honda", "Hyundai","Jeep","Kia","Land Rover", "Mazda", "Mercedes-Benz", "BMW",
				"Nissan", "Subaru", "Suzuki","Toyota","Volkswagen"};
		ComboBoxRounded<String> listMarcas = new ComboBoxRounded<>(marcas);
		listMarcas.setFont(new Font("Poppins", Font.BOLD, 15));
		listMarcas.setForeground(Color.black);
		listMarcas.setOpaque(false);
		listMarcas.setSize(280,40);
		listMarcas.setLocation(50,160);
		filtrosAvanzados.add(listMarcas);
		
		//Label telefono y su respectivo campo de texto
		JLabel modelo = new JLabel("Modelo");
		modelo.setOpaque(false);
		modelo.setForeground(Color.black);
		modelo.setHorizontalAlignment(JLabel.LEFT);
		modelo.setFont(new Font("Poppins",Font.PLAIN,15));
		modelo.setSize(70,25);
		modelo.setLocation(50,230);
		filtrosAvanzados.add(modelo);
		
		String[] modelos = {"Todos", "Chevrolet","Ford", "Honda", "Hyundai","Jeep","Kia","Land Rover", "Mazda", "Mercedes-Benz", "BMW",
				"Nissan", "Subaru", "Suzuki","Toyota","Volkswagen"};
		ComboBoxRounded<String> listModelos = new ComboBoxRounded<>(modelos);
		listModelos.setFont(new Font("Poppins", Font.BOLD, 15));
		listModelos.setForeground(Color.black);
		listModelos.setOpaque(false);
		listModelos.setSize(280,40);
		listModelos.setLocation(50,260);
		filtrosAvanzados.add(listModelos);
		
		//Label telefono y su respectivo campo de texto
		JLabel estado = new JLabel("Estado");
		estado.setOpaque(false);
		estado.setForeground(Color.black);
		estado.setHorizontalAlignment(JLabel.LEFT);
		estado.setFont(new Font("Poppins",Font.PLAIN,15));
		estado.setSize(70,25);
		estado.setLocation(50,330);
		filtrosAvanzados.add(estado);
		
		String[] Estados = {"Todos","Activo ", "Finalizado", "Rentado", "En mantenimiento","Disponible"};
		ComboBoxRounded<String> listEstados= new ComboBoxRounded<>(Estados);
		listEstados.setFont(new Font("Poppins", Font.BOLD, 15));
		listEstados.setForeground(Color.black);
		listEstados.setOpaque(false);
		listEstados.setSize(280,40);
		listEstados.setLocation(50,360);
		filtrosAvanzados.add(listEstados);
		
		JLabel tituloAño = new JLabel("Año");
		tituloAño.setOpaque(false);
		tituloAño.setForeground(Color.black);
		tituloAño.setHorizontalAlignment(JLabel.LEFT);
		tituloAño.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloAño.setSize(70,25);
		tituloAño.setLocation(370,130);
		filtrosAvanzados.add(tituloAño);
		
		String[] años = {"Todos","2025", "2024", "2023", "2022","2021","2020","2019", "2018", "2017", "2016", "2015"};
		ComboBoxRounded<String> listAños = new ComboBoxRounded<>(años);
		listAños.setFont(new Font("Poppins", Font.BOLD, 15));
		listAños.setForeground(Color.black);
		listAños.setOpaque(false);
		listAños.setSize(280,40);
		listAños.setLocation(370,160);
		filtrosAvanzados.add(listAños);
		
		JLabel precio = new JLabel("Precio P/Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		precio.setSize(150,25);
		precio.setLocation(370,230);
		filtrosAvanzados.add(precio);
		
		String[] preciosMin= {"00.00", "75.00", "85.0", "95.0","120.00","150.00","180.00", "200.00"	};
		ComboBoxRounded<String> listPreciosMin = new ComboBoxRounded<>(preciosMin);
		listPreciosMin.setFont(new Font("Poppins", Font.BOLD, 15));
		listPreciosMin.setForeground(Color.black);
		listPreciosMin.setOpaque(false);
		listPreciosMin.setSize(120,40);
		listPreciosMin.setLocation(370,260);
		filtrosAvanzados.add(listPreciosMin);
		
		String[] preciosMax = {"00.00", "75.00", "85.0", "95.0","120.00","150.00","180.00", "200.00"};
		ComboBoxRounded<String> listPreciosMax = new ComboBoxRounded<>(preciosMax);
		listPreciosMax.setFont(new Font("Poppins", Font.BOLD, 15));
		listPreciosMax.setForeground(Color.black);
		listPreciosMax.setOpaque(false);
		listPreciosMax.setSize(120,40);
		listPreciosMax.setLocation(510,260);
		filtrosAvanzados.add(listPreciosMax);
		
		//Botones
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
		filtrosAvanzados.add(cancelarCliente);
		
		ButtonRounded aplicarFiltros = new ButtonRounded("Aplicar Filtros",10,1);
		aplicarFiltros.setOpaque(false);
		aplicarFiltros.setForeground(Color.white);
		aplicarFiltros.setHorizontalAlignment(JLabel.CENTER);
		aplicarFiltros.setFont(new Font("Poppins",Font.BOLD,20));
		aplicarFiltros.setHorizontalTextPosition(JLabel.RIGHT);
		aplicarFiltros.addActionListener(e->{
			
			List<RowFilter<Object, Object>> filtros = new ArrayList<>();
			String Fmodelos = listModelos.getSelectedItem().toString();
			String Fmarca = listMarcas.getSelectedItem().toString();
			String Festados = listEstados.getSelectedItem().toString();
			String Faños = listAños.getSelectedItem().toString();
			BigDecimal min = new BigDecimal(listPreciosMin.getSelectedItem().toString());
			BigDecimal max = new BigDecimal(listPreciosMax.getSelectedItem().toString());
			final BigDecimal precioMin = new BigDecimal(listPreciosMin.getSelectedItem().toString());
			final BigDecimal precioMax =  new BigDecimal(listPreciosMax.getSelectedItem().toString());
			
			/*if (!Fmodelos.equals("Todos")) {
			    filtros.add(
			        RowFilter.regexFilter(
			            "^" + Pattern.quote(Fmodelos) + "$",
			            2
			        )
			    );
			}*/
			if (!Fmarca.equals("Todos")) {
			    filtros.add(
			        RowFilter.regexFilter(
			            "^" + Pattern.quote(Fmarca) + "$",
			            3
			        )
			    );
			}
			if (!Faños.equals("Todos")) {
			    filtros.add(
			        RowFilter.regexFilter(
			            "^" + Pattern.quote(Faños) + "$",
			            4
			        )
			    );
			}
			if (!Festados.equals("Todos")) {
				filtros.add(
						RowFilter.regexFilter(
								"^" + Pattern.quote(Festados) + "$",
								6
								)
						);
			}
			
			filtros.add(new RowFilter<Object, Object>() {
				
			    @Override
			    public boolean include(
			            Entry<? extends Object,
			            ? extends Object> entry) {

			    	BigDecimal precio = (BigDecimal) entry.getValue(5);

			        boolean cumpleMin =  min.compareTo(BigDecimal.ZERO) == 0 || precio.compareTo(precioMin) >= 0;

			        boolean cumpleMax =  max.compareTo(BigDecimal.ZERO) == 0 || precio.compareTo(precioMax) <= 0;
			        
			        return cumpleMin && cumpleMax;
			    }
			});
			sorter.setRowFilter(RowFilter.andFilter(filtros));
        	ventana.dispose();
		});
		aplicarFiltros.setSize(200,60);
		aplicarFiltros.setLocation(350,500);
        URL url = getClass().getResource("/iconos/adicionales/buscar.png");//Carga ubi imagen
	    
	    if (url != null) {
	    	aplicarFiltros.setIcon(new ImageIcon(url));
	    }
	    filtrosAvanzados.add(aplicarFiltros);
		
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void editVehicle(int idVehiculo,String marcaActual,String modeloActual,String categoriaActual,String estadoActual,String añoActual,BigDecimal precioActual) {
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
		PanelRounded añadirVehiculo = new PanelRounded(20,true,true,true,true);
		añadirVehiculo.setLayout(null);
		añadirVehiculo.setSize(700,600);
		añadirVehiculo.setLocation(610,240);
		añadirVehiculo.setBackground(Color.white);
		añadirVehiculo.setOpaque(false);
		ventana.add(añadirVehiculo);
		//Label superior con nombre de pestaña
		LabelRounded tituloAñadir = new LabelRounded("EDITAR VEHICULO",20,Color.decode("#000D56"));
		tituloAñadir.setOpaque(false);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.BOLD,25));
		tituloAñadir.setSize(700,100);
		tituloAñadir.setLocation(0, 0);
		añadirVehiculo.add(tituloAñadir);
		//Label nombre y su respectivo campo de texto
		JLabel marca = new JLabel("Marca");
		marca.setOpaque(false);
		marca.setForeground(Color.black);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setFont(new Font("Poppins",Font.PLAIN,15));
		marca.setSize(70,25);
		marca.setLocation(50,130);
		añadirVehiculo.add(marca);
		
		ComboBoxRounded<String> listMarcas = new ComboBoxRounded<>();
		listMarcas.setFont(new Font("Poppins", Font.BOLD, 15));
		listMarcas.setForeground(Color.black);
		listMarcas.setOpaque(false);
		listMarcas.setSize(280,40);
		listMarcas.setLocation(50,160);
		añadirVehiculo.add(listMarcas);
		
		//Label correo y su respectivo campo de texto
		JLabel modelo = new JLabel("Modelo");
		modelo.setOpaque(false);
		modelo.setForeground(Color.black);
		modelo.setHorizontalAlignment(JLabel.LEFT);
		modelo.setFont(new Font("Poppins",Font.PLAIN,15));
		modelo.setSize(70,25);
		modelo.setLocation(50,230);
		añadirVehiculo.add(modelo);
		
		ComboBoxRounded<String> listModelos = new ComboBoxRounded<>();
		listModelos.setFont(new Font("Poppins", Font.BOLD, 15));
		listModelos.setForeground(Color.black);
		listModelos.setOpaque(false);
		listModelos.setSize(280,40);
		listModelos.setLocation(50,260);
		añadirVehiculo.add(listModelos);
		
		//Label telefono y su respectivo campo de texto
		JLabel categoria = new JLabel("Categoria");
		categoria.setOpaque(false);
		categoria.setForeground(Color.black);
		categoria.setHorizontalAlignment(JLabel.LEFT);
		categoria.setFont(new Font("Poppins",Font.PLAIN,15));
		categoria.setSize(70,25);
		categoria.setLocation(50,330);
		añadirVehiculo.add(categoria);
		
		ComboBoxRounded<String> listCategorias = new ComboBoxRounded<>();
		listCategorias.setFont(new Font("Poppins", Font.BOLD, 15));
		listCategorias.setForeground(Color.black);
		listCategorias.setOpaque(false);
		listCategorias.setSize(280,40);
		listCategorias.setLocation(50,360);
		añadirVehiculo.add(listCategorias);
		
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setOpaque(false);
		tituloEstado.setForeground(Color.black);
		tituloEstado.setHorizontalAlignment(JLabel.LEFT);
		tituloEstado.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloEstado.setSize(70,25);
		tituloEstado.setLocation(370,130);
		añadirVehiculo.add(tituloEstado);
		
		//Contorno redondeado 280 40 400 160
		ComboBoxRounded<String> listEstado = new ComboBoxRounded<>();
		listEstado.setFont(new Font("Poppins", Font.BOLD, 15));
		listEstado.setForeground(Color.decode("#000000"));
		listEstado.setOpaque(false);
		listEstado.setSize(280,40);
		listEstado.setLocation(370,160);
		añadirVehiculo.add(listEstado);
		
		JLabel tituloAño = new JLabel("Año");
		tituloAño.setOpaque(false);
		tituloAño.setForeground(Color.black);
		tituloAño.setHorizontalAlignment(JLabel.LEFT);
		tituloAño.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloAño.setSize(70,25);
		tituloAño.setLocation(370,230);
		añadirVehiculo.add(tituloAño);
		
		ComboBoxRounded<String> listAños = new ComboBoxRounded<>();
		listAños.setFont(new Font("Poppins", Font.BOLD, 15));
		listAños.setForeground(Color.black);
		listAños.setOpaque(false);
		listAños.setSize(280,40);
		listAños.setLocation(370,260);
		añadirVehiculo.add(listAños);
		
		JLabel precio = new JLabel("Precio P/Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		precio.setSize(100,25);
		precio.setLocation(370,330);
		añadirVehiculo.add(precio);
		
		ComboBoxRounded<BigDecimal> listPrecios = new ComboBoxRounded<>();
		listPrecios.setFont(new Font("Poppins", Font.BOLD, 15));
		listPrecios.setForeground(Color.black);
		listPrecios.setOpaque(false);
		listPrecios.setSize(280,40);
		listPrecios.setLocation(370,360);
		añadirVehiculo.add(listPrecios);
		
		//Botones
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
		añadirVehiculo.add(cancelarCliente);
		
		//Prellenar campos con datos actuales y eviar que se puedan modificar
		listMarcas.addItem(marcaActual);
		listMarcas.setBloqueado(true);
		listModelos.addItem(modeloActual);
		listModelos.setBloqueado(true);
		listCategorias.addItem(categoriaActual);
		listCategorias.setBloqueado(true);
		listAños.addItem(añoActual);
		listAños.setBloqueado(true);
		listEstado.addItem(estadoActual);
		listPrecios.addItem(precioActual);
		
		ButtonRounded registrarVehiculo = new ButtonRounded("Aplicar Cambios",10,1);
		registrarVehiculo.setOpaque(false);
		registrarVehiculo.setForeground(Color.white);
		registrarVehiculo.setHorizontalAlignment(JLabel.CENTER);
		registrarVehiculo.setFont(new Font("Poppins",Font.BOLD,20));
		registrarVehiculo.addActionListener(e->{
			String nuevoEstado = listEstado.getSelectedItem().toString();
			BigDecimal nuevoPrecio = (BigDecimal)listPrecios.getSelectedItem();
			
			control.update(idVehiculo,nuevoPrecio, nuevoEstado);
			LoadData.refreshTable(Vehicle_table, modeloVehiculos, control.obtenerVehiculos());
        	ventana.dispose();
		});
		registrarVehiculo.setSize(200,60);
		registrarVehiculo.setLocation(350,500);
		añadirVehiculo.add(registrarVehiculo);
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	}

	public void historialVehiculos(int idVehiculo) {
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
		
		LabelRounded etiquetaHistorial = new LabelRounded("HISTORIAL DEL VEHICULO", 10, Color.decode("#000D56"));
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
		panelOrdenar.setBounds(1300, 100, 150, 50);
		panelOrdenar.setBorder(null);
		panelOrdenar.setLayout(new BorderLayout());
		detallesCliente.add(panelOrdenar);
		
		//Creacion de un arreglo para introducir cada copcion dentro de un ComboBox
		String[] Ordenamientos = {"TODOS", "ID Renta", "Nombre", "Fecha Inicio", "Fecha fin", "Estado"};
		ComboBoxRounded<String> list = new ComboBoxRounded<>(Ordenamientos);
		//Personalizacion del comboBox
		list.setFont(new Font("Poppins", Font.BOLD, 15));
		panelOrdenar.add(list, BorderLayout.CENTER);
		
		//Panel para filtros avanzados
		PanelRounded panelFiltros = new PanelRounded(10, true, true, true, true);
		panelFiltros.setOpaque(false);
		panelFiltros.setBounds(1500, 100, 120, 50);
		panelFiltros.setBackground(Color.decode("#AFAFAF"));
		panelFiltros.setBorder(null);
		panelFiltros.setLayout(new BorderLayout());
		detallesCliente.add(panelFiltros);
		//Creacion boton filtros con icono
		ButtonRounded filtros = new ButtonRounded("Filtros",10,4);
        URL url = getClass().getResource("/iconos/adicionales/filtros.png");//Carga ubi imagen
	    
	    if (url != null) {
	    	filtros.setIcon(new ImageIcon(url));
	    }
	    //Personalizacion
	    filtros.setPreferredSize(new Dimension(60,30));
		filtros.setFont(new Font("Poppins",Font.BOLD,15));
		filtros.setHorizontalAlignment(JLabel.CENTER);  
		filtros.setIconTextGap(10);                      
		filtros.setHorizontalTextPosition(JLabel.LEFT);
		panelFiltros.add(filtros, BorderLayout.CENTER);
		
		PanelRounded panelTabla = new PanelRounded(10, true, true, true, true);
		panelTabla.setOpaque(false);
		panelTabla.setBounds(100, 180, 1520, 700);
		panelTabla.setBackground(Color.white);
		panelTabla.setBorder(null);
		panelTabla.setLayout(new BorderLayout());
		detallesCliente.add(panelTabla);
		
		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"ID Renta","Nombre","Feha Inicio","Fecha Fin","Estado"};

		DefaultTableModel modeloVehiculo = new DefaultTableModel(null,table_head){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Ninguna celda será editable
		    }
		};
		ArrayList<VehicleModel> listaVehiculos = control.obtenerRentasVehiculo(idVehiculo);
		for (VehicleModel Verhiculo : listaVehiculos) {
			Object[] fila = new Object[5];
			fila[0] = Verhiculo.getIdLetraRenta();
			fila[1] = Verhiculo.getName();
			fila[2] = Verhiculo.getInicio_renta();
			fila[3] = Verhiculo.getFin_renta();
			fila[4] = Verhiculo.getestado();
			
	    
			modeloVehiculo.addRow(fila);
		}
		
		//Creacion de la tabla para usuario con el modelo y agregamos el filtrador
		JTable clientes_table = new JTable(modeloVehiculo);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloVehiculo);
		clientes_table.setRowSorter(sorter);
		
		list.addActionListener(e -> {
		    String seleccion = (String) list.getSelectedItem();
		    
		    switch (seleccion) {
	        case "TODOS":
	            sorter.setSortKeys(null);
	            break;
	        case "ID Renta":
	        	sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
	        	break;
	        case "Nombre":
	        	sorter.setSortKeys(List.of(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
	        	break;
	        case "Fecha inicio":
	            sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
	            break;
	        case "Fecha fin":
	            sorter.setSortKeys(List.of(new RowSorter.SortKey(3, SortOrder.DESCENDING)));
	            break;
	        case "Estado":
	            sorter.setSortKeys(List.of(new RowSorter.SortKey(4, SortOrder.DESCENDING)));
	            break;
	    }
	});
		
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
