package br.ufg.inf.apsi.escola.componentes.acd.modelo;

import junit.framework.TestCase;

/**
 * Esta classe executa uma bateria de testes na classe <code>Resposta</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class RespostaTest extends TestCase {

	/**
	 * Executa testes no metodo "public int hashCode()"
	 */
	public final void testHashCode() {
		Questao q1, q2;
		Resposta r1, r2, r3;
		int i, j, k;

		q1 = new Questao(true, "Pergunta_01");
		q2 = new Questao("Pergunta");

		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta");
		r3 = new Resposta(q2, "Resposta");

		i = r1.hashCode();
		j = r2.hashCode();
		k = r3.hashCode();

		assertNotSame(i, j);
		assertNotSame(i, k);
		assertEquals(j, k);
	}

	/**
	 * Executa testes no metodo "public boolean equals(Object obj)"
	 */
	public final void testEquals() {
		Questao q1, q2;
		Resposta r1, r2, r3, r4;

		q1 = new Questao(true, "Pergunta_01");
		q2 = new Questao("Pergunta");

		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta");
		r3 = new Resposta(q2, "Resposta");
		r4 = new Resposta(q1, "Resposta");

		assertFalse(r1.equals(r2));
		assertFalse(r1.equals(r3));
		assertFalse(r1.equals(r4));
		assertTrue(r2.equals(r3));
		assertFalse(r2.equals(r4));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(RespostaTest.class);
	}
}
