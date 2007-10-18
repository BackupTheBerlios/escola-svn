package br.ufg.inf.apsi.escola.ie.acegi;

import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;

public class AutenticadorUsuario implements UserDetailsService {
	/**
	 * Referencia a implementacao da classe de servico do componente Usuario
	 */
	private UsuarioService usuarioService = null;

	// private AutorizacaoService autorizacaoService = null;
	/**
	 * Cria uma nova instancia de AutenticadorUsuario
	 * 
	 * @param usuarioService
	 *            Referencia para implementacao da classe de servico do
	 *            componente Usuario
	 * @param 
	 */
	public AutenticadorUsuario(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		// this.autorizacaoService = autorizacaoService;
	}

	/**
	 * Busca usuario pelo nome
	 * 
	 * @param username
	 *            Username do usuario
	 * @return Instancia de UserDetails, referencia para um MyUserDetails
	 * @throws org.acegisecurity.userdetails.UsernameNotFoundException
	 *             Quando nenhum usuario e encontrado com o nome passado
	 * @throws org.springframework.dao.DataAccessException
	 *             Na occorencia de qualquer outra excecao
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		Long uid = null;
		String nomePessoa = null;
		String nomeUsuario = null;
		String validade = null;
		Boolean disponibilidade = null;
		String senha = null;

		UserDetails userDetails = null;
		GrantedAuthorityImpl[] grantedAuthoritiesImpl = null;
		List<String> autorizacoes = new ArrayList<String>();
		Object[] vetorDadosUsuario;
		
		autorizacoes.add("DOCENTE");
		autorizacoes.add("SECRETARIO");
		autorizacoes.add("ALUNO");

		try {
			vetorDadosUsuario = usuarioService.consultaUsuario(username);
		} catch (UsuarioException e) {
			throw new DataAccessResourceFailureException(e.getMessage(), e);
		}
		
		uid = (Long) vetorDadosUsuario[0];
		nomeUsuario = (String) vetorDadosUsuario[1];
		senha = (String) vetorDadosUsuario[2];
		disponibilidade = (Boolean) vetorDadosUsuario[3]; 
		nomePessoa = (String) vetorDadosUsuario[4];
		validade = (String) vetorDadosUsuario[5];

		// autorizacoes =
		// autorizacaoService.buscarPorUsuario(usuario.getId());

		grantedAuthoritiesImpl = new GrantedAuthorityImpl[autorizacoes
				.size()];
		for (int i = 0; i < autorizacoes.size(); i++) {
			grantedAuthoritiesImpl[i] = new GrantedAuthorityImpl(
					autorizacoes.get(i));
		}

		userDetails = new MyUserDetails(grantedAuthoritiesImpl, senha,
				nomeUsuario, uid, nomePessoa, disponibilidade, validade);

		return userDetails;
	}
}
