package model.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa a entidade Venda.
 * 
 * @author Adriano de Melo
 *
 */
public class VendaVO {
	
	private int idVenda;
	private ArrayList<ItemBebidaVO> itensBebidas;
	private ArrayList<ItemPratoVO> itensPratos;
	private Date dataVenda;
	private int senhaPedido;
	private boolean flagVendaCancelada;
	
	public VendaVO(int idVenda, ArrayList<ItemBebidaVO> itensBebidas, ArrayList<ItemPratoVO> itensPratos,
			Date dataVenda, int senhaPedido, boolean flagVendaCancelada) {
		super();
		this.idVenda = idVenda;
		this.itensBebidas = itensBebidas;
		this.itensPratos = itensPratos;
		this.dataVenda = dataVenda;
		this.senhaPedido = senhaPedido;
		this.flagVendaCancelada = flagVendaCancelada;
	}

	public VendaVO() {
		super();
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public ArrayList<ItemBebidaVO> getItensBebidas() {
		return itensBebidas;
	}

	public void setItensBebidas(ArrayList<ItemBebidaVO> itensBebidas) {
		this.itensBebidas = itensBebidas;
	}

	public ArrayList<ItemPratoVO> getItensPratos() {
		return itensPratos;
	}

	public void setItensPratos(ArrayList<ItemPratoVO> itensPratos) {
		this.itensPratos = itensPratos;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getSenhaPedido() {
		return senhaPedido;
	}

	public void setSenhaPedido(int senhaPedido) {
		this.senhaPedido = senhaPedido;
	}

	public boolean isFlagVendaCancelada() {
		return flagVendaCancelada;
	}

	public void setFlagVendaCancelada(boolean flagVendaCancelada) {
		this.flagVendaCancelada = flagVendaCancelada;
	}
}