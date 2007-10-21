package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EstadoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEstadoEncontradoException;


/**
 * Interface definida para gerenciar a persistência de estados.
 * @author gilmar
 *
 */
public interface EstadoRepository {
	/**
	 * Operação definida para incluir o cadastro de um novo estado no repositório.
	 * @param estado
	 * @return boolean
	 * @throws EstadoCadastradoException
	 */
	boolean incluir(Estado estado) throws EstadoCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um estado do repositório.
	 * @param estadoId
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean remover(Long estadoId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um estado.
	 * @param estado
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Estado estado) throws EscolaException;
	/**
	 * Operação definida para consultar os dados de um estado, a partir do seu nome.
	 * @param nomeEstado
	 * @return Estado
	 * @throws EstadoNaoEncontradoException
	 */
	Estado consultar(String nomeEstado) throws EstadoNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um estado, a partir do seu identificador.
	 * @param estadoId
	 * @return Estado
	 * @throws EstadoNaoEncontradoException
	 */
	Estado carregar(Long estadoId) throws EstadoNaoEncontradoException;
	/**
	 * Operação definida para listar todos os estados cadastrados.
	 * @return List<Estado>
	 * @throws NenhumEstadoEncontradoException
	 */
	List<Estado> listaTodos() throws NenhumEstadoEncontradoException;
}
