package br.ufg.inf.apsi.escola.componentes.nf.servico;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;

public interface ConfiguracaoNotaService {

	public ConfiguracaoNota obterConfiguracaoNota(Turma turma) throws Exception;

	public void salvar(ConfiguracaoNota configuracaoNota) throws Exception;

}