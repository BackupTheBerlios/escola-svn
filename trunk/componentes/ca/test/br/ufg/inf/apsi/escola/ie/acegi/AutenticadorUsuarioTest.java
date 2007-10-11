package br.ufg.inf.apsi.escola.ie.acegi;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;

@RunWith(JMock.class)
public class AutenticadorUsuarioTest {

	Mockery context1 = new JUnit4Mockery();

	AutenticadorUsuario autenticadorUsuario;
	UserDetails usuarioAutenticado;
	String username, senha;
	UsuarioService usuarioService;
	Usuario usuario1;
	boolean disponibilidade;
	GregorianCalendar data1;

	@Before
	public void iniciarTeste() {

		usuarioService = context1.mock(UsuarioService.class);
		autenticadorUsuario = new AutenticadorUsuario(usuarioService);

		username = "leandro";
		senha = "123";
		disponibilidade = true;
		data1 = new GregorianCalendar(1998, Calendar.DECEMBER, 25);
		usuario1 = new Usuario(new Long(001), "leandro", "123", true, data1);
		usuario1.setUid(new Long(25));
	}

	@Test
	public void testLoadUserByUsername() {

		final String dadosUsuario = 25 + "\n" + "leandro" + "\n" + "123" + "\n"
				+ true + "\n" + "25/12/2011" + "\n" + 1 + "\n";

		UserDetails userdetails;

		try {
			context1.checking(new Expectations() {
				{
					one(usuarioService).consultaUsuario(usuario1.getUsername());
					will(returnValue(dadosUsuario));
				}
			});
		} catch (UsuarioException e) {
			fail("Nao deveria ter lancado um UsuarioException");
		}

		userdetails = autenticadorUsuario.loadUserByUsername("leandro");

		assertEquals(userdetails.getUsername(), usuario1.getUsername());
		assertEquals(userdetails.getPassword(), usuario1.getSenha());
		assertEquals(userdetails.isEnabled(), usuario1.getDisponibilidade());
	}
}