package Controllers;

import java.util.HashMap;
import java.util.Map;
import Utilities.PDFGenerador;
import Models.RentModel;

public class PDFController {

	public PDFController() {
		// TODO Auto-generated constructor stub
	}
	
	private RentModel rm;

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
}
