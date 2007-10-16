package br.ufg.inf.apsi.escola.componentes.nf.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;
import br.ufg.inf.apsi.escola.componentes.nf.negocio.ConfiguracaoNotaNegocio;
import br.ufg.inf.apsi.escola.componentes.nf.repositorio.ConfiguracaoNotaRepositorio;

class ConfiguracaoNotaBean implements ConfiguracaoNotaNegocio {

	private ConfiguracaoNotaRepositorio repositorio = null;

	public ConfiguracaoNotaBean(ConfiguracaoNotaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public void salvar(ConfiguracaoNota configuracaoNota)
			throws Exception {
		this.repositorio.salvar(configuracaoNota);
	}

	public ConfiguracaoNota obterConfiguracao(Turma turma) throws Exception {
		return this.repositorio.obterConfiguracao(turma);
	}
}