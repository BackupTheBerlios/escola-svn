package de.berlios.escola.acd.src;

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
	private Aluno al1, al2, al3, al4;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		a1 = new Avaliacao();
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
	 * Executa testes em todos os metodos que manipulam <code>FormAvaliacao</code>. 
	 */
	public final void testManipularFormAvaliacao() {
		al1 = new Aluno(1, "Aluno_01");
		al2 = new Aluno(2, "Aluno_02");
		al3 = new Aluno(3, "Aluno_03");
		al4 = new Aluno(4, "Aluno_04");

		al1.setId(1L);
		al2.setId(2L);
		al3.setId(3L);
		al4.setId(4L);

		fa1 = new FormAvaliacao(al1, a1);
		fa2 = new FormAvaliacao(al2);
		fa3 = new FormAvaliacao(a1);
		fa4 = new FormAvaliacao(al1, a1);
		fa5 = new FormAvaliacao(al3, a1);

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
		assertNotNull(a1.adicionarFormAvaliacao(al4));

		assertEquals(4, a1.getFormulariosAvaliacao().size());

		assertEquals(fa1, a1.getFormAvaliacao(1L));
		assertEquals(fa2, a1.getFormAvaliacaoAluno(al2));
		assertEquals(fa5, a1.getFormAvaliacaoAluno(3L));
		assertNotNull(a1.getFormAvaliacaoAluno(4));

		assertTrue(a1.removerFormAvaliacao(fa1));
		assertEquals(fa2, a1.removerFormAvaliacaoAluno(al2));
		assertEquals(fa5, a1.removerFormAvaliacaoAluno(3L));
		assertNotNull(a1.removerFormAvaliacaoAluno(4));

		assertEquals(0, a1.getFormulariosAvaliacao().size());
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoTest.class);
	}
}
