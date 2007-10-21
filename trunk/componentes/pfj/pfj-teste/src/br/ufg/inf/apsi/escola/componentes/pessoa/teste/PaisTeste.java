/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;


/**
 * Classe de teste para a classe Pais.
 * @authors João Marcos e Gilmar 
 *
 */
public class PaisTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#Pais()}.
	 */
	@Test
	public void testPais() {
		Pais brasil = new Pais();
		brasil.setNome("Brasil");
		assertEquals("Brasil", brasil.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#Pais(java.lang.String)}.
	 */
	@Test
	public void testPaisString() {
		Pais pais = new Pais("Brasil");
		assertEquals("Brasil", pais.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#getId()}.
	 */
	@Test
	public void testGetId() {
		Pais p = new Pais();
		p.setId(1L);
		assertSame(1L, p.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#setId(Long)}.
	 */
	@Test
	public void testSetId() {
		Pais p = new Pais();
		p.setId(1L);
		assertSame(1L, p.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#getNome()}.
	 */
	@Test
	public void testGetNome() {
		Pais p = new Pais();
		p.setNome("Brasil");
		assertEquals("Brasil", p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		Pais p = new Pais();
		p.setNome("Brasil");
		assertEquals("Brasil", p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#getListaEstados()}.
	 */
	@Test
	public void testGetListaEstados() {
		Pais pais = new Pais();
		List<Estado> estados = new ArrayList<Estado>();
		pais.setListaEstados(estados);
		assertEquals(estados, pais.getListaEstados());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#setListaEstados(java.util.List)}.
	 */
	@Test
	public void testSetListaEstados() {
		Pais pais = new Pais();
		List<Estado> estados = new ArrayList<Estado>();
		pais.setListaEstados(estados);
		assertEquals(estados, pais.getListaEstados());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais#toString()}.
	 */
	@Test
	public void testToString() {
		Pais p = new Pais("Brasil");
		assertEquals("Brasil", p.toString());
	}

}
