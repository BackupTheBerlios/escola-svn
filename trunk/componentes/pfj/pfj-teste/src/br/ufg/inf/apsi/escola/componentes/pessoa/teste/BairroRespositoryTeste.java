package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;


/**
 * Classe definida para testar a interface BairroRepository
 * @author Gilmar
 *
 */

public class BairroRespositoryTeste extends MockObjectTestCase{
	
	private Bairro b = new Bairro();
	private Mock bairroMock = new Mock(BairroRepository.class);
	private BairroRepository br = (BairroRepository) bairroMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir(){
		
		b.setNome("Parque Santa Rita");
		
		bairroMock.expects(once()).method("incluir").with(eq(b)).will(returnValue(true));

		boolean esperado = true;
		try {
			assertEquals(esperado, br.incluir(b));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
		
		bairroMock.expects(once()).method("remover").with(eq(b.getId())).will(returnValue(true));
		
		boolean esperado = true;
		try{
			assertEquals(esperado, br.remover(b.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		b.setNome("Parque Santa Rita");
		bairroMock.expects(once()).method("salvar").with(eq(b)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, br.salvar(b));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	//funcionou colocando a classe Bairro como public 
	public void testaConsultar(){
		
		b.setNome("Parque Santa Rita");
		
		bairroMock.expects(once()).method("consultar").with(eq(b.getNome())).will(returnValue(b));
		
		String esperado = "Parque Santa Rita" ;
		
		try{
			assertEquals(esperado, br.consultar(b.getNome()).getNome());
		}catch (Exception e){
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}	
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		bairroMock.expects(once()).method("carregar").with(eq(b.getId())).will(returnValue(b));
		
		b.setNome("Bairro a");
		
		try {
			assertEquals("Bairro a", br.carregar(b.getId()).toString());
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		List<Bairro> listaBairros = new ArrayList<Bairro>();
		bairroMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Bairro>()));
		try {
			assertEquals(listaBairros, br.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	
}
