package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumDocumentoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.RemocaoDocumentoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository;


/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository
 */
public class DocumentoRepositoryImpl implements DocumentoRepository {
	/**
	 * atributo definido para representar o gerenciador de persistência
	 */
	private CriaPersistenciaGeral persistencia = new CriaPersistenciaGeral();
	/**
	 * atributo definido para representar o objeto de consulta ao repositório
	 */
	private Query query;
	/**
	 * 
	 *
	 */
	public DocumentoRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository#incluir(Documento)
	 */
	public boolean incluir(Documento documento) throws DocumentoCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(documento);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new DocumentoCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new DocumentoCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new DocumentoCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new DocumentoCadastradoException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository#remover(String)
	 */
	public boolean remover(String numeroDocumento) throws RemocaoDocumentoException {
		Documento doc = null;
		persistencia.getTx().begin();
		try {
			doc = consultar(numeroDocumento);
			persistencia.getEm().remove(doc);
			persistencia.getTx().commit();
			return true;
		}catch (DocumentoNaoEncontradoException bnee) {
			throw new RemocaoDocumentoException();
		} catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new RemocaoDocumentoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new RemocaoDocumentoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new RemocaoDocumentoException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository#salvar(Documento)
	 */
	public boolean salvar(Documento documento) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(documento);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository#consultar(String)
	 */
	public Documento consultar(String numeroDocumento) throws DocumentoNaoEncontradoException {
		Documento doc = null;
		try {
			query = persistencia.getEm().createQuery("from Documento d where d.numero =:numero");
			query.setParameter("numero", numeroDocumento);
			doc = (Documento) query.getSingleResult();
			return doc;
		}catch (NoResultException nre) {
			throw new DocumentoNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new DocumentoNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new DocumentoNaoEncontradoException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository#carregar(Long)
	 */
	public Documento carregar(Long documentoId) throws DocumentoNaoEncontradoException {
		Documento doc = null;
		try {
			doc = persistencia.getEm().find(Documento.class, documentoId);
			return doc;	
		} catch (IllegalStateException ilee) {
			throw new DocumentoNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new DocumentoNaoEncontradoException();
		}
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Documento> listaTodos() throws NenhumDocumentoEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Documento d");
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumDocumentoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumDocumentoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumDocumentoEncontradoException();
		}
	}
}
