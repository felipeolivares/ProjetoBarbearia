package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Profissional;

public class ProfissionalDAOImpl implements ProfissionalDAO{

	private static String url = 
			"jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";

public ProfissionalDAOImpl() {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	
	@Override
	public void adicionar(Profissional l) {
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO profissional "
					+ " (nome_prof, cpf_prof, tel_prof, email_prof, especializacao_prof, cod_prof) "
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, l.getNomeProfissional());
			stmt.setInt(2, l.getCPFProfissional());
			stmt.setInt(3, l.getTelefoneProfissional());
			stmt.setString(4, l.getEmailProfissional());
			stmt.setString(5, l.getEspecializacaoProfissional());
			stmt.setInt(6, l.getCodProfissional());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
