package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

import junit.framework.TestCase;

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
 * Para a execucao destes testes deve-se iniciar o servico do banco de dados,
 * excluir o velho Schema e criar um novo Schema. Para executar esta tarefa,
 * pode fazer uso do ant com o arquivo build.xml que acompanha o projeto, digite
 * ant -p no prompt de comando que lhe sera mostrado todas as opcoes.
 * 
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoRepositoryImplTest extends TestCase {

	private Avaliacao a1, a2;
	private FormAvaliacao fa1, fa2, fa3, fa4, fa5;
	private Questao q1, q2, q3, q4, q5;
	private Resposta r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12;

	private final FormAvaliacaoRepository fari = new FormAvaliacaoRepositoryImpl();

	/**
	 * Executa testes no metodo "boolean gravarFormAvaliacao(FormAvaliacao
	 * formAvaliacao)".
	 */
	public final void testGravarFormAvaliacao() {
		criarInstancias();
		carregaBancoDados();

		assertTrue(fari.gravarFormAvaliacao(fa1));
		assertTrue(fari.gravarFormAvaliacao(fa2));
		assertTrue(fari.gravarFormAvaliacao(fa3));
		assertTrue(fari.gravarFormAvaliacao(fa4));
		assertTrue(fari.gravarFormAvaliacao(fa5));
	}

	/**
	 * Executa testes nos metodos: "FormAvaliacao buscarFormAvaliacao(Long
	 * formAvaliacaoId)"; "FormAvaliacao buscarFormAvaliacao(Long avaliacaoId,
	 * Long alunoId)"; "List<FormAvaliacao> buscarListFormAvaliacao(Long
	 * avaliacaoId)"; "List<Resposta> buscarListResposta(Long
	 * formAvaliacaoId)".
	 */
	public final void testBuscarFormAvaliacao() {
		List<FormAvaliacao> lfa;

		fa1 = fari.buscarFormAvaliacao(1L);
		fa2 = fari.buscarFormAvaliacao(1L, 2L);
		fa3 = fari.buscarFormAvaliacao(3L);

		assertEquals(1L, (long) fa1.getId());
		assertEquals(2L, (long) fa2.getId());
		assertEquals(3L, (long) fa3.getId());

		lfa = fari.buscarListFormAvaliacao(2L);
		assertEquals(2, lfa.size());

		assertEquals(2, fari.buscarListResposta(fa3.getId()).size());
	}

	/**
	 * Executa testes no metodo "boolean alterarFormAvaliacao(FormAvaliacao
	 * formAvaliacao)".
	 */
	public final void testAlterarFormAvaliacao() {
		fa2 = fari.buscarFormAvaliacao(2L);

		fa2.getResposta(0).setResposta("Resposta_06 - Alterada");
		fa2.getResposta(1).setResposta("Resposta_07 - Alterada");

		assertTrue(fari.alterarFormAvaliacao(fa2));

		fa2 = null;
		fa2 = fari.buscarFormAvaliacao(2L);

		assertEquals("Resposta_06 - Alterada", fa2.getResposta(0).getResposta());
		assertEquals("Resposta_07 - Alterada", fa2.getResposta(1).getResposta());
	}

	/**
	 * Executa testes no metodo "boolean excluirFormAvaliacao(FormAvaliacao
	 * formAvaliacao)".
	 */
	public final void testExcluirFormAvaliacao() {
		fa3 = fari.buscarFormAvaliacao(3L);

		assertTrue(fari.excluirFormAvaliacao(fa3));
		assertNull(fari.buscarFormAvaliacao(3L));
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

		a1 = new Avaliacao(10L);
		a1.adicionarQuestao(q1);
		a1.adicionarQuestao(q2);

		a2 = new Avaliacao(20L);
		a2.adicionarQuestao(q3);
		a2.adicionarQuestao(q4);
		a2.adicionarQuestao(q5);

		r1 = new Resposta(q1, "Resposta_01");
		r2 = new Resposta(q2, "Resposta_02");
		r3 = new Resposta(q3, "Resposta_03");
		r4 = new Resposta(q4, "Resposta_04");
		r5 = new Resposta(q5, "Resposta_05");
		r6 = new Resposta(q1, "Resposta_06");
		r7 = new Resposta(q2, "Resposta_07");
		r8 = new Resposta(q3, "Resposta_08");
		r9 = new Resposta(q4, "Resposta_09");
		r10 = new Resposta(q5, "Resposta_10");
		r11 = new Resposta(q1, "Resposta_11");
		r12 = new Resposta(q2, "Resposta_12");

		fa1 = new FormAvaliacao(1L, a1);
		fa2 = new FormAvaliacao(2L, a1);
		fa3 = new FormAvaliacao(3L, a1);
		fa4 = new FormAvaliacao(4L, a2);
		fa5 = new FormAvaliacao(5L, a2);

		fa1.adicionarResposta(r1);
		fa1.adicionarResposta(r2);

		fa2.adicionarResposta(r6);
		fa2.adicionarResposta(r7);

		fa3.adicionarResposta(r11);
		fa3.adicionarResposta(r12);

		fa4.adicionarResposta(r3);
		fa4.adicionarResposta(r4);
		fa4.adicionarResposta(r5);

		fa5.adicionarResposta(r8);
		fa5.adicionarResposta(r9);
		fa5.adicionarResposta(r10);
	}

	/*
	 * Persiste alguns objetos iniciais no banco de dados para a execucao dos
	 * testes.
	 */
	private void carregaBancoDados() {
		AvaliacaoRepository ari = new AvaliacaoRepositoryImpl();

		ari.gravarAvaliacao(a1);
		ari.gravarAvaliacao(a2);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(FormAvaliacaoRepositoryImplTest.class);
	}
}
