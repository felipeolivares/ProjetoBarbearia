package Entity;

import java.util.Date;

public class Secretaria {
	private String nomeSecretaria;
	private int CPFSecretaria;
	private int telSecretaria;
	private String emailSecretaria;
	private Date horarioSecretaria;
	private int codSecretaria;
	
	public int getCodSecretaria() {
		return codSecretaria;
	}
	public void setCodSecretaria(int codSecretaria) {
		this.codSecretaria = codSecretaria;
	}
	public String getNomeSecretaria() {
		return nomeSecretaria;
	}
	public void setNomeSecretaria(String nomeSecretaria) {
		this.nomeSecretaria = nomeSecretaria;
	}
	public int getCPFSecretaria() {
		return CPFSecretaria;
	}
	public void setCPFSecretaria(int cPFSecretaria) {
		CPFSecretaria = cPFSecretaria;
	}
	public int getTelSecretaria() {
		return telSecretaria;
	}
	public void setTelSecretaria(int telSecretaria) {
		this.telSecretaria = telSecretaria;
	}
	public String getEmailSecretaria() {
		return emailSecretaria;
	}
	public void setEmailSecretaria(String emailSecretaria) {
		this.emailSecretaria = emailSecretaria;
	}
	public Date getHorarioSecretaria() {
		return horarioSecretaria;
	}
	public void setHorarioSecretaria(Date horarioSecretaria) {
		this.horarioSecretaria = horarioSecretaria;
	}
	
}
