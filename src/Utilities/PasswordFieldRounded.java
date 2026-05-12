package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class PasswordFieldRounded extends JPasswordField{
	private int radius;

	public PasswordFieldRounded(int columns, int radius) {
		super(columns);
		this.radius = radius;
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // padding
		setEchoChar('•');
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Fondo
		g2.setColor(getBackground());
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
		g2.setColor(Color.GRAY);
		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);

		g2.dispose();
	}
}
