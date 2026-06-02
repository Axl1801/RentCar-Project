package Controllers;

import javax.swing.JPanel;

import Models.VehicleModel;
import Views.VehicleView;

public class VehicleController {
	private VehicleView vv;
	private VehicleModel vm;
	
	public VehicleController() {
		vv = new VehicleView();
	}
	
	public JPanel showVehicle() {
		return vv.vistaVehiculos();
	}
	
	public void añadirVehicle() {
		vv.addVehicle();
	}
	
	public void EditVehicleView() {
		vv.editVehicle();
	}
	
	public void showHistorial() {
		vv.historialVehiculos();
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
	
}
