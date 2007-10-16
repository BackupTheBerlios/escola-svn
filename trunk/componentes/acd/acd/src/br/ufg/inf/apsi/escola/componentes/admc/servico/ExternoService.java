package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.Calendar;
import java.util.List;

/**
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
