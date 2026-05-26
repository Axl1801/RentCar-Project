package Models;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.Statement;

public class AuthModel {
	public AuthModel(){

	}

	public boolean login(String usuario, String contrasena) {

		String query = "SELECT * FROM Agente WHERE usuario = ? AND contrasena = ?";

		System.out.println(query);
		
		Connection conn = null;
		
		Properties propiedades = new Properties();
		
		try (InputStream entrada = new FileInputStream("Claves.txt")) {
			
			propiedades.load(entrada);
			
			String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");
            
            try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			conn = DriverManager.getConnection(url, user, contra);

    			PreparedStatement ps = conn.prepareStatement(query);
    			ps.setString(1, usuario.trim());
    			ps.setString(2, contrasena.trim());

    			ResultSet rs = ps.executeQuery();

    			if (rs.next()) {

        			rs.close();
        			ps.close();
        			conn.close();
    				return true;
    			}  

    			rs.close();
    			ps.close();
    			conn.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		finally {
    			try {
    				conn.close();
    			}catch(Exception e) {}
    		}
    		
		} catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración: " + e);
        }  
		
		return false;
	}
}
