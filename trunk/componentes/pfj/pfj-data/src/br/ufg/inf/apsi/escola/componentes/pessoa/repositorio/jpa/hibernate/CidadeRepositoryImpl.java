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
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.CidadeRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.CidadeCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.CidadeNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumaCidadeEncontradaException;

/**
 * Classe definida para implementar a persistência de cidades.
 * @author gilmar
 *
 */
public class CidadeRepositoryImpl implements CidadeRepository {
	
	private CriaPersistenciaGeral persistencia = null;
	private Query q;
	/**
	 * 
	 *
	 */
	public CidadeRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operação consultar.
	 */
	public Cidade consultar(String nome) throws CidadeNaoEncontradaException {
		Cidade cidade = null;
		try {
			q = persistencia.getEm().createQuery("from Cidade c where c.nome =:nome");
			q.setParameter("nome", nome);
			cidade = (Cidade) q.getSingleResult();
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
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Cidade c) throws CidadeCadastradaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(c);
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
	 * Implementação da operação remover.
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
	 * Implementação da operação salvar.
	 */
	public boolean salvar(Cidade c) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(c);
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
	 *Implementação da operação carregar. 
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
	 * Implementação da operação listaTodas.
	 */
	@SuppressWarnings("unchecked")
	public List<Cidade> listaTodas() throws NenhumaCidadeEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("from Cidade c");
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumaCidadeEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaCidadeEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaCidadeEncontradaException();
		}
	}
	
}
