/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DisciplinaService;

/**
 * @author ailton
 * 
 */
public class LocalDisciplinaService implements DisciplinaService {

	private DisciplinaNegocio disciplinaNegocio = null;

	public LocalDisciplinaService(DisciplinaNegocio disciplinaNegocio) {
		this.disciplinaNegocio = disciplinaNegocio;
	}

	public Disciplina consultar(long id) throws Exception {
		return this.disciplinaNegocio.consultar(id);
	}

	public void excluir(long id) throws Exception {
		this.disciplinaNegocio.excluir(id);

	}

	public void gravar(Disciplina disciplina) throws Exception {
		this.disciplinaNegocio.gravar(disciplina);
	}

	public List<Disciplina> consultar() throws Exception {
		return this.disciplinaNegocio.consultar();
	}

}
