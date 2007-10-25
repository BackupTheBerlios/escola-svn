/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.MatriculaTurmaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.MatriculaTurmaRepositorio;

/**
 * @author ailton
 *
 */
public class MatriculaTurmaNegocioBean implements MatriculaTurmaNegocio {

	
	private MatriculaTurmaRepositorio matriculaTurmaRepositorio = null;
	
	
	public MatriculaTurmaNegocioBean(MatriculaTurmaRepositorio matriculaTurmaRepositorio){
		this.matriculaTurmaRepositorio = matriculaTurmaRepositorio;
		
	}
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.MatriculaTurmaNegocio#consultar(java.lang.String)
	 */
	public MatriculaTurma consultar(String matriculaAluno) throws Exception {
		return this.matriculaTurmaRepositorio.consultar(matriculaAluno);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.MatriculaTurmaNegocio#excluir(java.lang.String)
	 */
	public void excluir(String matriculaAluno) throws Exception {
		this.matriculaTurmaRepositorio.excluir(matriculaAluno);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.MatriculaTurmaNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma)
	 */
	public void gravar(MatriculaTurma matricula) throws Exception {
		
		this.matriculaTurmaRepositorio.gravar(matricula);

	}


	public List<MatriculaTurma> consultar() throws Exception {
		return this.matriculaTurmaRepositorio.consultar();
	}

}
