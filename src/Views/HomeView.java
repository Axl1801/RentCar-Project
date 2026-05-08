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
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import Utilities.ButtonRounded;
import Utilities.PanelRounded;
import Utilities.ResponsiveImageLabel;

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
        
        JButton botonNotificaciones = new JButton();
	    url = getClass().getResource("/iconos/barra_superior/notificaciones.png");//Carga ubi imagen
	    if (url != null) {
	    	botonNotificaciones.setIcon(new ImageIcon(url));
	    }
        botonNotificaciones.setBorder(null);
        botonNotificaciones.setContentAreaFilled(false);
        botonNotificaciones.setFocusPainted(false);
        panelBotones.add(botonNotificaciones);
        
        JButton botonAjustes = new JButton();
	    url = getClass().getResource("/iconos/barra_superior/ajustes.png");//Carga ubi imagen
	    if (url != null) {
	    	botonAjustes.setIcon(new ImageIcon(url));
	    }
	    botonAjustes.setBorder(null);
	    botonAjustes.setContentAreaFilled(false);
	    botonAjustes.setFocusPainted(false);
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
        VehicleController vC = new VehicleController();
        
        panelContenido.add(hv,"vistaHome");
        panelContenido.add(cc.showClientView(),"vistaCliente");
        panelContenido.add(dc.showDashboard(),"vistaDashboard");
        panelContenido.add(ec.showEstablishment(),"vistaEstablecimiento");
        panelContenido.add(rc.showRent(),"vistaRentas");
        panelContenido.add(vC.showVehicle(),"vistaVehiculos");
            
        clientes.addActionListener(e->{
        	tituloPanel.setText("Clientes");
        	cl.show(panelContenido,"vistaCliente");
        });
        
        dashboard.addActionListener(e->{
        	tituloPanel.setText("Dashboard");
        	cl.show(panelContenido,"vistaDashboard");
        });
        
        Locales.addActionListener(e->{
        	tituloPanel.setText("Establecimientos");
        	cl.show(panelContenido,"vistaEstablecimiento");
        });
        
        rentas.addActionListener(e->{
        	tituloPanel.setText("Rentas");
        	cl.show(panelContenido,"vistaRentas");
        });
        
        vehiculos.addActionListener(e->{
        	tituloPanel.setText("Vehiculos");
        	cl.show(panelContenido,"vistaVehiculos");
        });
        
        cerrarSesion.addActionListener(e->{
        	ventana.dispose();
        	ac.login();
        });
        
        ventana.revalidate();
        ventana.repaint();
	}
}
