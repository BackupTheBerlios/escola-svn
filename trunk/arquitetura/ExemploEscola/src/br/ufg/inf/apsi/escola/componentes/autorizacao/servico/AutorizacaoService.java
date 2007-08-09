/*
 * UsuarioServico.java
 *
 * Created on 23 de Julho de 2007, 21:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.servico;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import java.util.List;

/**
 *
 * @author pmelo
 */
public interface AutorizacaoService {
    List<Autorizacao> buscarPorUsuario(long id) throws NenhumaAutorizacaoEncontrada, AutorizacaoException;
}
