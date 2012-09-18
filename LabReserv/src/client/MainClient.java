package client;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainClient {
	private static Scanner scan;
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		int opcao = 0;
		ClientImpl client = new ClientImpl();
				
		
		while (true) {
			opcao = initialScreen();
			//System.out.println(opcao);

			switch (opcao) {
			case 1:
				try {
									
					System.out.println("\n--------------Visualizar Reservas Por Dia--------------\n");
					System.out.println("Digite o dia: ");
					Integer dia = scan.nextInt();
					System.out.println("Digite o mes: ");
					Integer mes = scan.nextInt();
					System.out.println("Digite o ano: ");
					Integer ano = scan.nextInt();

					Calendar diaBusca = new GregorianCalendar(ano, mes, dia,0,0);
			
					System.out.println("\n--------------Resultados--------------\n");
					System.out.println(client.obterTodasReservas(diaBusca));
					menuReturn();
					clearScree();
				} catch (Exception e) {
					System.out.println("Valor inválido foi inserido!");
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					System.out.println("\n--------------Laboratórios Disponíveis--------------\n");
					System.out.println(client.getGerenciador().obterTodosLaboratorios());					
					System.out.println("\n--------------Criar Reserva--------------\n");
					System.out.println("Digite o nome do usuário: ");
					String usuarioSolicitante = scan.next();
					System.out.println("Digite o dia para reserva: ");
					Integer dia = scan.nextInt();
					System.out.println("Digite o mes para reserva: ");
					Integer mes = scan.nextInt();
					System.out.println("Digite o ano para reserva: ");
					Integer ano = scan.nextInt();
					
					System.out.println("Digite a hora de inicio da reserva (0-23): ");
					Integer horaInicio = scan.nextInt();
					System.out.println("Digite a hora de fim da reserva (0-23): ");
					Integer horaFim = scan.nextInt();
					
					Calendar horaInicial = new GregorianCalendar(ano, mes, dia, horaInicio,0);
					Calendar horaFinal = new GregorianCalendar(ano, mes, dia, horaFim,0);
					
					System.out.println("Digite o código do laboratório: ");
					String codLab = scan.next();
										
					System.out.println(client.criarReserva(usuarioSolicitante, horaInicial, horaFinal, codLab));
					menuReturn();
					clearScree();
				} catch (Exception e) {
					System.out.println("Valor inválido foi inserido!");
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("\n--------------Cancelar Reserva--------------\n");
					System.out.println("Insira o código numérico da reserva a ser cancelada: ");
					Integer codReserva = scan.nextInt();
					System.out.print("\n Resposta: ");
					System.out.println(client.cancelarReserva(codReserva));
					menuReturn();
					clearScree(); 

				} catch (Exception e) {
					System.out.println("Valor inválido foi inserido!");
					e.printStackTrace();
				}
				break;	
			case 4:
				try {
					System.out.println("\n--------------Resultados--------------\n");
					System.out.println(client.getGerenciador().obterTodosLaboratorios());
					menuReturn();
					clearScree(); 
				} catch (Exception e) {
					System.out.println("Valor inválido foi inserido!");
					e.printStackTrace();
				}
				break;

			case 9:
				System.out.println("\n--------------Obrigado :D--------------\n");
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	public static void clearScree(){
		for (int i = 0; i < 100; ++i)    
			System.out.println();   
	}
	
	public static  int initialScreen() {
		System.out.println("\n\n ==== LABORATÓRIO REMOTO COM JAVA RMI ===");
		System.out.println("< Escolha sua opção abaixo: > ");
		System.out.println(" 1 - Visualizar todas as reservas");
		System.out.println(" 2 - Criar nova reserva ");
		System.out.println(" 3 - Cancelar uma reserva ");
		System.out.println(" 4 - Visualizar todos os Laboratórios ");
		System.out.println(" 9 - Sair");
		System.out.print("\nDigite sua escolha: ");
		return scan.nextInt();
	}

	
	public static int menuReturn() {
		System.out
				.println(" Digite '1' para voltar ao Menu Inicial e digite 9 para 'sair'");
		System.out.print("\nDigite sua escolha: ");
		return scan.nextInt();
	}

}