package Control;


import java.util.ArrayList;
import java.util.List;

import DAO.ProdutoDAO;
import DAO.ProdutoDAOImpl;
import Entity.Produto;




public class ControlProduto {
	public List<Produto> produtos = new ArrayList<>();
	public ProdutoDAO prodDAO = new ProdutoDAOImpl();
	
	public void adicionar(Produto l) {

		prodDAO.adicionar(l);

	}
	
	public List<Produto> ler(Produto j) {
		produtos = prodDAO.ler(j);
		return produtos;

	}
}
