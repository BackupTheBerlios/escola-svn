/*
 * NenhumaAutorizacaoEncontrada.java
 *
 * Created on 26 de Julho de 2007, 11:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.modelo;

/**
 * Exception usada quando nao se encontra nenhuma Autorizacao
 * @author paulo
 */
public class NenhumaAutorizacaoEncontrada extends Exception {
    
    /** Creates a new instance of NenhumaAutorizacaoEncontrada */
    public NenhumaAutorizacaoEncontrada() {
        super("Nenhuma autoriza��o encontrada!");
    }    
}