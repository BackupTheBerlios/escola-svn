/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;

/**
 * @author ailton
 * 
 */
public class LocalCursoService implements CursoService {

	private CursoNegocio cursoNegocio = null;

	public LocalCursoService(CursoNegocio cursoNegocio) {
		this.cursoNegocio = cursoNegocio;
	}

	public Curso consultar(long id) throws Exception {
		return this.cursoNegocio.consultar(id);
	}

	public List<Curso> consultar() throws Exception {
		return this.cursoNegocio.consultar();
	}

	public void excluir(long id) throws Exception {
		this.cursoNegocio.excluir(id);

	}

	public void gravar(Curso curso) throws Exception {
		this.cursoNegocio.gravar(curso);
	}
}
