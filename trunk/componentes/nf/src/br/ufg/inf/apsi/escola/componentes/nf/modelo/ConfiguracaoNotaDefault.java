package br.ufg.inf.apsi.escola.componentes.nf.modelo;

public class ConfiguracaoNotaDefault extends ConfiguracaoNota {

	public ConfiguracaoNotaDefault() {
		super();
		super.setFormula(this.obtenhaFormulaPadrao());
		super.setQuantidadeNotas(2);
	}

	private Formula obtenhaFormulaPadrao() {
		Formula formula;
		Expressao expressao;

		expressao = new Expressao("([N1] + [N2]) / 2");
		formula = new Formula(expressao);
		return formula;
	}

	@Override
	public TipoConfiguracaoNota getTipoConfiguracaoNota() {
		return TipoConfiguracaoNota.Default;
	}
}