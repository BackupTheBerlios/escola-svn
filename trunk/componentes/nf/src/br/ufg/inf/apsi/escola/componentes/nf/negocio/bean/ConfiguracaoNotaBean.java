package br.ufg.inf.apsi.escola.componentes.nf.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;
import br.ufg.inf.apsi.escola.componentes.nf.negocio.ConfiguracaoNotaNegocio;
import br.ufg.inf.apsi.escola.componentes.nf.repositorio.ConfiguracaoNotaRepositorio;

class ConfiguracaoNotaBean implements
		ConfiguracaoNotaNegocio {

	private ConfiguracaoNotaRepositorio repositorio = null;

	public ConfiguracaoNotaBean(ConfiguracaoNotaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	public void salvar(ConfiguracaoNota configuracaoNotaFrequencia)
			throws Exception {
		this.repositorio.salvar(configuracaoNotaFrequencia);
	}

}