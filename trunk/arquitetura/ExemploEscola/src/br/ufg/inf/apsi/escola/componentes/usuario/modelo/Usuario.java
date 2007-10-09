/*
 * Usuario.java
 *
 * Created on 23 de Julho de 2007, 21:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.modelo;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe para armazenamento dos dados do Usuario
 * @author pmelo
 */
public class Usuario {
    /**
     * Inteiro longo para a indentitifacao do Usuario
     */
    private long id = 0;
    /**
     * String para o nome do usuario
     */
    private String usuario = null;
    /**
     * String para a senha do Usuario
     */
    private String senha = null;
    private List<Autorizacao> autorizacoes = null;
        
    /**
     * Cria uma nova instancia de usuario Usuario
     */
    public Usuario() {
    }
    
    /**
     * Retorna o nome do usuario
     * @return String contendo o nome do Usuario
     */
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * Atribui nome ao usuario
     * @param usuario String contendo o nome do usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Retorna a senha do usuario
     * @return String contando o nome do Usuario
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Atribui a senha ao Usuario
     * @param senha String contendo a senha do Usuario
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }
    
    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
    
    public void addAutorizacao(Autorizacao autorizacao) {
        if(autorizacoes == null) {
            autorizacoes = new LinkedList<Autorizacao>();
        }
        
        autorizacoes.add(autorizacao);
    }
    
    /**
     * Retorna o id do usuario
     * @return Inteiro longo contendoo id do Usuario
     */
    public long getId() {
        return id;
    }
    
    /**
     * Atribui o id ao Usuario
     * @param id Interi longo contendo o id do Usuario
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Repesentacao em String do Usuario
     * @return String contendo a representacao em String do Usuario
     */
    public String toString() {
        return usuario;
    }
}