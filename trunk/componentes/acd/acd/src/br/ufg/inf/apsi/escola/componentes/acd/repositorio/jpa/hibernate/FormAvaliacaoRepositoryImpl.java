package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository;

/**
 * Esta classe implementa a Interface <code>FormAvaliacao</code>. Ela fornece
 * servicos de recuperar, gravar, alterar e excluir informacoes de
 * <code>FormAvaliacao</code> e de <code>Resposta</code> do banco de dados,
 * ou para o banco de dados.
 * 
 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoRepositoryImpl extends JpaDaoSupport implements
		FormAvaliacaoRepository {

	public FormAvaliacaoRepositoryImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		return (FormAvaliacao) getJpaTemplate().find(FormAvaliacao.class,
				formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		List lista = null;
		Map<String, Long> params = new HashMap<String, Long>();
		String q = "select f from FormAvaliacao f inner join f.avaliacao as a where a.id = :avaliacaoId and f.alunoId = :alunoId";

		params.put("avaliacaoId", avaliacaoId);
		params.put("alunoId", alunoId);
		lista = getJpaTemplate().findByNamedParams(q, params);

		if (lista.isEmpty() || lista == null)
			return null;
		else
			return (FormAvaliacao) lista.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarListFormAvaliacao(java.lang.Long)
	 */
	@Override
	public List<FormAvaliacao> buscarListFormAvaliacao(Long avaliacaoId) {
		List lista = null;
		Map<String, Long> params = new HashMap<String, Long>();
		String q = "select f from FormAvaliacao f inner join f.avaliacao as a where a.id = :avaliacaoId";

		params.put("avaliacaoId", avaliacaoId);
		lista = getJpaTemplate().findByNamedParams(q, params);

		if (lista.isEmpty() || lista == null)
			return null;
		else
			return (List<FormAvaliacao>) lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#gravarFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	@Override
	public boolean gravarFormAvaliacao(FormAvaliacao formAvaliacao) {
		try {
			getJpaTemplate().persist(formAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#alterarFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	@Override
	public boolean alterarFormAvaliacao(FormAvaliacao formAvaliacao) {
		try {
			formAvaliacao = getJpaTemplate().merge(formAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#excluirFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	@Override
	public boolean excluirFormAvaliacao(FormAvaliacao formAvaliacao) {
		try {
			getJpaTemplate().remove(formAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// ===================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarResposta(java.lang.Long)
	 */
	@Override
	public Resposta buscarResposta(Long respostaId) {
		return getJpaTemplate().find(Resposta.class, respostaId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarListResposta(java.lang.Long)
	 */
	@Override
	public List<Resposta> buscarListResposta(Long formAvaliacaoId) {
		List lista = null;
		Map<String, Long> params = new HashMap<String, Long>();
		String q = "select r from FormAvaliacao f inner join f.respostas as r where f.id = :formAvaliacaoId";

		params.put("formAvaliacaoId", formAvaliacaoId);
		lista = getJpaTemplate().findByNamedParams(q, params);

		if (lista.isEmpty() || lista == null)
			return null;
		else
			return (List<Resposta>) lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#gravarResposta(br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta)
	 */
	@Override
	public boolean gravarResposta(Resposta resposta) {
		try {
			getJpaTemplate().persist(resposta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#alterarResposta(br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta)
	 */
	@Override
	public boolean alterarResposta(Resposta resposta) {
		try {
			resposta = getJpaTemplate().merge(resposta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#excluirResposta(br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta)
	 */
	@Override
	public boolean excluirResposta(Resposta resposta) {
		try {
			getJpaTemplate().remove(resposta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
