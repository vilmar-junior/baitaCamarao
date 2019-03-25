package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraBebida;
import model.vo.BebidaVO;


/**
 * Classe que representa um menu de bebidas.
 * 
 * @author Adriano de Melo
 *
 */
public class MenuBebidas {
	
	Scanner teclado = new Scanner(System.in);

	public void apresentarMenuBebidas() {
		System.out.println("\n\nFood Truck - Baita Camarão \n-------- Menu Cadastro de Bebidas--------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastrar Bebida");
		System.out.println("2 - Consultar Bebida");
		System.out.println("3 - Atualizar Bebida");
		System.out.println("4 - Excluir Bebida");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 5) {
			switch (opcao) {
				case 1: {
					this.cadastrarBebida();
					break;
				}
				case 2: {
					this.consultarBebida();
					break;
				}
				case 3: {
					this.atualizarBebida();
					break;
				}
				case 4: {
					this.excluirBebida();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\n\nFood Truck - Baita Camarão \n-------- Menu Cadastro de Bebida--------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastrar Bebida");
			System.out.println("2 - Consultar Bebida");
			System.out.println("3 - Atualizar Bebida");
			System.out.println("4 - Excluir Bebida");
			System.out.println("5 - Voltar");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}

	private void cadastrarBebida() {
		teclado.nextLine();
		BebidaVO bebidaVO = new BebidaVO();
		System.out.print("\nDigite o nome da Bebida: ");
		bebidaVO.setNome(teclado.nextLine());
		System.out.print("Digite o preço da Bebida: ");
		bebidaVO.setPreco(Double.parseDouble(teclado.next()));
		
		ControladoraBebida controladoraBebida = new ControladoraBebida();
		controladoraBebida.cadastrarBebidaController(bebidaVO);
	}

	private void consultarBebida() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todas as Bebidas");
		System.out.println("2 - Consultar uma Bebida Específica");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());

		ControladoraBebida controladoraBebida = new ControladoraBebida();
		while (opcao != 3) {
			switch (opcao) {
			case 1: {
				opcao = 3;
				ArrayList<BebidaVO> listaBebidasVO = controladoraBebida.consultarTodasBebidasController();
				System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
				System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "PREÇO");
				for (int i = 0; i < listaBebidasVO.size(); i++) {
					listaBebidasVO.get(i).imprimir();
				}
				break;
			}
			case 2: {
				opcao = 3;
				BebidaVO bebidaVO = new BebidaVO();
				System.out.print("\nInforme o código da Bebida: ");
				bebidaVO.setIdBebida(Integer.parseInt(teclado.next()));

				BebidaVO bebida = controladoraBebida.consultarBebidaController(bebidaVO);
				System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
				System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "PREÇO");
				bebida.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
				System.out.println("\nInforme o tipo de consulta a ser realizada");
				System.out.println("1 - Consultar todas as Bebida");
				System.out.println("2 - Consultar uma Bebida Específica");
				System.out.println("3 - Voltar");
				System.out.print("\nDigite a Opção: ");
				opcao = Integer.parseInt(teclado.next());
			}
			}
		}
	}

	private void atualizarBebida() {
		BebidaVO bebidaVO = new BebidaVO();
		System.out.print("\nInforme o código da Bebida: ");
		bebidaVO.setIdBebida(Integer.parseInt(teclado.next()));
		teclado.nextLine();
		System.out.print("Digite o nome da Bebida: ");
		bebidaVO.setNome(teclado.nextLine());
		System.out.print("Digite o preço da Bebida: ");
		bebidaVO.setPreco(Double.parseDouble(teclado.next()));

		ControladoraBebida controladoraBebida = new ControladoraBebida();
		controladoraBebida.atualizarBebidaController(bebidaVO);
	}

	private void excluirBebida() {
		BebidaVO bebidaVO = new BebidaVO();
		System.out.print("\nInforme o código da Bebida: ");
		bebidaVO.setIdBebida(Integer.parseInt(teclado.next()));

		ControladoraBebida controladoraBebida = new ControladoraBebida();
		controladoraBebida.excluirBebidaController(bebidaVO);
	}
}