package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumTelefoneEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository;

@RunWith(JMock.class)
public class TelefoneRepositoryTeste {
	private Telefone t = new Telefone();
	private Mockery context = new JUnit4Mockery();
	private TelefoneRepository tr = context.mock(TelefoneRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
		try {
			context.checking(new Expectations(){{
				one (tr).incluir(t);
			}});
		} catch (TelefoneCadastradoException tce) {
			System.out.println(tce.getMessage());
		}
		try {
			(tr).incluir(t);
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
				one (tr).remover(t.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try {
			(tr).remover(t.getId());
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
				one (tr).salvar(t);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try {
			(tr).salvar(t);
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
				one (tr).consultar(t.getNumero());
			}});
		} catch (TelefoneNaoEncontradoException tnee) {
			System.out.println(tnee.getMessage());
		}
		try {
			(tr).consultar(t.getNumero());
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
				one (tr).carregar(t.getId());
			}});
		} catch (TelefoneNaoEncontradoException tnee) {
			System.out.println(tnee.getMessage());
		}
		try {
			(tr).carregar(t.getId());
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
				one (tr).listaTodos();
			}});
		} catch (NenhumTelefoneEncontradoException ntee) {
			System.out.println(ntee.getMessage());
		}
		try {
			(tr).listaTodos();
		} catch (NenhumTelefoneEncontradoException ntee) {
			System.out.println(ntee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
