/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepository;

/**
 * @author ailton
 * 
 */
public class MatriculaTurmaRepositoryImpl extends JpaDaoSupport implements
		MatriculaTurmaRepository {

	public MatriculaTurmaRepositoryImpl() {

	}

	public MatriculaTurma consultar(String matriculaAluno) throws Exception {
		MatriculaTurma matriculaTurma = (MatriculaTurma) getJpaTemplate().find(
				MatriculaTurma.class, String.valueOf(matriculaAluno));

		if (matriculaTurma == null) {
			throw new Exception("Nenhuma Matricula encontrada para a Turma!");
		}

		return matriculaTurma;
	}

	public void excluir(String matriculaAluno) throws Exception {
		getJpaTemplate().remove(this.consultar(matriculaAluno));

	}

	public void gravar(MatriculaTurma matriculaTurma) throws Exception {
		getJpaTemplate().persist(matriculaTurma);

	}

	public List<MatriculaTurma> consultar() throws Exception {
		List<MatriculaTurma> list = getJpaTemplate()
				.find("from MatriculaTurma");

		if (list.size() == 0) {
			throw new Exception("Nenhuma Matricula em Turma encontrada!");
		}
		return list;
	}

}
