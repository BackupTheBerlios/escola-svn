package br.ufg.inf.apsi.escola.componentes.nf.modelo;

public class ConfiguracaoNotaFrequenciaFormula extends
		ConfiguracaoNotaFrequencia {
	
	private Formula formula;
	private int quantidadeNotas;

	public ConfiguracaoNotaFrequenciaFormula(short quantidadeNotas) {
		super();
		this.setQuantidadeNotas(quantidadeNotas);
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public int getQuantidadeNotas() {
		return quantidadeNotas;
	}

	public void setQuantidadeNotas(int quantidadeNotas) {
		this.quantidadeNotas = quantidadeNotas;
	}
	
}