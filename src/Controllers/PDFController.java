package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Utilities.PDFGenerador;
import Models.RentModel;
import Models.ClientModel;

public class PDFController {

	public PDFController() {
		// TODO Auto-generated constructor stub
	}
	
	private RentModel rm;
	private ClientModel cm;

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
	    System.out.println("Iniciando generación de PDF de Clientes...");

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

	    // 4. Mandamos a imprimir con PDFGenerator
	    String rutaPlantilla = "src/resources/plantilla_clientes.html";
	    String rutaSalidaPDF = "Reportes/Reporte_Clientes_General.pdf";

	    PDFGenerador generador = new PDFGenerador();
	    boolean exito = generador.generarPdf(rutaPlantilla, rutaSalidaPDF, datosClientes);
	    }
	}
}