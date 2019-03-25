package model.bo;

import java.util.ArrayList;

import model.dao.BebidaDAO;
import model.vo.BebidaVO;

/**
 * Classe que representa as regras de negócio de Bebida.
 * 
 * @author Adriano de Melo
 *
 */
public class BebidaBO {

	public void cadastrarBebidaBO(BebidaVO bebidaVO) {
		BebidaDAO bebidaDAO = new BebidaDAO();
		if(bebidaDAO.existeRegistroPorNome(bebidaVO.getNome())){
			System.out.println("\nBebida já Cadastrada");
		} else {
			int resultado = bebidaDAO.cadastrarBebidaDAO(bebidaVO);
			if(resultado == 1){
				System.out.println("\nBebida cadastrada com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar a Bebida.");
			}
		}
	}

	public ArrayList<BebidaVO> consultarBebidasBO() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		ArrayList<BebidaVO> bebidasVO = bebidaDAO.consultarTodasBebidasDAO();
		if(bebidasVO.isEmpty()){
			System.out.println("\nLista de Bebidas está vazia.");
		}
		return bebidasVO;
	}

	public BebidaVO consultarBebidaBO(BebidaVO bebidaVO) {
		BebidaDAO bebidaDAO = new BebidaDAO();
		BebidaVO bebida = bebidaDAO.consultarBebidaDAO(bebidaVO);
		if(bebida == null){
			System.out.println("\nBebida não Localizada.");
		}
		return bebida;
	}

	public void atualizarBebidaBO(BebidaVO bebidaVO) {
		BebidaDAO bebidaDAO = new BebidaDAO();
		if(bebidaDAO.existeRegistroPorIdBebida(bebidaVO.getIdBebida())){
			int resultado = bebidaDAO.atualizarBebidaDAO(bebidaVO);
			if(resultado == 1){
				System.out.println("\nBebida atualizada com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar a Bebida.");
			}
		} else {
			System.out.println("\nBebida ainda não foi cadastrada.");
		}
	}

	public void excluirBebidaBO(BebidaVO bebidaVO) {
		BebidaDAO bebidaDAO = new BebidaDAO();
		if(bebidaDAO.existeRegistroPorIdBebida(bebidaVO.getIdBebida())){
			int resultado = bebidaDAO.excluirBebidaDAO(bebidaVO);
			if(resultado == 1){
				System.out.println("\nBebida excluída com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir a Bebida.");
			}
		} else {
			System.out.println("\nBebida não existe na base da dados.");
		}
	}

}
