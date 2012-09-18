package client;

import interfaces.IReserva;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

public interface IClient {
	
	public String criarReserva(String usuarioSolicitante, Calendar inicioReserva, Calendar fimReserva, String codLaboratorio) throws RemoteException;
	public String cancelarReserva(IReserva reserva) throws RemoteException;
	public List obterTodasReservas() throws RemoteException;
	
}
