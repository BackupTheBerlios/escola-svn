package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEmailEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class EmailRepositoryTeste {
	/**
	 * 
	 */
	private Email email = new Email();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private EmailRepository emailRepository = context.mock(EmailRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
	
		try {
			context.checking(new Expectations(){{
				one (emailRepository).incluir(email);
			}});
		} catch (EmailCadastradoException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			emailRepository.incluir(email);
		} catch (EmailCadastradoException ece) {
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
				one (emailRepository).remover(email.getEmail());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			emailRepository.remover(email.getEmail());
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
				one (emailRepository).salvar(email);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			emailRepository.salvar(email);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultar(){
		
		try {
			context.checking(new Expectations(){{
				one (emailRepository).consultar(email.getEmail());
			}});
		} catch (EmailNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			emailRepository.consultar(email.getEmail());
		} catch (EmailNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
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
				one (emailRepository).carregar(email.getId());
			}});
		} catch (EmailNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			emailRepository.carregar(email.getId());
		} catch (EmailNaoEncontradoException enee) {
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
				one (emailRepository).listaTodos();
			}});
		} catch (NenhumEmailEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			emailRepository.listaTodos();
		} catch (NenhumEmailEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		context.assertIsSatisfied();
	}

}
