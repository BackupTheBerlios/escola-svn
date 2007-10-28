/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepository;

/**
 * @author ailton
 * 
 */
public class AlunoNegocioBean implements AlunoNegocio {

	private AlunoRepository alunoRepositorio = null;

	public AlunoNegocioBean(AlunoRepository alunoRepositorio) {
		this.alunoRepositorio = alunoRepositorio;

	}

	public Aluno consultar(long id) throws Exception {
		return alunoRepositorio.consultar(id);
	}

	public List<Aluno> consultar() throws Exception {
		return alunoRepositorio.consultar();
	}

	public void excluir(long id) throws Exception {
		alunoRepositorio.excluir(id);

	}

	public void gravar(Aluno aluno) throws Exception {
		alunoRepositorio.gravar(aluno);

	}

	public Aluno consultar(String numeroMatricula) throws Exception {
		return alunoRepositorio.consultar(numeroMatricula);
	}

}
