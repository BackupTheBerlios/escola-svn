/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;

/**
 * @author ailton
 * 
 */
public class PreMatriculaDisciplinaRepositoryImpl extends JpaDaoSupport
		implements
		br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepository {

	public PreMatriculaDisciplinaRepositoryImpl() {

	}

	public PreMatriculaDisciplina consultar(String matriculaAluno)
			throws Exception {
		PreMatriculaDisciplina preMatricula = (PreMatriculaDisciplina) getJpaTemplate()
				.find(PreMatriculaDisciplina.class,
						String.valueOf(matriculaAluno));

		if (preMatricula == null) {
			throw new Exception("Nenhuma Pre-Matricula foi encontrada!");
		}

		return preMatricula;
	}

	public void excluir(String matriculaAluno) throws Exception {
		getJpaTemplate().remove(this.consultar(matriculaAluno));

	}

	public void gravar(PreMatriculaDisciplina preMatricula) throws Exception {
		getJpaTemplate().persist(preMatricula);

	}

	public List<PreMatriculaDisciplina> consultar() throws Exception {
		List<PreMatriculaDisciplina> list = getJpaTemplate().find(
				"from PreMatriculaDisciplina");

		if (list.size() == 0) {
			throw new Exception("Nenhuma Pre-Matricula encontrada");
		}
		return list;
	}

}
