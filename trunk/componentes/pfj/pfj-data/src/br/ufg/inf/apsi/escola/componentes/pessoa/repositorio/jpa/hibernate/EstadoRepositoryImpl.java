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
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository
 * 
 */
public class EstadoRepositoryImpl implements EstadoRepository {
	/**
	 * atributo definido para representar o gerenciador de persistência
	 */
	private CriaPersistenciaGeral persistencia;
	/**
	 * atributo definido para representar o objeto de consulta ao repositório
	 */
	private Query query;
	/**
	 * 
	 *
	 */
	public EstadoRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 *@see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository#consultar(String)
	 */
	public Estado consultar(String nomeEstado) throws EstadoNaoEncontradoException {
		try {
			query = persistencia.getEm().createQuery("from Estado est where est.nome=:nome");
			query.setParameter("nome", nomeEstado);
			return (Estado) query.getSingleResult();
		}catch (NoResultException nre) {
			throw new EstadoNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new EstadoNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new EstadoNaoEncontradoException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository#incluir(Estado)
	 */
	public boolean incluir(Estado estado) throws EstadoCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(estado);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository#remover(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository#salvar(Estado)
	 */
	public boolean salvar(Estado estado) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(estado);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository#carregar(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EstadoRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Estado> listaTodos() throws NenhumEstadoEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Estado est");
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumEstadoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEstadoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEstadoEncontradoException();
		}
	}
}
