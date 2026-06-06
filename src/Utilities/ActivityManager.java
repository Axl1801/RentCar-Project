package Utilities;

import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ActivityManager {
	private static ArrayList<ActivityData> historial = new ArrayList<>();
    private static boolean habilitado = true;

    private static class PanelInfo {
        JPanel panel;
        int limite;

        PanelInfo(JPanel panel, int limite) {
            this.panel = panel;
            this.limite = limite;
        }
    }

    private static final ArrayList<PanelInfo> paneles = new ArrayList<>();

    public static void addPanel(JPanel panel, int limite) {
        paneles.add(new PanelInfo(panel, limite));
        for (int i = historial.size() - 1; i >= 0; i--) {
            ActivityData act = historial.get(i);
            panel.add(new Activities(act.getTitulo(),act.getSubtitulo(),act.getTiempo(),act.getColor()));

            if(panel.getComponentCount() >= limite) {
                break;
            }
        }

        panel.revalidate();
        panel.repaint();}

    public static void removePanel(JPanel panel) {
        paneles.removeIf(info -> info.panel == panel);
    }

    public static void setHabilitado(boolean estado) {
        habilitado = estado;
    }

    public static boolean isHabilitado() {
        return habilitado;
    }

    public static void addActivity(String titulo,String subtitulo,LocalTime tiempo,Color color) {
    	
    	historial.add(new ActivityData( titulo,subtitulo,tiempo,color));

        if (!habilitado) {
            return;
        }
        
        System.out.println("Paneles registrados: " + paneles.size());

        for (PanelInfo info : paneles) {
        	
            System.out.println(
                    "Agregando actividad a panel: " +
                    info.panel +
                    " limite=" + info.limite
                );

            JPanel panel = info.panel;
            int limite = info.limite;

            if (panel == null) {
                continue;
            }

            if (panel.getComponentCount() >= limite) {
                panel.remove(panel.getComponentCount() - 1);
            }

            Activities actividad = new Activities(
                    titulo,
                    subtitulo,
                    tiempo,
                    color);

            panel.add(actividad, 0);

            panel.revalidate();
            panel.repaint();
        }
    }
}