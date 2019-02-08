package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Secretaria;

public class SecretariaDAOImpl implements SecretariaDAO {

	private static String url = 
			"jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";

public SecretariaDAOImpl() {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	
	@Override
	public void adicionar(Secretaria l) {
		
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO secretaria "
					+ " (nome_secretaria, cpf_secretaria, telefone_secretaria, email_secretaria, horario, cod_secretaria) "
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, l.getNomeSecretaria());
			stmt.setInt(2, l.getCPFSecretaria());
			stmt.setInt(3, l.getTelSecretaria());
			stmt.setString(4, l.getEmailSecretaria());
			long timestamp = l.getHorarioSecretaria().getTime();  
			java.sql.Date sqld = new java.sql.Date( timestamp );
			stmt.setDate(5, sqld); 
			stmt.setInt(6, l.getCodSecretaria());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
