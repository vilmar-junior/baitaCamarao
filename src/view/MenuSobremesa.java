package view;

import javax.swing.JOptionPane;

import model.vo.SobremesaVO;

public class MenuSobremesa {

	public void apresentarMenuSobremesa() {
		String nomeInformado = JOptionPane.showInputDialog("Informe o nome:");

		double preco = obterPreco();
		boolean light = obterSeEhLight();

		SobremesaVO novaSobremesa = new SobremesaVO();
		novaSobremesa.setNome(nomeInformado);
		novaSobremesa.setPreco(preco);
		novaSobremesa.setLight(light);

		JOptionPane.showMessageDialog(null, "Sobremesa salva!\n "
				+ novaSobremesa.toString());
	}

	private boolean obterSeEhLight() {
		boolean light = false;
		String stringEhLight = JOptionPane.showInputDialog("É light (Sim/Não ou S/N)?");
		if(stringEhLight.equals("Sim") || stringEhLight.equals("S")) {
			light = true;
		}else if(stringEhLight.equals("Não") || stringEhLight.equals("N")) {
			light = false;
		}else {
			JOptionPane.showMessageDialog(null, "Informe se é light usando apenas as opções Sim/Não ou S/N");
			obterSeEhLight();
		}
		return light;
	}

	private double obterPreco() {
		String precoInformado = JOptionPane.showInputDialog("Informe o valor (com vírgula)");
		double preco = 0;

		if(!stringPrecoEstaCorreta(precoInformado)) {
			JOptionPane.showMessageDialog(null, "Informe o valor com UMA vírgula (,)!");
			//Chamada recursiva deve preencher o valor anterior para não retornar ZERO
			preco = obterPreco();
		}else {
			try {
				precoInformado = precoInformado.replace(',', '.');
				preco = Double.parseDouble(precoInformado);
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Informe o valor com UMA vírgula (,)!");
				obterPreco();
			}
		}
		return preco;
	}

	private boolean stringPrecoEstaCorreta(String precoInformado) {
		boolean stringPrecoEstaCorreta = false;
		//"10,50" --split--> ["10","50"]
		String[] partes = precoInformado.split(",");
		if(partes.length == 2) {
			stringPrecoEstaCorreta = true;
		}
		return stringPrecoEstaCorreta;
	}
}