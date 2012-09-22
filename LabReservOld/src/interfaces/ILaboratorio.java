package interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Reserva;


public interface ILaboratorio extends Remote{
	
	public String getCodLaboratorio() throws RemoteException;
	public void setCodLaboratorio(String codLaboratorio) throws RemoteException;
	public String getNomeLaboratorio() throws RemoteException;
	public void setNomeLaboratorio(String nomeLaboratorio) throws RemoteException;
	public List<Reserva> getReservasLaboratorio() throws RemoteException;
	public void setReservasLaboratorio(List<Reserva> reservasLaboratorio) throws RemoteException;


}
