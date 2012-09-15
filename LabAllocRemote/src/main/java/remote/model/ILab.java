package remote.model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import remote.model.impl.Allocation;

public interface ILab extends Remote{
	
	public Integer getIdLab() throws RemoteException;
	public void setIdLab(Integer idLab) throws RemoteException;
	public String getNameLab() throws RemoteException;
	public void setNameLab(String nameLab) throws RemoteException;
	public List<Allocation> getAllocationsFromLab() throws RemoteException;
	public void setAllocationsFromLab(List<Allocation> allocationsFromLab) throws RemoteException;	

}
