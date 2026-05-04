package Controllers;

import javax.swing.JPanel;

import Views.DashView;

public class DashController {
	private DashView dv;
	public DashController(){
		dv = new DashView();
	}
	
	public JPanel showDashboard() {
		return dv.Dashboard();
		
	}

}
