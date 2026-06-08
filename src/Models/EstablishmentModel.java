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

	 
	public ArrayList<String> get(){
		ArrayList<String> lugar = new ArrayList<>();
	    	
		String query = "SELECT nombre_sucursal FROM `Locacion`";
		
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
    			ResultSet rs = ps.executeQuery();

    			while(rs.next())
    			{
    				lugar.add(rs.getString("nombre_sucursal"));
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
        }
		return lugar;  	
	 }

	public  boolean make(int id_locacion, String nombre_sucursal, String direccion){
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
	        }  		 
		return false;		 
	}
	
	public double calcularDistancia(int id_origen, int id_destino) {
        
		if (id_origen == id_destino) {
			return 0.0;
		}

		double distanciaKm = 0.0;
		String query = "SELECT SUM(weight) FROM motor_rutas WHERE latch = 'dijkstra' AND origid = ? AND destid = ?";
        
		Properties propiedades = new Properties();

		try (InputStream entrada = new FileInputStream("Claves.txt")) {
			propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
                 PreparedStatement ps = conn.prepareStatement(query)) {
                 
                ps.setInt(1, id_origen);
                ps.setInt(2, id_destino);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        distanciaKm = rs.getDouble(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return distanciaKm;
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

	public int getIdLocacion(String nombreSucursal) {
	    int idLocacion = -1;

	    String query = "SELECT id_locacion FROM Locacion WHERE nombre_sucursal = ?";

	    Properties propiedades = new Properties();

	    try (InputStream entrada = new FileInputStream("Claves.txt")) {

	        propiedades.load(entrada);

	        String url = propiedades.getProperty("db.url");
	        String user = propiedades.getProperty("db.user");
	        String contra = propiedades.getProperty("db.password");

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection conn = DriverManager.getConnection(url, user, contra);
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setString(1, nombreSucursal);

	            try (ResultSet rs = ps.executeQuery()) {

	                if (rs.next()) {
	                    idLocacion = rs.getInt("id_locacion");
	                }
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return idLocacion;
	}
	
	public void setEmail(String direccion) {
		this.direccion = direccion;
	}
	
}
