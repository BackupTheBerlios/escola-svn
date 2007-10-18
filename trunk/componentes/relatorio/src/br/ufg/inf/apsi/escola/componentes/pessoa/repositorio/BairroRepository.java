package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Bairro;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.BairroNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumBairroEncontradoException;


/**
 * Interface definida para gerenciar a persistência de bairros.
 * @author gilmar
 */

public interface BairroRepository {
	/**
	 * Operação definida para incluir um novo bairro no repositório.
	 * @param b
	 * @return
	 * @throws BairroCadastradoException
	 */
	boolean incluir(Bairro b) throws BairroCadastradoException;
	/**
	 * Operação definida para remover um bairro do repositório.
	 * @param bairroId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long bairroId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas em um bairro.
	 * @param b
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Bairro b) throws EscolaException;
	/**
	 * Operação definida para consultar um bairro, a partir de seu nome.
	 * @param nome
	 * @return
	 * @throws BairroNaoEncontradoException
	 */
	Bairro consultar(String nome) throws BairroNaoEncontradoException; 
	/**
	 * Operação definida para carregar os dados de um bairro, a partir do seu identificador.
	 * @param bairroId
	 * @return
	 * @throws BairroNaoEncontradoException
	 */
	Bairro carregar(Long bairroId) throws BairroNaoEncontradoException;
	/**
	 * Operação definida para listar os bairros cadastrados.
	 * @return
	 * @throws NenhumBairroEncontradoException
	 */
	List<Bairro> listaTodos() throws NenhumBairroEncontradoException;
}
