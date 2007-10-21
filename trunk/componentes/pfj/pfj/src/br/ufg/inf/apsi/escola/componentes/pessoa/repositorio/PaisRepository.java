package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pais;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumPaisEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.PaisNaoEncontradoException;

/**
 * Interface definida para gerenciar a persistência de países.
 * @author gilmar
 *
 */

public interface PaisRepository {
	/**
	 * Operação definida para incluir um novo cadastro de país no repositório.
	 * @param pais
	 * @return boolean
	 * @throws PaisCadastradoException
	 */
	boolean incluir(Pais pais) throws PaisCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um país do repositório.
	 * @param paisId
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean remover(Long paisId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro de um país.
	 * @param pais
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Pais pais) throws EscolaException;
	/**
	 * Operação definida para consultar um país a partir do seu nome.
	 * @param nomePais
	 * @return Pais
	 * @throws PaisNaoEncontradoException
	 */
	Pais consultar(String nomePais) throws PaisNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um país a partir do seu identificador.
	 * @param paisId
	 * @return Pais
	 * @throws PaisNaoEncontradoException
	 */
	Pais carregar(Long paisId) throws PaisNaoEncontradoException;
	/**
	 * Operação definida para listar todos os países cadastrados.
	 * @return List<Pais>
	 * @throws NenhumPaisEncontradoException
	 */
	List<Pais> listaTodos() throws NenhumPaisEncontradoException; 
	
}
