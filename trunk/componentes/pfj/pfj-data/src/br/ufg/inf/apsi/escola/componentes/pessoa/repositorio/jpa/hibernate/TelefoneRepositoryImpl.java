package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumTelefoneEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TelefoneNaoEncontradoException;

/**
 * Classe definida para implementar a persistência de telefones.
 * @author gilmar
 *
 */
public class TelefoneRepositoryImpl implements TelefoneRepository {
	
	private CriaPersistenciaGeral persistencia = null;
	private Query q;
	/**
	 * 
	 *
	 */
	public TelefoneRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operação consultar.
	 */
	public Telefone consultar(long numero) throws TelefoneNaoEncontradoException {
		try {
			q = persistencia.getEm().createQuery("from Telefone t where t.numero =:numero");
			q.setParameter("numero", numero);
			return (Telefone)q.getSingleResult();
		}catch (NoResultException nre) {
			throw new TelefoneNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new TelefoneNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new TelefoneNaoEncontradoException();
		}
	}
	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Telefone t) throws TelefoneCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(t);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new TelefoneCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new TelefoneCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new TelefoneCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new TelefoneCadastradoException();
		}
	}
	/**
	 * Implementação da operação remover.
	 */
	public boolean remover(Long telefoneId) throws EscolaException {
		persistencia.getTx().begin();
		try {
			Telefone fone = carregar(telefoneId);
			persistencia.getEm().remove(fone);
			persistencia.getTx().commit();
			return true;
		}catch (TelefoneNaoEncontradoException bnee) {
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
	public boolean salvar(Telefone t) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(t);
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
	public Telefone carregar(Long telefoneId) throws TelefoneNaoEncontradoException {
		try {
			Telefone fone = persistencia.getEm().find(Telefone.class, telefoneId);
			return fone;	
		} catch (IllegalStateException ilee) {
			throw new TelefoneNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new TelefoneNaoEncontradoException();
		}
		
	}
	/**
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Telefone> listaTodos() throws NenhumTelefoneEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Telefone t");
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumTelefoneEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumTelefoneEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumTelefoneEncontradoException();
		}
	}
}
