package Control;


import DAO.FornecedorDAO;
import DAO.FornecedorDAOImpl;
import Entity.Fornecedor;



public class ControlFornecedor {
	

	public FornecedorDAO fornDAO = new FornecedorDAOImpl();
	

	
	public void adicionar(Fornecedor l) {
		fornDAO.adicionar(l);
	
	}
	
	public Fornecedor pesquisarPorCod(String produtoFornecedor) {
		Fornecedor a = new Fornecedor();
		a = fornDAO.pesquisarPorCod(produtoFornecedor);
		return a;
		
	}
}
