package Controllers;

import Views.AuthView;

public class AuthController {
	
	private AuthView av;
	
	public AuthController() {
		av = new AuthView();
	}
	
	public void login() {
		av.showLogin();
	}

}
