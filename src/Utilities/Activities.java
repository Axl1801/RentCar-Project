package Utilities;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Activities extends JPanel {
	public Activities(String titulo, String subtitulo, String tiempo, Color color) {

		setLayout(new BorderLayout());
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

		// círculo
		JPanel circulo = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g;

				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(color);
				g2.setStroke(new BasicStroke(3));
				g2.drawOval(5, 5, 14, 14);

				g2.setColor(Color.WHITE);
				g2.fillOval(7, 7, 10, 10);
			}
		};

		circulo.setPreferredSize(new Dimension(40, 30));
		circulo.setOpaque(false);

		// textos
		JPanel textos = new JPanel();
		textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
		textos.setOpaque(false);

		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Poppins", Font.BOLD, 14));

		JLabel lblSub = new JLabel(subtitulo);
		lblSub.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblSub.setForeground(new Color(120,120,120));

		JLabel lblTiempo = new JLabel(tiempo);
		lblTiempo.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblTiempo.setForeground(new Color(150,150,150));

		textos.add(lblTitulo);
		textos.add(Box.createVerticalStrut(3));
		textos.add(lblSub);
		textos.add(Box.createVerticalStrut(2));
		textos.add(lblTiempo);

		add(circulo, BorderLayout.WEST);
		add(textos, BorderLayout.CENTER);
	}
}
