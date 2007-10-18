package br.ufg.inf.apsi.escola.componentes.ca.modelo;

import java.util.GregorianCalendar;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import junit.framework.TestCase;

/**
 * Classe de testes referente às classes do modelo
 * 
 * @author leandro
 * 
 */
public class UsuarioTest extends TestCase {

	private Usuario user1, user2;
	GregorianCalendar cal;

	protected void setUp() throws Exception {
		cal = (GregorianCalendar) GregorianCalendar.getInstance();
		user1 = new Usuario(new Long(001), "leandro", "abc", true, cal);
		user2 = new Usuario();
		user2.setIdPessoa(new Long(002));
		user2.setUsername("rose");
		user2.setSenha("www");
		user2.setDisponibilidade(true);
		user2.setValidade(cal);

	}

	public void testUsuario() throws java.text.ParseException {
		assertEquals(new Long(001), user1.getIdPessoa());
		assertEquals("leandro", user1.getUsername());
		assertEquals("abc", user1.getSenha());
		assertEquals(true, user1.getDisponibilidade());
		assertEquals(cal, user1.getValidade());

		assertEquals(new Long(002), user2.getIdPessoa());
		assertEquals("rose", user2.getUsername());
		assertEquals("www", user2.getSenha());
		assertEquals(true, user2.getDisponibilidade());
		assertEquals(cal, user2.getValidade());
	}

}