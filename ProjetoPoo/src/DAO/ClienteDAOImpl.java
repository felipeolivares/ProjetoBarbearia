package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

	private static String url = 
			"jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";
	
	public ClienteDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Cliente l) {
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			String sql = "INSERT INTO cliente "
					+ " (nome_cliente, cpf_cliente, tel_cliente, email_cliente) "
					+ " VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, l.getNomeCliente());
			stmt.setInt(2, l.getCPFCliente());
			stmt.setInt(3, l.getTelefoneCliente());
			stmt.setString(4, l.getEmailCliente());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

}
