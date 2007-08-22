package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.LogradouroCadastradoException;

/**
 * Clase definida para testar a interface LogradouroRepository
 * @author Gilmar
 *
 */
public class LogradouroRespositoryTeste extends MockObjectTestCase {
	
	private Logradouro log = new Logradouro();
	private Mock logMock = new Mock(LogradouroRepository.class);
	private LogradouroRepository lr = (LogradouroRepository) logMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir(){
				
		logMock.expects(once()).method("incluir").with(eq(log)).will(returnValue(true));

		boolean esperado = true;

		try {
			assertEquals(esperado, lr.incluir(log));
		} catch (LogradouroCadastradoException e) {
			e.getMessage();
		}		
	}
	/**
	 * 
	 */
	public void testaRemover(){
				
		logMock.expects(once()).method("remover").with(eq(log.getId())).will(returnValue(true));
				
		boolean esperado = true;
		
		try{
			assertEquals(esperado, lr.remover(log.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		logMock.expects(once()).method("salvar").with(eq(log)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, lr.salvar(log));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}				
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		
		log.setNome("Av. Republica do Libano");
		
		logMock.expects(once()).method("consultar").with(eq(log.getNome())).will(returnValue(log));
		
		String esperado = "Av. Republica do Libano";
		
		try{
			assertEquals(esperado, lr.consultar(log.getNome()).getNome());
		}catch (Exception e){
			new EscolaException(e.getCause().getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		logMock.expects(once()).method("carregar").with(eq(log.getId())).will(returnValue(log));
		
		Long logId = null;
		
		try {
			assertEquals(logId, lr.carregar(log.getId()).getId());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		List<Logradouro> listaLogradouros = new ArrayList<Logradouro>();
		
		logMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Logradouro>()));
		
		try {
			assertEquals(listaLogradouros, lr.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
}
