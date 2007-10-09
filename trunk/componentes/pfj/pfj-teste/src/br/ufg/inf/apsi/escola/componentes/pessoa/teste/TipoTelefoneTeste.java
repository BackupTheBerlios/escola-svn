/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Classe de teste para a Enum TipoTelefone.
 * @author João Marcos e Gilmar.
 *
 */
public class TipoTelefoneTeste {
	/**
	 * 
	 */
	@Test
	public void TipoTelefone() {
		br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoTelefone tipo = br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoTelefone.FIXO;
		assertEquals(tipo, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoTelefone.FIXO);
	}
	

}
