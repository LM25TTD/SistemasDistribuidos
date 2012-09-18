package model;

import interfaces.ILaboratorio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio extends UnicastRemoteObject  implements ILaboratorio {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1998862203202692724L;
	private String codLaboratorio;
	private String nomeLaboratorio;
	private List<Reserva> reservasLaboratorio;
	
	public Laboratorio() throws RemoteException {
		super();
		reservasLaboratorio=new ArrayList<Reserva>();
		
	}
	
	public Laboratorio(String codLaboratorio, String nomeLaboratorio) throws RemoteException {
		super();
		this.codLaboratorio=codLaboratorio;
		this.nomeLaboratorio=nomeLaboratorio;
		this.reservasLaboratorio=new ArrayList<Reserva>();
	}
	
	public Laboratorio(String codLaboratorio, String nomeLaboratorio, List<Reserva> reservasLaboratorio) throws RemoteException {
		super();
		this.codLaboratorio=codLaboratorio;
		this.nomeLaboratorio=nomeLaboratorio;
		this.reservasLaboratorio=reservasLaboratorio;
	}
	
	public String getCodLaboratorio() throws RemoteException {
		return codLaboratorio;
	}
	public void setCodLaboratorio(String codLaboratorio) throws RemoteException {
		this.codLaboratorio = codLaboratorio;
	}
	
	public String getNomeLaboratorio() throws RemoteException {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) throws RemoteException {
		this.nomeLaboratorio = nomeLaboratorio;
	}

	public List<Reserva> getReservasLaboratorio() throws RemoteException {
		return reservasLaboratorio;
	}
	public void setReservasLaboratorio(List<Reserva> reservasLaboratorio) throws RemoteException {
		this.reservasLaboratorio = reservasLaboratorio;
	}
	
	

}
