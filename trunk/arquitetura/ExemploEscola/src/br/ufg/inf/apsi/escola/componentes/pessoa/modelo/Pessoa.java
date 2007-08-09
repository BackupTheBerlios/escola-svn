/*
 * Pessoa.java
 *
 * Created on 4 de Julho de 2007, 07:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

/**
 * Classe que armazena os dados de uma Pessoa
 * @author agaphbm
 */
public class Pessoa {
    
    /**
     * Creates a new instance of Pessoa
     */
    public Pessoa() {
    }
    
    /**
     * Cria uma nova intancia de Pessoa
     * @param id Inteiro longo contendo o id da Pessoa
     * @param nome String contendo o nome da Pessoa
     */
    public Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    /**
     * Cria uma nova intancia de Pessoa
     * @param nome String contendo o nome da Pessoa
     */
    public Pessoa(String nome) {
        this.nome = nome;
    }

    /**
     * Mantem o valor da propriedade id.
     */
    private long id;

    /**
     * "Getter" para a propriedade id.
     * @return Valor para a propriedade id.
     */
    public long getId() {
        return this.id;
    }

    /**
     * "Setter" para a propriedade id.
     * @param id Novo valor para a propriedade id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Mantem o valor da propriedade nome.
     */
    private String nome;

    /**
     * "Getter" para a propriedade nome.
     * @return Valor para a propriedade nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * "Setter" para a propriedade nome.
     * @param nome Novo valor para a propriedade nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }    
}