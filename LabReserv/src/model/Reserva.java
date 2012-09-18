package model;




import interfaces.IReserva;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Calendar;

public class Reserva implements IReserva,Serializable{
	
	private static final long serialVersionUID = -4503462265541015065L;
	public static final Integer STATUS_ATIVA=1;
	public static final Integer STATUS_CANCELADA=2;
	
	public String statusToText(Integer status){
		switch (status) {
		case 1: return "Ativa";
		case 2: return "Cancelada";
		default: return "N/A";
		}
	}
	
	public Reserva() throws RemoteException {super();}
	
	public Reserva(String usuarioSolicitante, Calendar inicioReserva, Calendar fimReserva, Integer statusReserva, Laboratorio laboratorioReservado) throws RemoteException {
		super();
		this.usuarioSolicitante=usuarioSolicitante;
		this.inicioReserva=inicioReserva;
		this.fimReserva=fimReserva;
		this.statusReserva=statusReserva;
		this.laboratorioReservado=laboratorioReservado;
	}
	
	private Integer codReserva;
	private String usuarioSolicitante;
	private Calendar inicioReserva;
	private Calendar fimReserva;
	private Integer statusReserva;
	private Laboratorio laboratorioReservado;

	public Integer getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(Integer codReserva) {
		this.codReserva = codReserva;
	}
	public String getUsuarioSolicitante(){
		return usuarioSolicitante;
	}
	public void setUsuarioSolicitante(String usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}
	public Calendar getInicioReserva() {
		return inicioReserva;
	}
	public void setInicioReserva(Calendar inicioReserva) {
		this.inicioReserva = inicioReserva;
	}
	public Calendar getFimReserva() {
		return fimReserva;
	}
	public void setFimReserva(Calendar fimReserva) {
		this.fimReserva = fimReserva;
	}
	public Integer getStatusReserva() {
		return statusReserva;
	}
	public void setStatusReserva(Integer statusReserva) {
		this.statusReserva = statusReserva;
	}
	public Laboratorio getLaboratorioReservado(){
		return laboratorioReservado;
	}
	public void setLaboratorioReservado(Laboratorio laboratorioReservado){
		this.laboratorioReservado = laboratorioReservado;
	}
	
	

}
