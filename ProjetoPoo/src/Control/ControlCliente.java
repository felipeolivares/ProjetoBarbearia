package Control;

import DAO.ClienteDAO;
import DAO.ClienteDAOImpl;
import Entity.Cliente;

public class ControlCliente {
	
	public ClienteDAO cliDAO = new ClienteDAOImpl();

	public void adicionar(Cliente l) {
		cliDAO.adicionar(l);
	}
}
