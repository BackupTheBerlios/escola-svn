package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEnderecoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class EnderecoRepositoryTeste {
	/**
	 * 
	 */
	private Endereco endereco = new Endereco();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private EnderecoRepository enderecoRepository = context.mock(EnderecoRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaInlcuir(){
	
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).incluir(endereco);
			}});
		} catch (EnderecoCadastradoException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			enderecoRepository.incluir(endereco);
		} catch (EnderecoCadastradoException ece) {
			System.out.println(ece.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaRemover(){
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).remover(endereco.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			enderecoRepository.remover(endereco.getId());
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void testaSalvar(){
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).salvar(endereco);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			enderecoRepository.salvar(endereco);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultarNomeRua(){
		Logradouro log = new Logradouro();
		endereco.setLogradouro(log);
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).consultarNomeRua(endereco.getLogradouro().getNome());
			}});
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			enderecoRepository.consultarNomeRua(endereco.getLogradouro().getNome());
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		context.assertIsSatisfied();	
	}
	/**
	 * 
	 */
	@Test
	public void testaCarregar(){
		
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).carregar(endereco.getId());
			}});
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			enderecoRepository.carregar(endereco.getId());
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaListaTodos(){
		
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).listaTodos();
			}});
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			enderecoRepository.listaTodos();
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultaCep(){
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).consultaCep(endereco.getCep());
			}});
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			enderecoRepository.consultaCep(endereco.getCep());
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		context.assertIsSatisfied();

	}
	/**
	 * 
	 */
	@Test
	public void testaConsultarDiversos(){
		Logradouro log = new Logradouro();
		endereco.setLogradouro(log);
		try {
			context.checking(new Expectations(){{
				one (enderecoRepository).consultarDiversos(endereco.getLogradouro().getNome(), endereco.getComplemento(), endereco.getNumero());
			}});
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			enderecoRepository.consultarDiversos(endereco.getLogradouro().getNome(), endereco.getComplemento(), endereco.getNumero());
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
