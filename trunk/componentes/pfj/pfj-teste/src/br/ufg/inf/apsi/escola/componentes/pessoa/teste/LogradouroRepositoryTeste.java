package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumLogradouroEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class LogradouroRepositoryTeste {
	/**
	 * 
	 */
	private Logradouro logradouro = new Logradouro();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private LogradouroRepository logradouroRepository = context.mock(LogradouroRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir(){
		try {
			context.checking(new Expectations(){{
				one (logradouroRepository).incluir(logradouro);
			}});
		} catch (LogradouroCadastradoException lce) {
			System.out.println(lce.getMessage());
		}
		
		try {
			logradouroRepository.incluir(logradouro);
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
				one (logradouroRepository).remover(logradouro.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			logradouroRepository.remover(logradouro.getId());
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
				one (logradouroRepository).salvar(logradouro);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			logradouroRepository.salvar(logradouro);
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
				one (logradouroRepository).consultar(logradouro.getNome());
			}});
		} catch (LogradouroNaoEncontradoException lnee) {
			System.out.println(lnee.getMessage());
		}
		
		try {
			logradouroRepository.consultar(logradouro.getNome());
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
				one (logradouroRepository).carregar(logradouro.getId());
			}});
		} catch (LogradouroNaoEncontradoException lnee) {
			System.out.println(lnee.getMessage());
		}
		
		try {
			logradouroRepository.carregar(logradouro.getId());
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
				one (logradouroRepository).listaTodos();
			}});
		} catch (NenhumLogradouroEncontradoException nlee) {
			System.out.println(nlee.getMessage());
		}
		
		try {
			logradouroRepository.listaTodos();
		} catch (NenhumLogradouroEncontradoException nlee) {
			System.out.println(nlee.getMessage());
		}
		
		context.assertIsSatisfied();
	}
}
