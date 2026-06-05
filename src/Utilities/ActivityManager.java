package Utilities;

import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;

public class ActivityManager {
	private static JPanel panel;
	private static int lim;
    private static boolean habilitado = true;
    public static void setPanel(JPanel p, int limite) {
        panel = p;
        lim = limite;
    }
    
    public static void setHabilitado(boolean estado) {
        habilitado = estado;
    }

    public static boolean isHabilitado() {
        return habilitado;
    }

    public static void addActivity( String titulo,String subtitulo,LocalTime tiempo,Color color) {
    	
        if (!habilitado) {
            return;
        }

        if (panel == null) {
        	return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        tiempo.format(formato);

        // Si ya hay 5 actividades, elimina la más antigua
        if (panel.getComponentCount() >= lim) {
            panel.remove(panel.getComponentCount() - 1);
        }

        panel.add(
            new Activities(titulo, subtitulo, tiempo, color),
            0
        );

        panel.revalidate();
        panel.repaint();
    }

    
}
