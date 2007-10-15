/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.negocio.bean;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario;
import br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio;
import br.ufg.inf.apsi.escola.componentes.admc.repositorio.SecretarioRepositorio;

/**
 * @author ailton
 *
 */
public class SecretarioNegocioBean implements SecretarioNegocio {

	private SecretarioRepositorio secretarioRepositorio =null;
	
	
	public SecretarioNegocioBean(SecretarioRepositorio secretarioRepositorio){
		this.secretarioRepositorio = secretarioRepositorio;
	}
	
	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio#consultar(long)
	 */
	public Secretario consultar(long id) throws Exception {
		return this.secretarioRepositorio.consultar(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio#consultar()
	 */
	public List<Secretario> consultar() throws Exception {
		return this.secretarioRepositorio.consultar();
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio#consultar(java.lang.String)
	 */
	public Secretario consultar(String numeroMatricula) throws Exception {
		return this.secretarioRepositorio.consultar(numeroMatricula);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio#excluir(long)
	 */
	public void excluir(long id) throws Exception {
		this.secretarioRepositorio.excluir(id);

	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.admc.negocio.SecretarioNegocio#gravar(br.ufg.inf.apsi.escola.componentes.admc.modelo.Secretario)
	 */
	public void gravar(Secretario secretario) throws Exception {
		this.secretarioRepositorio.gravar(secretario);

	}

}
