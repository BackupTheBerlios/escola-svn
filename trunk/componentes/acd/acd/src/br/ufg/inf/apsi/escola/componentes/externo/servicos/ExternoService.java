package br.ufg.inf.apsi.escola.componentes.externo.servicos;

import java.util.Calendar;
import java.util.List;

/**
 * Interface criada com o intuito de simular servicos de componentes externos ao
 * componente "acd", dos quais o componente "acd" depende. Dessa forma, pode-se
 * executar e testar o componente "acd", enquanto os servicos externos dos quais
 * ele dependente, nao estao disponiveis. Por este motivo, nao sera gerado
 * documentacao para esta classe.
 * 
 * @author Rodrigo Morian Loures
 */
public interface ExternoService {
	public Turma buscarTurma(Long turmaId);

	public List<Turma> buscarTurmas();

	public List<Long> buscarIdAlunosTurma(Long turmaId);

	public Long buscarIdAlunoLogado();

	public Calendar buscarDataInicioTurma(Long turmaId);

	public Calendar buscarDataTerminoTurma(Long turmaId);
}
