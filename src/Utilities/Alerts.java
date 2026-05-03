	package Utilities;
	
	import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
	
	public class Alerts{
		public Alerts() {
			
		}
		
		public void show(LabelRounded label, String mensaje) {
			label.setText(mensaje); 
		    label.setBackground(Color.decode("#BD4747"));
		    URL url = getClass().getResource("/iconos/emergentes/error_blanco.png");//Carga ubi imagen
		    
		    if (url != null) {
		        label.setIcon(new ImageIcon(url));
		    }

		    label.setHorizontalAlignment(JLabel.CENTER);  
		    label.setIconTextGap(10);                      
		    label.setHorizontalTextPosition(JLabel.LEFT); 
		    
		    label.setVisible(true);
	
		    new Timer(5000, e -> { //contador para que se desaparezca la label
		        label.setVisible(false);
		    }) {{
		        setRepeats(false);
		        start();
		    }};	
		}
	}
