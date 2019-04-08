package model.vo;

/**
 * Classe que representa uma entidade Sobremesa, uma subclasse de Prato.
 * 
 * @author Vilmar César Pereira Júnior
 *
 */
public class SobremesaVO extends PratoVO {

	private boolean light;

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	@Override
	public String toString() {
		return this.getNome() + " (" + (this.isLight() ? "Light" : "Não é light") + ")";
	}
}