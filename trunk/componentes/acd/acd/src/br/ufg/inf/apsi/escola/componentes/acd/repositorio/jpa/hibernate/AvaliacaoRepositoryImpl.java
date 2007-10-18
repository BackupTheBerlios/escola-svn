package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.util.List;

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
public class AvaliacaoRepositoryImpl extends JpaDaoSupport implements AvaliacaoRepository {

	public AvaliacaoRepositoryImpl() {
		
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarAvaliacao(java.lang.Long)
	 */
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return (Avaliacao) getJpaTemplate().find(Avaliacao.class, avaliacaoId);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarAvaliacaoTurma(java.lang.Long)
	 */
	public Avaliacao buscarAvaliacaoTurma(Long turmaId) {
		// TODO Auto-generated method stub
		return (Avaliacao) getJpaTemplate().find("from Avaliacao a where a.turmaId = " + turmaId);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#buscarListQuestao(java.lang.Long)
	 */
	public List<Questao> buscarListQuestao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		String hqlQuery = "select q from Avaliacao a inner join a.questoes as q where a.id = " + avaliacaoId;

		return (List<Questao>) getJpaTemplate().find(hqlQuery);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#gravarAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	public boolean gravarAvaliacao(Avaliacao avaliacao) {
		// TODO Auto-generated method stub
		try {
			getJpaTemplate().persist(avaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#alterarAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	public boolean alterarAvaliacao(Avaliacao avaliacao) {
		// TODO Auto-generated method stub
		try {
			getJpaTemplate().refresh(avaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.apsi.escola.componentes.acd.repositorio.AvaliacaoRepository#excluirAvaliacao(br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao)
	 */
	public boolean excluirAvaliacao(Avaliacao avaliacao) {
		// TODO Auto-generated method stub
		try {
			getJpaTemplate().remove(avaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
