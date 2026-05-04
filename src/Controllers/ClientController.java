	package Controllers;

import javax.swing.JPanel;

import Views.ClientView;

public class ClientController {
	private ClientView cv;
	
	public ClientController(){
		cv = new ClientView();
	}
	
	public JPanel showClientView() {
		 return cv.showClient();
	}

}
