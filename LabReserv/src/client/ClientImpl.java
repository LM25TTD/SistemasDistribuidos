package client;

import interfaces.IGerenciadorReservas;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Calendar;

public class ClientImpl {
	public ClientImpl() {
		try {
			registry=  LocateRegistry.getRegistry("localhost");
			gerenciador = (IGerenciadorReservas) registry.lookup("Gerenciador");
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
		
		private Registry registry; 
		private IGerenciadorReservas gerenciador;
	
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
			

		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.criarReserva(usuarioSolicitante, inicioReserva,
				fimReserva, codLaboratorio);
	}

	public String cancelarReserva(Integer codReserva) throws RemoteException {
		try {
			

		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.cancelarReserva(codReserva);
	}

	public String obterTodasReservas() throws RemoteException {
		try {
			

		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.obterTodasReservas();
	}
	
	public String obterTodasReservas(Calendar dataBusca) throws RemoteException {
		try {
			

		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception: " + e.toString());
		}
		return gerenciador.obterTodasReservas(dataBusca);
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public IGerenciadorReservas getGerenciador() {
		return gerenciador;
	}

	public void setGerenciador(IGerenciadorReservas gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	

}
