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

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumEnderecoEncontradoException;



/**
 * Classe definida para testar a implementação de endereços.
 * @author gilmar
 *
 */
public class EnderecoRepositoryImpl implements EnderecoRepository {

	private CriaPersistenciaGeral persistencia = null;
	private Query q;
	/**
	 * 
	 *
	 */
	public EnderecoRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 * Implementação da operaçã consultar.
	 */
	@SuppressWarnings("unchecked")
	public List<Endereco> consultarNomeRua(String nomeRua) throws NenhumEnderecoEncontradoException {
		 
		try {
			q = persistencia.getEm().createQuery("Select endr from Endereco endr " +
					" left join endr.logradouro logr " + 
					" where logr.nome = :nomeRua");
			q.setParameter("nomeRua", nomeRua);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumEnderecoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEnderecoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEnderecoEncontradoException();
		}
		
	}
	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Endereco end) throws EnderecoCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(end);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new EnderecoCadastradoException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new EnderecoCadastradoException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new EnderecoCadastradoException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new EnderecoCadastradoException();
		}
	}
	/**
	 * Implementação da operação remover.
	 */
	public boolean remover(Long enderecoId) throws EscolaException {
		persistencia.getTx().begin();
		try {
			Endereco end = carregar(enderecoId);
			persistencia.getEm().remove(end);
			persistencia.getTx().commit();
			return true;
		}catch (EnderecoNaoEncontradoException bnee) {
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
	public boolean salvar(Endereco end) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(end);
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
	public Endereco carregar(Long enderecoId) throws EnderecoNaoEncontradoException {
		persistencia.getTx().begin();
		try {
			Endereco end = persistencia.getEm().find(Endereco.class, enderecoId);
			return end;	
		} catch (IllegalStateException ilee) {
			throw new EnderecoNaoEncontradoException();
		}catch (IllegalArgumentException ilae) {
			throw new EnderecoNaoEncontradoException();
		}
		
	}
	/**
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Endereco> listaTodos() throws NenhumEnderecoEncontradoException {
		
		try {
			q = persistencia.getEm().createQuery("from Endereco end");
			return q.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumEnderecoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEnderecoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEnderecoEncontradoException();
		}
	}
	/**
	 * Implementação da operação consultaCep.
	 */
	@SuppressWarnings("unchecked")
	public List<Endereco> consultaCep(Integer cep) throws NenhumEnderecoEncontradoException{
		
		try {
			q = persistencia.getEm().createQuery("from Endereco end where end.cep =:cep");
			q.setParameter("cep", cep);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumEnderecoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEnderecoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEnderecoEncontradoException();
		}
	}
	/**
	 * Implementação da operação consultar.
	 */
	@Override
	public Endereco consultarDiversos(String nomeRua, String complemento, String numero)
			throws EnderecoNaoEncontradoException {
		Endereco end = null;
		try {
			q = persistencia.getEm().createQuery("Select e from Endereco e left join e.logradouro logr " +
					" where logr.nome = :nomeRua and e.numero =:numero and e.complemento =:complemento");
			q.setParameter("nomeRua", nomeRua);
			q.setParameter("numero", numero);
			q.setParameter("complemento", complemento);
			end = (Endereco) q.getSingleResult();
			return end;
		}catch (NoResultException nre) {
			throw new EnderecoNaoEncontradoException();
		} catch (EntityNotFoundException enfe) {
			throw new EnderecoNaoEncontradoException();
		} catch (IllegalStateException ilee) {
			throw new EnderecoNaoEncontradoException();
		}
	}
	
}
