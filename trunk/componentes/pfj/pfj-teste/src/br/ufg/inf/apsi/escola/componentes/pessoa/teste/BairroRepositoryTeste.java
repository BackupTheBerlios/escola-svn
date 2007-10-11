package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumBairroEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository;


/**
 * Classe definida para testar a interface BairroRepository
 * @author Gilmar
 *
 */

@RunWith(JUnit4ClassRunner.class)
public class BairroRepositoryTeste {

	private Bairro b = new Bairro();
	private Mockery context = new JUnit4Mockery();
	final BairroRepository br = context.mock(BairroRepository.class); 
	
	@Test
	public void testaIncluir(){
		Pais p = new Pais("Brasil");
		Estado e = new Estado("Goiás");
		Cidade c = new Cidade("Goiânia");
		e.setPais(p);
		c.setEstado(e);
		b.setCidade(c);
		b.setNome("Setor Oeste");


		try{
			context.checking(new Expectations(){{
				one (br).incluir(b);
			}});
		}catch (BairroCadastradoException bce) {
			System.out.println(bce.getMessage());
		}
		try{
			br.incluir(b);
		}catch (BairroCadastradoException bce) {
			System.out.println(bce.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaRemover(){

		try{
			context.checking(new Expectations(){{
				one (br).remover(b.getId());
			}});
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try{
			br.remover(b.getId());
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
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
				one (br).salvar(b);
			}});
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		try{
			br.salvar(b);
		}catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	//funcionou colocando a classe Bairro como public 
	@Test
	public void testaConsultar(){

		try{
			context.checking(new Expectations(){{
				one (br).consultar(b.getNome());
			}});
		}catch (BairroNaoEncontradoException bnee) {
			System.out.println(bnee.getMessage());
		}
		try{
			br.consultar(b.getNome());
		}catch (BairroNaoEncontradoException bnee) {
			System.out.println(bnee.getMessage());
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
				one (br).carregar(b.getId());
			}});
		}catch (BairroNaoEncontradoException bnee) {
			System.out.println(bnee.getMessage());
		}
		try{
			br.carregar(b.getId());
		}catch (BairroNaoEncontradoException bnee) {
			System.out.println(bnee.getMessage());
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
				one (br).listaTodos();
			}});
		}catch (NenhumBairroEncontradoException nbee) {
			System.out.println(nbee.getMessage());
		}
		try{
			br.listaTodos();
		}catch (NenhumBairroEncontradoException nbee) {
			System.out.println(nbee.getMessage());
		}
		context.assertIsSatisfied();
	}
}
