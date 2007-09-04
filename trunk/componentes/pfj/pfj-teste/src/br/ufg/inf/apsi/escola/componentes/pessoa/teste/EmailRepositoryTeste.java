package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EmailCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EmailNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumEmailEncontradoException;

@RunWith(JMock.class)
public class EmailRepositoryTeste {
	private Email email = new Email();
	private Mockery context = new JUnit4Mockery();
	private EmailRepository er = context.mock(EmailRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
	
		try {
			context.checking(new Expectations(){{
				one (er).incluir(email);
			}});
		} catch (EmailCadastradoException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			er.incluir(email);
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
				one (er).remover(email.getEmail());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			er.remover(email.getEmail());
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
				one (er).salvar(email);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			er.salvar(email);
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
				one (er).consultar(email.getEmail());
			}});
		} catch (EmailNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			er.consultar(email.getEmail());
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
				one (er).carregar(email.getId());
			}});
		} catch (EmailNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			er.carregar(email.getId());
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
				one (er).listaTodos();
			}});
		} catch (NenhumEmailEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			er.listaTodos();
		} catch (NenhumEmailEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		context.assertIsSatisfied();
	}

}
