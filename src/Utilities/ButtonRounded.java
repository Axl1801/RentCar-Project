package Utilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonRounded extends JButton{
	private int radius;
	private int ver;

	public ButtonRounded(String text, int radius, int ver) {
		super(text);
		this.radius = radius;
		this.ver = ver;

		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setOpaque(false);
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//Boton Azul
		if(ver == 1) {
			// Color dinámico (hover / click)
			if (getModel().isPressed()) {
				g2.setColor(new Color(0x000A40)); // más oscuro
			} else if (getModel().isRollover()) {
				g2.setColor(new Color(0x001A80)); // hover
			} else {
				g2.setColor(new Color(0x000D56)); // normal	        	
			}
		}
		//Boton Rojo
		if(ver == 2) {
			setForeground(Color.decode("#000000"));
			setBorderPainted(true);
			setBorder(BorderFactory.createLineBorder(Color.decode("#D32F2F"), 1));
			// Color dinámico (hover / click)
			if (getModel().isPressed()) {
				g2.setColor(Color.decode("#BD4747")); // más oscuro
			} else if (getModel().isRollover()) {
				g2.setColor(Color.decode("#E0A9A9")); // hover
			} else {
				g2.setColor(Color.decode("#FFFFFF")); // normal	        	
			}
		}
		//Boton Gris
		if(ver == 3) {
			setForeground(Color.decode("000000"));
			// Color dinámico (hover / click)
			if (getModel().isPressed()) {
				g2.setColor(Color.decode("#969696")); // más oscuro
			} else if (getModel().isRollover()) {
				g2.setColor(Color.decode("#C4C4C4")); // hover
			} else {
				g2.setColor(Color.decode("#D9D9D9")); // normal	        	
			}
		}
		//Boton Blanco
		if(ver == 4) {
			setForeground(Color.decode("#000000"));
			// Color dinámico (hover / click)
			if (getModel().isPressed()) {
				g2.setColor(Color.decode("#B6B6B6")); // más oscuro
			} else if (getModel().isRollover()) {
				g2.setColor(Color.decode("#CFCFCF")); // hover
			} else {
				g2.setColor(Color.decode("#FFFFFF")); // normal	        	
			}
		}
		//Boton Rojo full
		if(ver == 5) {
			setForeground(Color.white);
			// Color dinámico (hover / click)
			if (getModel().isPressed()) {
				g2.setColor(Color.decode("#782B2B")); // más oscuro
			} else if (getModel().isRollover()) {
				g2.setColor(Color.decode("#9A3737")); // hover
			} else {
				g2.setColor(Color.decode("#BD4747")); // normal	        	
			}
		}
		//Boton para subir Fotografia
		if(ver == 6) {
			setForeground(Color.white);
			setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
			setText("Subir Fotografia");
			// Color dinámico (hover / click)
			if (getModel().isPressed()) {
				g2.setColor(Color.decode("#515151"));
				setText("Subir Fotografia");
				setBorderPainted(true);
				setForeground(Color.black);// más oscuro
			} else if (getModel().isRollover()) {
				g2.setColor(Color.decode("#8B8B8B")); // hover
				setBorderPainted(true);
				setForeground(Color.black);
			} else {
				g2.setColor(Color.decode("#EAEAEA")); // normal
				setBorderPainted(false);
			}
		}

		// Fondo redondeado
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

		super.paintComponent(g);
		g2.dispose();
	}
}
