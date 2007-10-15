package br.ufg.inf.apsi.escola.componentes.nf.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaFrequencia;
import br.ufg.inf.apsi.escola.componentes.nf.negocio.ConfiguracaoNotaFrequenciaNegocio;
import br.ufg.inf.apsi.escola.componentes.nf.repositorio.ConfiguracaoNotaFrequenciaRepositorio;

class ConfiguracaoNotaFrequenciaBean implements
		ConfiguracaoNotaFrequenciaNegocio {

	private ConfiguracaoNotaFrequenciaRepositorio repositorio = null;

	public ConfiguracaoNotaFrequenciaBean(ConfiguracaoNotaFrequenciaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	public void salvar(ConfiguracaoNotaFrequencia configuracaoNotaFrequencia)
			throws Exception {
		this.repositorio.salvar(configuracaoNotaFrequencia);
	}

}