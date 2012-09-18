package control;

import interfaces.IGerenciadorReservas;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Laboratorio;
import model.Reserva;
import util.Codigos;
import basedados.DataBase;

public class GerenciadorReservas extends UnicastRemoteObject implements IGerenciadorReservas {

	
	private static final long serialVersionUID = -4641105449911966499L;

	public GerenciadorReservas() throws RemoteException {
		super();		
	}
	
	public String criarReserva(String usuarioSolicitante, Calendar inicioReserva, Calendar fimReserva, String codLaboratorio) throws RemoteException{
		
		List<Reserva> reservasCadastradas = DataBase.obterTodasReservas();
		
		for (Reserva reservaBase : reservasCadastradas) {
			if ((reservaBase.getStatusReserva()==Reserva.STATUS_ATIVA)&&(reservaBase.getLaboratorioReservado().getCodLaboratorio().equalsIgnoreCase(codLaboratorio))&&(reservaBase.getInicioReserva().equals(inicioReserva)||reservaBase.getFimReserva().equals(inicioReserva) ||(reservaBase.getInicioReserva().before(inicioReserva)&&reservaBase.getFimReserva().before(inicioReserva))
					|| (reservaBase.getInicioReserva().before(fimReserva)&&reservaBase.getFimReserva().before(fimReserva)) ||reservaBase.getInicioReserva().equals(fimReserva)||reservaBase.getFimReserva().equals(fimReserva))){
				return Codigos.RESERVA_JA_EXISTE;
			}
		}
		
		Laboratorio laboratorioReservado = DataBase.obterLaboratorioPorCodigo(codLaboratorio);
		Reserva reserva = new Reserva(usuarioSolicitante, inicioReserva, fimReserva, Reserva.STATUS_ATIVA, laboratorioReservado);
		
		if (DataBase.adicionarReserva(reserva)==Codigos.ADD_SUCESSO)
			return Codigos.RESERVA_SUCESSO;
		else
			return Codigos.RESERVA_ERRO;
	}
	
	public String cancelarReserva(Reserva reserva) throws RemoteException{		
		reserva.setStatusReserva(Reserva.STATUS_CANCELADA);
		Integer statusCancelamento = DataBase.atualizarReserva(reserva);
				
		if (statusCancelamento==Codigos.ATUALIZAR_SUCESSO)
			return Codigos.CANCEL_RESERVA_SUCESSO;
		else{
			if(statusCancelamento==Codigos.ATUALIZAR_NAO_EXISTE)
				return Codigos.CANCEL_RESERVA_NAO_EXISTE;
			else
				return Codigos.CANCEL_RESERVA_ERRO;
		}
	}
	
	public List<Reserva> obterTodasReservas() throws RemoteException{
		return DataBase.obterTodasReservas();
	}
	
	public List<Reserva> obterTodasReservas(String codLaboratorio, String nomeLaboratorio) throws RemoteException{
		List<Reserva> todasReservas=DataBase.obterTodasReservas();
		List<Reserva> retorno = new ArrayList<Reserva>();
		for (Reserva reserva : todasReservas) {
			if (reserva.getLaboratorioReservado().getCodLaboratorio().equalsIgnoreCase(codLaboratorio))
				retorno.add(reserva);
		}		
		return retorno;
	}
	
	public List<Reserva> obterTodasReservas(String usuarioSolicitante) throws RemoteException{
		List<Reserva> todasReservas=DataBase.obterTodasReservas();
		List<Reserva> retorno = new ArrayList<Reserva>();
		for (Reserva reserva : todasReservas) {
			if (reserva.getUsuarioSolicitante().equalsIgnoreCase(usuarioSolicitante))
				retorno.add(reserva);
		}		
		return retorno;
	}
	

}
