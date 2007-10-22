package br.ufg.inf.apsi.escola.componentes.acd.negocio.bean;

import java.util.GregorianCalendar;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoServiceImpl;

/**
 * Esta classe implementa a interface AvaliacaoDocenteHandler e fornece todas as
 * funcionalidades definidas por ela.
 * 
 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoDocenteHandlerImpl implements AvaliacaoDocenteHandler {

	private AvaliacaoRepository ari = null;
	private FormAvaliacaoRepository fari = null;

	public AvaliacaoDocenteHandlerImpl() {

	}

	/**
	 * Construtor para o qual se pode passar as implementacoes das interfaces de
	 * persistencia usadas por esta classe.
	 * 
	 * @param ar
	 *            Implementacao da interface de persistencia para
	 *            <code>AvaliacaoRepository</code>.
	 * @param far
	 *            Implementacao da interface de persistencia para
	 *            <code>FormAvaliacaoRepository</code>.
	 */
	public AvaliacaoDocenteHandlerImpl(AvaliacaoRepository ar,
			FormAvaliacaoRepository far) {
		ari = ar;
		fari = far;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarAvaliacao(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);
		return avaliacao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Long buscarAvaliacaoId(Long turmaId) {
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacaoTurma(turmaId);
		if (avaliacao == null)
			return 0L;
		else
			return avaliacao.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#cadastrarAvaliacao(java.lang.Long)
	 */
	@Override
	public Long cadastrarAvaliacao(Long turmaId) {
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacaoTurma(turmaId);

		if (avaliacao == null) {
			avaliacao = new Avaliacao(turmaId);

			if (!validaPeriodoTurma(turmaId))
				return 0L;

			if (ari.gravarAvaliacao(avaliacao))
				return avaliacao.getId();
			else
				return 0L;
		} else
			return avaliacao.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#excluirAvaliacao(java.lang.Long)
	 */
	@Override
	public boolean excluirAvaliacao(Long avaliacaoId) {
		List<FormAvaliacao> lista = null;
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);
		if (avaliacao == null)
			return false;

		lista = fari.buscarListFormAvaliacao(avaliacaoId);
		if (lista != null)
			return false;

		return ari.excluirAvaliacao(avaliacao);
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Questao buscarQuestao(Long avaliacaoId, Long questaoId) {
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);
		if (avaliacao == null)
			return null;

		return avaliacao.getQuestao(questaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarQuestoes(java.lang.Long)
	 */
	@Override
	public List<Questao> buscarQuestoes(Long avaliacaoId) {
		List<Questao> lista = null;

		lista = ari.buscarListQuestao(avaliacaoId);
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#cadastrarQuestao(java.lang.Long,
	 *      boolean, java.lang.String)
	 */
	@Override
	public boolean cadastrarQuestao(Long avaliacaoId, boolean objetiva,
			String pergunta) {
		List<FormAvaliacao> lista = null;
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao == null)
			return false;

		if (!validaPeriodoTurma(avaliacao.getTurmaId()))
			return false;

		lista = fari.buscarListFormAvaliacao(avaliacaoId);
		if (lista != null)
			return false;

		if (avaliacao.adicionarQuestao(objetiva, pergunta))
			return ari.alterarAvaliacao(avaliacao);

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#alterarQuestao(java.lang.Long,
	 *      java.lang.Long, boolean, java.lang.String)
	 */
	@Override
	public boolean alterarQuestao(Long avaliacaoId, Long questaoId,
			boolean objetiva, String pergunta) {
		List<FormAvaliacao> lista = null;
		Avaliacao avaliacao = null;
		Questao questao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao == null)
			return false;

		if (!validaPeriodoTurma(avaliacao.getTurmaId()))
			return false;

		lista = fari.buscarListFormAvaliacao(avaliacaoId);
		if (lista != null)
			return false;

		questao = avaliacao.getQuestao(questaoId);
		if (questao == null)
			return false;

		questao.setObjetiva(objetiva);
		questao.setPergunta(pergunta);
		return ari.alterarAvaliacao(avaliacao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#excluirQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public boolean excluirQuestao(Long avaliacaoId, Long questaoId) {
		List<FormAvaliacao> lista = null;
		Avaliacao avaliacao = null;
		Questao questao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao == null)
			return false;

		if (!validaPeriodoTurma(avaliacao.getTurmaId()))
			return false;

		lista = fari.buscarListFormAvaliacao(avaliacaoId);
		if (lista != null)
			return false;

		questao = avaliacao.getQuestao(questaoId);
		if (questao == null)
			return false;

		if (avaliacao.removerQuestao(questao))
			return ari.excluirQuestao(questao);

		return false;
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarFormAvaliacao(java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		FormAvaliacao formAvaliacao = null;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);
		return formAvaliacao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long buscarFormAvaliacaoId(Long avaliacaoId, Long alunoId) {
		FormAvaliacao formAvaliacao = null;

		formAvaliacao = fari.buscarFormAvaliacao(avaliacaoId, alunoId);
		if (formAvaliacao == null)
			return 0L;
		else
			return formAvaliacao.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarFormulariosAvaliacao(java.lang.Long)
	 */
	@Override
	public List<FormAvaliacao> buscarFormulariosAvaliacao(Long avaliacaoId) {
		List<FormAvaliacao> lista = null;

		lista = fari.buscarListFormAvaliacao(avaliacaoId);
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#cadastrarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long cadastrarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		Avaliacao avaliacao = null;
		FormAvaliacao formAvaliacao = null;

		formAvaliacao = fari.buscarFormAvaliacao(avaliacaoId, alunoId);

		if (formAvaliacao == null) {
			avaliacao = ari.buscarAvaliacao(avaliacaoId);
			if (avaliacao == null)
				return 0L;

			if (avaliacao.getQuestoes().isEmpty())
				return 0L;

			if (!validaPeriodoTurma(avaliacao.getTurmaId()))
				return 0L;

			formAvaliacao = new FormAvaliacao(alunoId, avaliacao);
			if (formAvaliacao == null)
				return 0L;

			if (avaliacao.adicionarFormAvaliacao(formAvaliacao)) {
				for (int i = 0; i < avaliacao.getQuestoes().size(); i++)
					if (!formAvaliacao.adicionarResposta(i, new Resposta(
							avaliacao.getQuestao(i))))
						return 0L;

				if (fari.gravarFormAvaliacao(formAvaliacao))
					return formAvaliacao.getId();
			}
		} else
			return formAvaliacao.getId();

		return 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#excluirFormAvaliacao(java.lang.Long)
	 */
	@Override
	public boolean excluirFormAvaliacao(Long formAvaliacaoId) {
		FormAvaliacao formAvaliacao = null;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);
		if (formAvaliacao == null)
			return false;

		if (!validaPeriodoTurma(formAvaliacao.getAvaliacao().getTurmaId()))
			return false;

		return fari.excluirFormAvaliacao(formAvaliacao);
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarResposta(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Resposta buscarResposta(Long formAvaliacaoId, Long respostaId) {
		FormAvaliacao formAvaliacao = null;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);
		if (formAvaliacao == null)
			return null;

		return formAvaliacao.getResposta(respostaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarRespostas(java.lang.Long)
	 */
	@Override
	public List<Resposta> buscarRespostas(Long formAvaliacaoId) {
		List<Resposta> lista = null;

		lista = fari.buscarListResposta(formAvaliacaoId);
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#cadastrarResposta(java.lang.Long,
	 *      java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean AlterarResposta(Long formAvaliacaoId, Long respostaId,
			String resposta) {
		FormAvaliacao formAvaliacao = null;
		Resposta resp = null;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);
		if (formAvaliacao == null)
			return false;

		if (!validaPeriodoTurma(formAvaliacao.getAvaliacao().getTurmaId()))
			return false;

		resp = formAvaliacao.getResposta(respostaId);
		if (resp == null)
			return false;

		resp.setResposta(resposta);
		return fari.alterarFormAvaliacao(formAvaliacao);
	}

	/**
	 * Verifica se o periodo letivo da <code>Turma</code> de uma
	 * <code>Avaliacao</code> esta em andamento, finalizou ou ainda nao
	 * comecou.
	 * 
	 * @param avaliacao
	 *            <code>Avaliacao</code> que se deseja fazer a verificacao.
	 * @return <code>true</code> caso o periodo letivo esta em andamento e
	 *         <code>false</code> caso o periodo letivo ainda nao comecou ou
	 *         ja finalizou.
	 */
	private boolean validaPeriodoTurma(Long turmaId) {
		GregorianCalendar agora = new GregorianCalendar();

		ExternoService servicoTurma = new ExternoServiceImpl();
		if (agora.compareTo(servicoTurma.buscarDataInicioTurma(turmaId)) >= 0
				&& agora
						.compareTo(servicoTurma.buscarDataTerminoTurma(turmaId)) <= 0)
			return true;
		else
			return false;
	}
}
