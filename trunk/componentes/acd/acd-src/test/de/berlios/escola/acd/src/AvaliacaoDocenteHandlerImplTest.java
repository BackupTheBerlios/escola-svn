package de.berlios.escola.acd.src;

import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;

import junit.framework.TestCase;

/**
 * Esta classe executa uma bateria de testes na classe
 * <code>AvaliacaoDocenteHandlerImpl</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoDocenteHandlerImplTest extends TestCase {

	private Mockery contextoAvaliacao = new JUnit4Mockery();
	private Mockery contextoFormAvaliacao = new JUnit4Mockery();
	private Mockery contextoTurma = new JUnit4Mockery();
	private Mockery contextoAluno = new JUnit4Mockery();

	private AvaliacaoDocenteHandler adh = null;
	private AvaliacaoRepository ar = null;
	private FormAvaliacaoRepository far = null;

	private Avaliacao a = null;
	private FormAvaliacao fa1 = null, fa2 = null;
	private Questao q1 = null, q2 = null;
	private Resposta r1 = null, r2 = null;

	private TurmaRepository tr;
	private AlunoRepository alr;
	private Turma t;
	private Aluno al1, al2;

	/**
	 * Executa testes no metodo "Avaliacao buscarAvaliacao(Long avaliacaoId)".
	 */
	public void testBuscarAvaliacao() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		t.setId(1L);
		a.setId(2L);
		t.setAvaliacao(a);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertEquals(2L, (long) adh.buscarAvaliacao(2L).getId());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Avaliacao buscarAvaliacaoTurma(Long turmaId)".
	 */
	public void testBuscarAvaliacaoTurma() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		t.setId(1L);
		a.setId(2L);
		t.setAvaliacao(a);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertEquals(2L, (long) adh.buscarAvaliacaoTurma(1L).getId());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarAvaliacao(Long turmaId)".
	 */
	public void testCadastrarAvaliacao_01() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);

		t.setId(1L);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(null));
				one(ar).gravarAvaliacao(a);
				will(returnValue(true));
			}
		});

		tr = contextoTurma.mock(TurmaRepository.class);
		contextoTurma.checking(new Expectations() {
			{
				one(tr).buscarTurma(1L);
				will(returnValue(t));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, tr, null);

		adh.cadastrarAvaliacao(1L);
		contextoAvaliacao.assertIsSatisfied();
		contextoTurma.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarAvaliacao(Long turmaId)".
	 */
	public void testCadastrarAvaliacao_02() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);

		t.setId(1L);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(null));
				one(ar).gravarAvaliacao(a);
				will(returnValue(false));
			}
		});

		tr = contextoTurma.mock(TurmaRepository.class);
		contextoTurma.checking(new Expectations() {
			{
				one(tr).buscarTurma(1L);
				will(returnValue(t));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, tr, null);

		assertEquals(0L, (long) adh.cadastrarAvaliacao(1L));
		contextoAvaliacao.assertIsSatisfied();
		contextoTurma.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarAvaliacao(Long turmaId)".
	 */
	public void testCadastrarAvaliacao_03() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);

		t.setId(1L);
		a.setId(2L);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacaoTurma(1L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertEquals(2L, (long) adh.cadastrarAvaliacao(1L));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Long avaliacaoId)".
	 */
	public final void testExcluirAvaliacao_01() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		t.setId(1L);
		a.setId(2L);
		t.setAvaliacao(a);
		a.adicionarFormAvaliacao(fa1);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertFalse(adh.excluirAvaliacao(2L));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirAvaliacao(Long avaliacaoId)".
	 */
	public final void testExcluirAvaliacao_02() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);

		t.setId(1L);
		a.setId(2L);
		t.setAvaliacao(a);

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).excluirAvaliacao(a);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertTrue(adh.excluirAvaliacao(2L));
		contextoAvaliacao.assertIsSatisfied();
	}

	// ==================================================================================

	/**
	 * Executa testes no metodo "Questao buscarQuestao(Long avaliacaoId, Long
	 * questaoId)".
	 */
	public void testBuscarQuestao() {
		a = new Avaliacao();
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

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertEquals(3L, (long) adh.buscarQuestao(1L, 3L).getId());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "List<Questao>
	 * buscarQuestoes(Long avaliacaoId)".
	 */
	public final void testBuscarQuestoes() {
		a = new Avaliacao();
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

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertEquals(2, adh.buscarQuestoes(1L).size());
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean cadastrarQuestao(Long avaliacaoId,
	 * boolean objetiva, String pergunta)".
	 */
	public final void testCadastrarQuestao() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);

		t.setId(1L);
		a.setId(2L);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).alterarAvaliacao(a);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertTrue(adh.cadastrarQuestao(2L, false, "Questao_01"));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean alterarQuestao(Long avaliacaoId, Long
	 * questaoId, boolean objetiva, String pergunta)".
	 */
	public final void testAlterarQuestao() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");

		t.setId(1L);
		a.setId(2L);
		q1.setId(3L);
		q2.setId(4L);

		a.adicionarQuestao(q1);
		a.adicionarQuestao(q2);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).alterarAvaliacao(a);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

		assertTrue(adh.alterarQuestao(2L, 4L, true, "Questao_02 - Alterada"));
		contextoAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirQuestao(Long avaliacaoId, Long
	 * questaoId)".
	 */
	public final void testExcluirQuestao() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");

		t.setId(1L);
		a.setId(2L);
		q1.setId(3L);
		q2.setId(4L);

		a.adicionarQuestao(q1);
		a.adicionarQuestao(q2);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		ar = contextoAvaliacao.mock(AvaliacaoRepository.class);
		contextoAvaliacao.checking(new Expectations() {
			{
				one(ar).buscarAvaliacao(2L);
				will(returnValue(a));
				one(ar).alterarAvaliacao(a);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, null, null, null);

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
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		a.setId(1L);
		fa1.setId(2L);
		al1.setId(3L);
		a.adicionarFormAvaliacao(fa1);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(2L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

		assertEquals(2L, (long) adh.buscarFormAvaliacao(2L).getId());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "FormAvaliacao buscarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public void testBuscarFormAvaliacao_02() {
		a = new Avaliacao();
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		a.setId(1L);
		fa1.setId(2L);
		al1.setId(3L);
		a.adicionarFormAvaliacao(fa1);

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(1L, 3L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

		assertEquals(2L, (long) adh.buscarFormAvaliacao(1L, 3L).getId());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Set<FormAvaliacao>
	 * buscarFormulariosAvaliacao(Long formAvaliacaoId)".
	 */
	public final void testBuscarFormulariosAvaliacao() {
		a = new Avaliacao();
		al1 = new Aluno(1, "Aluno_01");
		al2 = new Aluno(2, "Aluno_02");
		fa1 = new FormAvaliacao(al1, a);
		fa2 = new FormAvaliacao(al2, a);

		a.setId(1L);
		fa1.setId(2L);
		fa2.setId(3L);
		al1.setId(4L);
		al2.setId(5L);
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

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

		assertEquals(2, adh.buscarFormulariosAvaliacao(1L).size());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public final void testCadastrarFormAvaliacao_01() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		t.setId(1L);
		a.setId(2L);
		al1.setId(3L);

		a.adicionarQuestao(false, "Questao_01");
		a.adicionarQuestao(true, "Questao_02");
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

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

		alr = contextoAluno.mock(AlunoRepository.class);
		contextoAluno.checking(new Expectations() {
			{
				one(alr).buscarAluno(3L);
				will(returnValue(al1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far, null, alr);

		adh.cadastrarFormAvaliacao(2L, 3L);
		contextoAvaliacao.assertIsSatisfied();
		contextoFormAvaliacao.assertIsSatisfied();
		contextoAluno.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public final void testCadastrarFormAvaliacao_02() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		t.setId(1L);
		a.setId(2L);
		al1.setId(3L);

		a.adicionarQuestao(false, "Questao_01");
		a.adicionarQuestao(true, "Questao_02");
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

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

		alr = contextoAluno.mock(AlunoRepository.class);
		contextoAluno.checking(new Expectations() {
			{
				one(alr).buscarAluno(3L);
				will(returnValue(al1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(ar, far, null, alr);

		assertEquals(0L, (long) adh.cadastrarFormAvaliacao(2L, 3L));
		contextoAvaliacao.assertIsSatisfied();
		contextoFormAvaliacao.assertIsSatisfied();
		contextoAluno.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "Long cadastrarFormAvaliacao(Long
	 * formAvaliacaoId, Long alunoId)".
	 */
	public final void testCadastrarFormAvaliacao_03() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		t.setId(1L);
		a.setId(2L);
		fa1.setId(3L);
		al1.setId(4L);

		a.adicionarFormAvaliacao(fa1);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(2L, 4L);
				will(returnValue(fa1));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

		assertEquals(3L, (long) adh.cadastrarFormAvaliacao(2L, 4L));
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean excluirFormAvaliacao(Long
	 * formAvaliacaoId)".
	 */
	public final void testExluirFormAvaliacao() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);

		t.setId(1L);
		a.setId(2L);
		fa1.setId(3L);
		al1.setId(4L);

		a.adicionarFormAvaliacao(fa1);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));

		far = contextoFormAvaliacao.mock(FormAvaliacaoRepository.class);
		contextoFormAvaliacao.checking(new Expectations() {
			{
				one(far).buscarFormAvaliacao(3L);
				will(returnValue(fa1));
				one(far).excluirFormAvaliacao(fa1);
				will(returnValue(true));
			}
		});

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

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

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

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

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

		assertEquals(2, adh.buscarRespostas(1L).size());
		contextoFormAvaliacao.assertIsSatisfied();
	}

	/**
	 * Executa testes no metodo "boolean alterarResposta(Long formAvaliacaoId,
	 * Long respostaId, String resposta)".
	 */
	public final void testAlterarResposta() {
		t = new Turma("Turma_01");
		a = new Avaliacao(t);
		al1 = new Aluno(1, "Aluno_01");
		fa1 = new FormAvaliacao(al1, a);
		q1 = new Questao("Questao_01");
		q2 = new Questao(true, "Questao_02");
		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta_02");

		t.setId(1L);
		a.setId(2L);
		fa1.setId(3L);
		al1.setId(4L);
		r1.setId(5L);
		r2.setId(6L);

		a.adicionarFormAvaliacao(fa1);
		t.setAvaliacao(a);
		t.setDataInicio(new GregorianCalendar(2007, 07, 03));
		t.setDataTermino(new GregorianCalendar(2007, 11, 19));
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

		adh = new AvaliacaoDocenteHandlerImpl(null, far, null, null);

		assertTrue(adh.AlterarResposta(3L, 6L, "Resposta_02 - Alterada"));
		contextoFormAvaliacao.assertIsSatisfied();
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AvaliacaoDocenteHandlerImplTest.class);
	}
}
