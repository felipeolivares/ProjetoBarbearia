package Control;

import DAO.LoginDAO;
import DAO.LoginDAOImpl;
import Entity.Login;


public class ControlLogin {
	
public LoginDAO logDAO = new LoginDAOImpl();

	
	public void adicionar(Login l) { 
	
			
	logDAO.adicionar(l);
		
	}
}
