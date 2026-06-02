package Utilities;

import java.awt.Color;

import javax.swing.JPanel;

public class ActivityManager {
	private static JPanel panel;

    public static void setPanel(JPanel p) {
        panel = p;
    }

    public static void addActivity(
            String titulo,
            String subtitulo,
            String tiempo,
            Color color) {

        if(panel == null) return;

        panel.add(new Activities(
            titulo,
            subtitulo,
            tiempo,
            color
        ));

        panel.revalidate();
        panel.repaint();
    }
}
