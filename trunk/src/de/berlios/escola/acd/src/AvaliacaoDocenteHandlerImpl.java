package de.berlios.escola.acd.src;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.berlios.escola.acd.data.AlunoRepositoryImpl;
import de.berlios.escola.acd.data.AvaliacaoRepositoryImpl;
import de.berlios.escola.acd.data.FormAvaliacaoRepositoryImpl;
import de.berlios.escola.acd.data.TurmaRepositoryImpl;

/**
 * Esta classe implementa a interface AvaliacaoDocenteHandler e fornece todas as
 * funcionalidades definidas por ela.
 * 
 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoDocenteHandlerImpl implements AvaliacaoDocenteHandler {

	private AvaliacaoRepository ari = new AvaliacaoRepositoryImpl();
	private FormAvaliacaoRepository fari = new FormAvaliacaoRepositoryImpl();
	private TurmaRepository tri = new TurmaRepositoryImpl();
	private AlunoRepository alri = new AlunoRepositoryImpl();

	public AvaliacaoDocenteHandlerImpl() {

	}

	/**
	 * Construtor para o qual se pode passar as interfaces usadas pela classe
	 * para fazer a persistencia dos objetos.
	 * 
	 * @param ar
	 *            Interface de persistencia para
	 *            <code>AvaliacaoRepository</code>.
	 * @param far
	 *            Interface de persistencia para
	 *            <code>FormAvaliacaoRepository</code>.
	 * @param tr
	 *            Interface de persistencia para <code>TurmaRepository</code>.
	 * @param alr
	 *            ar Interface de persistencia para <code>AlunoRepository</code>.
	 */
	public AvaliacaoDocenteHandlerImpl(AvaliacaoRepository ar,
			FormAvaliacaoRepository far, TurmaRepository tr, AlunoRepository alr) {
		ari = ar;
		fari = far;
		tri = tr;
		alri = alr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarAvaliacao(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return ari.buscarAvaliacao(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacaoTurma(Long turmaId) {
		// TODO Auto-generated method stub
		return ari.buscarAvaliacaoTurma(turmaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#cadastrarAvaliacao(java.lang.Long)
	 */
	@Override
	public Long cadastrarAvaliacao(Long turmaId) {
		// TODO Auto-generated method stub
		Turma turma = null;
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacaoTurma(turmaId);

		if (avaliacao == null) {
			turma = tri.buscarTurma(turmaId);
			avaliacao = new Avaliacao(turma);

			if (!validaPeriodoTurma(avaliacao))
				return 0L;

			turma.setAvaliacao(avaliacao);

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
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#excluirAvaliacao(java.lang.Long)
	 */
	@Override
	public boolean excluirAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		Avaliacao avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (avaliacao.getFormulariosAvaliacao().isEmpty())
			return ari.excluirAvaliacao(avaliacao);
		else
			return false;
	}

	// ==================================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Questao buscarQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		Avaliacao avaliacao = ari.buscarAvaliacao(avaliacaoId);

		return avaliacao.getQuestao(questaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarQuestoes(java.lang.Long)
	 */
	@Override
	public List<Questao> buscarQuestoes(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return ari.buscarListQuestao(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#cadastrarQuestao(java.lang.Long,
	 *      boolean, java.lang.String)
	 */
	@Override
	public boolean cadastrarQuestao(Long avaliacaoId, boolean objetiva,
			String pergunta) {
		Avaliacao avaliacao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (!validaPeriodoTurma(avaliacao))
			return false;

		if (!avaliacao.getFormulariosAvaliacao().isEmpty())
			return false;

		if (avaliacao != null)
			if (avaliacao.adicionarQuestao(objetiva, pergunta))
				return ari.alterarAvaliacao(avaliacao);

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#alterarQuestao(java.lang.Long,
	 *      java.lang.Long, boolean, java.lang.String)
	 */
	@Override
	public boolean alterarQuestao(Long avaliacaoId, Long questaoId,
			boolean objetiva, String pergunta) {
		Avaliacao avaliacao = null;
		Questao questao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (!validaPeriodoTurma(avaliacao))
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
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#excluirQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public boolean excluirQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		Avaliacao avaliacao = null;
		Questao questao = null;

		avaliacao = ari.buscarAvaliacao(avaliacaoId);

		if (!validaPeriodoTurma(avaliacao))
			return false;

		if (!avaliacao.getFormulariosAvaliacao().isEmpty())
			return false;

		questao = avaliacao.getQuestao(questaoId);
		if (questao != null)
			if (avaliacao.removerQuestao(questao))
				return ari.alterarAvaliacao(avaliacao);

		return false;
	}

	// ==================================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarFormAvaliacao(java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return fari.buscarFormAvaliacao(formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		return fari.buscarFormAvaliacao(avaliacaoId, alunoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarFormulariosAvaliacao(java.lang.Long)
	 */
	@Override
	public Set<FormAvaliacao> buscarFormulariosAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		List<FormAvaliacao> formsList;
		Set<FormAvaliacao> formsSet;

		formsList = fari.buscarListFormAvaliacao(avaliacaoId);
		if (formsList != null) {
			formsSet = new HashSet<FormAvaliacao>(formsList);
			return formsSet;
		} else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#cadastrarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long cadastrarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		Avaliacao avaliacao = null;
		Aluno aluno = null;
		FormAvaliacao formAvaliacao = null;

		formAvaliacao = fari.buscarFormAvaliacao(avaliacaoId, alunoId);

		if (formAvaliacao == null) {
			avaliacao = ari.buscarAvaliacao(avaliacaoId);

			if (!validaPeriodoTurma(avaliacao))
				return 0L;

			aluno = alri.buscarAluno(alunoId);
			formAvaliacao = new FormAvaliacao(aluno, avaliacao);

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
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#excluirFormAvaliacao(java.lang.Long)
	 */
	@Override
	public boolean excluirFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		FormAvaliacao formAvaliacao;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);

		if (!validaPeriodoTurma(formAvaliacao.getAvaliacao()))
			return false;

		return fari.excluirFormAvaliacao(formAvaliacao);
	}

	// ==================================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarResposta(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Resposta buscarResposta(Long formAvaliacaoId, Long respostaId) {
		// TODO Auto-generated method stub
		FormAvaliacao formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);

		return formAvaliacao.getResposta(respostaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#buscarRespostas(java.lang.Long)
	 */
	@Override
	public List<Resposta> buscarRespostas(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return fari.buscarListResposta(formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoDocenteHandler#cadastrarResposta(java.lang.Long,
	 *      java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean AlterarResposta(Long formAvaliacaoId, Long respostaId,
			String resposta) {
		// TODO Auto-generated method stub
		FormAvaliacao formAvaliacao = null;
		Resposta resp = null;

		formAvaliacao = fari.buscarFormAvaliacao(formAvaliacaoId);

		if (!validaPeriodoTurma(formAvaliacao.getAvaliacao()))
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
	private boolean validaPeriodoTurma(Avaliacao avaliacao) {
		GregorianCalendar agora = new GregorianCalendar();

		if (agora.compareTo(avaliacao.getTurma().getDataInicio()) >= 0
				&& agora.compareTo(avaliacao.getTurma().getDataTermino()) <= 0)
			return true;
		else
			return false;
	}
}
