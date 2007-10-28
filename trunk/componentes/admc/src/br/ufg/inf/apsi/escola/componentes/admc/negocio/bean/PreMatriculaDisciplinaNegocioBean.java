/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.PreMatriculaDisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.PreMatriculaDisciplinaRepository;

/**
 * @author ailton
 * 
 */
public class PreMatriculaDisciplinaNegocioBean implements
		PreMatriculaDisciplinaNegocio {

	private PreMatriculaDisciplinaRepository preMatricula = null;

	public PreMatriculaDisciplinaNegocioBean(
			PreMatriculaDisciplinaRepository preMatriculaRepositorio) {
		this.preMatricula = preMatriculaRepositorio;
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

	public List<PreMatriculaDisciplina> consultar() throws Exception {
		return this.preMatricula.consultar();
	}

}
