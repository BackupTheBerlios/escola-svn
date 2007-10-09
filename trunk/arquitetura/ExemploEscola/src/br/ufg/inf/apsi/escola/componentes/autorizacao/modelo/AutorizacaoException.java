/*
 * AutorizacaoException.java
 *
 * Created on 26 de Julho de 2007, 11:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.modelo;

/**
 * Exception geral para uso no Componente Autorizacao
 * @author paulo
 */
public class AutorizacaoException extends Exception {
    
    /** Creates a new instance of AutorizacaoException */
    public AutorizacaoException(String mensagem) {
        super(mensagem);
    }    
}