package Views;

import java.awt.Color;

import javax.swing.JPanel;

public class EstablishmentView {
	public EstablishmentView(){
		
	}
	
	public JPanel showEstablishment() {
		JPanel c = new JPanel();
		c.setOpaque(true);
		c.setBackground(Color.decode("#EAEAEA"));
		c.setVisible(true);
		return c;
	}
}
