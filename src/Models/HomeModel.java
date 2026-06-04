package Models;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class HomeModel {
	
	
	 public ArrayList<String> getListaMarcas() {
		 ArrayList<String> marcas = new ArrayList<>();
		 String query = "SELECT nombre FROM Marcas ORDER BY nombre ASC";

		 Properties propiedades = new Properties();
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");

			 try (Connection conn = DriverManager.getConnection(url, user, contra);
					 PreparedStatement ps = conn.prepareStatement(query);
					 ResultSet rs = ps.executeQuery()) {

				 while (rs.next()) {
					 marcas.add(rs.getString("nombre"));
				 }
				 
				 rs.close();
				 ps.close();
				 conn.close();
			 }
		 } catch (Exception e) {
			 System.out.println("Error al obtener marcas: " + e.getMessage());
		 }
		 return marcas;
	 }
	 
	 public String getCategoriaVehiculo(int id_vehiculo) {
		 String nombreCategoria = "";
	        
		 String query = "SELECT c.nombre " +
				 		"FROM Vehiculos v " +
				 		"INNER JOIN Categorias c ON v.id_categoria = c.id_categoria " +
				 		"WHERE v.id_vehiculo = ?";

		 Properties propiedades = new Properties();
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");

			 try (Connection conn = DriverManager.getConnection(url, user, contra);
					 PreparedStatement ps = conn.prepareStatement(query)) {
				 
				 ps.setInt(1, id_vehiculo);
	                
				 try (ResultSet rs = ps.executeQuery()) {
					 if (rs.next()) {
						 nombreCategoria = rs.getString("nombre");
					 }
					 rs.close();
					 ps.close();
	   				 conn.close();
				 }
			 }
		 } catch (Exception e) {
			 System.out.println("Error al consultar la categoría: " + e.getMessage());
		 }        
		 return nombreCategoria;
	 }
	 
	 public ArrayList<String> getListaModelos(String nombreMarca) {
		 ArrayList<String> modelos = new ArrayList<>();
	        
		 String query = "SELECT mo.nombre " +
				 		"FROM Modelos mo " +
				 		"INNER JOIN Marcas ma ON mo.id_marca = ma.id_marca " +
				 		"WHERE ma.nombre = ? " +
				 		"ORDER BY mo.nombre ASC";

		 Properties propiedades = new Properties();
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");

			 try (Connection conn = DriverManager.getConnection(url, user, contra);
					 PreparedStatement ps = conn.prepareStatement(query)) {
	                 
				 ps.setString(1, nombreMarca);
	                
				 try (ResultSet rs = ps.executeQuery()) {
					 while (rs.next()) {
						 modelos.add(rs.getString("nombre"));
					 }
					 
					 rs.close();
					 ps.close();
					 conn.close();
				 }
			 }
		 } catch (Exception e) {
			 System.out.println("Error al obtener modelos filtrados: " + e.getMessage());
		 }
		 return modelos;
	 }
	
	
}