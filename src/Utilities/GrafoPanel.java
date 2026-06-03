package Utilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GrafoPanel extends JPanel {

    public GrafoPanel() {
        setLayout(new BorderLayout());
        
        JFXPanel jfxPanel = new JFXPanel();
        add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            WebView webView = new WebView();            
            String html = "<!DOCTYPE html>" +
                          "<html>" +
                          "<head>" +
                          "<meta charset=\"UTF-8\">" +
                          "<style>" +
                          "  html, body { margin: 0; padding: 0; width: 100%; height: 100%; overflow: hidden; background-color: #FFFFFF; display: flex; align-items: center; justify-content: center; }" +
                          "  .flourish-embed { width: 100%; height: 100vh !important; }" +
                          "</style>" +
                          "</head>" +
                          "<body>" +
                          "<div class=\"flourish-embed flourish-network\" data-src=\"visualisation/29032604\" data-height=\"100%\">" +
                          "<script src=\"https://public.flourish.studio/resources/embed.js\"></script>" +
                          "</div>" +
                          "</body>" +
                          "</html>";
            
            webView.getEngine().loadContent(html);
            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
        });
    }
}