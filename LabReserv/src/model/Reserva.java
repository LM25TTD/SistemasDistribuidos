package model;

import interfaces.IReserva;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class Reserva extends UnicastRemoteObject implements IReserva{
	
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

	public Integer getCodReserva() throws RemoteException{
		return codReserva;
	}
	public void setCodReserva(Integer codReserva) throws RemoteException{
		this.codReserva = codReserva;
	}
	public String getUsuarioSolicitante() throws RemoteException{
		return usuarioSolicitante;
	}
	public void setUsuarioSolicitante(String usuarioSolicitante) throws RemoteException{
		this.usuarioSolicitante = usuarioSolicitante;
	}
	public Calendar getInicioReserva() throws RemoteException{
		return inicioReserva;
	}
	public void setInicioReserva(Calendar inicioReserva) throws RemoteException{
		this.inicioReserva = inicioReserva;
	}
	public Calendar getFimReserva() throws RemoteException{
		return fimReserva;
	}
	public void setFimReserva(Calendar fimReserva) throws RemoteException{
		this.fimReserva = fimReserva;
	}
	public Integer getStatusReserva() throws RemoteException{
		return statusReserva;
	}
	public void setStatusReserva(Integer statusReserva) throws RemoteException{
		this.statusReserva = statusReserva;
	}
	public Laboratorio getLaboratorioReservado() throws RemoteException{
		return laboratorioReservado;
	}
	public void setLaboratorioReservado(Laboratorio laboratorioReservado) throws RemoteException{
		this.laboratorioReservado = laboratorioReservado;
	}
	
	

}
