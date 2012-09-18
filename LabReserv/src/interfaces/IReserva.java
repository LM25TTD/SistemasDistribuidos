package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

import model.Laboratorio;

public interface IReserva extends Remote{
	
	public Integer getCodReserva() throws RemoteException;
	public void setCodReserva(Integer codReserva) throws RemoteException;
	public String getUsuarioSolicitante() throws RemoteException;
	public void setUsuarioSolicitante(String usuarioSolicitante) throws RemoteException;
	public Calendar getInicioReserva() throws RemoteException;
	public void setInicioReserva(Calendar inicioReserva) throws RemoteException;
	public Calendar getFimReserva() throws RemoteException;
	public void setFimReserva(Calendar fimReserva) throws RemoteException;
	public Integer getStatusReserva() throws RemoteException;
	public void setStatusReserva(Integer statusReserva) throws RemoteException;
	public Laboratorio getLaboratorioReservado() throws RemoteException;
	public void setLaboratorioReservado(Laboratorio laboratorioReservado) throws RemoteException;
	
	

}
