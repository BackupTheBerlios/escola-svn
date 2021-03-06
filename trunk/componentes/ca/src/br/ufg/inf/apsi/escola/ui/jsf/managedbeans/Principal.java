package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.ie.acegi.ControladorDeAutenticacao;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

public class Principal {
    private ControladorDeAutenticacao controladorDeAutenticacao = null;
    
    public Principal() {
        controladorDeAutenticacao = (ControladorDeAutenticacao) EscolaServiceDelegate.getInstancia().obtemServico("controladorDeAutenticacao");
    }
    
    /**
     * <p>Retornar uma referï¿½ncia para o Bean de dados limitados.</p>
     */
    public String cadastrarUsuario() {
        return "cadastrar";
    }
    
    public String alterarSenha() {
        return "alterarSenha";
    }
    
    public String listarUsuarios() {
        return "listar";
    }
    
    public String sair(ActionEvent e) {
        controladorDeAutenticacao.logout(getRequest());
        return "sair";
    }
    
    /**
     * Obtem o request HTTP
     * @return O HttpServletRequest corrente
     */
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
