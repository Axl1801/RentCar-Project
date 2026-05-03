package Controllers;

import Views.HomeView;

public class HomeController {
	private HomeView hv;
	
	public HomeController(){
		hv = new HomeView();
	}
	
	public void Home() {
		hv.home();
	}
}
