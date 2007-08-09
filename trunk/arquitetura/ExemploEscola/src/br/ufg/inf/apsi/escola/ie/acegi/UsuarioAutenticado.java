/*
 * UsuarioAutenticado.java
 *
 * Created on 23 de Julho de 2007, 22:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.ie.acegi;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.User;

/**
 * Implementaca deUser
 * @author pmelo
 */
public class UsuarioAutenticado extends User{
    
    /**
     * Inteiro longo contendo o id Usuario
     */
    private long id;
    /**
     * String contendo o nome do Usuario
     */
    private String nome;
    
    /**
     * Cra uma nova instancia de UsuarioAutenticado
     * @param userId Inteiro contendo o id do Usuario
     * @param nome String contendo o nome do Usuario
     * @param username String contendo o nome do usuario
     * @param password String contendo o password do usuario
     * @param enabled Boolean informando se o usuario esta habilitado(true) ou nao(false)
     * @param accountNonExpired Boolean informando se a conta do usuario esta expirada ou nao
     * @param credentialsNonExpired Boolean informando se as credenciais do Usuario estao expiradas ou nao
     * @param accountNonLocked Boolean informando se a conta do Usuario nao esta bloqueada
     * @param authorities Vetor de GrantedAuthority do Usuario
     * @throws java.lang.IllegalArgumentException Na ocorrencia de algum parametro incorreto
     */
    public UsuarioAutenticado(long userId, String nome, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities) throws IllegalArgumentException {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = userId;
        this.nome = nome;
    }    
}