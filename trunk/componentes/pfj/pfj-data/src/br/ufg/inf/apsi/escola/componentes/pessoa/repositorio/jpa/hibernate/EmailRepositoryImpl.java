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
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository
 *
 */
public class EmailRepositoryImpl implements EmailRepository {
	/**
	 * atributo definido para representar o gerenciador de persistência
	 */
	private CriaPersistenciaGeral persistencia = null;
	/**
	 * atributo definido para representar o objeto de consulta ao repositório
	 */
	private Query query;
	/**
	 * 
	 *
	 */
	public EmailRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository#consultar(String)
	 */
	public Email consultar(String email) throws EmailNaoEncontradoException {
		Email mail;
		try {
			query = persistencia.getEm().createQuery("from Email e where e.email =:email");
			query.setParameter("email", email);
			mail = (Email) query.getSingleResult();
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository#incluir(Email)
	 */
	public boolean incluir(Email email) throws EmailCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(email);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository#remover(String)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository#salvar(Email)
	 */
	public boolean salvar(Email email) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(email);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository#carregar(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EmailRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Email> listaTodos() throws NenhumEmailEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Email e");	
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumEmailEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEmailEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEmailEncontradoException();
		}
	}
}
