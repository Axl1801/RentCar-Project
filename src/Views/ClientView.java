package Views;

import java.awt.Color;

import javax.swing.JPanel;

public class ClientView {
	
	public ClientView(){
		
	}
	
	public JPanel showClient() {
		JPanel a = new JPanel();
		a.setOpaque(true);
		a.setBackground(Color.red);
		a.setVisible(true);
		return a;
	}
}
