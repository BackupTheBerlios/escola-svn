/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.AlunoNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;

/**
 * @author ailton
 *
 */
public class LocalAlunoService implements AlunoService {

	
	private AlunoNegocio alunoNegocio= null;
	
	
	public LocalAlunoService(AlunoNegocio alunoNegocio){
		this.alunoNegocio = alunoNegocio;
	}
	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService#consultar(long)
	 */
	public Aluno consultar(long id) throws Exception {
		return this.alunoNegocio.consultar(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService#consultar()
	 */
	public List<Aluno> consultar() throws Exception {
		return this.alunoNegocio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.alunoNegocio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno)
	 */
	public void gravar(Aluno aluno) throws Exception {
		this.alunoNegocio.gravar(aluno);
	}

}
