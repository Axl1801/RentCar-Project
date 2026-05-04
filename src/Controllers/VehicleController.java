package Controllers;

import javax.swing.JPanel;

import Views.VehicleView;

public class VehicleController {
	private VehicleView vv;
	
	public VehicleController() {
		vv = new VehicleView();
	}
	
	public JPanel showVehicle() {
		return vv.vistaVehiculos();
	}
}
