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

}
