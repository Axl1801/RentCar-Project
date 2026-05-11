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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.AuthController;
import Controllers.ClientController;
import Controllers.DashController;
import Controllers.EstablishmentController;
import Controllers.HomeController;
import Controllers.RentController;
import Controllers.VehicleController;
import Utilities.Activities;
import Utilities.Alerts;
import Utilities.ButtonRounded;
import Utilities.ComboBoxRounded;
import Utilities.LabelRounded;
import Utilities.PanelRounded;
import Utilities.ResponsiveImageLabel;
import Utilities.TextFieldRounded;
import Utilities.ToggleButtonRounded;

public class HomeView {
	public HomeView(){
		
	}
	
	public void home() {
		
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
	    	opcionesMarcas();
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
        HomeController hc = new HomeController();
        
        panelContenido.add(hv,"vistaHome");
        panelContenido.add(cc.showClientView(),"vistaCliente");
        panelContenido.add(dc.showDashboard(),"vistaDashboard");
        panelContenido.add(ec.showEstablishment(),"vistaEstablecimiento");
        panelContenido.add(rc.showRent(),"vistaRentas");
        panelContenido.add(vc.showVehicle(),"vistaVehiculos");
        panelContenido.add(hc.showUser(),"vistaUsuario");
        
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
        	cl.show(panelContenido,"vistaUsuario");
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
	    
	    panelActividades.add(new Activities( "Vehiculo Entregado","V-001 Corolla","Hace 1 Hora",Color.decode("#308C52")),0);
	    panelActividades.add(new Activities( "Nueva renta creada","Cliente: Esau Garcia","Hace 3 Horas",Color.decode("#4C75B7")),0);
	    panelActividades.add(new Activities( "Vehiculo en Mantenimiento","V-007 Versa ","Hace 7 Horas",Color.decode("#C79E59")),0);
		
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
	
	public JPanel showProfile() {
		JPanel fondoOscuro = new JPanel();
		fondoOscuro.setVisible(true);
		fondoOscuro.setEnabled(true);
		fondoOscuro.setSize(1920,1080);
		fondoOscuro.setOpaque(true);
		fondoOscuro.setLayout(new GridBagLayout());
		fondoOscuro.setBackground(new Color(0, 0, 0, 100));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		PanelRounded userPanel = new PanelRounded(10,true,true,true,true);
		userPanel.setBackground(Color.white);
		userPanel.setLayout(new BorderLayout());
		userPanel.setOpaque(false);
		//Panel superior de la ventana 
		PanelRounded panelSupUser = new PanelRounded(10,true,true,false,false);
		panelSupUser.setBackground(Color.decode("#000D56"));
		panelSupUser.setLayout(new BorderLayout());
		panelSupUser.setOpaque(false);
		
		URL url = getClass().getResource("/iconos/barra_superior/perfil.png");//Carga ubi imagen
		//JLabel para almacenar el icono de la ventana
		JLabel iconoPerfil = new JLabel();
		iconoPerfil.setOpaque(false);
		iconoPerfil.setHorizontalAlignment(JLabel.CENTER);
		iconoPerfil.setPreferredSize(new Dimension(0,100));
		if (url != null) {
			iconoPerfil.setIcon(new ImageIcon(url));
		}
		panelSupUser.add(iconoPerfil,BorderLayout.CENTER);
		
		 url = getClass().getResource("/iconos/adicionales/anterior.png");//Carga ubi imagen
		//Boton de regresar
		JButton regresar = new JButton();
		regresar.setContentAreaFilled(false); // Sin fondo
		regresar.setBorderPainted(false); // Sin borde
		regresar.setFocusPainted(false); // Sin línea de focus
		if (url != null) {
			regresar.setIcon(new ImageIcon(url));
		}
		panelSupUser.add(regresar,BorderLayout.WEST);
		
		userPanel.add(panelSupUser,BorderLayout.NORTH);
		
		//Panel para almacenar los datos
		JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.setOpaque(false);
		
		//JLabel de nombre del usuario
		JLabel nombreUsuario = new JLabel("Jonathan Soto");
		nombreUsuario.setOpaque(false);
		nombreUsuario.setForeground(Color.black);
		nombreUsuario.setHorizontalAlignment(JLabel.CENTER);
		nombreUsuario.setFont(new Font("Poppins",Font.PLAIN,16));
		nombreUsuario.setHorizontalTextPosition(JLabel.RIGHT);
		url = getClass().getResource("/iconos/barra_superior/iconos_del_perfil/usuario_negro.png");//Carga ubi imagen
		if (url != null) {
			nombreUsuario.setIcon(new ImageIcon(url));
		}
		
		//JLabel de correo del usuario
		JLabel correoUsuario = new JLabel("jsoto@uabcs.mx");
		correoUsuario.setOpaque(false);
		correoUsuario.setForeground(Color.black);
		correoUsuario.setHorizontalAlignment(JLabel.CENTER);
		correoUsuario.setFont(new Font("Poppins",Font.PLAIN,16));
		correoUsuario.setHorizontalTextPosition(JLabel.RIGHT);
		url = getClass().getResource("/iconos/barra_superior/iconos_del_perfil/correo_negro.png");//Carga ubi imagen
		if (url != null) {
			correoUsuario.setIcon(new ImageIcon(url));
		}
		
		//JLabel de nombre del usuario
		JLabel rolUsuario = new JLabel("Admin");
		rolUsuario.setOpaque(false);
		rolUsuario.setForeground(Color.black);
		rolUsuario.setHorizontalAlignment(JLabel.CENTER);
		rolUsuario.setFont(new Font("Poppins",Font.PLAIN,16));
		rolUsuario.setHorizontalTextPosition(JLabel.RIGHT);
		url = getClass().getResource("/iconos/barra_superior/iconos_del_perfil/puesto_negro.png");//Carga ubi imagen
		if (url != null) {
			rolUsuario.setIcon(new ImageIcon(url));
		}
		//introduccion de los jlabels de datos en el panel del centro
		panelDatos.add(nombreUsuario);
		panelDatos.add(correoUsuario);
		panelDatos.add(rolUsuario);
		
	    userPanel.add(panelDatos,BorderLayout.CENTER);
	    
	    JPanel panelInfUser = new JPanel();
	    panelInfUser.setBackground(Color.decode("#000D56"));
	    panelInfUser.setLayout(new FlowLayout());
	    panelInfUser.setOpaque(false);
	    
	    ButtonRounded editarPerfil = new ButtonRounded("Editar Perfil",10,3);
	    editarPerfil.setFont(new Font("Poppins",Font.PLAIN,15));
	    editarPerfil.setContentAreaFilled(false);
	    editarPerfil.setFocusPainted(false);
	    editarPerfil.setHorizontalAlignment(JLabel.CENTER);
	    
	    panelInfUser.add(editarPerfil);
	    
	    ButtonRounded Salir = new ButtonRounded("Salir ",10,5);
	    Salir.setFont(new Font("Poppins",Font.PLAIN,15));
	    Salir.setContentAreaFilled(false);
	    Salir.setFocusPainted(false);
	    Salir.setHorizontalAlignment(JLabel.CENTER);
	    Salir.addActionListener(e->{
	    	System.exit(0);
	    });
	    
	    panelInfUser.add(Salir);
	    
	    userPanel.add(panelInfUser,BorderLayout.SOUTH);
	    
	    //Posicionamiento la ventana
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weightx = 2;
        gbc.weighty = 2;
        gbc.insets = new Insets(10, 0, 10, 0); // 
        gbc.fill = GridBagConstraints.NONE;
        fondoOscuro.add(userPanel,gbc);
        
        regresar.addActionListener(e->{
        	fondoOscuro.setVisible(false);
        });
        
        return fondoOscuro;
	}

	public void opcionesMarcas() {
		 // Crear Ventana
        JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(700, 320);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout());
        
        PanelRounded panelOpciones = new PanelRounded(10,true,true,true,true);
        panelOpciones.setVisible(true);
        panelOpciones.setLayout(new BorderLayout());
        panelOpciones.setBackground(Color.decode("#FFFFFF"));
        panelOpciones.setPreferredSize(new Dimension(0,120));
        ventana.add(panelOpciones,BorderLayout.CENTER);
        
        PanelRounded panelSupOpciones = new PanelRounded(10,true,true,false,false);
        panelSupOpciones.setVisible(true);
        panelSupOpciones.setLayout(new BorderLayout());
        panelSupOpciones.setBackground(Color.decode("#000D56"));
        panelSupOpciones.setPreferredSize(new Dimension(0,120));
        panelOpciones.add(panelSupOpciones,BorderLayout.NORTH);
        
        JLabel tituloOpciones = new JLabel("Opciones");
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
		
		PanelRounded agregarMarcas = new PanelRounded(10,true,true,true,true);
		agregarMarcas.setLayout(new FlowLayout());
		agregarMarcas.setVisible(true);
		panelOpciones.add(agregarMarcas,BorderLayout.CENTER);
		
		PanelRounded contMarcas = new PanelRounded(10,true,true,true,true);
		contMarcas.setLayout(new BorderLayout());
		contMarcas.setSize(100,100);
		contMarcas.setVisible(true);
		contMarcas.setOpaque(false);
		agregarMarcas.add(contMarcas);
		
        JLabel tituloMarcas = new JLabel("Agregar Marcas");
        tituloMarcas.setOpaque(true);
        tituloMarcas.setForeground(Color.white);
        tituloMarcas.setBackground(Color.decode("#000D56"));
        tituloMarcas.setHorizontalAlignment(JLabel.CENTER);
        tituloMarcas.setFont(new Font("Poppins",Font.BOLD,15));
        contMarcas.add(tituloMarcas, BorderLayout.NORTH);
        
        url = getClass().getResource("/iconos/adicionales/agregar_categoria.png");
        
        JButton marcas = new JButton();
        marcas.setFocusPainted(false);
        marcas.setBackground(Color.decode("#D9D9D9"));
        marcas.setOpaque(true);
		if (url != null) {
			marcas.setIcon(new ImageIcon(url));
		}
		marcas.addActionListener(e->{
			addMarca();
		});
		contMarcas.add(marcas, BorderLayout.CENTER);
		
		
		PanelRounded contCategorias = new PanelRounded(10,true,true,true,true);
		contCategorias.setLayout(new BorderLayout());
		contCategorias.setSize(100,100);
		contCategorias.setVisible(true);
		contCategorias.setOpaque(false);
		agregarMarcas.add(contCategorias);
		
		JLabel tituloCategorias = new JLabel("Agregar Categorias");
        tituloCategorias.setOpaque(true);
        tituloCategorias.setForeground(Color.white);
        tituloCategorias.setBackground(Color.decode("#000D56"));
        tituloCategorias.setHorizontalAlignment(JLabel.CENTER);
        tituloCategorias.setFont(new Font("Poppins",Font.PLAIN,15));
        contCategorias.add(tituloCategorias, BorderLayout.NORTH);
		
        url = getClass().getResource("/iconos/adicionales/agregar_marca.png");
        
        JButton categorias = new JButton();
        categorias.setFocusPainted(false);
        categorias.setBackground(Color.decode("#D9D9D9"));
        categorias.setOpaque(true);
		if (url != null) {
			categorias.setIcon(new ImageIcon(url));
		}
		contCategorias.add(categorias, BorderLayout.CENTER);
		categorias.addActionListener(e->{
			addCat();
		});
        ventana.setVisible(true);
        
	}
	
	public void addCat() {
		JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(700, 320);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout());
        
        PanelRounded panelOpciones = new PanelRounded(10,true,true,true,true);
        panelOpciones.setVisible(true);
        panelOpciones.setLayout(new BorderLayout());
        panelOpciones.setBackground(Color.decode("#FFFFFF"));
        panelOpciones.setPreferredSize(new Dimension(0,120));
        ventana.add(panelOpciones,BorderLayout.CENTER);
        
        PanelRounded panelSupOpciones = new PanelRounded(10,true,true,false,false);
        panelSupOpciones.setVisible(true);
        panelSupOpciones.setLayout(new BorderLayout());
        panelSupOpciones.setBackground(Color.decode("#000D56"));
        panelSupOpciones.setPreferredSize(new Dimension(0,120));
        panelOpciones.add(panelSupOpciones,BorderLayout.NORTH);
        
        JLabel tituloAgregarCategoria = new JLabel("Agregar Categoria");
        tituloAgregarCategoria.setOpaque(false);
        tituloAgregarCategoria.setForeground(Color.white);
        tituloAgregarCategoria.setHorizontalAlignment(JLabel.CENTER);
        tituloAgregarCategoria.setFont(new Font("Poppins",Font.BOLD,30));
        tituloAgregarCategoria.setHorizontalTextPosition(JLabel.CENTER);
        panelSupOpciones.add(tituloAgregarCategoria,BorderLayout.CENTER);
        
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
		
		PanelRounded agregarCat = new PanelRounded(10,true,true,true,true);
		agregarCat.setLayout(new BoxLayout(agregarCat, BoxLayout.Y_AXIS));
		agregarCat.setVisible(true);
		panelOpciones.add(agregarCat,BorderLayout.CENTER);
		
		PanelRounded contCat = new PanelRounded(10,true,true,true,true);
		contCat.setLayout(new BorderLayout());
		contCat.setSize(100,100);
		contCat.setVisible(true);
		contCat.setOpaque(false);
		agregarCat.add(contCat);
		
        JLabel tituloCat = new JLabel("Categoria");
        tituloCat.setOpaque(true);
        tituloCat.setForeground(Color.white);
        tituloCat.setBackground(Color.decode("#000D56"));
        tituloCat.setHorizontalAlignment(JLabel.CENTER);
        tituloCat.setFont(new Font("Poppins",Font.BOLD,15));
        agregarCat.add(tituloCat, BorderLayout.NORTH);
        
		TextFieldRounded campoCat = new TextFieldRounded(10, 10,false);
		campoCat.setFont(new Font("Poppins", Font.PLAIN, 15));
		campoCat.setForeground(Color.decode("#8B8B8B"));
		campoCat.setOpaque(false);
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
		        	campoCat.setForeground(Color.decode("#8B8B8B"));
		        	campoCat.setText("Sedan"); // Restaurar el mensaje
		        }
		    }
		});
		agregarCat.add(campoCat);
		
		ButtonRounded registrarCat = new ButtonRounded("Registrar Categoria",10,1);
		registrarCat.setOpaque(false);
		registrarCat.setForeground(Color.white);
		registrarCat.setHorizontalAlignment(JLabel.CENTER);
		registrarCat.setFont(new Font("Poppins",Font.BOLD,20));
		registrarCat.addActionListener(e->{
        	ventana.dispose();
     
		});
		
		agregarCat.add(registrarCat, BorderLayout.CENTER);
		
		ventana.setVisible(true);
	}

	public void addMarca() {

		JDialog ventana = new JDialog();
        ventana.setModal(true);
        ventana.setUndecorated(true);
        ventana.setSize(700, 320);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout());
        
        PanelRounded panelOpciones = new PanelRounded(10,true,true,true,true);
        panelOpciones.setVisible(true);
        panelOpciones.setLayout(new BorderLayout());
        panelOpciones.setBackground(Color.decode("#FFFFFF"));
        panelOpciones.setPreferredSize(new Dimension(0,120));
        ventana.add(panelOpciones,BorderLayout.CENTER);
        
        PanelRounded panelSupOpciones = new PanelRounded(10,true,true,false,false);
        panelSupOpciones.setVisible(true);
        panelSupOpciones.setLayout(new BorderLayout());
        panelSupOpciones.setBackground(Color.decode("#000D56"));
        panelSupOpciones.setPreferredSize(new Dimension(0,120));
        panelOpciones.add(panelSupOpciones,BorderLayout.NORTH);
        
        JLabel tituloAgregarMarca = new JLabel("Agregar Marca");
        tituloAgregarMarca.setOpaque(false);
        tituloAgregarMarca.setForeground(Color.white);
        tituloAgregarMarca.setHorizontalAlignment(JLabel.CENTER);
        tituloAgregarMarca.setFont(new Font("Poppins",Font.BOLD,30));
        tituloAgregarMarca.setHorizontalTextPosition(JLabel.CENTER);
        panelSupOpciones.add(tituloAgregarMarca,BorderLayout.CENTER);
        
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
		
		PanelRounded agregarMarca = new PanelRounded(10,true,true,true,true);
		agregarMarca.setLayout(new BoxLayout(agregarMarca, BoxLayout.Y_AXIS));
		agregarMarca.setVisible(true);
		panelOpciones.add(agregarMarca,BorderLayout.CENTER);
		
		PanelRounded contMarca = new PanelRounded(10,true,true,true,true);
		contMarca.setLayout(new BorderLayout());
		contMarca.setSize(100,100);
		contMarca.setVisible(true);
		contMarca.setOpaque(false);
		agregarMarca.add(contMarca);
		
        JLabel tituloMarca = new JLabel("Marca");
        tituloMarca.setOpaque(true);
        tituloMarca.setForeground(Color.white);
        tituloMarca.setBackground(Color.decode("#000D56"));
        tituloMarca.setHorizontalAlignment(JLabel.CENTER);
        tituloMarca.setFont(new Font("Poppins",Font.BOLD,15));
        agregarMarca.add(tituloMarca, BorderLayout.NORTH);
        
		TextFieldRounded campoMarca = new TextFieldRounded(10, 10,false);
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
		        	campoMarca.setForeground(Color.decode("#8B8B8B"));
		        	campoMarca.setText("Toyota"); // Restaurar el mensaje
		        }
		    }
		});
		agregarMarca.add(campoMarca);
		
		ButtonRounded registrarMarca = new ButtonRounded("Registrar Marca",10,1);
		registrarMarca.setOpaque(false);
		registrarMarca.setForeground(Color.white);
		registrarMarca.setHorizontalAlignment(JLabel.CENTER);
		registrarMarca.setFont(new Font("Poppins",Font.BOLD,20));
		registrarMarca.addActionListener(e->{
        	ventana.dispose();
     
		});
		
		agregarMarca.add(registrarMarca, BorderLayout.CENTER);
		
		ventana.setVisible(true);
	}
}
