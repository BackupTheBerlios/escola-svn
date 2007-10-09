/*
 * Autorizacao.java
 *
 * Created on 26 de Julho de 2007, 11:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.modelo;

import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;

/**
 * Classe que armazena Autorizacao de acesso de um usuário
 *
 * @author paulo
 */
public class Autorizacao {
    private long id = 0;
    private String nome = null;
    private Usuario usuario = null;
    
    /** Creates a new instance of Autorizacao */
    public Autorizacao() {
    }
    
    /**
     *  Obtém id da autorizacao
     * @return id da Autorizacao
     */
    public long getId() {
        return id;
    }
    
    /**
     * Atribui id a Autorizacao
     * @param id Intei
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Obtem nome da Autorizacao
     * @return Uma Strinf contendo o nome da Autorizacao
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Atribui nome a Autorizacao
     * @param nome String contendo o nome para a Autorizacao
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtem referencia do Usuario dono da Autorizacao
     *
     * @return Instancia de Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    
    /**
     * Atribui Usuario dono da Autorizacao
     * @param usuario Instancia de Usuario dono da Autorizacao
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}