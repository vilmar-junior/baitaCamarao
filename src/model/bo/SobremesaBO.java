package model.bo;

import model.dao.SobremesaDAO;
import model.vo.SobremesaVO;

/**
 * Classe que encapsula as regras de negócio de uma 
 * Sobremesa
 * 
 * @author Vilmar C. Pereira Júnior
 *
 */
public class SobremesaBO {
	
	
	/**
	 * Cadastra uma nova sobremesa.
	 * Não permite o cadastro de sobremesas homônimas.
	 * 
	 * @param novaSobremesa a sobremesa que será salva
	 * @return String mensagem: de sucesso, erro ou não permitindo o cadastro
	 * por já existir sobremesa no banco com o mesmo nome.
	 */
	public String cadastrar(SobremesaVO novaSobremesa) {
		
		String mensagem = "";
		SobremesaDAO sDao = new SobremesaDAO();
		if(sDao.existeRegistroPorNome(novaSobremesa.getNome())){
			mensagem = "Já existe sobremesa cadastrada com este nome: " + novaSobremesa.getNome();
		}else {
			int statusPersistencia = sDao.cadastrarSobremesaDAO(novaSobremesa);
			
			if(statusPersistencia == 1) {
				mensagem = "Sobremesa salva com sucesso";
			}else if(statusPersistencia == 0) {
				mensagem = "Erro ao salvar sobremesa";
			}
		}
		
		return mensagem;
	}
	
	public String atualizar(SobremesaVO sobremesa) {
		
		String mensagem = "";
		SobremesaDAO sDao = new SobremesaDAO();
		
		if(sobremesa == null ) {
			mensagem = "Sobremesa está nula, favor preencher";
		}else if (sobremesa.getId() > 0){
			mensagem = "Sobremesa deve possuir um id. Erro ao consultar a sobremesa";
		}
		
		if(sDao.existeRegistroPorNome(sobremesa.getNome())){
			mensagem = "Já existe sobremesa cadastrada com este nome: " + sobremesa.getNome();
		}else {
			int statusPersistencia = sDao.atualizarSobremesa(sobremesa);
			
			if(statusPersistencia == 1) {
				mensagem = "Sobremesa atualizada com sucesso";
			}else if(statusPersistencia == 0) {
				mensagem = "Erro ao atualizada sobremesa";
			}
		}
		
		return mensagem;
	}
	
	public SobremesaVO consultarSobremesaPorNome(String nome) {
		//TODO incluir validação do parâmetro nome
		SobremesaDAO dao = new SobremesaDAO();
		return dao.consultarSobremesaPorNome(nome);
	}
}