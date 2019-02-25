package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraPrato;
import model.vo.PratoVO;

public class MenuPratos {

	Scanner teclado = new Scanner(System.in);

	public void apresentarMenuPratos() {
		System.out.println("\n\nFood Truck - Baita Camarão \n-------- Menu Cadastro de Pratos--------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastrar Prato");
		System.out.println("2 - Consultar Prato");
		System.out.println("3 - Atualizar Prato");
		System.out.println("4 - Excluir Prato");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 5) {
			switch (opcao) {
				case 1: {
					this.cadastrarPrato();
					break;
				}
				case 2: {
					this.consultarPrato();
					break;
				}
				case 3: {
					this.atualizarPrato();
					break;
				}
				case 4: {
					this.excluirPrato();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\n\nFood Truck - Baita Camarão \n-------- Menu Cadastro de Pratos--------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastrar Prato");
			System.out.println("2 - Consultar Prato");
			System.out.println("3 - Atualizar Prato");
			System.out.println("4 - Excluir Prato");
			System.out.println("5 - Voltar");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}

	private void cadastrarPrato() {
		teclado.nextLine();
		PratoVO pratoVO = new PratoVO();
		System.out.print("\nDigite o nome do Prato: ");
		pratoVO.setNome(teclado.nextLine());
		System.out.print("Digite o preço do Prato: ");
		pratoVO.setPreco(Double.parseDouble(teclado.next()));
		
		ControladoraPrato controladoraPrato = new ControladoraPrato();
		controladoraPrato.cadastrarPratoController(pratoVO);
	}

	private void consultarPrato() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos os Pratos");
		System.out.println("2 - Consultar um Prato Específico");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());

		ControladoraPrato controladoraPrato = new ControladoraPrato();
		while (opcao != 3) {
			switch (opcao) {
			case 1: {
				opcao = 3;
				ArrayList<PratoVO> listaPratosVO = controladoraPrato.consultarTodosPratosController();
				System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
				System.out.printf("\n%3s   %-40s   %-20s \n", "ID", "NOME", "PREÇO");
				for (int i = 0; i < listaPratosVO.size(); i++) {
					listaPratosVO.get(i).imprimir();
				}
				break;
			}
			case 2: {
				opcao = 3;
				PratoVO pratoVO = new PratoVO();
				System.out.print("\nInforme o código do Prato: ");
				pratoVO.setIdPrato(Integer.parseInt(teclado.next()));

				PratoVO prato = controladoraPrato.consultarPratoController(pratoVO);
				System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
				System.out.printf("\n%3s   %-40s   %-20s \n", "ID", "NOME", "PREÇO");
				prato.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
				System.out.println("\nInforme o tipo de consulta a ser realizada");
				System.out.println("1 - Consultar todos os Pratos");
				System.out.println("2 - Consultar um Prato Específico");
				System.out.println("3 - Voltar");
				System.out.print("\nDigite a Opção: ");
				opcao = Integer.parseInt(teclado.next());
			}
			}
		}
	}

	private void atualizarPrato() {
		PratoVO pratoVO = new PratoVO();
		System.out.print("\nInforme o código do Prato: ");
		pratoVO.setIdPrato(Integer.parseInt(teclado.next()));
		teclado.nextLine();
		System.out.print("Digite o nome do Prato: ");
		pratoVO.setNome(teclado.nextLine());
		System.out.print("Digite o preço do Prato: ");
		pratoVO.setPreco(Double.parseDouble(teclado.next()));

		ControladoraPrato controladoraPrato = new ControladoraPrato();
		controladoraPrato.atualizarPratoController(pratoVO);
	}

	private void excluirPrato() {
		PratoVO pratoVO = new PratoVO();
		System.out.print("\nInforme o código do Prato: ");
		pratoVO.setIdPrato(Integer.parseInt(teclado.next()));

		ControladoraPrato controladoraPrato = new ControladoraPrato();
		controladoraPrato.excluirPratoController(pratoVO);
	}

}
