package remote.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import remote.model.impl.Allocation;
import remote.model.impl.Lab;

public interface IAllocationManager extends Remote{

	public String createAllocation(Allocation allocation) throws RemoteException;
	public String cancelAllocation(Allocation allocation) throws RemoteException ;
	public List<Allocation> getAllocationsFromDate(Date date) throws RemoteException;
	public List<Lab> getAllLabs() throws RemoteException;
	
	
}
