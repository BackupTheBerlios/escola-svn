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

	private AlunoNegocio alunoNegocio = null;

	public LocalAlunoService(AlunoNegocio alunoNegocio) {
		this.alunoNegocio = alunoNegocio;
	}

	public Aluno consultar(long id) throws Exception {
		return this.alunoNegocio.consultar(id);
	}

	public List<Aluno> consultar() throws Exception {
		return this.alunoNegocio.consultar();
	}

	public void excluir(long id) throws Exception {
		this.alunoNegocio.excluir(id);

	}

	public void gravar(Aluno aluno) throws Exception {
		this.alunoNegocio.gravar(aluno);
	}

}
