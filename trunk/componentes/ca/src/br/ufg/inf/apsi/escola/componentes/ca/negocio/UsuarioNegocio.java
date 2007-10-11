package br.ufg.inf.apsi.escola.componentes.ca.negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;

public interface UsuarioNegocio {

	void cadastrarUsuario(long idPessoa, String username,
			boolean disponibilidade, GregorianCalendar validade)
			throws UsuarioException;

	void removerUsuario(long uid) throws UsuarioException;

	void alterarSenha(String username, String senhaAntiga, String senhaNova)
			throws UsuarioException;

	void alterarDisponibilidade(long uid, boolean disponibilidade)
			throws UsuarioException;

	void alterarValidade(long uid, GregorianCalendar validade)
			throws UsuarioException;

	void recuperarSenha(String username) throws UsuarioException;

	boolean checarValidade(String username) throws UsuarioException;

	boolean checarUsuarioDisponivel(String username) throws UsuarioException;

	List<String> listaUsuariosDisponibilidade(boolean disponibilidade)
			throws UsuarioException;

	List<String> listaUsuariosValidade(Calendar dataValidade)
			throws UsuarioException;

	List<String> listaTodosUsuarios() throws UsuarioException;

	String consultaUsuario(String username) throws UsuarioException;

}
