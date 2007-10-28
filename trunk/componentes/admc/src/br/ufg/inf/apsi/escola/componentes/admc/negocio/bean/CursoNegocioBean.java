package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.CursoRepository;

/**
 * @author ailton
 * 
 */
public class CursoNegocioBean implements CursoNegocio {

	private CursoRepository cursoRepositorio = null;

	public CursoNegocioBean(CursoRepository cursoRepositorio) {
		this.cursoRepositorio = cursoRepositorio;
	}

	public void gravar(Curso curso) throws Exception {
		this.cursoRepositorio.gravar(curso);

	}

	public void excluir(long id) throws Exception {
		this.cursoRepositorio.excluir(id);
	}

	public Curso consultar(long id) throws Exception {
		return this.cursoRepositorio.consultar(id);
	}

	public List<Curso> consultar() throws Exception {
		return this.cursoRepositorio.consultar();
	}
}
