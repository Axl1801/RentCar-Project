package Views;

import java.awt.Color;

import javax.swing.JPanel;

public class DashView {
	public DashView() {
		
	}
	
	public JPanel Dashboard() {
		JPanel b = new JPanel();
		b.setOpaque(true);
		b.setBackground(Color.green);
		b.setVisible(true);
		return b;
	}

}
