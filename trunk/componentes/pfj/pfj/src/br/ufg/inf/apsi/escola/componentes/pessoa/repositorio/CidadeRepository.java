package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Cidade;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.CidadeCadastradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.CidadeNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumaCidadeEncontradaException;

/**
 * Interface definida para gerenciar a persistência de cidades.
 * @author gilmar
 *
 */
public interface CidadeRepository {
	/**
	 * Operação definida para incluir uma cidade no repositório.
	 * @param c
	 * @return
	 * @throws CidadeCadastradaException
	 */
	boolean incluir(Cidade c) throws CidadeCadastradaException;
	/**
	 * Operação definida para remover o cadastro de uma cidade do repositório.
	 * @param cidadeId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long cidadeId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas em uma cidade.
	 * @param c
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Cidade c) throws EscolaException;
	/**
	 * Operação definida para consultar uma cidade, a partir do seu nome.
	 * @param nome
	 * @return
	 * @throws CidadeNaoEncontradaException
	 */
	Cidade consultar(String nome) throws CidadeNaoEncontradaException;
	/**
	 * Operação definida para carregar os dados de uma cidade, a partir do seu identificador.
	 * @param cidadeId
	 * @return
	 * @throws CidadeNaoEncontradaException
	 */
	Cidade carregar(Long cidadeId) throws CidadeNaoEncontradaException;
	/**
	 * Operação definida para listar as cidades cadastradas.
	 * @return
	 * @throws NenhumaCidadeEncontradaException
	 */
	List<Cidade> listaTodas() throws NenhumaCidadeEncontradaException;
}
