package Views;

import java.awt.Color;

import javax.swing.JPanel;

public class VehicleView {
	public VehicleView() {
		
	}
	
	public JPanel vistaVehiculos() {
		JPanel e = new JPanel();
		e.setOpaque(true);
		e.setBackground(Color.decode("#EAEAEA"));
		e.setVisible(true);
		return e;
	}

}
