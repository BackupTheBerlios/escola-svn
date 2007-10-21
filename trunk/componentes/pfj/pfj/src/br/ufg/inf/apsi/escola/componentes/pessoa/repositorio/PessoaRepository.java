package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;


import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaPessoaEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PessoaNaoEncontradaException;
/**
 * Interface definida para gerenciar a persistência de pessoas.
 * @author gilmar
 *
 */
public interface PessoaRepository {
	/**
	 * Operação definida para incluir um novo cadastro de pessoa no repositório.
	 * @param pessoa
	 * @return boolean
	 * @throws PessoaCadastradaException
	 */
	boolean incluir(Pessoa pessoa) throws PessoaCadastradaException;
	/**
	 * Operação definida para remover o cadastro de uma pessoa do repositório.
	 * @param pessoaId
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean remover(Long pessoaId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de uma pessoa.
	 * @param pessoa
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Pessoa pessoa) throws EscolaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa, a partir do seu identificador.
	 * @param pessoaId
	 * @return {@link Pessoa}
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa consultarPessoaId(Long pessoaId) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa, a partir do número de um dos seus documentos.
	 * @param numeroDocumento
	 * @return {@link Pessoa}
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa consultaPessoaDocumento(String numeroDocumento) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa (id e nome), a partir do número de um dos seus
	 * documentos 
	 * @param numeroDocumento
	 * @return Map<Long, String>
	 * @throws PessoaNaoEncontradaException
	 */
	Map<Long, String> consultaPessoaPorDocumento(String numeroDocumento) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para carregar os dados de uma pessoa, a partir do deu identificador.
	 * @param pessoaId
	 * @return {@link Pessoa}
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa carregar(Long pessoaId) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa, a partir do seu nome e sua data de nascimento.
	 * @param nomePessoa
	 * @param dataNascimento
	 * @return {@link Pessoa}
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa consultaPessoaNomeDataNascimento(String nomePessoa, Date dataNascimento) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar pessoas, a partir do nome.
	 * @param nomePessoa
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaNome(String nomePessoa) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para consultar pessoas, moradoras de um determinada cidade.
	 * @param nomeCidade
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaCidade(String nomeCidade) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para consultar pessoas, moradoras de um determinado bairro.
	 * @param nomeBairro
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaBairro(String nomeBairro) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para consultar pessoas, a partir de um número de telefone.
	 * @param numeroTelefone
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaTelefone(long numeroTelefone) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para listar todas as pessoas cadastradas.
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaTodos() throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para listar pessoas, por idade.
	 * @param dataNascimento
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaPessoasIdade(Date dataNascimento) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para listar pessoas por sexo.
	 * @param sexo
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaPessoasSexo(String sexo) throws NenhumaPessoaEncontradaException;
	/**
	 * OPeração definida para listar pessoas por idade e sexo.
	 * @param dataNascimento
	 * @param sexo
	 * @return List<Pessoa>
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaPessoasIdadeSexo(Date dataNascimento, String sexo) throws NenhumaPessoaEncontradaException;
	
}
