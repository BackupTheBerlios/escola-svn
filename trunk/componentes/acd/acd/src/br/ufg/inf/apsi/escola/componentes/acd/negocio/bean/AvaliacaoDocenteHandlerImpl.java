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
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate.AvaliacaoRepositoryImpl;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate.FormAvaliacaoRepositoryImpl;
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

	// private AvaliacaoRepository ari = new AvaliacaoRepositoryImpl();
	// private FormAvaliacaoRepository fari = new FormAvaliacaoRepositoryImpl();

//	public AvaliacaoDocenteHandlerImpl() { }

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
		// TODO Auto-generated method stub
		return ari.buscarAvaliacao(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Long buscarAvaliacaoId(Long turmaId) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);
		if (avaliacao == null)
			return false;

		if (avaliacao.getFormulariosAvaliacao().isEmpty())
			return ari.excluirAvaliacao(avaliacao);
		else
			return false;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return ari.buscarListQuestao(avaliacaoId);
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
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao == null)
			return false;

		if (!validaPeriodoTurma(avaliacao.getTurmaId()))
			return false;

		if (!avaliacao.getFormulariosAvaliacao().isEmpty())
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
		Avaliacao avaliacao = null;
		Questao questao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao == null)
			return false;

		if (!validaPeriodoTurma(avaliacao.getTurmaId()))
			return false;

		if (!avaliacao.getFormulariosAvaliacao().isEmpty())
			return false;

		questao = avaliacao.getQuestao(questaoId);
		if (questao != null) {
			questao.setObjetiva(objetiva);
			questao.setPergunta(pergunta);
			return ari.alterarAvaliacao(avaliacao);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#excluirQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public boolean excluirQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		Avaliacao avaliacao = null;
		Questao questao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao == null)
			return false;

		if (!validaPeriodoTurma(avaliacao.getTurmaId()))
			return false;

		if (!avaliacao.getFormulariosAvaliacao().isEmpty())
			return false;

		questao = avaliacao.getQuestao(questaoId);
		if (questao != null)
			if (avaliacao.removerQuestao(questao))
				return ari.alterarAvaliacao(avaliacao);

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
		// TODO Auto-generated method stub
		return fari.buscarFormAvaliacao(formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#buscarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long buscarFormAvaliacaoId(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub

		return fari.buscarListFormAvaliacao(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler#cadastrarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long cadastrarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return fari.buscarListResposta(formAvaliacaoId);
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
		// TODO Auto-generated method stub
		FormAvaliacao formAvaliacao = null;
		Resposta resp = null;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);
		if (formAvaliacao == null)
			return false;

		if (!validaPeriodoTurma(formAvaliacao.getAvaliacao().getTurmaId()))
			return false;

		resp = formAvaliacao.getResposta(respostaId);
		if (resp != null) {
			resp.setResposta(resposta);
			return fari.alterarFormAvaliacao(formAvaliacao);
		}

		return false;
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
