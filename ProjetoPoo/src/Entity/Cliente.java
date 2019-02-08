package Entity;

public class Cliente {
 private String nomeCliente;
 private int CPFCliente;
 private int TelefoneCliente;
 private String emailCliente;
 
public String getNomeCliente() {
	return nomeCliente;
}
public void setNomeCliente(String nomeCliente) {
	this.nomeCliente = nomeCliente;
}
public int getCPFCliente() {
	return CPFCliente;
}
public void setCPFCliente(int cPFCliente) {
	CPFCliente = cPFCliente;
}
public int getTelefoneCliente() {
	return TelefoneCliente;
}
public void setTelefoneCliente(int telefoneCliente) {
	TelefoneCliente = telefoneCliente;
}
public String getEmailCliente() {
	return emailCliente;
}
public void setEmailCliente(String emailCliente) {
	this.emailCliente = emailCliente;
}
}
