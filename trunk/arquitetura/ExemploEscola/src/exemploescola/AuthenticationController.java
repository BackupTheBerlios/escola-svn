/*
 * AuthenticationController.java
 *
 * Created on 26 de Julho de 2007, 17:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package exemploescola;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
 * Classe para autenticacao do usuario junto ao controlador do JSF
 * @author paulo
 */
public final class AuthenticationController {
    /**
     * Gerenciador de autenticacoes do ACEGI. Injetado pelo Spring
     */
    private AuthenticationManager authenticationManager;
    
    /**
     * Autentica usuario
     * @param usuario Strinf contendo o usuario
     * @param senha String contendo a senha do usuario
     * @return String de resultado para redirecionamento
     */
    public String autenticar(String usuario, String senha) {
        String outcome = "acessoNegado";
        
        try {
            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(usuario, senha);
            
            HttpServletRequest request = getRequest();
            authReq.setDetails(new WebAuthenticationDetails(request));
            
            HttpSession session = request.getSession();
            session.setAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY, usuario);
            
          /*
           * Faz a autenticacao
           */
            Authentication auth = getAuthenticationManager().authenticate(authReq);
            
           /*
            * Inicializa o contexto de segurança
            */
            SecurityContext secCtx = SecurityContextHolder.getContext();
            secCtx.setAuthentication( auth );
            session.setAttribute( HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY, secCtx);
            
            outcome = "sucesso";
        } catch ( Exception e ) {
            outcome = "acessoNegado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
        }
        
        return outcome;
    }
    
    /**
     * Obtem o request HTTP
     * @return O HttpServletRequest corrente
     */
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
    
    /**
     * Retorna o gerenciador de autenticacoes do ACEGI. Injetado pelo Spring
     * @return Uma instancia de AuthenticationManager
     */
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }
    
    /**
     * Atribui o gerenciador de autenticacoes do ACEGI. Injetado pelo Spring
     * @param authenticationManager Uma instancia de AuthenticationManager
     */
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}