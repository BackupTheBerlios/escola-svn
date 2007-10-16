package br.ufg.inf.apsi.escola.componentes.nf.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;

public interface ConfiguracaoNotaNegocio {
	
	public void salvar(ConfiguracaoNota configuracaoNotaFrequencia) throws Exception;
	public ConfiguracaoNota obterConfiguracao(Turma turma) throws Exception;
}