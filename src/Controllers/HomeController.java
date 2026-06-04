package Controllers;

import Views.AuthView;
import Views.HomeView;

public class HomeController {
	private HomeView hv;
	private AuthView av;
	
	public HomeController(){
		hv = new HomeView();
	}
	
	public void Home() {
		hv.showHome();
	}
	
}
