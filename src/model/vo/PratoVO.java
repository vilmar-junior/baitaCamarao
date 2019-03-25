package model.vo;

/**
 * Classe que representa a entidade Prato.
 * 
 * @author Adriano de Melo
 *
 */
public class PratoVO {
	
	private int id;
	private String nome;
	private double preco;
	
	public PratoVO(int id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public PratoVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void imprimir() {
		System.out.printf("%3d   %-40s   %-20s \n", 
		this.getId(), 
		this.getNome(), 
		this.getPreco());
	}
}