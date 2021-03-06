package controller;

import java.util.ArrayList;

import model.bo.PratoBO;
import model.vo.PratoVO;

/**
 * Classe que representa um controller de pratos.
 * 
 * @author Adriano de Melo
 *
 */
public class ControladoraPrato {

	public void cadastrarPratoController(PratoVO pratoVO) {
		PratoBO pratoBO = new PratoBO();
		pratoBO.cadastrarPratoBO(pratoVO);
	}

	public ArrayList<PratoVO> consultarTodosPratosController() {
		PratoBO pratoBO = new PratoBO();
		return pratoBO.consultarPratosBO();
	}

	public PratoVO consultarPratoController(PratoVO pratoVO) {
		PratoBO pratoBO = new PratoBO();
		return pratoBO.consultarPratoBO(pratoVO);
	}

	public void atualizarPratoController(PratoVO pratoVO) {
		PratoBO pratoBO = new PratoBO();
		pratoBO.atualizarPratoBO(pratoVO);
	}

	public void excluirPratoController(PratoVO pratoVO) {
		PratoBO pratoBO = new PratoBO();
		pratoBO.excluirPratoBO(pratoVO);
	}
}