package main;



import interfaces.IGerenciadorReservas;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import control.GerenciadorReservas;



public class Main {

	public static void main(String[] args) {
		 try {  
			 
			  	GerenciadorReservas gerenciadorReservas = new GerenciadorReservas();
			  	IGerenciadorReservas gerenciadorStub = (IGerenciadorReservas) UnicastRemoteObject.exportObject(gerenciadorReservas, 0);
			  			  
			  	Registry registry = LocateRegistry.getRegistry();
			  	registry.rebind("Gerenciador", gerenciadorStub);
			  	  	
			  	
	            System.out.println("Servidor Pronto!");
	            
	        }  
	        catch( Exception e ) {  
	            System.out.println( "Problema: " + e );  
	        }  

	}

}
