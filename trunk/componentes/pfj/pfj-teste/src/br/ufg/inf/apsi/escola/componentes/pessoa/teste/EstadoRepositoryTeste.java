package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EstadoCadastradoException;


/**
 * Classe definida para testar a interface EstadoRepository
 * @author Gilmar
 *
 */
public class EstadoRepositoryTeste extends MockObjectTestCase {
	
	private Estado est = new Estado();
	private Mock estMock = new Mock(EstadoRepository.class);
	private EstadoRepository estRep = (EstadoRepository) estMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir(){
				
		estMock.expects(once()).method("incluir").with(eq(est)).will(returnValue(true));

		boolean esperado = true;

		try {
			assertEquals(esperado, estRep.incluir(est));
		} catch (EstadoCadastradoException e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
		
		estMock.expects(once()).method("remover").with(eq(est.getId())).will(returnValue(true));
		
		boolean esperado = true;

		try{
			assertEquals(esperado, estRep.remover(est.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		estMock.expects(once()).method("salvar").with(eq(est)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, estRep.salvar(est));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		
		est.setSigla("GO");
		
		estMock.expects(once()).method("consultar").with(eq(est.getNome())).will(returnValue(est));
		
		String esperado = "GO"; 
		
		try {
			assertEquals(esperado, estRep.consultar(est.getNome()).getSigla());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		estMock.expects(once()).method("carregar").with(eq(est.getId())).will(returnValue(est));
		
		Long idEstado = null;
		
		try {
			assertEquals(idEstado, estRep.carregar(est.getId()).getId());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		
		List<Estado> listaEstados = new ArrayList<Estado>();
		
		estMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Estado>()));
		
		try {
			assertEquals(listaEstados, estRep.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
}
