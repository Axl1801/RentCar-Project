package Utilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JToggleButton;

public class ToggleButtonRounded extends JToggleButton{
	 public ToggleButtonRounded() {

	        setPreferredSize(new Dimension(60, 30));

	        setContentAreaFilled(false);
	        setFocusPainted(false);
	        setBorderPainted(false);
	        setOpaque(false);

	        // Estado inicial
	        setSelected(true);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {

	        Graphics2D g2 = (Graphics2D) g.create();

	        // Suavizado
	        g2.setRenderingHint(
	                RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON
	        );

	        int width = getWidth();
	        int height = getHeight();

	        // Fondo
	        if (isSelected()) {
	            g2.setColor(Color.decode("#050B5C"));
	        } else {
	            g2.setColor(Color.LIGHT_GRAY);
	        }

	        g2.fillRoundRect(
	                0,
	                0,
	                width,
	                height,
	                height,
	                height
	        );

	        // Círculo
	        int circleSize = height - 6;

	        int x;

	        if (isSelected()) {
	            x = width - circleSize - 3;
	        } else {
	            x = 3;
	        }

	        g2.setColor(Color.WHITE);

	        g2.fillOval(
	                x,
	                3,
	                circleSize,
	                circleSize
	        );

	        // Check
	        if (isSelected()) {

	            g2.setColor(Color.decode("#050B5C"));

	            Font font = new Font("Arial", Font.BOLD, 15);

	            g2.setFont(font);

	            g2.drawString(
	                    "",
	                    x + 6,
	                    height - 9
	            );
	        }else {
	            g2.setColor(Color.decode("#050B5C"));

	            Font font = new Font("Arial", Font.BOLD, 12);

	            g2.setFont(font);

	            g2.drawString(
	                    "",
	                    x + 6,
	                    height - 9
	            );
	        }

	        g2.dispose();
	    }
}
