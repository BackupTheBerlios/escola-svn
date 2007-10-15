package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;

/**
 * 
 * @author Fernando Nery Barros
 * 
 */
public interface DocenteNegocio {

	/**
	 * 
	 * @param docente
	 * @throws Exception
	 */

	public abstract void gravar(Docente docente) throws Exception;

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

	public abstract Docente consultar(long id) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */

	public abstract List<Docente> consultar() throws Exception;

	/**
	 * 
	 * @param matricula
	 * @return
	 * @throws Exception
	 */

	public abstract Docente consultarPorMatricula(String matricula)
			throws Exception;
}
