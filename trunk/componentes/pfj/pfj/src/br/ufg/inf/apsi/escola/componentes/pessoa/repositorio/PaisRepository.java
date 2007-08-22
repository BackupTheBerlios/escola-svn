package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumPaisEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.PaisCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.PaisNaoEncontradoException;

/**
 * Interface definida para gerenciar a persistência de países.
 * @author gilmar
 *
 */

public interface PaisRepository {
	/**
	 * Operação definida para incluir um novo cadastro de país no repositório.
	 * @param p
	 * @return
	 * @throws PaisCadastradoException
	 */
	boolean incluir(Pais p) throws PaisCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um país do repositório.
	 * @param paisId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long paisId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um país.
	 * @param p
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Pais p) throws EscolaException;
	/**
	 * Operação definida para consultar um país a partir do seu nome.
	 * @param nome
	 * @return
	 * @throws PaisNaoEncontradoException
	 */
	Pais consultar(String nome) throws PaisNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um país a partir do seu identificador.
	 * @param paisId
	 * @return
	 * @throws PaisNaoEncontradoException
	 */
	Pais carregar(Long paisId) throws PaisNaoEncontradoException;
	/**
	 * Operação definida para listar todos os países cadastrados.
	 * @return
	 * @throws NenhumPaisEncontradoException
	 */
	List<Pais> listaTodos() throws NenhumPaisEncontradoException; 
	
}
