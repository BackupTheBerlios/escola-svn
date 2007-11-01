package br.ufg.inf.apsi.escola.ie.acegi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.anonymous.AnonymousAuthenticationToken;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;

/**
 * Testa a classe ControladorDeAutenticacao com dados persistidos no banco de
 * dados. Utiliza as configurações dos arquivos de contexto do spring
 * applicationContext.xml e acegi-security.xml
 * 
 * @author leandro
 * 
 */
@RunWith(JMock.class)
public class ControladorDeAutenticacaoUsandoPersistenciaTest {

	Mockery context1 = new JUnit4Mockery();
	Mockery context2 = new JUnit4Mockery();
	Mockery context3 = new JUnit4Mockery();
	Mockery context4 = new JUnit4Mockery();

	ControladorDeAutenticacao controlador;
	MockHttpServletRequest mockRequest;
	Authentication auth;
	PessoaService pessoaService;
	SecretarioService secretarioService;
	DocenteService docenteService;
	AlunoService alunoService;

	/**
	 * Lê o arquivo de configuração do Spring.
	 */
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	/**
	 * Inicia alguns atributos e objetos para que os testes possam transcorrer
	 * corretamente
	 */
	@Before
	public void iniciarTeste() {

		controlador = new ControladorDeAutenticacao();

		pessoaService = context1.mock(PessoaService.class);
		secretarioService = context2.mock(SecretarioService.class);
		docenteService = context3.mock(DocenteService.class);
		alunoService = context4.mock(AlunoService.class);

		AuthenticationManager manager = (AuthenticationManager) ctx
				.getBean("authenticationManager");

		controlador.setAuthenticationManager(manager);

		AutenticadorUsuario au = (AutenticadorUsuario) ctx
				.getBean("autenticadorUsuario");

		au.setPessoaService(pessoaService);
		au.setSecretarioService(secretarioService);
		au.setDocenteService(docenteService);
		au.setAlunoService(alunoService);

		mockRequest = new MockHttpServletRequest("GET", "/faces/Login.jsp");

	}

	/**
	 * Testa o método autenticar passando um usuário e uma senha existentes no
	 * banco de dados.
	 */
	@Test
	public void testAutenticar() {
		/**
		 * Simula a consulta na interface PessoaService
		 */
		try {
			context1.checking(new Expectations() {
				{
					one(pessoaService).consultaPessoaId(1L);
					will(returnValue("Romario"));
				}
			});
		} catch (EscolaException e1) {
			e1.printStackTrace();
		}

		/**
		 * Simula a consulta na interface SecretarioService
		 */
		context2.checking(new Expectations() {
			{
				one(secretarioService).isSecretario(1L);
				will(returnValue(true));
			}
		});

		/**
		 * Simula a consulta na interface DocenteService
		 */
		context3.checking(new Expectations() {
			{
				one(docenteService).isDocente(1L);
				will(returnValue(true));
			}
		});

		/**
		 * Simula a consulta na interface AlunoService
		 */
		context4.checking(new Expectations() {
			{
				one(alunoService).isAluno(1L);
				will(returnValue(true));
			}
		});

		/**
		 * Chama o método autenticar da classe ControladorDeAutenticacao
		 */
		try {
			controlador.autenticar(mockRequest, "romario", "111");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Nao deveria ter lancado uma Exception");
		}

		/**
		 * Obtém um objeto do tipo UsernamePasswordAuthenticationToken de dentro
		 * do contexto seguro
		 */
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		/**
		 * Faz as verificações
		 */
		assertTrue(token.isAuthenticated());
		assertEquals("romario", token.getName());
		assertEquals(token.getAuthorities()[0], "SECRETARIO");
		assertEquals(token.getAuthorities()[1], "DOCENTE");
		assertEquals(token.getAuthorities()[2], "ALUNO");
	}

	/**
	 * Testa o método logout
	 */
	@Test
	public void testLogout() {
		/**
		 * Simula a consulta na interface PessoaService
		 */
		try {
			context1.checking(new Expectations() {
				{
					one(pessoaService).consultaPessoaId(2L);
					will(returnValue("Robson da Silva"));
				}
			});
		} catch (EscolaException e1) {
			e1.printStackTrace();
		}

		/**
		 * Simula a consulta na interface SecretarioService
		 */
		context2.checking(new Expectations() {
			{
				one(secretarioService).isSecretario(2L);
				will(returnValue(true));
			}
		});

		/**
		 * Simula a consulta na interface DocenteService
		 */
		context3.checking(new Expectations() {
			{
				one(docenteService).isDocente(2L);
				will(returnValue(true));
			}
		});

		/**
		 * Simula a consulta na interface AlunoService
		 */
		context4.checking(new Expectations() {
			{
				one(alunoService).isAluno(2L);
				will(returnValue(true));
			}
		});

		/**
		 * Chama o método autenticar para em seguid fazer logout
		 */
		try {
			controlador.autenticar(mockRequest, "robinho", "222");
			controlador.logout(mockRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testa uma autenticação anônima
	 */
	@Test
	public void testAutenticacaoAnonima() {
		/**
		 * Obtém o bean do contexto do spring
		 */
		AuthenticationProvider provider = (AuthenticationProvider) ctx
				.getBean("anonymousAuthenticationProvider");
		/**
		 * Faz a autenticação do usuario anonimo
		 */
		Authentication auth = provider
				.authenticate(new AnonymousAuthenticationToken("foobar",
						"anonymousUser",
						new GrantedAuthority[] { new GrantedAuthorityImpl(
								"ANONYMOUS") }));
		/**
		 * Guarda no contexto seguro as informações da autenticação
		 */
		SecurityContextHolder.getContext().setAuthentication(auth);

		/**
		 * Obtém um objeto do tipo AnonymousAuthenticationToken de dentro do
		 * contexto seguro
		 */
		AnonymousAuthenticationToken token = (AnonymousAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		/**
		 * Faz as verificações
		 */
		assertTrue(token.isAuthenticated());
		assertEquals("anonymousUser", token.getName());
	}
}
