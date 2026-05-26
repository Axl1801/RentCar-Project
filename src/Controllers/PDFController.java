package Controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import Utilities.PDFGenerador;
import Models.RentModel;
import Models.VehicleModel;
import Models.ClientModel;

public class PDFController {

	public PDFController() {
		// TODO Auto-generated constructor stub
	}
	
	private RentModel rm;
	private ClientModel cm;
	private VehicleModel vm;

	public void generarPDFReserva(int idRentaSeleccionada) {
	    
	    Map<String, String> datosRenta = rm.getDatosParaPDF(idRentaSeleccionada);
	    
	    if (datosRenta.isEmpty()) {
	        System.out.println("No se encontró la renta en la BD.");
	        return; 
	    }

	    String rutaPlantilla = "src/resources/PDFs/plantilla_reserva.html";
	    String rutaSalidaPDF = "Tickets/Ticket_Reserva_R" + datosRenta.get("id_renta") + ".pdf";

	    PDFGenerador generador = new PDFGenerador();
	    boolean exitoPdf = generador.generarPdf(rutaPlantilla, rutaSalidaPDF, datosRenta);
	
}
	
	public void generarPDFReporteClientes() {

	    ArrayList<ClientModel> listaClientes = cm.get();

	    StringBuilder filasHtml = new StringBuilder();

	    for (ClientModel c : listaClientes) {
	        filasHtml.append("<tr>");     
	        filasHtml.append("<td style=\"font-weight:bold;\">").append(c.getIdLetra()).append("</td>");
	        filasHtml.append("<td>").append(c.getName()).append("</td>");
	        filasHtml.append("<td>").append(c.getEmail()).append("</td>");
	        filasHtml.append("<td>").append(c.getPhone()).append("</td>");
	        filasHtml.append("</tr>");

	    Map<String, String> datosClientes = new HashMap<>();
	    datosClientes.put("filas_clientes", filasHtml.toString());

	    String rutaPlantilla = "src/resources/plantilla_clientes.html";
	    String rutaSalidaPDF = "Reportes/Reporte_Clientes_General.pdf";

	    PDFGenerador generador = new PDFGenerador();
	    boolean exito = generador.generarPdf(rutaPlantilla, rutaSalidaPDF, datosClientes);
	    }
	}
	
	public void generarPDFReporteVehiculos() {

	    ArrayList<VehicleModel> listaCarros = vm.get();

	    StringBuilder filasHtml = new StringBuilder();

	    for (VehicleModel vm : listaCarros) {
	        filasHtml.append("<tr>");

	        byte[] fotoBytes = vm.getfoto();
	        String fotoBase64 = "";
	        
	        if (fotoBytes != null && fotoBytes.length > 0) {
	            fotoBase64 = Base64.getEncoder().encodeToString(fotoBytes);
	            filasHtml.append("<td style=\"text-align: center;\"><img src=\"data:image/jpeg;base64,")
	                     .append(fotoBase64)
	                     .append("\" class=\"img-carro\"/></td>");
	        } else {
	            filasHtml.append("<td style=\"text-align: center; color: #94a3b8; font-size: 8pt;\">Sin Foto</td>");
	        }

	        filasHtml.append("<td style=\"font-weight:bold;\">V-").append(vm.getId()).append("</td>");
	        filasHtml.append("<td>").append(vm.getmarca()).append("</td>");
	        filasHtml.append("<td>").append(vm.getmodelo()).append("</td>");
	        filasHtml.append("<td>").append(vm.getanio()).append("</td>");
	        filasHtml.append("<td style=\"text-align: right;\">$").append(vm.getprecio_dia()).append("</td>");
	        
	        String estado = vm.getestado() != null ? vm.getestado() : "Disponible";
	        
	        filasHtml.append("<td style=\"text-align: center;\">");
	        if (estado.equalsIgnoreCase("Disponible")) {
	            filasHtml.append("<span class=\"badge badge-disponible\">Disponible</span>");
	        } else if (estado.equalsIgnoreCase("Rentado")) {
	            filasHtml.append("<span class=\"badge badge-rentado\">Rentado</span>");
	        } else {
	            filasHtml.append("<span class=\"badge badge-taller\">Mantenimiento</span>");
	        }
	        filasHtml.append("</td>");
	        
	        filasHtml.append("</tr>");
	    }

	    Map<String, String> datosVehiculos = new HashMap<>();
	    datosVehiculos.put("filas_vehiculos", filasHtml.toString());

	    String rutaPlantilla = "src/resources/PDFs/plantilla_vehiculos.html";
	    String rutaSalidaPDF = "Reportes/Reporte_Flotilla_Vehiculos.pdf";

	    PDFGenerador generador = new PDFGenerador();
	    boolean exito = generador.generarPdf(rutaPlantilla, rutaSalidaPDF, datosVehiculos);
	}
}