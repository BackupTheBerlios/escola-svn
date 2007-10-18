package br.ufg.inf.apsi.escola.servicos.local;

import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;
import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;

public class LocalServiceFactory implements ServiceFactory {
    /**
     * Referencia uma implementacao de EscolaServiceDelegate
     */
    private EscolaServiceDelegate escolaServiceDelegate = null;
    
    /** Creates a new instance of LocalServiceFactory */
    public LocalServiceFactory() {
        escolaServiceDelegate = EscolaServiceDelegate.getInstancia();
    }
    
    /**
     * Metodo para obter referencia para implementecao local de PessoaService
     * @return Instancia de implementacao de PessoaService
     */
    public PessoaService obtemPessoaService() {
        return (PessoaService)escolaServiceDelegate.obtemServico("localPessoaService");
    }

    /**
     * Metodo para obter referencia para implementecao local de UsuarioService
     * @return Instancia de implementacao de UsuarioService
     */
    public UsuarioService obtemUsuarioService() {
        return (UsuarioService)escolaServiceDelegate.obtemServico("localUsuarioService");
    }
}
