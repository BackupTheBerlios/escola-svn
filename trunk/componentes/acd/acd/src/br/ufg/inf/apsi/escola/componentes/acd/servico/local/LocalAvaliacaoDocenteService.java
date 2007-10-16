package br.ufg.inf.apsi.escola.componentes.acd.servico.local;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.negocio.AvaliacaoDocenteHandler;
import br.ufg.inf.apsi.escola.componentes.acd.negocio.bean.AvaliacaoDocenteHandlerImpl;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;

/**
 * Esta classe implementa a interface AvaliacaoDocenteService e fornece todas as
 * funcionalidades definidas por ela.
 * 
 * @author Rodrigo Morian Loures
 */
public class LocalAvaliacaoDocenteService implements AvaliacaoDocenteService {

	private AvaliacaoDocenteHandler adhi = new AvaliacaoDocenteHandlerImpl();

//	private AvaliacaoDocenteHandler adhi = null;

	public LocalAvaliacaoDocenteService() {

	}

	public LocalAvaliacaoDocenteService(AvaliacaoDocenteHandler adh) {
		adhi = adh;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarAvaliacao(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.buscarAvaliacao(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Long buscarAvaliacaoId(Long turmaId) {
		// TODO Auto-generated method stub
		return adhi.buscarAvaliacaoId(turmaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#cadastrarAvaliacao(java.lang.Long)
	 */
	@Override
	public Long cadastrarAvaliacao(Long turmaId) {
		// TODO Auto-generated method stub
		return adhi.cadastrarAvaliacao(turmaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#excluirAvaliacao(java.lang.Long)
	 */
	@Override
	public boolean excluirAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.excluirAvaliacao(avaliacaoId);
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Questao buscarQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		return adhi.buscarQuestao(avaliacaoId, questaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarQuestoes(java.lang.Long)
	 */
	@Override
	public List<Questao> buscarQuestoes(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.buscarQuestoes(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#cadastrarQuestao(java.lang.Long,
	 *      boolean, java.lang.String)
	 */
	@Override
	public boolean cadastrarQuestao(Long avaliacaoId, boolean objetiva,
			String pergunta) {
		// TODO Auto-generated method stub
		return adhi.cadastrarQuestao(avaliacaoId, objetiva, pergunta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#alterarQuestao(java.lang.Long,
	 *      java.lang.Long, boolean, java.lang.String)
	 */
	@Override
	public boolean alterarQuestao(Long avaliacaoId, Long questaoId,
			boolean objetiva, String pergunta) {
		// TODO Auto-generated method stub
		return adhi.alterarQuestao(avaliacaoId, questaoId, objetiva, pergunta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#excluirQuestao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public boolean excluirQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		return adhi.excluirQuestao(avaliacaoId, questaoId);
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarFormAvaliacao(java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.buscarFormAvaliacao(formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long buscarFormAvaliacaoId(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		return adhi.buscarFormAvaliacaoId(avaliacaoId, alunoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarFormulariosAvaliacao(java.lang.Long)
	 */
	@Override
	public List<FormAvaliacao> buscarFormulariosAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.buscarFormulariosAvaliacao(avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#cadastrarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Long cadastrarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		return adhi.cadastrarFormAvaliacao(avaliacaoId, alunoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#excluirFormAvaliacao(java.lang.Long)
	 */
	@Override
	public boolean excluirFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.excluirFormAvaliacao(formAvaliacaoId);
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarResposta(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public Resposta buscarResposta(Long formAvaliacaoId, Long respostaId) {
		// TODO Auto-generated method stub
		return adhi.buscarResposta(formAvaliacaoId, respostaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#buscarRespostas(java.lang.Long)
	 */
	@Override
	public List<Resposta> buscarRespostas(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return adhi.buscarRespostas(formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService#AlterarResposta(java.lang.Long,
	 *      java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean AlterarResposta(Long formAvaliacaoId, Long respostaId,
			String resposta) {
		// TODO Auto-generated method stub
		return adhi.AlterarResposta(formAvaliacaoId, respostaId, resposta);
	}
}
