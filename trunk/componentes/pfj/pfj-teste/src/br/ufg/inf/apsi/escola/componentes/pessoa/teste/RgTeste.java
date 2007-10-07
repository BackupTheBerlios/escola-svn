/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG;


import java.util.Date;

/**
 * Classe de teste para a classe RG.
 * @authors João Marcos e Gilmar
 *
 */
public class RgTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#RG()}.
	 */
	@Test
	public void testRG() {
		Documento rg = new RG();
		rg.setId(1L);
		assertSame(1L, rg.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#RG(java.lang.String, java.util.Date, java.lang.String)}.
	 */
	@Test
	public void testRGStringPessoaDateString() {
		Pessoa p = new PessoaFisica();
		Documento rg = new RG("12",p,new Date(), "go");
		assertEquals("12", rg.getNumero());
	}
	
	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#getDataEmissao()}.
	 */
	@Test
	public void testGetDataEmissao() {
		RG rg = new RG();
		rg.setDataEmissao(new Date());
		Date esperado = new Date();
		assertEquals(esperado, rg.getDataEmissao());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#setDataEmissao(java.util.Date)}.
	 */
	@Test
	public void testSetDataEmissao() {
		RG rg = new RG();
		rg.setDataEmissao(new Date());
		Date esperado = new Date();
		assertEquals(esperado, rg.getDataEmissao());
	}
	
	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#getOrgaoExpedidor()}.
	 */
	@Test
	public void testGetOrgaoExpedidor() {
		RG rg = new RG();
		rg.setOrgaoExpedidor("DGPC");
		assertEquals("DGPC", rg.getOrgaoExpedidor());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#setOrgaoExpedidor(java.lang.String)}.
	 */
	@Test
	public void testSetOrgaoExpedidor() {
		RG rg = new RG();
		rg.setOrgaoExpedidor("DGPC");
		assertEquals("DGPC", rg.getOrgaoExpedidor());
	}
	
	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		RG rg = new RG();
		assertEquals("RG", rg.getTipo());
	}
	
	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#toString()}.
	 */
	@Test
	public void testToString() {
		RG rg = new RG();
		rg.setNumero("1234567");
		rg.setDataEmissao(new Date());
		rg.setOrgaoExpedidor("DGPC");
		String esperado = "Dados do RG:" + "\n" +
						  "Numero...............: " + "1234567" + "\n" +
						  "Data Emissao.........: " + rg.getDataEmissao() + "\n" +
						  "Órgão Expedidor......: " + "DGPC" + "\n";
		assertEquals(esperado, rg.toString());
	}
	
	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG#validar(java.lang.String)}.
	 */
	@Test
	public void testValidar() {
		RG rg = new RG();
		assertTrue(rg.validar("12345678"));
	}

}
