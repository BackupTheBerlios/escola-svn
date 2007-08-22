/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;


/**
 * Classe de teste para a classe Email.
 * @authors João Marcos e Gilmar
 *
 */
public class EmailTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#Email()}.
	 */
	@Test
	public void testEmail() {
		Email email = new Email();
		email.setId(1L);
		assertEquals(1L, email.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#Email(java.lang.String)}.
	 */
	@Test
	public void testEmailString() {
		Email email = new Email("meu@mail.com.br");
		assertEquals("meu@mail.com.br", email.getEmail());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		Email email = new Email();
		email.setEmail("meu@mail.com.br");
		assertEquals("meu@mail.com.br", email.getEmail());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmail() {
		Email email = new Email();
		email.setEmail("meu@mail.com.br");
		assertEquals("meu@mail.com.br", email.getEmail());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#getId()}.
	 */
	@Test
	public void testGetId() {
		Email email = new Email();
		email.setId(1L);
		long id = 1;
		assertEquals(id, email.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#setId(long)}.
	 */
	@Test
	public void testSetId() {
		Email email = new Email();
		email.setId(1L);
		long id = 1;
		assertEquals(id, email.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#getTitularEmail()}.
	 */
	@Test
	public void testGetTitularEmail() {
		Email email = new Email("alguem@provedor.com.br");
		Pessoa p = new PessoaFisica("Nome");
		email.setTitularEmail(p);
		assertEquals("Nome", email.getTitularEmail().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#setTitularEmail(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa)}.
	 */
	@Test
	public void testSetTitularEmail() {
		Email email = new Email("alguem@provedor.com.br");
		Pessoa p = new PessoaFisica("Nome");
		email.setTitularEmail(p);
		assertEquals("Nome", email.getTitularEmail().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#validar(java.lang.String)}.
	 */
	@Test
	public void testValidar() {
		Email email = new Email();
		assertTrue(email.validar("meu@email.com.br"));
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email#toString()}.
	 */
	@Test
	public void testToString() {
		Email email = new Email();
		email.setEmail("meu@mail.com.br");
		assertEquals("meu@mail.com.br", email.toString());
	}

}
