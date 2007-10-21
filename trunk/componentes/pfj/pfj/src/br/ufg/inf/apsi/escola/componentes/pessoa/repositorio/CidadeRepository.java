package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.CidadeNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumaCidadeEncontradaException;

/**
 * Interface definida para gerenciar a persistência de cidades.
 * @author gilmar
 *
 */
public interface CidadeRepository {
	/**
	 * Operação definida para incluir uma cidade no repositório.
	 * @param cidade
	 * @return boolean
	 * @throws CidadeCadastradaException
	 */
	boolean incluir(Cidade cidade) throws CidadeCadastradaException;
	/**
	 * Operação definida para remover o cadastro de uma cidade do repositório.
	 * @param cidadeId
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean remover(Long cidadeId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas em uma cidade.
	 * @param cidade
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Cidade cidade) throws EscolaException;
	/**
	 * Operação definida para consultar uma cidade, a partir do seu nome.
	 * @param nomeCidade
	 * @return {@link Cidade}
	 * @throws CidadeNaoEncontradaException
	 */
	Cidade consultar(String nomeCidade) throws CidadeNaoEncontradaException;
	/**
	 * Operação definida para carregar os dados de uma cidade, a partir do seu identificador.
	 * @param cidadeId
	 * @return {@link Cidade}
	 * @throws CidadeNaoEncontradaException
	 */
	Cidade carregar(Long cidadeId) throws CidadeNaoEncontradaException;
	/**
	 * Operação definida para listar as cidades cadastradas.
	 * @return List<Cidade>
	 * @throws NenhumaCidadeEncontradaException
	 */
	List<Cidade> listaTodas() throws NenhumaCidadeEncontradaException;
}
