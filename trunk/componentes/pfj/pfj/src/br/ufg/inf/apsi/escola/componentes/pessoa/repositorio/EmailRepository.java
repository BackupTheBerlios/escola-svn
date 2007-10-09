package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Email;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailCadastradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EmailNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.NenhumEmailEncontradoException;

/**
 * Interface definida para gerenciar a persistência de emails.
 * @author gilmar
 *
 */
public interface EmailRepository {
	/**
	 * Operação definida para incluir um novo email no repositório.
	 * @param e
	 * @return
	 * @throws EmailCadastradoException
	 */
	boolean incluir(Email e) throws EmailCadastradoException;
	/**
	 * Operação definida para remover o cadastro de email do repositório.
	 * @param email
	 * @return
	 * @throws EscolaException
	 */
	boolean remover(String email) throws EscolaException;
	/**
	 * Operação definida para salvar as operações efetuadas no cadastro de um email.
	 * @param e
	 * @return
	 * @throws EscolaException
	 */
	boolean salvar(Email e) throws EscolaException;
	/**
	 * Operação definida para consultar um email.
	 * @param email
	 * @return
	 * @throws EmailNaoEncontradoException
	 */
	Email consultar(String email) throws EmailNaoEncontradoException;
	/**
	 * Operação definida para carregar os dados de um email, a partir do seu identificador.
	 * @param emailId
	 * @return
	 * @throws EmailNaoEncontradoException
	 */
	Email carregar(Long emailId) throws EmailNaoEncontradoException;
	/**
	 * Operação definida para listar os emails cadastrados.
	 * @return
	 * @throws NenhumEmailEncontradoException
	 */
	List<Email> listaTodos() throws NenhumEmailEncontradoException;
}
