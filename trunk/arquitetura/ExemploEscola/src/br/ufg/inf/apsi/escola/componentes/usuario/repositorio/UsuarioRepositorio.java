/*
 * UsuarioRepositorio.java
 *
 * Created on 23 de Julho de 2007, 21:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.repositorio;

import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;

/**
 * Interface para a classe de persistencia do componente Usuario
 * @author pmelo
 */
public interface UsuarioRepositorio {
    /**
     * Busca usuario pelo nome no repositrio
     * @param nome String contendo o nome do usuario
     * @return Instancia de Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException Quando o usuario nao e encontrado
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException Na ocorrencia de qualquer outra Excecao
     */
    public Usuario buscar(String nome) throws UsuarioNaoEncontradoException, UsuarioException;
}
