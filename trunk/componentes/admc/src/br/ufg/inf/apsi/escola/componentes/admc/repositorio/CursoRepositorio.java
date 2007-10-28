package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;

public interface CursoRepositorio {

	public abstract void gravar(Curso curso) throws Exception;

	public abstract void excluir(long id) throws Exception;

	public abstract Curso consultar(long id) throws Exception;

	public abstract List<Curso> consultar() throws Exception;

}
