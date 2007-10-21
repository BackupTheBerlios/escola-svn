/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoLogradouro;


/**
 * Classe de teste para a classe Logradouro.
 * @authors João Marcos e Gilmar
 *
 */
public class LogradouroTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#Logradouro()}.
	 */
	@Test
	public void testLogradouro() {
		Logradouro log = new Logradouro();
		log.setId(1L);
		assertSame(1L, log.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#Logradouro(java.lang.String)}.
	 */
	@Test
	public void testLogradouroString() {
		Logradouro log = new Logradouro("Rua");;
		assertEquals("Rua", log.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#Logradouro(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogradouroStringString() {
		Logradouro log = new Logradouro("RUA","Conde dos Arcos");
		String tipoLogradouro = "RUA";
		assertEquals(tipoLogradouro, log.getTipo().toString());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#getId()}.
	 */
	@Test
	public void testGetId() {
		Logradouro log = new Logradouro();
		log.setId(1L);
		assertSame(1L, log.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#setId(Long)}.
	 */
	@Test
	public void testSetId() {
		Logradouro log = new Logradouro();
		log.setId(1L);
		assertSame(1L, log.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#getNome()}.
	 */
	@Test
	public void testGetNome() {
		Logradouro log = new Logradouro();
		log.setNome("Conde dos Arcos");
		assertEquals("Conde dos Arcos", log.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		Logradouro log = new Logradouro();
		log.setNome("Conde dos Arcos");
		assertEquals("Conde dos Arcos", log.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		Logradouro log = new Logradouro();
		TipoLogradouro tl = TipoLogradouro.RUA;
		log.setTipo(tl);
		assertEquals(tl, log.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#setTipo(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoLogradouro)}.
	 */
	@Test
	public void testSetTipo() {
		Logradouro log = new Logradouro();
		TipoLogradouro tl = TipoLogradouro.RUA;
		log.setTipo(tl);
		assertEquals(tl, log.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#getListaEnderecos()}.
	 */
	@Test
	public void testGetListaEnderecos() {
		Logradouro log = new Logradouro();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		log.setListaEnderecos(enderecos);
		assertEquals(enderecos, log.getListaEnderecos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro#setListaEnderecos(java.util.List)}.
	 */
	@Test
	public void testSetListaEnderecos() {
		Logradouro log = new Logradouro();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		log.setListaEnderecos(enderecos);
		assertEquals(enderecos, log.getListaEnderecos());
	}
	/**
	 * 
	 *
	 */
	@Test
	public void testToString() {
		Logradouro log = new Logradouro("RUA", "Conde dos Arcos");
		String resultado = log.getTipo() + " " + log.getNome();
		assertEquals(resultado, log.toString());
	}

}
