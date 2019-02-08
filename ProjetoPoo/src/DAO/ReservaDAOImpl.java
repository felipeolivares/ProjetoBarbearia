package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entity.Reserva;

public class ReservaDAOImpl implements ReservaDAO {
	
	private static String url = "jdbc:mariadb://localhost:3306/barbearia?allowMultiQueries=true";
	private static String user = "root";
	private static String pass = "";

	public ReservaDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adicionar(Reserva l) {
		try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO reserva " + " (cpf_cliente_reserva, data_reserva, tipo_reserva, cod_reserva) "
                    + " VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, l.getClienteReserva());
            long timestamp = l.getDataReserva().getTime();
            java.sql.Date sqld = new java.sql.Date( timestamp );
            stmt.setDate(2, sqld); 
            stmt.setString(3, l.getTipoReserva());
            stmt.setInt(4, l.getCodReserva());
            stmt.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro");
        }
		
	}

	@Override
	public void excluir(Reserva r) {
		try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String slq = "DELETE FROM reserva WHERE cpf_cliente_reserva LIKE ?";
            PreparedStatement stmt = con.prepareStatement(slq);

            stmt.setInt(1, r.getClienteReserva());
            stmt.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro");
        }
		
	}

	@Override
	public void atualizar(Reserva a) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String sql = "UPDATE reserva SET cpf_cliente_reserva = ?, data_reserva = ?, tipo_reserva = ?, cod_reserva = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);	
			
			stmt.setInt(1, a.getClienteReserva());
            long timestamp = a.getDataReserva().getTime();
            java.sql.Date sqld = new java.sql.Date( timestamp );
            stmt.setDate(2, sqld); 
            stmt.setString(3, a.getTipoReserva());
            stmt.setInt(4, a.getCodReserva());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro");
		}
		
	}

	@Override
	public List<Reserva> ler(Reserva j) {
		Reserva f = new Reserva();
		List<Reserva> reservas = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String query = "SELECT * FROM reserva;";
			
			PreparedStatement stmt = con.prepareStatement(query);	
			ResultSet rs = stmt.executeQuery();

		 while (rs.next()) {
				f.setClienteReserva(rs.getInt("cpf_cliente_reserva"));
				f.setDataReserva(rs.getDate("data_reserva"));
				f.setTipoReserva(rs.getString("tipo_reserva"));
				f.setCodReserva(rs.getInt("cod_reserva"));
				reservas.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

}
