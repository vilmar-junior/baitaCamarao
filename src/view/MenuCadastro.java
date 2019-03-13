package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MenuCadastro {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_CADASTRO_PRATO = 1;
	private static final int OPCAO_CADASTRO_SOBREMESA = 2;
	private static final int OPCAO_CADASTRO_BEBIDA = 3;
	private static final int OPCAO_VOLTAR = 4;

	public void apresentarMenuCadastroGrafico() {
		String textoMenu = "Food Truck - Baita Camarão \n"
				+ "Opções: \n"
				+ OPCAO_CADASTRO_PRATO + " - Prato \n"
				+ OPCAO_CADASTRO_SOBREMESA + " - Sobremesa \n"
				+ OPCAO_CADASTRO_BEBIDA + " - Bebida \n"
				+ OPCAO_VOLTAR + " - Voltar \n"
				+ "Digite a Opção (somente o número): ";

		String opcaoInformada = JOptionPane.showInputDialog(textoMenu);

		try {
			//Código inseguro
			int opcao = Integer.parseInt(opcaoInformada);
			encaminharParaTelaEscolhida(opcao);
		}catch(NumberFormatException nExp) {
			//Código de exceção (exceção foi lançada)
			JOptionPane.showMessageDialog(null, "Informe um NÚMERO INTEIRO");
			apresentarMenuCadastroGrafico();
		}
	}

	private void encaminharParaTelaEscolhida(int opcao) {
		switch(opcao){
		case OPCAO_CADASTRO_PRATO: {
			MenuPratos menuPratos = new MenuPratos();
			menuPratos.apresentarMenuPratos();
			break;
		}
		case OPCAO_CADASTRO_SOBREMESA: {
			MenuSobremesa menuSobremesa = new MenuSobremesa();
			menuSobremesa.apresentarMenuSobremesa();
		}
		case OPCAO_CADASTRO_BEBIDA: {
			MenuBebidas menuBebidas = new MenuBebidas();
			menuBebidas.apresentarMenuBebidas();
			break;
		}
		default: {
			System.out.println("\nOpção Inválida");
		}

		}
	}

	public void apresentarMenuCadastro() {
		System.out.println("\nFood Truck - Baita Camarão \n-------- Menu Cadastro --------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastro de Pratos");
		System.out.println("2 - Cadastro de Bebidas");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 3){
			encaminharParaTelaEscolhida(opcao);
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