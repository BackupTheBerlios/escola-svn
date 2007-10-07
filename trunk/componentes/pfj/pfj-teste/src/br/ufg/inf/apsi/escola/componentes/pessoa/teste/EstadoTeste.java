/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;


/**
 * Classe de teste para a classe Estado
 * @authors João Marcos e Gilmar
 *
 */
public class EstadoTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#Estado()}.
	 */
	@Test
	public void testEstado() {
		Estado go = new Estado();
		go.setSigla("GO");
		String siglaEstado = "GO";
		assertEquals(siglaEstado, go.getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#Estado(java.lang.String)}.
	 */
	@Test
	public void testEstadoString() {
		Estado est = new Estado("GO");
		assertEquals("GO", est.getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#Estado(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testEstadoStringString() {
		Estado est = new Estado("GO","Goiás");
		assertEquals("GO", est.getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#Estado(java.lang.String, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais)}.
	 */
	@Test
	public void testEstadoStringPais() {
		Pais p = new Pais();
		Estado est = new Estado("GO","Goiás",p);
		assertEquals("GO", est.getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#Estado(java.lang.String, java.lang.String, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais)}.
	 */
	@Test
	public void testEstadoStringStringPais() {
		Pais p = new Pais("Brasil");
		Estado go = new Estado("GO","GOIAS",p);
		String nomePais = "Brasil";
		assertEquals(nomePais, go.getPais().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#getId()}.
	 */
	@Test
	public void testGetId() {
		Estado estado = new Estado();
		estado.setId(1L);
		assertSame(1L, estado.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#setId(java.lang.Long)}.
	 */
	@Test
	public void testSetId() {
		Estado estado = new Estado();
		estado.setId(1L);
		assertSame(1L, estado.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#getNome()}.
	 */
	@Test
	public void testGetNome() {
		Estado go = new Estado();
		go.setNome("GOIAS");
		String nomeEstado = "GOIAS";
		assertEquals(nomeEstado, go.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		Estado go = new Estado();
		go.setNome("GOIAS");
		String nomeEstado = "GOIAS";
		assertEquals(nomeEstado, go.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#getPais()}.
	 */
	@Test
	public void testGetPais() {
		Pais p = new Pais("Brasil");
		Estado go = new Estado("GO","GOIAS",p);
		String nomePais = "Brasil";
		assertEquals(nomePais, go.getPais().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#setPais(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais)}.
	 */
	@Test
	public void testSetPais() {
		Pais p = new Pais("Brasil");
		Estado go = new Estado();
		go.setPais(p);
		String nomePais = "Brasil";
		assertEquals(nomePais, go.getPais().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#getSigla()}.
	 */
	@Test
	public void testGetSigla() {
		Estado go = new Estado();
		go.setSigla("GO");
		String siglaEstado = "GO";
		assertEquals(siglaEstado, go.getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#setSigla(java.lang.String)}.
	 */
	@Test
	public void testSetSigla() {
		Estado go = new Estado();
		go.setSigla("GO");
		String siglaEstado = "GO";
		assertEquals(siglaEstado, go.getSigla());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#getListaCidades()}.
	 */
	@Test
	public void testGetListaCidades() {
		Estado estado = new Estado();
		List<Cidade> cidades = new ArrayList<Cidade>();
		estado.setListaCidades(cidades);
		assertEquals(cidades, estado.getListaCidades());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#setListaCidades(java.util.List)}.
	 */
	@Test
	public void testSetListaCidades() {
		Estado estado = new Estado();
		List<Cidade> cidades = new ArrayList<Cidade>();
		estado.setListaCidades(cidades);
		assertEquals(cidades, estado.getListaCidades());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado#toString()}.
	 */
	@Test
	public void testToString() {
		Pais p = new Pais("Brasil");
		Estado go = new Estado("GO","GOIAS",p);
		go.setPais(p);
		String estadoPais =
					"Estado...............: " + go.getNome() + "(" + go.getSigla() + ")" + "\n" +
				    "País.................: " + p.getNome();
		assertEquals(estadoPais, go.toString());
	}

}
