/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;


/**
 * Classe de teste para a classe CPF.
 * @authors João Marcos e Gilmar
 *
 */
public class CPFTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF#validar(java.lang.String)}.
	 */
	@Test
	public void testValidar() {
		CPF cpf = new CPF();
		assertTrue(cpf.validar("64817350172"));
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		CPF cpf = new CPF();
		cpf.setNumero("64817350172");
		assertEquals("CPF", cpf.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF#CPF()}.
	 */
	@Test
	public void testCPF() {
		Documento doc = new CPF();
		assertEquals("CPF", doc.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF#CPF(java.lang.String)}.
	 */
	@Test
	public void testCPFStringPessoa() {
		Pessoa p = new PessoaFisica();
		Documento doc = new CPF("64817350172", p);
		assertEquals("CPF", doc.getTipo());
	}

}
