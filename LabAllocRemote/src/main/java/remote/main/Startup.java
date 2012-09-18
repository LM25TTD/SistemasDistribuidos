package remote.main;

import java.rmi.Naming;

import remote.controller.IAllocationManager;
import remote.controller.impl.AllocationManager;

public class Startup {
	
	public static void main(String[] args) {
		  try {  
			  	IAllocationManager allocationController = new AllocationManager();
	            Naming.rebind("rmi://localhost:1099/AllocationController", allocationController);  
	        }  
	        catch( Exception e ) {  
	            System.out.println( "Trouble: " + e );  
	        }  
		 		 
	}

}
