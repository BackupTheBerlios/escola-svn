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
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class CidadeRepositoryTeste {
	/**
	 * 
	 */
	private Cidade cidade = new Cidade();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	final CidadeRepository cidadeRepository = context.mock(CidadeRepository.class); 
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
		
		try{
			context.checking(new Expectations(){{
				one (cidadeRepository).incluir(cidade);
			}});
		}catch (CidadeCadastradaException cce) {
			System.out.println(cce.getMessage());
		}
		try{
			cidadeRepository.incluir(cidade);
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
				one (cidadeRepository).remover(cidade.getId());
			}});
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try{
			cidadeRepository.remover(cidade.getId());
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
				one (cidadeRepository).salvar(cidade);
			}});
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try{
			cidadeRepository.salvar(cidade);
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
				one (cidadeRepository).consultar(cidade.getNome());
			}});
		}catch (CidadeNaoEncontradaException cnee) {
			System.out.println(cnee.getMessage());
		}
		try{
			cidadeRepository.consultar(cidade.getNome());
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
				one (cidadeRepository).carregar(cidade.getId());
			}});
		}catch (CidadeNaoEncontradaException cnee) {
			System.out.println(cnee.getMessage());
		}
		try{
			cidadeRepository.carregar(cidade.getId());
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
				one (cidadeRepository).listaTodas();
			}});
		}catch (NenhumaCidadeEncontradaException ncee) {
			System.out.println(ncee.getMessage());
		}
		try{
			cidadeRepository.listaTodas();
		}catch (NenhumaCidadeEncontradaException ncee) {
			System.out.println(ncee.getMessage());
		}
		context.assertIsSatisfied();
	}

}
