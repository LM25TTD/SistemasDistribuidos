package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import model.Reserva;

@SuppressWarnings("rawtypes")
public interface IGerenciadorReservas extends Remote {
	
	public String criarReserva(String usuarioSolicitante, Calendar inicioReserva, Calendar fimReserva, String codLaboratorio) throws RemoteException;
	public String cancelarReserva(Reserva reserva) throws RemoteException;
	public List obterTodasReservas() throws RemoteException;
	public List obterTodasReservas(String codLaboratorio, String nomeLaboratorio) throws RemoteException;
	public List obterTodasReservas(String usuarioSolicitante) throws RemoteException;
	
}
