package br.ufg.inf.apsi.escola.componentes.repositorioParaTeste;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Frequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;

/**
 * 
 * Repositorio em memória criado somente para efetuar testes de execução do
 * componente.
 * 
 * @author Yoshiyuki
 * 
 */
public class RepositorioTeste {
	private static RepositorioTeste repositorioTeste;

	private Pessoa[] pessoa;
	private Curso[] curso;
	private Disciplina[] disciplina;
	private Turma[] turma;
	private Aluno[] aluno;
	private MatriculaTurma[] matriculaTurma;
	private Docente[] docente;
	private Nota[] nota;
	private Frequencia[] frequencia;

	public RepositorioTeste() {
		this.pessoa = iniciaPessoa();
		this.curso = iniciaCurso();
		this.aluno = iniciaAluno();
		this.docente = iniciaDocente();
		this.disciplina = iniciaDisciplina();
		this.turma = iniciaTurma();
		this.matriculaTurma = iniciaMatriculaTurma();
		this.nota = iniciaNota();
		this.frequencia = iniciaFrequencia();
	}

	public Pessoa[] getPessoa() {
		return pessoa;
	}

	public Curso[] getCurso() {
		return curso;
	}

	public Disciplina[] getDisciplina() {
		return disciplina;
	}

	public Turma[] getTurma() {
		return turma;
	}

	public Aluno[] getAluno() {
		return aluno;
	}

	public MatriculaTurma[] getMatriculaTurma() {
		return matriculaTurma;
	}

	public Docente[] getDocente() {
		return docente;
	}

	public Nota[] getNota() {
		return nota;
	}

	public Frequencia[] getFrequencia() {
		return frequencia;
	}

	private Frequencia[] iniciaFrequencia() {
		Frequencia[] x = new Frequencia[11];
		x[1] = new Frequencia(new Date(), true);
		x[2] = new Frequencia(new Date(), true);
		x[3] = new Frequencia(new Date(), true);
		x[4] = new Frequencia(new Date(), true);
		x[5] = new Frequencia(new Date(), true);
		x[6] = new Frequencia(new Date(), true);
		x[7] = new Frequencia(new Date(), false);
		x[8] = new Frequencia(new Date(), true);
		x[9] = new Frequencia(new Date(), true);
		x[10] = new Frequencia(new Date(), false);
		return x;
	}

	private Nota[] iniciaNota() {
		Nota[] x = new Nota[17];
		x[1] = new Nota(1);
		x[2] = new Nota(2);
		x[3] = new Nota(3);
		x[4] = new Nota(4);
		x[5] = new Nota(5);
		x[6] = new Nota(6);
		x[7] = new Nota(7);
		x[8] = new Nota(8);
		x[9] = new Nota(9);
		x[10] = new Nota(10);
		x[11] = new Nota(11);
		x[12] = new Nota(12);
		x[13] = new Nota(13);
		x[14] = new Nota(14);
		x[15] = new Nota(15);
		x[16] = new Nota(16);
		return x;
	}

	private Docente[] iniciaDocente() {
		int t = 5;
		Docente[] x = new Docente[t + 1];
		for (int i = 1; i <= t; i++) {
			x[i] = new Docente();
			x[i].setMatricula("MatDoc-" + i);
			x[i].setPessoaId(pessoa[i + 10].getId());
			x[i].setId((long) i);
		}
		return x;
	}

	private MatriculaTurma[] iniciaMatriculaTurma() {
		int t = 150;
		int ialuno = 0;
		int iturma = 0;
		MatriculaTurma[] x = new MatriculaTurma[t + 1];
		for (int i = 1; i <= t; i++) {
			ialuno = ((int) ((i - 1) / 5)) + 1;
			iturma = (((i - 1) % 5) + 1) + (((int) ((i - 1) / 50)) * 5);
			x[i] = new MatriculaTurma();
			x[i].setMatriculaAluno(aluno[ialuno].getNumeroMatricula());
			x[i].setTurma(turma[iturma]);
		}
		return x;
	}

	private Aluno[] iniciaAluno() {
		int t = 30;
		Aluno[] x = new Aluno[t + 1];
		for (int i = 1; i <= t; i++) {
			// x[i]=new Aluno((long) (((i-1)%10)+1),"Mat2007-" + i,curso[(int)
			// ((i-1)/10)+1]);
			x[i] = new Aluno((long) i, "Mat2007-" + i,
					curso[(int) ((i - 1) / 10) + 1]);
			x[i].setId(new Long(i));
		}
		return x;
	}

	private Turma[] iniciaTurma() {
		int t = 15;
		Turma[] x = new Turma[t + 1];
		for (int i = 1; i <= t; i++) {
			x[i] = new Turma("CodT-" + i, "(n1 + n2 + n3 + n4) / 4", 4, false,
					true, disciplina[i], docente[(i % 5) + 1]);
			x[i].setId(new Long(i));
			docente[(i % 5) + 1].addTurma(x[i]);
		}
		return x;
	}

	private Disciplina[] iniciaDisciplina() {
		int t = 15;
		Disciplina[] x = new Disciplina[t + 1];
		for (int i = 1; i <= t; i++) {
			x[i] = new Disciplina("Desciplina " + i, "DCPK-" + i, "Ementa" + i,
					(i % 3) * 10, curso[(int) ((i - 1) / 5 + 1)]);
			x[i].setId((long) i);
			curso[(int) ((i - 1) / 5 + 1)].addDisciplina(x[i]);
		}
		return x;
	}

	private Curso[] iniciaCurso() {
		int t = 3;
		Curso[] x = new Curso[t + 1];
		for (int i = 1; i <= t; i++) {
			x[i] = new Curso("cdg" + i, "Curso Teste " + i);
			x[i].setId((long) i);
		}
		return x;
	}

	private Pessoa[] iniciaPessoa() {
		int t = 30;
		Pessoa[] x = new Pessoa[t + 1];
		for (int i = 1; i <= t; i++) {
			x[i] = new Pessoa("Fulano " + i);
			x[i].setId(new Long(i));
		}
		return x;
	}

	public static RepositorioTeste getRepositorioTeste() {
		if (repositorioTeste == null) {
			repositorioTeste = new RepositorioTeste();
		}
		return repositorioTeste;
	}

	//
	// =============================================================================================
	//

	public HashMap<Long, Pessoa> getPessoaHM() {
		HashMap<Long, Pessoa> hm = new HashMap<Long, Pessoa>();
		for (int i = 1; i < pessoa.length; i++)
			hm.put(pessoa[i].getId(), pessoa[i]);
		return hm;
	}

	public HashMap<String, Curso> getCursoHM() {
		HashMap<String, Curso> hm = new HashMap<String, Curso>();
		for (int i = 1; i < curso.length; i++)
			hm.put(curso[i].getCodigo(), curso[i]);
		return hm;
	}

	public HashMap<String, Disciplina> getDisciplinaHM() {
		HashMap<String, Disciplina> hm = new HashMap<String, Disciplina>();
		for (int i = 1; i < disciplina.length; i++)
			hm.put(disciplina[i].getCodigo(), disciplina[i]);
		return hm;
	}

	public HashMap<String, Turma> getTurmaHM() {
		HashMap<String, Turma> hm = new HashMap<String, Turma>();
		for (int i = 1; i < turma.length; i++) {
			hm.put(turma[i].getCodigoTurma(), turma[i]);
		}
		return hm;
	}

	public HashMap<Long, Turma> getTurmaIdHM() {
		HashMap<Long, Turma> hm = new HashMap<Long, Turma>();
		for (int i = 1; i < turma.length; i++) {
			hm.put(turma[i].getId(), turma[i]);
		}
		return hm;
	}

	public HashMap<String, Aluno> getAlunoHM() {
		HashMap<String, Aluno> hm = new HashMap<String, Aluno>();
		for (int i = 1; i < aluno.length; i++)
			hm.put(aluno[i].getNumeroMatricula(), aluno[i]);
		return hm;
	}

	public HashMap<String, MatriculaTurma> getMatriculaTurmaHM() {
		HashMap<String, MatriculaTurma> hm = new HashMap<String, MatriculaTurma>();
		for (int i = 1; i < matriculaTurma.length; i++)
			hm.put(matriculaTurma[i].getMatriculaAluno() + "@"
					+ matriculaTurma[i].getTurma().getCodigoTurma(),
					matriculaTurma[i]);
		return hm;
	}

	public HashMap<String, Docente> getDocenteHM() {
		HashMap<String, Docente> hm = new HashMap<String, Docente>();
		for (int i = 1; i < docente.length; i++)
			hm.put(docente[i].getMatricula(), docente[i]);
		return hm;
	}

	public List<Nota> getNotaL() {
		List<Nota> l = new ArrayList<Nota>();
		for (int i = 1; i < nota.length; i++)
			l.add(nota[i]);
		return l;
	}

	public List<Frequencia> getFrequenciaL() {
		List<Frequencia> l = new ArrayList<Frequencia>();
		for (int i = 1; i < frequencia.length; i++)
			l.add(frequencia[i]);
		return l;
	}

}
