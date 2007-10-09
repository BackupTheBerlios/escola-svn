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
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoEndereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoLogradouro;


/**
 * Classe de Teste para a classe PessoaJuridica.
 * @authors João Marcos e Gilmar
 *
 */
public class PessoaJuridicaTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		Pessoa p = new PessoaJuridica();
		assertEquals("Pessoa Juridica", p.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica#PessoaJuridica()}.
	 */
	@Test
	public void testPessoaJuridica() {
		Pessoa p = new PessoaJuridica();
		p.setId(2L);
		assertSame(2L, p.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica#PessoaJuridica(java.lang.String)}.
	 */
	@Test
	public void testPessoaJuridicaString() {
		Pessoa p = new PessoaJuridica("Armarinhos Brasl");
		assertEquals("Armarinhos Brasl", p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica#getNomeFantasia()}.
	 */
	public void testGetNomeFantasia() {
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNomeFantasia("Armação Ilimitada");
		assertEquals("Armação Ilimitada", pj.getNomeFantasia());
		
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica#setNomeFantasia(java.lang.String)}.
	 */
	public void testSetNomeFantasia() {
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNomeFantasia("Armação Ilimitada");
		assertEquals("Armação Ilimitada", pj.getNomeFantasia());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica#toString()}.
	 */
	public void testToString() {
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome("Empresa");
		pj.setNomeFantasia("Armação Ilimitada");
		Email e1 = new Email("meu@mail.com");
		List<Email> listaEmail = new ArrayList<Email>();
		listaEmail.add(e1);
		Telefone t1 = new Telefone(32211441);
		List<Telefone> listaTelefone = new ArrayList<Telefone>();
		listaTelefone.add(t1);
		Endereco endcom = new Endereco();
		Logradouro l2 = new Logradouro("R-2");
		TipoLogradouro tl2 = TipoLogradouro.RUA;
		Bairro b2 = new Bairro("Central");
		Cidade c2 = new Cidade("Goiânia", null);
		Estado estado = new Estado("Goiás","GO", null);
		Pais p2 = new Pais("Brasil");
		endcom.setTipo(TipoEndereco.COMERCIAL);
		l2.setTipo(tl2);
		endcom.setNumero("30");
		endcom.setComplemento("Loja 5");
		endcom.setCep(74000800);
		endcom.setLogradouro(l2);
		endcom.setBairro(b2);
		c2.setEstado(estado);
		estado.setPais(p2);
		
		String esperado =
			"Nome.................: " + "Empresa" + "\n" +
			"Nome de Fantasia.....: " + "Armação Ilimitada" + "\n" +
			"Tipo.................: " + "Pessoa Juridica" + "\n" +
			"Email(s).............: " + "meu@mail.com" + "\n" +
			"Telefones............: " + "\n" + 32211441 + "\n" +
			"Endereço.............: " + "\n" +
			"Tipo do Endereço.....: " + "COMERCIAL" + "\n" +
			"Logradouro...........: " + "RUA" + " " + "R-2" + "\n" +
			"Número...............: " + "30" + "\n" +
			"Complemento..........: " + "Loja 5" + "\n" +
			"Cep..................: " + 74000800 + "\n" +
			"Bairro...............: " + "Central" + "\n" +
			"Cidade...............: " + "Goiânia" + "\n" +
			"Estado...............: " + "Goiás" + "(" + "GO" + ")" + "\n" +
			"País.................: " + "Brasil" + "\n";
			
		assertEquals(esperado, pj.toString());
	}

}
