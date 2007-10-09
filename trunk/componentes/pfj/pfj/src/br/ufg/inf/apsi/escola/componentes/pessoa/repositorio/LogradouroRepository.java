package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Logradouro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.LogradouroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumLogradouroEncontradoException;

/**
 * Interface definida para gerenciar a persistência de logradouros.
 * @author gilmar
 *
 */
public interface LogradouroRepository {
	/**
	 * Operação definida para incluir um novo cadastro de logradouro no repositório.
	 * @param log
	 * @return
	 * @throws LogradouroCadastradoException
	 */
	boolean incluir(Logradouro log) throws LogradouroCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um logradouro do repositório.
	 * @param logradouroId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long logradouroId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um logradouro.
	 * @param log
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Logradouro log) throws EscolaException;
	/**
	 * Operação definida para consultar um logradouro, a partir do seu nome.
	 * @param nome
	 * @return
	 * @throws LogradouroNaoEncontradoException
	 */
	Logradouro consultar(String nome) throws LogradouroNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de uma logradouro, a partir do seu identificador.
	 * @param logradouroId
	 * @return
	 * @throws LogradouroNaoEncontradoException
	 */
	Logradouro carregar(Long logradouroId) throws LogradouroNaoEncontradoException;
	/**
	 * Operação definida para listar todos os logradouros cadastrados.
	 * @return
	 * @throws NenhumLogradouroEncontradoException
	 */
	List<Logradouro> listaTodos() throws NenhumLogradouroEncontradoException;
}
