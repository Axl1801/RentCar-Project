package Utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PrevisualizadorPDF {

    public PrevisualizadorPDF() {
    }

    public JLabel generarVistaPreviaDesdeMemoria(byte[] bytesDelPDF) {
        JLabel labelPrevia = new JLabel();

        if (bytesDelPDF == null || bytesDelPDF.length == 0) {
            labelPrevia.setText("Error: PDF vacío");
            return labelPrevia;
        }

        try {
            PDDocument documento = PDDocument.load(bytesDelPDF);

            PDFRenderer renderizador = new PDFRenderer(documento);

            BufferedImage imagenPDF = renderizador.renderImageWithDPI(0, 150);

            Image imagenEscalada = imagenPDF.getScaledInstance(550, 750, Image.SCALE_SMOOTH);

            labelPrevia.setIcon(new ImageIcon(imagenEscalada));

            documento.close();

        } catch (Exception e) {
            System.out.println("Error al renderizar el PDF con PDFBox: " + e.getMessage());
            e.printStackTrace();
            labelPrevia.setText("No se pudo cargar la vista previa del PDF");
        }

        return labelPrevia;
    }
}