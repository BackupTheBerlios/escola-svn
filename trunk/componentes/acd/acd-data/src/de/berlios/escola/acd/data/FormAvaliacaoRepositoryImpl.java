package de.berlios.escola.acd.data;

import java.util.List;

import org.hibernate.HibernateException;

import de.berlios.escola.acd.src.FormAvaliacao;
import de.berlios.escola.acd.src.FormAvaliacaoRepository;
import de.berlios.escola.acd.src.Resposta;

/**
 * Esta classe implementa a Interface <code>FormAvaliacao</code>. Ela fornece
 * servicos de recuperar, gravar, alterar e excluir informacoes de
 * <code>FormAvaliacao</code> e de <code>Resposta</code> do banco de dados,
 * ou para o banco de dados.
 * 
 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoRepositoryImpl implements FormAvaliacaoRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#buscarFormAvaliacao(java.lang.Long)
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
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#buscarFormAvaliacao(long,
	 *      long)
	 */
	@Override
	public FormAvaliacao buscarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select f from FormAvaliacao f inner join f.Avaliacao as a inner join f.Aluno as al"
				+ " where a.id = " + avaliacaoId + " and al.id = " + alunoId;

		return (FormAvaliacao) HibernateUtils.obtem(hqlQuery);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#buscarFormAvaliacao(long)
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
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#buscarListResposta(long)
	 */
	@Override
	public List<Resposta> buscarListResposta(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select r from FormAvaliacao fa inner join fa.respostas as r where fa.id = "
				+ formAvaliacaoId;

		return (List<Resposta>) HibernateUtils.obtemList(hqlQuery);
		// FormAvaliacao fa = buscarFormAvaliacao(formAvaliacaoId);
		// return fa.getRespostas();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#gravarFormAvaliacao(de.berlios.escola.acd.src.FormAvaliacao)
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
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#alterarFormAvaliacao(de.berlios.escola.acd.src.FormAvaliacao)
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
	 * @see de.berlios.escola.acd.src.FormAvaliacaoRepository#excluirFormAvaliacao(de.berlios.escola.acd.src.FormAvaliacao)
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
