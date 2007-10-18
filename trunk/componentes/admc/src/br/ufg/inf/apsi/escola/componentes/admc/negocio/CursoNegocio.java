/*
 * CursoNegocio.java
 *
 * Alterado em 13 de Outubro de 2007 16:06
 * Por: Yoshi
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;

/**
 * 
 * @author Ailton
 * 
 */
public interface CursoNegocio {

	/**
	 * 
	 * Persiste o Curso
	 * <p>
	 * 
	 * @param curso
	 *            instância de Curso a ser persistida.
	 *            <p>
	 * @throws Exception
	 *             Exceção gerada na gravação do curso.
	 */
	public abstract void gravar(Curso curso) throws Exception;

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public abstract void excluir(long id) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract Curso consultar(long id) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract List<Curso> consultar() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract List<Disciplina> consultarDisciplinaDeCurso(long idCurso)
			throws Exception;
}
