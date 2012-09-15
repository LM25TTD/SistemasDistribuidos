package remote.model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import remote.model.impl.Lab;

public interface IAllocation extends Remote{
	
	public Integer getIdAllocation() throws RemoteException;
	public void setIdAllocation(Integer idAllocation) throws RemoteException;
	public String getAllocationOwner() throws RemoteException;
	public void setAllocationOwner(String allocationOwner) throws RemoteException;
	public Date getStartTime() throws RemoteException;
	public void setStartTime(Date startTime) throws RemoteException;
	public Date getEndTime() throws RemoteException;
	public void setEndTime(Date endTime) throws RemoteException;
	public Integer getStatus() throws RemoteException;
	public void setStatus(Integer status) throws RemoteException;
	public Lab getLabAllocated() throws RemoteException;
	public void setLabAllocated(Lab labAllocated) throws RemoteException;


}
