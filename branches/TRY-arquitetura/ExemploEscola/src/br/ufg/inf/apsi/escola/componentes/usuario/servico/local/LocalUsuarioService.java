/*
 * UsuarioServicoLocal.java
 *
 * Created on 23 de Julho de 2007, 21:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.servico.local;

import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.usuario.negocio.UsuarioNegocio;
import br.ufg.inf.apsi.escola.componentes.usuario.servico.UsuarioService;

/**
 * implementacao Local da classe de servico do componente Usuario
 * @author pmelo
 */
public class LocalUsuarioService implements UsuarioService {
    /**
     * Referencia implementacao da classe de negocio do componente Usuario
     */
    private UsuarioNegocio usuarioNegocio = null;
    
    /**
     * Cria uma nova instancia de UsuarioServicoLocal
     * @param usuarioNegocio Referencia para implementacao UsuarioNegocio
     */
    public LocalUsuarioService(UsuarioNegocio usuarioNegocio) {
        this.usuarioNegocio = usuarioNegocio;
    }
    
    /**
     * Busca Usuario pelo nome
     * @param nome String contando o nome do Usuario
     * @return Instancia de Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException Quando o usuario nao encontrado.
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException Na ocorrencia de qualquer outra excecao
     */
    public Usuario buscar(String nome) throws UsuarioNaoEncontradoException, UsuarioException {
        return usuarioNegocio.buscar(nome);
    }
}