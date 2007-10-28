/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;

/**
 * @author Fernando Nery Barros
 * 
 */
public class LocalDocenteService implements DocenteService {

	/**
	 * 
	 */

	private DocenteNegocio docenteNegocio = null;

	public LocalDocenteService(DocenteNegocio docenteNegocio) {
		this.docenteNegocio = docenteNegocio;
	}

	public Docente consultar(long id) throws Exception {
		return this.docenteNegocio.consultar(id);
	}

	public List<Docente> consultar() throws Exception {
		return this.docenteNegocio.consultar();
	}

	public void excluir(long id) throws Exception {
		this.docenteNegocio.excluir(id);

	}

	public void gravar(Docente docente) throws Exception {
		this.docenteNegocio.gravar(docente);
	}

	public Docente consultarPorMatricula(String matricula) throws Exception {
		return this.docenteNegocio.consultarPorMatricula(matricula);
	}

}
