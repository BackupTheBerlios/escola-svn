package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import junit.framework.TestCase;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;

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

	private Avaliacao a1, a2;
	private Questao q1, q2, q3, q4, q5, q6;

	private final AvaliacaoRepository ari = new AvaliacaoRepositoryImpl();

	/**
	 * Executa testes no metodo "boolean gravarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testGravarAvaliacao() {
		criarInstancias();

		assertTrue(ari.gravarAvaliacao(a1));
		assertTrue(ari.gravarAvaliacao(a2));
	}

	/**
	 * Executa testes nos metodos: "Avaliacao buscarAvaliacao(Long
	 * avaliacaoId)"; "Avaliacao buscarAvaliacaoTurma(Long turmaId)"; "List<Questao>
	 * buscarListQuestao(Long avaliacaoId)".
	 */
	public final void testBuscarAvaliacao() {
		a1 = ari.buscarAvaliacaoTurma(10L);
		a2 = ari.buscarAvaliacao(2L);

		assertEquals(1L, (long) a1.getId());
		assertEquals(2L, (long) a2.getId());

		assertEquals(4, ari.buscarListQuestao(a1.getId()).size());
	}

	/**
	 * Executa testes no metodo "boolean alterarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testAlterarAvaliacao() {
		a1 = ari.buscarAvaliacaoTurma(10L);
		a2 = ari.buscarAvaliacao(2L);

		a1.removerQuestao(3);
		a2.getQuestao(1).setPergunta("Pergunta_05");

		assertTrue(ari.alterarAvaliacao(a1));
		assertTrue(ari.alterarAvaliacao(a2));

		a1 = null;
		a2 = null;
		a1 = ari.buscarAvaliacao(1L);
		a2 = ari.buscarAvaliacaoTurma(20L);

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
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		q3 = new Questao("Questao_03");
		q4 = new Questao(true, "Questao_04");
		q5 = new Questao("Questao_05");
		q6 = new Questao(true, "Questao_06");

		a1 = new Avaliacao(10L);
		a1.adicionarQuestao(q1);
		a1.adicionarQuestao(q2);
		a1.adicionarQuestao(q3);
		a1.adicionarQuestao(q6);

		a2 = new Avaliacao(20L);
		a2.adicionarQuestao(q4);
		a2.adicionarQuestao(q5);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoRepositoryImplTest.class);
	}
}
