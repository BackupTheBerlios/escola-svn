package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;

import java.util.List;

/**
 * 
 * @author root
 * 
 */

public interface DocenteRepository {

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
