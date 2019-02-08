package DAO;

import java.util.List;

import Entity.Reserva;

public interface ReservaDAO {
	void adicionar(Reserva l);
	void excluir(Reserva r);
	void atualizar(Reserva a);
	List<Reserva> ler(Reserva j);
}
