package br.ufg.inf.apsi.escola.componentes.acd.modelo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * Esta classe executa uma bateria de testes na classe <code>Avaliacao</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoTest extends TestCase {

	private Avaliacao a1;
	private Questao q1, q2, q3;
	private FormAvaliacao fa1, fa2, fa3, fa4, fa5;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		a1 = new Avaliacao(51L);
	}

	/**
	 * Executa testes no metodo "boolean setQuestoes(List<Questao> questoes)".
	 */
	public final void testSetQuestoes() {
		List<Questao> questoes = new ArrayList<Questao>();

		questoes.add(new Questao("Questao_01"));
		questoes.add(new Questao(true, "Questao_02"));
		questoes.add(new Questao("Questao_03"));
		assertTrue(a1.setQuestoes(questoes));

		questoes.add(new Questao(true, "Questao_02"));
		assertFalse(a1.setQuestoes(questoes));
	}

	/**
	 * Executa testes em todos os metodos que manipulam <code>Questao</code>.
	 */
	public final void testManipularQuestao() {
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		q3 = new Questao("Questao_01");

		q1.setId(1L);
		q2.setId(2L);
		q3.setId(3L);

		assertTrue(a1.adicionarQuestao(q1));
		assertTrue(a1.adicionarQuestao(q2));
		assertFalse(a1.adicionarQuestao(q3));
		assertTrue(a1.adicionarQuestao(true, "Questao_04"));
		assertFalse(a1.adicionarQuestao(false, ""));

		assertEquals(3, a1.getQuestoes().size());

		assertEquals(q1, a1.getQuestao(1L));
		assertEquals(q2, a1.getQuestao(1));

		assertNotNull(a1.removerQuestao(2));
		assertTrue(a1.removerQuestao(q2));

		assertEquals(1, a1.getQuestoes().size());
	}

	/**
	 * Executa testes em todos os metodos que manipulam
	 * <code>FormAvaliacao</code>.
	 */
	public final void testManipularFormAvaliacao() {
		fa1 = new FormAvaliacao(1L, a1);
		fa2 = new FormAvaliacao(2L);
		fa3 = new FormAvaliacao(a1);
		fa4 = new FormAvaliacao(1L, a1);
		fa5 = new FormAvaliacao(3L, a1);

		fa1.setId(1L);
		fa2.setId(2L);
		fa3.setId(3L);
		fa4.setId(4L);
		fa5.setId(5L);

		assertTrue(a1.adicionarFormAvaliacao(fa1));
		assertTrue(a1.adicionarFormAvaliacao(fa2));
		assertFalse(a1.adicionarFormAvaliacao(fa3));
		assertFalse(a1.adicionarFormAvaliacao(fa4));
		assertTrue(a1.adicionarFormAvaliacao(fa5));
		assertNotNull(a1.adicionarFormAvaliacao(4L));

		assertEquals(4, a1.getFormulariosAvaliacao().size());

		assertEquals(fa1, a1.getFormAvaliacao(1L));
		assertEquals(fa2, a1.getFormAvaliacaoAluno(2L));
		assertEquals(fa5, a1.getFormAvaliacaoAluno(3L));
		assertNotNull(a1.getFormAvaliacaoAluno(4L));

		assertTrue(a1.removerFormAvaliacao(fa1));
		assertEquals(fa2, a1.removerFormAvaliacao(2L));
		assertEquals(fa5, a1.removerFormAvaliacao(3L));
		assertNotNull(a1.removerFormAvaliacao(4L));

		assertEquals(0, a1.getFormulariosAvaliacao().size());
	}

	/**
	 * Executa testes no metodo "public int hashCode()"
	 */
	public final void testHashCode() {
		Avaliacao a2, a3;
		int i, j, k;

		a2 = new Avaliacao(29L);
		a3 = new Avaliacao(29L);

		i = a1.hashCode();
		j = a2.hashCode();
		k = a3.hashCode();

		assertNotSame(i, j);
		assertNotSame(i, k);
		assertEquals(j, k);
	}

	/**
	 * Executa testes no metodo "public boolean equals(Object obj)"
	 */
	public final void testEquals() {
		Avaliacao a2, a3;

		a2 = new Avaliacao(29L);
		a3 = new Avaliacao(29L);

		assertFalse(a1.equals(a2));
		assertFalse(a1.equals(a3));
		assertTrue(a2.equals(a3));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoTest.class);
	}
}
