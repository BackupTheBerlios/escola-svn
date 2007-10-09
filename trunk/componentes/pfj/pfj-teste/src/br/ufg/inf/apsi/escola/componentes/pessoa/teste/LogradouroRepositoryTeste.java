package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumLogradouroEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository;

@RunWith(JMock.class)
public class LogradouroRepositoryTeste {
	private Logradouro log = new Logradouro();
	private Mockery context = new JUnit4Mockery();
	private LogradouroRepository lr = context.mock(LogradouroRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir(){
		try {
			context.checking(new Expectations(){{
				one (lr).incluir(log);
			}});
		} catch (LogradouroCadastradoException lce) {
			System.out.println(lce.getMessage());
		}
		
		try {
			lr.incluir(log);
		} catch (LogradouroCadastradoException lce) {
			System.out.println(lce.getMessage());
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
				one (lr).remover(log.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			lr.remover(log.getId());
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
				one (lr).salvar(log);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			lr.salvar(log);
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
				one (lr).consultar(log.getNome());
			}});
		} catch (LogradouroNaoEncontradoException lnee) {
			System.out.println(lnee.getMessage());
		}
		
		try {
			lr.consultar(log.getNome());
		} catch (LogradouroNaoEncontradoException lnee) {
			System.out.println(lnee.getMessage());
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
				one (lr).carregar(log.getId());
			}});
		} catch (LogradouroNaoEncontradoException lnee) {
			System.out.println(lnee.getMessage());
		}
		
		try {
			lr.carregar(log.getId());
		} catch (LogradouroNaoEncontradoException lnee) {
			System.out.println(lnee.getMessage());
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
				one (lr).listaTodos();
			}});
		} catch (NenhumLogradouroEncontradoException nlee) {
			System.out.println(nlee.getMessage());
		}
		
		try {
			lr.listaTodos();
		} catch (NenhumLogradouroEncontradoException nlee) {
			System.out.println(nlee.getMessage());
		}
		
		context.assertIsSatisfied();
	}
}
