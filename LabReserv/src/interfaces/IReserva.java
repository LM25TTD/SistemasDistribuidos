package interfaces;



import java.util.Calendar;

import model.Laboratorio;


public interface IReserva{
	
	public Integer getCodReserva() ;
	public void setCodReserva(Integer codReserva) ;
	public String getUsuarioSolicitante() ;
	public void setUsuarioSolicitante(String usuarioSolicitante) ;
	public Calendar getInicioReserva() ;
	public void setInicioReserva(Calendar inicioReserva) ;
	public Calendar getFimReserva() ;
	public void setFimReserva(Calendar fimReserva) ;
	public Integer getStatusReserva() ;
	public void setStatusReserva(Integer statusReserva) ;
	public Laboratorio getLaboratorioReservado() ;
	public void setLaboratorioReservado(Laboratorio laboratorioReservado);
	
	

}
