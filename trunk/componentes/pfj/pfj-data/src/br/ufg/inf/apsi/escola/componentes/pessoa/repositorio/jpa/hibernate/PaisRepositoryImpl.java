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

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumPaisEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository;



/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository
 */
public class PaisRepositoryImpl implements PaisRepository {
	/**
	 * atributo definido para representar o gerenciador de persistência
	 */
	private CriaPersistenciaGeral persistencia;
	/**
	 * atributo definido para representar o objeto de consulta ao repositório
	 */
	Query query;
	/**
	 * construtor inicializando o gerenciador de persistência
	 */
	public PaisRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository#consultar(String)
	 */
	public Pais consultar(String nomePais) throws PaisNaoEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Pais p where p.nome=:nome");
			query.setParameter("nome", nomePais);
			return (Pais) query.getSingleResult();
		}catch (NoResultException nre) {
			throw new PaisNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new PaisNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new PaisNaoEncontradoException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository#incluir(Pais)
	 */
	public boolean incluir(Pais pais) throws PaisCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(pais);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new PaisCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new PaisCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new PaisCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new PaisCadastradoException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository#remover(Long)
	 */
	public boolean remover(Long paisId) throws EscolaException {
		persistencia.getTx().begin();
		try {
			Pais pais = carregar(paisId);
			persistencia.getEm().remove(pais);
			persistencia.getTx().commit();
			return true;
		}catch (PaisNaoEncontradoException bnee) {
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository#salvar(Pais)
	 */
	public boolean salvar(Pais pais) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(pais);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository#carregar(Long)
	 */
	public Pais carregar(Long paisId) throws PaisNaoEncontradoException {
		try {
			Pais pais = persistencia.getEm().find(Pais.class, paisId);
			return pais;
		} catch (IllegalStateException ilee) {
			throw new PaisNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new PaisNaoEncontradoException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PaisRepository#listaTodos()
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Pais> listaTodos() throws NenhumPaisEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Pais p");
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumPaisEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumPaisEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumPaisEncontradoException();
		}
	}
}
