package br.ufg.inf.apsi.escola.componentes.ca.servico;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;

/**
 * Interface de acesso aos servicos do componente Controle de Acesso.
 * 
 * @author leandro
 * 
 */
public interface UsuarioService {
	/**
	 * 
	 * @param idPessoa
	 *            Identificador único de um objeto da Classe Pessoa
	 * @param username
	 *            Nome do usuário
	 * @param disponibilidade
	 *            Define se a conta está disponível(true) ou indisponível(false)
	 * @param validade
	 *            Período de validade da conta do usuário
	 * @throws UsuarioException
	 *             Se não for possível cadastrar o usuário
	 */
	void cadastrarUsuario(long idPessoa, String username,
			boolean disponibilidade, GregorianCalendar validade)
			throws UsuarioException;

	/**
	 * Operação definida para remover um usuário dado seu uid
	 * 
	 * @param uid
	 *            Identificador único de um objeto da Classe Usuario
	 * @throws UsuarioException
	 *             Se o identificador passado não corresponder a um usuário
	 *             cadastrado.
	 * 
	 */
	void removerUsuario(long uid) throws UsuarioException;

	/**
	 * Operacao definida para alterar a senha de um usuário. Deve-se passar o
	 * username, a senha atual e a nova senha pretendida.
	 * 
	 * @param username
	 *            Nome do usuário
	 * @param senhaAntiga
	 *            Senha antiga
	 * @param senhaNova
	 *            Nova senha
	 * @throws UsuarioException
	 *             Se o username passado não corresponder a um usuário
	 *             cadastrado.
	 * 
	 */
	void alterarSenha(String username, String senhaAntiga, String senhaNova)
			throws UsuarioException;

	/**
	 * Operação definida para alterar a disponibilidade da conta de um usuário.
	 * 
	 * @param uid
	 *            Identificador único de um objeto da Classe Usuario
	 * @param disponibilidade
	 *            Define se a conta está disponível(true) ou indisponível(false)
	 * @throws UsuarioException
	 *             Se o identificador passado não corresponder a um usuário
	 *             cadastrado.
	 * 
	 */
	void alterarDisponibilidade(long uid, boolean disponibilidade)
			throws UsuarioException;

	/**
	 * Operação definida para alterar o prazo de validade da conta de um
	 * usuário.
	 * 
	 * @param uid
	 *            Identificador único de um objeto da Classe Usuario
	 * @param validade
	 *            Período de validade da conta do usuário
	 * @throws UsuarioException
	 *             Se o identificador passado não corresponder a um usuário
	 *             cadastrado.
	 * 
	 */
	void alterarValidade(long uid, GregorianCalendar validade)
			throws UsuarioException;

	/**
	 * Operação definida para recuperar a senha de um usuário que a esqueceu. Um
	 * e-mail será enviado com a senha.
	 * 
	 * @param username
	 *            Nome do usuário
	 * @throws UsuarioException
	 *             Se o username passado não corresponder a um usuário
	 *             cadastrado.
	 */
	void recuperarSenha(String username) throws UsuarioException;

	/**
	 * Operação definida para checar se a conta do usuário está dentro do
	 * período de validade.
	 * 
	 * @param username
	 *            Nome do usuário
	 * @return True ou false
	 * @throws UsuarioException
	 *             Se o usuário não existir
	 */
	boolean checarValidade(String username) throws UsuarioException;

	/**
	 * Operação definida para checar se a conta do usuário está ou não
	 * disponível.
	 * 
	 * @param username
	 *            Nome do usuário
	 * @return True ou false
	 * @throws UsuarioException
	 *             Se o usuário não existir
	 */
	boolean checarUsuarioDisponivel(String username) throws UsuarioException;

	/**
	 * Operacao definida para listar usuários de acordo com a disponibilidade
	 * 
	 * @param disponibilidade
	 *            Define se a conta está disponível(true) ou indisponível(false)
	 * @return A lista de usuários resultante
	 * @throws UsuarioException
	 *             Se nehum usuário for encontrado de acordo com o critério de
	 *             pesquisa
	 * 
	 */
	List<String> listaUsuariosDisponibilidade(boolean disponibilidade)
			throws UsuarioException;

	/**
	 * Operacao definida para listar usuários de acordo com o período informado
	 * 
	 * @param dataValidade
	 *            Data para pesquisa
	 * @return A lista de usuários resultante
	 * @throws UsuarioException
	 *             Se nehum usuário for encontrado de acordo com o critério de
	 *             pesquisa
	 * 
	 */
	List<String> listaUsuariosValidade(Calendar dataValidade)
			throws UsuarioException;

	/**
	 * Operação definida para listar todos os usuários
	 * 
	 * @return A lista de usuários resultante
	 * @throws UsuarioException
	 *             Se nehum usuário for encontrado de acordo com o critério de
	 *             pesquisa
	 * 
	 */
	List<String> listaTodosUsuarios() throws UsuarioException;

	/**
	 * Operação definida para retornar os dados de um determinado usuário
	 * 
	 * @param username
	 *            Nome do usuário
	 * @return String com os dados do usuario
	 * @throws UsuarioException
	 *             Se o usuario referido não for encontrado
	 */
	String consultaUsuario(String username) throws UsuarioException;

}