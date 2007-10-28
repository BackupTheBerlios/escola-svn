/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepository;

/**
 * @author ailton
 * 
 */
public class SecretarioNegocioBean implements SecretarioNegocio {

	private SecretarioRepository secretarioRepositorio = null;

	public SecretarioNegocioBean(SecretarioRepository secretarioRepositorio) {
		this.secretarioRepositorio = secretarioRepositorio;
	}

	public Secretario consultar(long id) throws Exception {
		return this.secretarioRepositorio.consultar(id);
	}

	public List<Secretario> consultar() throws Exception {
		return this.secretarioRepositorio.consultar();
	}

	public Secretario consultar(String numeroMatricula) throws Exception {
		return this.secretarioRepositorio.consultar(numeroMatricula);
	}

	public void excluir(long id) throws Exception {
		this.secretarioRepositorio.excluir(id);

	}

	public void gravar(Secretario secretario) throws Exception {
		this.secretarioRepositorio.gravar(secretario);
	}

}
