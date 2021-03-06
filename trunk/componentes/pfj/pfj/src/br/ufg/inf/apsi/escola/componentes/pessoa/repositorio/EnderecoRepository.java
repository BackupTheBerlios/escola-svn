package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Endereco;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EnderecoNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEnderecoEncontradoException;

/**
 * Interface definida para gerenciar a persistência de endereços.
 * @author gilmar
 *
 */
public interface EnderecoRepository {
	/**
	 * Operação definida para incluir o cadastro de um novo endereço no repositório.
	 * @param endereco
	 * @return boolean
	 * @throws EnderecoCadastradoException
	 */
	boolean incluir(Endereco endereco) throws EnderecoCadastradoException;
	/**
	 * Operação definida para remover o cadastro de um endereço do repositório.
	 * @param enderecoId
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean remover(Long enderecoId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações feitas no cadastro de um endereço.
	 * @param endereco
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Endereco endereco) throws EscolaException;
	/**
	 * Operação definida para consultar endereços, a partir do nome da rua.
	 * @param nomeRua
	 * @return List<Endereco>
	 * @throws NenhumEnderecoEncontradoException
	 */
	List<Endereco> consultarNomeRua(String nomeRua) throws NenhumEnderecoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um endereço a partir do seu id.
	 * @param enderecoId
	 * @return {@link Endereco}
	 * @throws EnderecoNaoEncontradoException
	 */
	Endereco carregar(Long enderecoId) throws EnderecoNaoEncontradoException;
	/**
	 * Operação definida para listar todos os endereços cadastrados.
	 * @return List<Endereco>
	 * @throws NenhumEnderecoEncontradoException
	 */
	List<Endereco> listaTodos() throws NenhumEnderecoEncontradoException;
	/**
	 * Operação definida para consultar endereços, a partir do cep.
	 * @param cep
	 * @return List<Endereco>
	 * @throws NenhumEnderecoEncontradoException
	 */
	List<Endereco> consultaCep(Integer cep) throws NenhumEnderecoEncontradoException;
	/**
	 * Operação definida para consultar um endereço, a partir do nome da rua, do número e do complemento.
	 * @param nomeRua
	 * @param complemento
	 * @param numero
	 * @return {@link Endereco}
	 * @throws EnderecoNaoEncontradoException
	 */
	Endereco consultarDiversos(String nomeRua, String complemento, String numero) throws EnderecoNaoEncontradoException;
}
