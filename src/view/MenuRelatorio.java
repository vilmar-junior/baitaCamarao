package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraRelatorio;
import model.dto.ProdutoDTO;
import model.dto.VendaDTO;


/**
 * Classe que representa um menu de relatórios.
 * 
 * @author Adriano de Melo
 *
 */
public class MenuRelatorio {

	Scanner teclado = new Scanner(System.in);

	public void apresentarMenuRelatorio() {
		System.out.println("\n\nFood Truck - Baita Camarão \n-------- Menu Relatórios --------");
		System.out.println("\nOpções:");
		System.out.println("1 - Relatório de Produtos");
		System.out.println("2 - Relatório Contábil - Vendas Canceladas");
		System.out.println("3 - Relatório Contábil - Vendas Realizadas");
		System.out.println("4 - Relatório Contábil - Venda Específica");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite a Opção: ");
		int opcao = Integer.parseInt(teclado.next());
		while (opcao != 5) {
			switch (opcao) {
				case 1: {
					this.gerarRelatorioProdutos();
					break;
				}
				case 2: {
					this.gerarRelatorioVendasCanceladas();
					break;
				}
				case 3: {
					this.gerarRelatorioVendasRealizadas();
					break;
				}
				case 4: {
					this.gerarRelatorioVendaEspecífica();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\n\nFood Truck - Baita Camarão \n-------- Menu Relatórios --------");
			System.out.println("\nOpções:");
			System.out.println("1 - Relatório de Produtos");
			System.out.println("2 - Relatório Contábil - Vendas Canceladas");
			System.out.println("3 - Relatório Contábil - Vendas Realizadas");
			System.out.println("4 - Relatório Contábil - Venda Específica");
			System.out.println("5 - Voltar");
			System.out.print("\nDigite a Opção: ");
			opcao = Integer.parseInt(teclado.next());
		}
	}

	private void gerarRelatorioVendaEspecífica() {
		teclado.nextLine();
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		System.out.print("\nInforme o código da venda: ");
		int idVenda = Integer.parseInt(teclado.nextLine());
		ArrayList<VendaDTO> listaVendaDTO = controladoraRelatorio.gerarRelatorioVendaEspecificaController(idVenda);
		System.out.print("\n-------- RELATÓRIO - VENDAS REALIZADASS -------");
		System.out.printf("\n%10s   %-40s   %10s   %12s   %10s \n", "TIPO", "DESCRICAO", "PREÇO", "QUANTIDADE", "SUBTOTAL");
		double total = 0;
		for(int i = 0; i < listaVendaDTO.size(); i++){
			listaVendaDTO.get(i).imprimir();
			total = total + listaVendaDTO.get(i).getSubtotal();
		}
		System.out.println("\nTotal em R$: " + total);
	}

	private void gerarRelatorioVendasRealizadas() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<VendaDTO> listaVendaDTO = controladoraRelatorio.gerarRelatorioVendasRealizadasController();
		System.out.print("\n-------- RELATÓRIO - VENDAS REALIZADASS -------");
		System.out.printf("\n%10s   %-40s   %10s   %12s   %10s \n", "TIPO", "DESCRICAO", "PREÇO", "QUANTIDADE", "SUBTOTAL");
		double total = 0;
		for(int i = 0; i < listaVendaDTO.size(); i++){
			listaVendaDTO.get(i).imprimir();
			total = total + listaVendaDTO.get(i).getSubtotal();
		}
		System.out.println("\nTotal em R$: " + total);
	}

	private void gerarRelatorioVendasCanceladas() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<VendaDTO> listaVendaDTO = controladoraRelatorio.gerarRelatorioVendasCanceladasController();
		System.out.print("\n-------- RELATÓRIO - VENDAS CANCELADAS -------");
		System.out.printf("\n%10s   %-40s   %10s   %12s   %10s \n", "TIPO", "DESCRICAO", "PREÇO", "QUANTIDADE", "SUBTOTAL");
		double total = 0;
		for(int i = 0; i < listaVendaDTO.size(); i++){
			listaVendaDTO.get(i).imprimir();
			total = total + listaVendaDTO.get(i).getSubtotal();
		}
		System.out.println("\nTotal em R$: " + total);
	}

	private void gerarRelatorioProdutos() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<ProdutoDTO> listaProdutoDTO = controladoraRelatorio.gerarRelatorioProdutosController();
		System.out.print("\n--------- RELATÓRIO - LISTAGEM DE PRODUTOS ---------");
		System.out.printf("\n%5s   %-40s   \n", "ITEM", "NOME");
		for (int i = 0; i < listaProdutoDTO.size(); i++) {
			listaProdutoDTO.get(i).imprimir();
		}
		System.out.println("\nTotal de Itens: " + listaProdutoDTO.size());
	}
	
}