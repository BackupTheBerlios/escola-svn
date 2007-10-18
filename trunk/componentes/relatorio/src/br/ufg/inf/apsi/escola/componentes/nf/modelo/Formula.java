package br.ufg.inf.apsi.escola.componentes.nf.modelo;

public class Formula {
	
	private Expressao expressao;
	
	public Formula(Expressao expressao) {
		this.setExpressao(expressao);
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}

}