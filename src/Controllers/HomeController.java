package Controllers;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Views.HomeView;

public class HomeController {
	private HomeView hv;
	
	public HomeController(){
		hv = new HomeView();
	}
	
	public void Home() {
		hv.showHome();
	}
	
}
