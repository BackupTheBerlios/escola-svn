package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;

public interface CursoRepositorio {

	public abstract void gravar(Curso curso) throws Exception;

	public abstract void excluir(long id) throws Exception;

	public abstract Curso consultar(long id) throws Exception;

	public abstract List<Curso> consultar() throws Exception;

	public abstract List<Disciplina> consultarDisciplinaDeCurso(long idCurso)
			throws Exception;
}
