package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.TurmaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;

/**
 * @author ailton
 *
 */
public class LocalTurmaService implements TurmaService {

	
	private TurmaNegocio turmaNegocio = null;
	
	public LocalTurmaService(TurmaNegocio turmaNegocio){
		this.turmaNegocio = turmaNegocio;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService#consultar()
	 */
	public List consultar() throws Exception {
		return this.turmaNegocio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService#consultar(java.lang.String)
	 */
	public Turma consultar(String codigoTurma) throws Exception {
		return this.turmaNegocio.consultar(codigoTurma);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService#excluir(java.lang.String)
	 */
	public void excluir(String codigoTurma) throws Exception {
		this.turmaNegocio.excluir(codigoTurma);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma)
	 */
	public void gravar(Turma turma) throws Exception {
		this.turmaNegocio.gravar(turma);

	}

}
