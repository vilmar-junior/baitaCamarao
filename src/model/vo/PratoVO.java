package model.vo;

public class PratoVO {
	
	private int idPrato;
	private String nome;
	private double preco;
	
	public PratoVO(int idPrato, String nome, double preco) {
		super();
		this.idPrato = idPrato;
		this.nome = nome;
		this.preco = preco;
	}

	public PratoVO() {
		super();
	}

	public int getIdPrato() {
		return idPrato;
	}

	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
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
		this.getIdPrato(), 
		this.getNome(), 
		this.getPreco());
	}
	
}
