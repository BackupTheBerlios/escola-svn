/*
 * UsuarioNaoEncontradoException.java
 *
 * Created on 23 de Julho de 2007, 22:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.modelo;

/**
 * Exception usada quando um Usuario nao e encontrado
 * @author pmelo
 */
public class UsuarioNaoEncontradoException extends Exception {
    
    /** Creates a new instance of UsuarioNaoEncontradoException */
    public UsuarioNaoEncontradoException() {
        super("Usuario não encontrado!");
    }    
}