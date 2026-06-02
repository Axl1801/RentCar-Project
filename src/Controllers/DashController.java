package Controllers;

import java.util.Map;

import javax.swing.JPanel;

import Models.ClientModel;
import Models.DashModel;
import Views.ClientView;
import Views.DashView;

public class DashController {
	
	private DashView dv;
	private DashModel dm;
	
	private double semana1;
	private double semana2;
	private double semana3;
	private double semana4;
	private double semana5;
	private double totalMes;
	private double totalSemanaEnCurso;
	private double totalMes_anterior;
	
	public DashController(){
		dv = new DashView();
		dv.setControlador(this);
		dm = new DashModel();
	}
	
	public JPanel showDashboard() {
		return dv.Dashboard();
		
	}
	
	//TIENE LOS DOUIBLES DE LAS 5 SEMANAS ASI COMO EL DEL TOTAL DE LAS GANANCIAS MENSUALES
	public void actualizarReporteSemanas() {
        Map<Integer, Double> datosSemanas = dm.ganancias_semanales_mes_actual();

        semana1 = datosSemanas.getOrDefault(1, 0.0);
        semana2 = datosSemanas.getOrDefault(2, 0.0);
        semana3 = datosSemanas.getOrDefault(3, 0.0);
        semana4 = datosSemanas.getOrDefault(4, 0.0);
        semana5 = datosSemanas.getOrDefault(5, 0.0);
        
        totalMes = dm.ganancia_mes_actual();
        totalSemanaEnCurso = dm.ganancia_semana_actual();

    }
	
	//DEVUELVE LAS GANANCIAS DE LA SEMANA 1
	public double get_semana_1() {
		return semana1;
	}

	//DEVUELVE LAS GANANCIAS DE LA SEMANA 2
	public double get_semana_2() {
		return semana2;
	}
	
	//DEVUELVE LAS GANANCIAS DE LA SEMANA 3
	public double get_semana_3() {
		return semana3;
	}
	
	//DEVUELVE LAS GANANCIAS DE LA SEMANA 4
	public double get_semana_4() {
		return semana4;
	}
	
	//DEVUELVE LAS GANANCIAS DE LA SEMANA 5
	public double get_semana_5() {
		return semana5;
	}
	
	//DEVUELVE LAS GANANCIAS DE EL MES TOTAL
	public double get_totalMes() {
		totalMes = dm.ganancia_mes_actual(); 
		return totalMes;
	}
	
	//DEVUELVE LAS GANANCIAS DE LA SEMANA EN CURSO 
	public double get_totalSemanaEnCurso() {
		totalSemanaEnCurso = dm.ganancia_semana_actual();
		return totalSemanaEnCurso;
	}
	
	//DEVUELVE LAS GANANCIAS DE EL MES ANTERIOR
	public double get_ganancia_mes_anterior() {
		totalMes_anterior = dm.ganancia_mes_anterior();
		return totalMes_anterior;
	}
	
	//DEVUELVE EL TOTAL DE VEHICULOS
	public int numeroVehiculos_total(){
		
		int num_car_total = dm.numeroVehiculos_total();
		
		return num_car_total;
		
	}
	
	//DEVUELVE EL TOTAL DE VEHICULOS EN RENTA
	public int numeroVehiculos_renta(){
		
		int num_car_renta = dm.numeroVehiculos_renta();
		
		return num_car_renta;
		
	}
	
	//DEVUELVE EL TOTAL DE VEHICULOS DISPONIBLES
	public int numeroVehiculos_dispo(){
		
		int num_car_disponibles = dm.numeroVehiculos_dispo();
		
		return num_car_disponibles;
		
	}
	
	//DEVUELVE EL TOTAL DE VEHICULOS EN MANTENIMIENTO 
	public int numeroVehiculos_manteni(){
		
		int num_car_mantenimiento = dm.numeroVehiculos_manteni();
		
		return num_car_mantenimiento;
		
	}
	
	//DEVUELVE EL TOTAL DE VEHICULOS NO DISPONIBLES 
	public int numeroVehiculos_fuera(){
		
		int num_car_fuera = dm.numeroVehiculos_fuera();
		
		return num_car_fuera;
		
	}

}
