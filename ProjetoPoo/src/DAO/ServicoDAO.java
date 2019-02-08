package DAO;

import java.util.List;

import Entity.Servico;

public interface ServicoDAO {

	void adicionar(Servico l);
	List<Servico> ler(Servico j);
}
