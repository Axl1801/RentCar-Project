package Views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AuthController;
import Controllers.ClientController;
import Controllers.DashController;
import Controllers.EstablishmentController;
import Controllers.HomeController;
import Controllers.RentController;
import Controllers.VehicleController;
import Utilities.Activities;
import Utilities.ActivityManager;
import Utilities.Alerts;
import Utilities.ButtonRounded;
import Utilities.ComboBoxRounded;
import Utilities.LabelRounded;
import Utilities.LoadData;
import Utilities.PanelRounded;
import Utilities.ResponsiveImageLabel;
import Utilities.TextFieldRounded;
import Utilities.ToggleButtonRounded;

public class HomeView {
	
	HomeController control;
	public HomeView(){

	}

	public void setControlador(HomeController c) {
		this.control = c;
	}

	public void showHome() {
		JFrame ventana = new JFrame("Paz Drive");
		ventana.setSize(1920, 1080);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(new BorderLayout());
		ventana.setVisible(true);

		JPanel principal = new JPanel();
		principal.setBounds(0,0,1920,1080);
		principal.setLayout(new BorderLayout());
		principal.setOpaque(true);
		principal.setBackground(Color.white);
		principal.setVisible(true);
		ventana.add(principal,BorderLayout.CENTER);

		JPanel menuOpciones = new JPanel();
		menuOpciones.setOpaque(false);
		menuOpciones.setVisible(true);
		menuOpciones.setLayout(new GridBagLayout());
		menuOpciones.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));// margen derecho

		principal.add(menuOpciones,BorderLayout.WEST);

		GridBagConstraints gbc = new GridBagConstraints();

		ImageIcon logoMenu = new ImageIcon(
				getClass().getResource("/Imagenes-sprites/paz_drive_logo_2.png")
				);
		JLabel labelfondo = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(logoMenu.getImage(), 10,0, getWidth(), getHeight(), this);
			}
		};

		labelfondo.setHorizontalAlignment(JLabel.CENTER);
		labelfondo.setPreferredSize(new Dimension(150, 150));
		//Posicionamiento del logo
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.insets = new Insets(5, 30, 0, 0); // 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(labelfondo,gbc);

		JLabel nombreMenu = new JLabel("Paz Drive");//Titulo barra superior
		nombreMenu.setPreferredSize(new Dimension(150, 120));
		nombreMenu.setBackground(Color.white);
		nombreMenu.setForeground(Color.decode("#000D56"));
		nombreMenu.setVerticalAlignment(JLabel.TOP);
		nombreMenu.setHorizontalAlignment(JLabel.CENTER);
		nombreMenu.setFont(new Font("Poppins",Font.BOLD,25));
		//Posicionamiento del titulo
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(nombreMenu,gbc);

		JButton dashboard = new JButton("Dashboard");
		URL url = getClass().getResource("/iconos/barra_lateral/dashboard.png");//Carga ubi imagen

		if (url != null) {
			dashboard.setIcon(new ImageIcon(url));
		}

		dashboard.setFont(new Font("Poppins",Font.BOLD,20));
		dashboard.setBorderPainted(false);
		dashboard.setBorder(null);
		dashboard.setContentAreaFilled(false);
		dashboard.setFocusPainted(false);
		dashboard.setHorizontalAlignment(JLabel.CENTER);  
		dashboard.setIconTextGap(10);                      
		dashboard.setHorizontalTextPosition(JLabel.RIGHT);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 30, 15, 0); //
		menuOpciones.add(dashboard,gbc);

		JButton clientes = new JButton("Clientes ");
		url = getClass().getResource("/iconos/barra_lateral/usuarios.png");//Carga ubi imagen

		if (url != null) {
			clientes.setIcon(new ImageIcon(url));
		}

		clientes.setFont(new Font("Poppins",Font.BOLD,20));
		clientes.setBorderPainted(false);
		clientes.setBorder(null);
		clientes.setContentAreaFilled(false);
		clientes.setFocusPainted(false);
		clientes.setHorizontalAlignment(JLabel.CENTER);  
		clientes.setIconTextGap(10);                      
		clientes.setHorizontalTextPosition(JLabel.RIGHT);

		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(clientes,gbc);

		JButton vehiculos = new JButton("Vehiculos");
		url = getClass().getResource("/iconos/barra_lateral/vehiculos.png");//Carga ubi imagen

		if (url != null) {
			vehiculos.setIcon(new ImageIcon(url));
		}

		vehiculos.setFont(new Font("Poppins",Font.BOLD,20));
		vehiculos.setBorderPainted(false);
		vehiculos.setBorder(null);
		vehiculos.setContentAreaFilled(false);
		vehiculos.setFocusPainted(false);
		vehiculos.setHorizontalAlignment(JLabel.CENTER);  
		vehiculos.setIconTextGap(10);                      
		vehiculos.setHorizontalTextPosition(JLabel.RIGHT);

		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(vehiculos,gbc);

		JButton rentas = new JButton("Rentas   ");
		url = getClass().getResource("/iconos/barra_lateral/rentas.png");//Carga ubi imagen

		if (url != null) {
			rentas.setIcon(new ImageIcon(url));
		}

		rentas.setFont(new Font("Poppins",Font.BOLD,20));
		rentas.setBorderPainted(false);
		rentas.setBorder(null);
		rentas.setContentAreaFilled(false);
		rentas.setFocusPainted(false);
		rentas.setHorizontalAlignment(JLabel.CENTER);  
		rentas.setIconTextGap(10);                      
		rentas.setHorizontalTextPosition(JLabel.RIGHT);

		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(rentas,gbc);

		JButton Locales = new JButton("Locales  ");
		url = getClass().getResource("/iconos/barra_lateral/locales.png");//Carga ubi imagen

		if (url != null) {
			Locales.setIcon(new ImageIcon(url));
		}

		Locales.setFont(new Font("Poppins",Font.BOLD,20));
		Locales.setBorderPainted(false);
		Locales.setBorder(null);
		Locales.setContentAreaFilled(false);
		Locales.setFocusPainted(false);
		Locales.setHorizontalAlignment(JLabel.CENTER);  
		Locales.setIconTextGap(10);                      
		Locales.setHorizontalTextPosition(JLabel.RIGHT);

		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(Locales,gbc);

		ButtonRounded cerrarSesion = new ButtonRounded("Cerrar Sesión",10,2);
		url = getClass().getResource("/iconos/barra_lateral/cerrar_sesion_black.png");//Carga ubi imagen

		if (url != null) {
			cerrarSesion.setIcon(new ImageIcon(url));
		}

		cerrarSesion.setFont(new Font("Poppins",Font.PLAIN,15));
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setHorizontalAlignment(JLabel.CENTER);  
		cerrarSesion.setIconTextGap(10);                      
		cerrarSesion.setHorizontalTextPosition(JLabel.RIGHT);

		gbc.gridx = 2;
		gbc.gridy = 11;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		menuOpciones.add(cerrarSesion,gbc);

		//Panel guardar el contenido principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(true);
		panelPrincipal.setVisible(true);
		panelPrincipal.setBackground(Color.white );
		panelPrincipal.setLayout(new BorderLayout());
		principal.add(panelPrincipal,BorderLayout.CENTER);

		//Panel superior del contenido superior
		PanelRounded panelSuperior = new PanelRounded(20,true,true,false,false);
		panelSuperior.setVisible(true);
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.setBackground(Color.decode("#000D56"));
		panelSuperior.setPreferredSize(new Dimension(0,120));
		panelPrincipal.add(panelSuperior,BorderLayout.NORTH);

		JLabel tituloPanel = new JLabel("Inicio");
		tituloPanel.setVisible(true);
		tituloPanel.setOpaque(false);
		tituloPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));// margen derecho
		tituloPanel.setForeground(Color.white);
		tituloPanel.setFont(new Font("Poppins",Font.PLAIN,50));
		tituloPanel.setVerticalAlignment(JLabel.CENTER);
		tituloPanel.setHorizontalAlignment(JLabel.LEFT);
		panelSuperior.add(tituloPanel,BorderLayout.CENTER);

		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 80, 40));
		panelBotones.setVisible(true);
		panelSuperior.add(panelBotones,BorderLayout.EAST);

		ButtonRounded botonOpciones = new ButtonRounded("Opciones",10,3);
		url = getClass().getResource("/iconos/adicionales/agregar_black.png");//Carga ubi imagen
		if (url != null) {
			botonOpciones.setIcon(new ImageIcon(url));
		}
		botonOpciones.setBorder(null);
		botonOpciones.setFont(new Font("Poppins",Font.PLAIN,15));
		botonOpciones.setContentAreaFilled(false);
		botonOpciones.setFocusPainted(false);
		botonOpciones.setHorizontalTextPosition(JLabel.LEFT);
		botonOpciones.setVisible(false);
		botonOpciones.addActionListener(e->{
			opciones();
		});
		panelBotones.add(botonOpciones);

		JButton botonNotificaciones = new JButton();
		url = getClass().getResource("/iconos/barra_superior/notificaciones.png");//Carga ubi imagen
		if (url != null) {
			botonNotificaciones.setIcon(new ImageIcon(url));
		}
		botonNotificaciones.setBorder(null);
		botonNotificaciones.setContentAreaFilled(false);
		botonNotificaciones.setFocusPainted(false);
		botonNotificaciones.addActionListener(e->{
			showNotification();
		});
		panelBotones.add(botonNotificaciones);

		JButton botonAjustes = new JButton();
		url = getClass().getResource("/iconos/barra_superior/ajustes.png");//Carga ubi imagen
		if (url != null) {
			botonAjustes.setIcon(new ImageIcon(url));
		}
		botonAjustes.setBorder(null);
		botonAjustes.setContentAreaFilled(false);
		botonAjustes.setFocusPainted(false);
		botonAjustes.addActionListener(e->{
			showSettings();
		});
		panelBotones.add(botonAjustes);

		JButton botonPerfil = new JButton();
		url = getClass().getResource("/iconos/barra_superior/perfil.png");//Carga ubi imagen
		if (url != null) {
			botonPerfil.setIcon(new ImageIcon(url));
		}
		botonPerfil.setBorder(null);
		botonPerfil.setContentAreaFilled(false);
		botonPerfil.setFocusPainted(false);
		panelBotones.add(botonPerfil);


		//Panel inicial del Home
		JPanel hv = new JPanel(new GridBagLayout());
		hv.setBackground(Color.white);

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.weightx = 1;
		gbc2.anchor = GridBagConstraints.CENTER;

		gbc2.gridy = 0;
		gbc2.weighty = 1;
		hv.add(Box.createVerticalGlue(), gbc2);

		ResponsiveImageLabel logoHome = new ResponsiveImageLabel(logoMenu);
		logoHome.setPreferredSize(new Dimension(500, 500));
		logoHome.setMinimumSize(new Dimension(200, 200));

		gbc2.gridy = 1;
		gbc2.weighty = 0;
		gbc2.fill = GridBagConstraints.NONE;
		hv.add(logoHome, gbc2);

		gbc2.gridy = 2;
		hv.add(Box.createRigidArea(new Dimension(0, 10)), gbc2);

		JLabel tituloHome = new JLabel("PAZ DRIVE");
		tituloHome.setForeground(Color.decode("#000D56"));
		tituloHome.setHorizontalAlignment(JLabel.CENTER);
		tituloHome.setFont(new Font("Poppins", Font.BOLD, 30));

		gbc2.gridy = 3;
		hv.add(tituloHome, gbc2);

		gbc2.gridy = 4;
		gbc2.weighty = 1;
		hv.add(Box.createVerticalGlue(), gbc2);


		//Panel donde ira el contenido de cada apartado y el control de manejo de este
		CardLayout cl = new CardLayout();
		JPanel panelContenido = new JPanel(cl);
		panelPrincipal.add(panelContenido);

		AuthController ac = new AuthController();
		ClientController cc = new ClientController();
		DashController dc = new DashController();
		EstablishmentController ec = new EstablishmentController();
		RentController rc = new RentController();
		VehicleController vc = new VehicleController();

		panelContenido.add(hv,"vistaHome");
		panelContenido.add(cc.showClientView(),"vistaCliente");
		panelContenido.add(dc.showDashboard(),"vistaDashboard");
		panelContenido.add(ec.showEstablishment(),"vistaEstablecimiento");
		panelContenido.add(rc.showRent(),"vistaRentas");
		panelContenido.add(vc.showVehicle(),"vistaVehiculos");

		//Mostrar vista de clientes
		clientes.addActionListener(e->{
			botonOpciones.setVisible(false);
			tituloPanel.setText("Clientes");
			cl.show(panelContenido,"vistaCliente");
		});
		//Mostrar vista de Dashboard
		dashboard.addActionListener(e->{
			botonOpciones.setVisible(false);
			tituloPanel.setText("Dashboard");
			cl.show(panelContenido,"vistaDashboard");
		});
		//Mostrar vista de Establecimientos
		Locales.addActionListener(e->{
			botonOpciones.setVisible(false);
			tituloPanel.setText("Establecimientos");
			cl.show(panelContenido,"vistaEstablecimiento");
		});
		//Mostrar vista de Rentas
		rentas.addActionListener(e->{
			botonOpciones.setVisible(false);
			tituloPanel.setText("Rentas");
			cl.show(panelContenido,"vistaRentas");
		});
		//Mostrar vista de Vehiculos
		vehiculos.addActionListener(e->{
			tituloPanel.setText("Vehiculos");
			botonOpciones.setVisible(true);
			cl.show(panelContenido,"vistaVehiculos");
		});

		botonAjustes.addActionListener(e->{
			botonOpciones.setVisible(false);
			cl.show(panelContenido,"vistaAjustes");
		});

		botonPerfil.addActionListener(e->{
			botonOpciones.setVisible(false);
			showProfile();
		});
		//Cerrar ventana y regresar al login
		cerrarSesion.addActionListener(e->{
			botonOpciones.setVisible(false);
			ventana.dispose();
			ac.login();
		});


		ventana.revalidate();
		ventana.repaint();
	}

	public void showNotification(){
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
		PanelRounded Notificaciones = new PanelRounded(20,true,true,true,true);
		Notificaciones.setLayout(new BorderLayout());
		Notificaciones.setSize(300,400);
		Notificaciones.setLocation(810,340);
		Notificaciones.setBackground(Color.decode("#000D56"));
		Notificaciones.setOpaque(false);
		ventana.add(Notificaciones);

		PanelRounded panelSup = new PanelRounded(20,true,true,false,false);
		panelSup.setOpaque(false);
		panelSup.setLayout(new BorderLayout());
		panelSup.setBackground(Color.decode("#000D56"));
		Notificaciones.add(panelSup,BorderLayout.NORTH);

		JLabel tituNotificaciones = new JLabel("Notificaciones");
		tituNotificaciones.setOpaque(false);
		tituNotificaciones.setForeground(Color.white);
		tituNotificaciones.setHorizontalAlignment(JLabel.CENTER);
		tituNotificaciones.setFont(new Font("Poppins",Font.BOLD,15));
		tituNotificaciones.setHorizontalTextPosition(JLabel.CENTER);
		tituNotificaciones.setBounds(75,0,225,75);
		panelSup.add(tituNotificaciones, BorderLayout.CENTER);

		URL url = getClass().getResource("/iconos/adicionales/anterior.png");//Carga ubi imagen

		ButtonRounded regresar = new ButtonRounded("",20,1);
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		regresar.setPreferredSize(new Dimension(74,74));
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSup.add(regresar, BorderLayout.WEST);

		PanelRounded panelActividades = new PanelRounded(20,false,false,true,true);
		panelActividades.setBackground(Color.white);
		panelActividades.setLayout(new BoxLayout(panelActividades, BoxLayout.Y_AXIS));
		panelActividades.setBounds(0, 75, 300, 325);
		panelActividades.setOpaque(false);

		ActivityManager.setPanel(panelActividades);
		
		Notificaciones.add(panelActividades,BorderLayout.CENTER);

		regresar.addActionListener(e->{
			ventana.dispose();
		});

		ventana.setVisible(true);
	}

	public void showSettings() {

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
		PanelRounded Ajustes = new PanelRounded(20,true,true,true,true);
		Ajustes.setLayout(new BorderLayout());
		Ajustes.setSize(300,400);
		Ajustes.setLocation(810,340);
		Ajustes.setBackground(Color.decode("#000D56"));
		Ajustes.setOpaque(false);
		ventana.add(Ajustes);

		PanelRounded panelSup = new PanelRounded(20,true,true,false,false);
		panelSup.setOpaque(false);
		panelSup.setLayout(new BorderLayout());
		panelSup.setBackground(Color.decode("#000D56"));
		Ajustes.add(panelSup,BorderLayout.NORTH);

		JLabel tituAjustes = new JLabel("Ajustes");
		tituAjustes.setOpaque(false);
		tituAjustes.setForeground(Color.white);
		tituAjustes.setHorizontalAlignment(JLabel.CENTER);
		tituAjustes.setFont(new Font("Poppins",Font.BOLD,15));
		tituAjustes.setHorizontalTextPosition(JLabel.CENTER);
		tituAjustes.setBounds(75,0,225,75);
		panelSup.add(tituAjustes, BorderLayout.CENTER);

		URL url = getClass().getResource("/iconos/adicionales/anterior.png");//Carga ubi imagen

		ButtonRounded regresar = new ButtonRounded("",20,1);
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		regresar.setPreferredSize(new Dimension(74,74));
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSup.add(regresar, BorderLayout.WEST);

		regresar.addActionListener(e->{
			ventana.dispose();
		});

		PanelRounded panelCentral = new PanelRounded(20,false,false,false,false);
		panelCentral.setBackground(Color.white);
		panelCentral.setLayout(null);
		panelCentral.setBounds(0, 75, 300, 325);
		panelCentral.setOpaque(false);
		Ajustes.add(panelCentral,BorderLayout.CENTER);

		JLabel nitsAct = new JLabel("Notificaciones Activas");
		nitsAct.setBounds(30,50,150,30);
		nitsAct.setOpaque(false);
		nitsAct.setForeground(Color.BLACK);
		nitsAct.setHorizontalAlignment(JLabel.CENTER);
		nitsAct.setFont(new Font("Poppins",Font.PLAIN,14));
		panelCentral.add(nitsAct);

		//Toggle button de notificacioens activadas
		ToggleButtonRounded toggleNoti = new ToggleButtonRounded();
		toggleNoti.setBounds(200,50,50,30);
		if(toggleNoti.isSelected()) {
		}
		toggleNoti.setOpaque(false);
		panelCentral.add(toggleNoti);

		ButtonRounded apliCambios = new ButtonRounded("Aplicar Cambios", 10, 1);
		apliCambios.setBounds(50, 200, 200, 70);
		apliCambios.setOpaque(false);
		apliCambios.setBackground(Color.decode("#000D56"));
		apliCambios.setFont(new Font("Poppins",Font.BOLD,15));

		apliCambios.addActionListener(e->{
			ventana.dispose();
		});

		panelCentral.add(apliCambios);
		ventana.setVisible(true);

	}

	public void showProfile() {
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
		PanelRounded perfil = new PanelRounded(20,true,true,true,true);
		perfil.setLayout(new BorderLayout());
		perfil.setSize(300,400);
		perfil.setLocation(810,340);
		perfil.setBackground(Color.decode("#000D56"));
		perfil.setOpaque(false);
		ventana.add(perfil);

		PanelRounded panelSup = new PanelRounded(20,true,true,false,false);
		panelSup.setOpaque(false);
		panelSup.setLayout(new BorderLayout());
		panelSup.setBackground(Color.decode("#000D56"));
		perfil.add(panelSup,BorderLayout.NORTH);

		URL url = getClass().getResource("/iconos/barra_superior/perfil.png");//Carga ubi imagen


		JLabel iconoPerfil = new JLabel(new ImageIcon(url));
		iconoPerfil.setOpaque(false);
		iconoPerfil.setHorizontalAlignment(JLabel.LEFT);
		iconoPerfil.setBorder(new EmptyBorder(0, 50, 0, 0));
		iconoPerfil.setBounds(75,0,225,75);
		panelSup.add(iconoPerfil, BorderLayout.CENTER);

		url = getClass().getResource("/iconos/adicionales/anterior.png");//Carga ubi imagen

		ButtonRounded regresar = new ButtonRounded("",20,1);
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		regresar.setPreferredSize(new Dimension(74,74));
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSup.add(regresar, BorderLayout.WEST);

		regresar.addActionListener(e->{
			ventana.dispose();
		});

		PanelRounded panelCentral = new PanelRounded(20,false,false,true,true);
		panelCentral.setBackground(Color.white);
		panelCentral.setLayout(null);
		panelCentral.setBounds(0, 75, 300, 325);
		panelCentral.setOpaque(false);
		perfil.add(panelCentral,BorderLayout.CENTER);

		JLabel usuario = new JLabel("Jonathan Soto");
		usuario.setBounds(80,50,150,30);
		usuario.setOpaque(false);
		usuario.setForeground(Color.BLACK);
		usuario.setHorizontalAlignment(JLabel.LEFT);
		usuario.setHorizontalTextPosition(JLabel.RIGHT);
		usuario.setFont(new Font("Poppins",Font.BOLD,15));
		url = getClass().getResource("/iconos/barra_superior/iconos_del_perfil/usuario_negro.png");
		usuario.setIcon(new ImageIcon(url));
		panelCentral.add(usuario);

		JLabel correo = new JLabel("jsoto@uabcs.mx");
		correo.setBounds(80,90,150,30);
		correo.setOpaque(false);
		correo.setForeground(Color.BLACK);
		correo.setHorizontalAlignment(JLabel.LEFT);
		correo.setHorizontalTextPosition(JLabel.RIGHT);
		correo.setFont(new Font("Poppins",Font.BOLD,14));
		url = getClass().getResource("/iconos/barra_superior/iconos_del_perfil/correo_negro.png");
		correo.setIcon(new ImageIcon(url));
		panelCentral.add(correo);

		JLabel rol = new JLabel("Admin");
		rol.setBounds(80,130,150,30);
		rol.setOpaque(false);
		rol.setForeground(Color.BLACK);
		rol.setHorizontalAlignment(JLabel.LEFT);
		rol.setHorizontalTextPosition(JLabel.RIGHT);
		rol.setFont(new Font("Poppins",Font.BOLD,14));
		url = getClass().getResource("/iconos/barra_superior/iconos_del_perfil/puesto_negro.png");
		rol.setIcon(new ImageIcon(url));
		panelCentral.add(rol);

		ButtonRounded salir = new ButtonRounded("Salir", 10, 5);
		salir.setBounds(50, 200, 70, 40);
		salir.setOpaque(false);
		salir.setBackground(Color.decode("#000D56"));
		salir.setFont(new Font("Poppins",Font.BOLD,15));

		salir.addActionListener(e->{
			System.exit(0);
		});
		panelCentral.add(salir);

		ButtonRounded editarPerfil = new ButtonRounded("Editar Perfil", 10, 3);
		editarPerfil.setBounds(130, 200, 130, 40);
		editarPerfil.setOpaque(false);
		editarPerfil.setBackground(Color.decode("#000D56"));
		editarPerfil.setFont(new Font("Poppins",Font.BOLD,15));

		editarPerfil.addActionListener(e->{
			ventana.dispose();
		});

		panelCentral.add(editarPerfil);
		ventana.setVisible(true);

	}

	public void opciones() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);

		PanelRounded panelOpciones = new PanelRounded(10,true,true,true,true);
		panelOpciones.setVisible(true);
		panelOpciones.setLayout(new BorderLayout());
		panelOpciones.setBackground(Color.decode("#FFFFFF"));
		panelOpciones.setBounds(635,365,650,350);
		ventana.add(panelOpciones);

		PanelRounded panelSupOpciones = new PanelRounded(10,true,true,false,false);
		panelSupOpciones.setVisible(true);
		panelSupOpciones.setLayout(new BorderLayout());
		panelSupOpciones.setBackground(Color.decode("#000D56"));
		panelSupOpciones.setPreferredSize(new Dimension(0,120));
		panelOpciones.add(panelSupOpciones,BorderLayout.NORTH);

		JLabel tituloOpciones = new JLabel("Opciones");
		tituloOpciones.setBorder(new EmptyBorder(0, 0, 0, 60));
		tituloOpciones.setOpaque(false);
		tituloOpciones.setForeground(Color.white);
		tituloOpciones.setHorizontalAlignment(JLabel.CENTER);
		tituloOpciones.setFont(new Font("Poppins",Font.BOLD,30));
		tituloOpciones.setHorizontalTextPosition(JLabel.CENTER);
		panelSupOpciones.add(tituloOpciones,BorderLayout.CENTER);

		JButton regresar = new JButton();
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		URL url = getClass().getResource("/iconos/adicionales/anterior.png");
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSupOpciones.add(regresar,BorderLayout.WEST);
		regresar.addActionListener(e->{
			ventana.dispose();
		});

		PanelRounded contOpciones = new PanelRounded(10,true,true,true,true);
		contOpciones.setLayout(null);
		contOpciones.setVisible(true);
		panelOpciones.add(contOpciones,BorderLayout.CENTER);

		PanelRounded contMarcas = new PanelRounded(10,true,true,true,true);
		contMarcas.setLayout(null);
		contMarcas.setSize(150,100);
		contMarcas.setLocation(50,50);
		contMarcas.setOpaque(false);
		contOpciones.add(contMarcas);

		LabelRounded tituloMarcas = new LabelRounded("Agregar Marcas",10,Color.decode("#000D56"));
		tituloMarcas.setOpaque(false);
		tituloMarcas.setForeground(Color.white);
		tituloMarcas.setBounds(0, 0, 150, 25);
		tituloMarcas.setHorizontalAlignment(JLabel.CENTER);
		tituloMarcas.setFont(new Font("Poppins",Font.BOLD,15));
		contMarcas.add(tituloMarcas);

		url = getClass().getResource("/iconos/adicionales/agregar_marca.png");

		ButtonRounded marcas = new ButtonRounded("",10,3);
		marcas.setFocusPainted(false);
		marcas.setBounds(0,25,150,75);
		marcas.setBackground(Color.decode("#D9D9D9"));
		marcas.setOpaque(false);
		if (url != null) {
			marcas.setIcon(new ImageIcon(url));
		}
		marcas.addActionListener(e->{
			addMarca();
		});
		contMarcas.add(marcas);
		
		PanelRounded contModelos = new PanelRounded(10,true,true,true,true);
		contModelos.setLayout(null);
		contModelos.setSize(150,100);
		contModelos.setLocation(250,50);
		contModelos.setOpaque(false);
		contOpciones.add(contModelos);

		LabelRounded tituloModelos = new LabelRounded("Agregar Modelos",10,Color.decode("#000D56"));
		tituloModelos.setOpaque(false);
		tituloModelos.setForeground(Color.white);
		tituloModelos.setBounds(0, 0, 150, 25);
		tituloModelos.setHorizontalAlignment(JLabel.CENTER);
		tituloModelos.setFont(new Font("Poppins",Font.BOLD,15));
		contModelos.add(tituloModelos);

		url = getClass().getResource("/iconos/adicionales/car.png");

		ButtonRounded modelos = new ButtonRounded("",10,3);
		modelos.setFocusPainted(false);
		modelos.setBounds(0,25,150,75);
		modelos.setBackground(Color.decode("#D9D9D9"));
		modelos.setOpaque(false);
		if (url != null) {
			modelos.setIcon(new ImageIcon(url));
		}
		modelos.addActionListener(e->{
			addModelo();
		});
		contModelos.add(modelos);

		PanelRounded contCategorias = new PanelRounded(10,true,true,true,true);
		contCategorias.setLayout(null);
		contCategorias.setSize(150,100);
		contCategorias.setLocation(450,50);
		contCategorias.setOpaque(false);
		contOpciones.add(contCategorias);

		LabelRounded tituloCategorias = new LabelRounded("Agregar Categoria",10,Color.decode("#000D56"));
		tituloCategorias.setOpaque(false);
		tituloCategorias.setForeground(Color.white);
		tituloCategorias.setBounds(0, 0, 150, 25);
		tituloCategorias.setHorizontalAlignment(JLabel.CENTER);
		tituloCategorias.setFont(new Font("Poppins",Font.BOLD,15));
		contCategorias.add(tituloCategorias);

		url = getClass().getResource("/iconos/adicionales/agregar_categoria.png");

		ButtonRounded categorias = new ButtonRounded("",10,3);
		categorias.setFocusPainted(false);
		categorias.setBounds(0,25,150,75);
		categorias.setBackground(Color.decode("#D9D9D9"));
		categorias.setOpaque(false);
		if (url != null) {
			categorias.setIcon(new ImageIcon(url));
		}
		categorias.addActionListener(e->{
			addCat();
		});
		contCategorias.add(categorias);
		ventana.setVisible(true);

	}

	public void addCat() {
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
		panelCat.setBounds(635,365,650,350);
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
		contCat.setLayout(null);
		contCat.setVisible(true);
		panelCat.add(contCat,BorderLayout.CENTER);

		JLabel etiquetaCat = new JLabel("Categoría");
		etiquetaCat.setOpaque(false);
		etiquetaCat.setForeground(Color.black);
		etiquetaCat.setHorizontalAlignment(JLabel.LEFT);
		etiquetaCat.setFont(new Font("Poppins",Font.PLAIN,15));
		etiquetaCat.setBounds(150,40,100,30);
		contCat.add(etiquetaCat);

		TextFieldRounded campoCat = new TextFieldRounded(20,10,true);
		campoCat.setBounds(150,80,350,50);
		campoCat.setOpaque(false);
		campoCat.setFont(new Font("Poppins",Font.BOLD,12));
		campoCat.setForeground(Color.decode("#8B8B8B"));
		campoCat.setHorizontalAlignment(JLabel.LEFT);
		campoCat.setText("Sedan");
		campoCat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoCat.getText().equals("Sedan")) {
					campoCat.setText(""); // Vaciar la caja
					campoCat.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoCat.getText().isEmpty()) {
					campoCat.setText("Sedan");// Restaurar el mensaje
					campoCat.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		contCat.add(campoCat);

		ButtonRounded regCat = new ButtonRounded("Registrar Categoría",10,1);
		regCat.setBounds(150,140,350,50);
		regCat.setOpaque(false);
		regCat.setFont(new Font("Poppins",Font.BOLD,15));
		regCat.setForeground(Color.white);
		regCat.setHorizontalAlignment(JLabel.CENTER);
		regCat.addActionListener(e->{
			control.generarCategoria(campoCat.getText());
		});
		
		contCat.add(regCat);

		ventana.setVisible(true);
	}

	public void addMarca() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);

		PanelRounded panelMarca = new PanelRounded(10,true,true,true,true);
		panelMarca.setVisible(true);
		panelMarca.setLayout(new BorderLayout());
		panelMarca.setBackground(Color.decode("#FFFFFF"));
		panelMarca.setBounds(635,365,650,350);
		ventana.add(panelMarca);

		PanelRounded panelSupMarca = new PanelRounded(10,true,true,false,false);
		panelSupMarca.setVisible(true);
		panelSupMarca.setLayout(new BorderLayout());
		panelSupMarca.setBackground(Color.decode("#000D56"));
		panelSupMarca.setPreferredSize(new Dimension(0,120));
		panelMarca.add(panelSupMarca,BorderLayout.NORTH);

		JLabel tituloMarca = new JLabel("AGREGAR MARCA");
		tituloMarca.setBorder(new EmptyBorder(0, 0, 0, 30));
		tituloMarca.setForeground(Color.white);
		tituloMarca.setOpaque(false);
		tituloMarca.setHorizontalAlignment(JLabel.CENTER);
		tituloMarca.setFont(new Font("Poppins",Font.BOLD,30));
		tituloMarca.setHorizontalTextPosition(JLabel.CENTER);
		panelSupMarca.add(tituloMarca,BorderLayout.CENTER);

		JButton regresar = new JButton();
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		URL url = getClass().getResource("/iconos/adicionales/anterior.png");
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		regresar.addActionListener(e->{
			ventana.dispose();
		});
		panelSupMarca.add(regresar,BorderLayout.WEST);

		PanelRounded contMarca = new PanelRounded(10,true,true,true,true);
		contMarca.setBackground(Color.white);
		contMarca.setLayout(null);
		contMarca.setVisible(true);
		panelMarca.add(contMarca,BorderLayout.CENTER);

		JLabel etiquetaMarca = new JLabel("Marca");
		etiquetaMarca.setOpaque(false);
		etiquetaMarca.setForeground(Color.black);
		etiquetaMarca.setHorizontalAlignment(JLabel.LEFT);
		etiquetaMarca.setFont(new Font("Poppins",Font.PLAIN,15));
		etiquetaMarca.setBounds(150,40,100,30);
		contMarca.add(etiquetaMarca);

		TextFieldRounded campoMarca = new TextFieldRounded(20,10,true);
		campoMarca.setBounds(150,80,350,50);
		campoMarca.setOpaque(false);
		campoMarca.setFont(new Font("Poppins",Font.BOLD,12));
		campoMarca.setForeground(Color.decode("#8B8B8B"));
		campoMarca.setHorizontalAlignment(JLabel.LEFT);
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
					campoMarca.setText("Toyota");// Restaurar el mensaje
					campoMarca.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		contMarca.add(campoMarca);

		ButtonRounded regMarca = new ButtonRounded("Registrar Marca",10,1);
		regMarca.setBounds(150,140,350,50);
		regMarca.setOpaque(false);
		regMarca.setFont(new Font("Poppins",Font.BOLD,15));
		regMarca.setForeground(Color.white);
		regMarca.setHorizontalAlignment(JLabel.CENTER);
		regMarca.addActionListener(e->{
			System.out.println("marca a guardar"+campoMarca.getText());
			control.generarMarca(campoMarca.getText());
		});
		contMarca.add(regMarca);

		ventana.setVisible(true);
	}

	public void addModelo() {
		// Crear Ventana JDialog
		JDialog ventana = new JDialog();
		ventana.setModal(true);
		ventana.setUndecorated(true);
		ventana.setSize(1920, 1080);
		ventana.setBackground(new Color(0, 0, 0, 120)); 
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);

		PanelRounded panelMod = new PanelRounded(10,true,true,true,true);
		panelMod.setVisible(true);
		panelMod.setLayout(new BorderLayout());
		panelMod.setBackground(Color.decode("#FFFFFF"));
		panelMod.setBounds(635,365,650,350);
		ventana.add(panelMod);

		PanelRounded panelSupMod = new PanelRounded(10,true,true,false,false);
		panelSupMod.setVisible(true);
		panelSupMod.setLayout(new BorderLayout());
		panelSupMod.setBackground(Color.decode("#000D56"));
		panelSupMod.setPreferredSize(new Dimension(0,120));
		panelMod.add(panelSupMod,BorderLayout.NORTH);

		JLabel tituloMod = new JLabel("AGREGAR MODELO");
		tituloMod.setBorder(new EmptyBorder(0, 0, 0, 20));
		tituloMod.setForeground(Color.white);
		tituloMod.setOpaque(false);
		tituloMod.setHorizontalAlignment(JLabel.CENTER);
		tituloMod.setFont(new Font("Poppins",Font.BOLD,30));
		tituloMod.setHorizontalTextPosition(JLabel.CENTER);
		panelSupMod.add(tituloMod,BorderLayout.CENTER);

		JButton regresar = new JButton();
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		URL url = getClass().getResource("/iconos/adicionales/anterior.png");
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSupMod.add(regresar,BorderLayout.WEST);
		regresar.addActionListener(e->{
			ventana.dispose();
		});

		PanelRounded contMod = new PanelRounded(10,true,true,true,true);
		contMod.setBackground(Color.white);
		contMod.setLayout(null);
		contMod.setVisible(true);
		panelMod.add(contMod,BorderLayout.CENTER);
		
		ArrayList<String> marcas = control.getListaMarcas();
		ComboBoxRounded<String> listMarcas = new ComboBoxRounded<>(marcas);
		listMarcas.setFont(new Font("Poppins", Font.BOLD, 15));
		listMarcas.setForeground(Color.black);
		listMarcas.setOpaque(false);
		listMarcas.setSize(350,40);
		listMarcas.setLocation(150,10);
		contMod.add(listMarcas);

		JLabel etiquetaMod = new JLabel("Modelo");
		etiquetaMod.setOpaque(false);
		etiquetaMod.setForeground(Color.black);
		etiquetaMod.setHorizontalAlignment(JLabel.LEFT);
		etiquetaMod.setFont(new Font("Poppins",Font.PLAIN,15));
		etiquetaMod.setBounds(150,50,100,30);
		contMod.add(etiquetaMod);

		TextFieldRounded campoMod = new TextFieldRounded(20,10,true);
		campoMod.setBounds(150,80,350,50);
		campoMod.setOpaque(false);
		campoMod.setFont(new Font("Poppins",Font.BOLD,12));
		campoMod.setForeground(Color.decode("#8B8B8B"));
		campoMod.setHorizontalAlignment(JLabel.LEFT);
		campoMod.setText("Toyota");
		campoMod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (campoMod.getText().equals("Toyota")) {
					campoMod.setText(""); // Vaciar la caja
					campoMod.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (campoMod.getText().isEmpty()) {
					campoMod.setText("Toyota");// Restaurar el mensaje
					campoMod.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		contMod.add(campoMod);

		ButtonRounded regMod = new ButtonRounded("Registrar Modelo",10,1);
		regMod.setBounds(150,140,350,50);
		regMod.setOpaque(false);
		regMod.setFont(new Font("Poppins",Font.BOLD,15));
		regMod.setForeground(Color.white);
		regMod.setHorizontalAlignment(JLabel.CENTER);
		regMod.addActionListener(e->{
			control.generarModelo(listMarcas.getSelectedItem().toString(), campoMod.getText());
		});
		contMod.add(regMod);

		ventana.setVisible(true);
	}
}
