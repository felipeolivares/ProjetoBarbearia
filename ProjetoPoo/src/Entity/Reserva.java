package Entity;

import java.util.Date;

public class Reserva {
	private int clienteReserva;
	private Date dataReserva;
	private String tipoReserva;
	private int codReserva;
	
	public int getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}
	public int getClienteReserva() {
		return clienteReserva;
	}
	public void setClienteReserva(int clienteReserva) {
		this.clienteReserva = clienteReserva;
	}
	public Date getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	public String getTipoReserva() {
		return tipoReserva;
	}
	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}
	
}
