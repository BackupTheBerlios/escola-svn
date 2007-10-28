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

	private SecretarioNegocio secretarioNegocio = null;

	public LocalSecretarioService(SecretarioNegocio secretarioNegocio) {
		this.secretarioNegocio = secretarioNegocio;
	}

	public Secretario consultar(long id) throws Exception {
		return this.secretarioNegocio.consultar(id);
	}

	public List<Secretario> consultar() throws Exception {
		return this.secretarioNegocio.consultar();
	}

	public void excluir(long id) throws Exception {
		this.secretarioNegocio.excluir(id);

	}

	public void gravar(Secretario secretario) throws Exception {
		this.secretarioNegocio.gravar(secretario);
	}

}
