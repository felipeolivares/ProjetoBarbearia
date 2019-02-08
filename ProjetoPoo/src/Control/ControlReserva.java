package Control;


import java.util.ArrayList;
import java.util.List;

import DAO.ReservaDAO;
import DAO.ReservaDAOImpl;
import Entity.Reserva;


public class ControlReserva {
	
	public List<Reserva> reservas = new ArrayList<>();
	public ReservaDAO rerDAO = new ReservaDAOImpl();
	
	public void adicionar(Reserva l) {

        rerDAO.adicionar(l);

    }

	public void excluir(Reserva r) {

        rerDAO.excluir(r);

    }

	public void atualizar(Reserva a) {
		
		rerDAO.atualizar(a);

	}

	public List<Reserva> ler(Reserva j) {
		reservas = rerDAO.ler(j);
		return reservas;

	}
	
	
}