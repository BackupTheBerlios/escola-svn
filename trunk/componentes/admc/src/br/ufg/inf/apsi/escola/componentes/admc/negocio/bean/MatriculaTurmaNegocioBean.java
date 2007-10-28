/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.MatriculaTurmaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepository;

/**
 * @author ailton
 * 
 */
public class MatriculaTurmaNegocioBean implements MatriculaTurmaNegocio {

	private MatriculaTurmaRepository matriculaTurmaRepositorio = null;

	public MatriculaTurmaNegocioBean(
			MatriculaTurmaRepository matriculaTurmaRepositorio) {
		this.matriculaTurmaRepositorio = matriculaTurmaRepositorio;

	}

	public MatriculaTurma consultar(String matriculaAluno) throws Exception {
		return this.matriculaTurmaRepositorio.consultar(matriculaAluno);
	}

	public void excluir(String matriculaAluno) throws Exception {
		this.matriculaTurmaRepositorio.excluir(matriculaAluno);

	}

	public void gravar(MatriculaTurma matricula) throws Exception {
		this.matriculaTurmaRepositorio.gravar(matricula);

	}

	public List<MatriculaTurma> consultar() throws Exception {
		return this.matriculaTurmaRepositorio.consultar();
	}

}
