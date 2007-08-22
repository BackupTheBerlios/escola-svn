/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;


/**
 * Classe de Teste para a Classe Cidade.
 * @authors João Marcos e Gilmar
 *
 */
public class CidadeTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#Cidade()}.
	 */
	@Test
	public void testCidade() {
		Cidade c = new Cidade();
		c.setNome("Goiânia");
		String nomeCidade = "Goiânia";
		assertEquals(nomeCidade, c.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#Cidade(java.lang.String)}.
	 */
	@Test
	public void testCidadeString() {
		Cidade c = new Cidade("Goiânia");
		assertEquals("Goiânia", c.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#Cidade(java.lang.String, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado)}.
	 */
	@Test
	public void testCidadeStringEstado() {
		Estado go = new Estado();
		go.setSigla("GO");
		Cidade c = new Cidade();
		c.setNome("Goiânia");
		c.setEstado(go);
		assertEquals(go.getSigla(), c.getEstado().getSigla());
		
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#getId()}.
	 */
	@Test
	public void testGetId() {
		Cidade c = new Cidade();
		long cidadeId = 1;
		c.setId(cidadeId);
		assertEquals(cidadeId, c.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#setId(long)}.
	 */
	@Test
	public void testSetId() {
		Cidade c = new Cidade();
		long cidadeId = 1;
		c.setId(cidadeId);
		assertEquals(cidadeId, c.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#getEstado()}.
	 */
	@Test
	public void testGetEstado() {
		Cidade c = new Cidade();
		Estado e = new Estado();
		e.setSigla("GO");
		c.setEstado(e);
		String siglaEstado = "GO";
		assertEquals(siglaEstado, c.getEstado().getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#setEstado(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado)}.
	 */
	@Test
	public void testSetEstado() {
		Cidade c = new Cidade();
		Estado e = new Estado();
		e.setSigla("GO");
		c.setEstado(e);
		String siglaEstado = "GO";
		assertEquals(siglaEstado, c.getEstado().getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#getNome()}.
	 */
	@Test
	public void testGetNome() {
		Cidade c = new Cidade();
		String nomeCidade = "Buriti Alegre";
		c.setNome(nomeCidade);
		assertEquals(nomeCidade, c.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		Cidade c = new Cidade();
		String nomeCidade = "Buriti Alegre";
		c.setNome(nomeCidade);
		assertEquals(nomeCidade, c.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#getListaBairros()}.
	 */
	@Test
	public void testGetListaBairros() {
		Cidade c = new Cidade();
		List<Bairro> listaBairros = new ArrayList<Bairro>();
		c.setListaBairros(listaBairros);
		assertEquals(listaBairros, c.getListaBairros());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#setListaBairros(java.util.List)}.
	 */
	@Test
	public void testSetListaBairros() {
		Cidade c = new Cidade();
		List<Bairro> listaBairros = new ArrayList<Bairro>();
		c.setListaBairros(listaBairros);
		assertEquals(listaBairros, c.getListaBairros());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade#toString()}.
	 */
	@Test
	public void testToString() {
		Cidade c = new Cidade("Buriti Alegre");
		Pais p = new Pais("Brasil");
		Estado e = new Estado("GOIAS","GO", p);
		c.setEstado(e);
		String esperado = "Cidade...............: " + c.getNome() + "\n" +
						  "Estado...............: " + e.getNome() + "(" + e.getSigla() + ")" + "\n" +
						  "País.................: " + p.getNome();
		assertEquals(esperado, c.toString());
	}

}
