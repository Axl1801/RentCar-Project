package Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

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
	public boolean addVehicle(byte[] f, int im, int ic, int a, BigDecimal pd, String e)
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
	
	//REGRESA LISTA DE ESTADOS
	public ArrayList<String> getListaEstados() {
		return new ArrayList<>(Arrays.asList("Todos","Rentado", "Disponible", "Mantenimiento", "Inactivo"));
	}
	
	//REGRESA LISTA DE PRECIOS
	public ArrayList<Double> getListaPrecios() {
		return new ArrayList<>(Arrays.asList(00.00,75.0, 100.0, 150.0, 175.0, 200.0, 250.0, 275.0, 300.0, 350.0, 375.0, 400.0));
    }
	
	//REGRESA LISTA DE AÑOS 
	public ArrayList<Integer> getListaAnios() {
		return new ArrayList<>(Arrays.asList(0,2028, 2027, 2026, 2025, 2024, 2023, 2022, 2021, 2020));
    }
	
	//REGRESA LISTA DE MARCAS
	 public ArrayList<String> getListaMarcas() {
		 return vm.getListaMarcas();
	 }
	 
	 //REGRESA LISTA DE MODELOS DEPENDIENDO DE LA MARCA
	 public ArrayList<String> getListaModelosNombre(String nombreMarca) {
		 return vm.getListaModelos(nombreMarca);
	 }
	 
	 //REGRESA LISTA DE MODELOS
	 public ArrayList<String> getListaModelos() {
		 return vm.getNombresModelos();
	 }
	 
	 //REGRESA ID del modelo dependiendo de la marca
	 public int getListaIdModelo(String nombreMarca) {
		 return vm.getIdPorNombreModelo(nombreMarca);
	 }
	 
	 //REGRESA LA CATEGORIA DEL VEHICULO CON SU ID
	 public String getCategoriaVehiculo(int id_vehiculo) {
		 return vm.getCategoriaVehiculo(id_vehiculo);
	 }
	
}
