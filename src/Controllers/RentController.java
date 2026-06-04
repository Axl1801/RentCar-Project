package Controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.ClientModel;
import Models.RentModel;
import Utilities.PDFGenerador;
import Utilities.PrevisualizadorPDF;
import Views.RentView;

public class RentController {
	private RentView rv;
	private RentModel rm;
	private VehicleController vc;
	
	public RentController() {
		rv = new RentView();
		rv.setControlador(this);
		rm = new RentModel();
	}
	
	public JPanel showRent() {
		return rv.Rent();
	}
	
	public void editRent(int IDrenta,String cliente, String modelo, LocalDate fechaInicio, LocalDate fechaFinal, byte[] foto ) {
		rv.editRent(IDrenta,cliente,modelo,fechaInicio,fechaFinal, foto);
	}
	
	public void showHistorial(int idRenta) {
		rv.historialRenta(idRenta);
	}
	
	//Genera el listado de RENTAS con su informacion
	public ArrayList<RentModel> obtenerRentas(){
		return rm.getinfo();
	}
	
	//REGRESA TRUE SI SE REGISTRO NUEVA RENTA, VALIDA LA DISTANCIA DE SUCURSALES Y EL PRECIO TOTAL
	public void registrarNuevaRenta(int ic, int iv, int io, int ild, Date fi, Date ff, String e) {
        
		int idCliente = ic;
		int idVehiculo = iv;
		int idOrigen = io;
        int idDestino = ild;
        Date fechaInicio = fi;
        Date fechaFin = ff;
        String estado = e;

        BigDecimal costoFinal = rm.calcularCostoTotal(iv, io, ild, fi, ff);
        double distanciaCalculada = rm.getDistancia_recorrida();

        if (rm.DisponibilidadVehiculos(iv, fi, ff)) {
           
			boolean exito = rm.make(idCliente, idVehiculo, idOrigen, idDestino, fechaInicio, fechaFin, distanciaCalculada, costoFinal, estado);
            if(exito) {
            	System.out.println("Renta registrada exitosamente");
            }
            
		} else {
        	System.out.println("¡Error! Ese vehículo ya está rentado en esas fechas.");

        }
        
	}
	
	//ACTUALIZA LA RENTA A CANCELADA
	public void cancelarRenta(int id) {
		rm.cancelarRenta(id);
	}
	
	//ELIMINA LA RENTA DE LA BASE DE DATOS
	public void eliminarRenta(int id) {
		rm.delete(id);
	}
	
	//REGRESA EL COSTO TOTAL CALCULANDO LA TARIFA DIARIA DEL VEHICULO Y UTILIZANDO LA DISTANCIA
	public BigDecimal calcularCostoTotal(int iv, int io, int id, Date fi, Date ff) {
		BigDecimal costoTotal = rm.calcularCostoTotal(iv, io, id, fi, ff);
		return costoTotal;
	}
	
	//GENERA UN JDIALOG CON LA INFORMACION DEL PDF DE LA RESERVA
	public void visualizarDatosReserva(int id) {
		
		RentModel modeloDeRenta = new RentModel();
		Map<String, String> datosDelTicket = modeloDeRenta.getDatosParaPDF(id);

		if (datosDelTicket != null && !datosDelTicket.isEmpty()) {
		    
		    PDFGenerador creadorPdf = new PDFGenerador();
		    String rutaDeMiPlantilla = "src/resources/PDFs/plantilla_reserva.html";
		    
		    byte[] pdfEnBytes = creadorPdf.PreVisualizarPDF(rutaDeMiPlantilla, datosDelTicket);
		    
		    if (pdfEnBytes != null) {
		        PrevisualizadorPDF previsualizador = new PrevisualizadorPDF();
		        JLabel labelConVistaPrevia = previsualizador.generarVistaPreviaDesdeMemoria(pdfEnBytes);
		        
		        JDialog dialogVistaPrevia = new JDialog();
		        dialogVistaPrevia.setTitle("Vista Previa del Ticket");
		        dialogVistaPrevia.add(labelConVistaPrevia);
		        dialogVistaPrevia.pack();
		        dialogVistaPrevia.setLocationRelativeTo(null);
		        dialogVistaPrevia.setVisible(true);
		        
		    } else {
		        System.out.println("No se pudo convertir el HTML a PDF.");
		    }
		} else {
		    System.out.println("No se encontraron los datos de esa renta.");
		}
	}
		
	//Regresa la cantidad de Total de vehiculos
	public int numeroVehiculos_total(){
		int num_car_total = rm.numeroVehiculos_total();		
		return num_car_total;		
	}
	
	//Regresa la cantidad de vehiculos Rentados
	public int numeroVehiculos_renta(){
		int num_car_renta = rm.numeroVehiculos_renta();
		return num_car_renta;
	}
	
	//Regresa la cantidad de vehiculos Disponibles
	public int numeroVehiculos_dispo(){
		int num_car_disponibles = rm.numeroVehiculos_dispo();
		return num_car_disponibles;
	}
	
	//Regresa la cantidad de vehiculos en Mantenimiento
	public int numeroVehiculos_manteni(){
		int num_car_mantenimiento = rm.numeroVehiculos_manteni();
		return num_car_mantenimiento;
	}
	
	//REGRESA LA LISTA DELOS ESTADOS DE RENTA
	public ArrayList<String> getListaEstados() {
        return new ArrayList<>(Arrays.asList("Pendiente", "Activo", "Finalizado", "Cancelado"));
    }
	
	//REGRESA LISTA DE PRECIOS
	public ArrayList<BigDecimal> getListaPrecios() {
		return new ArrayList<>(Arrays.asList(
		        BigDecimal.valueOf(0.00),
		        BigDecimal.valueOf(75.00),
		        BigDecimal.valueOf(100.00),
		        BigDecimal.valueOf(150.00),
		        BigDecimal.valueOf(175.00),
		        BigDecimal.valueOf(200.00),
		        BigDecimal.valueOf(250.00),
		        BigDecimal.valueOf(275.00),
		        BigDecimal.valueOf(300.00),
		        BigDecimal.valueOf(350.00),
		        BigDecimal.valueOf(375.00),
		        BigDecimal.valueOf(400.00)));
    }
		
	//REGRESA LISTA DE AÑOS 
	public ArrayList<Integer> getListaAnios() {
		return new ArrayList<>(Arrays.asList(2028, 2027, 2026, 2025, 2024, 2023, 2022, 2021, 2020));
	}
	
	//REGRESA LISTA DE MODELOS DEPENDIENDO DE LA MARCA
	public ArrayList<String> getListaModelos(String nombreMarca) {
		return rm.getListaModelos(nombreMarca);
	}
	
	//REGRESA LA LISTA DE SUCURSALLES
	public ArrayList<String> getNombresSucursales( ) {
		return rm.getNombresSucursales();
	}
	 
	//REGRESA EL ID DE LA SUCURSAL
	public int sucursalID(String sucursal) {	
		return rm.getIdPorNombre(sucursal);
	}
	
	//REGRESA LA LISTA DE CLIENTES
	public ArrayList<String> getNombresClientes( ) {
		return rm.getNombresClientes();
	}
	 
	//REGRESA EL ID DE EL CLIENTE
	public int clientelID(String cliente) {	
		return rm.getIdPorNombre_Clientes(cliente);
	}
	
	 //REGRESA LISTA DE MODELOS
	 public ArrayList<String> getListaModelos() {
		 return vc.getListaModelos();
	 }
	 
	 //REGRESA EL ID DEL MODELO DEL NBOMBRE
	 public int obtenerIdModelo(String modelo) {
		 int id_modelo = vc.obtenerIdModelo(modelo);
		 return id_modelo;
	 }
	 
	 //REGRESA EL ID DEL ORIGEN DEL VEHICULO
	 public int getIdOrigenPorRenta(int id_renta) {
		 int id_origen = rm.getIdOrigenPorRenta(id_renta);
		 return id_origen;
	 }
	 
	 //REGRESA EL ID DEL DESTINO DEL VEHICULO
	 public int getIdDestinoPorRenta(int id_renta) {
		 int id_destino = rm.getIdDestinoPorRenta(id_renta);
		 return id_destino;
	 }
	 
	 //REGRESA EL ID DE LA SUCURSAL 
	 public int getIdSucursalPorNombre(String nombreSucursal) {
		 int id_sucursal = rm.getIdSucursalPorNombre(nombreSucursal);
		 return id_sucursal;
	 }
	 
	 //REGRESA LA FECHA DE INICIO DE LA RENTA
	 public Date getFechaInicioRenta(int id_renta) {
		 Date Fecha = rm.getFechaInicioRenta(id_renta);
		 return Fecha;
	 }
	 
	 //REGRESA LA FECHA DEL FINAL DE LA RENTA
	 public Date getFechaFinRenta(int id_renta) {
		 Date Fecha = rm.getFechaFinRenta(id_renta);
		 return Fecha;
	 }
	 
}
