package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.TurmaNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;

/**
 * @author Fernando Nery Barros
 * 
 */
public class LocalTurmaService implements TurmaService {

	private TurmaNegocio turmaNegocio = null;

	public LocalTurmaService(TurmaNegocio turmaNegocio) {
		this.turmaNegocio = turmaNegocio;
	}

	public List<Turma> consultar() throws Exception {
		return this.turmaNegocio.consultar();
	}

	public Turma consultar(String codigoTurma) throws Exception {
		return this.turmaNegocio.consultar(codigoTurma);
	}

	public void excluir(String codigoTurma) throws Exception {
		this.turmaNegocio.excluir(codigoTurma);

	}

	public void gravar(Turma turma) throws Exception {
		this.turmaNegocio.gravar(turma);
	}

}
