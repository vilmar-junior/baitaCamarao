package controller;

import model.bo.VendaBO;
import model.vo.VendaVO;

/**
 * Classe que representa um controller de vendas.
 * 
 * @author Adriano de Melo
 *
 */
public class ControladoraVenda {

	public void cadastrarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		vendaBO.cadastrarVendaBO(vendaVO);
	}

	public void cancelarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		vendaBO.cancelarVendaBO(vendaVO);
	}
}