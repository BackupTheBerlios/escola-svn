/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica;


/**
 * Classe de Teste para a classe CNPJ
 * @authors João Marcos e Gilmar
 *
 */
public class CnpjTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ#validar(java.lang.String)}.
	 */
	@Test
	public void testValidar() {
		CNPJ cnpj = new CNPJ();
		cnpj.setNumero("03314200000107") ;
		String numero = "03314200000107";
		cnpj.setNumero(numero);
		boolean resultado = true;
		assertEquals(resultado, cnpj.validar(numero));
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		CNPJ cnpj = new CNPJ();
		String tipo = "CNPJ";
		assertEquals(tipo, cnpj.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ#CNPJ()}.
	 */
	@Test
	public void testCNPJ() {
		CNPJ cnpj = new CNPJ();
		String numero = "03314200000107";
		cnpj.setNumero(numero);
		assertEquals(numero, cnpj.toString());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ#CNPJ(java.lang.String)}.
	 */
	@Test
	public void testCNPJStringPessoa() {
		Pessoa p = new PessoaJuridica();
		CNPJ cnpj = new CNPJ("03314200000107", p);
		String numero = "03314200000107";
		assertEquals(numero, cnpj.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#Documento()}.
	 */
	@Test
	public void testDocumento() {
		Documento d = new CNPJ();
		String numeroDocumento = "03314200000107";
		d.setNumero(numeroDocumento);
		assertEquals(numeroDocumento, d.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#Documento(java.lang.String)}.
	 */
	@Test
	public void testDocumentoStringPessoa() {
		Documento d = new CNPJ();
		d.setNumero("03314200000107");
		String numeroDocumento = "03314200000107";
		assertEquals(numeroDocumento, d.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#getId()}.
	 */
	@Test
	public void testGetId() {
		Documento doc = new CNPJ();
		doc.setId(1L);
		assertSame(1L,doc.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#setId(java.lang.Long)}.
	 */
	@Test
	public void testSetId() {
		Documento doc = new CNPJ();
		doc.setId(1L);
		assertSame(1L,doc.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#getNumero()}.
	 */
	@Test
	public void testGetNumero() {
		CNPJ cnpj = new CNPJ();
		cnpj.setNumero("03314200000107");
		String numero = "03314200000107";
		assertEquals(numero, cnpj.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#setNumero(java.lang.String)}.
	 */
	@Test
	public void testSetNumero() {
		CNPJ cnpj = new CNPJ();
		String numero = "03314200000107";
		cnpj.setNumero(numero);
		assertEquals(numero, cnpj.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#getTitular()}.
	 */
	@Test
	public void testGetTitular() {
		Documento doc = new CNPJ();
		Pessoa p = new PessoaFisica("nome");
		doc.setTitular(p);
		assertEquals("nome", doc.getTitular().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#setTitular(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa)}.
	 */
	@Test
	public void testSetTitular() {
		Documento doc = new CNPJ();
		Pessoa p = new PessoaFisica("nome");
		doc.setTitular(p);
		assertEquals("nome", doc.getTitular().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#toString()}.
	 */
	@Test
	public void testToString() {
		CNPJ cnpj = new CNPJ();
		String numero = "03314200000107";
		cnpj.setNumero(numero);
		assertEquals(numero, cnpj.toString());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#setTipo(java.lang.String)}.
	 */
	@Test
	public void testSetTipo() {
		Documento doc = new CNPJ();
		doc.setTipo("CNPJ");
		assertEquals("CNPJ", doc.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#getDocumento(java.lang.String, java.util.Date, java.lang.String)}.
	 */
	@Test
	public void testGetDocumento() {
		Documento doc = Documento.getDocumento("03314200000107", null, null);
		assertEquals("CNPJ", doc.getTipo());
	}

}
