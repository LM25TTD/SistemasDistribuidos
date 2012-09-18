package control;

import interfaces.IGerenciadorReservas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.Laboratorio;
import model.Reserva;
import util.Codigos;
import basedados.DataBase;

public class GerenciadorReservas implements IGerenciadorReservas, Serializable {

	private static final long serialVersionUID = -4641105449911966499L;

	public GerenciadorReservas() throws RemoteException {
		super();
	}

	public String criarReserva(String usuarioSolicitante,
			Calendar inicioReserva, Calendar fimReserva, String codLaboratorio)
			throws RemoteException {
		List<Reserva> reservasCadastradas = DataBase.obterTodasReservas();

		for (Reserva reservaBase : reservasCadastradas) {
			if ((reservaBase.getStatusReserva() == Reserva.STATUS_ATIVA)
					&& (reservaBase.getLaboratorioReservado()
							.getCodLaboratorio()
							.equalsIgnoreCase(codLaboratorio))
					&& (reservaBase.getInicioReserva().equals(inicioReserva)
							|| reservaBase.getFimReserva()
									.equals(inicioReserva)
							|| (reservaBase.getInicioReserva().before(
									inicioReserva) && reservaBase
									.getFimReserva().before(inicioReserva))
							|| (reservaBase.getInicioReserva().before(
									fimReserva) && reservaBase.getFimReserva()
									.before(fimReserva))
							|| reservaBase.getInicioReserva()
									.equals(fimReserva) || reservaBase
							.getFimReserva().equals(fimReserva))) {
				return Codigos.RESERVA_JA_EXISTE;
			}
		}

		Laboratorio laboratorioReservado = DataBase
				.obterLaboratorioPorCodigo(codLaboratorio);
		Reserva reserva = new Reserva(usuarioSolicitante, inicioReserva,
				fimReserva, Reserva.STATUS_ATIVA, laboratorioReservado);

		if (DataBase.adicionarReserva(reserva) == Codigos.ADD_SUCESSO)
			return Codigos.RESERVA_SUCESSO;
		else
			return Codigos.RESERVA_ERRO;
	}

	public String cancelarReserva(Integer codReserva) throws RemoteException {
		try {

			Reserva reserva = DataBase.obterReservaPorCodigo(codReserva);
			reserva.setStatusReserva(Reserva.STATUS_CANCELADA);
			Integer statusCancelamento = DataBase.atualizarReserva(reserva);

			if (statusCancelamento == Codigos.ATUALIZAR_SUCESSO)
				return Codigos.CANCEL_RESERVA_SUCESSO;
			else {
				if (statusCancelamento == Codigos.ATUALIZAR_NAO_EXISTE)
					return Codigos.CANCEL_RESERVA_NAO_EXISTE;
				else
					return Codigos.CANCEL_RESERVA_ERRO;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Codigos.CANCEL_RESERVA_ERRO;

		}
	}

	public String obterTodasReservas() throws RemoteException {
		List<Reserva> todasReservas =  DataBase.obterTodasReservas();
		StringBuffer reservasToString = new StringBuffer();
		for (Reserva reserva : todasReservas) {
			reservasToString.append("Código: "+reserva.getCodReserva().toString()+
					"\t Usuário: "+reserva.getUsuarioSolicitante()+
					"\t Início: "+reserva.getInicioReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getInicioReserva().get(Calendar.MONTH)+"/"+reserva.getInicioReserva().get(Calendar.YEAR)+" "+reserva.getInicioReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Fim: "+reserva.getFimReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getFimReserva().get(Calendar.MONTH)+"/"+reserva.getFimReserva().get(Calendar.YEAR)+" "+reserva.getFimReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Laboratório: "+reserva.getLaboratorioReservado().getNomeLaboratorio()+
					"\t Status: "+reserva.statusToText(reserva.getStatusReserva())+"\n");
		}
		
		return reservasToString.toString();
		
	}

	public String obterTodasReservas(String codLaboratorio,
			String nomeLaboratorio) throws RemoteException {
		List<Reserva> todasReservas = DataBase.obterTodasReservas();
		List<Reserva> retorno = new ArrayList<Reserva>();
		for (Reserva reserva : todasReservas) {
			if (reserva.getLaboratorioReservado().getCodLaboratorio()
					.equalsIgnoreCase(codLaboratorio))
				retorno.add(reserva);
		}
		
		StringBuffer reservasToString = new StringBuffer();
		for (Reserva reserva : retorno) {
			reservasToString.append("Código: "+reserva.getCodReserva().toString()+
					"\t Usuário: "+reserva.getUsuarioSolicitante()+
					"\t Início: "+reserva.getInicioReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getInicioReserva().get(Calendar.MONTH)+"/"+reserva.getInicioReserva().get(Calendar.YEAR)+" "+reserva.getInicioReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Fim: "+reserva.getFimReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getFimReserva().get(Calendar.MONTH)+"/"+reserva.getFimReserva().get(Calendar.YEAR)+" "+reserva.getFimReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Laboratório: "+reserva.getLaboratorioReservado().getNomeLaboratorio()+
					"\t Status: "+reserva.statusToText(reserva.getStatusReserva())+"\n");
		}
		
		return reservasToString.toString();		
	}

	public String obterTodasReservas(String usuarioSolicitante)
			throws RemoteException {
		List<Reserva> todasReservas = DataBase.obterTodasReservas();
		List<Reserva> retorno = new ArrayList<Reserva>();
		for (Reserva reserva : todasReservas) {
			if (reserva.getUsuarioSolicitante().equalsIgnoreCase(
					usuarioSolicitante))
				retorno.add(reserva);
		}
		
		StringBuffer reservasToString = new StringBuffer();
		for (Reserva reserva : retorno) {
			reservasToString.append("Código: "+reserva.getCodReserva().toString()+
					"\t Usuário: "+reserva.getUsuarioSolicitante()+
					"\t Início: "+reserva.getInicioReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getInicioReserva().get(Calendar.MONTH)+"/"+reserva.getInicioReserva().get(Calendar.YEAR)+" "+reserva.getInicioReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Fim: "+reserva.getFimReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getFimReserva().get(Calendar.MONTH)+"/"+reserva.getFimReserva().get(Calendar.YEAR)+" "+reserva.getFimReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Laboratório: "+reserva.getLaboratorioReservado().getNomeLaboratorio()+
					"\t Status: "+reserva.statusToText(reserva.getStatusReserva())+"\n");
		}
		
		return reservasToString.toString();
	}

	@Override
	public String obterTodosLaboratorios() throws RemoteException {
		List<Laboratorio> todosLaboratorio =  DataBase.obterTodosLaboratorios();
		
		StringBuffer reservasToString = new StringBuffer();
		for (Laboratorio laboratorio : todosLaboratorio) {
			reservasToString.append("Código: "+laboratorio.getCodLaboratorio()+
					"\t Descrição: "+laboratorio.getNomeLaboratorio()+"\n");
		}
		
		return reservasToString.toString();
	}

	@Override
	public String obterTodasReservas(Calendar data) throws RemoteException {
		List<Reserva> todasReservas = DataBase.obterTodasReservas();
		List<Reserva> retorno = new ArrayList<Reserva>();
		data.set(Calendar.HOUR_OF_DAY,0);
		Calendar tomorrow= new GregorianCalendar();
		tomorrow.set(data.get(Calendar.YEAR), data.get(Calendar.MONTH), data.get(Calendar.DAY_OF_MONTH+1));
		
		
		for (Reserva reserva : todasReservas) {
			if ( (reserva.getInicioReserva().after(data)&&reserva.getFimReserva().before(tomorrow)))
				retorno.add(reserva);
		}
		
		StringBuffer reservasToString = new StringBuffer();
		for (Reserva reserva : retorno) {
			reservasToString.append("Código: "+reserva.getCodReserva().toString()+
					"\t Usuário: "+reserva.getUsuarioSolicitante()+
					"\t Início: "+reserva.getInicioReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getInicioReserva().get(Calendar.MONTH)+"/"+reserva.getInicioReserva().get(Calendar.YEAR)+" "+reserva.getInicioReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Fim: "+reserva.getFimReserva().get(Calendar.DAY_OF_MONTH)+"/"+reserva.getFimReserva().get(Calendar.MONTH)+"/"+reserva.getFimReserva().get(Calendar.YEAR)+" "+reserva.getFimReserva().get(Calendar.HOUR_OF_DAY)+":00"+
					"\t Laboratório: "+reserva.getLaboratorioReservado().getNomeLaboratorio()+
					"\t Status: "+reserva.statusToText(reserva.getStatusReserva())+"\n");
		}
		
		return reservasToString.toString();
		
	}

}
