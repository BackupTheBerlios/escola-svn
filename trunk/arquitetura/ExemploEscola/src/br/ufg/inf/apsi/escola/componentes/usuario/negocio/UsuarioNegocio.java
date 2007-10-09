/*
 * UsuarioNegocio.java
 *
 * Created on 23 de Julho de 2007, 21:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.negocio;

import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;

/**
 *
 * @author pmelo
 */
public interface UsuarioNegocio {
    /**
     * Busca Usuario pelo nome.
     * @param nome String contendo o nome do usuario
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException Quando o Usuario nao e encontrado.
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException Na ocorrencia de qualquer outra Excecao
     * @return Instancia de Usuario
     */
    public Usuario buscar(String nome) throws UsuarioNaoEncontradoException, UsuarioException;
}