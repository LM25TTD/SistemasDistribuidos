package interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;


public interface IGerenciadorReservas extends Remote {
	
	public String criarReserva(String usuarioSolicitante, Calendar inicioReserva, Calendar fimReserva, String codLaboratorio) throws RemoteException;
	public String cancelarReserva(Integer codReserva) throws RemoteException;
	public String obterTodasReservas() throws RemoteException;
	public String obterTodasReservas(String codLaboratorio, String nomeLaboratorio) throws RemoteException;
	public String obterTodasReservas(String usuarioSolicitante) throws RemoteException;
	public String obterTodasReservas(Calendar data) throws RemoteException;
	public String obterTodosLaboratorios() throws RemoteException;
	
	
}
