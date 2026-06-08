package Models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import Utilities.FilaTabla;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

public class RentModel implements FilaTabla{

    private int id_renta;
    private String nameCliente;
    private String nombreModelo;
    private int id_cliente;
    private int id_vehiculo;
    private int id_origen;
    private int id_destino;
    private Date inicio_renta;
    private Date fin_renta;
    private double distancia_recorrida;
    private BigDecimal costo_total;
    private String estado;
	private byte[] foto;


    public RentModel() {
    	
    }

    public RentModel(int id_renta, String name, String nombre, int id_origen, int id_destino, Date inicio_renta, Date fin_renta, double distancia_recorrida, BigDecimal costo_total, String estado){
    	
    	this.id_renta = id_renta;
    	this.nameCliente = name;
    	this.nombreModelo = nombre;
    	this.id_origen = id_origen;
    	this.id_destino = id_destino;
    	this.inicio_renta = inicio_renta;
    	this.fin_renta = fin_renta;
    	this.estado = estado;
    }
    
    
    public ArrayList<RentModel> getinfo() {
    	
        ArrayList<RentModel> rentas = new ArrayList<>();
        
        String query = "SELECT r.*, " +
        				"c.name, " +           
        				"mo.nombre AS modelo_texto, " +
        				"v.foto " +
        				"FROM Rentas r " +
        				"INNER JOIN Clientes c ON r.id_cliente = c.id_cliente " +
        				"INNER JOIN Vehiculos v ON r.id_vehiculo = v.id_vehiculo " +
        				"INNER JOIN Modelos mo ON v.id_modelo = mo.id_modelo";
        
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
                    tmp.setnameCliente(rs.getString("name")); 
                    tmp.setnombreModelo(rs.getString("modelo_texto")); 
                    tmp.setfoto(rs.getBytes("foto"));

                    rentas.add(tmp);
                }
    			
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
        }
        
        return rentas;
    }

    public boolean make(int id_cliente, int id_vehiculo, int id_origen, int id_destino, Date inicio_renta, Date fin_renta, double distancia_recorrida, BigDecimal costo_total, String estado) {

        String query = "INSERT INTO `Rentas` (`id_cliente`, `id_vehiculo`, `id_origen`, `id_destino`, `inicio_renta`, `fin_renta`, `distancia_recorrida`, `costo_total`, `estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
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
        }  		 
		return false;	 
    }
    
    public boolean update(int id_renta, int id_cliente, int id_vehiculo, int id_origen, int id_destino, Date inicio_renta, Date fin_renta, double distancia_recorrida, BigDecimal costo_total, String estado) {

        String query = "UPDATE `Rentas` SET `id_cliente` = ?, `id_vehiculo` = ?, `id_origen` = ?, `id_destino` = ?, `inicio_renta` = ?, `fin_renta` = ?, `distancia_recorrida` = ?, `costo_total` = ?, `estado` = ? WHERE `id_renta` = ?;";
        
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
    		}

    		costoTotal = costoBase.add(costoDistancia);
         
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try { if (conn != null) conn.close(); } catch (Exception e) {}
    	}

    	return costoTotal;
    }
    
    public Map<String, String> getDatosParaPDF(int idRenta) {
        
        Map<String, String> datos = new HashMap<>();
        
        String query = "SELECT r.*, c.name, c.email, c.phone, " +
                "m.nombre AS marca_texto, mo.nombre AS modelo_texto, v.anio, v.precio_dia, v.foto " +
                "FROM Rentas r " +
                "INNER JOIN Clientes c ON r.id_cliente = c.id_cliente " +
                "INNER JOIN Vehiculos v ON r.id_vehiculo = v.id_vehiculo " +
                "INNER JOIN Modelos mo ON v.id_modelo = mo.id_modelo " +
                "INNER JOIN Marcas m ON mo.id_marca = m.id_marca " +
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
                datos.put("name", rs.getString("name"));
                datos.put("email", rs.getString("email"));
                datos.put("phone", rs.getString("phone"));
                
                datos.put("id_vehiculo", String.format("%03d", rs.getInt("id_vehiculo")));
                datos.put("marca", rs.getString("marca_texto"));
                datos.put("modelo", rs.getString("modelo_texto"));
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
            e.printStackTrace();
        }
        
        return datos;
    }
    
    public boolean DisponibilidadVehiculos(int idVehiculo, Date fechaInicioPropuesta, Date fechaFinPropuesta) {
        
    	String query = "SELECT COUNT(*) AS rentas_empalmadas FROM Rentas " +
	               "WHERE id_vehiculo = ? " +
	               "AND inicio_renta <= ? " +
	               "AND fin_renta >= ? " + 
	               "AND estado NOT IN ('Cancelado', 'Finalizado')";
        
    	boolean estaDisponible = true;
    	Properties propiedades = new Properties();

    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
    		String url = propiedades.getProperty("db.url");
    		String user = propiedades.getProperty("db.user");
    		String contra = propiedades.getProperty("db.password");

    		try (Connection conn = DriverManager.getConnection(url, user, contra);
    				PreparedStatement ps = conn.prepareStatement(query)) {
                 
    			ps.setInt(1, idVehiculo);
    			ps.setDate(2, fechaFinPropuesta);
    			ps.setDate(3, fechaInicioPropuesta);

    			try (ResultSet rs = ps.executeQuery()) {
    				if (rs.next()) {
    					int rentasQueChocan = rs.getInt("rentas_empalmadas");
                        
    					if (rentasQueChocan > 0) {
    						estaDisponible = false;
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        
    	return estaDisponible;
    }
    
    public int getVehiculoFisicoDisponible(int id_modelo, Date fechaInicio, Date fechaFin) {
        int idVehiculo = -1;
        
        String query = "SELECT id_vehiculo FROM Vehiculos " +
                       "WHERE id_modelo = ? " +
                       "AND id_vehiculo NOT IN (" +
                       "    SELECT id_vehiculo FROM Rentas " +
                       "    WHERE estado NOT IN ('Cancelado', 'Finalizado') " +
                       "    AND inicio_renta <= ? " +
                       "    AND fin_renta >= ?" +
                       ") LIMIT 1";

        Properties propiedades = new Properties();
        try (InputStream entrada = new FileInputStream("Claves.txt")) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
                 PreparedStatement ps = conn.prepareStatement(query)) {
                 
                ps.setInt(1, id_modelo);
                ps.setDate(2, fechaFin);     
                ps.setDate(3, fechaInicio);     
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // ¡Encontramos uno libre! Atrapamos su ID físico real
                    	idVehiculo = rs.getInt("id_vehiculo");
                    }
                }
            }
        } catch (Exception e) {
        }
        
        return idVehiculo;
    }
    
    public boolean cancelarRenta(int id_renta) {
    	String query = "UPDATE Rentas SET estado = 'Cancelado' WHERE id_renta = ?";
        
    	Properties propiedades = new Properties();

    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
    		String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
            		PreparedStatement ps = conn.prepareStatement(query)) {
                 
            	ps.setInt(1, id_renta);

            	int rowsAffected = ps.executeUpdate();
            	return rowsAffected > 0;
                
            } catch (Exception e) {
            	e.printStackTrace();
            }

    	} catch (IOException e) {
    	}        
    	return false;
    }
    
    public boolean delete(int id_renta) {
        String query = "DELETE FROM Rentas WHERE id_renta = ?";
        
        Properties propiedades = new Properties();

        try (InputStream entrada = new FileInputStream("Claves.txt")) {
        	propiedades.load(entrada);
        	String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
            		PreparedStatement ps = conn.prepareStatement(query)) {
                 
            	ps.setInt(1, id_renta);

            	int rowsAffected = ps.executeUpdate();
            	return rowsAffected > 0;
                
            } catch (Exception e) {
            	e.printStackTrace();
            }
            
        } catch (IOException e) {
        }      
        return false;
    }
    
    private int conteo(String query) {
	
    	int resultado = 0;
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

    			if (rs.next()) {
    		        resultado = rs.getInt(1);
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
		}  		 
		return resultado;	 
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
			 }

		 } catch (Exception e) {
		 }
	         
		 return nombres;
	 }
    
    public ArrayList<String> getNombresSucursales() {
    	ArrayList<String> nombres = new ArrayList<>();
        
    	String query = "SELECT nombre_sucursal FROM Locacion ORDER BY nombre_sucursal ASC";
        
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
                    nombres.add(rs.getString("nombre_sucursal"));
                }
                
            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
        
        return nombres;
    }
    
    public int getIdPorNombre(String nombreSucursal) {
    	int idLocacion = -1;
    	String query = "SELECT id_locacion FROM Locacion WHERE nombre_sucursal = ?";

    	Properties propiedades = new Properties();
    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

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
        }
        return idLocacion;
    }
    
    public ArrayList<String> getNombresClientes() {
    	ArrayList<String> nombres = new ArrayList<>();
        
    	String query = "SELECT name FROM Clientes ORDER BY id_cliente ASC";
        
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
                    nombres.add(rs.getString("name"));
                }
                
            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
        
        return nombres;
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
		 }
		 return idModelo;
	 }
    
    public int getIdPorNombre_Clientes(String nombreCliente) {
        int idCliente = -1; 

        String query = "SELECT id_cliente FROM Clientes WHERE name = ? LIMIT 1";

        Properties propiedades = new Properties();
        try (InputStream entrada = new FileInputStream("Claves.txt")) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
                 PreparedStatement ps = conn.prepareStatement(query)) {
                 
                ps.setString(1, nombreCliente);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idCliente = rs.getInt("id_cliente");
                    }
                }
            }
        } catch (Exception e) {
        }
        return idCliente;
    }
	
    public int numeroVehiculos_total() {
        int total = conteo("SELECT COUNT(*) FROM Vehiculos");
        return total;
    }

    public int numeroVehiculos_renta() {
        int renta = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Rentado'");
        return renta;
    }

    public int numeroVehiculos_dispo() {
        int dispo = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Disponible'");
        return dispo;
    }

    public int numeroVehiculos_manteni() {
        int manteni = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Mantenimiento'");
        return manteni;
    }
    
    public int getIdOrigenPorRenta(int id_renta) {
    	int idOrigen = -1; 
    	String query = "SELECT id_origen FROM Rentas WHERE id_renta = ?";

    	Properties propiedades = new Properties();
    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
    		String url = propiedades.getProperty("db.url");
    		String user = propiedades.getProperty("db.user");
    		String contra = propiedades.getProperty("db.password");

    		try (Connection conn = DriverManager.getConnection(url, user, contra);
    				PreparedStatement ps = conn.prepareStatement(query)) {
                 
    			ps.setInt(1, id_renta);
                
    			try (ResultSet rs = ps.executeQuery()) {
    				if (rs.next()) {
    	                   idOrigen = rs.getInt("id_origen");
    				}
    			}
    		}
    	} catch (Exception e) {
    	}
    	return idOrigen;
    }

    public int getIdDestinoPorRenta(int id_renta) {
    	int idDestino = -1; 
    	String query = "SELECT id_destino FROM Rentas WHERE id_renta = ?";

    	Properties propiedades = new Properties();
    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
    		String url = propiedades.getProperty("db.url");
    		String user = propiedades.getProperty("db.user");
    		String contra = propiedades.getProperty("db.password");

    		try (Connection conn = DriverManager.getConnection(url, user, contra);
    				PreparedStatement ps = conn.prepareStatement(query)) {
                 
    			ps.setInt(1, id_renta);
                
    			try (ResultSet rs = ps.executeQuery()) {
    				if (rs.next()) {
    					idDestino = rs.getInt("id_destino");
                    }
    			}
    		}
    	} catch (Exception e) {
    	}
    	return idDestino;
    }
    
    public int getIdSucursalPorNombre(String nombreSucursal) {
    	int idSucursal = -1;
        
    	String query = "SELECT id_locacion FROM Locacion WHERE nombre_sucursal = ? LIMIT 1";

    	Properties propiedades = new Properties();
    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
    		String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
            		PreparedStatement ps = conn.prepareStatement(query)) {
                 
            	ps.setString(1, nombreSucursal);
                
            	try (ResultSet rs = ps.executeQuery()) {
            		if (rs.next()) {
            			idSucursal = rs.getInt("id_locacion");
            		}
            	}
            }
    	} catch (Exception e) {
    	}
    	return idSucursal;
    }
    
    public Date getFechaInicioRenta(int id_renta) {
    	Date fechaInicio = null; 
    	String query = "SELECT inicio_renta FROM Rentas WHERE id_renta = ?";

    	Properties propiedades = new Properties();
    	try (InputStream entrada = new FileInputStream("Claves.txt")) {
    		propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
            		PreparedStatement ps = conn.prepareStatement(query)) {
                 
            	ps.setInt(1, id_renta);
                
            	try (ResultSet rs = ps.executeQuery()) {
            		if (rs.next()) {
                		fechaInicio = rs.getDate("inicio_renta");
            		}
            	}
            }
    	} catch (Exception e) {
    	}
        return fechaInicio;
    }

    public Date getFechaFinRenta(int id_renta) {
    	Date fechaFin = null; 
    	String query = "SELECT fin_renta FROM Rentas WHERE id_renta = ?";
        
    	Properties propiedades = new Properties();
        try (InputStream entrada = new FileInputStream("Claves.txt")) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, contra);
            		PreparedStatement ps = conn.prepareStatement(query)) {
                 
                ps.setInt(1, id_renta);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        fechaFin = rs.getDate("fin_renta");
                    }
                }
            }
        } catch (Exception e) {
        }
        return fechaFin;
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

    public String getnameCliente() {
    	return nameCliente; 
    }
    
    public void setnameCliente(String nameCliente) {
    	this.nameCliente = nameCliente; 
    }
    
    public String getnombreModelo() {
    	return nombreModelo; 
    }
    
    public void setnombreModelo(String nombreModelo) {
    	this.nombreModelo = nombreModelo; 
    }
	 	
    public byte[] getfoto(){
    	return this.foto;
    }
	
    public void setfoto(byte[] foto){
    	this.foto = foto;
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

    @Override
    public Object[] toFila() {
        return new Object[]{getIdLetra(), getnameCliente(), getId_vehiculo(), getfoto(), getInicio_renta(),getFin_renta(),getEstado(), ""};
    }
}
