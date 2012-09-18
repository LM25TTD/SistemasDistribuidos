package main;



import interfaces.IGerenciadorReservas;
import interfaces.ILaboratorio;
import interfaces.IReserva;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.Laboratorio;
import model.Reserva;

import control.GerenciadorReservas;



public class Main {

	public static void main(String[] args) {
		 try {  
			 
			  	GerenciadorReservas gerenciadorReservas = new GerenciadorReservas();
			  	IGerenciadorReservas gerenciadorStub = (IGerenciadorReservas) UnicastRemoteObject.exportObject(gerenciadorReservas, 0);
			  	
			  	Laboratorio laboratorio = new Laboratorio();
			  	ILaboratorio laboratorioStub = (ILaboratorio)UnicastRemoteObject.exportObject(laboratorio, 0);
			  	
			  	Reserva reserva = new Reserva();		
			  	IReserva reservaStub = (IReserva)UnicastRemoteObject.exportObject(reserva, 0);
			  	
			  	Registry registry = LocateRegistry.getRegistry();
			  	registry.rebind("rmi://localhost/Gerenciador", gerenciadorStub);
			  	registry.rebind("rmi://localhost/Laboratorio", laboratorioStub);
			  	registry.rebind("rmi://localhost/Reserva", reservaStub);		  	
			  	
	            System.out.println("Servidor Pronto!");
	            
	        }  
	        catch( Exception e ) {  
	            System.out.println( "Trouble: " + e );  
	        }  

	}

}
