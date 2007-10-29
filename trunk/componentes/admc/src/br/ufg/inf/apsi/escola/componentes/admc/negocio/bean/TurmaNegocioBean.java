/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.TurmaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.TurmaRepository;

/**
 * Esta classe, <code>TurmaNegocioBean</code>, implementa a
 * <code>interface</code><code>TurmaNegocio</code> seguindo o contrato
 * estabelecido pela interface.
 * 
 * @author Fernando Nery Barros
 * @data 13/10/207
 */
public class TurmaNegocioBean implements TurmaNegocio {

	private TurmaRepository turmaRepositorio = null;

	public TurmaNegocioBean(TurmaRepository turmaRepositorio) {
		this.turmaRepositorio = turmaRepositorio;
	}

	public List<Turma> consultar() throws Exception {
		return this.turmaRepositorio.consultar();
	}

	public Turma consultar(long id) throws Exception {
		return this.turmaRepositorio.consultar(id);
	}

	public void excluir(long id) throws Exception {
		this.turmaRepositorio.excluir(id);

	}

	public void gravar(Turma turma) throws Exception {
		this.turmaRepositorio.gravar(turma);
	}

}
