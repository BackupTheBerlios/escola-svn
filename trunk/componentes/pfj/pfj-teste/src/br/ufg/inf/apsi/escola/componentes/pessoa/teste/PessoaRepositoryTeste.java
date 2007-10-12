package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import java.util.Date;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository;

@RunWith(JUnit4ClassRunner.class)
public class PessoaRepositoryTeste {
	private Pessoa pf = new PessoaFisica();
	private Pessoa pj = new PessoaJuridica();
	private Mockery context = new JUnit4Mockery();
	private PessoaRepository pr = context.mock(PessoaRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
		//Testa a inclus�o de uma pessoa f�sica		
		try {
			context.checking(new Expectations(){{
				one(pr).incluir(pf);
			}});
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		
		try {
			pr.incluir(pf);
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		context.assertIsSatisfied();
		
		//testa a inclus�o de uma pessoa jur�dica
		try {
			context.checking(new Expectations(){{
				one(pr).incluir(pj);
			}});
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		
		try {
			pr.incluir(pj);
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaRemover(){
		//Testa a remo��o de uma pessoa f�sica
		try {
			context.checking(new Expectations(){{
				one(pr).remover(pf.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pr.remover(pf.getId());
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		//Testa a remo��o de uma pessoa jur�dica
		try {
			context.checking(new Expectations(){{
				one(pr).remover(pj.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pr.remover(pj.getId());
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
		//Testa Salvar Pessoa Fisica
		try {
			context.checking(new Expectations(){{
				one(pr).salvar(pf);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pr.salvar(pf);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();		
		//Testa Salvar Pessoa Jurídica
		try {
			context.checking(new Expectations(){{
				one(pr).salvar(pj);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pr.salvar(pj);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultarPessoaId(){
		//Testa Consultar Pessoa Fisica
		try {
			context.checking(new Expectations(){{
				one(pr).consultarPessoaId(pf.getId());
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.consultarPessoaId(pf.getId());
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa Consultar Pessoa Juridica
		try {
			context.checking(new Expectations(){{
				one(pr).consultarPessoaId(pj.getId());
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.consultarPessoaId(pj.getId());
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		context.assertIsSatisfied(); 
	} 
	/**
	 * 
	 */
	@Test
	public void testaConsultarPessoaNome(){
		try {
			context.checking(new Expectations(){{
				one(pr).consultarPessoaNome(pf.getNome());
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pr.consultarPessoaNome(pf.getNome());
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultarPessoaCidade(){
		
		final String nomeCidade = "Goi�nia";
		
		try {
			context.checking(new Expectations(){{
				one(pr).consultarPessoaCidade(nomeCidade);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pr.consultarPessoaCidade(nomeCidade);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultarPessoaBairro(){
		
		final String nomeBairro = "Setor Oeste";
		try {
			context.checking(new Expectations(){{
				one(pr).consultarPessoaBairro(nomeBairro);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pr.consultarPessoaBairro(nomeBairro);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultarPessoaTelefone(){
		
		final long numeroTelefone = 32016574;
		try {
			context.checking(new Expectations(){{
				one(pr).consultarPessoaTelefone(numeroTelefone);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pr.consultarPessoaTelefone(numeroTelefone);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
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
				one(pr).carregar(pj.getId());
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.carregar(pj.getId());
		} catch (PessoaNaoEncontradaException pnee) {
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
				one(pr).listaTodos();
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pr.listaTodos();
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultaPessoaDocumento(){
		final String numeroDocumento = "123456789";
		try {
			context.checking(new Expectations(){{
				one(pr).consultaPessoaDocumento(numeroDocumento);
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.consultaPessoaDocumento(numeroDocumento);
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		context.assertIsSatisfied();
		
	}
	/**
	 * 
	 */
	@Test
	public void consultaPessoaPorDocumento(){
		final String numeroDocumento = "123456789";
		try {
			context.checking(new Expectations(){{
				one(pr).consultaPessoaPorDocumento(numeroDocumento);
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pr.consultaPessoaPorDocumento(numeroDocumento);
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultaPessoaNomeDataNascimento(){
		final String nomePessoa = "AlgumNome";
		final Date dataNascimento = new Date();
		try {
			context.checking(new Expectations(){{
				one(pr).consultaPessoaNomeDataNascimento(nomePessoa, dataNascimento);
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}

		try {
			pr.consultaPessoaNomeDataNascimento(nomePessoa, dataNascimento);
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		context.assertIsSatisfied();
	}


	/**
	 * 
	 */
	@Test
	public void testaListaPessoasIdade(){
		final Date dataNascimento = new Date();
		try {
			context.checking(new Expectations(){{
				one(pr).listaPessoasIdade(dataNascimento);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}

		try {
			pr.listaPessoasIdade(dataNascimento);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaListaPessoasIdadeSexo(){
		final Date dataNascimento = new Date();
		final String sexo = "M";
		
		try {
			context.checking(new Expectations(){{
				one(pr).listaPessoasIdadeSexo(dataNascimento, sexo);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}

		try {
			pr.listaPessoasIdadeSexo(dataNascimento, sexo);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaListaPessoasSexo(){
		final String sexo = "M";
		try {
			context.checking(new Expectations(){{
				one(pr).listaPessoasSexo(sexo);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}

		try {
			pr.listaPessoasSexo(sexo);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
