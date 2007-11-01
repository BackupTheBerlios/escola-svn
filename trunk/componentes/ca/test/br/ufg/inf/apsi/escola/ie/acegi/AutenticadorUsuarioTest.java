package br.ufg.inf.apsi.escola.ie.acegi;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessResourceFailureException;

import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;

/**
 * Implementação dos testes referentes à classe AutenticadorUsuario. Esta classe
 * é a responsável pela autenticação dos usuários do sistema.
 * 
 * @author leandro
 * 
 */
@RunWith(JMock.class)
public class AutenticadorUsuarioTest {

	static Mockery context1 = new JUnit4Mockery();
	static Mockery context2 = new JUnit4Mockery();
	static Mockery context3 = new JUnit4Mockery();
	static Mockery context4 = new JUnit4Mockery();
	static Mockery context5 = new JUnit4Mockery();

	AutenticadorUsuario autenticadorUsuario;

	static UsuarioService usuarioService;
	static PessoaService pessoaService;
	static SecretarioService secretarioService;
	static AlunoService alunoService;
	static DocenteService docenteService;

	UsuarioAutenticado usuarioAutenticado;

	static Long pessoaId = 10L;

	final Object[] vetorDadosUsuario = new Object[6];

	/**
	 * Inicialização dos objetos que ocorre sempre antes de cada teste.
	 */
	@Before
	public void iniciarTeste() {

		usuarioService = context1.mock(UsuarioService.class);
		pessoaService = context2.mock(PessoaService.class);
		alunoService = context3.mock(AlunoService.class);
		docenteService = context4.mock(DocenteService.class);
		secretarioService = context5.mock(SecretarioService.class);

		autenticadorUsuario = new AutenticadorUsuario(usuarioService,
				pessoaService, alunoService, docenteService, secretarioService);
	}

	/**
	 * Testa o método loadUserByUsername proveniente da interface
	 * UserDetailsService. Um usuário comum cadastrado no sistema é testado.
	 */
	@Test
	public void testLoadUserByUsernameComUsuarioComum() {

		vetorDadosUsuario[0] = 1L; // Uid
		vetorDadosUsuario[1] = "leandro"; // Username
		vetorDadosUsuario[2] = "123"; // Senha
		vetorDadosUsuario[3] = false; // Disponibilidade
		vetorDadosUsuario[4] = pessoaId; // IdPessoa
		vetorDadosUsuario[5] = "22/10/2008"; // Data de Validade

		/**
		 * Simula as consultas feitas através da interface UsuarioServie
		 */
		try {
			context1.checking(new Expectations() {
				{
					one(usuarioService).consultaUsuario("leandro");
					will(returnValue(vetorDadosUsuario));

					allowing(usuarioService).checarValidade("leandro");
					will(returnValue(true));
				}
			});
		} catch (UsuarioException e1) {
			fail("Não deveria ter lançado um UsuarioException!");
		}

		/**
		 * Simula as consultas feitas na interface PessoaService
		 */
		try {
			context2.checking(new Expectations() {
				{
					one(pessoaService).consultaPessoaId(pessoaId);
					will(returnValue("Leandro Pires Rabelo"));
				}
			});
		} catch (EscolaException e) {
			e.printStackTrace();
		}

		/**
		 * Simula as consultas feitas na interface AlunoService
		 */
		context3.checking(new Expectations() {
			{
				one(alunoService).isAluno(pessoaId);
				will(returnValue(false));
			}
		});

		/**
		 * Simula as consultas feitas na interface DocenteService
		 */
		context4.checking(new Expectations() {
			{
				one(docenteService).isDocente(pessoaId);
				will(returnValue(false));
			}
		});

		/**
		 * Simula as consultas feitas na interface SecretarioService
		 */
		context5.checking(new Expectations() {
			{
				one(secretarioService).isSecretario(pessoaId);
				will(returnValue(true));
			}
		});

		/**
		 * Chama o método loadUserByUsername da classe AutenticadorUsuario
		 */
		usuarioAutenticado = (UsuarioAutenticado) autenticadorUsuario
				.loadUserByUsername("leandro");

		assertNotNull(usuarioAutenticado);
		assertEquals(1, usuarioAutenticado.getAuthorities().length);
		assertEquals("leandro", usuarioAutenticado.getUsername());
		assertEquals("123", usuarioAutenticado.getPassword());
		assertEquals("22/10/2008", usuarioAutenticado.getValidade());

	}

	/**
	 * Testa o método loadUserByUsername proveniente da interface
	 * UserDetailsService. O usuário administrador cadastrado no sistema é
	 * testado.
	 * 
	 * @throws UsuarioException
	 * @throws DataAccessResourceFailureException
	 */
	@Test
	public void testLoadUserByUsernameComAdministrador()
			throws UsuarioException, DataAccessResourceFailureException {

		vetorDadosUsuario[0] = 0L;
		vetorDadosUsuario[1] = "administrador";
		vetorDadosUsuario[2] = "escola";
		vetorDadosUsuario[3] = true;
		vetorDadosUsuario[4] = 0L;
		vetorDadosUsuario[5] = "30/12/2099";

		/**
		 * Simula as consultas feitas através da interface UsuarioServie
		 */
		context1.checking(new Expectations() {
			{
				one(usuarioService).consultaUsuario("administrador");
				will(returnValue(vetorDadosUsuario));
			}
		});

		/**
		 * Chama o método loadUserByUsername da classe AutenticadorUsuario
		 */
		usuarioAutenticado = (UsuarioAutenticado) autenticadorUsuario
				.loadUserByUsername("administrador");

		assertNotNull(usuarioAutenticado);
		assertEquals(1, usuarioAutenticado.getAuthorities().length);
		assertEquals("administrador", usuarioAutenticado.getUsername());
		assertEquals("escola", usuarioAutenticado.getPassword());
		assertEquals("30/12/2099", usuarioAutenticado.getValidade());
		assertEquals("Administrador do Sistema", usuarioAutenticado
				.getNomePessoa());
		assertEquals(true, usuarioAutenticado.isAccountNonExpired());
	}
}
