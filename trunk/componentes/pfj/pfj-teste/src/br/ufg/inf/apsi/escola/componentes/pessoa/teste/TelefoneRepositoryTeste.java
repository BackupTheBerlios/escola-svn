package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TelefoneCadastradoException;


/**
 * Classe de teste para a interface TelefoneRepository.
 * @author Gilmar
 *
 */
public class TelefoneRepositoryTeste extends MockObjectTestCase{
	
	private Telefone t = new Telefone();
	private Mock telefoneMock = new Mock(TelefoneRepository.class);
	private TelefoneRepository tr = (TelefoneRepository) telefoneMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir() {
				
		telefoneMock.expects(once()).method("incluir").with(eq(t)).will(returnValue(true));

		boolean esperado = true;
		try {
			assertEquals(esperado, tr.incluir(t));
		} catch (TelefoneCadastradoException e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
		
		telefoneMock.expects(once()).method("remover").with(eq(t.getId())).will(returnValue(true));
		
		boolean esperado = true;
		
		try{
			assertEquals(esperado, tr.remover(t.getId()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		telefoneMock.expects(once()).method("salvar").with(eq(t)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, tr.salvar(t));
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		
		t.setNumero(98765678);
		
		telefoneMock.expects(once()).method("consultar").with(eq(t.getNumero())).will(returnValue(t));
		
		Long idFone = null;
		
		try{
			assertEquals(idFone, tr.consultar(t.getNumero()).getId());
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}	
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		telefoneMock.expects(once()).method("carregar").with(eq(t.getId())).will(returnValue(t));
		
		Long idFone = null;
		
		try{
			assertEquals(idFone, tr.carregar(t.getId()).getId());
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
		
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		
		telefoneMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Telefone>()));
		try {
			assertEquals(listaTelefones, tr.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}

}
