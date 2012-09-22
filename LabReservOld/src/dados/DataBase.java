package dados;



import interfaces.ILaboratorio;
import interfaces.IReserva;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Laboratorio;
import model.Reserva;

import util.Codigos;



public class DataBase {

	private static Map<String, Laboratorio> laboratoriosCadastrados;
	private static Map<Integer, Reserva> reservasCadastradas;
	private static Integer indiceReserva;
	
	static{
		laboratoriosCadastrados = new HashMap<String, Laboratorio>();
		reservasCadastradas = new HashMap<Integer, Reserva>();
		indiceReserva=0;
		try{
			laboratoriosCadastrados.put("Lab001", new Laboratorio("Lab001", "Laboratório de Química"));
			laboratoriosCadastrados.put("Lab002", new Laboratorio("Lab002", "Laboratório de Física"));
			laboratoriosCadastrados.put("Lab003", new Laboratorio("Lab003", "Laboratório de Computação 1"));
			laboratoriosCadastrados.put("Lab004", new Laboratorio("Lab004", "Laboratório de Computação 2"));
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer adicionarLaboratorio (Laboratorio laboratorio){
		try{
			if (!laboratoriosCadastrados.containsKey(laboratorio.getCodLaboratorio())){
				laboratoriosCadastrados.put(laboratorio.getCodLaboratorio(), laboratorio);
				return Codigos.ADD_SUCESSO;
			}else{
				return Codigos.ADD_JA_EXISTE;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Codigos.ADD_ERRO;
		}
	}
	
	public static Integer removerLaboratorio (Laboratorio laboratorio){
		try{			
			if (laboratoriosCadastrados.containsKey(laboratorio.getCodLaboratorio())){
				laboratoriosCadastrados.remove(laboratorio.getCodLaboratorio());
				return Codigos.REMOVER_SUCESSO;
			}else{
				return Codigos.REMOVER_NAO_EXISTE;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Codigos.REMOVER_ERRO;
		}
	}
	
	public static Integer atualizarLaboratorio (Laboratorio laboratorio){
		try{			
			if (laboratoriosCadastrados.containsKey(laboratorio.getCodLaboratorio())){
				laboratoriosCadastrados.remove(laboratorio.getCodLaboratorio());
				laboratoriosCadastrados.put(laboratorio.getCodLaboratorio(), laboratorio);
				return Codigos.ATUALIZAR_SUCESSO;
			}else{
				return Codigos.ATUALIZAR_NAO_EXISTE;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Codigos.ATUALIZAR_ERRO;
		}
	}
	
	public static Laboratorio obterLaboratorioPorCodigo(String codLaboratorio){
		try{			
			return laboratoriosCadastrados.get(codLaboratorio);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<ILaboratorio> obterTodosLaboratorios(){
		try{			
			return new ArrayList<ILaboratorio>(laboratoriosCadastrados.values()) ;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static Integer adicionarReserva (Reserva reserva){
		try{
			indiceReserva++;
			reserva.setCodReserva(indiceReserva);
			if (!reservasCadastradas.containsKey(reserva.getCodReserva())){
				reservasCadastradas.put(reserva.getCodReserva(), reserva);
				return Codigos.ADD_SUCESSO;
			}else{
				return Codigos.ADD_JA_EXISTE;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Codigos.ADD_ERRO;
		}
	}
	
	public static Integer removerReserva (Reserva reserva){
		try{			
			if (reservasCadastradas.containsKey(reserva.getCodReserva())){
				reservasCadastradas.remove(reserva.getCodReserva());
				return Codigos.REMOVER_SUCESSO;
			}else{
				return Codigos.REMOVER_NAO_EXISTE;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Codigos.REMOVER_ERRO;
		}
	}
	
	public static Integer atualizarReserva (IReserva reserva){
		try{			
			if (reservasCadastradas.containsKey(reserva.getCodReserva())){
				reservasCadastradas.remove(reserva.getCodReserva());
				reservasCadastradas.put(reserva.getCodReserva(), (Reserva)reserva);
				return Codigos.ATUALIZAR_SUCESSO;
			}else{
				return Codigos.ATUALIZAR_NAO_EXISTE;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Codigos.ATUALIZAR_ERRO;
		}
	}
	
	public static Reserva obterReservaPorCodigo(Integer codReserva){
		try{			
			return reservasCadastradas.get(codReserva);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Reserva> obterTodasReservas(){
		try{			
			return new ArrayList<Reserva>(reservasCadastradas.values()) ;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, Laboratorio> getLaboratoriosCadastrados() {
		return laboratoriosCadastrados;
	}

	public static void setLaboratoriosCadastrados(
			Map<String, Laboratorio> laboratoriosCadastrados) {
		DataBase.laboratoriosCadastrados = laboratoriosCadastrados;
	}

	public static Map<Integer, Reserva> getReservasCadastradas() {
		return reservasCadastradas;
	}

	public static void setReservasCadastradas(
			Map<Integer, Reserva> reservasCadastradas) {
		DataBase.reservasCadastradas = reservasCadastradas;
	}
	
	
	
}
