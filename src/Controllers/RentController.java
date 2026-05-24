package Controllers;

import java.math.BigDecimal;
import java.sql.Date;

import javax.swing.JPanel;

import Models.RentModel;
import Views.RentView;

public class RentController {
	private RentView rv;
	private RentModel rm;
	
	public RentController() {
		rv = new RentView();
	}
	
	public JPanel showRent() {
		return rv.Rent();
	}
	
	public void editRent() {
		rv.editRent();
	}
	
	public void showHistorial() {
		rv.historialRenta();
	}
	
	public void registrarNuevaRenta(int ic, int id, int io, int ild, Date fi, Date ff, String e) {
        
		int idCliente = ic;
		int idVehiculo = id;
		int idOrigen = io;
        int idDestino = ild;
        Date fechaInicio = fi;
        Date fechaFin = ff;
        String estado = e;

        BigDecimal costoFinal = rm.calcularCostoTotal(id, io, ild, fi, ff);
        double distanciaCalculada = rm.getDistancia_recorrida();

        boolean exito = rm.make(
            idCliente, 
            idVehiculo, 
            idOrigen, 
            idDestino, 
            fechaInicio, 
            fechaFin, 
            distanciaCalculada,
            costoFinal, 
            estado
        );
        }
    

}
