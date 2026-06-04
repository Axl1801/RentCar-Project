package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import Controllers.RentController;
import Controllers.VehicleController;
import Models.RentModel;
import Models.VehicleModel;
import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.ComboBoxRounded;
import Utilities.DatePickerRounded;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class RentView {
	RentController control;
	private JTable Rent_table;
	private DefaultTableModel modeloRentas;
	private byte[] fotoSeleccionada;
	public RentView(){
		
	}
	
	public void setControlador(RentController c) {
	    this.control = c;
	}
	
	public JPanel Rent() {
		JPanel RentPanel = new JPanel();
		RentPanel.setOpaque(true);
		RentPanel.setBackground(Color.decode("#EAEAEA"));
		RentPanel.setVisible(true);
		RentPanel.setLayout(new GridBagLayout());

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
		RentPanel.add(totalVehiculos, gbc);
		RentPanel.add(totalVehiculos, gbc);

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
		RentPanel.add(totalDisponibles, gbc);

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
		RentPanel.add(totalRentados, gbc);

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
		RentPanel.add(totalMantenimiento, gbc);
		
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
		RentPanel.add(barraBusqueda, gbc);
		
		//Panel para el ordenamiento
		PanelRounded panelOrdenar = new PanelRounded(10, true, true, true, true);
		panelOrdenar.setOpaque(false);
		panelOrdenar.setVisible(true);
		panelOrdenar.setBackground(Color.white);
		panelOrdenar.setBorder(null);
		panelOrdenar.setLayout(new BorderLayout());
		
		//Creacion de un arreglo para introducir cada copcion dentro de un ComboBox
		String[] Ordenamientos = {"TODOS", "Cliente", "Vehiculo", "Inicio(DSC)", "Fin(DSC)","Estado"};
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
		RentPanel.add(panelOrdenar, gbc);
		
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
		RentPanel.add(panelFiltros, gbc);
		
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
		ButtonRounded añadirRenta = new ButtonRounded("Añadir Renta",10,1);
		añadirRenta.setOpaque(false);
		añadirRenta.setBackground(Color.decode("#000D56"));
		añadirRenta.setForeground(Color.white);
		añadirRenta.setFont(new Font("Poppins",Font.BOLD,20));
		añadirRenta.addActionListener(e->{
			addRent();
		});
		añadirRenta.setIcon(añadirEscalada);
		//Posicionamiento del boton en el GridBagLayout
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10, 20, 10, 20);
		RentPanel.add(añadirRenta, gbc);
		
		//Creacion del panel para la tabla de clientes
		PanelRounded tablaRentas = new PanelRounded(10, true, true, true, true);
		tablaRentas.setOpaque(false);
		tablaRentas.setVisible(true);
		tablaRentas.setBackground(Color.decode("#D9D9D9"));
		tablaRentas.setLayout(new BorderLayout());
		
		//Creacion de un arreglo de opciones  para los apartados de una tabla
		Object [] table_head = {"ID","Cliente","Vehiculo","Foto","Inicio","Fin", "Estado","Acciones"};

		//Creacion de modelo de tabla para poder filtrar y evitar que el usuario edite las columnas diferentes del boton
		modeloRentas = new DefaultTableModel(null,table_head) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 7; 
		          
		    }
			
			@Override
			public Class<?> getColumnClass(int column) {

			    if (getRowCount() > 0) {
			        Object value = getValueAt(0, column);

			        if (value != null) {
			            return value.getClass();
			        }
			    }

			    return Object.class;
			}
		};
		
		// Pide la lista al controlador
		ArrayList<RentModel> listaRentas = control.obtenerRentas();
		//ArrayList<RentModel> listaRentas = control;
		for (RentModel Renta : listaRentas) {
		    Object[] fila = new Object[8];
		    fila[0] = Renta.getIdLetra();
		    fila[1] = Renta.getnameCliente();
		    fila[2] = Renta.getId_vehiculo();
		    fila[3] = Renta.getfoto();
		    fila[4] = Renta.getInicio_renta();
		    fila[5] = Renta.getFin_renta();
		    fila[6] = Renta.getEstado();
		    fila[7] = "";	    
		    modeloRentas.addRow(fila);
		}
		//Creacion de la tabla para usuario con el modelo y agregamos el filtrador
		Rent_table = new JTable(modeloRentas);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloRentas);
		Rent_table.setRowSorter(sorter);
		Rent_table.setRowHeight(60);
		
		Rent_table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				
				JLabel etiquetaCelda = new JLabel();
				etiquetaCelda.setHorizontalAlignment(JLabel.CENTER);

				if (isSelected) {
					etiquetaCelda.setBackground(table.getSelectionBackground());
					etiquetaCelda.setOpaque(true);
				}

				if (value != null && value instanceof byte[]) {
					byte[] bytesFoto = (byte[]) value;
					ImageIcon iconoOriginal = new ImageIcon(bytesFoto);
					Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
					etiquetaCelda.setIcon(new ImageIcon(imagenEscalada));
					etiquetaCelda.setText(""); 
				} else {
					etiquetaCelda.setIcon(null);
					etiquetaCelda.setText("Sin foto");
				}

				return etiquetaCelda;
			}
		});
				
		list.addActionListener(e -> {
		    String seleccion = (String) list.getSelectedItem();
		    
		    switch (seleccion) {
		        case "TODOS":
		            sorter.setSortKeys(null);
		            break;
		        case "Cliente":
		        	sorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.DESCENDING)));
		        	break;
		        case "Vehiculo":
		            sorter.setSortKeys(List.of(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
		            break;
		        case "Inicio(DSC)":
		            sorter.setSortKeys(List.of(new RowSorter.SortKey(4, SortOrder.DESCENDING)));
		            break;
		        case "Fin(DSC)":
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
		JScrollPane scrollPane = new JScrollPane(Rent_table);
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
		Rent_table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRoundedRenderer(btnPrincipal));
		Rent_table.getColumnModel().getColumn(7).setCellEditor(new ButtonRoundedEditor(new JCheckBox(), btnPrincipal,btnVer,btnEditar,btnEliminar,btnDescargar,"Rentas",Rent_table, null,null,control));
		Rent_table.setRowHeight(40);
		Rent_table.getColumnModel().getColumn(7).setPreferredWidth(60);
		Rent_table.setBackground(Color.decode("#D9D9D9"));
		Rent_table.setShowVerticalLines(false);
		Rent_table.setShowHorizontalLines(true);
		tablaRentas.add(scrollPane, BorderLayout.CENTER);
		
		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < 7; i++) {//Ciclo para aplicar el centrado solo a los campos de datos
			if (i != 3) {
			Rent_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
		}
		JTableHeader header = Rent_table.getTableHeader();
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
		RentPanel.add(tablaRentas, gbc);

		return RentPanel;
	}

	public void addRent() {
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
		PanelRounded añadirRenta = new PanelRounded(20,true,true,true,true);
		añadirRenta.setLayout(null);
		añadirRenta.setSize(700,900);
		añadirRenta.setLocation(610,100);
		añadirRenta.setBackground(Color.white);
		añadirRenta.setOpaque(false);
		ventana.add(añadirRenta);
		//Label superior con nombre de pestaña
		LabelRounded tituloAñadir = new LabelRounded("AÑADIR RENTA",20,Color.decode("#000D56"));
		tituloAñadir.setOpaque(false);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.BOLD,25));
		tituloAñadir.setSize(700,100);
		tituloAñadir.setLocation(0, 0);
		añadirRenta.add(tituloAñadir);

		//Label nombre y su respectivo campo de texto
		JLabel cliente = new JLabel("Cliente");
		cliente.setOpaque(false);
		cliente.setForeground(Color.black);
		cliente.setHorizontalAlignment(JLabel.LEFT);
		cliente.setFont(new Font("Poppins",Font.PLAIN,15));
		cliente.setSize(70,25);
		cliente.setLocation(50,130);
		añadirRenta.add(cliente);
		
		ArrayList<String> Clientes = control.getNombresClientes();
		ComboBoxRounded<String> listClientes = new ComboBoxRounded<>(Clientes);
		listClientes.setFont(new Font("Poppins", Font.BOLD, 15));
		listClientes.setForeground(Color.black);
		listClientes.setOpaque(false);
		listClientes.setSize(280,40);
		listClientes.setLocation(50,160);
		añadirRenta.add(listClientes);
		
		//Label telefono y su respectivo campo de texto
		JLabel etiquetaVehiculo = new JLabel("Vehiculo");
		etiquetaVehiculo.setOpaque(false);
		etiquetaVehiculo.setForeground(Color.black);
		etiquetaVehiculo.setHorizontalAlignment(JLabel.LEFT);
		etiquetaVehiculo.setFont(new Font("Poppins",Font.PLAIN,15));
		etiquetaVehiculo.setSize(70,25);
		etiquetaVehiculo.setLocation(50,230);
		añadirRenta.add(etiquetaVehiculo);
		
		ArrayList<String> vehiculos = control.getListaModelos();
		ComboBoxRounded<String> listVehiculos = new ComboBoxRounded<>(vehiculos);
		listVehiculos.setFont(new Font("Poppins", Font.BOLD, 15));
		listVehiculos.setForeground(Color.black);
		listVehiculos.setOpaque(false);
		listVehiculos.setSize(280,40);
		listVehiculos.setLocation(50,260);
		añadirRenta.add(listVehiculos);
		
		//Label telefono y su respectivo campo de texto
		JLabel tituloFechaInicio = new JLabel("Fecha De Inicio");
		tituloFechaInicio.setOpaque(false);
		tituloFechaInicio.setForeground(Color.black);
		tituloFechaInicio.setHorizontalAlignment(JLabel.LEFT);
		tituloFechaInicio.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloFechaInicio.setSize(150,25);
		tituloFechaInicio.setLocation(50,330);
		añadirRenta.add(tituloFechaInicio);
		
		DatePickerRounded listFechasInicio = new DatePickerRounded();
		listFechasInicio.setFont(new Font("Poppins", Font.BOLD, 15));
		listFechasInicio.setForeground(Color.black);
		listFechasInicio.setOpaque(false);
		listFechasInicio.setSize(280,40);
		listFechasInicio.setLocation(50,360);
		añadirRenta.add(listFechasInicio);
		
		JLabel tituloFechaFinal = new JLabel("Fecha De Entrega");
		tituloFechaFinal.setOpaque(false);
		tituloFechaFinal.setForeground(Color.black);
		tituloFechaFinal.setHorizontalAlignment(JLabel.LEFT);
		tituloFechaFinal.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloFechaFinal.setSize(150,25);
		tituloFechaFinal.setLocation(50,430);
		añadirRenta.add(tituloFechaFinal);
		
		DatePickerRounded listFechasFinal = new DatePickerRounded();
		listFechasFinal.setFont(new Font("Poppins", Font.BOLD, 15));
		listFechasFinal.setForeground(Color.black);
		listFechasFinal.setOpaque(false);
		listFechasFinal.setSize(280,40);
		listFechasFinal.setLocation(50,460);
		añadirRenta.add(listFechasFinal);
		
		JLabel precio = new JLabel("Precio Por Dia");
		precio.setOpaque(false);
		precio.setForeground(Color.black);
		precio.setHorizontalAlignment(JLabel.LEFT);
		precio.setFont(new Font("Poppins",Font.PLAIN,15));
		precio.setSize(150,25);
		precio.setLocation(50,530);
		añadirRenta.add(precio);
		
		ArrayList<BigDecimal> precios = control.getListaPrecios();
		ComboBoxRounded<BigDecimal> listPreciosMax = new ComboBoxRounded<>(precios);
		listPreciosMax.setFont(new Font("Poppins", Font.BOLD, 15));
		listPreciosMax.setForeground(Color.black);
		listPreciosMax.setOpaque(false);
		listPreciosMax.setSize(280,40);
		listPreciosMax.setLocation(50,560);
		añadirRenta.add(listPreciosMax);
		
		JLabel sucursal = new JLabel("Sucursal de Recoleccion");
		sucursal.setOpaque(false);
		sucursal.setForeground(Color.black);
		sucursal.setHorizontalAlignment(JLabel.LEFT);
		sucursal.setFont(new Font("Poppins",Font.PLAIN,15));
		sucursal.setSize(200,25);
		sucursal.setLocation(50,630);
		añadirRenta.add(sucursal);
		
		ArrayList<String> sucursales = control.getNombresSucursales();
		ComboBoxRounded<String> listSucursales = new ComboBoxRounded<>(sucursales);
		listSucursales.setFont(new Font("Poppins", Font.BOLD, 15));
		listSucursales.setForeground(Color.black);
		listSucursales.setOpaque(false);
		listSucursales.setSize(280,40);
		listSucursales.setLocation(50,660);
		añadirRenta.add(listSucursales);
		
		JLabel fotoCliente = new JLabel("Foto Del Cliente");
		fotoCliente.setOpaque(false);
		fotoCliente.setForeground(Color.black);
		fotoCliente.setHorizontalAlignment(JLabel.LEFT);
		fotoCliente.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCliente.setSize(200,25);
		fotoCliente.setLocation(370,130);
		añadirRenta.add(fotoCliente);
		
		ButtonRounded LabelFotografia = new ButtonRounded("",15,6);
		LabelFotografia.setBounds(370,160,280,250);
		LabelFotografia.setOpaque(false);
		añadirRenta.add(LabelFotografia);
		
		JLabel fotoVehiculo = new JLabel("Foto Del Vehiculo");
		fotoVehiculo.setOpaque(false);
		fotoVehiculo.setForeground(Color.black);
		fotoVehiculo.setHorizontalAlignment(JLabel.LEFT);
		fotoVehiculo.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoVehiculo.setSize(200,25);
		fotoVehiculo.setLocation(370,430);
		añadirRenta.add(fotoVehiculo);
		
		ButtonRounded botonFotografiaVehiculo = new ButtonRounded("",15,6);
		botonFotografiaVehiculo.setBounds(370,460,280,250);
		botonFotografiaVehiculo.setOpaque(false);
		botonFotografiaVehiculo.addActionListener(e->{
			 JFileChooser selector = new JFileChooser();
			    
			    selector.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes","jpg", "jpeg", "png", "webp"));
			    
			    int resultado = selector.showOpenDialog(null);
			    
			    if (resultado == JFileChooser.APPROVE_OPTION) {

			        File archivo = selector.getSelectedFile();

			        if (archivo != null) {

			            try {

			                fotoSeleccionada =
			                    Files.readAllBytes(archivo.toPath());

			            } catch (IOException ex) {
			                ex.printStackTrace();
			            }
			        }
			    }
		});
		añadirRenta.add(botonFotografiaVehiculo);
		
		//Botones
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setSize(150,60);
		cancelarCliente.setLocation(150,750);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
      	ventana.dispose();
   
		});
		añadirRenta.add(cancelarCliente);
		
		ButtonRounded registrarRenta = new ButtonRounded("Registrar Renta",10,1);
		registrarRenta.setOpaque(false);
		registrarRenta.setForeground(Color.white);
		registrarRenta.setHorizontalAlignment(JLabel.CENTER);
		registrarRenta.setFont(new Font("Poppins",Font.BOLD,20));
		registrarRenta.setHorizontalTextPosition(JLabel.RIGHT);
		registrarRenta.addActionListener(e->{
		/*control.registrarNuevaRenta(control.clientelID(listClientes.getSelectedItem().toString()),
				control.obtenerIdModelo(listVehiculos.getSelectedItem().toString()),
				0,
				0,
				(LocalDate)listFechasInicio.getDate(),
				(LocalDate)listFechasFinal.getDate(),
				"Activo");*/
      	ventana.dispose();
		});
		registrarRenta.setSize(200,60);
		registrarRenta.setLocation(350,750);

	    añadirRenta.add(registrarRenta);
		
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	
	}

	public void editRent(int IDrenta, String Cliente, String modelo, LocalDate fehcaInicio, LocalDate fechaFinal, byte[] f) {
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
		PanelRounded añadirRenta = new PanelRounded(20,true,true,true,true);
		añadirRenta.setLayout(null);
		añadirRenta.setSize(700,900);
		añadirRenta.setLocation(610,100);
		añadirRenta.setBackground(Color.white);
		añadirRenta.setOpaque(false);
		ventana.add(añadirRenta);
		//Label superior con nombre de pestaña
		LabelRounded tituloAñadir = new LabelRounded("EDITAR RENTA",20,Color.decode("#000D56"));
		tituloAñadir.setOpaque(false);
		tituloAñadir.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloAñadir.setForeground(Color.WHITE);
		tituloAñadir.setHorizontalAlignment(JLabel.LEFT);
		tituloAñadir.setFont(new Font("Poppins",Font.BOLD,25));
		tituloAñadir.setSize(700,100);
		tituloAñadir.setLocation(0, 0);
		añadirRenta.add(tituloAñadir);

		//Label nombre y su respectivo campo de texto
		JLabel cliente = new JLabel("Cliente");
		cliente.setOpaque(false);
		cliente.setForeground(Color.black);
		cliente.setHorizontalAlignment(JLabel.LEFT);
		cliente.setFont(new Font("Poppins",Font.PLAIN,15));
		cliente.setSize(70,25);
		cliente.setLocation(50,130);
		añadirRenta.add(cliente);
		
		ComboBoxRounded<String> listClientes = new ComboBoxRounded<>();
		listClientes.setFont(new Font("Poppins", Font.BOLD, 15));
		listClientes.setForeground(Color.black);
		listClientes.setOpaque(false);
		listClientes.setSize(280,40);
		listClientes.setLocation(50,160);
		añadirRenta.add(listClientes);
		
		//Label telefono y su respectivo campo de texto
		JLabel etiquetaVehiculo = new JLabel("Vehiculo");
		etiquetaVehiculo.setOpaque(false);
		etiquetaVehiculo.setForeground(Color.black);
		etiquetaVehiculo.setHorizontalAlignment(JLabel.LEFT);
		etiquetaVehiculo.setFont(new Font("Poppins",Font.PLAIN,15));
		etiquetaVehiculo.setSize(70,25);
		etiquetaVehiculo.setLocation(50,230);
		añadirRenta.add(etiquetaVehiculo);
		
		ComboBoxRounded<String> listVehiculos = new ComboBoxRounded<>();
		listVehiculos.setFont(new Font("Poppins", Font.BOLD, 15));
		listVehiculos.setForeground(Color.black);
		listVehiculos.setOpaque(false);
		listVehiculos.setSize(280,40);
		listVehiculos.setLocation(50,260);
		añadirRenta.add(listVehiculos);

		JLabel tituloFechaInicio = new JLabel("Fecha De Inicio");
		tituloFechaInicio.setOpaque(false);
		tituloFechaInicio.setForeground(Color.black);
		tituloFechaInicio.setHorizontalAlignment(JLabel.LEFT);
		tituloFechaInicio.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloFechaInicio.setSize(150,25);
		tituloFechaInicio.setLocation(50,330);
		añadirRenta.add(tituloFechaInicio);
		
		DatePickerRounded listFechasInicio= new DatePickerRounded();
		listFechasInicio.setFont(new Font("Poppins", Font.BOLD, 15));
		listFechasInicio.setForeground(Color.black);
		listFechasInicio.setOpaque(false);
		listFechasInicio.setSize(280,40);
		listFechasInicio.setLocation(50,360);
		listFechasInicio.setDate(fehcaInicio);
		añadirRenta.add(listFechasInicio);
		
		JLabel tituloFechaFinal = new JLabel("Fecha De Entrega");
		tituloFechaFinal.setOpaque(false);
		tituloFechaFinal.setForeground(Color.black);
		tituloFechaFinal.setHorizontalAlignment(JLabel.LEFT);
		tituloFechaFinal.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloFechaFinal.setSize(150,25);
		tituloFechaFinal.setLocation(50,430);
		añadirRenta.add(tituloFechaFinal);

		DatePickerRounded listFechasFinal = new DatePickerRounded();
		listFechasFinal.setFont(new Font("Poppins", Font.BOLD, 15));
		listFechasFinal.setForeground(Color.black);
		listFechasFinal.setOpaque(false);
		listFechasFinal.setSize(280,40);
		listFechasFinal.setLocation(50,460);
		listFechasFinal.setDate(fechaFinal);
		añadirRenta.add(listFechasFinal);
		
		ArrayList<String> sucursales = control.getNombresSucursales();
		
		JLabel sucursalRecoleccion = new JLabel("Sucursal de Recoleccion");
		sucursalRecoleccion.setOpaque(false);
		sucursalRecoleccion.setForeground(Color.black);
		sucursalRecoleccion.setHorizontalAlignment(JLabel.LEFT);
		sucursalRecoleccion.setFont(new Font("Poppins",Font.PLAIN,15));
		sucursalRecoleccion.setSize(150,25);
		sucursalRecoleccion.setLocation(50,530);
		añadirRenta.add(sucursalRecoleccion);
		
		ComboBoxRounded<String> listSucursalesEntrega = new ComboBoxRounded<>(sucursales);
		listSucursalesEntrega.setFont(new Font("Poppins", Font.BOLD, 15));
		listSucursalesEntrega.setForeground(Color.black);
		listSucursalesEntrega.setOpaque(false);
		listSucursalesEntrega.setSize(280,40);
		listSucursalesEntrega.setLocation(50,560);
		añadirRenta.add(listSucursalesEntrega);
		
		JLabel sucursalEntrega = new JLabel("Sucursal de Entrega");
		sucursalEntrega.setOpaque(false);
		sucursalEntrega.setForeground(Color.black);
		sucursalEntrega.setHorizontalAlignment(JLabel.LEFT);
		sucursalEntrega.setFont(new Font("Poppins",Font.PLAIN,15));
		sucursalEntrega.setSize(200,25);
		sucursalEntrega.setLocation(50,630);
		añadirRenta.add(sucursalEntrega);
		
		ComboBoxRounded<String> listSucursales = new ComboBoxRounded<>(sucursales);
		listSucursales.setFont(new Font("Poppins", Font.BOLD, 15));
		listSucursales.setForeground(Color.black);
		listSucursales.setOpaque(false);
		listSucursales.setSize(280,40);
		listSucursales.setLocation(50,660);
		añadirRenta.add(listSucursales);
		
		JLabel fotoCliente = new JLabel("Foto Del Cliente");
		fotoCliente.setOpaque(false);
		fotoCliente.setForeground(Color.black);
		fotoCliente.setHorizontalAlignment(JLabel.LEFT);
		fotoCliente.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoCliente.setSize(200,25);
		fotoCliente.setLocation(370,130);
		añadirRenta.add(fotoCliente);
		
		ButtonRounded LabelFotografia = new ButtonRounded("",15,6);
		LabelFotografia.setBounds(370,160,280,250);
		LabelFotografia.setOpaque(false);
		ImageIcon icon = new ImageIcon(f);
		Image imagenEscalada = icon.getImage().getScaledInstance(
			        280,    // ancho
			        250,    // alto
			        Image.SCALE_SMOOTH);

				LabelFotografia.setIcon(new ImageIcon(imagenEscalada));
				
		añadirRenta.add(LabelFotografia);
		
		JLabel fotoVehiculo = new JLabel("Foto Del Vehiculo");
		fotoVehiculo.setOpaque(false);
		fotoVehiculo.setForeground(Color.black);
		fotoVehiculo.setHorizontalAlignment(JLabel.LEFT);
		fotoVehiculo.setFont(new Font("Poppins",Font.PLAIN,15));
		fotoVehiculo.setSize(200,25);
		fotoVehiculo.setLocation(370,430);
		añadirRenta.add(fotoVehiculo);
		
		ButtonRounded LabelFotografiaVehiculo = new ButtonRounded("",15,6);
		LabelFotografiaVehiculo.setBounds(370,460,280,250);
		LabelFotografiaVehiculo.setOpaque(false);
		añadirRenta.add(LabelFotografiaVehiculo);
		
		//Botones
		ButtonRounded cancelarCliente = new ButtonRounded("Cancelar",10,5);
		cancelarCliente.setSize(150,60);
		cancelarCliente.setLocation(150,750);
		cancelarCliente.setOpaque(false);
		cancelarCliente.setForeground(Color.white);
		cancelarCliente.setHorizontalAlignment(JLabel.CENTER);
		cancelarCliente.setFont(new Font("Poppins",Font.BOLD,20));
		cancelarCliente.addActionListener(e->{
      	ventana.dispose();
   
		});
		añadirRenta.add(cancelarCliente);
		
		listClientes.addItem(Cliente);
		listVehiculos.addItem(modelo);
		ButtonRounded editarRenta = new ButtonRounded("Editar Renta",10,1);
		editarRenta.setOpaque(false);
		editarRenta.setForeground(Color.white);
		editarRenta.setHorizontalAlignment(JLabel.CENTER);
		editarRenta.setFont(new Font("Poppins",Font.BOLD,20));
		editarRenta.setHorizontalTextPosition(JLabel.RIGHT);
		editarRenta.addActionListener(e->{
      	ventana.dispose();
		});
		editarRenta.setSize(200,60);
		editarRenta.setLocation(350,750);

	    añadirRenta.add(editarRenta);
		
		
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
		LabelRounded tituloFiltros = new LabelRounded("FILTROS AVANZADOS - RENTAS",20,Color.decode("#000D56"));
		tituloFiltros.setOpaque(false);
		tituloFiltros.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		tituloFiltros.setForeground(Color.WHITE);
		tituloFiltros.setHorizontalAlignment(JLabel.LEFT);
		tituloFiltros.setFont(new Font("Poppins",Font.BOLD,25));
		tituloFiltros.setSize(700,100);
		tituloFiltros.setLocation(0, 0);
		filtrosAvanzados.add(tituloFiltros);

		//Label nombre y su respectivo campo de texto
		JLabel cliente = new JLabel("Cliente");
		cliente.setOpaque(false);
		cliente.setForeground(Color.black);
		cliente.setHorizontalAlignment(JLabel.LEFT);
		cliente.setFont(new Font("Poppins",Font.PLAIN,15));
		cliente.setSize(70,25);
		cliente.setLocation(50,130);
		filtrosAvanzados.add(cliente);
		
		ArrayList<String> Clientes = control.getNombresClientes();
		ComboBoxRounded<String> listClientes = new ComboBoxRounded<>(Clientes);
		listClientes.setFont(new Font("Poppins", Font.BOLD, 15));
		listClientes.setForeground(Color.black);
		listClientes.setOpaque(false);
		listClientes.setSize(280,40);
		listClientes.setLocation(50,160);
		filtrosAvanzados.add(listClientes);
		
		//Label telefono y su respectivo campo de texto
		JLabel Estado = new JLabel("Estado");
		Estado.setOpaque(false);
		Estado.setForeground(Color.black);
		Estado.setHorizontalAlignment(JLabel.LEFT);
		Estado.setFont(new Font("Poppins",Font.PLAIN,15));
		Estado.setSize(70,25);
		Estado.setLocation(50,230);
		filtrosAvanzados.add(Estado);
		
		ArrayList<String> estados = control.getListaEstados();
		ComboBoxRounded<String> listEstados = new ComboBoxRounded<>(estados);
		listEstados.setFont(new Font("Poppins", Font.BOLD, 15));
		listEstados.setForeground(Color.black);
		listEstados.setOpaque(false);
		listEstados.setSize(280,40);
		listEstados.setLocation(50,260);
		filtrosAvanzados.add(listEstados);
		
		JLabel tituloFechaInicio = new JLabel("Fecha de Inicio");
		tituloFechaInicio.setOpaque(false);
		tituloFechaInicio.setForeground(Color.black);
		tituloFechaInicio.setHorizontalAlignment(JLabel.LEFT);
		tituloFechaInicio.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloFechaInicio.setSize(70,25);
		tituloFechaInicio.setLocation(370,130);
		filtrosAvanzados.add(tituloFechaInicio);
		
		DatePickerRounded selectorFechaInicio = new DatePickerRounded();
		selectorFechaInicio.setFont(new Font("Poppins", Font.BOLD, 15));
		selectorFechaInicio.setForeground(Color.black);
		selectorFechaInicio.setOpaque(false);
		selectorFechaInicio.setSize(280,40);
		selectorFechaInicio.setLocation(370,160);
		filtrosAvanzados.add(selectorFechaInicio);
		
		JLabel tituloFechaFin = new JLabel("Fecha de Inicio");
		tituloFechaFin.setOpaque(false);
		tituloFechaFin.setForeground(Color.black);
		tituloFechaFin.setHorizontalAlignment(JLabel.LEFT);
		tituloFechaFin.setFont(new Font("Poppins",Font.PLAIN,15));
		tituloFechaFin.setSize(70,25);
		tituloFechaFin.setLocation(370,330);
		filtrosAvanzados.add(tituloFechaFin);
		
		DatePickerRounded selectorFechaFin = new DatePickerRounded();
		selectorFechaFin.setFont(new Font("Poppins", Font.BOLD, 15));
		selectorFechaFin.setForeground(Color.black);
		selectorFechaFin.setOpaque(false);
		selectorFechaFin.setSize(280,40);
		selectorFechaFin.setLocation(370,360);
		filtrosAvanzados.add(selectorFechaFin);
		
		ArrayList<BigDecimal> precios = control.getListaPrecios();
		ComboBoxRounded<BigDecimal> listPreciosMin = new ComboBoxRounded<>(precios);
		listPreciosMin.setFont(new Font("Poppins", Font.BOLD, 15));
		listPreciosMin.setForeground(Color.black);
		listPreciosMin.setOpaque(false);
		listPreciosMin.setSize(120,40);
		listPreciosMin.setLocation(370,260);
		filtrosAvanzados.add(listPreciosMin);
		
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
		String Fclientes = listClientes.getSelectedItem().toString();
		String Festados = listEstados.getSelectedItem().toString();
		LocalDate FfechaInicio = selectorFechaInicio.getDate();
		LocalDate FfechaFinal = selectorFechaFin.getDate();
		
		if (!Fclientes.equals("Todos")) {
		    filtros.add(
		        RowFilter.regexFilter(
		            "^" + Pattern.quote(Fclientes) + "$",
		            2
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
		
		if (FfechaInicio != null) {

		    filtros.add(new RowFilter<Object, Object>() {

		        @Override
		        public boolean include(
		                Entry<? extends Object,
		                ? extends Object> entry) {

		            LocalDate fechaTabla =
		                (LocalDate) entry.getValue(4);

		            return fechaTabla.equals(FfechaInicio);
		        }
		    });
		}
		
		if (FfechaFinal != null) {

		    filtros.add(new RowFilter<Object, Object>() {

		        @Override
		        public boolean include(
		                Entry<? extends Object,
		                ? extends Object> entry) {

		            LocalDate fechaTabla =
		                (LocalDate) entry.getValue(5);

		            return fechaTabla.equals(FfechaFinal);
		        }
		    });
		}

		sorter.setRowFilter(RowFilter.andFilter(filtros));
    	ventana.dispose();
		});
		
		aplicarFiltros.setSize(200,60);
		aplicarFiltros.setLocation(350,500);
       URL url = getClass().getResource("/iconos/adicionales/buscar_blanco.png");//Carga ubi imagen
	    
	    if (url != null) {
	    	aplicarFiltros.setIcon(new ImageIcon(url));
	    }
	    filtrosAvanzados.add(aplicarFiltros);
		
		
		ventana.revalidate();
		ventana.repaint();
		ventana.setVisible(true);
	
	}

	public void historialRenta(int idRenta) {
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
		
		LabelRounded etiquetaHistorial = new LabelRounded("HISTORIAL DE RENTA", 10, Color.decode("#000D56"));
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
		String[] Ordenamientos = {"TODOS", "Fecha Inicio", "Fecha Final", "Estado"};
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
		Object [] table_head = {"ID", "Nombre", "Vehiculo", "Fecha Inicio", "Fecha Fin", "Estado"};
		//Creacion de una matriz para los datos de una tabla 
		
		DefaultTableModel modeloRentas= new DefaultTableModel(null,table_head){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Ninguna celda será editable
		    }
		};
		ArrayList<RentModel> listaRentas = control.obtenerRentas();
		//ArrayList<RentModel> listaRentas = control;
		for (RentModel Renta : listaRentas) {
		    Object[] fila = new Object[8];
		    fila[0] = Renta.getIdLetra();
		    fila[1] = Renta.getnameCliente();
		    fila[2] = Renta.getId_vehiculo();
		    fila[3] = Renta.getInicio_renta();
		    fila[4] = Renta.getFin_renta();
		    fila[5] = Renta.getEstado();  
		    modeloRentas.addRow(fila);
		}
		//Creacion de la tabla para usuario con el modelo y agregamos el filtrador
		JTable Rentas_table = new JTable(modeloRentas);
		
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloRentas);
		Rentas_table.setRowSorter(sorter);
		
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
		JScrollPane scrollPane = new JScrollPane(Rentas_table);
		scrollPane.getVerticalScrollBar().setUI(new ScrollBarCustom());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		Rentas_table.setRowHeight(40);
		Rentas_table.setBackground(Color.decode("#D9D9D9"));
		Rentas_table.setShowVerticalLines(false);
		Rentas_table.setShowHorizontalLines(true);
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		//Personalizacion de la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//Render para centrar el texto
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < 6; i++) {//Ciclo para aplicar el centrado solo a los campos de datos
			Rentas_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		JTableHeader header = Rentas_table.getTableHeader();
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
