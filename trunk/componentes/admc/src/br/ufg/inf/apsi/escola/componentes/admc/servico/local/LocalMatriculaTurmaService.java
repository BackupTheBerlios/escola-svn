/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.MatriculaTurmaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;

/**
 * @author ailton
 * 
 */
public class LocalMatriculaTurmaService implements MatriculaTurmaService {

	private MatriculaTurmaNegocio matriculaTurma = null;

	public LocalMatriculaTurmaService(MatriculaTurmaNegocio matriculaTurma) {
		this.matriculaTurma = matriculaTurma;
	}

	public MatriculaTurma consultar(String matriculaAluno) throws Exception {

		return this.matriculaTurma.consultar(matriculaAluno);
	}

	public void excluir(String matriculaAluno) throws Exception {
		this.matriculaTurma.excluir(matriculaAluno);

	}

	public void gravar(MatriculaTurma matricula) throws Exception {
		this.matriculaTurma.gravar(matricula);
	}

}
