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
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class PessoaRepositoryTeste {
	/**
	 * 
	 */
	private Pessoa pessoaFisica = new PessoaFisica();
	/**
	 * 
	 */
	private Pessoa pessoaJuridica = new PessoaJuridica();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private PessoaRepository pessoaRepository = context.mock(PessoaRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluir() {
		//Testa a inclusão de uma pessoa física		
		try {
			context.checking(new Expectations(){{
				one(pessoaRepository).incluir(pessoaFisica);
			}});
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		
		try {
			pessoaRepository.incluir(pessoaFisica);
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		context.assertIsSatisfied();
		
		//testa a inclus�o de uma pessoa jur�dica
		try {
			context.checking(new Expectations(){{
				one(pessoaRepository).incluir(pessoaJuridica);
			}});
		} catch (PessoaCadastradaException pce) {
			System.out.println(pce.getMessage());
		}
		
		try {
			pessoaRepository.incluir(pessoaJuridica);
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
				one(pessoaRepository).remover(pessoaFisica.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pessoaRepository.remover(pessoaFisica.getId());
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		//Testa a remo��o de uma pessoa jur�dica
		try {
			context.checking(new Expectations(){{
				one(pessoaRepository).remover(pessoaJuridica.getId());
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pessoaRepository.remover(pessoaJuridica.getId());
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
				one(pessoaRepository).salvar(pessoaFisica);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pessoaRepository.salvar(pessoaFisica);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();		
		//Testa Salvar Pessoa Jurídica
		try {
			context.checking(new Expectations(){{
				one(pessoaRepository).salvar(pessoaJuridica);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pessoaRepository.salvar(pessoaJuridica);
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
				one(pessoaRepository).consultarPessoaId(pessoaFisica.getId());
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pessoaRepository.consultarPessoaId(pessoaFisica.getId());
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa Consultar Pessoa Juridica
		try {
			context.checking(new Expectations(){{
				one(pessoaRepository).consultarPessoaId(pessoaJuridica.getId());
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pessoaRepository.consultarPessoaId(pessoaJuridica.getId());
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
				one(pessoaRepository).consultarPessoaNome(pessoaFisica.getNome());
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pessoaRepository.consultarPessoaNome(pessoaFisica.getNome());
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
				one(pessoaRepository).consultarPessoaCidade(nomeCidade);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pessoaRepository.consultarPessoaCidade(nomeCidade);
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
				one(pessoaRepository).consultarPessoaBairro(nomeBairro);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pessoaRepository.consultarPessoaBairro(nomeBairro);
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
				one(pessoaRepository).consultarPessoaTelefone(numeroTelefone);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pessoaRepository.consultarPessoaTelefone(numeroTelefone);
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
				one(pessoaRepository).carregar(pessoaJuridica.getId());
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pessoaRepository.carregar(pessoaJuridica.getId());
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
				one(pessoaRepository).listaTodos();
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		
		try {
			pessoaRepository.listaTodos();
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
				one(pessoaRepository).consultaPessoaDocumento(numeroDocumento);
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pessoaRepository.consultaPessoaDocumento(numeroDocumento);
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
				one(pessoaRepository).consultaPessoaPorDocumento(numeroDocumento);
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}
		
		try {
			pessoaRepository.consultaPessoaPorDocumento(numeroDocumento);
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
				one(pessoaRepository).consultaPessoaNomeDataNascimento(nomePessoa, dataNascimento);
			}});
		} catch (PessoaNaoEncontradaException pnee) {
			System.out.println(pnee.getMessage());
		}

		try {
			pessoaRepository.consultaPessoaNomeDataNascimento(nomePessoa, dataNascimento);
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
				one(pessoaRepository).listaPessoasIdade(dataNascimento);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}

		try {
			pessoaRepository.listaPessoasIdade(dataNascimento);
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
				one(pessoaRepository).listaPessoasIdadeSexo(dataNascimento, sexo);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}

		try {
			pessoaRepository.listaPessoasIdadeSexo(dataNascimento, sexo);
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
				one(pessoaRepository).listaPessoasSexo(sexo);
			}});
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}

		try {
			pessoaRepository.listaPessoasSexo(sexo);
		} catch (NenhumaPessoaEncontradaException npee) {
			System.out.println(npee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
