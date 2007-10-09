/*
 * PessoaNaoEncontradaException.java
 *
 * Criado em 28 de Julho de 2007, 14:13
 *
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

/**
 * Exception usada quando uma Pessoa nao e encontrada
 * @author pmelo
 */
public class PessoaNaoEncontradaException extends Exception {
    
    /** Cria uma nova intancia de PessoaNaoEncontradaException */
    public PessoaNaoEncontradaException() {
        super("Pessoa não encontrada!");
    }    
}
