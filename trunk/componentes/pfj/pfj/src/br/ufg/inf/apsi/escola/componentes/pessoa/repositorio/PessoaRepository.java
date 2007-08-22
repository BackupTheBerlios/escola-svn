package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;


import java.util.Date;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.*;
/**
 * Interface definida para gerenciar a persistência de pessoas.
 * @author gilmar
 *
 */
public interface PessoaRepository {
	/**
	 * Operação definida para incluir um novo cadastro de pessoa no repositório.
	 * @param p
	 * @return
	 * @throws PessoaCadastradaException
	 */
	boolean incluir(Pessoa p) throws PessoaCadastradaException;
	/**
	 * Operação definida para remover o cadastro de uma pessoa do repositório.
	 * @param pessoaId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long pessoaId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de uma pessoa.
	 * @param p
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Pessoa p) throws EscolaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa, a partir do seu identificador.
	 * @param pessoaId
	 * @return
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa consultarPessoaId(Long pessoaId) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa, a partir do número de um dos seus documentos.
	 * @param numeroDocumento
	 * @return
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa consultaPessoaDocumento(String numeroDocumento) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para carregar os dados de uma pessoa, a partir do deu identificador.
	 * @param pessoaId
	 * @return
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa carregar(Long pessoaId) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar os dados de uma pessoa, a partir do seu nome e sua data de nascimento.
	 * @param nome
	 * @param dataNascimento
	 * @return
	 * @throws PessoaNaoEncontradaException
	 */
	Pessoa consultaPessoaNomeDataNascimento(String nome, Date dataNascimento) throws PessoaNaoEncontradaException;
	/**
	 * Operação definida para consultar pessoas, a partir do nome.
	 * @param nome
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaNome(String nome) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para consultar pessoas, moradoras de um determinada cidade.
	 * @param nomeCidade
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaCidade(String nomeCidade) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para consultar pessoas, moradoras de um determinado bairro.
	 * @param nomeBairro
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaBairro(String nomeBairro) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para consultar pessoas, a partir de um número de telefone.
	 * @param numeroTelefone
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> consultarPessoaTelefone(long numeroTelefone) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para listar todas as pessoas cadastradas.
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaTodos() throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para listar pessoas, por idade.
	 * @param dataNascimento
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaPessoasIdade(Date dataNascimento) throws NenhumaPessoaEncontradaException;
	/**
	 * Operação definida para listar pessoas por sexo.
	 * @param sexo
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaPessoasSexo(String sexo) throws NenhumaPessoaEncontradaException;
	/**
	 * OPeração definida para listar pessoas por idade e sexo.
	 * @param dataNascimento
	 * @param sexo
	 * @return
	 * @throws NenhumaPessoaEncontradaException
	 */
	List<Pessoa> listaPessoasIdadeSexo(Date dataNascimento, String sexo) throws NenhumaPessoaEncontradaException;
	
}
