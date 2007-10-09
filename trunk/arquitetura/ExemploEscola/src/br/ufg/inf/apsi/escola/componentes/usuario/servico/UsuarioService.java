/*
 * UsuarioServico.java
 *
 * Created on 23 de Julho de 2007, 21:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.servico;

import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;

/**
 * Interface para classe de servico do componente Usuario
 * @author pmelo
 */
public interface UsuarioService {
    /**
     * Busca Usuario pelo nome
     * @param nome String contando o nome do Usuario
     * @return Instancia de Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException Quando o usuario nao encontrado.
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException Na ocorrencia de qualquer outra excecao
     */
    public Usuario buscar(String nome) throws UsuarioNaoEncontradoException, UsuarioException;
}
