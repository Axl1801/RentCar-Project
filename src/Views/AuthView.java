package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class AuthView {
	
	public AuthView() {
		
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
        		 getClass().getResource("/resources/Imagenes-sprites/FondoPazDrive.png")
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
        		getClass().getResource("/resources/Imagenes-sprites/PAZ DRIVE LOGO WHITE.png")
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
        
        //Panel del login
        JPanel login = new JPanel();
        login.setOpaque(false);
        login.setLayout(null);
        
        
        
        //Agregamos paneles al contenedor en orden descendente
        contenedor.add(logoFondo);
        contenedor.add(fondo);
        
        //Agregamos el contenedor raiz a la ventana y aplicamos el setvisible
        ventana.add(contenedor, BorderLayout.CENTER);
        ventana.setVisible(true);
        
        //Metodo para posicionar la imagen del logotipo correctamente al cambiarla de tamaño
        ventana.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {

                int w = contenedor.getWidth();
                int h = contenedor.getHeight();

                logotipo.setBounds(
                    (int)(w * xRatio),
                    (int)(h * yRatio),
                    (int)(w * wRatio),
                    (int)(h * hRatio)
                );
            }
        });
        
        //Forzar la poscision desde un inicio
        ventana.dispatchEvent(
        	    new java.awt.event.ComponentEvent(
        	        ventana, 
        	        java.awt.event.ComponentEvent.COMPONENT_RESIZED
        	    )
        	);
    }
}
