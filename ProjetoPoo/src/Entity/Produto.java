package Entity;

public class Produto {
 private int ReservaProduto;
 private int CodProduto;
 private float PrecoProduto;
 private String Descricao;
 
public int getReservaProduto() {
	return ReservaProduto;
}
public void setReservaProduto(int reservaProduto) {
	ReservaProduto = reservaProduto;
}
public int getCodProduto() {
	return CodProduto;
}
public void setCodProduto(int codProduto) {
	CodProduto = codProduto;
}

public float getPrecoProduto() {
	return PrecoProduto;
}
public void setPrecoProduto(float precoProduto) {
	PrecoProduto = precoProduto;
}
public String getDescricao() {
	return Descricao;
}
public void setDescricao(String descricao) {
	Descricao = descricao;
}
 
}
