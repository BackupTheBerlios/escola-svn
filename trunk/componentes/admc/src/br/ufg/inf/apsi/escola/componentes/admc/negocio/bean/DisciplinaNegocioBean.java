/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.DisciplinaRepositorio;

/**
 * @author ailton
 *
 */
public class DisciplinaNegocioBean implements DisciplinaNegocio {

	private DisciplinaRepositorio disciplinaRepositorio = null;
	
	public DisciplinaNegocioBean(DisciplinaRepositorio disciplinaRepositorio){
		this.disciplinaRepositorio = disciplinaRepositorio;
		
	}
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DisciplinaNegocio#consultar(long)
	 */
	public Disciplina consultar(long id) throws Exception {
	   return this.disciplinaRepositorio.consultar(id);
	}
	
	public List<Disciplina> consultar() throws Exception{
		return this.disciplinaRepositorio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DisciplinaNegocio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.disciplinaRepositorio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.DisciplinaNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina)
	 */
	public void gravar(Disciplina disciplina) throws Exception {
	
		this.disciplinaRepositorio.gravar(disciplina);

	}

}
