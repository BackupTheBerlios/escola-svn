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

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.LogradouroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.LogradouroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumLogradouroEncontradoException;



/**
 * Classe definida para implementar a persistência de Logradouros.
 * @author gilmar
 *
 */
public class LogradouroRepositoryImpl implements LogradouroRepository {
	
	private CriaPersistenciaGeral persistencia = null;
	private Query q;
	/**
	 * 
	 *
	 */
	public LogradouroRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}

	/**
	 * Implementação da operação consultar.
	 */
	public Logradouro consultar(String nome) throws LogradouroNaoEncontradoException {
		try {
			q = persistencia.getEm().createQuery("from Logradouro log where log.nome=:nome");
			q.setParameter("nome", nome);
			return (Logradouro) q.getSingleResult();
		}catch (NoResultException nre) {
			throw new LogradouroNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new LogradouroNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new LogradouroNaoEncontradoException();
		}
	}

	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Logradouro log) throws LogradouroCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(log);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new LogradouroCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new LogradouroCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new LogradouroCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new LogradouroCadastradoException();
		}
	}

	/**
	 * Operação da operação remover.
	 */
	public boolean remover(Long logradouroId) throws EscolaException {
		persistencia.getTx().begin();
		try {
			Logradouro log = carregar(logradouroId);
			persistencia.getEm().remove(log);
			persistencia.getTx().commit();
			return true;
		}catch (LogradouroNaoEncontradoException bnee) {
			throw new EscolaException(bnee.getMessage());
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
	public boolean salvar(Logradouro log) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(log);
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
	 * Implementação da operação carregar.
	 */
	public Logradouro carregar(Long logradouroId) throws LogradouroNaoEncontradoException {
		try {
			Logradouro log = persistencia.getEm().find(Logradouro.class, logradouroId);
			return log;
		} catch (IllegalStateException ilee) {
			throw new LogradouroNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new LogradouroNaoEncontradoException();
		}
	}
	/**
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Logradouro> listaTodos() throws NenhumLogradouroEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Logradouro log");
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumLogradouroEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumLogradouroEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumLogradouroEncontradoException();
		}
	}
}
