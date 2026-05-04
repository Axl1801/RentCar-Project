package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AuthModel {
	public AuthModel(){
		
	}
	
	public boolean login(String user, String password) {
		
		String query = "SELECT * FROM agente WHERE usuario = ? AND contrasena = ?";
		
		System.out.println(query);
		
		Connection conn = null;
		
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/rentcar_project",
					"pagrent",
					"ContraPagRentJava"
					);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.trim());
			ps.setString(2, password.trim());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				rs.close();
				ps.close();
				conn.close();
				
				return true;
			}  
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {}
		}
		
		return false;
	}

}
