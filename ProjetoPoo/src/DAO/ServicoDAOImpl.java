package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Servico;

public class ServicoDAOImpl implements ServicoDAO{

	private static String url = "jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";

	public ServicoDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Servico l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO servico " + " (cod_reserva_servico, cod_servico, preco_servico, tipo_servico) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, l.getReservaServico());
			stmt.setInt(2, l.getCodServico());
			stmt.setFloat(3, l.getPrecoServico());
			stmt.setString(4, l.getTipoServico());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Servico> ler(Servico j) {
		Servico f = new Servico();
		List<Servico> servicos = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM servico;";
			
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				f.setReservaServico(rs.getInt("cod_reserva_servico"));
				f.setCodServico(rs.getInt("cod_servico"));
				f.setPrecoServico(rs.getFloat("preco_servico"));
				f.setTipoServico(rs.getString("tipo_servico"));
				servicos.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicos;
	}

}
