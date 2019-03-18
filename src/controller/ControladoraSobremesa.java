package controller;

import javax.swing.JOptionPane;

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
		
		if(nome == null || nome.trim().length() < 3) {
			mensagem += "- Nome deve possuir pelo menos 3 caracteres \n";
		}
		
		double precoConvertidoParaDouble = 0;
		if(!stringPrecoEstaCorreto(preco)) {
			mensagem += "- Informe o valor com UMA vírgula (,)!";
		}else {
			//Converte o preco para double
			preco = preco.replace(",", ".");
			precoConvertidoParaDouble = Double.parseDouble(preco);
		}
		
		if(mensagem == "") {
			SobremesaVO novaSobremesa = new SobremesaVO();
			novaSobremesa.setNome(nome);
			novaSobremesa.setPreco(precoConvertidoParaDouble);
			novaSobremesa.setLight(light);
			
			//Chamar BO, passando uma nova sobremesa -> por enquanto só fingindo :)
//			SobremesaBO bo = new SobremesaBO();
//			bo.salvar(novaSobremesa);
			mensagem = "Salvou com sucesso (apesar de não salvar nada ainda :D)!\n"
					+ novaSobremesa.toString();
			
		}
		
		
		return mensagem;
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
