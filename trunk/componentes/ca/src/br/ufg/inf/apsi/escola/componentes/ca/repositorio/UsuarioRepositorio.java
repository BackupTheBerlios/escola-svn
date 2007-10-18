package br.ufg.inf.apsi.escola.componentes.ca.repositorio;

import java.util.Calendar;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.NenhumUsuarioEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioNaoEncontradoException;

/**
 * Interface de acesso a camada de persistência do componente Controle de
 * Acesso.
 * 
 * @author leandro
 * 
 */
public interface UsuarioRepositorio {
	/**
	 * Operação definida para persistir um novo usuário no banco de dados.
	 * 
	 * @param usuario
	 *            Instancia de objeto do tipo Usuario
	 * @throws UsuarioException
	 *             Se houver erro na persistência do objeto
	 */
	public void incluirUsuario(Usuario usuario) throws UsuarioException;

	/**
	 * Operação definida para exluir um usuário existente no banco de dados.
	 * 
	 * @param username
	 *            Username do usuário
	 * @throws UsuarioNaoEncontradoException
	 *             Se não for encontrado um usuário com o username referido
	 * @throws UsuarioException
	 */
	public void excluirUsuario(String username)
			throws UsuarioNaoEncontradoException, UsuarioException;

	/**
	 * Operação definida para alterar as informações de um usuário existente no
	 * banco de dados
	 * 
	 * @param usuario
	 *            Instancia de objeto do tipo Usuario
	 * @throws UsuarioException
	 *             Se houver erro na persistência do objeto
	 */
	public void updateUsuario(Usuario usuario) throws UsuarioException;

	/**
	 * Operação definida para obter um objeto do tipo Usuario a partir de um
	 * username
	 * 
	 * @param username
	 *            Username do usuário
	 * @return Objeto do tipo Usuario
	 * @throws UsuarioNaoEncontradoException
	 *             Se não for encontrado um usuário com o username referido
	 * @throws UsuarioException
	 */
	public Usuario obterUsuario(String username)
			throws UsuarioNaoEncontradoException, UsuarioException;

	/**
	 * Operação definida para obter um objeto do tipo Usuario a partir de um id.
	 * 
	 * @param uid
	 *            Identificador único do objeto Usuário
	 * @return Objeto do tipo Usuario
	 * @throws UsuarioNaoEncontradoException
	 *             Se não for encontrado um usuário com o username referido
	 * @throws UsuarioException
	 */
	public Usuario obterUsuario(long uid) throws UsuarioNaoEncontradoException,
			UsuarioException;

	/**
	 * Operação definida para obter uma lista com todos os usuários existentes
	 * no banco de dados.
	 * 
	 * @return Lista contendo objetos do tipo Usuario
	 * @throws NenhumUsuarioEncontradoException
	 *             Se nenhum usuário for encontrado
	 * @throws UsuarioException
	 */
	public List<Usuario> buscarTodosUsuarios()
			throws NenhumUsuarioEncontradoException, UsuarioException;

	/**
	 * Operação definida para obter uma lista de usuários de acordo com a
	 * disponibilidade
	 * 
	 * @param disponibilidade
	 *            Define se a conta está disponível(true) ou indisponível(false)
	 * @return Lista contendo objetos do tipo Usuario
	 * @throws NenhumUsuarioEncontradoException
	 *             Se nenhum usuário for encontrado com o critério escolhido
	 * @throws UsuarioException
	 */
	public List<Usuario> buscarUsuariosPelaDisponibilidade(
			boolean disponibilidade) throws NenhumUsuarioEncontradoException,
			UsuarioException;

	/**
	 * Operação definida para obter uma lista de usuários de acordo com o
	 * período de validade da conta
	 * 
	 * @param dataValidade
	 *            Data para pesquisa
	 * @return Lista contendo objetos do tipo Usuario
	 * @throws NenhumUsuarioEncontradoException
	 *             Se nenhum usuário for encontrado
	 * @throws UsuarioException
	 */
	public List<Usuario> buscarUsuariosPelaValidade(Calendar dataValidade)
			throws NenhumUsuarioEncontradoException, UsuarioException;
}
