package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioDAO;
import model.dto.ProdutoDTO;
import model.dto.VendaDTO;

/**
 * Classe que representa as regras de negócio de Relatorio.
 * 
 * @author Adriano de Melo
 *
 */
public class RelatorioBO {

	public ArrayList<ProdutoDTO> gerarRelatorioProdutosBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<ProdutoDTO> listaProdutosDTO = relatorioDAO.gerarRelatorioProdutosDAO();
		if(listaProdutosDTO.isEmpty()){
			System.out.println("\nLista de Produtos está vazia.");
		}
		return listaProdutosDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasCanceladasBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<VendaDTO> listaVendaDTO = relatorioDAO.gerarRelatorioVendasCanceladasDAO();
		if(listaVendaDTO.isEmpty()){
			System.out.println("\nNão existem Vendas Canceladas");
		}
		return listaVendaDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasRealizadasBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<VendaDTO> listaVendaDTO = relatorioDAO.gerarRelatorioVendasRealizadasDAO();
		if(listaVendaDTO.isEmpty()){
			System.out.println("\nNão existem Vendas Realizadas");
		}
		return listaVendaDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendaEspecifica(int idVenda) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<VendaDTO> listaVendaDTO = relatorioDAO.gerarRelatorioVendaEspecifica(idVenda);
		if(listaVendaDTO == null){
			System.out.println("\nNão foi localizado a venda específica");
		}
		return listaVendaDTO;
	}

}
