package Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JPanel;

import Models.ClientModel;
import Models.VehicleModel;
import Views.VehicleView;

public class VehicleController {
	private VehicleView vv;
	private VehicleModel vm;
	
	public VehicleController() {
		vv = new VehicleView();
		vv.setControlador(this);
		vm = new VehicleModel();
		
	}
	
	public JPanel showVehicle() {
		return vv.vistaVehiculos();
	}
	
	public void añadirVehicle() {
		vv.addVehicle();
	}
	
	public void EditVehicleView(int idVehiculo,String marca, String modelo, String categoria, String estado, String año, BigDecimal precio) {
		vv.editVehicle(idVehiculo, marca, modelo, categoria, estado, año, precio);
	}
	
	public void showHistorial(int idVehicle) {
		vv.historialVehiculos(idVehicle);
	}
	
	//Genera el listado de Vehiculos con su informacion
	public ArrayList<VehicleModel> obtenerVehiculos(){
		return vm.get();
	}
	
	//ELIMINA EL VEHICULO SELECCIONADO *EN CASO DE USARSE EN UNA RENTA CAMBIA SU ESTADO A INACTIVO
	public boolean EliminarVehiculo(int id_vehiculo) {
		boolean jalo = vm.delete(id_vehiculo);
		return jalo;		
	}
	
	//ACTUALIZA LA INFORMACION DE UN VEHICULO 
	public boolean update(int i,BigDecimal pd, String e) {
		boolean flag = vm.update(i,pd, e); 
		return flag;		
	}
	
	//Agrega un nuevo Vehiculo a la base de datos *se tiene que mandar foto, modelo, categoria, año, precio y estado* EL ID SE ASIGNA SOLO
	public boolean addClient(byte[] f, int im, int ic, int a, BigDecimal pd, String e)
	{
		boolean flag = vm.make(f, im, ic, a, pd, e);
		return flag;
	}
	
	//Regresa la cantidad de Total de vehiculos
	public int numeroVehiculos_total(){
		int num_car_total = vm.numeroVehiculos_total();		
		return num_car_total;		
	}
		
	//Regresa la cantidad de vehiculos Rentados
	public int numeroVehiculos_renta(){
		int num_car_renta = vm.numeroVehiculos_renta();
		return num_car_renta;
	}
		
	//Regresa la cantidad de vehiculos Disponibles
	public int numeroVehiculos_dispo(){
		int num_car_disponibles = vm.numeroVehiculos_dispo();
		return num_car_disponibles;
	}
	
	//Regresa la cantidad de vehiculos en Mantenimiento
	public int numeroVehiculos_manteni(){
		int num_car_mantenimiento = vm.numeroVehiculos_manteni();
		return num_car_mantenimiento;
	}
	
	//Genera el listado de Rentas del Vehiculo
	public ArrayList<VehicleModel> obtenerRentasVehiculo(int id_vehiculo){
		return vm.getinfo(id_vehiculo);
	}
	
	
}
