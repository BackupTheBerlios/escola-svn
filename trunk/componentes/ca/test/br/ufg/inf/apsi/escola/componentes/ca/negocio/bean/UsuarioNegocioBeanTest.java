package br.ufg.inf.apsi.escola.componentes.ca.negocio.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import static org.hamcrest.Matchers.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.NenhumUsuarioEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.negocio.UsuarioNegocio;
import br.ufg.inf.apsi.escola.componentes.ca.negocio.bean.UsuarioNegocioBean;
import br.ufg.inf.apsi.escola.componentes.ca.repositorio.UsuarioRepositorio;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;
import br.ufg.inf.apsi.escola.ie.email.EmailService;

/**
 * Classe de testes referente à implementação da camada de negócio
 * 
 * @author leandro
 * 
 */
@RunWith(JMock.class)
public class UsuarioNegocioBeanTest {

	Mockery context1 = new JUnit4Mockery();
	Mockery context2 = new JUnit4Mockery();
	Mockery context3 = new JUnit4Mockery();

	UsuarioRepositorio usuarioRepositorio;
	PessoaService pessoaService;
	EmailService emailService;
	String username, senha, nomePessoa;
	boolean disponibilidade;
	UsuarioNegocio usuarioNegocio;
	UsuarioNegocioBean usuarioNegocioBean;
	Usuario usuario1, usuario2, usuario3;
	GregorianCalendar validade, data1, data2;

	String emailRemetente;
	String nomeRemetente;
	String assunto;
	String mensagem;
	String emailDestino;

	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	List<Usuario> listaUsuarios2 = new ArrayList<Usuario>();
	List<String> listaEmails = new ArrayList<String>();
	List<String> listaDocumentos = new ArrayList<String>();

	/**
	 * Inicia alguns atributos e objetos para que os testes possam transcorrer
	 * corretamente
	 */
	@Before
	public void iniciarTeste() {

		usuarioRepositorio = context1.mock(UsuarioRepositorio.class);
		pessoaService = context2.mock(PessoaService.class);
		emailService = context3.mock(EmailService.class);

		nomePessoa = "Maria da Silva Cardoso";
		username = "leandro";
		senha = "123";
		disponibilidade = true;
		validade = new GregorianCalendar();

		data1 = new GregorianCalendar(1998, Calendar.DECEMBER, 25);
		data2 = new GregorianCalendar(2008, Calendar.OCTOBER, 10);

		usuarioNegocioBean = new UsuarioNegocioBean(usuarioRepositorio,
				pessoaService, emailService);
		usuarioNegocioBean.setPessoaService(pessoaService);
		usuarioNegocioBean.setEmailservice(emailService);

		usuario1 = new Usuario(new Long(001), "leandro", "123", true, data1);
		usuario2 = new Usuario(new Long(002), "jose", "321", true, data2);
		usuario2.setUid(new Long(25));
		usuario3 = new Usuario();
		usuario3.setIdPessoa(new Long(003));
		usuario3.setUsername("maria");
		usuario3.setDisponibilidade(false);
		usuario3.setValidade(data1);
		usuario3.setSenha("aaa");

		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		listaDocumentos.add("123456");
		listaEmails.add("maria@especializacao.info");
	}

	@Test
	public void testCadastrarUsuario() throws UsuarioNaoEncontradoException {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio)
							.obterUsuario(usuario3.getUsername());
					will(throwException(new UsuarioNaoEncontradoException()));

					one(usuarioRepositorio).incluirUsuario(
							with(not(same(usuario3))));
				}
			});

			context2.checking(new Expectations() {
				{
					one(pessoaService)
							.listaEmailsPessoa(usuario3.getIdPessoa());
					will(returnValue(listaEmails));

					one(pessoaService).consultaPessoaId(usuario3.getIdPessoa());
					will(returnValue(nomePessoa));
				}
			});

			context3.checking(new Expectations() {
				{
					String mensagem = "Confira abaixo seus dados para uso no Sistema de Pós-Graduação - SISPG.\n"
							+ "Username = "
							+ usuario3.getUsername()
							+ "\n"
							+ "Senha = " + usuario3.getSenha() + "\n";

					one(emailService).enviarEmailTexto(listaEmails.get(0),
							"secretaria@inf.ufg.br",
							"Instituto de Informatica",
							"Senha do Sistema SISPG", not(same(mensagem))); // Passou nos testes!!
				}
			});

			usuarioNegocioBean.cadastrarUsuario(usuario3.getIdPessoa(),
					usuario3.getUsername(), usuario3.getDisponibilidade(),
					usuario3.getValidade());

		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		} catch (EscolaException e) {
			fail("Nao deveria ter lancado um EscolaException");
		}
	}

	@Test(expected = UsuarioException.class)
	public void testCadastrarUsuarioRepetido() throws UsuarioException {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio)
							.obterUsuario(usuario1.getUsername());
					will(returnValue(usuario1));
				}
			});
		} catch (UsuarioNaoEncontradoException e) {
			fail("Nao deveria ter lancado um UsuarioNaoEncontradoException");
		}

		usuarioNegocioBean.cadastrarUsuario(001, "leandro", true, data1);
	}

	@Test
	public void testAlterarUsuario() {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio).updateUsuario(usuario1);
				}
			});

			usuarioNegocioBean.alterarUsuario(usuario1);

		} catch (UsuarioException e1) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testObterListaDeTodosUsuarios()
			throws NenhumUsuarioEncontradoException, UsuarioException {

		List<String> lista;

		context1.checking(new Expectations() {
			{
				one(usuarioRepositorio).buscarTodosUsuarios();
				will(returnValue(listaUsuarios));
			}
		});

		lista = usuarioNegocioBean.listaTodosUsuarios();

		assertNotNull(lista);
		assertEquals(2, lista.size());
		assertEquals("leandro", lista.get(0));
	}

	@Test
	public void testObterListaUsuariosPelaDisponibilidade()
			throws NenhumUsuarioEncontradoException, UsuarioException {
		List<String> lista;

		context1.checking(new Expectations() {
			{
				one(usuarioRepositorio).buscarUsuariosPelaDisponibilidade(
						disponibilidade);
				will(returnValue(listaUsuarios));
			}
		});

		lista = usuarioNegocioBean
				.listaUsuariosDisponibilidade(disponibilidade);

		assertNotNull(lista);
		assertEquals(2, lista.size());
		assertEquals("jose", lista.get(1));
	}

	@Test
	public void testObterListaUsuariosPelaValidade() {
		List<String> lista;

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio)
							.buscarUsuariosPelaValidade(validade);
					will(returnValue(listaUsuarios));
				}
			});

			lista = usuarioNegocioBean.listaUsuariosValidade(validade);

			assertNotNull(lista);
			assertEquals(2, lista.size());
			assertEquals("jose", lista.get(1));

		} catch (NenhumUsuarioEncontradoException e) {
			fail("Não deveria ter lancado um NenhumUsuarioEncontradoException");
		} catch (UsuarioException e) {
			fail("Não deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testAlterarSenha() {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio).obterUsuario(username);
					will(returnValue(usuario1));
					one(usuarioRepositorio).updateUsuario(usuario1);
				}
			});

			usuarioNegocioBean.alterarSenha(username, "123", "321");

		} catch (UsuarioNaoEncontradoException e) {
			fail("Nao deveria ter lancado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testChecarUsernames() {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio).obterUsuario(username);
					will(returnValue(usuario1));
				}
			});
		} catch (UsuarioNaoEncontradoException e) {
			fail("Nao deveria ter lancado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
		assertTrue(usuarioNegocioBean.checarUsername(username));
		assertEquals("leandro", usuario1.getUsername());
	}

	@Test
	public void testChecarUsuarioDisponivel() {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio).obterUsuario(username);
					will(returnValue(usuario1));
				}
			});

			assertTrue(usuarioNegocioBean.checarUsuarioDisponivel(username));
			assertEquals("leandro", usuario1.getUsername());

		} catch (UsuarioNaoEncontradoException e) {
			fail("Nao deveria ter lancado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testChecarValidade() {

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio).obterUsuario("jose");
					will(returnValue(usuario2));
				}
			});

			assertTrue(usuarioNegocioBean.checarValidade("jose"));

		} catch (UsuarioNaoEncontradoException e) {
			fail("Nao deveria ter lancado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}
	}

	@Test
	public void testConsultaUsuario() {
		Object[] dadosUsuario = null;

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioRepositorio).obterUsuario("jose");
					will(returnValue(usuario2));
				}
			});

			context2.checking(new Expectations() {
				{
					one(pessoaService).consultaPessoaId(new Long(002));
					will(returnValue("Jose de Ribamar"));
				}
			});

			dadosUsuario = usuarioNegocioBean.consultaUsuario("jose");

			assertEquals(25L, dadosUsuario[0]);
			assertEquals("jose", dadosUsuario[1]);
			assertEquals("321", dadosUsuario[2]);
			assertEquals(true, dadosUsuario[3]);
			assertEquals("Jose de Ribamar", dadosUsuario[4]);
			assertEquals("10/10/2008", dadosUsuario[5]);

		} catch (UsuarioNaoEncontradoException e) {
			fail("Nao deveria ter lancado um UsuarioNaoEncontradoException");
		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		} catch (EscolaException e) {
			fail("Nao deveria ter lancado um EscolaException");
		}
	}
}