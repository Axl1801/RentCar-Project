package Views;

import java.awt.Color;

import javax.swing.JPanel;

public class ClientView {
	
	public ClientView(){
		
	}
	
	public JPanel showClient() {
		JPanel a = new JPanel();
		a.setOpaque(true);
		a.setBackground(Color.decode("#EAEAEA"));
		a.setVisible(true);
		return a;
	}
}
