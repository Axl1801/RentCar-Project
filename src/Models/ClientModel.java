package Models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Utilities.FilaTabla;

import java.sql.Statement;


public class ClientModel implements FilaTabla{
	
	private String Modelo_vehiculo;
	private int id;
    private String name;
    private String email;
    private String phone;
    private int totalRentas;
	private int id_renta;
	private int id_vehiculo;
	private Date inicio_renta;
	private Date fin_renta;

	public ClientModel(){

	}
	
	public ClientModel(int id, String name, String email, String phone){
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	}

	 
	public ArrayList<ClientModel> get()
	{
		ArrayList<ClientModel> users = new ArrayList<>();
	    	
		String query = "SELECT c.id_cliente, c.name, c.email, c.phone, COUNT(r.id_renta) AS total_rentas " +
	               "FROM Clientes c " +
	               "LEFT JOIN Rentas r ON c.id_cliente = r.id_cliente " +
	               "GROUP BY c.id_cliente;";
	    	
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
    				ClientModel tmp = new ClientModel();
    				
    				tmp.setId(rs.getInt("id_cliente"));
    				tmp.setName(rs.getString("name"));
    				tmp.setEmail(rs.getString("email"));
    				tmp.setPhone(rs.getString("phone"));
    				tmp.setTotalRentas(rs.getInt("total_rentas"));
    				
    				users.add(tmp);
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
		return users;  	
	}

	public  boolean make(String email, String name, String phone)
	{
		String query = "INSERT INTO `Clientes` (`name`, `email`, `phone`) VALUES (?, ?, ?);";
			
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
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, phone);
	
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
	 
	public boolean update(int id_cliente, String email, String name, String phone) {
		String query = "UPDATE `Clientes` SET `name` = ?, `email` = ?, `phone` = ? WHERE `id_cliente` = ?;";
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
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, phone);
				ps.setInt(4, id_cliente);

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
	
	private String busqueda(String query, int id_cliente) {
			
			String dato = null;
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
	    			ResultSet rs = ps.executeQuery();
	
	    			if (rs.next()) {
	    				dato = rs.getString(1);
	    		        System.out.println("La info es: " + dato);
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
			return dato;	 
	}
	
	public String nombre_Cliente(int id_cliente) {
        String nombre_Cliente = busqueda("SELECT name FROM Clientes WHERE id_cliente = ?", id_cliente);
        System.out.println("numeroVehiculos_total: " + nombre_Cliente);
        return nombre_Cliente;
    }
	
	public String correo_Cliente(int id_cliente) {
        String correo_Cliente = busqueda("SELECT email FROM Clientes WHERE id_cliente = ?", id_cliente);
        System.out.println("numeroVehiculos_total: " + correo_Cliente);
        return correo_Cliente;
    }
	
	public String telefono_Cliente(int id_cliente) {
        String telefono_Cliente = busqueda("SELECT phone FROM Clientes WHERE id_cliente = ?", id_cliente);
        System.out.println("numeroVehiculos_total: " + telefono_Cliente);
        return telefono_Cliente;
    }
	
	public ClientModel buscarClientePorId(int id_cliente) {
	    
		ClientModel cliente_solo = null;
		String query = "SELECT c.id_cliente, c.name, c.email, c.phone, COUNT(r.id_renta) AS total_rentas " +
				"FROM Clientes c " +
				"LEFT JOIN Rentas r ON c.id_cliente = r.id_cliente " +
				"WHERE c.id_cliente = ? " +
				"GROUP BY c.id_cliente;";
                   
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
				ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cliente_solo = new ClientModel();
           
                cliente_solo.setId(rs.getInt("id_cliente"));
                cliente_solo.setName(rs.getString("name"));
                cliente_solo.setEmail(rs.getString("email"));
                cliente_solo.setPhone(rs.getString("phone"));  
                cliente_solo.setTotalRentas(rs.getInt("total_rentas"));
            }

  	         rs.close();
  	         ps.close();
  	         conn.close();

			} catch (Exception e) {
				System.out.println("Error al buscar el Cliente: " + e.getMessage());
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
		return cliente_solo; 
	}
	
	public boolean checar_renta(int id_cliente) {
	    boolean estaLibre = true; 
	    
	    String query = "SELECT COUNT(*) AS total FROM Rentas WHERE id_cliente = ?";
	    
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
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                int totalRentas = rs.getInt("total");
	                
	                if (totalRentas > 0) {
	                    estaLibre = false;
	                }
	            }

	            rs.close();
	            ps.close();
	            conn.close();

	        } catch (Exception e) {
	           System.out.println("Error al verificar las rentas: " + e.getMessage());
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
	    
	    return estaLibre; 
	}
	
	public boolean eliminarCliente(int id_cliente) {
	    boolean exito = false;
	    String query = "DELETE FROM Clientes WHERE id_cliente = ?";
	    
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
	            
	            int filasAfectadas = ps.executeUpdate();
	            
	            if (filasAfectadas > 0) {
	                exito = true;
	            }

	            ps.close();
	            conn.close();

	        } catch (Exception e) {
	           System.out.println("Error al intentar borrar el cliente: " + e.getMessage());
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
	    
	    return exito; 
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
    
    public ClientModel (int id_renta, String Modelo_vehiculo, Date inicio_renta, Date fin_renta){
    	
    	this. id_renta = id_renta;
    	this. Modelo_vehiculo = Modelo_vehiculo;
    	this. inicio_renta = inicio_renta;
    	this. fin_renta = fin_renta;
    }
    
    public ArrayList<ClientModel> getinfo(int id_cliente) {
    	
    	ArrayList<ClientModel> rentas = new ArrayList<>();
        
    	String query = "SELECT r.id_renta, m.nombre AS nombre, r.inicio_renta, r.fin_renta " +
                "FROM Rentas r " +
                "INNER JOIN Vehiculos v ON r.id_vehiculo = v.id_vehiculo " +
                "INNER JOIN Modelos m ON v.id_modelo = m.id_modelo " +
                "WHERE r.id_cliente = ?";
        
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
    			ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                	ClientModel tmp = new ClientModel();

                	tmp.setId_renta(rs.getInt("id_renta"));
                	tmp.setModelo_vehiculo(rs.getString("nombre"));                
                    tmp.setInicio_renta(rs.getDate("inicio_renta"));
                    tmp.setFin_renta(rs.getDate("fin_renta"));
<<<<<<< Updated upstream
                    System.out.println("Add CTE");
=======
>>>>>>> Stashed changes
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

	 
    public int getId_renta() {
        return this.id_renta;
    }

    public void setId_renta(int id_renta) { 
        this.id_renta = id_renta;
    }
	
    public String getModelo_vehiculo() {
		return this.Modelo_vehiculo;
	}

	public void setModelo_vehiculo(String Modelo_vehiculo) {
		this.Modelo_vehiculo = Modelo_vehiculo;
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
    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public String getIdLetra() {
		return String.format("C-%03d", this.id);
	}
	
	public String getIdLetraRenta() {
		return String.format("R-%03d", this.id_renta);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	public int getTotalRentas() {
		return totalRentas;
	}
	
	public void setTotalRentas(int totalRentas) {
		this.totalRentas = totalRentas;
	}
	
    @Override
    public Object[] toFila() {
        return new Object[]{getIdLetra(), getName(), getEmail(), getPhone(), getTotalRentas(), ""};
    }
}
