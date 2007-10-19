package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

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
public class FormAvaliacaoRepositoryImpl extends JpaDaoSupport implements FormAvaliacaoRepository {

	public FormAvaliacaoRepositoryImpl() {
		
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(java.lang.Long)
	 */
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return (FormAvaliacao) getJpaTemplate().find(FormAvaliacao.class, formAvaliacaoId);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(java.lang.Long, java.lang.Long)
	 */
	public FormAvaliacao buscarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select f from FormAvaliacao f inner join f.Avaliacao as a where a.id = :" + avaliacaoId + " and f.alunoId = :" + alunoId;

		return (FormAvaliacao) getJpaTemplate().find(hqlQuery);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarListFormAvaliacao(java.lang.Long)
	 */
	public List<FormAvaliacao> buscarListFormAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select f from FormAvaliacao f inner join f.Avaliacao as a where a.id = :" + avaliacaoId;

		return (List<FormAvaliacao>) getJpaTemplate().find(hqlQuery);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarListResposta(java.lang.Long)
	 */
	public List<Resposta> buscarListResposta(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select r from FormAvaliacao f inner join f.respostas as r where f.id = :" + formAvaliacaoId;

		return (List<Resposta>) getJpaTemplate().find(hqlQuery);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#gravarFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	public boolean gravarFormAvaliacao(FormAvaliacao formAvaliacao) {
		// TODO Auto-generated method stub
		try {
			getJpaTemplate().persist(formAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#alterarFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	public boolean alterarFormAvaliacao(FormAvaliacao formAvaliacao) {
		try {
			getJpaTemplate().refresh(formAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#excluirFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	public boolean excluirFormAvaliacao(FormAvaliacao formAvaliacao) {
		// TODO Auto-generated method stub
		try {
			getJpaTemplate().remove(formAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
