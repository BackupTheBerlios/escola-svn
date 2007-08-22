/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Classe de teste para a Enum TipoEndereco
 * @authors João Marcos e Gilmar.
 *
 */
public class TipoEnderecoTeste {
	/**
	 * 
	 */
	@Test
	public void TipoEndereco() {
		br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco tipo = br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco.RESIDENCIAL;
		assertEquals(tipo, br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco.RESIDENCIAL );
	}

}
