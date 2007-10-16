package br.ufg.inf.apsi.escola.componentes.nf.servico.local;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;
import br.ufg.inf.apsi.escola.componentes.nf.negocio.ConfiguracaoNotaNegocio;
import br.ufg.inf.apsi.escola.componentes.nf.servico.ConfiguracaoNotaService;

public class LocalConfiguracaoNotaService implements ConfiguracaoNotaService {

	private ConfiguracaoNotaNegocio configuracaoNotaNegocio;

	public LocalConfiguracaoNotaService(
			ConfiguracaoNotaNegocio configuracaoNotaNegocio) {
		this.configuracaoNotaNegocio = configuracaoNotaNegocio;
	}

	public ConfiguracaoNota obterConfiguracaoNota(Turma turma) throws Exception {
		return this.configuracaoNotaNegocio.obterConfiguracao(turma);
	}

	public void salvar(ConfiguracaoNota configuracaoNota) throws Exception {
		this.configuracaoNotaNegocio.salvar(configuracaoNota);
	}

}