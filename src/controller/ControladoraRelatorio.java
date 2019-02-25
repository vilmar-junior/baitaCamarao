package controller;

import java.util.ArrayList;

import model.bo.RelatorioBO;
import model.dto.ProdutoDTO;
import model.dto.VendaDTO;

public class ControladoraRelatorio {

	public ArrayList<ProdutoDTO> gerarRelatorioProdutosController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioProdutosBO();
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasCanceladasController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioVendasCanceladasBO();
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasRealizadasController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioVendasRealizadasBO();
	}

	public ArrayList<VendaDTO> gerarRelatorioVendaEspecificaController(int idVenda) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioVendaEspecifica(idVenda);
	}

}
