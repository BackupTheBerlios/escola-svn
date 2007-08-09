/*
 * AutorizacaoNegocioBean.java
 *
 * Created on 23 de Julho de 2007, 21:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import br.ufg.inf.apsi.escola.componentes.autorizacao.negocio.AutorizacaoNegocio;
import br.ufg.inf.apsi.escola.componentes.autorizacao.repositorio.AutorizacaoRepositorio;
import java.util.List;

/**
 * Implementacao em Bean da Regra de Negócio do componente Autorizacao
 *
 * @author pmelo
 */
public class AutorizacaoNegocioBean implements AutorizacaoNegocio {
    
    private AutorizacaoRepositorio autorizacaoRepositorio = null;
    
    /** Cria uma nova intancia de UsuarioNegocio esperando uma implementacao de AutorizacaoRepositorio no contrutor */
    public AutorizacaoNegocioBean(AutorizacaoRepositorio autorizacaoRepositorio) {        
        this.autorizacaoRepositorio = autorizacaoRepositorio;
    }
    
    public List<Autorizacao> buscarPorUsuario(long id) throws NenhumaAutorizacaoEncontrada, AutorizacaoException {
        return autorizacaoRepositorio.buscarPorUsuario(id);
    }
}
