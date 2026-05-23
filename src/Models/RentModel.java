package Models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Date;

public class RentModel {

    private int id_renta;
    private int id_cliente;
    private int id_vehiculo;
    private int id_origen;
    private int id_destino;
    private Date inicio_renta;
    private Date fin_renta;
    private double distancia_recorrida;
    private BigDecimal costo_total;
    private String estado;

    public RentModel() {
    	
    }

    public RentModel(int id_renta, int id_cliente, int id_vehiculo, int id_origen, int id_destino, Date inicio_renta, Date fin_renta, double distancia_recorrida, BigDecimal costo_total, String estado){
    	
    	this. id_renta = id_renta;
    	this. id_cliente = id_cliente;
    	this. id_vehiculo = id_vehiculo;
    	this. id_origen = id_origen;
    	this. id_destino = id_destino;
    	this. inicio_renta = inicio_renta;
    	this. fin_renta = fin_renta;
    	this. distancia_recorrida = distancia_recorrida;
    	this. costo_total = costo_total;
    	this. estado = estado;
    }
    
    
    public ArrayList<RentModel> getinfo() {
    	
        ArrayList<RentModel> rentas = new ArrayList<>();
        
        String query = "SELECT * FROM `Rentas`";
        
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

                while (rs.next()) {
                    RentModel tmp = new RentModel();

                    tmp.setId_renta(rs.getInt("id_renta"));
                    tmp.setId_cliente(rs.getInt("id_cliente"));
                    tmp.setId_vehiculo(rs.getInt("id_vehiculo"));
                    tmp.setId_origen(rs.getInt("id_origen"));
                    tmp.setId_destino(rs.getInt("id_destino"));
                    tmp.setInicio_renta(rs.getDate("inicio_renta"));
                    tmp.setFin_renta(rs.getDate("fin_renta"));
                    tmp.setDistancia_recorrida(rs.getDouble("distancia_recorrida"));
                    tmp.setCosto_total(rs.getBigDecimal("costo_total"));
                    tmp.setEstado(rs.getString("estado"));

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

    public boolean make(int id_cliente, int id_vehiculo, int id_origen, int id_destino, Date inicio_renta, Date fin_renta, double distancia_recorrida, BigDecimal costo_total, String estado) {

        String query = "INSERT INTO `Rentas` (`id_cliente`, `id_vehiculo`, `id_origen`, `id_destino`, `inicio_renta`, `fin_renta`, `distancia_recorrida`, `costo_total`, `estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
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

                ps.setInt(1, id_cliente);
                ps.setInt(2, id_vehiculo);
                ps.setInt(3, id_origen);
                ps.setInt(4, id_destino);
                ps.setDate(5, inicio_renta);
                ps.setDate(6, fin_renta);
                ps.setDouble(7, distancia_recorrida);
                ps.setBigDecimal(8, costo_total);
                ps.setString(9, estado);

                int rowsAffected = ps.executeUpdate();
                ps.close();
                conn.close();
                return rowsAffected > 0;
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
    public boolean update(int id_renta, int id_cliente, int id_vehiculo, int id_origen, int id_destino, Date inicio_renta, Date fin_renta, double distancia_recorrida, BigDecimal costo_total, String estado) {

        String query = "UPDATE `Rentas` SET `id_cliente` = ?, `id_vehiculo` = ?, `id_origen` = ?, `id_destino` = ?, `inicio_renta` = ?, `fin_renta` = ?, `distancia_recorrida` = ?, `costo_total` = ?, `estado` = ? WHERE `id_renta` = ?;";
        
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

                ps.setInt(1, id_cliente);
                ps.setInt(2, id_vehiculo);
                ps.setInt(3, id_origen);
                ps.setInt(4, id_destino);
                ps.setDate(5, inicio_renta);
                ps.setDate(6, fin_renta);
                ps.setDouble(7, distancia_recorrida);
                ps.setBigDecimal(8, costo_total);
                ps.setString(9, estado);
                ps.setInt(10, id_renta);

                int rowsAffected = ps.executeUpdate();
                ps.close();
                conn.close();
                return rowsAffected > 0;
                
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

    public int getId_renta() { 
    	return id_renta; 
    	}
    
    public void setId_renta(int id_renta) {
    	this.id_renta = id_renta; 
    	}

    public String getIdLetra() {
        return String.format("R-%03d", this.id_renta);
        }

    public int getId_cliente() {
    	return id_cliente; 
    	}
    
    public void setId_cliente(int id_cliente) {
    	this.id_cliente = id_cliente; 
    	}

    public int getId_vehiculo() {
    	return id_vehiculo; 
    	}
    
    public void setId_vehiculo(int id_vehiculo) {
    	this.id_vehiculo = id_vehiculo; 
    	}

    public int getId_origen() {
    	return id_origen; 
    	}
    
    public void setId_origen(int id_origen) {
    	this.id_origen = id_origen; 
    	}

    public int getId_destino() {
    	return id_destino; 
    	}
    
    public void setId_destino(int id_destino) {
    	this.id_destino = id_destino; 
    	}

    public Date getInicio_renta() {
    	return inicio_renta; 
    	}
    
    public void setInicio_renta(Date inicio_renta) {
    	this.inicio_renta = inicio_renta; 
    	}

    public Date getFin_renta() {
    	return fin_renta; 
    	}
    public void setFin_renta(Date fin_renta) {
    	this.fin_renta = fin_renta; 
    	}

    public double getDistancia_recorrida() {
    	return distancia_recorrida; 
    	}
    
    public void setDistancia_recorrida(double distancia_recorrida) {
    	this.distancia_recorrida = distancia_recorrida; 
    	}

    public BigDecimal getCosto_total() {
    	return costo_total; 
    	}
    
    public void setCosto_total(BigDecimal costo_total) {
    	this.costo_total = costo_total; 
    	}

    public String getEstado() {
    	return estado; 
    	}
    
    public void setEstado(String estado) {
    	this.estado = estado; 
    	}
}
