package br.ufg.inf.apsi.escola.componentes.externo.servicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Esta classe implementa ExternoService, foi criada com o intuito de simular servicos
 * de componentes externos ao componente "acd", dos quais o componente "acd"
 * depende. Dessa forma, pode-se executar e testar o componente "acd", enquanto
 * os servicos externos dos quais ele dependente, nao estao disponiveis. Por este
 * motivo, nao sera gerado documentacao para esta classe.
 * 
 * @author Rodrigo Morian Loures
 */
public class ExternoServiceImpl implements ExternoService {

	public Long buscarIdAlunoLogado() {
		byte valor;

		valor = (byte) (Math.random() * 10);
		if(valor < 5)
			return 29L;
		else
			return 51L;
	}

	public List<Long> buscarIdAlunosTurma(Long turmaId) {
		List<Long> alunos = new ArrayList<Long>();
		for (int i = 1; i < 6; i++)
			alunos.add((long) i);
		return alunos;
	}

	public Calendar buscarDataInicioTurma(Long turmaId) {
		return new GregorianCalendar(2007, 06, 03);
	}

	public Calendar buscarDataTerminoTurma(Long turmaId) {
		return new GregorianCalendar(2007, 11, 29);
	}

	public Turma buscarTurma(Long turmaId) {
		return new Turma(1L, "Turma_01", new GregorianCalendar(2007, 01, 03),
				new GregorianCalendar(2007, 11, 13));
	}

	public List<Turma> buscarTurmas() {
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(new Turma(60L, "Turma_01", new GregorianCalendar(2007, 01,
				03), new GregorianCalendar(2007, 11, 13)));
		turmas.add(new Turma(70L, "Turma_02", new GregorianCalendar(2006, 01,
				03), new GregorianCalendar(2006, 11, 13)));
		turmas.add(new Turma(80L, "Turma_03", new GregorianCalendar(2007, 01,
				07), new GregorianCalendar(2007, 11, 17)));
		return turmas;
	}
}
