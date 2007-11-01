package br.ufg.inf.apsi.escola.componentes.ca.repositorio.jpa.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.NenhumUsuarioEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.repositorio.UsuarioRepository;

/**
 * Classe que implementa a persistência dos objetos no banco de dados
 * 
 * @author leandro
 * 
 */
class UsuarioRepositoryImpl extends JpaDaoSupport implements
		UsuarioRepository {

	List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

	public void incluirUsuario(Usuario usuario) throws UsuarioException {
		getJpaTemplate().persist(usuario);
	}

	public void excluirUsuario(String username)
			throws UsuarioNaoEncontradoException, UsuarioException {
		Usuario u = obterUsuario(username);
		getJpaTemplate().remove(u);
	}

	public void updateUsuario(Usuario usuario) throws UsuarioException {
		getJpaTemplate().merge(usuario);
	}

	@SuppressWarnings("unchecked")
	public Usuario obterUsuario(String username)
			throws UsuarioNaoEncontradoException, UsuarioException {
		Usuario usuario = null;

		listaDeUsuarios = getJpaTemplate().find(
				"select u from Usuario u where u.username = ?1", username);
		if (!listaDeUsuarios.isEmpty())
			usuario = listaDeUsuarios.get(0);
		else
			throw new UsuarioNaoEncontradoException();

		return usuario;
	}

	public Usuario obterUsuario(long uid) throws UsuarioNaoEncontradoException,
			UsuarioException {

		Usuario usuario = (Usuario) getJpaTemplate().find(Usuario.class, uid);

		if (usuario == null) {
			throw new UsuarioNaoEncontradoException();
		}

		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodosUsuarios()
			throws NenhumUsuarioEncontradoException, UsuarioException {

		listaDeUsuarios = getJpaTemplate().find("from Usuario");

		if (listaDeUsuarios.isEmpty())
			throw new NenhumUsuarioEncontradoException();

		return listaDeUsuarios;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarUsuariosPelaDisponibilidade(
			boolean disponibilidade) throws NenhumUsuarioEncontradoException,
			UsuarioException {

		listaDeUsuarios = getJpaTemplate().find(
				"select u from Usuario u where u.disponibilidade = ?1",
				disponibilidade);

		if (listaDeUsuarios.isEmpty())
			throw new NenhumUsuarioEncontradoException();

		return listaDeUsuarios;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarUsuariosPelaValidade(Calendar dataValidade)
			throws NenhumUsuarioEncontradoException, UsuarioException {

		listaDeUsuarios = getJpaTemplate().find(
				"select u from Usuario u where u.validade = ?1", dataValidade);

		if (listaDeUsuarios.isEmpty())
			throw new NenhumUsuarioEncontradoException();

		return listaDeUsuarios;
	}

}