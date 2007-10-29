package br.ufg.inf.apsi.escola.componentes.acd.modelo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>FormAvaliacao</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoTest extends TestCase {

	private FormAvaliacao fa1;
	private Questao q1, q2, q3, q4, q5;
	private Resposta r1, r2, r3, r4, r5;

	/**
	 * Executa testes no metodo "boolean setRespostas(List<Resposta>
	 * respostas)".
	 */
	public final void testSetRespostas() {
		List<Resposta> respostas = new ArrayList<Resposta>();

		fa1 = new FormAvaliacao();

		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		q3 = new Questao("Questao_03");

		respostas.add(new Resposta(q1, "Resposta_01"));
		respostas.add(new Resposta(q2, "Resposta_02"));
		respostas.add(new Resposta(q3, "Resposta_03"));
		assertTrue(fa1.setRespostas(respostas));

		respostas.add(new Resposta(q2, "Resposta_02"));
		assertFalse(fa1.setRespostas(respostas));
	}

	/**
	 * Executa testes em todos os metodos que manipulam <code>Resposta</code>.
	 */
	public final void testManipularResposta() {
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		q3 = new Questao("Questao_03");
		q4 = new Questao(true, "Questao_04");
		q5 = new Questao("Questao_05");

		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta_02");
		r3 = new Resposta(q3);
		r4 = new Resposta(q4, "Resposta_04");
		r5 = new Resposta(q4);

		r1.setId(1L);
		r2.setId(2L);
		r3.setId(3L);
		r4.setId(4L);
		r5.setId(5L);

		fa1 = new FormAvaliacao();

		assertTrue(fa1.adicionarResposta(r1));
		assertTrue(fa1.adicionarResposta(r3));
		assertTrue(fa1.adicionarResposta(r4));
		assertTrue(fa1.adicionarResposta(1, r2));
		assertFalse(fa1.adicionarResposta(r5));
		assertTrue(fa1.adicionarResposta(q5, "Resposta_06"));

		assertEquals(5, fa1.getRespostas().size());

		assertEquals(r2, fa1.getResposta(1));
		assertEquals(r1, fa1.getResposta(1L));
		assertEquals(r4, fa1.getResposta(q4));

		assertNotNull(fa1.removerResposta(3));
		assertTrue(fa1.removerResposta(r3));

		assertEquals(3, fa1.getRespostas().size());
	}

	/**
	 * Executa testes no metodo "public int hashCode()"
	 */
	public final void testHashCode() {
		Avaliacao a1;
		FormAvaliacao fa2, fa3, fa4;
		int i, j, k, l;

		a1 = new Avaliacao(29L);
		fa1 = new FormAvaliacao();
		fa2 = new FormAvaliacao(99L, a1);
		fa3 = new FormAvaliacao(99L);
		fa4 = new FormAvaliacao(99L, a1);

		i = fa1.hashCode();
		j = fa2.hashCode();
		k = fa3.hashCode();
		l = fa4.hashCode();

		assertNotSame(i, j);
		assertNotSame(i, k);
		assertNotSame(i, l);
		assertNotSame(j, k);
		assertEquals(j, l);
		assertNotSame(k, l);
	}

	/**
	 * Executa testes no metodo "public boolean equals(Object obj)"
	 */
	public final void testEquals() {
		Avaliacao a1;
		FormAvaliacao fa2, fa3, fa4;

		a1 = new Avaliacao(29L);
		fa1 = new FormAvaliacao();
		fa2 = new FormAvaliacao(99L, a1);
		fa3 = new FormAvaliacao(99L);
		fa4 = new FormAvaliacao(99L, a1);

		assertFalse(fa1.equals(fa2));
		assertFalse(fa1.equals(fa3));
		assertFalse(fa1.equals(fa4));
		assertFalse(fa2.equals(fa3));
		assertTrue(fa2.equals(fa4));
		assertFalse(fa3.equals(fa4));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(FormAvaliacaoTest.class);
	}
}
