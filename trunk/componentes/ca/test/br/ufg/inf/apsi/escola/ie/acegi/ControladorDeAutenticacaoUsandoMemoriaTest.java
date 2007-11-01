package br.ufg.inf.apsi.escola.ie.acegi;

import junit.framework.TestCase;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Testa a classe ControladorDeAutenticacao com dados setados nos arquivo de
 * contexto do spring applicationContext-TesteDados.xml e
 * acegi-security-teste.xml
 * 
 * @author leandro
 * 
 */
public class ControladorDeAutenticacaoUsandoMemoriaTest extends TestCase {

	ControladorDeAutenticacao controlador;
	MockHttpServletRequest mockRequest;
	Authentication auth;

	/**
	 * Lê o arquivo de configuração do Spring.
	 */
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext-TesteDados.xml");

	/**
	 * Inicia alguns atributos e objetos para que os testes possam transcorrer
	 * corretamente
	 */
	public void setUp() {

		controlador = new ControladorDeAutenticacao();

		AuthenticationManager manager = (AuthenticationManager) ctx
				.getBean("authenticationManager");

		controlador.setAuthenticationManager(manager);

		// Mock object referente a um HttpServletRequest
		mockRequest = new MockHttpServletRequest("GET", "/faces/Login.jsp");
	}

	/**
	 * Testa o método autenticar da clasee ControladorDeAutenticacao passando
	 * como parametros o username "administrador" e a senha "admin"
	 */
	public void testAutenticarComAdministrador() {

		try {
			controlador.autenticar(mockRequest, "administrador", "admin");
		} catch (Exception e) {
			fail("Nao deveria ter lancado uma Exception");
		}

		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		assertTrue(token.isAuthenticated());
		assertEquals("administrador", token.getName());
		assertEquals(token.getAuthorities()[0], "ADMIN");
	}

	/**
	 * Testa o método autenticar da clasee ControladorDeAutenticacao passando
	 * como parametros o username "leandro" e a senha "123"
	 */
	public void testAutenticarComUsuarioComum() {

		try {
			controlador.autenticar(mockRequest, "leandro", "123");
		} catch (Exception e) {
			fail("Nao deveria ter lancado uma Exception");
		}

		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		assertTrue(token.isAuthenticated());
		assertEquals("leandro", token.getName());
		assertEquals(token.getAuthorities()[0], "SECRETARIO");
	}

	/**
	 * Testa o método logout
	 */
	public void testLogout() {

		try {
			controlador.autenticar(mockRequest, "administrador", "admin");
			controlador.logout(mockRequest);
		} catch (Exception e) {
			fail("Nao deveria ter lancado uma Exception");
		}
	}
}
