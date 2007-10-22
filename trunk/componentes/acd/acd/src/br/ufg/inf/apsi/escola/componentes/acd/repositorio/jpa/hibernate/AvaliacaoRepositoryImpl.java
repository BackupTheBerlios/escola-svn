package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository;

/**
 * Esta classe implementa a interface <code>AvaliacaoRepository</code>. Ela
 * fornece servicos de recuperar, gravar, alterar e excluir informacoes de
 * <code>Avaliacao</code> e de <code>Questao</code> do banco de dados, ou
 * para o banco de dados.
 * 
 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoRepositoryImpl extends JpaDaoSupport implements
		AvaliacaoRepository {

	public AvaliacaoRepositoryImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarAvaliacao(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		return (Avaliacao) getJpaTemplate().find(Avaliacao.class, avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacaoTurma(Long turmaId) {
		List lista = null;
		String q = "from Avaliacao where turmaId = :turmaId";
		Map<String, Long> params = new HashMap<String, Long>();

		params.put("turmaId", turmaId);
		lista = getJpaTemplate().findByNamedParams(q, params);

		if (lista.isEmpty() || lista == null)
			return null;
		else
			return (Avaliacao) lista.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#gravarAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	@Override
	public boolean gravarAvaliacao(Avaliacao avaliacao) {
		try {
			getJpaTemplate().persist(avaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#alterarAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	@Override
	public boolean alterarAvaliacao(Avaliacao avaliacao) {
		try {
			avaliacao = getJpaTemplate().merge(avaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#excluirAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	@Override
	public boolean excluirAvaliacao(Avaliacao avaliacao) {
		try {
			getJpaTemplate().remove(avaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarQuestao(java.lang.Long)
	 */
	@Override
	public Questao buscarQuestao(Long questaoId) {
		return (Questao) getJpaTemplate().find(Questao.class, questaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarListQuestao(java.lang.Long)
	 */
	@Override
	public List<Questao> buscarListQuestao(Long avaliacaoId) {
		List lista = null;
		String q = "select q from Avaliacao a inner join a.questoes as q where a.id = :avaliacaoId";
		Map<String, Long> params = new HashMap<String, Long>();

		params.put("avaliacaoId", avaliacaoId);
		lista = getJpaTemplate().findByNamedParams(q, params);

		if (lista.isEmpty() || lista == null)
			return null;
		else
			return (List<Questao>) lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#gravarQuestao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao)
	 */
	@Override
	public boolean gravarQuestao(Questao questao) {
		try {
			getJpaTemplate().persist(questao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#alterarQuestao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao)
	 */
	@Override
	public boolean alterarQuestao(Questao questao) {
		try {
			questao = getJpaTemplate().merge(questao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#excluirQuestao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao)
	 */
	@Override
	public boolean excluirQuestao(Questao questao) {
		try {
			getJpaTemplate().remove(questao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
