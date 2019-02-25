package view;

import java.util.Scanner;

public class Menu {

	Scanner teclado = new Scanner(System.in);
	
	public void apresentarMenu() {
		System.out.println("Food Truck - Baita Camarão");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Venda");
		System.out.println("3 - Relatório");
		System.out.println("4 - Sair");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 4){
			switch(opcao){
				case 1: {
					MenuCadastro menuCadastro = new MenuCadastro();
					menuCadastro.apresentarMenuCadastro();
					break;
				}
				case 2: {
					MenuVenda menuVenda = new MenuVenda();
					menuVenda.apresentarMenuVenda();
					break;
				}
				case 3: {
					MenuRelatorio menuRelatorio = new MenuRelatorio();
					menuRelatorio.apresentarMenuRelatorio();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("Food Truck - Baita Camarão");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastro");
			System.out.println("2 - Venda");
			System.out.println("3 - Relatório");
			System.out.println("4 - Sair");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}

}
