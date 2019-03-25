package view;

import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * Classe que representa um menu principal do food truck.
 * 
 * @author Adriano de Melo
 *
 */
public class Menu {

	private static final int OPCAO_MENU_CADASTRO = 1;
	private static final int OPCAO_MENU_VENDA = 2;
	private static final int OPCAO_MENU_RELATORIO = 3;
	private static final int OPCAO_MENU_SAIR = 4;
	
	Scanner teclado = new Scanner(System.in);
	
	public void apresentarMenuGrafico() {
		
		String textoMenu = "Food Truck - Baita Camarão \n"
					     + "Opções: \n"
						 + OPCAO_MENU_CADASTRO + " - Cadastro \n"
						 + OPCAO_MENU_VENDA + " - Venda \n"
						 + OPCAO_MENU_RELATORIO + " - Relatório \n"
						 + OPCAO_MENU_SAIR + " - Sair \n"
		                 + "Digite a Opção (somente o número): ";
		
		String opcaoInformada = JOptionPane.showInputDialog(textoMenu);
		
		try {
			//Código inseguro
			int opcao = Integer.parseInt(opcaoInformada);
			encaminharParaTelaEscolhida(opcao);
		}catch(NumberFormatException nExp) {
			//Código de exceção (exceção foi lançada)
			JOptionPane.showMessageDialog(null, "Informe um NÚMERO INTEIRO");
			apresentarMenuGrafico();
		}
		
	}
	
	private void encaminharParaTelaEscolhida(int opcao) {
		switch(opcao){
			case OPCAO_MENU_CADASTRO: {
				MenuCadastro menuCadastro = new MenuCadastro();
				menuCadastro.apresentarMenuCadastroGrafico();
				break;
			}
			case OPCAO_MENU_VENDA: {
				MenuVenda menuVenda = new MenuVenda();
				menuVenda.apresentarMenuVenda();
				break;
			}
			case OPCAO_MENU_RELATORIO: {
				MenuRelatorio menuRelatorio = new MenuRelatorio();
				menuRelatorio.apresentarMenuRelatorio();
				break;
			}
			case OPCAO_MENU_SAIR: {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, 
						"Vai me abandonar? :(");
				switch (opcaoSelecionada) {
					case JOptionPane.YES_OPTION:
						JOptionPane.showMessageDialog(null, "Até mais");
						break;
					case JOptionPane.NO_OPTION:
						apresentarMenuGrafico();
						break;
					case JOptionPane.CANCEL_OPTION:
						apresentarMenuGrafico();
						break;	
				}
			}
			
			default: {
				System.out.println("\nOpção Inválida");
			}
		}
	}

	public void apresentarMenu() {
		mostrarOpcoes();
		
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 4){
			encaminharParaTelaEscolhida(opcao);
			mostrarOpcoes();
			opcao = Integer.parseInt(teclado.next());
		}
	}

	private void mostrarOpcoes() {
		System.out.println("Food Truck - Baita Camarão");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Venda");
		System.out.println("3 - Relatório");
		System.out.println("4 - Sair");
		System.out.print("\nDigite a Opção: ");
	}
}