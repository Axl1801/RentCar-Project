package Controllers;

import java.util.ArrayList;
import java.util.Arrays;

import Models.HomeModel;
import Views.AuthView;
import Views.HomeView;

public class HomeController {
	private HomeView hv;
	private HomeModel hm;
	
	public HomeController(){
		hv = new HomeView();
		hv.setControlador(this);
		hm = new HomeModel();
	}
	
	public void Home() {
		hv.showHome();
	}
	
	//REGRESA LISTA DE ESTADOS
	public ArrayList<String> getListaEstados() {
		return new ArrayList<>(Arrays.asList("Rentado", "Disponible", "Mantenimiento", "Inactivo"));
	}
	
	//REGRESA LISTA DE PRECIOS
	public ArrayList<Double> getListaPrecios() {
		return new ArrayList<>(Arrays.asList(75.0, 100.0, 150.0, 175.0, 200.0, 250.0, 275.0, 300.0, 350.0, 375.0, 400.0));
    }
	
	//REGRESA LISTA DE AÑOS 
	public ArrayList<Integer> getListaAnios() {
		return new ArrayList<>(Arrays.asList(2028, 2027, 2026, 2025, 2024, 2023, 2022, 2021, 2020));
    }
	
	//REGRESA LISTA DE MARCAS
	 public ArrayList<String> getListaMarcas() {
		 return hm.getListaMarcas();
	 }
	 
	 //REGRESA LISTA DE MODELOS DEPENDIENDO DE LA MARCA
	 public ArrayList<String> getListaModelos(String nombreMarca) {
		 return hm.getListaModelos(nombreMarca);
	 }
	
	 //REGRESA LA CATEGORIA DEL VEHICULO CON SU ID
	 public String getCategoriaVehiculo(int id_vehiculo) {
		 return hm.getCategoriaVehiculo(id_vehiculo);
	 }
	 
	 //AGREGAR UN MODELO A UNA MARCA
	 public void generarModelo(String marca, String modelo) {
		 
		 int idDeLaMarca = hm.obtenerIdMarca(marca);

		 if (idDeLaMarca != -1) {
		    boolean exito = hm.insertarModelo(modelo, idDeLaMarca);
		    if(exito){
		        System.out.println("Modelo: " + modelo + " guardado bajo la marca " + marca );
		    }
		} else {
		    System.out.println("Error: La marca seleccionada no existe en la base de datos.");
		}
	 }
	 
	 //AGREGA UNA CATEGORIA AL SISTEMA
	 public void generarCategoria(String nombre) {
		 hm.insertarCategoria(nombre);
	 }
	 
	 //AGREGA UNA MARCA AL SISTEMA
	 public void generarMarca(String marca) {
		 hm.insertarMarca(marca);
	 }
	 
}
