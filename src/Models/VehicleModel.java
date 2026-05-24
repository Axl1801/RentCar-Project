package Models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class VehicleModel {
	
	private int id;
	private byte[] foto;
    private int id_modelo;
    private int id_categoria;
    private String modelo;
    private String marca;
    private String categoria;
    private int anio;
    private BigDecimal precio_dia;
    private String estado;

	public VehicleModel(){
	}
	
	public VehicleModel(int id, byte[] foto, int id_modelo, int id_categoria, String modelo, String marca, String categoria, int anio, BigDecimal precio_dia, String estado){
        this.id = id;
        this.foto = foto;
        this.id_modelo = id_modelo;
        this.id_categoria = id_categoria;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.anio = anio;
        this.precio_dia = precio_dia;
        this.estado = estado;
	}

	public ArrayList<VehicleModel> get() {
		ArrayList<VehicleModel> carros = new ArrayList<>();
	    
		String query = "SELECT v.id_vehiculo, v.foto, v.anio, v.precio_dia, v.estado, " +
                      "v.id_modelo, mo.nombre AS modelo_texto, " +
                      "m.nombre AS marca_texto, " +
                      "v.id_categoria, c.nombre AS categoria_texto " +
                      "FROM Vehiculos v " +
                      "JOIN Modelos mo ON v.id_modelo = mo.id_modelo " +
                      "JOIN Marcas m ON mo.id_marca = m.id_marca " +
                      "JOIN Categorias c ON v.id_categoria = c.id_categoria";
	    	
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

    			while(rs.next()) {
    				VehicleModel tmp = new VehicleModel();
    				
    				tmp.setId(rs.getInt("id_vehiculo"));
    				tmp.setfoto(rs.getBytes("foto"));
    				tmp.setanio(rs.getInt("anio"));
    				tmp.setprecio_dia(rs.getBigDecimal("precio_dia"));
    				tmp.setestado(rs.getString("estado"));                
                    tmp.setId_modelo(rs.getInt("id_modelo"));
                    tmp.setId_categoria(rs.getInt("id_categoria"));
                    tmp.setmodelo(rs.getString("modelo_texto"));
                    tmp.setmarca(rs.getString("marca_texto"));
                    tmp.setCategoria(rs.getString("categoria_texto"));
                    
    				carros.add(tmp);
    			}
    			rs.close(); ps.close();
            } catch (Exception e) { e.printStackTrace(); }
            finally { try { if(conn != null) conn.close(); }catch(Exception e) {} }
		} catch (IOException e) {
			System.out.println("Error config: " + e.getMessage());
		}
		return carros;  	
	}

	public boolean make(byte[] foto, int id_modelo, int id_categoria, int anio, BigDecimal precio_dia, String estado){
		 
		 String query = "INSERT INTO `Vehiculos` (`foto`, `id_modelo`, `id_categoria`, `anio`, `precio_dia`, `estado`) VALUES (?, ?, ?, ?, ?, ?);";
			
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
	    			ps.setInt(2, id_modelo);
	    			ps.setInt(3, id_categoria);
	    			ps.setInt(4, anio);
	    			ps.setBigDecimal(5, precio_dia);
	    			ps.setString(6, estado);
	    			
	    			int rowsAffected = ps.executeUpdate();
	    			if (rowsAffected > 0) { ps.close(); conn.close(); return true; }
	    			ps.close();
	            } catch (Exception e) { e.printStackTrace(); }
	            finally { try { if(conn!=null) conn.close(); }catch(Exception e) {} }
		 } catch (IOException e) { System.out.println("Error config: " + e.getMessage()); }  		 
		 return false;	 
	 }

	 public boolean update(int id_vehiculo, byte[] foto, int id_modelo, int id_categoria, int anio, BigDecimal precio_dia, String estado) {
		 String query = "UPDATE `Vehiculos` SET `foto` = ?, `id_modelo` = ?, `id_categoria` = ?, `anio` = ?, `precio_dia` = ?, `estado` = ? WHERE `id_vehiculo` = ?;";
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
	    			ps.setInt(2, id_modelo);
	    			ps.setInt(3, id_categoria);
	    			ps.setInt(4, anio);
	    			ps.setBigDecimal(5, precio_dia);
	    			ps.setString(6, estado);
	    			ps.setInt(7, id_vehiculo);

	    			int rowsAffected = ps.executeUpdate();
	    			if (rowsAffected > 0) { ps.close(); conn.close(); return true; }
	    			ps.close();
	            } catch (Exception e) { e.printStackTrace(); }
	            finally { try { if(conn!=null) conn.close(); }catch(Exception e) {} }
		 } catch (IOException e) { System.out.println("Error config: " + e.getMessage()); }  		 
		 return false;		 
	 }
	 
	 public boolean delete(int id_vehiculo) {

		 String queryComprobar = "SELECT COUNT(*) FROM Rentas WHERE id_vehiculo = ?;";
		 String queryDesactivar = "UPDATE Vehiculos SET estado = 'Inactivo' WHERE id_vehiculo = ?;";
		 String queryBorrar = "DELETE FROM Vehiculos WHERE id_vehiculo = ?;";
		    
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

				 PreparedStatement psCheck = conn.prepareStatement(queryComprobar);
				 psCheck.setInt(1, id_vehiculo);
				 ResultSet rs = psCheck.executeQuery();
	            
				 boolean tieneHistorial = false;
				 if (rs.next()) {
					 tieneHistorial = rs.getInt(1) > 0;
				 }
				 rs.close();
				 psCheck.close();

				 PreparedStatement psAccion;
				 if (tieneHistorial) {
					 psAccion = conn.prepareStatement(queryDesactivar);
					 System.out.println("El vehículo tiene rentas.");
				 } else {
					 psAccion = conn.prepareStatement(queryBorrar);
					 System.out.println("El vehículo está limpio.");
				 }

				 psAccion.setInt(1, id_vehiculo);
				 int rowsAffected = psAccion.executeUpdate();

				 psAccion.close();
				 conn.close();

				 return rowsAffected > 0;

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
	 
	 public int getId(){
		 return this.id; 
	 }
	
	 public void setId(int id){
		 this.id = id;
	 }
		
	 public String getIdLetra(){
		 return String.format("V-%03d", this.id);
	 }
		
	 public byte[] getfoto(){
		 return this.foto;
	 }
	
	 public void setfoto(byte[] foto){
		 this.foto = foto;
	 }
	 
	 public int getId_modelo(){
		 return id_modelo;
	 }
    
	 public void setId_modelo(int id_modelo){ 
		 this.id_modelo = id_modelo;
	 }

	 public int getId_categoria(){
		 return id_categoria;
	 }
    
	 public void setId_categoria(int id_categoria){ 
		 this.id_categoria = id_categoria;
	 }
	 
	 public String getmarca(){
		 return marca;
	 }
	
	 public void setmarca(String marca){
		 this.marca = marca;
	 }

	 public String getmodelo(){
		return modelo;
	 }
	
	 public void setmodelo(String modelo){
		 this.modelo = modelo;
	 }

	 public String getCategoria(){ 
		 return categoria;
	 }
    
   	public void setCategoria(String categoria){
   		this.categoria = categoria;
   	}
		
   	public int getanio(){ 
   		return anio; 
   	}
	
   	public void setanio(int anio){
		this.anio = anio; 
   	}
		
   	public BigDecimal getprecio_dia(){ 
   		return precio_dia;
   	}
	
   	public void setprecio_dia(BigDecimal precio_dia){ 
   		this.precio_dia = precio_dia; 
   	}

   	public String getestado(){
   		return estado; 
   	}
	
   	public void setestado(String estado){
   		this.estado = estado; 
   	}
	
}