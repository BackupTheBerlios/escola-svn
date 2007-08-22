package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.PaisCadastradoException;

/**
 * Classe definida para testar a interface PaisRepository
 * @author Gilmar
 *
 */
public class PaisRepositoryTeste extends MockObjectTestCase {
	
	private Pais p = new Pais();
	private Mock paisMock = new Mock(PaisRepository.class);
	private PaisRepository pr = (PaisRepository) paisMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir(){
				
		paisMock.expects(once()).method("incluir").with(eq(p)).will(returnValue(true));

		boolean esperado = true;

		try {
			assertEquals(esperado, pr.incluir(p));
		} catch (PaisCadastradoException e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
		
		paisMock.expects(once()).method("remover").with(eq(p.getId())).will(returnValue(true));
		
		boolean resultadoEsperado = true;
		
		try {
			assertEquals(resultadoEsperado, pr.remover(p.getId()));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		paisMock.expects(once()).method("salvar").with(eq(p)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, pr.salvar(p));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		
		p.setNome("Brasil");
		
		paisMock.expects(once()).method("consultar").with(eq(p.getNome())).will(returnValue(p));
		
		String esperado = "Brasil";
		
		try{
			assertEquals(esperado, pr.consultar(p.getNome()).getNome());
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		paisMock.expects(once()).method("carregar").with(eq(p.getId())).will(returnValue(p));
		
		Long paisId = null;
		
		try {
			assertEquals(paisId, pr.carregar(p.getId()).getId());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		List<Pais> listaPaises = new ArrayList<Pais>();
		
		paisMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Pais>()));
		
		try {
			assertEquals(listaPaises, pr.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
 	}
}
