package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import org.springframework.test.jpa.AbstractJpaTests;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>AvaliacaoRepositoryImpl</code>.
 * 
 * Para a execucao destes testes deve-se iniciar o servico do banco de dados.
 * Para executar esta tarefa, pode fazer uso do ant com o arquivo build.xml que
 * acompanha o projeto (ant db-start), digite ant -p no prompt de comando de
 * dentro do diretorio "../acd/src" que lhe sera mostrado todas as opcoes.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoRepositoryImplTest extends AbstractJpaTests {

	private AvaliacaoRepository avaliacaoRepository = null;

	private Avaliacao a1, a2;
	private Questao q1, q2, q3, q4, q5, q6;
	private Long a1Id, a2Id, a1TurmaId, a2TurmaId;

	/**
	 * @param avaliacaoRepository
	 *            the avaliacaoRepository to set
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
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		q3 = new Questao("Questao_03");
		q4 = new Questao(true, "Questao_04");
		q5 = new Questao("Questao_05");
		q6 = new Questao(true, "Questao_06");

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
		a2TurmaId = a2.getTurmaId();
	}

	/**
	 * Executa testes no metodo "boolean gravarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testGravarAvaliacao() {
		Avaliacao a3 = new Avaliacao(56789L);
		assertTrue(avaliacaoRepository.gravarAvaliacao(a3));
	}

	/**
	 * Executa testes nos metodos: "Avaliacao buscarAvaliacao(Long
	 * avaliacaoId)"; "Avaliacao buscarAvaliacaoTurma(Long turmaId)"; "List<Questao>
	 * buscarListQuestao(Long avaliacaoId)".
	 */
	public final void testBuscarAvaliacao() {
		a1 = null;
		a2 = null;

		a1 = avaliacaoRepository.buscarAvaliacaoTurma(a1TurmaId);
		a2 = avaliacaoRepository.buscarAvaliacao(a2Id);

		assertEquals(a1Id, a1.getId());
		assertEquals(a2Id, a2.getId());

		assertEquals(4, avaliacaoRepository.buscarListQuestao(a1.getId())
				.size());
	}

	/**
	 * Executa testes no metodo "boolean alterarAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testAlterarAvaliacao() {
		a1 = null;
		a2 = null;

		a1 = avaliacaoRepository.buscarAvaliacaoTurma(a1TurmaId);
		a2 = avaliacaoRepository.buscarAvaliacao(a2Id);

		a1.removerQuestao(3);
		a2.getQuestao(1).setPergunta("Pergunta_05");

		assertTrue(avaliacaoRepository.alterarAvaliacao(a1));
		assertTrue(avaliacaoRepository.alterarAvaliacao(a2));

		a1 = null;
		a2 = null;
		a1 = avaliacaoRepository.buscarAvaliacao(a1Id);
		a2 = avaliacaoRepository.buscarAvaliacaoTurma(a2TurmaId);

		assertEquals(3, a1.getQuestoes().size());
		assertEquals("Pergunta_05", a2.getQuestao(1).getPergunta());
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Avaliacao avaliacao)".
	 */
	public final void testExcluirAvaliacao() {
		a2 = avaliacaoRepository.buscarAvaliacao(a2Id);

		assertTrue(avaliacaoRepository.excluirAvaliacao(a2));
		assertNull(avaliacaoRepository.buscarAvaliacao(a2Id));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoRepositoryImplTest.class);
	}
}
