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
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEnderecoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository;



/**
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository
 *
 */
public class EnderecoRepositoryImpl implements EnderecoRepository {
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
	public EnderecoRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}
	/**
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#consultarNomeRua(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Endereco> consultarNomeRua(String nomeRua) throws NenhumEnderecoEncontradoException {
		 
		try {
			query = persistencia.getEm().createQuery("Select endr from Endereco endr " +
					" left join endr.logradouro logr " + 
					" where logr.nome = :nomeRua");
			query.setParameter("nomeRua", nomeRua);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumEnderecoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEnderecoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEnderecoEncontradoException();
		}
		
	}
	/**
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#incluir(Endereco)
	 */
	public boolean incluir(Endereco endereco) throws EnderecoCadastradoException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(endereco);
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
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#remover(Long)
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
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#salvar(Endereco)
	 */
	public boolean salvar(Endereco endereco) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(endereco);
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
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#carregar(Long)
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
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Endereco> listaTodos() throws NenhumEnderecoEncontradoException {
		
		try {
			query = persistencia.getEm().createQuery("from Endereco end");
			return query.getResultList();
		} catch (NoResultException nre) {
			throw new NenhumEnderecoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEnderecoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEnderecoEncontradoException();
		}
	}
	/**
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#consultaCep(Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<Endereco> consultaCep(Integer cep) throws NenhumEnderecoEncontradoException{
		
		try {
			query = persistencia.getEm().createQuery("from Endereco end where end.cep =:cep");
			query.setParameter("cep", cep);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumEnderecoEncontradoException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumEnderecoEncontradoException();
		}catch (IllegalStateException ilee) {
			throw new NenhumEnderecoEncontradoException();
		}
	}
	/**
	 *  @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.EnderecoRepository#consultarDiversos(String, String, String)
	 */
	@Override
	public Endereco consultarDiversos(String nomeRua, String complemento, String numero)
			throws EnderecoNaoEncontradoException {
		Endereco end = null;
		try {
			query = persistencia.getEm().createQuery("Select e from Endereco e left join e.logradouro logr " +
					" where logr.nome = :nomeRua and e.numero =:numero and e.complemento =:complemento");
			query.setParameter("nomeRua", nomeRua);
			query.setParameter("numero", numero);
			query.setParameter("complemento", complemento);
			end = (Endereco) query.getSingleResult();
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
