package Views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class HomeView {
	public HomeView(){
		
	}
	
	public void home() {
		JFrame ventana = new JFrame("Paz Drive");
        ventana.setSize(1920, 1080);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(0,0));
        ventana.setVisible(true);
	}
}
