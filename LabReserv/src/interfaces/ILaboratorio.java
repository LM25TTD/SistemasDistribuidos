package interfaces;


import java.util.List;

import model.Reserva;


public interface ILaboratorio{
	
	public String getCodLaboratorio();
	public void setCodLaboratorio(String codLaboratorio) ;
	public String getNomeLaboratorio() ;
	public void setNomeLaboratorio(String nomeLaboratorio) ;
	public List<Reserva> getReservasLaboratorio() ;
	public void setReservasLaboratorio(List<Reserva> reservasLaboratorio) ;


}
