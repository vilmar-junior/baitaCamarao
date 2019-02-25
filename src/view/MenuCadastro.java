package view;

import java.util.Scanner;

public class MenuCadastro {
	
	Scanner teclado = new Scanner(System.in);

	public void apresentarMenuCadastro() {
		System.out.println("\nFood Truck - Baita Camarão \n-------- Menu Cadastro --------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastro de Pratos");
		System.out.println("2 - Cadastro de Bebidas");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 3){
			switch(opcao){
				case 1: {
					MenuPratos menuPratos = new MenuPratos();
					menuPratos.apresentarMenuPratos();
					break;
				}
				case 2: {
					MenuBebidas menuBebidas = new MenuBebidas();
					menuBebidas.apresentarMenuBebidas();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\nFood Truck - Baita Camarão \n-------- Menu Cadastro --------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastro de Pratos");
			System.out.println("2 - Cadastro de Bebidas");
			System.out.println("3 - Voltar");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
		
	}

}
