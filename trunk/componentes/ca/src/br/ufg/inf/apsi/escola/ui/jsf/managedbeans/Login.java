package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.ie.acegi.ControladorDeAutenticacao;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Login {
    
    private String usuario = null;
    private String senha = null;
    private ControladorDeAutenticacao controladorDeAutenticacao = null;
        
    public Login() {
        controladorDeAutenticacao = (ControladorDeAutenticacao) EscolaServiceDelegate.getInstancia().obtemServico("controladorDeAutenticacao");
    }
    
    public String efetuarLogin() {
        String retorno = "acessoNegado";
        
        try {
            controladorDeAutenticacao.autenticar(getRequest(), getUsuario(), getSenha());
            
            retorno = "sucesso";
        } catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
        }
        
        return retorno;
    }
    
    public String recuperarSenha(){
    	return "recuperarSenha";
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Obtem o request HTTP
     * @return O HttpServletRequest corrente
     */
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
