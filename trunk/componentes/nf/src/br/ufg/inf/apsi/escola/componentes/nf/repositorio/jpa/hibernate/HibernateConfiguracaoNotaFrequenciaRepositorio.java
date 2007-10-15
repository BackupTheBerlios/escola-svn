package br.ufg.inf.apsi.escola.componentes.nf.repositorio.jpa.hibernate;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaFrequencia;
import br.ufg.inf.apsi.escola.componentes.nf.repositorio.ConfiguracaoNotaFrequenciaRepositorio;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class HibernateConfiguracaoNotaFrequenciaRepositorio extends
		JpaDaoSupport implements ConfiguracaoNotaFrequenciaRepositorio {

	public ConfiguracaoNotaFrequencia obterConfiguracao(Turma turma)
			throws Exception {
		ConfiguracaoNotaFrequencia configuracaoNotaFrequencia = (ConfiguracaoNotaFrequencia) getJpaTemplate()
				.find(ConfiguracaoNotaFrequencia.class, null);

		if (configuracaoNotaFrequencia == null) {
			throw new Exception("Nenhum aluno encontrado!");
		}

		return configuracaoNotaFrequencia;
	}

	public void salvar(ConfiguracaoNotaFrequencia configuracaoNotaFrequencia) throws Exception {
		// TODO Auto-generated method stub
		
	}

}