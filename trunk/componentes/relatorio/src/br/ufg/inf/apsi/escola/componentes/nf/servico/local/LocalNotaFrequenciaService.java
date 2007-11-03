package br.ufg.inf.apsi.escola.componentes.nf.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaFrequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Frequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;
import br.ufg.inf.apsi.escola.componentes.nf.servico.NotaFrequenciaService;
import br.ufg.inf.apsi.escola.componentes.repositorioParaTeste.RepositorioTeste;

public class LocalNotaFrequenciaService implements NotaFrequenciaService {

	private RepositorioTeste repositorio;
	
	public LocalNotaFrequenciaService(){
		repositorio = RepositorioTeste.getRepositorioTeste();
	}
	public ConfiguracaoNotaFrequencia obterConfiguracaoNotaFrequencia(
			Object Turma) {
		return null;
	}

	public List<Frequencia> obterFrequenciasDoAluno(
			MatriculaTurma matriculaTurma) {
		return repositorio.getFrequenciaL();
	}

	public List<Nota> obterNotasDoAluno(MatriculaTurma matriculaTurma) {
		return repositorio.getNotaL();
	}

}
