/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.DisciplinaRepository;

/**
 * @author ailton
 * 
 */
public class DisciplinaNegocioBean implements DisciplinaNegocio {

	private DisciplinaRepository disciplinaRepositorio = null;

	public DisciplinaNegocioBean(DisciplinaRepository disciplinaRepositorio) {
		this.disciplinaRepositorio = disciplinaRepositorio;

	}

	public Disciplina consultar(long id) throws Exception {
		return this.disciplinaRepositorio.consultar(id);
	}

	public List<Disciplina> consultar() throws Exception {
		return this.disciplinaRepositorio.consultar();
	}

	public void excluir(long id) throws Exception {
		this.disciplinaRepositorio.excluir(id);

	}

	public void gravar(Disciplina disciplina) throws Exception {
		this.disciplinaRepositorio.gravar(disciplina);

	}

}
