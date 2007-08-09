/*
 * ServiceFactory.java
 *
 * Created on 27 de Junho de 2007, 09:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.servicos;

import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import br.ufg.inf.apsi.escola.componentes.usuario.servico.UsuarioService;

/**
 *
 * @author agaphbm
 */
public interface ServiceFactory {
    /**
     * Metodo para obter referencia para implementecao local de PessoaService
     * @return Instancia de implementacao de PessoaService
     */
    PessoaService obtemPessoaService();

    /**
     * Metodo para obter referencia para implementecao local de UsuarioService
     * @return Instancia de implementacao de UsuarioService
     */
    UsuarioService obtemUsuarioService();
}