/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.repositorio.jpa.hibernate;


import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author ailton
 * 
 */
public class PreMatriculaDisciplinaRepositorioImpl extends JpaDaoSupport
		implements
		br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepositorio {

	
	public PreMatriculaDisciplinaRepositorioImpl() {
	
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepositorio#consultar(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepositorio#excluir(java.lang.String)
	 */
	public void excluir(String matriculaAluno) throws Exception {
		getJpaTemplate().remove(this.consultar(matriculaAluno));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepositorio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina)
	 */
	public void gravar(PreMatriculaDisciplina preMatricula) throws Exception {
		getJpaTemplate().persist(preMatricula);

	}

}
