package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaJuridica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.PessoaCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.PessoaNaoEncontradaException;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe definida para testar a interface PessoaRepository.
 * @author Gilmar
 *
 */
public class PessoaRepositoryTeste extends MockObjectTestCase {
	
	
	private Pessoa pf = new PessoaFisica();
	private Pessoa pj = new PessoaJuridica();
	private Mock pessoaMock = new Mock(PessoaRepository.class);
	private PessoaRepository pr = (PessoaRepository) pessoaMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir() {
				
		pessoaMock.expects(once()).method("incluir").with(eq(pf)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, pr.incluir(pf));
		} catch (PessoaCadastradaException e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
		
		pessoaMock.expects(once()).method("remover").with(eq(pj.getId())).will(returnValue(true));
		
		boolean esperado = true;
		
		try{
			assertEquals(esperado, pr.remover(pj.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		//Testa Salvar Pessoa Fisica
		pessoaMock.expects(once()).method("salvar").with(eq(pf)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, pr.salvar(pf));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
		
		//Testa Salvar Pessoa Jurídica
		
		pessoaMock.expects(once()).method("salvar").with(eq(pj)).will(returnValue(true));

		boolean resultado = true;
		try {
			assertEquals(resultado, pr.salvar(pj));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultarPessoaId(){
		//Testa Consultar Pessoa Fisica
		pf.setNome("um dois tres de oliveira quatro");
		pessoaMock.expects(once()).method("consultarPessoaId").with(eq(pj.getId())).will(returnValue(pf));
		
		String nomePf = "um dois tres de oliveira quatro";
		
		try {
			assertEquals(nomePf, pr.consultarPessoaId(pf.getId()).getNome());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
		
		//Testa Consultar Pessoa Juridica
		pj.setNome("Mist�rios da Inform�tica");
		pessoaMock.expects(once()).method("consultarPessoaId").with(eq(pj.getId())).will(returnValue(pj));
		
		String nomePj = "Mist�rios da Inform�tica";
		
		try {
			assertEquals(nomePj, pr.consultarPessoaId(pj.getId()).getNome());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		} 
	} 
	/**
	 * 
	 */
	public void testaConsultarPessoaNome(){
		
		List<Pessoa> esperado = new ArrayList<Pessoa>();
		
		pessoaMock.expects(once()).method("consultarPessoaNome").with(eq("João")).will(returnValue(new ArrayList<Pessoa>()));
						
		try {
			assertEquals(esperado, pr.consultarPessoaNome("João"));
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultarPessoaCidade(){
		
		List<Pessoa> listaEsperada = new ArrayList<Pessoa>();
		Cidade c = new Cidade();
		c.setNome("Goiânia");
				
		pessoaMock.expects(once()).method("consultarPessoaCidade").with(eq(c.getNome())).will(returnValue(new ArrayList<Pessoa>()));
		
		try {
			assertEquals(listaEsperada, pr.consultarPessoaCidade(c.getNome()));
		} catch (Exception ex) {
			new EscolaException(ex.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultarPessoaBairro(){
		
		List<Pessoa> listaEsperada = new ArrayList<Pessoa>();
		
		Bairro b = new Bairro("Setor Oeste");
				
		pessoaMock.expects(once()).method("consultarPessoaBairro").with(eq(b.getNome())).will(returnValue(new ArrayList<Pessoa>()));		
		
		try {
			assertEquals(listaEsperada, pr.consultarPessoaBairro(b.getNome()));
		} catch (Exception ex) {
			new EscolaException(ex.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultarPessoaTelefone(){
		
		List<Pessoa> listaEsperada = new ArrayList<Pessoa>();
		
		Telefone t = new Telefone(32016574);
		
		pessoaMock.expects(once()).method("consultarPessoaTelefone").with(eq(t.getNumero())).will(returnValue(new ArrayList<Pessoa>()));
		
		try {
			assertEquals(listaEsperada, pr.consultarPessoaTelefone(t.getNumero()));
		} catch (Exception ex) {
			new EscolaException(ex.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		pf.setNome("Jorlei");
		pessoaMock.expects(once()).method("carregar").with(eq(pf.getId())).will(returnValue(pf));
		
		String nomePf = "Jorlei";
		
		try {
			assertEquals(nomePf, pr.carregar(pf.getId()).getNome());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		pessoaMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Pessoa>()));
		try {
			assertEquals(listaPessoas, pr.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultaPessoaDocumento(){
		Documento doc = new CPF();
		doc.setNumero("33462461168");
		pf.setNome("Alguém");
		pf.getListaDocumentos().add(doc);
		pessoaMock.expects(once()).method("consultaPessoaDocumento").with(eq("33462461168")).will(returnValue(pf));
		
		try {
			assertEquals("Alguém", pr.consultaPessoaDocumento("33462461168").getNome());
		} catch (PessoaNaoEncontradaException pnee) {
			pnee.getMessage();
		}
	}
	/**
	 * 
	 *
	 */
	public void testaConsultaPessoaNomeDataNascimento(){
		Date dataNascimento = new Date();
		 if (pf instanceof PessoaFisica) {
			PessoaFisica pf1 = (PessoaFisica) pf;
			pf1.setDataNascimento(dataNascimento);
			pf1.setNome("NomePessoa");
			
			pessoaMock.expects(once()).method("consultaPessoaNomeDataNascimento").will(returnValue(pf1));
			
			try {
				assertEquals("NomePessoa", pr.consultaPessoaNomeDataNascimento("NomePessoa", dataNascimento).getNome());
			} catch (PessoaNaoEncontradaException pnee) {
				pnee.getMessage();
			}
		}
	}
	/**
	 * 
	 */
	public void testaListaPessoasIdade(){
		Date dataNascimento = new Date();
		if (pf instanceof PessoaFisica) {
				PessoaFisica pf1 = (PessoaFisica) pf;
				pf1.setDataNascimento(dataNascimento);
				List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
				pessoaMock.expects(once()).method("listaPessoasIdade").will(returnValue(new ArrayList<Pessoa>()));
				
				try {
					assertEquals(listaPessoas, pr.listaPessoasIdade(dataNascimento));
				} catch (NenhumaPessoaEncontradaException npee) {
					npee.getMessage();
				}
			}
	}
	/**
	 * 
	 *
	 */
	public void testaListaPessoasIdadeSexo(){
		Date dataNascimento = new Date();
		String sexo = "M";
		if (pf instanceof PessoaFisica) {
				PessoaFisica pf1 = (PessoaFisica) pf;
				pf1.setDataNascimento(dataNascimento);
				pf1.setSexo(sexo);
				List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
				pessoaMock.expects(once()).method("listaPessoasIdadeSexo").will(returnValue(new ArrayList<Pessoa>()));
				
				try {
					assertEquals(listaPessoas, pr.listaPessoasIdadeSexo(dataNascimento, sexo));
				} catch (NenhumaPessoaEncontradaException npee) {
					npee.getMessage();
				}
			}
	}
	/**
	 * 
	 */
	public void testaListaPessoasSexo(){
		String sexo = "M";
		if (pf instanceof PessoaFisica) {
				PessoaFisica pf1 = (PessoaFisica) pf;
				pf1.setSexo(sexo);
				List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
				pessoaMock.expects(once()).method("listaPessoasSexo").will(returnValue(new ArrayList<Pessoa>()));
				
				try {
					assertEquals(listaPessoas, pr.listaPessoasSexo(sexo));
				} catch (NenhumaPessoaEncontradaException npee) {
					npee.getMessage();
				}
			}
	}
}
