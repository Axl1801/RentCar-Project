package Controllers;

import java.util.ArrayList;

import javax.swing.JPanel;

import Models.ClientModel;
import Utilities.ButtonRoundedEditor;
import Views.ClientView;

public class ClientController {
	private ClientView cv;	
	private ClientModel cm;
	
	public ClientController(){
		cv = new ClientView();
		cv.setControlador(this);
		cm = new ClientModel();
	}
	
	public void showEdit(int idCliente, String nombre, String correo, String telefono) {
	    cv.editClient(idCliente, nombre, correo, telefono);
	}
	
	public void showHistorial(int idCliente) {
		cv.historialCliente(idCliente);
	}
	
	public JPanel showClientView() {
		 return cv.showClient();
	}

	//Agrega un nuevo Cliente a la base de datos *se tiene que mandar correo, nombre y telefono* EL ID SE ASIGNA SOLO
	public boolean addClient(String e, String n, String p)
	{
		boolean flag = cm.make(e, n, p);
		return flag;
	}
	
	//Genera la modificacion de datos de un Cliente *se tiene que ingresar el numero de ID(SOLO EL NUMERO), correo, nombre y telefono* 
	public boolean update(int i, String e, String n, String p) {
		boolean flag = cm.update(i, e, n, p); 
		return flag;		
	}
	
	//Genera el listado de Clientes con su informacion
	public ArrayList<ClientModel> obtenerClientes(){
		return cm.get();
	}
	
	//Regresa el correo del Cliente de su respectiva ID
	public String correo_Cliente(int id_cliente) {
		String correo_Cliente = cm.correo_Cliente(id_cliente);
        return correo_Cliente;
    }
	
	//Regresa el nombre del Cliente de su respectiva ID
	public String nombre_Cliente(int id_cliente) {
		String nombre_Cliente = cm.nombre_Cliente(id_cliente);
        return nombre_Cliente;
    }
	
	//Regresa el telefono del Cliente de su respectiva ID
	public String telefono_Cliente(int id_cliente) {
		String telefono_Cliente = cm.nombre_Cliente(id_cliente);
        return telefono_Cliente;
    }
	
	//Regresa la cantidad de Total de vehiculos
	public int numeroVehiculos_total(){
		int num_car_total = cm.numeroVehiculos_total();		
		return num_car_total;		
	}
	
	//Regresa la cantidad de vehiculos Rentados
	public int numeroVehiculos_renta(){
		int num_car_renta = cm.numeroVehiculos_renta();
		return num_car_renta;
	}
	
	//Regresa la cantidad de vehiculos Disponibles
	public int numeroVehiculos_dispo(){
		int num_car_disponibles = cm.numeroVehiculos_dispo();
		return num_car_disponibles;
	}
	
	//Regresa la cantidad de vehiculos en Mantenimiento
	public int numeroVehiculos_manteni(){
		int num_car_mantenimiento = cm.numeroVehiculos_manteni();
		return num_car_mantenimiento;
	}
	
	//Elimina al Cliente tras verificar si tiene renta
	public boolean Eliminar_cliente(int id_cliente) {		
		if (cm.checar_renta(id_cliente)) {
			return cm.eliminarCliente(id_cliente);		
		} else {
			return false;
		}
	}
	
	//Genera el listado de Rentas del Cliente
	public ArrayList<ClientModel> obtenerRentasClientes(int id_cliente){
		return cm.getinfo(id_cliente);
	}
	
	public void recargarInfo() {
		cv.recargarInfo();
	}
}


