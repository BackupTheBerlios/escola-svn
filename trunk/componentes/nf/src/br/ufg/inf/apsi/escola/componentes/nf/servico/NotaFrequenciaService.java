package br.ufg.inf.apsi.escola.componentes.nf.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaFrequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Frequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Matricula;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;

public interface NotaFrequenciaService {

	public List<Nota> obterNotasDoAluno(Matricula matricula);

	public List<Frequencia> obterFrequenciasDoAluno(Matricula matricula);

	public ConfiguracaoNotaFrequencia obterConfiguracaoNotaFrequencia(
			Object Turma);
}