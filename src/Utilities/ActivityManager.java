package Utilities;

import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;

public class ActivityManager {
	private static JPanel panel;

    public static void setPanel(JPanel p) {
        panel = p;
    }

    public static void addActivity(String titulo,String subtitulo,LocalTime tiempo,Color color) {

    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
    	
    	tiempo.format(formato);
    	
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
