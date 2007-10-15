package br.ufg.inf.apsi.escola.componentes.nf.modelo;

public abstract class ConfiguracaoNota {

	protected int quantidadeNotas;

	protected Formula formula;

	protected ConfiguracaoNota() {

	}

	protected ConfiguracaoNota(int quantidadeNotas, Formula formula) {
		this.setQuantidadeNotas(quantidadeNotas);
		this.setFormula(formula);
	}

	public int getQuantidadeNotas() {
		return quantidadeNotas;
	}

	public void setQuantidadeNotas(int quantidadeNotas) {
		this.quantidadeNotas = quantidadeNotas;
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public abstract TipoConfiguracaoNota getTipoConfiguracaoNota();
}