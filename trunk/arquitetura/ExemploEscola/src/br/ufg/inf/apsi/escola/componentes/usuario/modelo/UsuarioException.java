/*
 * UsuarioException.java
 *
 * Created on 23 de Julho de 2007, 21:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.modelo;

/**
 * Excecao geral de uso no componente Usuario
 * @author pmelo
 */
public class UsuarioException extends Exception{
    
    /**
     * Cria uma nova instancia UsuarioException
     * @param mensagem Mensagem a ser atribuida
     */
    public UsuarioException(String mensagem) {
        super(mensagem);
    }    
}