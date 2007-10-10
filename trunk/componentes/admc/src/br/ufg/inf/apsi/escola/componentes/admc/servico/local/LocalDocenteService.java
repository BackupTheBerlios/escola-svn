/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.DocenteNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;

/**
 * @author ailton
 *
 */
public class LocalDocenteService implements DocenteService {

	
	private DocenteNegocio docenteNegocio=null;
	
	public LocalDocenteService(DocenteNegocio docenteNegocio) {
		this.docenteNegocio= docenteNegocio;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService#consultar(long)
	 */
	public Docente consultar(long id) throws Exception {
		return this.docenteNegocio.consultar(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService#consultar()
	 */
	public List<Docente> consultar() throws Exception {
		return this.docenteNegocio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.docenteNegocio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente)
	 */
	public void gravar(Docente docente) throws Exception {
		this.docenteNegocio.gravar(docente);

	}

}
