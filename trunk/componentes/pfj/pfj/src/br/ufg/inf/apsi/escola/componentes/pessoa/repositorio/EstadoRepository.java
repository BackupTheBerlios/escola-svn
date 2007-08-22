package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Estado;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EstadoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EstadoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumEstadoEncontradoException;


/**
 * Interface definida para gerenciar a persistência de estados.
 * @author gilmar
 *
 */
public interface EstadoRepository {
	/**
	 * Operação definida para incluir o cadastro de um novo estado no repositório.
	 * @param est
	 * @return
	 * @throws EstadoCadastradoException
	 */
	boolean incluir(Estado est) throws EstadoCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um estado do repositório.
	 * @param estadoId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long estadoId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um estado.
	 * @param e
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Estado e) throws EscolaException;
	/**
	 * Operação definida para consultar os dados de um estado, a partir do seu nome.
	 * @param nome
	 * @return
	 * @throws EstadoNaoEncontradoException
	 */
	Estado consultar(String nome) throws EstadoNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um estado, a partir do seu identificador.
	 * @param estadoId
	 * @return
	 * @throws EstadoNaoEncontradoException
	 */
	Estado carregar(Long estadoId) throws EstadoNaoEncontradoException;
	/**
	 * Operação definida para listar todos os estados cadastrados.
	 * @return
	 * @throws NenhumEstadoEncontradoException
	 */
	List<Estado> listaTodos() throws NenhumEstadoEncontradoException;
}
