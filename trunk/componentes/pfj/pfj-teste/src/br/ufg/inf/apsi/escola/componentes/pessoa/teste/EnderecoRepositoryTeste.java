package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEnderecoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository;

@RunWith(JMock.class)
public class EnderecoRepositoryTeste {
	private Endereco end = new Endereco();
	private Mockery context = new JUnit4Mockery();
	private EnderecoRepository er = context.mock(EnderecoRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaInlcuir(){
	
		try {
			context.checking(new Expectations(){{
				one (er).incluir(end);
			}});
		} catch (EnderecoCadastradoException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			er.incluir(end);
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
				one (er).remover(end.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			er.remover(end.getId());
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
				one (er).salvar(end);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			er.salvar(end);
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
		end.setLogradouro(log);
		try {
			context.checking(new Expectations(){{
				one (er).consultarNomeRua(end.getLogradouro().getNome());
			}});
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			er.consultarNomeRua(end.getLogradouro().getNome());
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
				one (er).carregar(end.getId());
			}});
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			er.carregar(end.getId());
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
				one (er).listaTodos();
			}});
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			er.listaTodos();
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
				one (er).consultaCep(end.getCep());
			}});
		} catch (NenhumEnderecoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			er.consultaCep(end.getCep());
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
		end.setLogradouro(log);
		try {
			context.checking(new Expectations(){{
				one (er).consultarDiversos(end.getLogradouro().getNome(), end.getComplemento(), end.getNumero());
			}});
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			er.consultarDiversos(end.getLogradouro().getNome(), end.getComplemento(), end.getNumero());
		} catch (EnderecoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
