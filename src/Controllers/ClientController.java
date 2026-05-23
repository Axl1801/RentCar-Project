	package Controllers;

import java.util.ArrayList;

import javax.swing.JPanel;

import Models.ClientModel;
import Views.ClientView;

public class ClientController {
	private ClientView cv;	
	private ClientView view;
	private ClientModel model;
	
	public ClientController(){
		cv = new ClientView();
		view = new ClientView();
		model = new ClientModel();
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

	public boolean addClient(String e, String p, String n)
	{
		boolean flag = model.make(e, p, n);
		
		return flag;
	}

}
