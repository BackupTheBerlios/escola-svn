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
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;


/**
 * Classe de teste para a classe Bairro
 * @author João Marcos e Gilmar.
 *
 */
public class BairroTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#Bairro()}.
	 */
	@Test
	public void testBairro() {
		Bairro b = new Bairro();
		b.setNome("Sul");
		String nomeBairro = "Sul";
		assertEquals(nomeBairro, b.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#Bairro(java.lang.String)}.
	 */
	@Test
	public void testBairroString() {
		Bairro b1 = new Bairro("Setor Sul");
		String nomeBairro = "Setor Sul";
		assertEquals(nomeBairro, b1.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#Bairro(java.lang.String, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade)}.
	 */
	@Test
	public void testBairroStringCidade() {
		Cidade cidade = new Cidade("Goiânia");
		Bairro b = new Bairro("Setor Sul", cidade);
		assertEquals("Goiânia", b.getCidade().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#getId()}.
	 */
	@Test
	public void testGetId() {
		Bairro b2 = new Bairro();
		b2.setId(1L);
		long bairroId = 1;
		assertEquals(bairroId, b2.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#setId()}.
	 */
	@Test
	public void testSetId(){
		Bairro b3 = new Bairro();
		b3.setId(1L);
		long bairroId = 1;
		assertEquals(bairroId, b3.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#getNome()}.
	 */
	@Test
	public void testGetNome() {
		Bairro b4 = new Bairro();
		b4.setNome("Setor Oeste");
		String nomeBairro = "Setor Oeste";
		assertEquals(nomeBairro, b4.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		Bairro b5 = new Bairro();
		b5.setNome("Setor Bueno");
		String nomeBairro = "Setor Bueno";
		assertEquals(nomeBairro, b5.getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#getCidade()}.
	 */
	@Test
	public void testGetCidade() {
		Cidade cidade = new Cidade("Goiânia");
		Bairro b = new Bairro("Setor Sul", cidade);
		assertEquals("Goiânia", b.getCidade().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#setCidade(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade)}.
	 */
	@Test
	public void testSetCidade() {
		Cidade cidade = new Cidade("Goiânia");
		Bairro b = new Bairro("Setor Sul");
		b.setCidade(cidade);
		assertEquals("Goiânia", b.getCidade().getNome());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#getListaEnderecos()}.
	 */
	@Test
	public void testGetListaEnderecos() {
		Bairro b = new Bairro();
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		b.setListaEnderecos(listaEnderecos);
		assertEquals(listaEnderecos, b.getListaEnderecos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#setListaEnderecos(java.util.List)}.
	 */
	@Test
	public void testSetListaEnderecos() {
		Bairro b = new Bairro();
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		b.setListaEnderecos(listaEnderecos);
		assertEquals(listaEnderecos, b.getListaEnderecos());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro#toString()}.
	 */
	@Test
	public void testToString() {
		Bairro b5 = new Bairro();
		b5.setNome("Setor Nova Suiça");
		String nomeBairro = "Setor Nova Suiça";
		assertEquals(nomeBairro, b5.getNome());
	}

}
