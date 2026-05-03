package Utilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class ButtonRounded extends JButton{
	 private int radius;

	    public ButtonRounded(String text, int radius) {
	        super(text);
	        this.radius = radius;

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

	        // Color dinámico (hover / click)
	        if (getModel().isPressed()) {
	            g2.setColor(new Color(0x000A40)); // más oscuro
	        } else if (getModel().isRollover()) {
	            g2.setColor(new Color(0x001A80)); // hover
	        } else {
	            g2.setColor(new Color(0x000D56)); // normal
	        }

	        // Fondo redondeado
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

	        super.paintComponent(g);
	        g2.dispose();
	    }
}
