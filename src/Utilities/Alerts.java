package Utilities;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Alerts{
	private URL url;
	public Alerts() {

	}

	public void show(LabelRounded label, String mensaje, int estilo) {
		label.setText(mensaje); 
		if(estilo == 1) {
			label.setBackground(Color.decode("#BD4747"));
			url = getClass().getResource("/iconos/emergentes/error_blanco.png");//Carga ubi imagen				
		}
		if(estilo == 2) {
			label.setBackground(Color.decode("#308C52"));
			url = getClass().getResource("/iconos/emergentes/correcto_blanco.png");//Carga ubi imagen				
		}

		if (url != null) {
			label.setIcon(new ImageIcon(url));
		}

		label.setHorizontalAlignment(JLabel.CENTER);  
		label.setIconTextGap(10);                      
		label.setHorizontalTextPosition(JLabel.LEFT); 

		label.setVisible(true);
		label.revalidate();
		label.repaint();

		new Timer(5000, e -> { //contador para que se desaparezca la label
			label.setVisible(false);
		}) {{
			setRepeats(false);
			start();
		}};	
	}
}
