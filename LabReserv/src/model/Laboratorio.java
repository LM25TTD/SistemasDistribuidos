package model;



import interfaces.ILaboratorio;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public class Laboratorio  implements ILaboratorio,Serializable {
	
	
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
	
	public String getCodLaboratorio() {
		return codLaboratorio;
	}
	public void setCodLaboratorio(String codLaboratorio) {
		this.codLaboratorio = codLaboratorio;
	}
	
	public String getNomeLaboratorio()  {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio)  {
		this.nomeLaboratorio = nomeLaboratorio;
	}

	public List<Reserva> getReservasLaboratorio()  {
		return reservasLaboratorio;
	}
	public void setReservasLaboratorio(List<Reserva> reservasLaboratorio)  {
		this.reservasLaboratorio = reservasLaboratorio;
	}
	
	

}
