package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class LabelRounded extends JLabel{
	private int radius;
	private Color backgroundColor;

	public LabelRounded(String text, int radius, Color bgColor) {
		super(text);
		this.radius = radius;
		this.backgroundColor = bgColor;

		setOpaque(false);
		setForeground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Fondo redondeado
		g2.setColor(backgroundColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

		super.paintComponent(g);
		g2.dispose();
	}

	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Borde
		g2.setColor(Color.decode("#000D56"));
		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);

		g2.dispose();
	}

}
