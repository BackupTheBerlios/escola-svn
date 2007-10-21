package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumTelefoneEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository;

/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository
 */
public class TelefoneRepositoryImpl implements TelefoneRepository {
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
	public TelefoneRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository#consultar(long)
	 */
	public Telefone consultar(long numeroTelefone) throws TelefoneNaoEncontradoException {
		try {
			query = persistencia.getEm().createQuery("from Telefone t where t.numero =:numero");
			query.setParameter("numero", numeroTelefone);
			return (Telefone)query.getSingleResult();
		}catch (NoResultException nre) {
			throw new TelefoneNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new TelefoneNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new TelefoneNaoEncontradoException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository#incluir(Telefone)
	 */
	public boolean incluir(Telefone telefone) throws TelefoneCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(telefone);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository#remover(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository#salvar(Telefone)
	 */
	public boolean salvar(Telefone telefone) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(telefone);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository#carregar(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.TelefoneRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Telefone> listaTodos() throws NenhumTelefoneEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Telefone t");
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumTelefoneEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumTelefoneEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumTelefoneEncontradoException();
		}
	}
}
