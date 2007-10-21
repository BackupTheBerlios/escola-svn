package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumTelefoneEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class TelefoneRepositoryTeste {
	/**
	 * 
	 */
	private Telefone telefone = new Telefone();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private TelefoneRepository telefoneRepository = context.mock(TelefoneRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
		try {
			context.checking(new Expectations(){{
				one (telefoneRepository).incluir(telefone);
			}});
		} catch (TelefoneCadastradoException tce) {
			System.out.println(tce.getMessage());
		}
		try {
			(telefoneRepository).incluir(telefone);
		} catch (TelefoneCadastradoException tce) {
			System.out.println(tce.getMessage());
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
				one (telefoneRepository).remover(telefone.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try {
			(telefoneRepository).remover(telefone.getId());
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
				one (telefoneRepository).salvar(telefone);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try {
			(telefoneRepository).salvar(telefone);
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
				one (telefoneRepository).consultar(telefone.getNumero());
			}});
		} catch (TelefoneNaoEncontradoException tnee) {
			System.out.println(tnee.getMessage());
		}
		try {
			(telefoneRepository).consultar(telefone.getNumero());
		} catch (TelefoneNaoEncontradoException tnee) {
			System.out.println(tnee.getMessage());
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
				one (telefoneRepository).carregar(telefone.getId());
			}});
		} catch (TelefoneNaoEncontradoException tnee) {
			System.out.println(tnee.getMessage());
		}
		try {
			(telefoneRepository).carregar(telefone.getId());
		} catch (TelefoneNaoEncontradoException tnee) {
			System.out.println(tnee.getMessage());
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
				one (telefoneRepository).listaTodos();
			}});
		} catch (NenhumTelefoneEncontradoException ntee) {
			System.out.println(ntee.getMessage());
		}
		try {
			(telefoneRepository).listaTodos();
		} catch (NenhumTelefoneEncontradoException ntee) {
			System.out.println(ntee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
