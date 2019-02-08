package DAO;

import java.util.List;

import Entity.Produto;

public interface ProdutoDAO {
	
	public void adicionar(Produto l);
	public List<Produto> ler(Produto j);
}
