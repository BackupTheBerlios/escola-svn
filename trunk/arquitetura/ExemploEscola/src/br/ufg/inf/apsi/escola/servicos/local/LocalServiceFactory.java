/*
 * LocalServiceFactory.java
 *
 * Created on 27 de Junho de 2007, 12:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.servicos.local;

import br.ufg.inf.apsi.escola.componentes.usuario.servico.UsuarioService;
import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;

/**
 * Implementecao local da fabrica de servicos
 * @author agaphbm
 */
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