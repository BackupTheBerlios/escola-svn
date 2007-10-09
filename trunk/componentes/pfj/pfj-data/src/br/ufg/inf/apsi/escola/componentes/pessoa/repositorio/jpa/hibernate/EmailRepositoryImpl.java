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

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEmailEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository;



/**
 * Classe definida para implementar a persistência de emails.
 * @author gilmar
 *
 */
public class EmailRepositoryImpl implements EmailRepository {

	private CriaPersistenciaGeral persistencia = null;
	private Query q;
	/**
	 * 
	 *
	 */
	public EmailRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operação consultar.
	 */
	public Email consultar(String email) throws EmailNaoEncontradoException {
		Email mail;
		try {
			q = persistencia.getEm().createQuery("from Email e where e.email =:email");
			q.setParameter("email", email);
			mail = (Email) q.getSingleResult();
			return mail;	
		} catch (NoResultException nre) {
			throw new EmailNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new EmailNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new EmailNaoEncontradoException();
		}
	}
	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Email e) throws EmailCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(e);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new EmailCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new EmailCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new EmailCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new EmailCadastradoException();
		}
	}
	/**
	 * Implementação da operação remover.
	 */
	public boolean remover(String email) throws EscolaException {
		Email mail = null;
		persistencia.getTx().begin();
		try {
			mail = consultar(email);
			persistencia.getEm().remove(mail);
			persistencia.getTx().commit();
			return true;
		}catch (EmailNaoEncontradoException bnee) {
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
	public boolean salvar(Email e) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(e);
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
	public Email carregar(Long emailId) throws EmailNaoEncontradoException {
		Email mail = null;
		try {
			mail = persistencia.getEm().find(Email.class, emailId);
			return mail;
		} catch (IllegalStateException ilee) {
			throw new EmailNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new EmailNaoEncontradoException();
		}
	}
	/**
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Email> listaTodos() throws NenhumEmailEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Email e");	
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumEmailEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEmailEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEmailEncontradoException();
		}
	}
}
