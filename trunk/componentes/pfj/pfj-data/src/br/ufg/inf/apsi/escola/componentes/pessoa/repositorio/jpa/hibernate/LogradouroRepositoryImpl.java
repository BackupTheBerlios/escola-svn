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
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumLogradouroEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository;



/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository
 */
public class LogradouroRepositoryImpl implements LogradouroRepository {
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
	public LogradouroRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository#consultar(String)
	 */
	public Logradouro consultar(String nomeLogradouro) throws LogradouroNaoEncontradoException {
		try {
			query = persistencia.getEm().createQuery("from Logradouro log where log.nome=:nome");
			query.setParameter("nome", nomeLogradouro);
			return (Logradouro) query.getSingleResult();
		}catch (NoResultException nre) {
			throw new LogradouroNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new LogradouroNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new LogradouroNaoEncontradoException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository#incluir(Logradouro)
	 */
	public boolean incluir(Logradouro logradouro) throws LogradouroCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(logradouro);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository#remover(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository#salvar(Logradouro)
	 */
	public boolean salvar(Logradouro logradouro) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(logradouro);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository#carregar(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.LogradouroRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Logradouro> listaTodos() throws NenhumLogradouroEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Logradouro log");
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumLogradouroEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumLogradouroEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumLogradouroEncontradoException();
		}
	}
}
