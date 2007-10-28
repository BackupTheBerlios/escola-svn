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

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService#consultar(long)
	 */
	public Curso consultar(long id) throws Exception {
		return this.cursoNegocio.consultar(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService#consultar()
	 */
	public List<Curso> consultar() throws Exception {
		return this.cursoNegocio.consultar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.cursoNegocio.excluir(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso)
	 */
	public void gravar(Curso curso) throws Exception {
		this.cursoNegocio.gravar(curso);

	}
}
