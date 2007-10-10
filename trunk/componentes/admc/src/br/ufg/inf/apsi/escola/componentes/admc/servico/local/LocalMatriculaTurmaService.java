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
		this.matriculaTurma=matriculaTurma;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService#consultar(java.lang.String)
	 */
	public MatriculaTurma consultar(String matriculaAluno) throws Exception {
		
		return this.matriculaTurma.consultar(matriculaAluno);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService#excluir(java.lang.String)
	 */
	public void excluir(String matriculaAluno) throws Exception {
		this.matriculaTurma.excluir(matriculaAluno);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma)
	 */
	public void gravar(MatriculaTurma matriculaTurma) throws Exception {
		this.matriculaTurma.gravar(matriculaTurma);

	}

}
