package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;

/**
 * 
 * @author root
 * 
 */

public interface DocenteRepository {

	public abstract void gravar(Docente docente) throws Exception;

	public abstract void excluir(long id) throws Exception;

	public abstract Docente consultar(long id) throws Exception;

	public abstract List<Docente> consultar() throws Exception;

	public abstract Docente consultarPorMatricula(String matricula)
			throws Exception;

}
