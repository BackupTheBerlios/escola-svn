/*
 * AutorizacaoNegocio.java
 *
 * Created on 23 de Julho de 2007, 21:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.negocio;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import java.util.List;

/**
 * Inteface para classe de Negócio do componente Autorizacao
 * @author pmelo
 */
public interface AutorizacaoNegocio {
    List<Autorizacao> buscarPorUsuario(long id) throws NenhumaAutorizacaoEncontrada, AutorizacaoException;
}