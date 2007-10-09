/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * Classe de teste para a Enum TipoLogradouro.
 * @author João Marcos e Gilmar.
 *
 */
public class TipoLogradouroTeste {
	/**
	 * 
	 */
	@Test
	public void TipoLogradouro() {
		br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoLogradouro tipo = br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoLogradouro.AVENIDA;
		assertEquals(tipo, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoLogradouro.AVENIDA);
	}

}
