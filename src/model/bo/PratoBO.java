package model.bo;

import java.util.ArrayList;
import model.dao.PratoDAO;
import model.vo.PratoVO;

public class PratoBO {

	public void cadastrarPratoBO(PratoVO pratoVO) {
		PratoDAO pratoDAO = new PratoDAO();
		if(pratoDAO.existeRegistroPorNome(pratoVO.getNome())){
			System.out.println("\nPrato já Cadastrado");
		} else {
			int resultado = pratoDAO.cadastrarPratoDAO(pratoVO);
			if(resultado == 1){
				System.out.println("\nPrato cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Prato.");
			}
		}
	}

	public ArrayList<PratoVO> consultarPratosBO() {
		PratoDAO pratoDAO = new PratoDAO();
		ArrayList<PratoVO> pratosVO = pratoDAO.consultarTodosPratosDAO();
		if(pratosVO.isEmpty()){
			System.out.println("\nLista de Pratos está vazia.");
		}
		return pratosVO;
	}

	public PratoVO consultarPratoBO(PratoVO pratoVO) {
		PratoDAO pratoDAO = new PratoDAO();
		PratoVO prato = pratoDAO.consultarPratoDAO(pratoVO);
		if(prato == null){
			System.out.println("\nPrato não Localizado.");
		}
		return prato;
	}

	public void atualizarPratoBO(PratoVO pratoVO) {
		PratoDAO pratoDAO = new PratoDAO();
		if(pratoDAO.existeRegistroPorIdPrato(pratoVO.getId())){
			int resultado = pratoDAO.atualizarPratoDAO(pratoVO);
			if(resultado == 1){
				System.out.println("\nPrato atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Prato.");
			}
		} else {
			System.out.println("\nPrato ainda não foi cadastrado.");
		}
	}

	public void excluirPratoBO(PratoVO pratoVO) {
		PratoDAO pratoDAO = new PratoDAO();
		if(pratoDAO.existeRegistroPorIdPrato(pratoVO.getId())){
			int resultado = pratoDAO.excluirPratoDAO(pratoVO);
			if(resultado == 1){
				System.out.println("\nPrato excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Prato.");
			}
		} else {
			System.out.println("\nPrato não existe na base da dados.");
		}
	}

}
