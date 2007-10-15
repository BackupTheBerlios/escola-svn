/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService;

/**
 * @author ailton
 *
 */
public class LocalSecretarioService implements SecretarioService {

	private SecretarioNegocio secretarioNegocio=null;
	
	
	public LocalSecretarioService(SecretarioNegocio secretarioNegocio){
		this.secretarioNegocio = secretarioNegocio;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService#consultar(long)
	 */
	public Secretario consultar(long id) throws Exception {
		return this.secretarioNegocio.consultar(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService#consultar()
	 */
	public List<Secretario> consultar() throws Exception {
		return this.secretarioNegocio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.secretarioNegocio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario)
	 */
	public void gravar(Secretario secretario) throws Exception {
		this.secretarioNegocio.gravar(secretario);

	}

}
