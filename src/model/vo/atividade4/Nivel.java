package model.vo.atividade4;

public class Nivel {

	private int id;
	private String descricao;
	
	public Nivel(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Método reescrito com o objetivo de mostrar um texto agradável
	 * no combobox na tela.
	 */
	@Override
	public String toString() {
		return this.descricao + " (" + this.id + ")";
	}
}