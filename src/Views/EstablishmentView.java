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
import java.util.ArrayList;

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

import Controllers.EstablishmentController;
import Controllers.HomeController;
import Utilities.ButtonRounded;
import Utilities.ButtonRoundedEditor;
import Utilities.ButtonRoundedRenderer;
import Utilities.ButtonSimpleEditor;
import Utilities.ComboBoxRounded;
import Utilities.GrafoPanel;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ScrollBarCustom;
import Utilities.TextFieldRounded;

public class EstablishmentView {
	EstablishmentController control;
	
	public EstablishmentView(){

	}
	
	public void setControlador(EstablishmentController c) {
		this.control = c;
	}

	public JPanel showEstablishment() {
		JPanel EstablishmentPanel = new JPanel();
		EstablishmentPanel.setOpaque(true);
		EstablishmentPanel.setBackground(Color.decode("#EAEAEA"));
		EstablishmentPanel.setVisible(true);
		EstablishmentPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		JPanel mapPanel = new JPanel();
		mapPanel.setOpaque(true);
		mapPanel.setVisible(true);
		mapPanel.setLayout(new BorderLayout());
		mapPanel.setBackground(Color.decode("#FFFFFF"));

        GrafoPanel miMapaInteractivo = new GrafoPanel();
        mapPanel.add(miMapaInteractivo, BorderLayout.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 4;
		gbc.weighty = 3;
		gbc.gridwidth = 4;
		gbc.gridheight = 3;
		gbc.insets = new Insets(0, 50, 0, 50); // 
		gbc.fill = GridBagConstraints.BOTH;
		EstablishmentPanel.add(mapPanel,gbc);

		ImageIcon ubicacionIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/ubicacion.png"));
		Image ubicacionEscalar = ubicacionIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon ubicacionEscalada = new ImageIcon(ubicacionEscalar);

		ButtonRounded seleccionarUbi = new ButtonRounded("Seleccionar Ubicacion",10,1);
		seleccionarUbi.setOpaque(false);
		seleccionarUbi.setIcon(ubicacionEscalada);
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

		PanelRounded panelUbi = new PanelRounded(10,true,true,true,true);
		panelUbi.setVisible(true);
		panelUbi.setLayout(new BorderLayout());
		panelUbi.setBackground(Color.decode("#FFFFFF"));
		panelUbi.setBounds(635,365,650,500);
		ventana.add(panelUbi);

		PanelRounded panelSupCat = new PanelRounded(10,true,true,false,false);
		panelSupCat.setVisible(true);
		panelSupCat.setLayout(new BorderLayout());
		panelSupCat.setBackground(Color.decode("#000D56"));
		panelSupCat.setPreferredSize(new Dimension(0,120));
		panelUbi.add(panelSupCat,BorderLayout.NORTH);

		JLabel tituloUbi = new JLabel("Seleccionar Ubicacion");
		tituloUbi.setBorder(new EmptyBorder(0, 0, 0, 30));
		tituloUbi.setForeground(Color.white);
		tituloUbi.setOpaque(false);
		tituloUbi.setHorizontalAlignment(JLabel.CENTER);
		tituloUbi.setFont(new Font("Poppins",Font.BOLD,30));
		tituloUbi.setHorizontalTextPosition(JLabel.CENTER);
		panelSupCat.add(tituloUbi,BorderLayout.CENTER);

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

		PanelRounded contUbi = new PanelRounded(10,true,true,true,true);
		contUbi.setBackground(Color.white);
		contUbi.setLayout(null);
		contUbi.setVisible(true);
		panelUbi.add(contUbi,BorderLayout.CENTER);
		
		ArrayList<String> localesOrigen = control.obtenerLocales();
		ComboBoxRounded<String> listOrigenes = new ComboBoxRounded<>(localesOrigen);
		listOrigenes.setFont(new Font("Poppins", Font.BOLD, 15));
		listOrigenes.setForeground(Color.black);
		listOrigenes.setOpaque(false);
		listOrigenes.setSize(260,40);
		listOrigenes.setLocation(40,10);
		contUbi.add(listOrigenes);
		
		ComboBoxRounded<String> listDestinos = new ComboBoxRounded<>(localesOrigen);
		listDestinos.setFont(new Font("Poppins", Font.BOLD, 15));
		listDestinos.setForeground(Color.black);
		listDestinos.setOpaque(false);
		listDestinos.setSize(260,40);
		listDestinos.setLocation(350,10);
		contUbi.add(listDestinos);

		JLabel etiquetaDistancia= new JLabel("Distancia");
		etiquetaDistancia.setOpaque(false);
		etiquetaDistancia.setForeground(Color.black);
		etiquetaDistancia.setHorizontalAlignment(JLabel.LEFT);
		etiquetaDistancia.setFont(new Font("Poppins",Font.PLAIN,20));
		etiquetaDistancia.setBounds(150,75,100,30);
		contUbi.add(etiquetaDistancia);
		
		JLabel MostrarDistancia= new JLabel("");
		MostrarDistancia.setOpaque(false);
		MostrarDistancia.setForeground(Color.black);
		MostrarDistancia.setHorizontalAlignment(JLabel.LEFT);
		MostrarDistancia.setFont(new Font("Poppins",Font.PLAIN,20));
		MostrarDistancia.setBounds(150,110,100,30);
		contUbi.add(MostrarDistancia);
		
		JLabel etiquetaCosto = new JLabel("Costo total");
		etiquetaCosto.setOpaque(false);
		etiquetaCosto.setForeground(Color.black);
		etiquetaCosto.setHorizontalAlignment(JLabel.LEFT);
		etiquetaCosto.setFont(new Font("Poppins",Font.PLAIN,20));
		etiquetaCosto.setBounds(150,150,100,30);
		contUbi.add(etiquetaCosto);
		
		JLabel MostrarCosto= new JLabel("");
		MostrarCosto.setOpaque(false);
		MostrarCosto.setForeground(Color.black);
		MostrarCosto.setHorizontalAlignment(JLabel.LEFT);
		MostrarCosto.setFont(new Font("Poppins",Font.PLAIN,20));
		MostrarCosto.setBounds(150,185,100,30);
		contUbi.add(MostrarCosto);

		ButtonRounded Calcular = new ButtonRounded("Calcular",10,1);
		Calcular.setBounds(150,250,350,50);
		Calcular.setOpaque(false);
		Calcular.setFont(new Font("Poppins",Font.BOLD,15));
		Calcular.setForeground(Color.white);
		Calcular.setHorizontalAlignment(JLabel.CENTER);
		Calcular.addActionListener(e->{
			int idOrigen = control.obtenerIDsuc(listOrigenes.getSelectedItem().toString());
			int idDestino = control.obtenerIDsuc(listDestinos.getSelectedItem().toString());
			double Distancia = control.calcularDistancia(idOrigen, idDestino);
			double Costo = control.calcularPrecio(Distancia);
			MostrarDistancia.setText(String.valueOf(Distancia));
			MostrarCosto.setText(String.valueOf(Costo));

		});
		contUbi.add(Calcular);

		ventana.setVisible(true);
	}

}
