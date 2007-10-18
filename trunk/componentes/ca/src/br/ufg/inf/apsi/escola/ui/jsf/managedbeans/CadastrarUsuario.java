package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CadastrarUsuario {
    private String username = null;
    
    private UsuarioService usuarioService = null;
    private LocalServiceFactory localServiceFactory = null;
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CadastrarUsuario() {
        localServiceFactory = new LocalServiceFactory();
        usuarioService = localServiceFactory.obtemUsuarioService();
    }
    
    public String voltar() {
        
        return "voltar";
    }
    
    public String gravar() {
        Usuario usuario = new Usuario();
        
        usuario.setUsername(username);
		//usuarioService.cadastrarUsuario(idPessoa, username, disponibilidade, validade);
        username = "";
        
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }        
}
