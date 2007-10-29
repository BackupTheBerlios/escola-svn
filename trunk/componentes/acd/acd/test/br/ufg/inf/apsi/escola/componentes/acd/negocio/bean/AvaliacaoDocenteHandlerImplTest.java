package br.ufg.inf.apsi.escola.componentes.acd.negocio.bean;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>AvaliacaoDocenteHandlerImpl</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoDocenteHandlerImplTest extends TestCase {

	private Mockery contextoAvaliacao = new JUnit4Mockery();
	private Mockery contextoFormAvaliacao = new JUnit4Mockery();

	private AvaliacaoDocenteHandler adh = null;
	private AvaliacaoRepository ar = null;
	private FormAvaliacaoRepository far = null;

	private Avaliacao a = null;
	private FormAvaliacao fa1 = null, fa2 = null;
	private Questao q1 = null, q2 = null;
	private Resposta r1 = null, r2 = null;
	private List<FormAvaliacao> formularios = null;

	/**
	 * Executa testes no metodo "Avaliacao buscarAvaliacao(Long avaliacaoId)".
	 */
	public void testBuscarAvaliacao() {
		a = new Avaliacao(1L);
		a.setId(2L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		assertEquals(2L, (long) adh.buscarAvaliacao(2L).getId());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Avaliacao buscarAvaliacaoTurma(Long turmaId)".
	 */
	public void testBuscarAvaliacaoTurma() {
		a = new Avaliacao(1L);
		a.setId(2L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		assertEquals(2L, (long) adh.buscarAvaliacaoId(1L));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarAvaliacao(Long turmaId)".
	 */
	public void testCadastrarAvaliacao_01() {
		a = new Avaliacao(1L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(null));
				one(ar).gravarAvaliacao(a);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		adh.cadastrarAvaliacao(1L);
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarAvaliacao(Long turmaId)".
	 */
	public void testCadastrarAvaliacao_02() {
		a = new Avaliacao(1L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(null));
				one(ar).gravarAvaliacao(a);
				will(returnValue(false));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		assertEquals(0L, (long) adh.cadastrarAvaliacao(1L));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarAvaliacao(Long turmaId)".
	 */
	public void testCadastrarAvaliacao_03() {
		a = new Avaliacao(1L);
		a.setId(2L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		assertEquals(2L, (long) adh.cadastrarAvaliacao(1L));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Long avaliacaoId)".
	 */
	public final void testExcluirAvaliacao_01() {
		a = new Avaliacao(1L);
		fa1 = new FormAvaliacao(1L, a);

		a.setId(2L);
		a.adicionarFormAvaliacao(fa1);
		formularios = new ArrayList<FormAvaliacao>(a.getFormulariosAvaliacao());

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
			}
		});

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListFormAvaliacao(2L);
				will(returnValue(formularios));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		assertFalse(adh.excluirAvaliacao(2L));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Long avaliacaoId)".
	 */
	public final void testExcluirAvaliacao_02() {
		a = new Avaliacao(1L);
		a.setId(2L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).excluirAvaliacao(a);
				will(returnValue(true));
			}
		});

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListFormAvaliacao(2L);
				will(returnValue(null));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		assertTrue(adh.excluirAvaliacao(2L));
		contextoAvaliacao.assertIsSatisfied();
	}

	// ==================================================================================

	/**
	 * Executa testes no metodo "Questao buscarQuestao(Long avaliacaoId, Long
	 * questaoId)".
	 */
	public void testBuscarQuestao() {
		a = new Avaliacao(4L);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");

		a.setId(1L);
		q1.setId(2L);
		q2.setId(3L);
		a.adicionarQuestao(q1);
		a.adicionarQuestao(q2);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(1L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		assertEquals(3L, (long) adh.buscarQuestao(1L, 3L).getId());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "List<Questao>
	 * buscarQuestoes(Long avaliacaoId)".
	 */
	public final void testBuscarQuestoes() {
		a = new Avaliacao(2L);
		a.setId(1L);

		a.adicionarQuestao(false, "Questao_01");
		a.adicionarQuestao(true, "Questao_02");

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarListQuestao(1L);
				will(returnValue(a.getQuestoes()));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null);

		assertEquals(2, adh.buscarQuestoes(1L).size());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean cadastrarQuestao(Long avaliacaoId,
	 * boolean objetiva, String pergunta)".
	 */
	public final void testCadastrarQuestao() {
		a = new Avaliacao(1L);
		a.setId(2L);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).alterarAvaliacao(a);
				will(returnValue(true));
			}
		});

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListFormAvaliacao(2L);
				will(returnValue(null));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		assertTrue(adh.cadastrarQuestao(2L, false, "Questao_01"));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean alterarQuestao(Long avaliacaoId, Long
	 * questaoId, boolean objetiva, String pergunta)".
	 */
	public final void testAlterarQuestao() {
		a = new Avaliacao(1L);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");

		a.setId(2L);
		q1.setId(3L);
		q2.setId(4L);
		a.adicionarQuestao(q1);
		a.adicionarQuestao(q2);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).alterarAvaliacao(a);
				will(returnValue(true));
			}
		});

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListFormAvaliacao(2L);
				will(returnValue(null));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		assertTrue(adh.alterarQuestao(2L, 4L, true, "Questao_02 - Alterada"));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirQuestao(Long avaliacaoId, Long
	 * questaoId)".
	 */
	public final void testExcluirQuestao() {
		a = new Avaliacao(1L);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");

		a.setId(2L);
		q1.setId(3L);
		q2.setId(4L);
		a.adicionarQuestao(q1);
		a.adicionarQuestao(q2);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).excluirQuestao(q2);
				will(returnValue(true));
			}
		});

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListFormAvaliacao(2L);
				will(returnValue(null));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		assertTrue(adh.excluirQuestao(2L, 4L));
		contextoAvaliacao.assertIsSatisfied();
	}

	// ==================================================================================

	/**
	 * Executa testes no metodo "FormAvaliacao buscarFormAvaliacao(Long
	 * formAvaliacaoId)".
	 */
	public void testBuscarFormAvaliacao_01() {
		a = new Avaliacao();
		fa1 = new FormAvaliacao(3L, a);

		a.setId(1L);
		fa1.setId(2L);
		a.adicionarFormAvaliacao(fa1);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(2L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertEquals(2L, (long) adh.buscarFormAvaliacao(2L).getId());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "FormAvaliacao buscarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public void testBuscarFormAvaliacao_02() {
		a = new Avaliacao();
		fa1 = new FormAvaliacao(3L, a);

		a.setId(1L);
		fa1.setId(2L);
		a.adicionarFormAvaliacao(fa1);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(1L, 3L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertEquals(2L, (long) adh.buscarFormAvaliacaoId(1L, 3L));
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Set<FormAvaliacao>
	 * buscarFormulariosAvaliacao(Long formAvaliacaoId)".
	 */
	public final void testBuscarFormulariosAvaliacao() {
		a = new Avaliacao();
		fa1 = new FormAvaliacao(4L, a);
		fa2 = new FormAvaliacao(5L, a);

		a.setId(1L);
		fa1.setId(2L);
		fa2.setId(3L);
		a.adicionarFormAvaliacao(fa1);
		a.adicionarFormAvaliacao(fa2);

		final List<FormAvaliacao> forms = new ArrayList<FormAvaliacao>(a
				.getFormulariosAvaliacao());

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListFormAvaliacao(1L);
				will(returnValue(forms));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertEquals(2, adh.buscarFormulariosAvaliacao(1L).size());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public final void testCadastrarFormAvaliacao_01() {
		a = new Avaliacao(1L);
		fa1 = new FormAvaliacao(3L, a);

		a.setId(2L);
		a.adicionarQuestao(false, "Questao_01");
		a.adicionarQuestao(true, "Questao_02");

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(2L, 3L);
				will(returnValue(null));
				one(far).gravarFormAvaliacao(fa1);
				will(returnValue(true));
			}
		});

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		adh.cadastrarFormAvaliacao(2L, 3L);
		contextoAvaliacao.assertIsSatisfied();
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public final void testCadastrarFormAvaliacao_02() {
		a = new Avaliacao(1L);
		fa1 = new FormAvaliacao(3L, a);

		a.setId(2L);
		a.adicionarQuestao(false, "Questao_01");
		a.adicionarQuestao(true, "Questao_02");

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(2L, 3L);
				will(returnValue(null));
				one(far).gravarFormAvaliacao(fa1);
				will(returnValue(false));
			}
		});

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far);

		assertEquals(0L, (long) adh.cadastrarFormAvaliacao(2L, 3L));
		contextoAvaliacao.assertIsSatisfied();
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public final void testCadastrarFormAvaliacao_03() {
		a = new Avaliacao(1L);
		fa1 = new FormAvaliacao(4L, a);

		a.setId(2L);
		fa1.setId(3L);
		a.adicionarFormAvaliacao(fa1);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(2L, 4L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertEquals(3L, (long) adh.cadastrarFormAvaliacao(2L, 4L));
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirFormAvaliacao(Long
	 * formAvaliacaoId)".
	 */
	public final void testExluirFormAvaliacao() {
		a = new Avaliacao(1L);
		fa1 = new FormAvaliacao(4L, a);

		a.setId(2L);
		fa1.setId(3L);
		a.adicionarFormAvaliacao(fa1);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(3L);
				will(returnValue(fa1));
				one(far).excluirFormAvaliacao(fa1);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertTrue(adh.excluirFormAvaliacao(3L));
		contextoFormAvaliacao.assertIsSatisfied();
	}

	// ==================================================================================

	/**
	 * Executa testes no metodo "Resposta buscarResposta(Long formAvaliacaoId,
	 * Long respostaId)".
	 */
	public void testBuscarResposta() {
		fa1 = new FormAvaliacao();
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta_02");

		fa1.setId(1L);
		r1.setId(2L);
		r2.setId(3L);

		fa1.adicionarResposta(r1);
		fa1.adicionarResposta(r2);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(1L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertEquals(3L, (long) adh.buscarResposta(1L, 3L).getId());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "List<Resposta> buscarRespostas(Long
	 * formAvaliacaoId)".
	 */
	public void testBuscarRespostas() {
		fa1 = new FormAvaliacao();
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");

		fa1.setId(1L);
		fa1.adicionarResposta(q1, "Resposta_01");
		fa1.adicionarResposta(q2, "Resposta_02");

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarListResposta(1L);
				will(returnValue(fa1.getRespostas()));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertEquals(2, adh.buscarRespostas(1L).size());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean alterarResposta(Long formAvaliacaoId,
	 * Long respostaId, String resposta)".
	 */
	public final void testAlterarResposta() {
		a = new Avaliacao(1L);
		fa1 = new FormAvaliacao(4L, a);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta_02");

		a.setId(2L);
		fa1.setId(3L);
		r1.setId(5L);
		r2.setId(6L);

		a.adicionarFormAvaliacao(fa1);
		fa1.adicionarResposta(r1);
		fa1.adicionarResposta(r2);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(3L);
				will(returnValue(fa1));
				one(far).alterarFormAvaliacao(fa1);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far);

		assertTrue(adh.alterarResposta(3L, 6L, "Resposta_02 - Alterada"));
		contextoFormAvaliacao.assertIsSatisfied();
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoDocenteHandlerImplTest.class);
	}
}
