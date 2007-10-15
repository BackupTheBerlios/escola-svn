package br.ufg.inf.apsi.escola.componentes.nf.repositorio.jpa.hibernate;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;
import br.ufg.inf.apsi.escola.componentes.nf.repositorio.ConfiguracaoNotaRepositorio;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class HibernateConfiguracaoNotaRepositorio extends
		JpaDaoSupport implements ConfiguracaoNotaRepositorio {

	public ConfiguracaoNota obterConfiguracao(Turma turma)
			throws Exception {
		ConfiguracaoNota configuracaoNotaFrequencia = (ConfiguracaoNota) getJpaTemplate()
				.find(ConfiguracaoNota.class, null);

		if (configuracaoNotaFrequencia == null) {
			throw new Exception("Nenhum aluno encontrado!");
		}

		return configuracaoNotaFrequencia;
	}

	public void salvar(ConfiguracaoNota configuracaoNotaFrequencia) throws Exception {
		// TODO Auto-generated method stub
		
	}

}