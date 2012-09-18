package main;

import interfaces.IGerenciadorReservas;

import java.rmi.Naming;

import control.GerenciadorReservas;

public class Main {

	public static void main(String[] args) {
		 try {  
			  	IGerenciadorReservas gerenciadorReservas = new GerenciadorReservas();
	            Naming.rebind("rmi://localhost:1099/GerenciadorReservas", gerenciadorReservas);  
	        }  
	        catch( Exception e ) {  
	            System.out.println( "Trouble: " + e );  
	        }  

	}

}
