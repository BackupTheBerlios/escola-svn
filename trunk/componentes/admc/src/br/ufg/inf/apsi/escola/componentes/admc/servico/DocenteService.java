package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;

/**
 * 
 * @author Fernando Nery Barros
 * 
 */
public interface DocenteService {

	public void gravar(Docente docente) throws Exception;

	public void excluir(long id) throws Exception;

	public Docente consultar(long id) throws Exception;

	public Docente consultarPorMatricula(String matricula) throws Exception;

	public List<Docente> consultar() throws Exception;
}
