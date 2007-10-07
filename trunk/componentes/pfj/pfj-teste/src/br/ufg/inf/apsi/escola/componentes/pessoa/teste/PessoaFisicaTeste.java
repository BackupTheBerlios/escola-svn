/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoLogradouro;



/**
 * Classe de teste para a classe PessoaFisica.
 * @authors João Marcos e Gilmar
 *
 */
public class PessoaFisicaTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		PessoaFisica pf = new PessoaFisica();
		assertEquals("Pessoa Fisica", pf.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#PessoaFisica()}.
	 */
	@Test
	public void testPessoaFisica() {
		Pessoa p = new PessoaFisica();
		p.setNome("nome");
		assertEquals("nome", p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#PessoaFisica(java.lang.String)}.
	 */
	@Test
	public void testPessoaFisicaString() {
		Pessoa p = new PessoaFisica("nome");
		assertEquals("nome", p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#getDataNascimento()}.
	 */
	@Test
	public void testGetDataNascimento() {
		PessoaFisica pf = new PessoaFisica();
		pf.setDataNascimento(new Date());
		Date esperado = new Date();
		assertEquals(esperado, pf.getDataNascimento());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#setDataNascimento(java.util.Date)}.
	 */
	@Test
	public void testSetDataNascimento() {
		PessoaFisica pf = new PessoaFisica();
		pf.setDataNascimento(new Date());
		Date esperado = new Date();
		assertEquals(esperado, pf.getDataNascimento());
	}


	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#getSexo()}.
	 */
	@Test
	public void testGetSexo() {
		PessoaFisica pf = new PessoaFisica();
		pf.setSexo("F");
		assertEquals("F", pf.getSexo());		
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#setSexo(char)}.
	 */
	@Test
	public void testSetSexo() {
		PessoaFisica pf = new PessoaFisica();
		pf.setSexo("F");
		assertEquals("F", pf.getSexo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#getNacionalidade()}.
	 */
	@Test
	public void testGetNacionalidade() {
		PessoaFisica p = new PessoaFisica();
		p.setNacionalidade("Brasileira");
		assertEquals("Brasileira", p.getNacionalidade());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#setNacionalidade(java.lang.String)}.
	 */
	@Test
	public void testSetNacionalidade() {
		PessoaFisica p = new PessoaFisica();
		p.setNacionalidade("Brasileira");
		assertEquals("Brasileira", p.getNacionalidade());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#getNaturalidade()}.
	 */
	@Test
	public void testGetNaturalidade() {
		PessoaFisica p = new PessoaFisica();
		p.setNaturalidade("Itumbiara");
		assertEquals("Itumbiara", p.getNaturalidade());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#setNaturalidade(java.lang.String)}.
	 */
	@Test
	public void testSetNaturalidade() {
		PessoaFisica p = new PessoaFisica();
		p.setNaturalidade("Itumbiara");
		assertEquals("Itumbiara", p.getNaturalidade());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica#toString()}.
	 */
	@Test
	public void testToString() {
		Date dataNascimento = new Date();
		PessoaFisica pf = new PessoaFisica("Fulano Detall");
		Documento doc = new CPF("33462461168", pf);
		List<Documento> listaDocumentos = new ArrayList<Documento>();
		listaDocumentos.add(doc);
		pf.setSexo("M");
		pf.setDataNascimento(dataNascimento);
		Email email = new Email("fulano@mail.com");
		List<Email> listaEmail = new ArrayList<Email>();
		listaEmail.add(email);
		pf.setListaEmails(listaEmail);
		long numeroTelefone = 32212321;
		Telefone telefone = new Telefone(numeroTelefone);
		List<Telefone> listaTelelefones = new ArrayList<Telefone>();
		listaTelelefones.add(telefone);
		pf.setListaTelefones(listaTelelefones);
		Endereco end = new Endereco();
		TipoEndereco tpEnd = TipoEndereco.RESIDENCIAL;
		end.setTipo(tpEnd);
		TipoLogradouro tplog = TipoLogradouro.ALAMEDA;
		Logradouro log = new Logradouro("Botafogo");
		log.setTipo(tplog);
		end.setLogradouro(log);
		Bairro bairro = new Bairro("Jardim Guanabara");
		Cidade cidade = new Cidade("Goiânia");
		bairro.setCidade(cidade);
		Pais pais = new Pais("Brasil");
		Estado estado = new Estado("Goiás","GO");
		cidade.setEstado(estado);
		estado.setPais(pais);
		end.setNumero("557");
		end.setComplemento("Apto 111");
		Integer cep = 74000110;
		end.setCep(cep);
		String esperado =
		"Nome.................: " + pf.getNome() + "\n" +
		"Tipo.................: " + pf.getTipo() + "\n" +
		"Sexo.................: " + pf.getSexo() + "\n" +
		"Data de Nascimento...: " + pf.getDataNascimento() + "\n" +
		"Nacionalidade........: " + pf.getNacionalidade() + "\n" +
		"Naturalidade.........: " + pf.getNaturalidade() + "\n" +
		"Email(s).............: " + pf.getListaEmails().toString() + "\n" +
		"Telefones:" + "\n" +
		pf.getListaTelefones().toString() + "\n" + 
		"Enderecos:" + "\n" +
		pf.getListaEnderecos().toString() + "\n" +
		"Documentos:" + "\n" +
		pf.getListaDocumentos().toString() + "\n";
			
		assertEquals(esperado, pf.toString());	
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#Pessoa()}.
	 */
	@Test
	public void testPessoa() {
		String nome = "Ana Paula de Oliveira";
		Pessoa p = new PessoaFisica();
		p.setNome(nome);
		assertEquals(nome, p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#Pessoa(java.lang.String)}.
	 */
	@Test
	public void testPessoaString() {
		Pessoa p = new PessoaFisica("Ana Paula de Oliveira");
		assertEquals("Ana Paula de Oliveira", p.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#getId()}.
	 */
	@Test
	public void testGetId() {
		Pessoa p = new PessoaFisica();
		p.setId(1L);
		assertSame(1L, p.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setId(java.lang.Long)}.
	 */
	@Test
	public void testSetId() {
		Pessoa p = new PessoaFisica();
		p.setId(1L);
		assertSame(1L, p.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#getListaEmails()}.
	 */
	@Test
	public void testGetListaEmails() {
		PessoaFisica pf = new PessoaFisica();
		List<Email> listaEmails = new ArrayList<Email>();
		pf.setListaEmails(listaEmails);
		assertEquals(listaEmails, pf.getListaEmails());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setListaEmails(java.util.Set)}.
	 */
	@Test
	public void testSetListaEmails() {
		PessoaFisica pf = new PessoaFisica();
		List<Email> listaEmails = new ArrayList<Email>();
		pf.setListaEmails(listaEmails);
		assertEquals(listaEmails, pf.getListaEmails());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#getListaEnderecos()}.
	 */
	@Test
	public void testGetListaEnderecos() {
		Pessoa p = new PessoaJuridica();
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		p.setListaEnderecos(listaEnderecos);
		assertEquals(listaEnderecos, p.getListaEnderecos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setListaEnderecos(java.util.List)}.
	 */
	@Test
	public void testSetListaEnderecos() {
		Pessoa p = new PessoaJuridica();
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		p.setListaEnderecos(listaEnderecos);
		assertEquals(listaEnderecos, p.getListaEnderecos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#getNome()}.
	 */
	@Test
	public void testGetNome() {
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Fulano Detall");
		assertEquals("Fulano Detall", pf.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Fulano Detall");
		assertEquals("Fulano Detall", pf.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#getListaTelefones()}.
	 */
	@Test
	public void testGetListaTelefones() {
		Pessoa p = new PessoaFisica();
		List<Telefone> telefones = new ArrayList<Telefone>();
		p.setListaTelefones(telefones);
		assertEquals(telefones, p.getListaTelefones());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setListaTelefones(java.util.Set)}.
	 */
	@Test
	public void testSetListaTelefones() {
		Pessoa p = new PessoaFisica();
		List<Telefone> telefones = new ArrayList<Telefone>();
		p.setListaTelefones(telefones);
		assertEquals(telefones, p.getListaTelefones());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setTipo(java.lang.String)}.
	 */
	@Test
	public void testSetTipo() {
		Pessoa p = new PessoaFisica();
		p.setTipo("Pessoa Fisica");
		assertEquals("Pessoa Fisica", p.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#getListaDocumentos()}.
	 */
	@Test
	public void testGetListaDocumentos() {
		Pessoa p = new PessoaFisica();
		List<Documento> listaDocumentos = new ArrayList<Documento>();
		p.setListaDocumentos(listaDocumentos);
		assertEquals(listaDocumentos, p.getListaDocumentos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setListaDocumentos(java.util.List)}.
	 */
	@Test
	public void testSetListaDocumentos() {
		Pessoa p = new PessoaFisica();
		List<Documento> listaDocumentos = new ArrayList<Documento>();
		p.setListaDocumentos(listaDocumentos);
		assertEquals(listaDocumentos, p.getListaDocumentos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa#setListas()}.
	 */
	@Test
	public void testSetListas() {
		Pessoa pf = new PessoaFisica();
		Email email = new Email("meu@mail.com");
		pf.getListaEmails().add(email);
		Telefone t = new Telefone(32221122);
		pf.getListaTelefones().add(t);
		assertTrue(!pf.getListaEmails().isEmpty());
		assertTrue(!pf.getListaTelefones().isEmpty());
	}

}
