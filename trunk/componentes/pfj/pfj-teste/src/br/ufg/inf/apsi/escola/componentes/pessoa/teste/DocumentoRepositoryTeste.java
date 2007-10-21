package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumDocumentoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.RemocaoDocumentoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository;
/**
 * 
 * @author gilmar
 *
 */
@RunWith(JUnit4ClassRunner.class)
public class DocumentoRepositoryTeste {
	/**
	 * 
	 */
	private Documento cpf = new CPF();
	/**
	 * 
	 */
	private Documento cnpj = new CNPJ();
	/**
	 * 
	 */
	private Documento rg = new RG();
	/**
	 * 
	 */
	private Mockery context = new JUnit4Mockery();
	/**
	 * 
	 */
	private DocumentoRepository documentoRepository = context.mock(DocumentoRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluirDocumento() {
		//Testa a inclusão de um cpf
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).incluir(cpf);
			}});
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		
		try {
			documentoRepository.incluir(cpf);
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa a inclusão de um cpf
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).incluir(cnpj);
			}});
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		
		try {
			documentoRepository.incluir(cnpj);
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa a inclusão de um RG
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).incluir(rg);
			}});
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		
		try {
			documentoRepository.incluir(rg);
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		context.assertIsSatisfied();
		
	}	
	/**
	 * 
	 */		
	@Test
	public void testaRemover(){
		//Testa a remoção de um cpf
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).remover(cpf.getNumero());
			}});
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		
		try {
			documentoRepository.remover(cpf.getNumero());
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		context.assertIsSatisfied();
		
		
		//Testa remoção de um cnpj
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).remover(cnpj.getNumero());
			}});
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		
		try {
			documentoRepository.remover(cnpj.getNumero());
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa remoção de um RG
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).remover(rg.getNumero());
			}});
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		
		try {
			documentoRepository.remover(rg.getNumero());
		} catch (RemocaoDocumentoException dce) {
			System.out.println(dce.getMessage());
		}
		context.assertIsSatisfied();
	}
	
	/**
	 * 
	 */
	@Test
	public void testaSalvar(){
	
		//Testa salvar um cpf
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).salvar(cpf);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			documentoRepository.salvar(cpf);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();	
				
		//Testa salvar um cnpj
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).salvar(cnpj);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			documentoRepository.salvar(cnpj);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		//Testa salvar um rg
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).salvar(rg);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			documentoRepository.salvar(rg);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaCarregar(){
		//Testa carregar um cpf
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).carregar(cpf.getId());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			documentoRepository.carregar(cpf.getId());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		context.assertIsSatisfied();
		//Testa carregar um cnpj
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).carregar(cnpj.getId());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			documentoRepository.carregar(cnpj.getId());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		context.assertIsSatisfied();
		//Testa carregar um rg
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).carregar(rg.getId());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			documentoRepository.carregar(rg.getId());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
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
				one (documentoRepository).listaTodos();
			}});
		} catch (NenhumDocumentoEncontradoException ndee) {
			System.out.println(ndee.getMessage());
		}
		
		try {
			documentoRepository.listaTodos();
		} catch (NenhumDocumentoEncontradoException ndee) {
			System.out.println(ndee.getMessage());
		}
		context.assertIsSatisfied();
	}
	/**
	 * 
	 */
	@Test
	public void testaConsultar(){
		//Testa consultar um cpf
		try {
			context.checking(new Expectations(){{
				one (documentoRepository).consultar(cpf.getNumero());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			documentoRepository.consultar(cpf.getNumero());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		context.assertIsSatisfied();
	}

}
