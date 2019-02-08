package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {
	private static String url = "jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";

	public ProdutoDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void adicionar(Produto l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO produto " + " (cod_reserva_produto, cod_produto, preco_produto, descricao_produto) "
					+ " VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, l.getReservaProduto());
			stmt.setInt(2, l.getCodProduto());
			stmt.setFloat(3, l.getPrecoProduto());
			stmt.setString(4, l.getDescricao());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produto> ler(Produto j) {
		Produto f = new Produto();
		List<Produto> produtos = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String query = "SELECT * FROM produto;";
			
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				f.setReservaProduto(rs.getInt("cod_reserva_produto"));
				f.setCodProduto(rs.getInt("cod_produto"));
				f.setPrecoProduto(rs.getFloat("preco_produto"));
				f.setDescricao(rs.getString("descricao_produto"));
				produtos.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

}
