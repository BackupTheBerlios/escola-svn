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

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEstadoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository;


/**
 * Classe definida para implementar a persistência de estados.
 * @author gilmar
 *
 */
public class EstadoRepositoryImpl implements EstadoRepository {

	private CriaPersistenciaGeral persistencia;
	private Query q;
	/**
	 * 
	 *
	 */
	public EstadoRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operação consultar.
	 */
	public Estado consultar(String nome) throws EstadoNaoEncontradoException {
		try {
			q = persistencia.getEm().createQuery("from Estado est where est.nome=:nome");
			q.setParameter("nome", nome);
			return (Estado) q.getSingleResult();
		}catch (NoResultException nre) {
			throw new EstadoNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new EstadoNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new EstadoNaoEncontradoException();
		}
	}

	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Estado est) throws EstadoCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(est);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new EstadoCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new EstadoCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new EstadoCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new EstadoCadastradoException();
		}
	}

	/**
	 * Implementação da operação remover.
	 */
	public boolean remover(Long estadoId) throws EscolaException {
		persistencia.getTx().begin();
		try {
			Estado estado = carregar(estadoId);
			persistencia.getEm().remove(estado);
			persistencia.getTx().commit();
			return true;
		}catch (EstadoNaoEncontradoException bnee) {
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
	public boolean salvar(Estado est) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(est);
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
	public Estado carregar(Long estadoId) throws EstadoNaoEncontradoException {
		try {
			Estado estado = persistencia.getEm().find(Estado.class, estadoId);
			return estado;
		} catch (IllegalStateException ilee) {
			throw new EstadoNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new EstadoNaoEncontradoException();
		}
	}
	/**
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Estado> listaTodos() throws NenhumEstadoEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Estado est");
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumEstadoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEstadoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEstadoEncontradoException();
		}
	}
}
