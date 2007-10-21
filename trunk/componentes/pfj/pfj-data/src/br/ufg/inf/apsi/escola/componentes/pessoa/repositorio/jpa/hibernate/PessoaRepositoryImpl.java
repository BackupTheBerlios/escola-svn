/**
 * 
 */
package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository
 *
 */
public class PessoaRepositoryImpl implements PessoaRepository {
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
	public PessoaRepositoryImpl(){
		persistencia = new CriaPersistenciaGeral();
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultarPessoaBairro(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaBairro(String nomeBairro) throws NenhumaPessoaEncontradaException{
		
		try {
			query = persistencia.getEm().createQuery("Select p from Pessoa AS p, IN (p.listaEnderecos) e " +
					" left join e.bairro b" +
					" where b.nome = :nomeBairro");
			query.setParameter("nomeBairro", nomeBairro);	
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultarPessoaCidade(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaCidade(String nomeCidade) throws NenhumaPessoaEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("Select p from Pessoa AS p, IN (p.listaEnderecos) e " +
					" left join e.bairro b " + 
					" left join b.cidade c " + 
					" where c.nome =:nomeCidade");
			query.setParameter("nomeCidade", nomeCidade);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultaPessoaDocumento(String)
	 */
	public Pessoa consultaPessoaDocumento(String numeroDocumento) throws PessoaNaoEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("Select p from Pessoa p " + 
				" left join p.listaDocumentos l "	+
				" where l.numero = :numeroDocumento");
			query.setParameter("numeroDocumento", numeroDocumento);
			return (Pessoa) query.getSingleResult();	
		}catch (NoResultException nre) {
			throw new PessoaNaoEncontradaException();
		} catch (EntityNotFoundException enfe) {
			throw new PessoaNaoEncontradaException();
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultaPessoaPorDocumento(java.lang.String)
	 */
	@Override
	public Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento)
			throws PessoaNaoEncontradaException {
		Pessoa pessoa = null;
		Map<Long, String> idNomePessoa = new HashMap<Long, String>();
		try {
			query = persistencia.getEm().createQuery("Select p from Pessoa p " + 
				" left join p.listaDocumentos l "	+
				" where l.numero = :numeroDocumento");
			query.setParameter("numeroDocumento", numeroDocumento);
			pessoa = (Pessoa) query.getSingleResult();	
		}catch (NoResultException nre) {
			throw new PessoaNaoEncontradaException();
		} catch (EntityNotFoundException enfe) {
			throw new PessoaNaoEncontradaException();
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}
		idNomePessoa.put(pessoa.getId(), pessoa.getNome());
		return idNomePessoa;
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultaPessoaNomeDataNascimento(String, Date)
	 */
	@Override
	public Pessoa consultaPessoaNomeDataNascimento(String nomePessoa,
			Date dataNascimento) throws PessoaNaoEncontradaException {
		try{
			query = persistencia.getEm().createQuery("From Pessoa p where p.nome=:nome and p.dataNascimento =:dataNascimento");
			query.setParameter("nome", nomePessoa);
			query.setParameter("dataNascimento", dataNascimento, TemporalType.DATE);
			return (Pessoa) query.getSingleResult();
		}catch (NoResultException nre) {
			throw new PessoaNaoEncontradaException();
		} catch (EntityNotFoundException enfe) {
			throw new PessoaNaoEncontradaException();
		} catch (IllegalStateException ilee) {
			throw new PessoaNaoEncontradaException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultarPessoaId(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultarPessoaNome(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaNome(String nomePessoa) throws NenhumaPessoaEncontradaException {

		try {
			query = persistencia.getEm().createQuery("select p from Pessoa p where p.nome like :nome");
			query.setParameter("nome", "%"+nomePessoa+"%");	
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#consultarPessoaTelefone(long)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoaTelefone(long numeroTelefone) throws NenhumaPessoaEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("Select p from Pessoa p " + 
					" left join p.listaTelefones t" + 
					" where t.numero = :numeroTelefone");
			query.setParameter("numeroTelefone",numeroTelefone);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
		
	}

	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#incluir(Pessoa)
	 */
	public boolean incluir(Pessoa pessoa) throws PessoaCadastradaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().persist(pessoa);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#remover(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#salvar(Pessoa)
	 */
	public boolean salvar(Pessoa pessoa) throws EscolaException {
		persistencia.getTx().begin();
		try {
			persistencia.getEm().merge(pessoa);
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#carregar(Long)
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
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#listaTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaTodos() throws NenhumaPessoaEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("from Pessoa p");	
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
		
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#listaPessoasIdade(Date)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaPessoasIdade(Date dataNascimento) throws NenhumaPessoaEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("from Pessoa p where p.dataNascimento >= :dataNascimento");
			query.setParameter("dataNascimento", dataNascimento, TemporalType.DATE);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}	
	}
	
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#listaPessoasIdadeSexo(Date, String)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaPessoasIdadeSexo(Date dataNascimento, String sexo) throws NenhumaPessoaEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("from Pessoa p where p.sexo =:sexo and p.dataNascimento >= :dataNascimento");
			query.setParameter("sexo", sexo);
			query.setParameter("dataNascimento", dataNascimento, TemporalType.DATE);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
		
	}
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.PessoaRepository#listaPessoasSexo(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> listaPessoasSexo(String sexo) throws NenhumaPessoaEncontradaException {
		
		try {
			query = persistencia.getEm().createQuery("from Pessoa p where p.sexo =:sexo");
			query.setParameter("sexo", sexo);
			return query.getResultList();	
		} catch (NoResultException nre) {
			throw new NenhumaPessoaEncontradaException();
		}catch (NonUniqueResultException nure) {
			throw new NenhumaPessoaEncontradaException();
		}catch (IllegalStateException ilee) {
			throw new NenhumaPessoaEncontradaException();
		}
	}
}
