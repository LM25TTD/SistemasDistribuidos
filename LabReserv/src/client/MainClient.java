package client;

import java.util.Scanner;

public class MainClient {

	public static void main(String[] args) {
		int opcao = 0;
		opcao = initialScreen();
		System.out.println(opcao);
		switch (opcao){
		case 1: 
			try{
				
			}catch(){
				
			}
			break;
			
		case 2: try{
			
		}catch(){
			
		}
		break;
		
		case 3: try{
			
		}catch(){
			
		}
		break;
		
		case 9: System.exit(0);
		break;
		
		default: break;
		}	
	
	}

	static public int initialScreen() {
		System.out.println(" ==== LABORATÓRIO REMOTO COM JAVA RMI ===");
		System.out.println("< Escolha sua opção abaixo: > ");
		Scanner scan = new Scanner(System.in);
		System.out.println(" 1 - Visualizar todas as reservas");
		System.out.println(" 2 - Criar nova reserva ");
		System.out.println(" 3 - Cancelar uma reserva ");
		System.out.println(" 9 - Sair");
		System.out.print("\nDigite sua escolha:");
		return scan.nextInt();
	}
	
	static public int menuReturn() {
		System.out.println(" Digite '1' para voltar ao Menu Inicial e digite 9 para 'sair'");
		Scanner scan = new Scanner(System.in);
		System.out.print("\nDigite sua escolha:");
		return scan.nextInt();
	}

}