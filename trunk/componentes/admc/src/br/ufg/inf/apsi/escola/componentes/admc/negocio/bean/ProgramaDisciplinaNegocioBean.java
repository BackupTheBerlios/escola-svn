/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.ProgramaDisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.ProgramaDisciplinaRepositorio;

/**
 * @author ailton
 *
 */
public class ProgramaDisciplinaNegocioBean implements ProgramaDisciplinaNegocio {

	private ProgramaDisciplinaRepositorio programaRepositorio = null;
	
	public ProgramaDisciplinaNegocioBean(ProgramaDisciplinaRepositorio programaRepositorio){
		this.programaRepositorio = programaRepositorio;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.ProgramaDisciplinaNegocio#consultar(long)
	 */
	public ProgramaDisciplina consultar(long id) throws Exception {
		return this.programaRepositorio.consultar(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.ProgramaDisciplinaNegocio#consultar()
	 */
	public List<ProgramaDisciplina> consultar() throws Exception {
		return this.programaRepositorio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.ProgramaDisciplinaNegocio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.programaRepositorio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.ProgramaDisciplinaNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina)
	 */
	public void gravar(ProgramaDisciplina programaDisciplina) throws Exception {
		this.programaRepositorio.gravar(programaDisciplina);

	}

}
