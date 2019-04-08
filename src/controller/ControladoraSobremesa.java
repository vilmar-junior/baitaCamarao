package controller;

import java.util.ArrayList;

import model.bo.SobremesaBO;
import model.vo.SobremesaVO;

/**
 * Classe que representa um controller de sobremesas.
 * 
 * @author Vilmar César Pereira Júnior.
 *
 */
public class ControladoraSobremesa {

	/**
	 * Salva uma nova sobremesa.
	 * 
	 * @param nome o nome da sobremesa
	 * @param preco uma string com o preço, no formato "0,0"
	 * @param light indica se a sobremesa é ou não light
	 * 
	 * @return String uma mensagem indicando:
	 * 	       1 - Se todos os parâmetros foram preenchidos corretamente
	 * 		   2 - Se a sobremesa foi ou não salva no banco
	 */
	public String salvar(String nome, String preco, boolean light) {
		String mensagem = "";
		
		mensagem = validarCampos(nome, preco);
		
		if(mensagem == "") {
			SobremesaVO novaSobremesa = new SobremesaVO();
			novaSobremesa.setNome(nome);
			novaSobremesa.setPreco(converterPreco(preco));
			novaSobremesa.setLight(light);
			
			SobremesaBO bo = new SobremesaBO();
			mensagem = bo.cadastrar(novaSobremesa);
		}
		
		return mensagem;
	}
	
	public String atualizar(int idSobremesa, String nome, String preco, boolean light) {
		String mensagem = "";
		
		mensagem = validarCampos(nome, preco);
		
		SobremesaBO bo = new SobremesaBO();
		SobremesaVO sobremesa = new SobremesaVO();
		sobremesa.setId(idSobremesa);
		sobremesa.setNome(nome);
		sobremesa.setPreco(converterPreco(preco));
		sobremesa.setLight(light);
		
		mensagem = bo.atualizar(sobremesa);
		
		return mensagem;
	}
	
	/**
	 * Busca uma sobremesa dado o seu nome.
	 * 
	 * @param nome da sobremesa a ser buscada
	 * @return SobremesaVO sobremesa encontrada. Caso encontre mais de uma, retorna a primeira.
	 * @throws Exception caso o nome informado para a consulta seja inválido (deve possuir no mínimo 3 caracteres)
	 */
	public SobremesaVO consultarSobremesaPorNome(String nome) throws Exception {

		if(nome == null || nome.isEmpty() || nome.trim().length() < 3) {
			throw new Exception("Nome deve possuir no mínimo 3 caracteres");
		}
		
		SobremesaBO bo = new SobremesaBO();
		return bo.consultarSobremesaPorNome(nome);
	}
	
	public ArrayList<SobremesaVO> consultarTodasAsSobremesas() {
		SobremesaBO bo = new SobremesaBO();
		return bo.consultarTodas();
	}
	
	private String validarCampos(String nome, String preco) {
		String mensagem = "";
		if(nome == null || nome.trim().length() < 3) {
			mensagem += "- Nome deve possuir pelo menos 3 caracteres \n";
		}
		
		if(!stringPrecoEstaCorreto(preco)) {
			mensagem += "- Informe o valor com UMA vírgula (,)!";
		}
		return mensagem;
	}

	private double converterPreco(String preco) {
		//Converte o preco para double
		preco = preco.replace(",", ".");
		double precoConvertidoParaDouble = Double.parseDouble(preco);
		return precoConvertidoParaDouble;
	}

	private boolean stringPrecoEstaCorreto(String precoInformado) {
		boolean stringPrecoEstaCorreta = false;
		//"10,50" --split--> ["10","50"]
		String[] partes = precoInformado.split(",");
		if(partes.length == 2) {
			stringPrecoEstaCorreta = true;
		}
		return stringPrecoEstaCorreta;
	}
	/**
	 * Pede para o BO excluir uma sobremesa
	 * @param sobremesa a sobremesa a ser excluída.
	 * @return mensagem informando se foi excluída ou não
	 */
	public String excluir(SobremesaVO sobremesa) {
		
		String mensagem = "";
		if(sobremesa == null) {
			mensagem = "Selecione uma sobremesa";
		}
		
		if(mensagem.isEmpty()) {
			SobremesaBO bo = new SobremesaBO();
			mensagem = bo.excluir(sobremesa);
		}
		
		return mensagem;
	}
}
