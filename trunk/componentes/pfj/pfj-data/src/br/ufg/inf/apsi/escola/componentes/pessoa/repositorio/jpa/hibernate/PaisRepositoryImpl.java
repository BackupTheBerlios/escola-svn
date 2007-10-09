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
 * Classe definida para implementar a persistência de países.
 * @author gilmar
 *
 */
public class PaisRepositoryImpl implements PaisRepository {

	private CriaPersistenciaGeral persistencia;
	Query q;
	/**
	 * 
	 *
	 */
	public PaisRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operação consultar.
	 */
	public Pais consultar(String nome) throws PaisNaoEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Pais p where p.nome=:nome");
			q.setParameter("nome", nome);
			return (Pais) q.getSingleResult();
		}catch (NoResultException nre) {
			throw new PaisNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new PaisNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new PaisNaoEncontradoException();
		}
	}

	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Pais p) throws PaisCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(p);
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
	 * Implementação da operação remover.
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
	 * Implementação da operação salvar.
	 */
	public boolean salvar(Pais p) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(p);
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
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Pais> listaTodos() throws NenhumPaisEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Pais p");
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumPaisEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumPaisEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumPaisEncontradoException();
		}
	}
}
