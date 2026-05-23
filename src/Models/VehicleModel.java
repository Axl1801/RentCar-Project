package Models;

import java.io.InputStream;
import java.math.BigDecimal;
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


public class VehicleModel {
	
	private int id;
	private byte[] foto;
    private String modelo;
    private String marca;
    private int anio;
    private BigDecimal precio_dia;
    private String estado;


	public VehicleModel(){

	}
	
	public VehicleModel(int id, byte[] foto, String modelo, String marca, int anio, BigDecimal precio_dia, String estado){
	        this.id = id;
	        this.foto = foto;
	        this.modelo = modelo;
	        this.marca = marca;
	        this.anio = anio;
	        this.precio_dia = precio_dia;
	        this.estado = estado;

	    }

	 
	public ArrayList<VehicleModel> get()
	{
		ArrayList<VehicleModel> carros = new ArrayList<>();
	    	
	   	String query = "SELECT * FROM `Vehiculos`";
	    	
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
    				VehicleModel tmp = new VehicleModel();
    				
    				tmp.setId(rs.getInt("id_vehiculo"));
    				tmp.setfoto(rs.getBytes("foto"));
    				tmp.setmodelo(rs.getString("modelo"));
    				tmp.setmarca(rs.getString("marca"));
    				tmp.setanio(rs.getInt("anio"));
    				tmp.setprecio_dia(rs.getBigDecimal("precio_dia"));
    				tmp.setestado(rs.getString("estado"));
    				
    				carros.add(tmp);
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
		return carros;  	
	 }

	 public  boolean make(byte[] foto, String modelo, String marca, int anio, BigDecimal precio_dia, String estado){
		 
		 String query = "INSERT INTO `Vehiculos` (`foto`, `modelo`, `marca`, `anio`, `precio_dia`, `estado`) VALUES (?, ?, ?, ?, ?, ?);";
			
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
	    			ps.setBytes(1, foto);
	    			ps.setString(2, modelo);
	    			ps.setString(3, marca);
	    			ps.setInt(4, anio);
	    			ps.setBigDecimal(5, precio_dia);
	    			ps.setString(6, estado);

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
	 
	 public boolean update(int id_vehiculos, byte[] foto, String modelo, String marca, int anio, BigDecimal precio_dia, String estado) {
		 String query = "UPDATE `Vehiculos` SET `foto` = ?, `modelo` = ?, `marca` = ?, `anio` = ?, `precio_dia` = ?, `estado` = ? WHERE `id_vehiculo` = ?;";
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
	    			ps.setBytes(1, foto);
	    			ps.setString(2, modelo);
	    			ps.setString(3, marca);
	    			ps.setInt(4, anio);
	    			ps.setBigDecimal(5, precio_dia);
	    			ps.setString(6, estado);
	    			ps.setInt(7, id_vehiculos);

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
	 
	 public boolean delete(int id_vehiculo) {
		    String query = "DELETE FROM `Vehiculos` WHERE `id_vehiculo` = ?;";
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
		            ps.setInt(1, id_vehiculo);

		            int rowsAffected = ps.executeUpdate();

		            if (rowsAffected > 0) {
		                ps.close();
		                conn.close();
		                return true;
		            }

		            ps.close();
		            conn.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if (conn != null) conn.close();
		            } catch (Exception e) {}
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
		
		public String getIdLetra() {
		    return String.format("V-%03d", this.id);
		}
		
		public byte[] getfoto() {
			return this.foto;
		}
		
		public void setfoto(byte[] foto) {
			this.foto = foto;
		}

		public String getmarca() {
			return marca;
		}

		public void setmarca(String name) {
			this.marca = name;
		}

		public String getmodelo() {
			return modelo;
		}

		public void setmodelo(String email) {
			this.modelo = email;
		}
		
		public int getanio() {
			return anio;
		}
		
		public void setanio(int anio) {
			this.anio = anio;
		}
		
		public BigDecimal getprecio_dia() {
			return precio_dia;
		}
		
		public void setprecio_dia(BigDecimal precio_dia) {
			this.precio_dia = precio_dia;
		}

		public String getestado() {
			return estado;
		}

		public void setestado(String phone) {
			this.estado = phone;
		}
}
