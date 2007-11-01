package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.test.jpa.AbstractJpaTests;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>AvaliacaoRepositoryImpl</code>.
 * 
 * Para a execucao destes testes, deve-se iniciar o servico do banco de dados.
 * Para executar esta tarefa, pode fazer uso do ant com o arquivo build.xml que
 * acompanha o projeto (ant db-start), digite ant -p no prompt de comando de
 * dentro do diretorio "../acd/src" para ser mostrado todas as opcoes.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoRepositoryImplTest extends AbstractJpaTests {

	private AvaliacaoRepository avaliacaoRepository = null;

	private Avaliacao a1, a2;
	private Questao q1, q2, q3, q4, q5, q6;
	private Long a1Id, a2Id, a1TurmaId;

	/**
	 * Atribui uma implementacao de <code>AvaliacaoRepository</code> para esta
	 * classe. Este metodo e usuado pelo Spring.
	 * 
	 * @param avaliacaoRepository
	 *            A implementacao de <code>AvaliacaoRepository</code> para ser
	 *            atribuida.
	 */
	public void setAvaliacaoRepository(AvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/testContext.xml" };
	}

	@Override
	protected void onSetUpInTransaction() throws Exception {
		q1 = new Questao("Pergunta_01");
		q2 = new Questao(true, "Pergunta_02");
		q3 = new Questao("Pergunta_03");
		q4 = new Questao(true, "Pergunta_04");
		q5 = new Questao("Pergunta_05");
		q6 = new Questao(true, "Pergunta_06");

		a1 = new Avaliacao(12345L);
		a1.adicionarQuestao(q1);
		a1.adicionarQuestao(q2);
		a1.adicionarQuestao(q3);
		a1.adicionarQuestao(q6);

		a2 = new Avaliacao(67890L);
		a2.adicionarQuestao(q4);
		a2.adicionarQuestao(q5);

		avaliacaoRepository.gravarAvaliacao(a1);
		avaliacaoRepository.gravarAvaliacao(a2);

		a1Id = a1.getId();
		a2Id = a2.getId();
		a1TurmaId = a1.getTurmaId();
	}

	/**
	 * Executa testes nos metodos: "Avaliacao buscarAvaliacao(Long
	 * avaliacaoId)"; "Avaliacao buscarAvaliacaoTurma(Long turmaId)".
	 */
	public final void testBuscarAvaliacao() {
		a1 = null;
		a2 = null;

		a1 = avaliacaoRepository.buscarAvaliacaoTurma(a1TurmaId);
		a2 = avaliacaoRepository.buscarAvaliacao(a2Id);

		assertEquals(a1Id, a1.getId());
		assertEquals(a2Id, a2.getId());
	}

	/**
	 * Executa testes no metodo "boolean gravarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testGravarAvaliacao() {
		Avaliacao a3 = new Avaliacao(56789L);
		assertTrue(avaliacaoRepository.gravarAvaliacao(a3));
	}

	/**
	 * Executa testes no metodo "boolean alterarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testAlterarAvaliacao() {
		Long qId = null;

		qId = a2.getQuestao(1).getId();
		a2.getQuestao(1).setPergunta("Pergunta_05 - Alterada");

		assertTrue(avaliacaoRepository.alterarAvaliacao(a2));

		a2 = null;
		a2 = avaliacaoRepository.buscarAvaliacao(a2Id);

		assertEquals("Pergunta_05 - Alterada", avaliacaoRepository
				.buscarQuestao(qId).getPergunta());
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testExcluirAvaliacao() {
		a2 = avaliacaoRepository.buscarAvaliacao(a2Id);

		assertTrue(avaliacaoRepository.excluirAvaliacao(a2));
		assertNull(avaliacaoRepository.buscarAvaliacao(a2Id));
	}

	// ===================================================================

	/**
	 * Executa testes no metodo "Questao buscarQuestao(Long questaoId)".
	 */
	public final void testBuscarQuestao() {
		Questao q = null;
		Long qId = null;

		qId = a1.getQuestao(1).getId();
		q = avaliacaoRepository.buscarQuestao(qId);

		assertEquals(qId, q.getId());
	}

	/**
	 * Executa testes no metodo "List<Questao>
	 * buscarListQuestao(Long avaliacaoId)".
	 */
	public final void testBuscarListQuestao() {
		List<Questao> la = null;

		la = avaliacaoRepository.buscarListQuestao(a1Id);
		assertEquals(4, la.size());
	}

	/**
	 * Executa testes no metodo "boolean gravarQuestao(Questao questao)".
	 */
	public final void testGravarQuestao() {
		Questao q = new Questao("Questao_Extra");

		a2.adicionarQuestao(q);

		assertTrue(avaliacaoRepository.gravarQuestao(q));
		assertEquals(3, avaliacaoRepository.buscarListQuestao(a2Id).size());
	}

	/**
	 * Executa testes no metodo "boolean alterarQuestao(Questao questao)".
	 */
	public final void testAlterarQuestao() {
		Long qId = null;

		q2.setPergunta("Pergunta_02 - Alterada");
		assertTrue(avaliacaoRepository.alterarQuestao(q2));

		qId = q2.getId();
		q2 = null;
		q2 = avaliacaoRepository.buscarQuestao(qId);
		assertEquals("Pergunta_02 - Alterada", q2.getPergunta());
	}

	/**
	 * Executa testes no metodo "boolean excluirQuestao(Questao questao)".
	 */
	public final void testExcluirQuestao() {
		Long qId = null;

		qId = q3.getId();
		a1.removerQuestao(q3);

		assertTrue(avaliacaoRepository.excluirQuestao(q3));
		assertNull(avaliacaoRepository.buscarQuestao(qId));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoRepositoryImplTest.class);
	}
}
