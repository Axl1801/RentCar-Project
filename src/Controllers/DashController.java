package Controllers;

import java.util.Map;

import javax.swing.JPanel;

import Models.DashModel;
import Views.DashView;

public class DashController {
	
	private DashView dv;
	private DashModel dm;
	
	
	public void actualizarReporteSemanas() {
        Map<Integer, Double> datosSemanas = dm.ganancias_semanales_mes_actual();

        double semana1 = datosSemanas.get(1);
        double semana2 = datosSemanas.get(2);
        double semana3 = datosSemanas.get(3);
        double semana4 = datosSemanas.get(4);
        double semana5 = datosSemanas.get(5);
        
        double totalMes = dm.ganancia_mes_actual();
        double totalSemanaEnCurso = dm.ganancia_semana_actual();

    }
	public DashController(){
		dv = new DashView();
	}
	
	public JPanel showDashboard() {
		return dv.Dashboard();
		
	}
	
	public int numeroVehiculos_total(){
		
		int num_car_total = dm.numeroVehiculos_total();
		
		return num_car_total;
		
	}
	
	public int numeroVehiculos_renta(){
		
		int num_car_renta = dm.numeroVehiculos_renta();
		
		return num_car_renta;
		
	}
	
	public int numeroVehiculos_dispo(){
		
		int num_car_disponibles = dm.numeroVehiculos_dispo();
		
		return num_car_disponibles;
		
	}
	
	public int numeroVehiculos_manteni(){
		
		int num_car_mantenimiento = dm.numeroVehiculos_manteni();
		
		return num_car_mantenimiento;
		
	}
	
	public int numeroVehiculos_fuera(){
		
		int num_car_fuera = dm.numeroVehiculos_fuera();
		
		return num_car_fuera;
		
	}

}
