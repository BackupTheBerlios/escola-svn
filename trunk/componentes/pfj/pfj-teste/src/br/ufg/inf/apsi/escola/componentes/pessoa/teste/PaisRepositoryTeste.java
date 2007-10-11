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

@RunWith(JUnit4ClassRunner.class)
public class PaisRepositoryTeste {
	private Pais p = new Pais();
	private Mockery context = new JUnit4Mockery();
	private PaisRepository pr = context.mock(PaisRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir(){
		try {
			context.checking(new Expectations(){{
				one (pr).incluir(p);
			}});
		} catch (PaisCadastradoException pce) {
			System.out.println(pce.getMessage());
		}
		
		try {
			pr.incluir(p);
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
				one (pr).remover(p.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pr.remover(p.getId());
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
				one (pr).salvar(p);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pr.salvar(p);
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
				one (pr).consultar(p.getNome());
			}});
		} catch (PaisNaoEncontradoException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.consultar(p.getNome());
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
				one (pr).carregar(p.getId());
			}});
		} catch (PaisNaoEncontradoException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.carregar(p.getId());
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
				one (pr).listaTodos();
			}});
		} catch (NenhumPaisEncontradoException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pr.listaTodos();
		} catch (NenhumPaisEncontradoException npee) {
			System.out.println(npee.getMessage());
		}
		
		context.assertIsSatisfied();
 	}
}
