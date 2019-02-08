package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Fornecedor;

public class FornecedorDAOImpl implements FornecedorDAO{

	private static String url = 
			"jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";
	
	
	public FornecedorDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Fornecedor l) {
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO fornecedor "
					+ " (cod_produto_fornecedor, cnpj_fornecedor, cod_fornecedor, nome_fornecedor) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, l.getProdutoFornecedor());
			stmt.setInt(2, l.getCnpjFornecedor());
			stmt.setInt(3, l.getCodFornecedor());
			stmt.setString(4, l.getNomeFornecedor());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public Fornecedor pesquisarPorCod(String produtoFornecedor) {
		Fornecedor l = new Fornecedor();
		try {
			Connection con = 
					DriverManager.getConnection(url, user, pass);
			
			String query = "SELECT * FROM fornecedor "
					+ " WHERE cod_produto_fornecedor LIKE ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + produtoFornecedor + "%");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				l.setProdutoFornecedor(rs.getInt("cod_produto_fornecedor"));
				l.setCnpjFornecedor(rs.getInt("cnpj_fornecedor"));
				l.setCodFornecedor(rs.getInt("cod_fornecedor"));
				l.setNomeFornecedor(rs.getString("nome_fornecedor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
