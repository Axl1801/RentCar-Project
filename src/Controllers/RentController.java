package Controllers;

import javax.swing.JPanel;

import Views.RentView;

public class RentController {
	private RentView rv;
	
	public RentController() {
		rv = new RentView();
	}
	
	public JPanel showRent() {
		return rv.Rent();
	}
}
