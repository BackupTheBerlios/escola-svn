/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepositorio;

/**
 * @author ailton
 * 
 */
public class DocenteNegocioBean implements DocenteNegocio {

	private DocenteRepositorio docenteRepositorio = null;

	public DocenteNegocioBean(DocenteRepositorio docenteRepositorio) {
		this.docenteRepositorio = docenteRepositorio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio#consultar(long)
	 */
	public Docente consultar(long id) throws Exception {
		return this.docenteRepositorio.consultar(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio#consultar()
	 */
	public List<Docente> consultar() throws Exception {
		return this.docenteRepositorio.consultar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.docenteRepositorio.excluir(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente)
	 */
	public void gravar(Docente docente) throws Exception {
		this.docenteRepositorio.gravar(docente);

	}

	public Docente consultarPorMatricula(String matricula) throws Exception {
		return this.docenteRepositorio.consultarPorMatricula(matricula);
	}

}
