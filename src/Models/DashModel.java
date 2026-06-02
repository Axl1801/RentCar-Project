package Models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

public class DashModel {
	
	int numeroVehiculos_total;
	int numeroVehiculos_renta;
	int numeroVehiculos_dispo;
	int numeroVehiculos_manteni;
	int numeroVehiculos_fuera;
	double total_mes;
	double total_semana;
	double total_mes_pasado;
	double total_mes_pasado_pasado;
	
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
    			conn.close();
    			ps.close();
    			rs.close();
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
	
	private double conteo_dinero(String query) {
		
		double resultado = 0;
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
    			conn.close();
    			ps.close();
    			rs.close();
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

    public int numeroVehiculos_fuera() {
        int fuera = conteo("SELECT COUNT(*) FROM Vehiculos WHERE estado = 'Inactivo'");
        System.out.println("numeroVehiculos_fuera: " + fuera);
        return fuera;
    }

    public Map<Integer, Double> ganancias_semanales_mes_actual() {

    	Map<Integer, Double> reporteSemanas = new HashMap<>();
        
        for (int i = 1; i <= 5; i++) {
            reporteSemanas.put(i, 0.0);
        }

        String query = "SELECT " +
                       "  FLOOR((DAYOFMONTH(inicio_renta) - 1) / 7) + 1 AS semana_del_mes, " +
                       "  SUM(costo_total) AS total_semana " +
                       "FROM Rentas " +
                       "WHERE estado = 'Finalizado' " +
                       "  AND YEAR(inicio_renta) = YEAR(NOW()) " +
                       "  AND MONTH(inicio_renta) = MONTH(NOW()) " +
                       "GROUP BY semana_del_mes " +
                       "ORDER BY semana_del_mes ASC";

        Properties propiedades = new Properties();

        try (InputStream entrada = new FileInputStream("Claves.txt")) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String contra = propiedades.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection(url, user, contra);
                 PreparedStatement ps = conn.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int numSemana = rs.getInt("semana_del_mes");
                    double totalSemana = rs.getDouble("total_semana");
                    
                    reporteSemanas.put(numSemana, totalSemana);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener reporte semanal: " + e.getMessage());
            e.printStackTrace();
        }
        
        return reporteSemanas;
    }
    
    public double ganancia_mes_actual() {
        String query = "SELECT SUM(costo_total) FROM Rentas " +
                       "WHERE estado = 'Finalizado' " +
                       "  AND YEAR(inicio_renta) = YEAR(NOW()) " +
                       "  AND MONTH(inicio_renta) = MONTH(NOW())";
                       
        total_mes = conteo_dinero(query);
        System.out.println("Ganancia del mes actual: $" + total_mes);
        return total_mes;
    }

    public double ganancia_semana_actual() {
        String query = "SELECT SUM(costo_total) FROM Rentas " +
                       "WHERE estado = 'Finalizado' " +
                       "  AND YEAR(inicio_renta) = YEAR(NOW()) " +
                       "  AND WEEK(inicio_renta, 1) = WEEK(NOW(), 1)";
                       
        total_semana = conteo_dinero(query);
        System.out.println("Ganancia de la semana actual: $" + total_semana);
        return total_semana;
    }
    
    public double ganancia_mes_anterior() {
        String query = "SELECT SUM(costo_total) FROM Rentas " +
                       "WHERE estado = 'Finalizado' " +
                       "  AND YEAR(inicio_renta) = YEAR(NOW() - INTERVAL 1 MONTH) " +
                       "  AND MONTH(inicio_renta) = MONTH(NOW() - INTERVAL 1 MONTH)";
                       
        total_mes_pasado = conteo_dinero(query);
        System.out.println("Ganancia del mes anterior: $" + total_mes_pasado);
        return total_mes_pasado;
    }
	
    public double ganancia_mes_anterior_anterior() {
        String query = "SELECT SUM(costo_total) FROM Rentas " +
                       "WHERE estado = 'Finalizado' " +
                       "  AND YEAR(inicio_renta) = YEAR(NOW() - INTERVAL 2 MONTH) " +
                       "  AND MONTH(inicio_renta) = MONTH(NOW() - INTERVAL 2 MONTH)";
                       
        total_mes_pasado_pasado = conteo_dinero(query);
        System.out.println("Ganancia del mes anterior: $" + total_mes_pasado_pasado);
        return total_mes_pasado_pasado;
    }
    
}
