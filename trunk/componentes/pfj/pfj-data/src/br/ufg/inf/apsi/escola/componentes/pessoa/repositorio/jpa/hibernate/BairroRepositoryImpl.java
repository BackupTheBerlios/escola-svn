/**
 * 
 */
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
 * Classe definida para implementar a persistência de bairros.
 * @author gilmar
 *
 */
public class BairroRepositoryImpl implements BairroRepository {
	
	private CriaPersistenciaGeral persistencia = null;
	Query q;
	/**
	 * 
	 *
	 */
	public BairroRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	
	
	/**
	 * Implementação da operação consultar.
	 */
	public Bairro consultar(String nome) throws BairroNaoEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Bairro b where b.nome =:nome");
			q.setParameter("nome", nome);
			return (Bairro) q.getSingleResult(); 
		}catch (NoResultException nre) {
			throw new BairroNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new BairroNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new BairroNaoEncontradoException();
		}
	}

	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Bairro b) throws BairroCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(b);
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
	 * Implementação da operação remover.
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
	 * Implementação da operação salvar.
	 */
	public boolean salvar(Bairro b) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(b);
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


	@SuppressWarnings("unchecked")
	public List<Bairro> listaTodos() throws NenhumBairroEncontradoException {
		try {
			q = persistencia.getEm().createQuery("from Bairro b");
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumBairroEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumBairroEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumBairroEncontradoException();
		}
	}
}
