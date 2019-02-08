package DAO;

import Entity.Fornecedor;

public interface FornecedorDAO {
	
	void adicionar(Fornecedor l);
	Fornecedor pesquisarPorCod(String produtoFornecedor);
}
