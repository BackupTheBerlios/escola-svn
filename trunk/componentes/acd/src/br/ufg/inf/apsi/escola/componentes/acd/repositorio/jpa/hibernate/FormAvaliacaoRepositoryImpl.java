package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

import org.hibernate.HibernateException;

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
public class FormAvaliacaoRepositoryImpl implements FormAvaliacaoRepository {

	public FormAvaliacaoRepositoryImpl() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(java.lang.Long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return (FormAvaliacao) HibernateUtils.obtem(FormAvaliacao.class,
				formAvaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(long,
	 *      long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select f from FormAvaliacao f inner join f.Avaliacao as a where a.id = "
				+ avaliacaoId + " and f.alunoId = " + alunoId;

		return (FormAvaliacao) HibernateUtils.obtem(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarFormAvaliacao(long)
	 */
	@Override
	public List<FormAvaliacao> buscarListFormAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select f from FormAvaliacao f inner join f.Avaliacao as a where a.id = "
				+ avaliacaoId;

		return (List<FormAvaliacao>) HibernateUtils.obtemList(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#buscarListResposta(long)
	 */
	@Override
	public List<Resposta> buscarListResposta(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select r from FormAvaliacao f inner join f.respostas as r where f.id = "
				+ formAvaliacaoId;

		return (List<Resposta>) HibernateUtils.obtemList(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.FormAvaliacaoRepository#gravarFormAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao)
	 */
	@Override
	public boolean gravarFormAvaliacao(FormAvaliacao formAvaliacao) {
		// TODO Auto-generated method stub
		try {
			HibernateUtils.persiste(formAvaliacao);
		} catch (HibernateException he) {
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
		// TODO Auto-generated method stub
		try {
			HibernateUtils.update(formAvaliacao);
		} catch (HibernateException he) {
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
		// TODO Auto-generated method stub
		try {
			HibernateUtils.remove(formAvaliacao);
		} catch (HibernateException he) {
			return false;
		}
		return true;
	}
}
