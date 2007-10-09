package br.ufg.inf.apsi.escola.componentes.pessoa.teste;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
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

@RunWith(JMock.class)
public class DocumentoRepositoryTeste {
	private Documento cpf = new CPF();
	private Documento cnpj = new CNPJ();
	private Documento rg = new RG();
	private Mockery context = new JUnit4Mockery();
	private DocumentoRepository dr = context.mock(DocumentoRepository.class);
	/**
	 * 
	 */
	@Test
	public void testaIncluirDocumento() {
		//Testa a inclus�o de um cpf
		try {
			context.checking(new Expectations(){{
				one (dr).incluir(cpf);
			}});
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		
		try {
			dr.incluir(cpf);
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa a inclus�o de um cpf
		try {
			context.checking(new Expectations(){{
				one (dr).incluir(cnpj);
			}});
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		
		try {
			dr.incluir(cnpj);
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa a inclus�o de um RG
		try {
			context.checking(new Expectations(){{
				one (dr).incluir(rg);
			}});
		} catch (DocumentoCadastradoException dce) {
			System.out.println(dce.getMessage());
		}
		
		try {
			dr.incluir(rg);
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
		//Testa a remo��o de um cpf
		try {
			context.checking(new Expectations(){{
				one (dr).remover(cpf.getNumero());
			}});
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		
		try {
			dr.remover(cpf.getNumero());
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		context.assertIsSatisfied();
		
		
		//Testa remo��o de um cnpj
		try {
			context.checking(new Expectations(){{
				one (dr).remover(cnpj.getNumero());
			}});
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		
		try {
			dr.remover(cnpj.getNumero());
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		context.assertIsSatisfied();
		
		//Testa remoção de um RG
		try {
			context.checking(new Expectations(){{
				one (dr).remover(rg.getNumero());
			}});
		} catch (RemocaoDocumentoException rde) {
			System.out.println(rde.getMessage());
		}
		
		try {
			dr.remover(rg.getNumero());
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
				one (dr).salvar(cpf);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dr.salvar(cpf);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();	
				
		//Testa salvar um cnpj
		try {
			context.checking(new Expectations(){{
				one (dr).salvar(cnpj);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dr.salvar(cnpj);
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		context.assertIsSatisfied();
		//Testa salvar um rg
		try {
			context.checking(new Expectations(){{
				one (dr).salvar(rg);
			}});
		} catch (EscolaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dr.salvar(rg);
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
				one (dr).carregar(cpf.getId());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			dr.carregar(cpf.getId());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		context.assertIsSatisfied();
		//Testa carregar um cnpj
		try {
			context.checking(new Expectations(){{
				one (dr).carregar(cnpj.getId());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			dr.carregar(cnpj.getId());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		context.assertIsSatisfied();
		//Testa carregar um rg
		try {
			context.checking(new Expectations(){{
				one (dr).carregar(rg.getId());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			dr.carregar(rg.getId());
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
				one (dr).listaTodos();
			}});
		} catch (NenhumDocumentoEncontradoException ndee) {
			System.out.println(ndee.getMessage());
		}
		
		try {
			dr.listaTodos();
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
				one (dr).consultar(cpf.getNumero());
			}});
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		
		try {
			dr.consultar(cpf.getNumero());
		} catch (DocumentoNaoEncontradoException dnee) {
			System.out.println(dnee.getMessage());
		}
		context.assertIsSatisfied();
	}

}
