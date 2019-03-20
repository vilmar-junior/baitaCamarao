package controller;

import javax.swing.JOptionPane;

import model.bo.SobremesaBO;
import model.vo.SobremesaVO;

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
	
	public SobremesaVO consultarSobremesaPorNome(String nome) {
		
		//TODO validar o parâmetro que vem da tela;
		SobremesaBO bo = new SobremesaBO();
		return bo.consultarSobremesaPorNome(nome);
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
}
