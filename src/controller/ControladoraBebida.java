package controller;

import java.util.ArrayList;
import model.bo.BebidaBO;
import model.vo.BebidaVO;

/**
 * Classe que representa um controller de bebidas.
 * 
 * @author Adriano de Melo
 *
 */
public class ControladoraBebida {

	public void cadastrarBebidaController(BebidaVO bebidaVO) {
		BebidaBO bebidaBO = new BebidaBO();
		bebidaBO.cadastrarBebidaBO(bebidaVO);
	}

	public ArrayList<BebidaVO> consultarTodasBebidasController() {
		BebidaBO bebidaBO = new BebidaBO();
		return bebidaBO.consultarBebidasBO();
	}

	public BebidaVO consultarBebidaController(BebidaVO bebidaVO) {
		BebidaBO bebidaBO = new BebidaBO();
		return bebidaBO.consultarBebidaBO(bebidaVO);
	}

	public void atualizarBebidaController(BebidaVO bebidaVO) {
		BebidaBO bebidaBO = new BebidaBO();
		bebidaBO.atualizarBebidaBO(bebidaVO);
	}

	public void excluirBebidaController(BebidaVO bebidaVO) {
		BebidaBO bebidaBO = new BebidaBO();
		bebidaBO.excluirBebidaBO(bebidaVO);
	}
}