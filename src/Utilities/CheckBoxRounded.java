package Utilities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JCheckBox;

public class CheckBoxRounded extends JCheckBox {
	public CheckBoxRounded(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        int size = 18;

        // Fondo
        if (isSelected()) {
            g2.setColor(new Color(0x000D56));
        } else {
            g2.setColor(Color.WHITE);
        }

        g2.fillRoundRect(0, (getHeight() - size)/2, size, size, 10, 10);

        // Borde
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, (getHeight() - size)/2, size, size, 10, 10);

        // Check
        if (isSelected()) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));

            int x = 4;
            int y = getHeight()/2;

            g2.drawLine(x, y, x+4, y+4);
            g2.drawLine(x+4, y+4, x+10, y-4);
        }

        // Texto
        g2.setColor(getForeground());
        g2.drawString(getText(), size + 5, getHeight()/2 + 5);

        g2.dispose();
    }
}
