package br.ufg.inf.apsi.escola.componentes.ca.modelo;

import java.util.GregorianCalendar;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import junit.framework.TestCase;

/**
 * Classe de testes referente à classe Usuário do package modelo
 * 
 * @author leandro
 * 
 */
public class UsuarioTest extends TestCase {

	private Usuario user1, user2;
	GregorianCalendar cal1, cal2;

	/**
	 * Inicializa os objetos testando os métodos Set
	 */
	protected void setUp() throws Exception {

		cal1 = new GregorianCalendar(2008, 12, 30);
		cal2 = new GregorianCalendar(2009, 11, 25);

		user1 = new Usuario();
		user1.setUid(1L);
		user1.setIdPessoa(10L);
		user1.setUsername("robinho");
		user1.setSenha("123");
		user1.setDisponibilidade(true);
		user1.setValidade(cal1);

		user2 = new Usuario();
		user2.setUid(2L);
		user2.setIdPessoa(20L);
		user2.setUsername("romario");
		user2.setSenha("www");
		user2.setDisponibilidade(true);
		user2.setValidade(cal2);

	}

	/**
	 * Testa os métodos Get da classe Usuário
	 */
	public void testUsuario() {

		assertEquals(new Long(10), user1.getIdPessoa());
		assertEquals("robinho", user1.getUsername());
		assertEquals("123", user1.getSenha());
		assertEquals(true, user1.getDisponibilidade());
		assertEquals(cal1, user1.getValidade());

		assertEquals(new Long(20), user2.getIdPessoa());
		assertEquals("romario", user2.getUsername());
		assertEquals("www", user2.getSenha());
		assertEquals(true, user2.getDisponibilidade());
		assertEquals(cal2, user2.getValidade());
	}

}