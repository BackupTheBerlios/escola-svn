package br.ufg.inf.apsi.escola.componentes.ca.repositorio;

import java.util.Calendar;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.NenhumUsuarioEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioNaoEncontradoException;


public interface UsuarioRepositorio {

	public void incluirUsuario(Usuario usuario) throws UsuarioException;

	public void excluirUsuario(long uid) throws UsuarioNaoEncontradoException,
			UsuarioException;

	public void updateUsuario(Usuario usuario) throws UsuarioException;

	public Usuario obterUsuario(String username)
			throws UsuarioNaoEncontradoException, UsuarioException;

	public Usuario obterUsuario(long uid) throws UsuarioNaoEncontradoException,
			UsuarioException;

	public List<Usuario> buscarTodosUsuarios()
			throws NenhumUsuarioEncontradoException, UsuarioException;

	public List<Usuario> buscarUsuariosPelaDisponibilidade(
			boolean disponibilidade) throws NenhumUsuarioEncontradoException,
			UsuarioException;

	public List<Usuario> buscarUsuariosPelaValidade(Calendar dataValidade)
			throws NenhumUsuarioEncontradoException, UsuarioException;
}
