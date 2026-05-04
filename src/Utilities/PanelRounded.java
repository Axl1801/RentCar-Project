package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class PanelRounded extends JPanel{
	private int arc;
    private boolean topLeft, topRight, bottomLeft, bottomRight;

    public PanelRounded(int arc, boolean tl, boolean tr, boolean bl, boolean br) {
        this.arc = arc;
        this.topLeft = tl;
        this.topRight = tr;
        this.bottomLeft = bl;
        this.bottomRight = br;
        setOpaque(false); // 🔥 importante
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int r = arc;

        Path2D path = new Path2D.Double();

        // Inicio
        path.moveTo(topLeft ? r : 0, 0);

        // Línea superior
        path.lineTo(w - (topRight ? r : 0), 0);
        if (topRight)
            path.quadTo(w, 0, w, r);

        // Lado derecho
        path.lineTo(w, h - (bottomRight ? r : 0));
        if (bottomRight)
            path.quadTo(w, h, w - r, h);

        // Línea inferior
        path.lineTo((bottomLeft ? r : 0), h);
        if (bottomLeft)
            path.quadTo(0, h, 0, h - r);

        // Lado izquierdo
        path.lineTo(0, (topLeft ? r : 0));
        if (topLeft)
            path.quadTo(0, 0, r, 0);

        path.closePath();

        // Fondo
        g2.setColor(getBackground());
        g2.fill(path);

        // (Opcional) borde
        g2.setColor(new Color(200, 200, 200));
        g2.draw(path);

        g2.dispose();

        super.paintComponent(g);
    }
}
