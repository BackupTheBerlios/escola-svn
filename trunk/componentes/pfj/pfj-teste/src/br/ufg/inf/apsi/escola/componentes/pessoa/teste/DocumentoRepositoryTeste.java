package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CNPJ;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.CPF;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.RG;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;


/**
 * Classe definida para testar a interface DocumentoRepository
 * @author Gilmar
 *
 */
public class DocumentoRepositoryTeste extends MockObjectTestCase{
	
	private Documento cpf = new CPF();
	private Documento cnpj = new CNPJ();
	private Documento rg = new RG();
	private Mock docMock = new Mock(DocumentoRepository.class);
	private DocumentoRepository dr = (DocumentoRepository) docMock.proxy();
	/**
	 * 
	 */
	public void testaIncluirDocumento() {
		
		cpf.setNumero("33462461168");
		
		docMock.expects(once()).method("incluir").with(eq(cpf)).will(returnValue(true));

		boolean esperado = true;

		try {
			assertEquals(esperado, dr.incluir(cpf));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */		
	public void testaRemover(){
		
		//Testa remoção de um cpf
		cpf.setNumero("33462461168");
		
		docMock.expects(once()).method("remover").with(eq(cpf.getNumero())).will(returnValue(true));
				
		boolean esperado = true;
		
		try{
			assertEquals(esperado, dr.remover(cpf.getNumero()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
		
		//Testa remoção de um cnpj
		cnpj.setNumero("03314200000107");
		
		docMock.expects(once()).method("remover").with(eq(cnpj.getNumero())).will(returnValue(true));
					
		boolean resultado = true;

		try{
			assertEquals(resultado, dr.remover(cnpj.getNumero()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
		
		//Testa remoção de um RG
		rg.setNumero("2215357");
		if (rg instanceof RG) {
			RG rg1 = (RG) rg;
			rg1.setDataEmissao(new Date());
			rg1.setOrgaoExpedidor("SSPGO");
			
			docMock.expects(once()).method("remover").with(eq(rg1.getNumero())).will(returnValue(true));
					
			boolean resultadoTeste = true;
			try{
				assertEquals(resultadoTeste, dr.remover(rg1.getNumero()));
			}catch (Exception e){
				new EscolaException(e.getMessage()).printStackTrace();
			}
		}	
	}
	/**
	 * 
	 */
	public void testaSalvar(){
	
		//Testa salvar um cpf
		cpf.setNumero("33462461168");
	
		docMock.expects(once()).method("salvar").with(eq(cpf)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, dr.salvar(cpf));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}		
		
		//Testa salvar um cnpj
		cnpj.setNumero("03314200000107");
		
		docMock.expects(once()).method("salvar").with(eq(cnpj)).will(returnValue(true));

		boolean resultado = true;
		
		try {
			assertEquals(resultado, dr.salvar(cnpj));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
		//Testa salvar um rg
		rg.setNumero("2215357");
		if (rg instanceof RG) {
			RG rg1 = (RG) rg;
			rg1.setDataEmissao(new Date());
			rg1.setOrgaoExpedidor("SSPGO");
			
			docMock.expects(once()).method("salvar").with(eq(rg1)).will(returnValue(true));

			boolean resultadoTeste = true;
			
			try {
				assertEquals(resultadoTeste, dr.salvar(rg1));
			} catch (EscolaException e) {
				new EscolaException(e.getMessage()).printStackTrace();
			}
		}
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		//o parâmetro de retorno está configurado para retornar um cpf, mas funciona
		//igualmente para cnpj ou rg.
		docMock.expects(once()).method("carregar").with(eq(cpf.getId())).will(returnValue(cpf));
		
		Long docId = null;
		
		try {
			assertEquals(docId, dr.carregar(cpf.getId()).toString());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		List<Documento> listaDocumentos = new ArrayList<Documento>();
		
		docMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Documento>()));
		
		try {
			assertEquals(listaDocumentos, dr.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		Documento doc = new RG();
		doc.setNumero("12");
		docMock.expects(once()).method("consultar").with(eq("12")).will(returnValue(doc));
		
		try {
			assertEquals("12", dr.consultar(doc.getNumero()).getNumero());
		} catch (DocumentoNaoEncontradoException e) {
			e.getMessage();
		}
		
	}
	
}
