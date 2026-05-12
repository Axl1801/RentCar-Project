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
	
	public void showEdit() {
		cv.editClient();
	}
	
	public void showHistorial() {
		cv.historialCliente();
	}

}
