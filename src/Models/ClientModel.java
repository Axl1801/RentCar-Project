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


public class ClientModel {
	
	private int id;
    private String name;
    private String email;
    private String phone;

	public ClientModel(){

	}
	
	 public ClientModel(int id, String name, String email, String phone)
	    {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	    }

	 
	 public ArrayList<ClientModel> get()
	 {
	    	ArrayList<ClientModel> users = new ArrayList<>();
	    	
	    	String query = "SELECT * FROM `Clientes`";
	    	
	    	Connection conn = null; 
			Statement stmt = null;
	 

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
    				
    				tmp.setId(rs.getInt("id"));
    				tmp.setName(rs.getString("name"));
    				tmp.setEmail(rs.getString("email"));
    				tmp.setPhone(rs.getString("phone"));
    				
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

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
}
