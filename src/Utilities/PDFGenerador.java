package Utilities;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PDFGenerador {

    public boolean generarPdf(String rutaPlantillaHtml, String rutaSalidaPdf, Map<String, String> datos) {
        
        try {
            String htmlContent = new String(Files.readAllBytes(Paths.get(rutaPlantillaHtml)), "UTF-8");

            for (Map.Entry<String, String> entry : datos.entrySet()) {
                String comodin = "{{" + entry.getKey() + "}}";
                String valor = entry.getValue() != null ? entry.getValue() : ""; 
                
                htmlContent = htmlContent.replace(comodin, valor);
            }

            File archivoSalida = new File(rutaSalidaPdf);
            if (archivoSalida.getParentFile() != null) {
                archivoSalida.getParentFile().mkdirs(); 
            }

            try (OutputStream os = new FileOutputStream(archivoSalida)) {
                PdfRendererBuilder builder = new PdfRendererBuilder();
                
                builder.useFastMode(); 
                builder.withHtmlContent(htmlContent, archivoSalida.toURI().toURL().toString());
                builder.toStream(os);
                builder.run(); 
            }

            return true;

        } catch (Exception e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    
    public byte[] PreVisualizarPDF(String rutaPlantillaHtml, Map<String, String> datos) {
    	
    	try {
    		String htmlContent = new String(Files.readAllBytes(Paths.get(rutaPlantillaHtml)), "UTF-8");

    		for (Map.Entry<String, String> entry : datos.entrySet()) {
    			String comodin = "{{" + entry.getKey() + "}}";
    			String valor = entry.getValue() != null ? entry.getValue() : ""; 
    			htmlContent = htmlContent.replace(comodin, valor);
    		}

            try (ByteArrayOutputStream salidaEnMemoria = new ByteArrayOutputStream()) {
                
                PdfRendererBuilder builder = new PdfRendererBuilder();
                builder.useFastMode(); 
                
                builder.withHtmlContent(htmlContent, new File(".").toURI().toURL().toString());
                builder.toStream(salidaEnMemoria);
                builder.run(); 
                
                return salidaEnMemoria.toByteArray();
            }

        } catch (Exception e) {
            System.err.println("Error al generar el PDF en memoria: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
}