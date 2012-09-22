package remote.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remote.controller.IAllocationManager;
import remote.controller.impl.AllocationManager;

public class Startup {
	
	public static void main(String[] args) {
		  try {  
			  	
			  	AllocationManager allocationController = new AllocationManager();
			  	IAllocationManager allocationStub = (IAllocationManager) UnicastRemoteObject.exportObject(allocationController,0);
			  	
			  	Registry registry = LocateRegistry.getRegistry();
			  	registry.rebind("Gerenciador", allocationStub);
			  	  	
	            System.out.println("Servidor Pronto!");

	        }  
	        catch( Exception e ) {  
	            System.out.println( "Trouble: " + e );  
	        }  
		 		 
	}

}
