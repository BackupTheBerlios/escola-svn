/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.ProgramaDisciplinaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ProgramaDisciplinaService;

/**
 * @author ailton
 *
 */
public class LocalProgramaDisciplinaService implements
		ProgramaDisciplinaService {

	private ProgramaDisciplinaNegocio programaDisciplina = null;
	
	public LocalProgramaDisciplinaService(ProgramaDisciplinaNegocio programaDisciplina){
		this.programaDisciplina = programaDisciplina;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.ProgramaDisciplinaService#consultar(long)
	 */
	public ProgramaDisciplina consultar(long id) throws Exception {
		return this.programaDisciplina.consultar(id);
	}

	
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.ProgramaDisciplinaService#consultar()
	 */
	public List<ProgramaDisciplina> consultar() throws Exception {
		return this.programaDisciplina.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.ProgramaDisciplinaService#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.programaDisciplina.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.ProgramaDisciplinaService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina)
	 */
	public void gravar(ProgramaDisciplina programa) throws Exception {
		this.programaDisciplina.gravar(programa);

	}

}
