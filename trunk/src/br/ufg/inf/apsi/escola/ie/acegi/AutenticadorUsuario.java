package br.ufg.inf.apsi.escola.ie.acegi;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

	/**
	 * Referencia a implementacao da classe de servico do componente Autorizacao
	 */
	// private AutorizacaoService autorizacaoService = null;
	/**
	 * Cria uma nova instancia de AutenticadorUsuario
	 * 
	 * @param usuarioService
	 *            Referencia para implementacao da classe de servico do
	 *            componente Usuario
	 * @param autorizacaoService
	 *            Referencia para implementacao da classe de servico do
	 *            componente Autorizacao
	 */
	public AutenticadorUsuario(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		// this.autorizacaoService = autorizacaoService;
	}

	/**
	 * Busca usuario pelo nome
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @return Instancia de UserDetails, neste caso Usuario autenticado
	 * @throws org.acegisecurity.userdetails.UsernameNotFoundException
	 *             Quando nenhum usuario e encontrado com o nome passado
	 * @throws org.springframework.dao.DataAccessException
	 *             Na occorencia de qualquer outra excecao
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// Usuario usuario = null;
		String dadosUsuario = null;
		Long uid;
		//String idPessoa;
		String nomeUsuario;
		//String validade;
		Boolean disponibilidade;
		String senha;

		UserDetails userDetails = null;
		GrantedAuthorityImpl[] grantedAuthoritiesImpl = null;
		List<String> autorizacoes = new ArrayList<String>();
		autorizacoes.add("DOCENTE");
		autorizacoes.add("SECRETARIO");
		autorizacoes.add("ALUNO");
		int i = 0;

		try {
			dadosUsuario = usuarioService.consultaUsuario(username);
			
			StringTokenizer tokens = new StringTokenizer(dadosUsuario);
			
			uid = Long.parseLong(String.valueOf(tokens.nextToken()));
			nomeUsuario = String.valueOf(tokens.nextToken());
			senha = String.valueOf(tokens.nextToken());
			disponibilidade = Boolean.parseBoolean(String.valueOf(tokens.nextToken()));
			//validade = String.valueOf(dadosUsuario.charAt(4));
			//idPessoa = String.valueOf(dadosUsuario.charAt(5));
			
			// autorizacoes =
			// autorizacaoService.buscarPorUsuario(usuario.getId());

			grantedAuthoritiesImpl = new GrantedAuthorityImpl[autorizacoes
					.size()];
			for (i = 0;i < autorizacoes.size();i++) {
				grantedAuthoritiesImpl[i] = new GrantedAuthorityImpl(
						autorizacoes.get(i));
			}
		} catch (UsuarioException e) {
			throw new DataAccessResourceFailureException(e.getMessage(), e);
		}

		userDetails = new UsuarioAutenticado(uid, null, nomeUsuario, senha,
				disponibilidade, true, true, true, grantedAuthoritiesImpl);

		return userDetails;
	}
}
