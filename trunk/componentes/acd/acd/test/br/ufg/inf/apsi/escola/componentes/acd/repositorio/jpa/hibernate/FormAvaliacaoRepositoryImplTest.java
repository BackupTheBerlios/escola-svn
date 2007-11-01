package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

import org.springframework.test.jpa.AbstractJpaTests;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>FormAvaliacaoRepositoryImpl</code>.
 * 
 * Para a execucao destes testes, deve-se iniciar o servico do banco de dados.
 * Para executar esta tarefa, pode fazer uso do ant com o arquivo build.xml que
 * acompanha o projeto (ant db-start), digite ant -p no prompt de comando de
 * dentro do diretorio "../acd/src" para ser mostrado todas as opcoes.
 * 
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoRepositoryImplTest extends AbstractJpaTests {

	private AvaliacaoRepository avaliacaoRepository = null;
	private FormAvaliacaoRepository formAvaliacaoRepository = null;

	private Avaliacao a1, a2;
	private FormAvaliacao fa1, fa2;
	private Questao q1, q2, q3;
	private Resposta r1, r2, r3, r4, r5, r6;
	private Long a1Id, fa1Id, fa2Id;

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

	/**
	 * Atribui uma implementacao de <code>FormAvaliacaoRepository</code> para
	 * esta classe. Este metodo e usuado pelo Spring.
	 * 
	 * @param formAvaliacaoRepository
	 *            A implementacao de <code>FormAvaliacaoRepository</code> para
	 *            ser atribuida.
	 */
	public void setFormAvaliacaoRepository(
			FormAvaliacaoRepository formAvaliacaoRepository) {
		this.formAvaliacaoRepository = formAvaliacaoRepository;
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

		a1 = new Avaliacao(12345L);
		a1.adicionarQuestao(q1);
		a1.adicionarQuestao(q2);
		a1.adicionarQuestao(q3);

		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta_02");
		r3 = new Resposta(q3, "Resposta_03");
		r4 = new Resposta(q1, "Resposta_04");
		r5 = new Resposta(q2, "Resposta_05");
		r6 = new Resposta(q3, "Resposta_06");

		fa1 = new FormAvaliacao(100L, a1);
		fa2 = new FormAvaliacao(200L, a1);

		fa1.adicionarResposta(r1);
		fa1.adicionarResposta(r2);
		fa1.adicionarResposta(r3);

		fa2.adicionarResposta(r4);
		fa2.adicionarResposta(r5);
		fa2.adicionarResposta(r6);

		a1.adicionarFormAvaliacao(fa1);
		a1.adicionarFormAvaliacao(fa2);

		avaliacaoRepository.gravarAvaliacao(a1);
		avaliacaoRepository.gravarAvaliacao(a2);

		formAvaliacaoRepository.gravarFormAvaliacao(fa1);
		formAvaliacaoRepository.gravarFormAvaliacao(fa2);

		a1Id = a1.getId();
		fa1Id = fa1.getId();
		fa2Id = fa2.getId();
	}

	/**
	 * Executa testes nos metodos: "FormAvaliacao buscarFormAvaliacao(Long
	 * formAvaliacaoId)"; "FormAvaliacao buscarFormAvaliacao(Long avaliacaoId,
	 * Long alunoId)"; "List<FormAvaliacao> buscarListFormAvaliacao(Long
	 * avaliacaoId)".
	 */
	public final void testBuscarFormAvaliacao() {
		List<FormAvaliacao> lfa = null;

		fa1 = null;
		fa2 = null;
		fa1 = formAvaliacaoRepository.buscarFormAvaliacao(fa1Id);
		fa2 = formAvaliacaoRepository.buscarFormAvaliacao(a1Id, 200L);

		assertEquals(fa1Id, fa1.getId());
		assertEquals(fa2Id, fa2.getId());

		lfa = formAvaliacaoRepository.buscarListFormAvaliacao(a1Id);
		assertEquals(2, lfa.size());
	}

	/**
	 * Executa testes no metodo "boolean gravarFormAvaliacao(FormAvaliacao
	 * formAvaliacao)".
	 */
	public final void testGravarFormAvaliacao() {
		FormAvaliacao fa3 = new FormAvaliacao(300L, a1);
		a1.adicionarFormAvaliacao(fa3);

		assertTrue(formAvaliacaoRepository.gravarFormAvaliacao(fa3));
	}

	/**
	 * Executa testes no metodo "boolean alterarFormAvaliacao(FormAvaliacao
	 * formAvaliacao)".
	 */
	public final void testAlterarFormAvaliacao() {
		fa2 = null;
		fa2 = formAvaliacaoRepository.buscarFormAvaliacao(fa2Id);

		fa2.getResposta(0).setResposta("Resposta_04 - Alterada");
		fa2.getResposta(1).setResposta("Resposta_05 - Alterada");

		assertTrue(formAvaliacaoRepository.alterarFormAvaliacao(fa2));

		fa2 = null;
		fa2 = formAvaliacaoRepository.buscarFormAvaliacao(fa2Id);

		assertEquals("Resposta_04 - Alterada", fa2.getResposta(0).getResposta());
		assertEquals("Resposta_05 - Alterada", fa2.getResposta(1).getResposta());
	}

	/**
	 * Executa testes no metodo "boolean excluirFormAvaliacao(FormAvaliacao
	 * formAvaliacao)".
	 */
	public final void testExcluirFormAvaliacao() {
		fa1 = null;
		fa1 = formAvaliacaoRepository.buscarFormAvaliacao(fa1Id);

		assertTrue(formAvaliacaoRepository.excluirFormAvaliacao(fa1));
		assertNull(formAvaliacaoRepository.buscarFormAvaliacao(fa1Id));
	}

	// ===================================================================

	/**
	 * Executa testes no metodo "Resposta buscarResposta(Long respostaId).
	 */
	public final void testBuscarResposta() {
		Long rId = null;

		rId = fa1.getResposta(1).getId();
		assertEquals(rId, formAvaliacaoRepository.buscarResposta(rId).getId());
	}

	/**
	 * Executa testes no metodo "List<Resposta> buscarListResposta(Long
	 * formAvaliacaoId).
	 */
	public final void testBuscarListResposta() {
		List<Resposta> lr = null;

		lr = formAvaliacaoRepository.buscarListResposta(fa2Id);
		assertEquals(3, lr.size());
	}

	/**
	 * Executa testes no metodo "boolean gravarResposta(Resposta resposta).
	 */
	public final void testGravarResposta() {
		FormAvaliacao fa3 = null;
		Resposta r7 = null;

		fa3 = new FormAvaliacao(300L, a1);
		a1.adicionarFormAvaliacao(fa3);
		formAvaliacaoRepository.gravarFormAvaliacao(fa3);

		r7 = new Resposta(q3, "Resposta_Extra");
		fa3.adicionarResposta(r7);

		assertTrue(formAvaliacaoRepository.gravarResposta(r7));
		assertEquals(1, formAvaliacaoRepository.buscarListResposta(fa3.getId())
				.size());
	}

	/**
	 * Executa testes no metodo "boolean alterarResposta(Resposta resposta).
	 */
	public final void testAlterarResposta() {
		Long rId = r2.getId();

		r2.setResposta("Resposta_02 - Alterada");
		assertTrue(formAvaliacaoRepository.alterarResposta(r2));

		r2 = null;
		r2 = formAvaliacaoRepository.buscarResposta(rId);
		assertEquals(rId, r2.getId());
	}

	/**
	 * Executa testes no metodo "boolean excluirResposta(Resposta resposta).
	 */
	public final void testExcluirResposta() {
		Long rId = r4.getId();

		assertTrue(formAvaliacaoRepository.excluirResposta(r4));
		assertNull(formAvaliacaoRepository.buscarResposta(rId));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(FormAvaliacaoRepositoryImplTest.class);
	}
}
