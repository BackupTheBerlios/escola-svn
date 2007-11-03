package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;

public interface TurmaService {

	public abstract void gravar(Turma turma) throws Exception;

	public abstract void excluir(String codigoTurma) throws Exception;

	public abstract List<Turma> consultar() throws Exception;

	public abstract Turma consultar(String codigoTurma) throws Exception;
	
	public abstract Turma consultar(Long idTurma) throws Exception;
	
	public abstract List<Turma> consultarTurmasDocente(String matriculaDocente);

	public abstract List<Turma> consultarTurmasAluno(Long idPessoa);

	public abstract Curso consultaCurso(Long idTurma);

	public abstract Disciplina consultaDisciplina(Long idTurma);

	public abstract Docente consultaDocente(Long idTurma);
}
