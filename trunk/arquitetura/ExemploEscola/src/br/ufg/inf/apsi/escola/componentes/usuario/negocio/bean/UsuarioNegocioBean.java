/*
 * UsuarioNegocioBean.java
 *
 * Created on 23 de Julho de 2007, 21:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.negocio.bean;

import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.usuario.negocio.UsuarioNegocio;
import br.ufg.inf.apsi.escola.componentes.usuario.repositorio.UsuarioRepositorio;

/**
 * Implementecao em Bean da classe de Negocio do componente Usuario
 * @author pmelo
 */
public class UsuarioNegocioBean implements UsuarioNegocio{
    
    /**
     * Referencia a implementacao da classe de persistencia do componente Usuario
     */
    private UsuarioRepositorio usuarioRepositorio = null;
    
    /**
     * Cria uma nova instancia de UsuarioNegocio
     * @param usuarioRepositorio Referencia para implementacao da classe de persistencia do componente Usuario
     */
    public UsuarioNegocioBean(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Busca Usuario pelo nome.
     * @param nome String contendo o nome do usuario
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException Quando o Usuario nao e encontrado.
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException Na ocorrencia de qualquer outra Excecao
     * @return Instancia de Usuario
     */
    public Usuario buscar(String nome) throws UsuarioNaoEncontradoException, UsuarioException {
        return usuarioRepositorio.buscar(nome);
    }
}
