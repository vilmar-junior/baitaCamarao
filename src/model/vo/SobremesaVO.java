package model.vo;

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
		return "SobremesaVO [IdPrato=" + getIdPrato() + ", Nome=" + getNome()
				+ ", Preco=" + getPreco() + ",light=" + light + "]";
	}
	
}
