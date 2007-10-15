package br.ufg.inf.apsi.escola.componentes.nf.repositorio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaFrequencia;

public interface ConfiguracaoNotaFrequenciaRepositorio {

	public void salvar(ConfiguracaoNotaFrequencia configuracaoNotaFrequencia)
			throws Exception;

	public ConfiguracaoNotaFrequencia obterConfiguracao(Turma turma)
			throws Exception;
}