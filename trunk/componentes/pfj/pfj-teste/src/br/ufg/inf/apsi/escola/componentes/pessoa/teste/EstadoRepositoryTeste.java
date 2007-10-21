package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEstadoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class EstadoRepositoryTeste {
	/**
	 * 
	 */
	private Estado estado = new Estado();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private EstadoRepository estadoRepository = context.mock(EstadoRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir(){
		try {
			context.checking(new Expectations(){{
				one (estadoRepository).incluir(estado);
			}});
		} catch (EstadoCadastradoException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			estadoRepository.incluir(estado);
		} catch (EstadoCadastradoException ece) {
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
				one (estadoRepository).remover(estado.getId());
			}});
		} catch (EscolaException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			estadoRepository.remover(estado.getId());
		} catch (EscolaException ece) {
			System.out.println(ece.getMessage());
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
				one (estadoRepository).salvar(estado);
			}});
		} catch (EscolaException ece) {
			System.out.println(ece.getMessage());
		}
		
		try {
			estadoRepository.salvar(estado);
		} catch (EscolaException ece) {
			System.out.println(ece.getMessage());
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
				one (estadoRepository).consultar(estado.getNome());
			}});
		} catch (EstadoNaoEncontradoException enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			estadoRepository.consultar(estado.getNome());
		} catch (EstadoNaoEncontradoException enee) {
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
				one (estadoRepository).carregar(estado.getId());
			}});
		} catch (EstadoNaoEncontradoException  enee) {
			System.out.println(enee.getMessage());
		}
		
		try {
			estadoRepository.carregar(estado.getId());
		} catch (EstadoNaoEncontradoException enee) {
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
				one (estadoRepository).listaTodos();
			}});
		} catch (NenhumEstadoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		
		try {
			estadoRepository.listaTodos();
		} catch (NenhumEstadoEncontradoException neee) {
			System.out.println(neee.getMessage());
		}
		context.assertIsSatisfied();
	}

}
