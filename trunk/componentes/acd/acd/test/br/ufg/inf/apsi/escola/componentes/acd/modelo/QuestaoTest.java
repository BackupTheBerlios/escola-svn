package br.ufg.inf.apsi.escola.componentes.acd.modelo;

import junit.framework.TestCase;

/**
 * Esta classe executa uma bateria de testes na classe <code>Questao</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class QuestaoTest extends TestCase {

	/**
	 * Executa testes no metodo "public int hashCode()"
	 */
	public final void testHashCode() {
		Questao q1, q2, q3;
		int i, j, k;

		q1 = new Questao(true, "Pergunta_01");
		q2 = new Questao("Pergunta");
		q3 = new Questao("Pergunta");

		i = q1.hashCode();
		j = q2.hashCode();
		k = q3.hashCode();

		assertNotSame(i, j);
		assertNotSame(i, k);
		assertEquals(j, k);
	}

	/**
	 * Executa testes no metodo "public boolean equals(Object obj)"
	 */
	public final void testEquals() {
		Questao q1, q2, q3;

		q1 = new Questao(true, "Pergunta_01");
		q2 = new Questao("Pergunta");
		q3 = new Questao("Pergunta");

		assertFalse(q1.equals(q2));
		assertFalse(q1.equals(q3));
		assertTrue(q2.equals(q3));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(QuestaoTest.class);
	}
}
