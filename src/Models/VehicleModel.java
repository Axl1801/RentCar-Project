package Models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import Utilities.FilaTabla;

public class VehicleModel implements FilaTabla{
	
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
	private int id_renta;
	private String name;
    private Date inicio_renta;
	private Date fin_renta;
	private String estado_renta;

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
		 
		 String query = "INSERT INTO `Vehiculos` (`foto`,`id_modelo`, `id_categoria`, `anio`, `precio_dia`, `estado`) VALUES (?, ?, ?, ?, ?, ?);";
			
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

	 public boolean update(int id_vehiculo, BigDecimal precio_dia, String estado) {
		 String query = "UPDATE `Vehiculos` SET `precio_dia` = ?, `estado` = ? WHERE `id_vehiculo` = ?;";
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
	    			ps.setBigDecimal(1, precio_dia);
	    			ps.setString(2, estado);
	    			ps.setInt(3, id_vehiculo);

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
	 
	 public VehicleModel buscarVehiculoPorId(int id_vehiculo) {
		    
		 VehicleModel vehiculo_solo = null;
		 
		 String query = "SELECT v.*, mo.nombre AS modelo_texto, ma.nombre AS marca_texto " +
		                "FROM Vehiculos v " +
		                "INNER JOIN Modelos mo ON v.id_modelo = mo.id_modelo " +
		                "INNER JOIN Marcas ma ON mo.id_marca = ma.id_marca " +
		                "WHERE v.id_vehiculo = ?";
		                
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
				 ps.setInt(1, id_vehiculo);
				 ResultSet rs = ps.executeQuery();

				 if (rs.next()) {
					 vehiculo_solo = new VehicleModel();
					 
					 vehiculo_solo.setId(rs.getInt("id_vehiculo"));
					 
					 vehiculo_solo.setmarca(rs.getString("marca_texto")); 
					 vehiculo_solo.setmodelo(rs.getString("modelo_texto")); 
					 
					 vehiculo_solo.setanio(rs.getInt("anio")); 
					 vehiculo_solo.setprecio_dia(rs.getBigDecimal("precio_dia"));
					 vehiculo_solo.setestado(rs.getString("estado"));                
					 vehiculo_solo.setfoto(rs.getBytes("foto")); 
				 }

				 rs.close();
				 ps.close();
				 conn.close();

			 } catch (Exception e) {
    	       System.out.println("Error al buscar el vehículo: " + e.getMessage());
    	       e.printStackTrace();
			 } finally {
				 try {
					 if (conn != null && !conn.isClosed()) {
						 conn.close();
					 }
				 } catch(Exception e) {}
			 }

		 } catch (Exception e) {
			 System.out.println("Error al leer configuración: " + e.getMessage());
		 }  
		 return vehiculo_solo; 
	 }
	 
	 private int conteo(String query) {
		
		 int resultado = 0;
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

				 if (rs.next()) {
					 resultado = rs.getInt(1);
					 System.out.println("Número total: " + resultado);
				 }
				 rs.close();
				 ps.close();
				 conn.close();
			 }

			 catch (Exception e) {
				 e.printStackTrace();
			 }
			 finally {
				 try {
					 conn.close();
				 }catch(Exception e) {	
				 }
			 }
		 } catch (IOException e) {
			 System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
		 }  		 
		 return resultado;	 
	 }
	
	 public int numeroVehiculos_total() {
		 int total = conteo("SELECT COUNT(*) FROM Vehiculos");
		 System.out.println("numeroVehiculos_total: " + total);
		 return total;
	 }

	 public int numeroVehiculos_renta() {
		 int renta = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Rentado'");
		 System.out.println("numeroVehiculos_renta: " +renta);
		 return renta;
	 }

	 public int numeroVehiculos_dispo() {
		 int dispo = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Disponible'");
		 System.out.println("numeroVehiculos_dispo: " + dispo);
		 return dispo;
	 }

	 public int numeroVehiculos_manteni() {
		 int manteni = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Mantenimiento'");
		 System.out.println("numeroVehiculos_manteni: " + manteni);
		 return manteni;
 	  }
	 
	 public VehicleModel (int id_renta, String Nombre_Cliente, Date inicio_renta, Date fin_renta, String estado_renta){
		 
		 this.id_renta = id_renta;
		 this.name = Nombre_Cliente;
		 this.inicio_renta = inicio_renta;
		 this.fin_renta = fin_renta;
		 this.estado_renta = estado_renta;
	 }
	    
	 public ArrayList<VehicleModel> getinfo(int id_vehiculo) {
	    	
		 ArrayList<VehicleModel> rentas = new ArrayList<>();
	        
		 String query = "SELECT r.id_renta, c.name AS name, r.inicio_renta, r.fin_renta, r.estado " +
				 		"FROM Rentas r " +
				 		"INNER JOIN Clientes c ON r.id_cliente = c.id_cliente " +
				 		"WHERE r.id_vehiculo = ?";
	        
		 Connection conn = null; 	 
		 System.out.println(query);
		   	
		 Properties propiedades = new Properties();
		   	
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");
			 System.out.println("ANSDJFOKBNADSBFNIJAHKSB");
			 try {
				 System.out.println("561968416548948948");
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 conn = DriverManager.getConnection(url, user, contra);

				 PreparedStatement ps = conn.prepareStatement(query);
				 ps.setInt(1, id_vehiculo);
				 ResultSet rs = ps.executeQuery();
	    			
				 while (rs.next()) {
					 System.out.println("HUEVOS ARIAN");
					 VehicleModel tmp = new VehicleModel();

					 tmp.setId_renta(rs.getInt("id_renta"));
					 tmp.setName(rs.getString("name"));                
					 tmp.setInicio_renta(rs.getDate("inicio_renta"));
					 tmp.setFin_renta(rs.getDate("fin_renta"));
					 tmp.setestado(rs.getString("estado"));
					 System.out.println("dfadsfsadfs");
					 rentas.add(tmp);
				 }
	                
				 rs.close();
				 ps.close();
				 conn.close();
	    			
			 } catch (Exception e) {
				 e.printStackTrace();
			 }

		 } catch (IOException e) {
			 System.out.println("Error al leer configuración: " + e.getMessage());
		 }
		 return rentas;
	 }	 
	 
	 public ArrayList<String> getListaMarcas() {
		 ArrayList<String> marcas = new ArrayList<>();
		 String query = "SELECT nombre FROM Marcas ORDER BY id_marca ASC";

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
				 		"ORDER BY id_modelo ASC";

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
	 
	 public ArrayList<String> getNombresModelos() {
		 ArrayList<String> nombres = new ArrayList<>();
	         
		 String query = "SELECT nombre FROM Modelos ORDER BY id_modelo ASC";
	         
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
					 nombres.add(rs.getString("nombre"));
				 }
				 
			 } catch (Exception e) {
				 System.out.println("Error al obtener nombres de los modelos: " + e.getMessage());
			 }

		 } catch (Exception e) {
			 System.out.println("Error al leer Claves.txt: " + e.getMessage());
		 }
	         
		 return nombres;
	 }
	 
	 public int getIdPorNombreModelo(String nombreModelo) {
		 int idModelo = -1; 
	        
		 String query = "SELECT id_modelo FROM Modelos WHERE nombre = ? LIMIT 1";

		 Properties propiedades = new Properties();
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");

			 try (Connection conn = DriverManager.getConnection(url, user, contra);
					 PreparedStatement ps = conn.prepareStatement(query)) {
				 
				 ps.setString(1, nombreModelo);
	                
				 try (ResultSet rs = ps.executeQuery()) {
					 if (rs.next()) {
						 idModelo = rs.getInt("id_modelo");
					 }
				 }
			 }
		 } catch (Exception e) {
			 System.out.println("Error al buscar el ID del modelo: " + e.getMessage());
		 }
		 return idModelo;
	 }
	 
	 public int obtenerIdMarca(String nombreMarca) {
		 int idMarca = -1;
		 String query = "SELECT id_marca FROM Marcas WHERE nombre = ?";

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
					 if (rs.next()) {
						 idMarca = rs.getInt("id_marca");
					 }
				 }
			 }
		 } catch (Exception e) {
			 System.out.println("Error al buscar el ID de la marca: " + e.getMessage());
		 }
		 return idMarca;
	 }
	 
	 public int obtenerIdCategoria(String nombreCategoria) {
		 int idCategoria = -1;
		 String query = "SELECT id_categoria FROM Categorias WHERE nombre = ?";

		 Properties propiedades = new Properties();
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");

			 try (Connection conn = DriverManager.getConnection(url, user, contra);
					 PreparedStatement ps = conn.prepareStatement(query)) {
	                 
				 ps.setString(1, nombreCategoria);
				 try (ResultSet rs = ps.executeQuery()) {
					 if (rs.next()) {
						 idCategoria = rs.getInt("id_categoria");
					 }
				 }
			 }
		 } catch (Exception e) {
			 System.out.println("Error al buscar el ID de la Categoria: " + e.getMessage());
		 }
		 return idCategoria;
	 }
	 
	 public int obtenerIdModelo(String nombreModelo) {
		 int idModelo = -1;
		 String query = "SELECT id_modelo FROM Modelos WHERE nombre = ?";

		 Properties propiedades = new Properties();
		 try (InputStream entrada = new FileInputStream("Claves.txt")) {
			 propiedades.load(entrada);
			 String url = propiedades.getProperty("db.url");
			 String user = propiedades.getProperty("db.user");
			 String contra = propiedades.getProperty("db.password");

			 try (Connection conn = DriverManager.getConnection(url, user, contra);
					 PreparedStatement ps = conn.prepareStatement(query)) {
	                 
				 ps.setString(1, nombreModelo);
				 try (ResultSet rs = ps.executeQuery()) {
					 if (rs.next()) {
						 idModelo = rs.getInt("id_modelo");
					 }
				 }
			 }
		 } catch (Exception e) {
			 System.out.println("Error al buscar el ID del modelo: " + e.getMessage());
		 }
		 return idModelo;
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
	 
	 public String getIdLetraRenta() {
        return String.format("R-%03d", this.id_renta);
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
   	
    public int getId_renta() {
        return this.id_renta;
    }

    public void setId_renta(int id_renta) { 
        this.id_renta = id_renta;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public Date getInicio_renta() {
		return this.inicio_renta;
	}

	public void setInicio_renta(Date inicio_renta) {
		this.inicio_renta = inicio_renta;
	}
	
    public Date getFin_renta() {
		return this.inicio_renta;
	}

	public void setFin_renta(Date fin_renta) {
		this.fin_renta = fin_renta;
	}
	
	@Override
    public Object[] toFila() {
        return new Object[]{getIdLetra(), getfoto(), getmodelo(), getmarca(),getanio(),getprecio_dia(),getestado(), ""};
    }
}
