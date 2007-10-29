package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 
 * @author Rodrigo Morian Loures
 */
public class ExternoServiceImpl implements ExternoService {

	public Long buscarIdAlunoLogado() {
		return (long) (Math.random() * 10);
	}

	public List<Long> buscarIdAlunosTurma(Long turmaId) {
		List<Long> alunos = new ArrayList<Long>();
		for (int i = 1; i < 6; i++)
			alunos.add((long) i);
		return alunos;
	}

	public Calendar buscarDataInicioTurma(Long turmaId) {
		return new GregorianCalendar(2007, 01, 03);
	}

	public Calendar buscarDataTerminoTurma(Long turmaId) {
		return new GregorianCalendar(2007, 11, 13);
	}

	public Turma buscarTurma(Long turmaId) {
		return new Turma(1L, "Turma_01", new GregorianCalendar(2007, 01, 03),
				new GregorianCalendar(2007, 11, 13));
	}

	public List<Turma> buscarTurmas() {
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(new Turma(60L, "Turma_01",
				new GregorianCalendar(2007, 01, 03), new GregorianCalendar(
						2007, 11, 13)));
		turmas.add(new Turma(70L, "Turma_02",
				new GregorianCalendar(2006, 01, 03), new GregorianCalendar(
						2006, 11, 13)));
		turmas.add(new Turma(80L, "Turma_03",
				new GregorianCalendar(2007, 01, 07), new GregorianCalendar(
						2007, 11, 17)));
		return turmas;
	}
}
