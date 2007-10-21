
package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumBairroEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository;


/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository
 *
 */
public class BairroRepositoryImpl implements BairroRepository {
	/**
	 * atributo definido para representar o gerenciador de persistência
	 */
	private CriaPersistenciaGeral persistencia = null;
	/**
	 * atributo definido para representar um objeto de consulta ao repositório
	 */
	Query query;
	/**
	 * construtor inicializando o gerenciador de persistência
	 *
	 */
	public BairroRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository#consultar(String)
	 */
	public Bairro consultar(String nomeBairro) throws BairroNaoEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Bairro b where b.nome =:nome");
			query.setParameter("nome", nomeBairro);
			return (Bairro) query.getSingleResult(); 
		}catch (NoResultException nre) {
			throw new BairroNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new BairroNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new BairroNaoEncontradoException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository#incluir(Bairro)
	 */
	public boolean incluir(Bairro bairro) throws BairroCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(bairro);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new BairroCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new BairroCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new BairroCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new BairroCadastradoException();
		}
	}

	/** 
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository#remover(Long)
	 */
	public boolean remover(Long bairroId) throws EscolaException {
		Bairro bairro = null;
		persistencia.getTx().begin();
		try {
			bairro = carregar(bairroId);
			persistencia.getEm().remove(bairro);
			persistencia.getTx().commit();
			return true;
		}catch (BairroNaoEncontradoException bnee) {
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository#salvar(Bairro)
	 */
	public boolean salvar(Bairro bairro) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(bairro);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository#carregar(Long)
	 */
	public Bairro carregar(Long bairroId) throws BairroNaoEncontradoException {
		Bairro bairro = null;
		try {
			bairro = persistencia.getEm().find(Bairro.class, bairroId);
			return bairro;
		} catch (IllegalStateException ilee) {
			throw new BairroNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new BairroNaoEncontradoException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.BairroRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Bairro> listaTodos() throws NenhumBairroEncontradoException {
		try {
			query = persistencia.getEm().createQuery("from Bairro b");
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumBairroEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumBairroEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumBairroEncontradoException();
		}
	}
}
