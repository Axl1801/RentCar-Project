package Utilities;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ResponsiveImageLabel extends JLabel{
	private Image image;

    public ResponsiveImageLabel(ImageIcon icon) {
        this.image = icon.getImage();
        setHorizontalAlignment(CENTER);
    }

    private int maxSize = 650; 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            int panelW = Math.min(getWidth(), maxSize);
            int panelH = Math.min(getHeight(), maxSize);

            int imgW = image.getWidth(this);
            int imgH = image.getHeight(this);

            double scale = Math.min((double) panelW / imgW, (double) panelH / imgH);

            int newW = (int) (imgW * scale);
            int newH = (int) (imgH * scale);

            int x = (getWidth() - newW) / 2;
            int y = (getHeight() - newH) / 2;

            g.drawImage(image, x, y, newW, newH, this);
        }
    }
}

