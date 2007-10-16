package br.ufg.inf.apsi.escola.componentes.nf.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Frequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;

public interface NotaFrequenciaService {

	public List<Nota> obterNotasDoAluno(MatriculaTurma matriculaTurma);

	public List<Frequencia> obterFrequenciasDoAluno(
			MatriculaTurma matriculaTurma);
}