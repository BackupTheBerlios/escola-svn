/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.AlunoRepositorio;

/**
 * @author ailton
 *
 */
public class AlunoNegocioBean implements AlunoNegocio {

	private AlunoRepositorio alunoRepositorio=null;
	
	
	public AlunoNegocioBean(AlunoRepositorio alunoRepositorio){
		this.alunoRepositorio = alunoRepositorio;
	}
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio#consultar(long)
	 */
	public Aluno consultar(long id) throws Exception {
		return alunoRepositorio.consultar(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio#consultar()
	 */
	public List<Aluno> consultar() throws Exception {
		return alunoRepositorio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		alunoRepositorio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno)
	 */
	public void gravar(Aluno aluno) throws Exception {
		alunoRepositorio.gravar(aluno);

	}
	public Aluno consultar(String numeroMatricula) throws Exception {
		return alunoRepositorio.consultar(numeroMatricula);
	}

}
