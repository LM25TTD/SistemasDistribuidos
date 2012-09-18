package remote.controller.impl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import remote.controller.IAllocationManager;
import remote.dao.impl.AllocationDao;
import remote.dao.impl.LabDao;
import remote.model.impl.Allocation;
import remote.model.impl.Lab;

public class AllocationManager extends UnicastRemoteObject implements IAllocationManager,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7283788361133955894L;

	public AllocationManager() throws RemoteException {
		super();
	}
	
	private LabDao labDao = new LabDao();
	private AllocationDao allocationDao = new AllocationDao();

	public String createAllocation(Allocation allocation)
			throws RemoteException {
		
		try{
			allocationDao.save(allocation);
			
			return "Reserva Criada com Sucesso!";
		}catch (Exception e) {
			e.printStackTrace();
			return "Erro ao criar reserva!";
		}
		
	}

	public String cancelAllocation(Allocation allocation)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Allocation> getAllocationsFromDate(Date date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Lab> getAllLabs() throws RemoteException {
		return labDao.getAll(Lab.class);
	}
	
	

}
