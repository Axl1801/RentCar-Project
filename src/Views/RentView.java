package Views;

import java.awt.Color;

import javax.swing.JPanel;

public class RentView {
	public RentView(){
		
	}
	
	public JPanel Rent() {
		JPanel d = new JPanel();
		d.setOpaque(true);
		d.setBackground(Color.decode("#EAEAEA"));
		d.setVisible(true);
		return d;
	}
}
