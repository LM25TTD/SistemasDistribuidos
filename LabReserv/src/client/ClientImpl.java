package client;

import interfaces.IReserva;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import control.GerenciadorReservas;

public class ClientImpl implements IClient {

	private GerenciadorReservas gerenciador;

	/*
	 * public ClientImpl() { try { gerenciador = (GerenciadorReservas) Naming
	 * .lookup("Gerenciador"); } catch (RemoteException e) {
	 * System.out.println(); System.out.println("RemoteException: " +
	 * e.toString()); } catch (Exception e) { System.out.println();
	 * System.out.println("Exception: " + e.toString()); } }
	 */

	public String criarReserva(String usuarioSolicitante,
			Calendar inicioReserva, Calendar fimReserva, String codLaboratorio)
			throws RemoteException {

		try {
			gerenciador = (GerenciadorReservas) Naming.lookup("Gerenciador");

		} catch (RemoteException e) {
			System.out.println();
			System.out.println("RemoteException: " + e.toString());
		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.criarReserva(usuarioSolicitante, inicioReserva,
				fimReserva, codLaboratorio);
	}

	public String cancelarReserva(IReserva reserva) throws RemoteException {
		try {
			gerenciador = (GerenciadorReservas) Naming.lookup("Gerenciador");

		} catch (RemoteException e) {
			System.out.println();
			System.out.println("RemoteException: " + e.toString());
		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.cancelarReserva(reserva);
	}

	public List obterTodasReservas() throws RemoteException {
		try {
			gerenciador = (GerenciadorReservas) Naming.lookup("Gerenciador");

		} catch (RemoteException e) {
			System.out.println();
			System.out.println("RemoteException: " + e.toString());
		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.obterTodasReservas();
	}

}
