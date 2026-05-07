package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextFieldRounded extends JTextField {
	 private int radius;
	 private boolean border;
    public TextFieldRounded(int columns, int radius, boolean border) {
        super(columns);
        this.radius = radius;
        this.border = border;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));//padding interno
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo blanco redondeado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
        g2.dispose();
    }
    
    
    @Override
    protected void paintBorder(Graphics g) {
    	if(border) {
    		Graphics2D g2 = (Graphics2D) g.create();
    		
    		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    				RenderingHints.VALUE_ANTIALIAS_ON);
    		
    		// Borde
    		g2.setColor(Color.GRAY);
    		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
    		
    		g2.dispose();    		
    	}else {
    		
    	}
    }
	    
}
