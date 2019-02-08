package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Login;

public class LoginDAOImpl implements LoginDAO {
	
	private static String url = 
			"jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";

public LoginDAOImpl() {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

	@Override
	public void adicionar(Login l) {
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO login (usuario, senha) VALUES (?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, l.getUsuario());
			stmt.setString(2, l.getSenha());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
