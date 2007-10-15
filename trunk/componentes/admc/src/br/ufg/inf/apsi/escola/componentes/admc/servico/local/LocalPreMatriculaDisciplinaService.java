/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.PreMatriculaDisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.PreMatriculaDisciplinaService;

/**
 * @author ailton
 *
 */
public class LocalPreMatriculaDisciplinaService implements
		PreMatriculaDisciplinaService {

	private PreMatriculaDisciplinaNegocio preMatricula = null;
	
	public LocalPreMatriculaDisciplinaService(PreMatriculaDisciplinaNegocio preMatricula){
		this.preMatricula = preMatricula;
	}
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.PreMatriculaDisciplinaService#consultar(java.lang.String)
	 */
	public PreMatriculaDisciplina consultar(String matriculaAluno)
			throws Exception {
		return this.preMatricula.consultar(matriculaAluno);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.PreMatriculaDisciplinaService#excluir(java.lang.String)
	 */
	public void excluir(String matriculaAluno) throws Exception {
	   this.preMatricula.excluir(matriculaAluno);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.PreMatriculaDisciplinaService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina)
	 */
	public void gravar(PreMatriculaDisciplina preMatricula) throws Exception {
		this.preMatricula.gravar(preMatricula);

	}

}
