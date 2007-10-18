/*
 * PessoaException.java
 *
 * Criado em 27 de Junho de 2007, 08:45
 * 
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

/**
 * Excecao de uso geral no componente Pessoa
 * @author agaphbm
 */
public class PessoaException extends Exception {
    
    /**
     * Cria uma nova intancia de PessoaException
     * @param mensagem String contendo a mensagem a ser atribuida.
     */
    public PessoaException(String mensagem) {
        super(mensagem);
    }    
}