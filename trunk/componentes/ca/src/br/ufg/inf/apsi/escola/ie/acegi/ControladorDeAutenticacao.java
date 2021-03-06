package br.ufg.inf.apsi.escola.ie.acegi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.WebAuthenticationDetails;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;

/**
 * Classe para autenticacao do Usuario
 * 
 * @author leandro
 */
public final class ControladorDeAutenticacao {
	/**
	 * Gerenciador de autenticacoes do ACEGI. Injetado pelo Spring
	 */
	private AuthenticationManager authenticationManager;

	/**
	 * Autentica o usuario através de suas credenciais
	 * 
	 * @param request
	 *            Instancia de HttpServletRequest contendo o request HTTP.
	 * @param usuario
	 *            String contendo o usuario.
	 * @param senha
	 *            String contendo a senha do usuario.
	 * @return String de resultado para redirecionamento.
	 * 
	 */
	public void autenticar(HttpServletRequest request, String usuario,
			String senha) throws Exception {
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
				usuario, senha);

		HttpSession session = request.getSession();
		session
				.setAttribute(
						AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY,
						usuario);

		authReq.setDetails(new WebAuthenticationDetails(request));

		/*
		 * Faz a autenticacao
		 */
		Authentication auth = getAuthenticationManager().authenticate(authReq);

		/*
		 * Inicializa o contexto de seguranca
		 */
		SecurityContext secCtx = SecurityContextHolder.getContext();
		secCtx.setAuthentication(auth);
		session.setAttribute(
				HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY,
				secCtx);
	}

	/**
	 * Efetua logoff na aplicação
	 * 
	 * @param request
	 *            Objeto HttpServletRequest
	 * 
	 */
	public void logout(HttpServletRequest request) {
		request.getSession(false).removeAttribute(
				HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY);

		SecurityContextHolder.clearContext();

		request.getSession(false).invalidate();
	}

	/**
	 * Atribui o gerenciador de autenticacoes do ACEGI. Injetado pelo Spring.
	 * 
	 * @param authenticationManager
	 *            Uma instancia de AuthenticationManager.
	 * 
	 */
	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * Retorna o gerenciador de autenticacoes do ACEGI.
	 * 
	 * @return Uma instancia de AuthenticationManager.
	 * 
	 */
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}
}
