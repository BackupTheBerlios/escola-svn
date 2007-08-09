/*
 * NenhumaPessoaEncontradaException.java
 *
 * Criado em 28 de Julho de 2007, 14:12
 *
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

/**
 *
 * @author pmelo
 */
public class NenhumaPessoaEncontradaException extends Exception {
    
    /**
     * Cria uma nova intancia de NenhumaPessoaEncontradaException
     */
    public NenhumaPessoaEncontradaException() {
        super("Nenhuma pessoa encontrada!");
    }
}