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
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Statement;


public class EstablishmentModel {
	
	private int id;
    private String nombre_sucursal;
    private String direccion;


	public EstablishmentModel(){

	}
	
	public EstablishmentModel(int id, String nombre_sucursal, String direccion){
	        this.id = id;
	        this.nombre_sucursal = nombre_sucursal;
	        this.direccion = direccion;
	    }

	 
	public ArrayList<EstablishmentModel> get()
	{
		ArrayList<EstablishmentModel> lugar = new ArrayList<>();
	    	
	   	String query = "SELECT * FROM `Locacion`";
	    	
	   	Connection conn = null; 	 
		System.out.println(query);
			
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
    			ResultSet rs = ps.executeQuery();

    			while(rs.next())
    			{
    				EstablishmentModel tmp = new EstablishmentModel();
    				
    				tmp.setId(rs.getInt("id_locacion"));
    				tmp.setName(rs.getString("nombre_sucursal"));
    				tmp.setEmail(rs.getString("direccion"));
    				
    				lugar.add(tmp);
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
            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
		return lugar;  	
	 }

	 public  boolean make(int id_locacion, String nombre_sucursal, String direccion)
	    {
		 String query = "INSERT INTO `Loacion` (`id_locacion`, `nombre_sucursal`, `direccion`) VALUES (?, ?, ?);";
			
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
					ps.setInt(1, id_locacion);
					ps.setString(2, nombre_sucursal);
	    			ps.setString(3, direccion);

	    			int rowsAffected = ps.executeUpdate();
	    			
	    			if (rowsAffected > 0)
	    			{
	    				
	    				ps.close();
	    				conn.close();
	    				
	    				return true;
	    			}

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
	            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
	        }  		 
			return false;	 
	    }
	 
	 public boolean update(int id_locacion, String nombre_sucursal, String direccion) {
		 String query = "UPDATE `Locacion` SET `nombre_sucursal` = ?, `direccion` = ? WHERE `id_locacion` = ?;";
		 Properties propiedades = new Properties();
		 Connection conn = null;						
		 
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
				
				propiedades.load(entrada);				
				String url = propiedades.getProperty("db.url");
	            String user = propiedades.getProperty("db.user");
	            String contra = propiedades.getProperty("db.password");
	            
	            try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    			conn = DriverManager.getConnection(url, user, contra);

	    			PreparedStatement ps = conn.prepareStatement(query);
	    			ps.setString(1, nombre_sucursal);
	                ps.setString(2, direccion);
	                ps.setInt(3, id_locacion);

	    			int rowsAffected = ps.executeUpdate();
	    			
	    			if (rowsAffected > 0)
	    			{	    				
	    				ps.close();
	    				conn.close();	    				
	    				return true;
	    			}
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
	            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
	        }  		 
		return false;		 
	 }
	 
	 	public int getId() {
		    return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getnombre_sucursal() {
			return nombre_sucursal;
		}

		public void setName(String nombre_sucursal) {
			this.nombre_sucursal = nombre_sucursal;
		}

		public String getdireccion() {
			return direccion;
		}

		public void setEmail(String direccion) {
			this.direccion = direccion;
		}
}
