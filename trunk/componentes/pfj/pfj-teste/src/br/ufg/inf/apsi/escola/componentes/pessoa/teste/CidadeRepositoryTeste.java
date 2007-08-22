package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;


/**
 * Classe definida para testar a interface CidadeRepository
 * @author Gilmar
 *
 */
public class CidadeRepositoryTeste extends MockObjectTestCase {
	
	private Cidade c = new Cidade();
	private Mock cidadeMock = new Mock(CidadeRepository.class);
	private CidadeRepository cr = (CidadeRepository) cidadeMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir() {
		
		cidadeMock.expects(once()).method("incluir").with(eq(c)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, cr.incluir(c));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaRemover() {
		
		cidadeMock.expects(once()).method("remover").with(eq(c.getId())).will(returnValue(true));
		
		boolean esperado = true;
		
		try{
			assertEquals(esperado, cr.remover(c.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		cidadeMock.expects(once()).method("salvar").with(eq(c)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, cr.salvar(c));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		
		c.setNome("Itumbiara");
				
		cidadeMock.expects(once()).method("consultar").with(eq(c.getNome())).will(returnValue(c));
		
		String nomeCidade = "Itumbiara";
		
		try{
			assertEquals(nomeCidade, cr.consultar(c.getNome()).getNome());
			
		}catch (Exception e){
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}	
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		c.setNome("Luziania");
		
		cidadeMock.expects(once()).method("carregar").with(eq(c.getId())).will(returnValue(c));
		
		String nomeCidade = "Luziania";
				
		try {
			assertEquals(nomeCidade, cr.carregar(c.getId()).getNome());
		} catch (Exception e) {
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		List<Cidade> listaCidades = new ArrayList<Cidade>();
		cidadeMock.expects(once()).method("listaTodas").will(returnValue(new ArrayList<Cidade>()));
		try {
			assertEquals(listaCidades, cr.listaTodas());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
}
