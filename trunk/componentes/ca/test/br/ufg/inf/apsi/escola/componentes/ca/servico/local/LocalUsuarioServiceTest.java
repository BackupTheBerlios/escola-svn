package br.ufg.inf.apsi.escola.componentes.ca.servico.local;

import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.negocio.UsuarioNegocio;

/**
 * Classe de testes referente à implementação da camada de serviço
 * 
 * @author leandro
 * 
 */
@RunWith(JMock.class)
public class LocalUsuarioServiceTest {

	Mockery context = new JUnit4Mockery();

	long uid;
	long idPessoa;
	String username, senha, senhaAntiga, senhaNova;
	boolean disponibilidade;
	UsuarioNegocio usuarioNegocio;
	LocalUsuarioService localUsuarioService;
	GregorianCalendar cal;

	@Before
	public void iniciarTeste() {

		uid = 100L;
		idPessoa = 1L;
		username = "leandro";
		senha = "123";
		senhaAntiga = "123";
		senhaNova = "321";
		disponibilidade = true;
		cal = (GregorianCalendar) GregorianCalendar.getInstance();

		usuarioNegocio = context.mock(UsuarioNegocio.class);
		localUsuarioService = new LocalUsuarioService(usuarioNegocio);
	}

	@Test
	public void testAlterarSenha() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).alterarSenha(username, senhaAntiga,
							senhaNova);
				}
			});

			localUsuarioService.alterarSenha("leandro", "123", "321");

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}

	}

	@Test
	public void testAlterarValidade() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).alterarValidade(username, cal);
				}
			});

			localUsuarioService.alterarValidade("leandro", cal);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}

	}

	@Test
	public void testAlterarDisponibilidade() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).alterarDisponibilidade(username,
							disponibilidade);
				}
			});

			localUsuarioService.alterarDisponibilidade("leandro", true);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testCadastrarUsuarios() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).cadastrarUsuario(idPessoa, username,
							disponibilidade, cal);
				}
			});

			localUsuarioService.cadastrarUsuario(1L, "leandro", true, cal);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testChecarValidade() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).checarValidade(username);
				}
			});

			localUsuarioService.checarValidade(username);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testChecarDisponibilidade() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).checarUsuarioDisponivel(username);
				}
			});

			localUsuarioService.checarUsuarioDisponivel(username);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testListaUsuariosDisponibilidade() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).listaUsuariosDisponibilidade(
							disponibilidade);
				}
			});

			localUsuarioService.listaUsuariosDisponibilidade(true);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testListaUsuariosValidade() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).listaUsuariosValidade(cal);
				}
			});

			localUsuarioService.listaUsuariosValidade(cal);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testListaTodosUsuarios() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).listaTodosUsuarios();
				}
			});

			localUsuarioService.listaTodosUsuarios();

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testRecuperarSenha() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).recuperarSenha(username);
				}
			});

			localUsuarioService.recuperarSenha(username);

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testRemoverUsuario() {

		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).removerUsuario(username);
				}
			});

			localUsuarioService.removerUsuario("leandro");

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testConsultaUsuario() {
		try {
			context.checking(new Expectations() {
				{
					one(usuarioNegocio).consultaUsuario(username);
				}
			});

			localUsuarioService.consultaUsuario("leandro");

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}
}
