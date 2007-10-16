package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

import org.hibernate.HibernateException;

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
public class AvaliacaoRepositoryImpl implements AvaliacaoRepository {

	public AvaliacaoRepositoryImpl() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarAvaliacao(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return (Avaliacao) HibernateUtils.obtem(Avaliacao.class, avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacaoTurma(Long turmaId) {
		// TODO Auto-generated method stub
		String hqlQuery = "from Avaliacao a where a.turmaId = " + turmaId;

		return (Avaliacao) HibernateUtils.obtem(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarListQuestao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	@Override
	public List<Questao> buscarListQuestao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select q from Avaliacao a inner join a.questoes as q where a.id = "
				+ avaliacaoId;

		return (List<Questao>) HibernateUtils.obtemList(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#gravarAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	@Override
	public boolean gravarAvaliacao(Avaliacao avaliacao) {
		// TODO Auto-generated method stub
		try {
			HibernateUtils.persiste(avaliacao);
		} catch (HibernateException he) {
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
		// TODO Auto-generated method stub
		try {
			HibernateUtils.update(avaliacao);
		} catch (HibernateException he) {
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
		// TODO Auto-generated method stub
		try {
			HibernateUtils.remove(avaliacao);
		} catch (HibernateException he) {
			return false;
		}
		return true;
	}
}
