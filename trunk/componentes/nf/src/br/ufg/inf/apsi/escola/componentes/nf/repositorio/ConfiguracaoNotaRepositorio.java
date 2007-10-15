package br.ufg.inf.apsi.escola.componentes.nf.repositorio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;

public interface ConfiguracaoNotaRepositorio {

	public void salvar(ConfiguracaoNota configuracaoNotaFrequencia)
			throws Exception;

	public ConfiguracaoNota obterConfiguracao(Turma turma) throws Exception;
}