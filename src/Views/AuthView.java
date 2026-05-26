package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import Controllers.HomeController;
import Models.AuthModel;
import Utilities.Alerts;
import Utilities.ButtonRounded;
import Utilities.CheckBoxRounded;
import Utilities.LabelRounded;
import Utilities.PasswordFieldRounded;
import Utilities.TextFieldRounded;

public class AuthView {

	private AuthModel model;

	public AuthView() {
		model = new AuthModel();
	}

	public void showLogin() {

		// Creada Ventana
		JFrame ventana = new JFrame("Paz Drive");
		ventana.setSize(1920, 1080);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(new BorderLayout(0,0));

		//Contenedor para colocar los componentes desde el fondo hasta el Login
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new OverlayLayout(contenedor));

		//Panel para el fondo, con la imagen correctamente creada
		JPanel fondo = new JPanel();
		fondo.setOpaque(true);
		fondo.setLayout(new BorderLayout(0,0));
		//Imagen dentro de una ImageIcon
		ImageIcon imagenFondo = new ImageIcon(
				getClass().getResource("/Imagenes-sprites/FondoPazDrive.png")
				);
		//Label contenedor de la imagen con metodo para escalarla
		JLabel labelfondo = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
		//Incluimos la imagen en el panel fondo
		fondo.add(labelfondo,BorderLayout.CENTER);

		//Panel para el logotipo del login
		JPanel logoFondo = new JPanel();
		logoFondo.setOpaque(false);
		logoFondo.setLayout(null);

		//Imagen del logotipo del Login
		ImageIcon logoLogin = new ImageIcon(
				getClass().getResource("/Imagenes-sprites/paz_drive_logo_white.png")
				);

		//Label del logotipo con sus dimensiones y posicion
		JLabel logotipo = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(logoLogin.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};

		//proporciones
		double xRatio = 280.0 / 1920.0;
		double yRatio = 305.0 / 1080.0;
		double wRatio = 450.0 / 1920.0;
		double hRatio = 450.0 / 1080.0;

		//Agregamos el logotipo al panel logoFondo
		logoFondo.add(logotipo);


		//contenedor del login
		JPanel loginCont = new JPanel();
		loginCont.setOpaque(false);
		loginCont.setLayout(null);

		//Panel del login
		JPanel login = new JPanel();
		login.setOpaque(false);
		login.setLayout(new BorderLayout());

		//proporciones del login
		double lx = 960.0 / 1920.0;
		double ly = 180.0 / 1080.0;
		double lw = 600.0 / 1920.0;
		double lh = 650.0 / 1080.0;

		//Agregamos el login al contendor del login
		loginCont.add(login);

		//Panel de elementos login
		JPanel loginElementos = new JPanel();
		loginElementos.setOpaque(false);        
		loginElementos.setLayout(null);

		login.add(loginElementos);

		//Elementos del Login
		JLabel tituloLogin = new JLabel("Acceso Al Sistema"); //Etiqueta principal
		tituloLogin.setOpaque(true);
		tituloLogin.setBackground(Color.decode("#FFFFFF"));
		tituloLogin.setBounds(75,50,400,50);
		tituloLogin.setFont(new Font("Poppins",Font.BOLD,40));
		tituloLogin.setHorizontalAlignment(JLabel.LEFT);
		tituloLogin.setForeground(Color.BLACK);
		loginElementos.add(tituloLogin);

		JLabel subTituloLogin = new JLabel("Ingrese sus credenciales para acceder");//Etiqueta Subtitulo
		subTituloLogin.setOpaque(true);
		subTituloLogin.setBounds(75,80,400,50);
		subTituloLogin.setFont(new Font("Poppins",Font.PLAIN,16));
		subTituloLogin.setHorizontalAlignment(JLabel.LEFT);
		subTituloLogin.setBackground(Color.decode("#FFFFFF"));
		subTituloLogin.setForeground(Color.decode("#99A1AF"));
		loginElementos.add(subTituloLogin);

		JLabel titulo_correo = new JLabel("USUARIO");//Etiqueta Subtitulo
		titulo_correo.setOpaque(true);
		titulo_correo.setBounds(75,150,400,30);
		titulo_correo.setFont(new Font("Poppins",Font.BOLD,12));
		titulo_correo.setHorizontalAlignment(JLabel.LEFT);
		titulo_correo.setBackground(Color.decode("#FFFFFF"));
		titulo_correo.setForeground(Color.black);
		loginElementos.add(titulo_correo);

		TextFieldRounded correoCampo = new TextFieldRounded(20,20,true);//Campo de texto para el correo
		correoCampo.setBounds(75,195,400,40);
		correoCampo.setOpaque(false);
		correoCampo.setFont(new Font("Poppins",Font.BOLD,12));
		correoCampo.setForeground(Color.decode("#8B8B8B"));
		correoCampo.setHorizontalAlignment(JLabel.LEFT);
		correoCampo.setText("admin@PazDrive.com");
		correoCampo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Cuando el usuario hace clic en la caja
				if (correoCampo.getText().equals("admin@PazDrive.com")) {
					correoCampo.setText(""); // Vaciar la caja
					correoCampo.setForeground(Color.decode("#000000"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Cuando el usuario hace clic en otro lado
				if (correoCampo.getText().isEmpty()) {
					correoCampo.setText("admin@PazDrive.com");// Restaurar el mensaje
					correoCampo.setForeground(Color.decode("#8B8B8B"));
				}
			}
		});
		loginElementos.add(correoCampo);

		JLabel titulo_contraseña = new JLabel("CONTRASEÑA");//Etiqueta de contraseña
		titulo_contraseña.setOpaque(true);
		titulo_contraseña.setBounds(75,260,400,30);
		titulo_contraseña.setFont(new Font("Poppins",Font.BOLD,12));
		titulo_contraseña.setHorizontalAlignment(JLabel.LEFT);
		titulo_contraseña.setBackground(Color.decode("#FFFFFF"));
		titulo_contraseña.setForeground(Color.black);
		loginElementos.add(titulo_contraseña);

		PasswordFieldRounded contraseñaCampo = new PasswordFieldRounded(20,20);//Campo de texto para la contraseña
		contraseñaCampo.setBounds(75,300,400,40);
		contraseñaCampo.setOpaque(false);
		contraseñaCampo.setFont(new Font("Poppins",Font.BOLD,12));
		contraseñaCampo.setHorizontalAlignment(JLabel.LEFT);
		loginElementos.add(contraseñaCampo);

		CheckBoxRounded recordar = new CheckBoxRounded("Recordarme");//CheckBox de recordar usuario
		recordar.setBounds(75,360,20,20);
		recordar.setOpaque(false);
		recordar.setForeground(Color.BLACK);
		recordar.setFont(new Font("Poppins",Font.BOLD,20));
		loginElementos.add(recordar);

		JLabel recordarme= new JLabel("Recordarme");//Etiqueta para el recordar usuario
		recordarme.setOpaque(true);
		recordarme.setBounds(100,360,90,20);
		recordarme.setFont(new Font("Poppins",Font.PLAIN,15));
		recordarme.setHorizontalAlignment(JLabel.LEFT);
		recordarme.setBackground(Color.decode("#FFFFFF"));
		recordarme.setForeground(Color.decode("#99A1AF"));  
		loginElementos.add(recordarme); 

		//Creacion de Label de error en caso de que la verificacion sea incorrecta
		LabelRounded errorAuth = new LabelRounded("",10,Color.decode("#BD4747"));
		errorAuth.setVisible(false);
		errorAuth.setOpaque(false);
		errorAuth.setFont(new Font("Poppins",Font.BOLD,15));
		errorAuth.setForeground(Color.decode("#FFFFFF"));
		loginCont.add(errorAuth);

		ButtonRounded iniciarSesion = new ButtonRounded("Iniciar Sesión", 20,1);//Boton de inicio de sesion
		iniciarSesion.setBounds(125, 420, 300, 50);
		iniciarSesion.setOpaque(false);
		iniciarSesion.setBackground(Color.decode("#000D56"));
		iniciarSesion.setFont(new Font("Poppins",Font.BOLD,15));

		//Action Listener para crear la funcion del boton, validaciones del login
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String passText = new String(contraseñaCampo.getPassword());
				Boolean flag1 = false, flag2 = false;
				String recordar_correo = "";
				String recordar_contraseña = "";

				if(recordar.isSelected()) {//verificar si recordar esta marcado y guardar datos en caso de que lo este
					recordar_correo = correoCampo.getText();
					recordar_contraseña = passText;
					if(model.login(recordar_correo, recordar_contraseña)){ //verificaicon con BD temporal

						ventana.dispose();//eliminar ventana
						HomeController hm = new HomeController(); //llamar al homeController y la vista
						hm.Home();
					}
				}else {
					recordar_correo = "";
					recordar_contraseña = "";
				}

				if(passText.equals("")) {//verificacion vacia y mostrar etiqueta error
					contraseñaCampo.setBorder(BorderFactory.createLineBorder(Color.red,2,true));
					contraseñaCampo.setBackground(Color.decode("#FFCFCF"));
					Alerts sh = new Alerts();
					sh.show(errorAuth,"Credenciales Incorrectas",1);	

				}
				else {
					flag1 = true;
				}

				if(correoCampo.getText().equals("")) {//verificacion vacia y mostrar etiqueta error
					correoCampo.setBorder(BorderFactory.createLineBorder(Color.red,2,true));
					correoCampo.setBackground(Color.decode("#FFCFCF"));
					Alerts sh = new Alerts(); //metodo para mostrar alerta error
					sh.show(errorAuth,"Credenciales Incorrectas",1);	
				}
				else {
					flag2 = true;
				}

				if(flag1 && flag2) {
					if(model.login(correoCampo.getText(), passText) ){ //verificaicon con BD temporal

						ventana.dispose();//eliminar ventana
						HomeController hm = new HomeController(); //llamar al homeController y la vista
						hm.Home();
					}else {//mostrar error en caso de que los datos no coincidan con el registro de BD
						contraseñaCampo.setBorder(BorderFactory.createLineBorder(Color.red,2,true));
						contraseñaCampo.setBackground(Color.decode("#FFCFCF"));
						correoCampo.setBorder(BorderFactory.createLineBorder(Color.red,2,true));
						correoCampo.setBackground(Color.decode("#FFCFCF"));
						Alerts sh = new Alerts();
						sh.show(errorAuth,"Credenciales Incorrectas",1);	
					}
				}
			}});

		loginElementos.add(iniciarSesion);//Agregar elementos al contenedor principal

		//Agregamos paneles al contenedor en orden descendente
		contenedor.add(loginCont);
		contenedor.add(logoFondo);
		contenedor.add(fondo);

		//Agregamos el contenedor raiz a la ventana y aplicamos el setvisible
		ventana.add(contenedor, BorderLayout.CENTER);
		ventana.repaint();
		ventana.revalidate();
		ventana.setVisible(true);

		//Metodo para posicionar la imagen del logotipo correctamente al cambiarla de tamaño
		ventana.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentResized(java.awt.event.ComponentEvent e) {

				int w = contenedor.getWidth();
				int h = contenedor.getHeight();
				//reAjuste de dimensiones de elementos para hacerlo responsivo
				logotipo.setBounds(//logotipo
						(int)(w * xRatio),
						(int)(h * yRatio),
						(int)(w * wRatio),
						(int)(h * hRatio)
						);

				login.setBounds(//panel login
						(int)(w * lx),
						(int)(h * ly),
						(int)(w * lw),
						(int)(h * lh)
						);


				int labelW = 300;
				int labelH = 50;

				errorAuth.setBounds(//etiqueta de error
						(w - labelW) / 2,
						(int)(h * 0.85),
						labelW,
						labelH
						);
			}});

		//Forzar la poscision desde un inicio
		ventana.dispatchEvent(
				new java.awt.event.ComponentEvent(
						ventana, 
						java.awt.event.ComponentEvent.COMPONENT_RESIZED
						)
				);
	}

}
