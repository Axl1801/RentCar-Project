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
import Utilities.Usuario;

public class AuthModel {
	public AuthModel(){
	}

	public boolean login(String usuario, String contrasena) {

		String query = "SELECT id_agente, usuario, correo, nivel_acceso FROM Agente WHERE usuario = ? AND contrasena = ?";
		
		System.out.println("Ejecutando: " + query);
		
		Properties propiedades = new Properties();
		
		try (InputStream entrada = new FileInputStream("Claves.txt")) {
			
			propiedades.load(entrada);
			String url = propiedades.getProperty("db.url");
			String user = propiedades.getProperty("db.user");
			String contra = propiedades.getProperty("db.password");
			
			try (Connection conn = DriverManager.getConnection(url, user, contra);
					PreparedStatement ps = conn.prepareStatement(query)) {
				
				ps.setString(1, usuario.trim());
				ps.setString(2, contrasena.trim());

				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Usuario.crearUsuarioMostrar(
								rs.getInt("id_agente"),
								rs.getString("usuario"),
								rs.getString("correo"),
								rs.getString("nivel_acceso")
								);
						return true;
					}
				}
					
			} catch (Exception e) {
				System.out.println("Error en la conexión o consulta de BD: " + e.getMessage());
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de configuración Claves.txt: " + e.getMessage());
		}  
		return false;
	}
}

