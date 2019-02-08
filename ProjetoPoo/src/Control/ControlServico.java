package Control;


import java.util.ArrayList;
import java.util.List;

import DAO.ServicoDAO;
import DAO.ServicoDAOImpl;
import Entity.Servico;

public class ControlServico {
	
	public List<Servico> servicos = new ArrayList<>();
	public ServicoDAO serDAO = new ServicoDAOImpl();

	public void adicionar(Servico l) {

		serDAO.adicionar(l);

	}
	
	public List<Servico> ler(Servico j) {
		
		servicos = serDAO.ler(j);
		return servicos;
	}
}
