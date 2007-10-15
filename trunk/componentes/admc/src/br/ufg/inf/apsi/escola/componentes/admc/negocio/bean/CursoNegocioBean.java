/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.CursoRepositorio;

/**
 * @author ailton
 * 
 */
public class CursoNegocioBean implements CursoNegocio {

	private CursoRepositorio cursoRepositorio = null;

	public CursoNegocioBean(CursoRepositorio cursoRepositorio) {
		this.cursoRepositorio = cursoRepositorio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso)
	 */
	public void gravar(Curso curso) throws Exception {
		this.cursoRepositorio.gravar(curso);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.cursoRepositorio.excluir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio#consultar(long)
	 */
	
	public Curso consultar(long id) throws Exception {
	   return this.cursoRepositorio.consultar(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.CursoNegocio#consultar()
	 */
	public List<Curso> consultar() throws Exception {
	   return this.cursoRepositorio.consultar();
	}

}
