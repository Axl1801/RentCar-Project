package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientModel {

	public ClientModel(){

	}

	public boolean login(String usuario, String contrasena) {

		String query = "SELECT * FROM users WHERE username = ? AND password = ?";

		System.out.println(query);
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/P3",
					"root",
					""
					);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, usuario.trim());
			ps.setString(2, contrasena.trim());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

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
