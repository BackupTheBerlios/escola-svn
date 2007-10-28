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

	public LocalPreMatriculaDisciplinaService(
			PreMatriculaDisciplinaNegocio preMatricula) {
		this.preMatricula = preMatricula;
	}

	public PreMatriculaDisciplina consultar(String matriculaAluno)
			throws Exception {
		return this.preMatricula.consultar(matriculaAluno);
	}

	public void excluir(String matriculaAluno) throws Exception {
		this.preMatricula.excluir(matriculaAluno);

	}

	public void gravar(PreMatriculaDisciplina preMatricula) throws Exception {
		this.preMatricula.gravar(preMatricula);
	}

}
