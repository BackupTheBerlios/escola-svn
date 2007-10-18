package br.ufg.inf.apsi.escola.componentes.ca.servico.local;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.negocio.UsuarioNegocio;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;

/**
 * Implementação local da classe de servico do componente Controle de Acesso
 * 
 * @author leandro
 * 
 */
class LocalUsuarioService implements UsuarioService {

	private UsuarioNegocio usuarioNegocio = null;

	public LocalUsuarioService(UsuarioNegocio usuarioNegocio) {
		this.usuarioNegocio = usuarioNegocio;
	}

	public void cadastrarUsuario(long idPessoa, String username,
			boolean disponibilidade, GregorianCalendar validade)
			throws UsuarioException {

		usuarioNegocio.cadastrarUsuario(idPessoa, username, disponibilidade,
				validade);
	}

	public void removerUsuario(String username) throws UsuarioException {

		usuarioNegocio.removerUsuario(username);
	}

	public void alterarSenha(String username, String senhaAntiga,
			String senhaNova) throws UsuarioException {

		usuarioNegocio.alterarSenha(username, senhaAntiga, senhaNova);
	}

	public void alterarDisponibilidade(String username, boolean disponibilidade)
			throws UsuarioException {

		usuarioNegocio.alterarDisponibilidade(username, disponibilidade);
	}

	public void alterarValidade(String username, GregorianCalendar validade)
			throws UsuarioException {

		usuarioNegocio.alterarValidade(username, validade);
	}

	public List<String> listaUsuariosDisponibilidade(boolean disponibilidade)
			throws UsuarioException {

		return usuarioNegocio.listaUsuariosDisponibilidade(disponibilidade);
	}

	public List<String> listaUsuariosValidade(Calendar dataValidade)
			throws UsuarioException {

		return usuarioNegocio.listaUsuariosValidade(dataValidade);
	}

	public List<String> listaTodosUsuarios() throws UsuarioException {

		return usuarioNegocio.listaTodosUsuarios();
	}

	public void recuperarSenha(String username) throws UsuarioException {

		usuarioNegocio.recuperarSenha(username);
	}

	public boolean checarUsuarioDisponivel(String username)
			throws UsuarioException {

		return usuarioNegocio.checarUsuarioDisponivel(username);
	}

	public boolean checarValidade(String username) throws UsuarioException {

		return usuarioNegocio.checarValidade(username);
	}

	public Object[] consultaUsuario(String username) throws UsuarioException {
		return usuarioNegocio.consultaUsuario(username);
	}

}
