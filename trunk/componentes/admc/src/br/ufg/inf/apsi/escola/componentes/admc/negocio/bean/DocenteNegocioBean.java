/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.DocenteRepository;

/**
 * @author ailton
 * 
 */
public class DocenteNegocioBean implements DocenteNegocio {

	private DocenteRepository docenteRepositorio = null;

	public DocenteNegocioBean(DocenteRepository docenteRepositorio) {
		this.docenteRepositorio = docenteRepositorio;
	}

	public Docente consultar(long id) throws Exception {
		return this.docenteRepositorio.consultar(id);
	}

	public List<Docente> consultar() throws Exception {
		return this.docenteRepositorio.consultar();
	}

	public void excluir(long id) throws Exception {
		this.docenteRepositorio.excluir(id);

	}

	public void gravar(Docente docente) throws Exception {

		this.docenteRepositorio.gravar(docente);

	}

	public Docente consultarPorMatricula(String matricula) throws Exception {
		return this.docenteRepositorio.consultarPorMatricula(matricula);
	}

}
