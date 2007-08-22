/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoTelefone;


/**
 * Classe de teste para a classe Telefone.
 * @author João Marcos e Gilmar
 *
 */
public class TelefoneTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#Telefone()}.
	 */
	@Test
	public void testTelefone() {
		Telefone t = new Telefone();
		t.setId(1L);
		assertEquals(1L, t.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#Telefone(long)}.
	 */
	@Test
	public void testTelefoneLong() {
		Telefone t = new Telefone(32997869);
		t.setId(1L);
		assertEquals(1L, t.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#Telefone(short, long)}.
	 */
	@Test
	public void testTelefoneShortLong() {
		short ddd = 62;
		Telefone t = new Telefone(ddd, 32997869);
		t.setId(1L);
		assertEquals(1L, t.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#Telefone(short, long, java.lang.String)}.
	 */
	@Test
	public void testTelefoneShortLongString() {
		short ddd = 62;
		Telefone t = new Telefone(ddd, 32997869,"CELULAR");
		t.setId(1L);
		assertEquals(1L, t.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#getDDD()}.
	 */
	@Test
	public void testGetDDD() {
		Telefone tel = new Telefone();
		short ddd = 62;
		tel.setDDD(ddd);
		assertEquals(ddd, tel.getDDD());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#setDDD(short)}.
	 */
	@Test
	public void testSetDDD() {
		Telefone tel = new Telefone();
		short ddd = 62;
		tel.setDDD(ddd);
		assertEquals(ddd, tel.getDDD());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#getId()}.
	 */
	@Test
	public void testGetId() {
		Telefone tel = new Telefone();
		tel.setId(1234L);
		assertEquals(1234L, tel.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#setId(long)}.
	 */
	@Test
	public void testSetId() {
		Telefone tel = new Telefone();
		tel.setId(1234L);
		assertEquals(1234L, tel.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#getNumero()}.
	 */
	@Test
	public void testGetNumero() {
		Telefone tel = new Telefone();
		long numero = 32211221;
		tel.setNumero(numero);
		assertEquals(numero, tel.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#setNumero(long)}.
	 */
	@Test
	public void testSetNumero() {
		Telefone tel = new Telefone();
		long numero = 32211221;
		tel.setNumero(numero);
		assertEquals(numero, tel.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		Telefone tel = new Telefone();
		tel.setTipo(TipoTelefone.FIXO);
		TipoTelefone esperado = TipoTelefone.FIXO;
		assertEquals(esperado, tel.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#setTipo(br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoTelefone)}.
	 */
	@Test
	public void testSetTipo() {
		Telefone tel = new Telefone();
		tel.setTipo(TipoTelefone.FIXO);
		TipoTelefone esperado = TipoTelefone.FIXO;
		assertEquals(esperado, tel.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#getPessoas()}.
	 */
	@Test
	public void testGetPessoas() {
		Telefone t = new Telefone();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		t.setPessoas(pessoas);
		assertEquals(pessoas, t.getPessoas());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#setPessoas(java.util.List)}.
	 */
	@Test
	public void testSetPessoas() {
		Telefone t = new Telefone();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		t.setPessoas(pessoas);
		assertEquals(pessoas, t.getPessoas());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone#toString()}.
	 */
	@Test
	public void testToString() {
		Telefone tel = new Telefone();
		short ddd = 62;
		tel.setDDD(ddd);
		tel.setNumero(32211221);
		tel.setTipo(TipoTelefone.FIXO);
		
		String esperado =
			"\t " + "DDD " + ddd + " \n" +
		    "\t " + "número " + 32211221 + " \n" +
		    "\t " + "Tipo " + "FIXO" + "\t\t\n";
		
		assertEquals(esperado, tel.toString());
	}

}
