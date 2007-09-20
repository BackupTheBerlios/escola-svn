package de.berlios.escola.acd.data;

import java.util.List;

import org.hibernate.HibernateException;

import de.berlios.escola.acd.src.Avaliacao;
import de.berlios.escola.acd.src.AvaliacaoRepository;
import de.berlios.escola.acd.src.Questao;

/**
 * Esta classe implementa a interface <code>AvaliacaoRepository</code>. Ela
 * fornece servicos de recuperar, gravar, alterar e excluir informacoes de
 * <code>Avaliacao</code> e de <code>Questao</code> do banco de dados, ou
 * para o banco de dados.
 * 
 * @see de.berlios.escola.acd.src.AvaliacaoRepository
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoRepositoryImpl implements AvaliacaoRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoRepository#buscarAvaliacao(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return (Avaliacao) HibernateUtils.obtem(Avaliacao.class, avaliacaoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoRepository#buscarAvaliacaoTurma(java.lang.Long)
	 */
	@Override
	public Avaliacao buscarAvaliacaoTurma(Long turmaId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select a from Turma t inner join t.Avaliacao as a where t.id = "
				+ turmaId;

		return (Avaliacao) HibernateUtils.obtem(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.AvaliacaoRepository#buscarListQuestao(de.berlios.escola.acd.src.Avaliacao)
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
	 * @see de.berlios.escola.acd.src.AvaliacaoRepository#gravarAvaliacao(de.berlios.escola.acd.src.Avaliacao)
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
	 * @see de.berlios.escola.acd.src.AvaliacaoRepository#alterarAvaliacao(de.berlios.escola.acd.src.Avaliacao)
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
	 * @see de.berlios.escola.acd.src.AvaliacaoRepository#excluirAvaliacao(de.berlios.escola.acd.src.Avaliacao)
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
