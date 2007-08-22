package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.DocumentoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.DocumentoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.DocumentoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumDocumentoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.RemocaoDocumentoException;


/**
 * Classe definida para implementar a persistência de documentos.
 * @author gilmar
 *
 */
public class DocumentoRepositoryImpl implements DocumentoRepository {
	
	private CriaPersistenciaGeral persistencia = new CriaPersistenciaGeral();
	private Query q;
	/**
	 * 
	 *
	 */
	public DocumentoRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Documento doc) throws DocumentoCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(doc);
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
	 * Implementação da operação remover.
	 */
	public boolean remover(String numero) throws RemocaoDocumentoException {
		Documento doc = null;
		persistencia.getTx().begin();
		try {
			doc = consultar(numero);
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
	 * Implementação da operação salvar.
	 */
	public boolean salvar(Documento doc) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(doc);
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
	 * Implementação da operação consultar.
	 */
	public Documento consultar(String numero) throws DocumentoNaoEncontradoException {
		Documento doc = null;
		try {
			q = persistencia.getEm().createQuery("from Documento d where d.numero =:numero");
			q.setParameter("numero", numero);
			doc = (Documento) q.getSingleResult();
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
	 * Implementação da operação carregar.
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
	 * Implementação da operação listaTodos
	 */
	@SuppressWarnings("unchecked")
	public List<Documento> listaTodos() throws NenhumDocumentoEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Documento d");
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumDocumentoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumDocumentoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumDocumentoEncontradoException();
		}
	}
}
