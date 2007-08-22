package br.ufg.inf.apsi.escola.componentes.pessoa.teste;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EmailCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;


/**
 * Classe definida para testar a interface Repository
 * @author Gilmar
 *
 */
public class EmailRepositoryTeste extends MockObjectTestCase{

	private Email email = new Email();
	private Mock mailMock = new Mock(EmailRepository.class);
	private EmailRepository er = (EmailRepository) mailMock.proxy();
	/**
	 * 
	 */
	public void testaIncluir() {
		
		email.setEmail("gilmar@especializacao.info");
		
		mailMock.expects(once()).method("incluir").with(eq(email)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, er.incluir(email));
		} catch (EmailCadastradoException e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 */
	public void testaRemover(){
	
		mailMock.expects(once()).method("remover").with(eq(email.getId())).will(returnValue(true));
			
		boolean esperado = true;
		
		try{
			assertEquals(esperado, er.remover(email.getEmail()));
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaSalvar(){
		
		email.setEmail("alguem@provedor.com.br");
		
		mailMock.expects(once()).method("salvar").with(eq(email)).will(returnValue(true));

		boolean esperado = true;
		
		try {
			assertEquals(esperado, er.salvar(email));
		} catch (EscolaException e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}		
	}
	/**
	 * 
	 */
	public void testaConsultar(){
		
		email.setEmail("alguem@provedor.com.br");
		
		mailMock.expects(once()).method("consultar").with(eq(email.getEmail())).will(returnValue(email));
		
		String esperado = "alguem@provedor.com.br";
		
		try{
			assertEquals(esperado, er.consultar(email.getEmail()).toString());
		}catch (Exception e){
			new EscolaException(e.getMessage()).printStackTrace();
		}	
	}
	/**
	 * 
	 */
	public void testaCarregar(){
		
		mailMock.expects(once()).method("carregar").with(eq(email.getId())).will(returnValue(email));
		
		Long emailId = null;
		
		try {
			assertEquals(emailId, er.carregar(email.getId()).toString());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void testaListaTodos(){
		
		List<Email> listaEmails = new ArrayList<Email>();
		
		mailMock.expects(once()).method("listaTodos").will(returnValue(new ArrayList<Email>()));
		
		try {
			assertEquals(listaEmails, er.listaTodos());
		} catch (Exception e) {
			new EscolaException(e.getMessage()).printStackTrace();
		}
	}
}
