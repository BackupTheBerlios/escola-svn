/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;

import java.util.List;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaCidadeEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository;

/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository
 *
 */
public class CidadeRepositoryImpl implements CidadeRepository {
	/**
	 * atributo definido para representar o gerenciador de persistência
	 */
	private CriaPersistenciaGeral persistencia = null;
	/**
	 * atributo definido para representar o objeto de consulta ao repositório
	 */
	private Query query;
	/**
	 * construtor inicializando o gerenciador de persistência
	 */
	public CidadeRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository#consultar(String)
	 */
	public Cidade consultar(String nomeCidade) throws CidadeNaoEncontradaException {
		Cidade cidade = null;
		try {
			query = persistencia.getEm().createQuery("from Cidade c where c.nome =:nome");
			query.setParameter("nome", nomeCidade);
			cidade = (Cidade) query.getSingleResult();
			return cidade;
		}catch (NoResultException nre) {
			throw new CidadeNaoEncontradaException();
		} catch (EntityNotFoundException enfe) {
			throw new CidadeNaoEncontradaException();
		} catch (IllegalStateException ilee) {
			throw new CidadeNaoEncontradaException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository#incluir(Cidade)
	 */
	public boolean incluir(Cidade cidade) throws CidadeCadastradaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(cidade);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new CidadeCadastradaException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new CidadeCadastradaException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new CidadeCadastradaException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new CidadeCadastradaException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository#remover(Long)
	 */
	public boolean remover(Long cidadeId) throws EscolaException {
		Cidade cidade = null;
		persistencia.getTx().begin();
		try {
			cidade = carregar(cidadeId);
			persistencia.getEm().remove(cidade);
			persistencia.getTx().commit();
			return true;
		}catch (CidadeNaoEncontradaException cnee) {
			throw new EscolaException(cnee.getMessage());
		} catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new EscolaException(ilee.getMessage());
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new EscolaException(ilae.getMessage());
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new EscolaException(tre.getMessage());
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository#salvar(Cidade)
	 */
	public boolean salvar(Cidade cidade) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(cidade);
			persistencia.getTx().commit();
			return true;
		} catch (IllegalStateException ilae) {
			persistencia.getTx().rollback();
			throw new EscolaException(ilae.getMessage());
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new EscolaException(ilae.getMessage());
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new EscolaException(tre.getMessage());
		}
	}
	/**
	 *@see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository#carregar(Long) 
	 */
	public Cidade carregar(Long cidadeId) throws CidadeNaoEncontradaException {
		Cidade cidade = null;
		try{
			cidade = persistencia.getEm().find(Cidade.class, cidadeId);
			return cidade;
		} catch (IllegalStateException ilee) {
			throw new CidadeNaoEncontradaException();
		}catch (IllegalArgumentException ilae) {
			throw new CidadeNaoEncontradaException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository#listaTodas()
	 */
	@SuppressWarnings("unchecked")
	public List<Cidade> listaTodas() throws NenhumaCidadeEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("from Cidade c");
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumaCidadeEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaCidadeEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaCidadeEncontradaException();
		}
	}
	
}
