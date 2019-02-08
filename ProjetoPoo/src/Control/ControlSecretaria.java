package Control;

import DAO.SecretariaDAO;
import DAO.SecretariaDAOImpl;
import Entity.Secretaria;


public class ControlSecretaria {
	
	public SecretariaDAO secDAO = new SecretariaDAOImpl();
	
	public void adicionar(Secretaria l) { 

		secDAO.adicionar(l);
		
	}

	
}
