	package Controllers;

import java.util.ArrayList;

import javax.swing.JPanel;

import Models.ClientModel;
import Views.ClientView;

public class ClientController {
	private ClientView cv;	
	private ClientModel model;
	
	public ClientController(){
		cv = new ClientView();
		cv.setControlador(this);
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

	public boolean addClient(String e, String n, String p)
	{
		boolean flag = model.make(e, n, p);
		
		return flag;
	}
	
	public boolean update(int i, String e, String n, String p) {
		boolean flag = model.update(i, e, n, p); 
		return flag;
		
	}
	
	public ArrayList<ClientModel> obtenerClientes(){
		return model.get();
	}

}
