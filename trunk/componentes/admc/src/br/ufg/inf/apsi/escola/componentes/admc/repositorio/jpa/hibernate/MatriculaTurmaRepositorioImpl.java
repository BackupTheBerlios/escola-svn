/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepositorio;
import org.springframework.orm.jpa.support.JpaDaoSupport;
/**
 * @author ailton
 *
 */
public class MatriculaTurmaRepositorioImpl extends JpaDaoSupport implements MatriculaTurmaRepositorio {

	public MatriculaTurmaRepositorioImpl() {
	
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepositorio#consultar(java.lang.String)
	 */
	public MatriculaTurma consultar(String matriculaAluno) throws Exception {
MatriculaTurma matriculaTurma = (MatriculaTurma) getJpaTemplate().find(MatriculaTurma.class, String.valueOf(matriculaAluno));
        
        if(matriculaTurma==null) {
            throw new Exception("Nenhuma Matricula encontrada para a Turma!");
        }
        
        return matriculaTurma;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepositorio#excluir(java.lang.String)
	 */
	public void excluir(String matriculaAluno) throws Exception {
		getJpaTemplate().remove(this.consultar(matriculaAluno));

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma)
	 */
	public void gravar(MatriculaTurma matriculaTurma) throws Exception {
		getJpaTemplate().persist(matriculaTurma);

	}

}
