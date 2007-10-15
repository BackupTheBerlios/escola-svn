package br.ufg.inf.apsi.escola.componentes.nf.modelo;

public class ConfiguracaoNotaCustomizado extends ConfiguracaoNota {

	public ConfiguracaoNotaCustomizado(short quantidadeNotas, Formula formula) {
		super(quantidadeNotas, formula);
	}

	@Override
	public TipoConfiguracaoNota getTipoConfiguracaoNota() {
		return TipoConfiguracaoNota.Customizado;
	}

}