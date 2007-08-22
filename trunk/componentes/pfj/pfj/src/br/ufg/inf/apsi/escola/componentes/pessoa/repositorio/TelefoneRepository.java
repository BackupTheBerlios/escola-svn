package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Telefone;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.NenhumTelefoneEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TelefoneCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.util.TelefoneNaoEncontradoException;

/**
 * interface definida para gerenciar a peristência de telefones.
 * @author gilmar
 *
 */
public interface TelefoneRepository {
	/**
	 * Operação definida para incluir um novo cadastro de telefone no repositório.
	 * @param t
	 * @return
	 * @throws TelefoneCadastradoException
	 */
	boolean incluir(Telefone t) throws TelefoneCadastradoException;
	/**
	 * Operação definida para remover um cadastro de telefone do repositório.
	 * @param telefoneId
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(Long telefoneId) throws EscolaException;
	/**
	 * Operação definida para salvar as alterações efetuadas no cadastro do telefone.
	 * @param t
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Telefone t) throws EscolaException;
	/**
	 * Operação definida para consultar um telefone, a partir do seu número.
	 * @param numero
	 * @return
	 * @throws TelefoneNaoEncontradoException
	 */
	Telefone consultar(long numero)throws TelefoneNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um telefone, a partir do seu identificador.
	 * @param telefoneId
	 * @return
	 * @throws TelefoneNaoEncontradoException
	 */
	Telefone carregar(Long telefoneId) throws TelefoneNaoEncontradoException;
	/**
	 * Operação definida para listar todos os telefones cadastrados.
	 * @return
	 * @throws NenhumTelefoneEncontradoException
	 */
	List<Telefone> listaTodos() throws NenhumTelefoneEncontradoException;
}
