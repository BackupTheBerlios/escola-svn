/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.PreMatriculaDisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepositorio;

/**
 * @author ailton
 *
 */
public class PreMatriculaDisciplinaNegocioBean implements
		PreMatriculaDisciplinaNegocio {

	private PreMatriculaDisciplinaRepositorio preMatricula = null;
	
	
	public PreMatriculaDisciplinaNegocioBean(PreMatriculaDisciplinaRepositorio preMatriculaRepositorio){
		this.preMatricula = preMatriculaRepositorio;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.PreMatriculaDisciplinaNegocio#consultar(java.lang.String)
	 */
	public PreMatriculaDisciplina consultar(String matriculaAluno)
			throws Exception {
		return this.preMatricula.consultar(matriculaAluno);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.PreMatriculaDisciplinaNegocio#excluir(java.lang.String)
	 */
	public void excluir(String matriculaAluno) throws Exception {
		this.preMatricula.excluir(matriculaAluno);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.PreMatriculaDisciplinaNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina)
	 */
	public void gravar(PreMatriculaDisciplina preMatricula) throws Exception {
		this.preMatricula.gravar(preMatricula);

	}

}
