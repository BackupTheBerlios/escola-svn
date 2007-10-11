package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaCidadeEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository;

@RunWith(JUnit4ClassRunner.class)
public class CidadeRepositoryTeste {
	
	private Cidade c = new Cidade();
	private Mockery context = new JUnit4Mockery();
	final CidadeRepository cr = context.mock(CidadeRepository.class); 
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
		
		try{
			context.checking(new Expectations(){{
				one (cr).incluir(c);
			}});
		}catch (CidadeCadastradaException cce) {
			System.out.println(cce.getMessage());
		}
		try{
			cr.incluir(c);
		}catch (CidadeCadastradaException cce) {
			System.out.println(cce.getMessage());
		}
		context.assertIsSatisfied();	
	}
	/**
	 * 
	 */
	@Test
	public void testaRemover() {
		try{
			context.checking(new Expectations(){{
				one (cr).remover(c.getId());
			}});
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try{
			cr.remover(c.getId());
		}catch (EscolaException cce) {
			System.out.println(cce.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaSalvar(){
		try{
			context.checking(new Expectations(){{
				one (cr).salvar(c);
			}});
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try{
			cr.salvar(c);
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultar(){
		
		try{
			context.checking(new Expectations(){{
				one (cr).consultar(c.getNome());
			}});
		}catch (CidadeNaoEncontradaException cnee) {
			System.out.println(cnee.getMessage());
		}
		try{
			cr.consultar(c.getNome());
		}catch (CidadeNaoEncontradaException cnee) {
			System.out.println(cnee.getMessage());
		}
		context.assertIsSatisfied();	
	}
	/**
	 * 
	 */
	@Test
	public void testaCarregar(){
		
		try{
			context.checking(new Expectations(){{
				one (cr).carregar(c.getId());
			}});
		}catch (CidadeNaoEncontradaException cnee) {
			System.out.println(cnee.getMessage());
		}
		try{
			cr.carregar(c.getId());
		}catch (CidadeNaoEncontradaException cnee) {
			System.out.println(cnee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaListaTodos(){
		try{
			context.checking(new Expectations(){{
				one (cr).listaTodas();
			}});
		}catch (NenhumaCidadeEncontradaException ncee) {
			System.out.println(ncee.getMessage());
		}
		try{
			cr.listaTodas();
		}catch (NenhumaCidadeEncontradaException ncee) {
			System.out.println(ncee.getMessage());
		}
		context.assertIsSatisfied();
	}

}
