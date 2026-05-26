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
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

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

    public BigDecimal calcularCostoTotal(int id_vehiculo, int id_origen, int id_destino, Date inicio_renta, Date fin_renta) {
    	BigDecimal costoTotal = BigDecimal.ZERO;
    	Connection conn = null;
    	Properties propiedades = new Properties();

    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
    		String url = propiedades.getProperty("db.url");
    		String user = propiedades.getProperty("db.user");
    		String contra = propiedades.getProperty("db.password");

    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(url, user, contra);

    		long diffEnMilisegundos = Math.abs(fin_renta.getTime() - inicio_renta.getTime());
    		long dias = TimeUnit.DAYS.convert(diffEnMilisegundos, TimeUnit.MILLISECONDS);
         
    		if (dias == 0) dias = 1; 

    		BigDecimal precioPorDia = BigDecimal.ZERO;
    		String queryVehiculo = "SELECT precio_dia FROM Vehiculos WHERE id_vehiculo = ?";
    		try (PreparedStatement psVehiculo = conn.prepareStatement(queryVehiculo)) {
    			psVehiculo.setInt(1, id_vehiculo);
    			try (ResultSet rsVehiculo = psVehiculo.executeQuery()) {
    				if (rsVehiculo.next()) {
    					precioPorDia = rsVehiculo.getBigDecimal("precio_dia");
    				}
    			}
    		}

    		BigDecimal costoBase = precioPorDia.multiply(BigDecimal.valueOf(dias));
    		BigDecimal costoDistancia = BigDecimal.ZERO;

    		if (id_origen != id_destino) {
    			double distanciaKm = 0.0;
    			String queryRuta = "SELECT SUM(weight) FROM motor_rutas WHERE latch = 'dijkstra' AND origid = ? AND destid = ?";
             
    			try (PreparedStatement psRuta = conn.prepareStatement(queryRuta)) {
    				psRuta.setInt(1, id_origen);
    				psRuta.setInt(2, id_destino);
    				try (ResultSet rsRuta = psRuta.executeQuery()) {
    					if (rsRuta.next()) {
    						distanciaKm = rsRuta.getDouble(1);
    					}
    				}
    			}
    			this.distancia_recorrida = distanciaKm;
    			costoDistancia = BigDecimal.valueOf(distanciaKm * 3.0);
    			System.out.println("Distancia: " + distanciaKm + "Cargo: " + costoDistancia);
    		}

    		costoTotal = costoBase.add(costoDistancia);
    		System.out.println("Costo Base: " + costoBase + " Cargo Distancia: " + costoDistancia + " Total: " + costoTotal);
         
    	} catch (Exception e) {
    		System.out.println("Error al calcular el costo total: " + e.getMessage());
    		e.printStackTrace();
    	} finally {
    		try { if (conn != null) conn.close(); } catch (Exception e) {}
    	}

    	return costoTotal;
    }
    
    public Map<String, String> getDatosParaPDF(int idRenta) {
        
        Map<String, String> datos = new HashMap<>();
        
        String query = "SELECT r.*, c.nombre, c.correo, c.telefono, " +
                       "v.marca, v.modelo, v.anio, v.precio_dia, v.foto " +
                       "FROM Rentas r " +
                       "INNER JOIN Clientes c ON r.id_cliente = c.id_cliente " +
                       "INNER JOIN Vehiculos v ON r.id_vehiculo = v.id_vehiculo " +
                       "WHERE r.id_renta = ?";

        Connection conn = null;
        Properties propiedades = new Properties();

        try (InputStream entrada = new FileInputStream("Claves.txt")) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, contra);

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idRenta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                datos.put("id_renta", String.format("%03d", rs.getInt("id_renta"))); 
                datos.put("fecha_inicio", rs.getDate("inicio_renta").toString());
                datos.put("fecha_fin", rs.getDate("fin_renta").toString());
                datos.put("estado", rs.getString("estado"));
                
                datos.put("id_cliente", String.format("%03d", rs.getInt("id_cliente")));
                datos.put("name", rs.getString("nombre"));
                datos.put("email", rs.getString("correo"));
                datos.put("phone", rs.getString("telefono"));
                
                datos.put("id_vehiculo", String.format("%03d", rs.getInt("id_vehiculo")));
                datos.put("marca", rs.getString("marca"));
                datos.put("modelo", rs.getString("modelo"));
                datos.put("anio", rs.getString("anio"));
                datos.put("precio_dia", rs.getBigDecimal("precio_dia").toString());
                
                byte[] fotoBytes = rs.getBytes("foto");
                if (fotoBytes != null) {
                    String fotoBase64 = Base64.getEncoder().encodeToString(fotoBytes);
                    datos.put("foto_vehiculo", fotoBase64);
                } else {
                    datos.put("foto_vehiculo", "");
                }

                double distancia = rs.getDouble("distancia_recorrida");
                double costoExtra = distancia * 3.0;
                BigDecimal total = rs.getBigDecimal("costo_total");
                BigDecimal costoBase = total.subtract(BigDecimal.valueOf(costoExtra));

                datos.put("distancia", String.valueOf(distancia));
                datos.put("costo_distancia", String.format("%.2f", costoExtra));
                datos.put("costo_base", costoBase.toString());
                datos.put("total_final", total.toString());
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al buscar datos del ticket: " + e.getMessage());
            e.printStackTrace();
        }
        
        return datos;
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
