package br.ufg.inf.apsi.escola.componentes.ca.repositorio.jpa.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.test.jpa.AbstractJpaTests;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.NenhumUsuarioEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.repositorio.UsuarioRepository;

/**
 * Classe de testes referentes à implementação do repositório. Os testes são
 * realizados utilizando a API spring-mock.jar, mais precisamente a classe
 * AbstractJpaTests. Esta classe utiliza as configurações presentes no arquivo
 * de contexto do spring applicationContext-TesteDados.xml.
 * 
 * @author leandro
 * 
 */
public class UsuarioRepositoryImplTest extends AbstractJpaTests {

	private UsuarioRepository usuarioRepositorio;
	Usuario user1, user2, user3;
	private String username1;
	private long userId1 = 99999L;
	private long userId2 = 99999L;
	private long userId3 = 99999L;
	private long idPessoa1 = 10L;
	private long idPessoa2 = 20L;
	private long idPessoa3 = 30L;
	private boolean disponibilidade = false;
	GregorianCalendar validade = new GregorianCalendar();
	GregorianCalendar data1 = new GregorianCalendar(1998, Calendar.DECEMBER, 25);
	GregorianCalendar data2 = new GregorianCalendar(2007, Calendar.OCTOBER, 10);

	public void setUsuarioRepositorio(UsuarioRepository usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/applicationContext-TesteDados.xml" };
	}

	/**
	 * Inicializaçao dos objetos para a realização dos testes
	 */
	protected void onSetUpInTransaction() throws Exception {

		user1 = new Usuario(idPessoa1, "jose", "123", true, data1);
		user2 = new Usuario(idPessoa2, "maria", "321", true, data1);
		user3 = new Usuario(idPessoa3, "severo", "123", false, data2);

		/* testIncluirUsuario() */
		usuarioRepositorio.incluirUsuario(user1);
		usuarioRepositorio.incluirUsuario(user2);
		usuarioRepositorio.incluirUsuario(user3);

		userId1 = user1.getUid();
		userId2 = user2.getUid();
		userId3 = user3.getUid();

		username1 = user1.getUsername();
	}

	/**
	 * Testa o método obterUsuario(Long uid)
	 */
	public void testObterUsuarioPeloId() {
		Usuario user1 = null;
		Usuario user2 = null;
		Usuario user3 = null;

		try {
			user1 = usuarioRepositorio.obterUsuario(userId1);
			user2 = usuarioRepositorio.obterUsuario(userId2);
			user3 = usuarioRepositorio.obterUsuario(userId3);
		} catch (UsuarioNaoEncontradoException e) {
			fail("Não deveria ter lançado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Não deveria ter lançado um UsuarioException");
		}

		assertNotNull(user1);
		assertNotNull(user2);
		assertNotNull(user3);
		assertEquals("jose", user1.getUsername());
		assertEquals("maria", user2.getUsername());
		assertEquals("severo", user3.getUsername());
	}

	/**
	 * Testa o método obterUsuario(String username)
	 */
	public void testObterUsuarioPeloUsername() {

		Usuario user1 = null;
		Usuario user2 = null;
		Usuario user3 = null;

		try {
			user1 = usuarioRepositorio.obterUsuario("jose");
			user2 = usuarioRepositorio.obterUsuario("maria");
			user3 = usuarioRepositorio.obterUsuario("severo");

			assertNotNull(user1);
			assertNotNull(user2);
			assertNotNull(user3);
			assertEquals("maria", user2.getUsername());

		} catch (UsuarioNaoEncontradoException e) {
			fail("Não deveria ter lançado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Não deveria ter lançado um UsuarioException");
		}

	}

	/**
	 * Testa o método buscarTodosUsuarios
	 */
	public void testBuscarTodosUsuarios() {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		try {
			listaUsuarios = usuarioRepositorio.buscarTodosUsuarios();

			assertEquals(3, listaUsuarios.size());
			assertTrue(listaUsuarios.contains(user1));
			assertTrue(listaUsuarios.contains(user2));
			assertTrue(listaUsuarios.contains(user3));

		} catch (NenhumUsuarioEncontradoException e) {
			fail("Não deveria lançar um UsuarioNaoEncontradoException!");
		} catch (UsuarioException e) {
			fail("Deveria lançar um UsuarioException!");
		}
	}

	/**
	 * Testa o método buscarUsuariosPelaDisponibilidade(boolean disponibilidade)
	 */
	public void testBuscarUsuariosPelaDisponibilidade() {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		try {
			listaUsuarios = usuarioRepositorio
					.buscarUsuariosPelaDisponibilidade(disponibilidade);

			assertFalse(listaUsuarios.isEmpty());
			assertEquals(1, listaUsuarios.size());
			assertTrue(listaUsuarios.contains(user3));

		} catch (NenhumUsuarioEncontradoException e) {
			fail("Não deveria lançar um NenhumUsuarioEncontradoException!");
		} catch (UsuarioException e) {
			fail("Não deveria lançar um UsuarioException!");
		}
	}

	/**
	 * Testa o método buscarUsuariosPelaValidade(GregorianCalendar validade)
	 */
	public void testBuscarUsuariosPelaValidade() {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		try {
			listaUsuarios = usuarioRepositorio
					.buscarUsuariosPelaValidade(data1);

			assertFalse(listaUsuarios.isEmpty());
			assertEquals(2, listaUsuarios.size());
			assertTrue(listaUsuarios.contains(user1));
			assertTrue(listaUsuarios.contains(user2));

		} catch (NenhumUsuarioEncontradoException e) {
			fail("Não deveria lançar um NenhumUsuarioEncontradoException!");
		} catch (UsuarioException e) {
			fail("Não deveria lançar um UsuarioException!");
		}
	}

	/**
	 * Testa o método updateUsuario(Usuario usuario)
	 */
	public void testUpdateUsuario() {
		String username = "severo";
		String senhaAntiga = "123";
		String senhaNova = "AAA";
		Usuario user1 = null;
		Usuario user2 = null;

		try {
			user1 = usuarioRepositorio.obterUsuario(username);
			assertEquals(senhaAntiga, user1.getSenha());

			user1.setSenha(senhaNova);
			usuarioRepositorio.updateUsuario(user1);

			user2 = usuarioRepositorio.obterUsuario(username);
			assertEquals(senhaNova, user2.getSenha());

		} catch (UsuarioNaoEncontradoException e) {
			fail("Não deveria lançar um UsuarioNaoEncontradoException!");
		} catch (UsuarioException e) {
			fail("Não deveria lançar um UsuarioException!");
		}
	}

	/**
	 * Testa o método excluirUsuario(String username)
	 */
	public void testExcluirUsuario() {

		Usuario user1 = null;

		try {
			usuarioRepositorio.excluirUsuario(username1);

		} catch (UsuarioNaoEncontradoException e) {
			fail("Não deveria lançar um UsuarioNaoEncontradoException!");
		} catch (UsuarioException e) {
			fail("Não deveria lançar um UsuarioException!");
		}

		try {
			user1 = usuarioRepositorio.obterUsuario(userId1);
			fail("Deveria lançar um UsuarioNaoEncontradoException!");
		} catch (UsuarioNaoEncontradoException e) {
			assertNull(user1);
		} catch (UsuarioException e) {

		}
	}
}
