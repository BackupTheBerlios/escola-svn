package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumTelefoneEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TelefoneNaoEncontradoException;

/**
 * interface definida para gerenciar a peristência de telefones.
 * @author gilmar
 *
 */
public interface TelefoneRepository {
	/**
	 * Operação definida para incluir um novo cadastro de telefone no repositório.
	 * @param telefone
	 * @return boolean
	 * @throws TelefoneCadastradoException
	 */
	boolean incluir(Telefone telefone) throws TelefoneCadastradoException;
	/**
	 * Operação definida para remover um cadastro de telefone do repositório.
	 * @param telefoneId
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean remover(Long telefoneId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro do telefone.
	 * @param telefone
	 * @return boolean
	 * @throws EscolaException
	 */
	boolean salvar(Telefone telefone) throws EscolaException;
	/**
	 * Operação definida para consultar um telefone, a partir do seu número.
	 * @param numeroTelefone
	 * @return Telefone
	 * @throws TelefoneNaoEncontradoException
	 */
	Telefone consultar(long numeroTelefone)throws TelefoneNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um telefone, a partir do seu identificador.
	 * @param telefoneId
	 * @return Telefone
	 * @throws TelefoneNaoEncontradoException
	 */
	Telefone carregar(Long telefoneId) throws TelefoneNaoEncontradoException;
	/**
	 * Operação definida para listar todos os telefones cadastrados.
	 * @return List<Telefone>
	 * @throws NenhumTelefoneEncontradoException
	 */
	List<Telefone> listaTodos() throws NenhumTelefoneEncontradoException;
}
