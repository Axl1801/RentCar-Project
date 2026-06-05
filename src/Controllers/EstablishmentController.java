package Controllers;

import java.util.ArrayList;
import javax.swing.JPanel;
import Models.EstablishmentModel;
import Views.EstablishmentView;

public class EstablishmentController {
	private EstablishmentView ev;
	private EstablishmentModel em;
	private double distancia;
	
	public EstablishmentController(){
		ev = new EstablishmentView();
		ev.setControlador(this);
		em = new EstablishmentModel();
		
	}
	
	public JPanel showEstablishment() {
		return ev.showEstablishment();
	}
	
	//REGRESA LA LISTA DE LOCALES
	public ArrayList<String> obtenerLocales(){
		return em.get();
	}
	
	//REGRESA LA DISTANCIA ENTRE DOS SUCURSALES
	public double calcularDistancia(int io, int id) {
		distancia = em.calcularDistancia(io, id);
		return distancia;
	}
	
	//REGRESA EL COSTO POR LA DISTANCIA 
	public double calcularPrecio(double d) {
		double precio = distancia*3;
		return precio;
	}
	
	public int obtenerIDsuc(String nombreSuc) {
		int id = em.getIdLocacion(nombreSuc);
		return id;
	}

}
