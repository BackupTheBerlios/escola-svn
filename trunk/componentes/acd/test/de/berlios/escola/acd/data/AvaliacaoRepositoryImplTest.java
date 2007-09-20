package de.berlios.escola.acd.data;

import java.util.GregorianCalendar;

import junit.framework.TestCase;

import de.berlios.escola.acd.src.Avaliacao;
import de.berlios.escola.acd.src.AvaliacaoRepository;
import de.berlios.escola.acd.src.Questao;
import de.berlios.escola.acd.src.Turma;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>AvaliacaoRepositoryImpl</code>.
 * 
 * Para a execucao destes testes deve-se iniciar o servico do banco de dados,
 * excluir o velho Schema e criar um novo Schema. Para executar esta tarefa,
 * pode fazer uso do ant com o arquivo build.xml que acompanha o projeto, digite
 * ant -p no prompt de comando que lhe sera mostrado todas as opcoes.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoRepositoryImplTest extends TestCase {

	private Turma t1, t2;
	private Avaliacao a1, a2;
	private Questao q1, q2, q3, q4, q5, q6;

	private final AvaliacaoRepository ari = new AvaliacaoRepositoryImpl();

	/**
	 * Executa testes no metodo "boolean gravarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testGravarAvaliacao() {
		criarInstancias();
		carregaBancoDados();

		assertTrue(ari.gravarAvaliacao(a1));
		assertTrue(ari.gravarAvaliacao(a2));
	}

	/**
	 * Executa testes nos metodos: "Avaliacao buscarAvaliacao(Long
	 * avaliacaoId)"; "Avaliacao buscarAvaliacaoTurma(Long turmaId)"; "List<Questao>
	 * buscarListQuestao(Long avaliacaoId)".
	 */
	public final void testBuscarAvaliacao() {
		a1 = ari.buscarAvaliacaoTurma(1L);
		a2 = ari.buscarAvaliacao(2L);

		assertEquals(1L, (long) a1.getId());
		assertEquals(2L, (long) a2.getId());

		assertEquals(4, ari.buscarListQuestao(a1.getId()).size());
	}

	/**
	 * Executa testes no metodo "boolean alterarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testAlterarAvaliacao() {
		a1 = ari.buscarAvaliacaoTurma(1L);
		a2 = ari.buscarAvaliacao(2L);

		a1.removerQuestao(3);
		a2.getQuestao(1).setPergunta("Pergunta_05");

		assertTrue(ari.alterarAvaliacao(a1));
		assertTrue(ari.alterarAvaliacao(a2));

		a1 = null;
		a2 = null;
		a1 = ari.buscarAvaliacao(1L);
		a2 = ari.buscarAvaliacaoTurma(2L);

		assertEquals(3, a1.getQuestoes().size());
		assertEquals("Pergunta_05", a2.getQuestao(1).getPergunta());
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testExcluirAvaliacao() {
		a2 = ari.buscarAvaliacao(2L);

		assertTrue(ari.excluirAvaliacao(a2));
		assertNull(ari.buscarAvaliacao(2L));
	}

	/*
	 * Cria instancias iniciais para a execucao dos testes.
	 */
	private void criarInstancias() {
		t1 = new Turma("Turma_01");
		t1.setDataInicio(new GregorianCalendar(2007, 01, 01));
		t1.setDataTermino(new GregorianCalendar(2007, 05, 30));

		t2 = new Turma("Turma_02");
		t2.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t2.setDataTermino(new GregorianCalendar(2007, 11, 15));

		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		q3 = new Questao("Questao_03");
		q4 = new Questao(true, "Questao_04");
		q5 = new Questao("Questao_05");
		q6 = new Questao(true, "Questao_06");

		a1 = new Avaliacao(t1);
		a1.adicionarQuestao(q1);
		a1.adicionarQuestao(q2);
		a1.adicionarQuestao(q3);
		a1.adicionarQuestao(q6);

		a2 = new Avaliacao(t2);
		a2.adicionarQuestao(q4);
		a2.adicionarQuestao(q5);
	}

	/*
	 * Persiste alguns objetos iniciais no banco de dados para a execucao dos
	 * testes.
	 */
	private void carregaBancoDados() {
		TurmaRepositoryImpl tr = new TurmaRepositoryImpl();

		tr.gravarTurma(t1);
		tr.gravarTurma(t2);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoRepositoryImplTest.class);
	}
}
