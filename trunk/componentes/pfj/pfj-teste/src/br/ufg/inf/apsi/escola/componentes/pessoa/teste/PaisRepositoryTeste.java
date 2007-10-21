package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumPaisEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class PaisRepositoryTeste {
	/**
	 * 
	 */
	private Pais pais = new Pais();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private PaisRepository paisRepository = context.mock(PaisRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir(){
		try {
			context.checking(new Expectations(){{
				one (paisRepository).incluir(pais);
			}});
		} catch (PaisCadastradoException pce) {
			System.out.println(pce.getMessage());
		}
		
		try {
			paisRepository.incluir(pais);
		} catch (PaisCadastradoException pce) {
			System.out.println(pce.getMessage());
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
				one (paisRepository).remover(pais.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			paisRepository.remover(pais.getId());
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
				one (paisRepository).salvar(pais);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			paisRepository.salvar(pais);
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
				one (paisRepository).consultar(pais.getNome());
			}});
		} catch (PaisNaoEncontradoException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			paisRepository.consultar(pais.getNome());
		} catch (PaisNaoEncontradoException pnee) {
			System.out.println(pnee.getMessage());
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
				one (paisRepository).carregar(pais.getId());
			}});
		} catch (PaisNaoEncontradoException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			paisRepository.carregar(pais.getId());
		} catch (PaisNaoEncontradoException pnee) {
			System.out.println(pnee.getMessage());
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
				one (paisRepository).listaTodos();
			}});
		} catch (NenhumPaisEncontradoException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			paisRepository.listaTodos();
		} catch (NenhumPaisEncontradoException npee) {
			System.out.println(npee.getMessage());
		}
		
		context.assertIsSatisfied();
 	}
}
