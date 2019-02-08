package Control;


import DAO.ProfissionalDAO;
import DAO.ProfissionalDAOImpl;
import Entity.Profissional;


public class ControlProfissional {
	
	public ProfissionalDAO profDAO = new ProfissionalDAOImpl();
	
	public void adicionar(Profissional l) { 
		profDAO.adicionar(l);
	
		
	}
}
