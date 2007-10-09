/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TransactionRequiredException;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository;


/**
 * Classe definida para implementar a persistência de pessoas.
 * @author gilmar
 *
 */
public class PessoaRepositoryImpl implements PessoaRepository {

	private CriaPersistenciaGeral persistencia = null;
	private Query q;
	/**
	 * 
	 *
	 */
	public PessoaRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}

	/**
	 * Implementação da operação consultarPessoaBairro.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaBairro(String nomeBairro) throws NenhumaPessoaEncontradaException{
		
		try {
			q = persistencia.getEm().createQuery("Select p from Pessoa AS p, IN (p.listaEnderecos) e " +
					" left join e.bairro b" +
					" where b.nome = :nomeBairro");
			q.setParameter("nomeBairro", nomeBairro);	
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}

	/**
	 * Implementação da operação consultarPessoaCidade.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaCidade(String nomeCidade) throws NenhumaPessoaEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("Select p from Pessoa AS p, IN (p.listaEnderecos) e " +
					" left join e.bairro b " + 
					" left join b.cidade c " + 
					" where c.nome =:nomeCidade");
			q.setParameter("nomeCidade", nomeCidade);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}

	/**
	 * Implementação da operação consultaPessoaDocumento.
	 */
	public Pessoa consultaPessoaDocumento(String numeroDocumento) throws PessoaNaoEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("Select p from Pessoa p " + 
				" left join p.listaDocumentos l "	+
				" where l.numero = :numeroDocumento");
			q.setParameter("numeroDocumento", numeroDocumento);
			return (Pessoa) q.getSingleResult();	
		}catch (NoResultException nre) {
			throw new PessoaNaoEncontradaException();
		} catch (EntityNotFoundException enfe) {
			throw new PessoaNaoEncontradaException();
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	/**
	 * Implementação da operação consultaPessoaNomeDataNascimento.
	 */
	@Override
	public Pessoa consultaPessoaNomeDataNascimento(String nome,
			Date dataNascimento) throws PessoaNaoEncontradaException {
		try{
			q = persistencia.getEm().createQuery("From Pessoa p where p.nome=:nome and p.dataNascimento =:dataNascimento");
			q.setParameter("nome", nome);
			q.setParameter("dataNascimento", dataNascimento, TemporalType.DATE);
			return (Pessoa) q.getSingleResult();
		}catch (NoResultException nre) {
			throw new PessoaNaoEncontradaException();
		} catch (EntityNotFoundException enfe) {
			throw new PessoaNaoEncontradaException();
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}
	}

	/**
	 * Implementação da operação consultarPessoaId.
	 */
	public Pessoa consultarPessoaId(Long pessoaId) throws PessoaNaoEncontradaException {
		try {
			Pessoa p = carregar(pessoaId);
			return p;	
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}catch (IllegalArgumentException ilae) {
			throw new PessoaNaoEncontradaException();
		}
	}

	/**
	 * Implementação da operação consultarPessoaNome.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaNome(String nome) throws NenhumaPessoaEncontradaException {

		try {
			q = persistencia.getEm().createQuery("select p from Pessoa p where p.nome like :nome");
			q.setParameter("nome", "%"+nome+"%");	
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}

	/**
	 * Implementação da operação consultarPessoaTelefone.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaTelefone(long numeroTelefone) throws NenhumaPessoaEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("Select p from Pessoa p " + 
					" left join p.listaTelefones t" + 
					" where t.numero = :numeroTelefone");
			q.setParameter("numeroTelefone",numeroTelefone);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
		
	}

	/**
	 * Implementação da operação incluir.
	 */
	public boolean incluir(Pessoa p) throws PessoaCadastradaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(p);
			persistencia.getTx().commit();
			return true;
		} catch (EntityExistsException eee) {
			persistencia.getTx().rollback();
			throw new PessoaCadastradaException();
		}catch (IllegalStateException ilee) {
			persistencia.getTx().rollback();
			throw new PessoaCadastradaException();
		}catch (IllegalArgumentException ilae) {
			persistencia.getTx().rollback();
			throw new PessoaCadastradaException();
		}catch (TransactionRequiredException tre) {
			persistencia.getTx().rollback();
			throw new PessoaCadastradaException();
		}
	}

	/**
	 * Implementação da operação remover.
	 */
	public boolean remover(Long pessoaId) throws EscolaException {
		persistencia.getTx().begin();
		try {
			Pessoa p = carregar(pessoaId);
			persistencia.getEm().remove(p);
			persistencia.getTx().commit();
			return true;	
		}catch (PessoaNaoEncontradaException pnee) {
			throw new EscolaException(pnee.getMessage());
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
	public boolean salvar(Pessoa p) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(p);
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
	public Pessoa carregar(Long pessoaId) throws PessoaNaoEncontradaException {
		try {
			Pessoa p = persistencia.getEm().find(Pessoa.class, pessoaId);
			return p;	
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}catch (IllegalArgumentException ilae) {
			throw new PessoaNaoEncontradaException();
		}
	}
	/**
	 * Implementação da operação listaTodos.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaTodos() throws NenhumaPessoaEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("from Pessoa p");	
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
		
	}
	/**
	 * Implementação da operação listaPessoasIdade.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaPessoasIdade(Date dataNascimento) throws NenhumaPessoaEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("from Pessoa p where p.dataNascimento >= :dataNascimento");
			q.setParameter("dataNascimento", dataNascimento, TemporalType.DATE);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}	
	}
	
	/**
	 * Implementação da operação listaPessoasIdadeSexo.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaPessoasIdadeSexo(Date dataNascimento, String sexo) throws NenhumaPessoaEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("from Pessoa p where p.sexo =:sexo and p.dataNascimento >= :dataNascimento");
			q.setParameter("sexo", sexo);
			q.setParameter("dataNascimento", dataNascimento, TemporalType.DATE);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
		
	}
	/**
	 * Implementação da operação listaPessoasSexo.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaPessoasSexo(String sexo) throws NenhumaPessoaEncontradaException {
		
		try {
			q = persistencia.getEm().createQuery("from Pessoa p where p.sexo =:sexo");
			q.setParameter("sexo", sexo);
			return q.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}
}
