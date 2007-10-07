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
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoLogradouro;


/**
 * Classe de teste para a classe Endereco
 * @authors João Marcos e Gilmar
 *
 */
public class EnderecoTeste {

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#Endereco()}.
	 */
	@Test
	public void testEndereco() {
		Endereco end = new Endereco();
		end.setId(1L);
		assertSame(1L, end.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#Endereco(java.lang.String, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro, java.lang.String, java.lang.String, java.lang.Integer, br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro)}.
	 */
	@Test
	public void testEnderecoStringLogradouroStringStringIntegerBairro() {
		Logradouro log = new Logradouro("Rua das Paineiras");
		Bairro b = new Bairro();
		Endereco end = new Endereco("COMERCIAL", log, "125", "", 74093140, b);
		assertEquals("125", end.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getBairro()}.
	 */
	@Test
	public void testGetBairro() {
		Endereco e = new Endereco();
		Bairro b = new Bairro("Jardim Guanabara");
		e.setBairro(b);
		assertEquals(b, e.getBairro());
	}


	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setBairro(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro)}.
	 */
	@Test
	public void testSetBairro() {
		Endereco e = new Endereco();
		Bairro b = new Bairro("Jardim Guanabara");
		e.setBairro(b);
		assertEquals(b, e.getBairro());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getId()}.
	 */
	@Test
	public void testGetId() {
		Endereco e = new Endereco();
		e.setId(1L);
		assertSame(1L, e.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setId(long)}.
	 */
	@Test
	public void testSetId() {
		Endereco e = new Endereco();
		e.setId(1L);
		assertSame(1L, e.getId());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getCep()}.
	 */
	@Test
	public void testGetCep() {
		Endereco e = new Endereco();
		e.setCep(7400110);
		Integer i = 7400110;
		assertEquals(i, e.getCep());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setCep(java.lang.Integer)}.
	 */
	@Test
	public void testSetCep() {
		Endereco e = new Endereco();
		e.setCep(7400110);
		Integer i = 7400110;
		assertEquals(i, e.getCep());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getComplemento()}.
	 */
	@Test
	public void testGetComplemento() {
		Endereco e = new Endereco();
		e.setComplemento("Apto 111");
		assertEquals("Apto 111", e.getComplemento());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setComplemento(java.lang.String)}.
	 */
	@Test
	public void testSetComplemento() {
		Endereco e = new Endereco();
		e.setComplemento("Apto 111");
		assertEquals("Apto 111", e.getComplemento());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getLogradouro()}.
	 */
	@Test
	public void testGetLogradouro() {
		Endereco e = new Endereco();
		Logradouro l = new Logradouro("Alameda Botafogo");
		e.setLogradouro(l);
		assertEquals(l, e.getLogradouro());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setLogradouro(br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro)}.
	 */
	@Test
	public void testSetLogradouro() {
		Endereco e = new Endereco();
		Logradouro l = new Logradouro("Alameda Botafogo");
		e.setLogradouro(l);
		assertEquals(l, e.getLogradouro());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getNumero()}.
	 */
	@Test
	public void testGetNumero() {
		Endereco e = new Endereco();
		e.setNumero("557");
		assertEquals("557", e.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setNumero(java.lang.String)}.
	 */
	@Test
	public void testSetNumero() {
		Endereco e = new Endereco();
		e.setNumero("557");
		assertEquals("557", e.getNumero());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getTipo()}.
	 */
	@Test
	public void testGetTipo() {
		Endereco e = new Endereco();
		TipoEndereco te = TipoEndereco.RESIDENCIAL;
		e.setTipo(te);
		assertEquals(te, e.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setTipo(br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoEndereco)}.
	 */
	@Test
	public void testSetTipo() {
		Endereco e = new Endereco();
		TipoEndereco te = TipoEndereco.RESIDENCIAL;
		e.setTipo(te);
		assertEquals(te, e.getTipo());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#getPessoas()}.
	 */
	@Test
	public void testGetPessoas() {
		Endereco end = new Endereco();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		end.setPessoas(pessoas);
		assertEquals(pessoas, end.getPessoas());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#setPessoas(java.util.List)}.
	 */
	@Test
	public void testSetPessoas() {
		Endereco end = new Endereco();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		end.setPessoas(pessoas);
		assertEquals(pessoas, end.getPessoas());
	}

	/**
	 * Test method for {@link br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco#toString()}.
	 */
	@Test
	public void testToString() {
		Endereco end = new Endereco();
		TipoEndereco tpend = TipoEndereco.RESIDENCIAL;
		TipoLogradouro tplog = TipoLogradouro.ALAMEDA;
		Logradouro log = new Logradouro("Alameda Botafogo");
		Bairro bairro = new Bairro("Jardim Guanabara");
		Cidade cidade = new Cidade("Goiânia");
		Estado estado = new Estado("Goiás","GO");
		Pais pais = new Pais("Brasil");
		
		estado.setPais(pais);
		cidade.setEstado(estado);
		bairro.setCidade(cidade);
		log.setTipo(tplog);
		end.setBairro(bairro);
		end.setLogradouro(log);
		end.setTipo(tpend);
		end.setNumero("557");
		end.setComplemento("Apto 111");
		end.setCep(7400110);
		
		
		String esperado =
			"Tipo do Endereço.....: " + end.getTipo() + "\n" +
			"Logradouro...........: " + end.getLogradouro().getTipo() + " " + end.getLogradouro().getNome() + "\n" +
			"Número...............: " + end.getNumero() + "\n" +
			"Complemento..........: " + end.getComplemento() + "\n" +
			"Cep..................: " + end.getCep() + "\n" +
			"Bairro...............: " + end.getBairro().getNome() + "\n" +
			"Cidade...............: " + end.getBairro().getCidade().getNome() + "\n" +
			"Estado...............: " + end.getBairro().getCidade().getEstado().getNome() + "(" + end.getBairro().getCidade().getEstado().getSigla() + ")" + "\n" +
			"País.................: " + end.getBairro().getCidade().getEstado().getPais().getNome() +"\n";
		assertEquals(esperado, end.toString());
	}

}
