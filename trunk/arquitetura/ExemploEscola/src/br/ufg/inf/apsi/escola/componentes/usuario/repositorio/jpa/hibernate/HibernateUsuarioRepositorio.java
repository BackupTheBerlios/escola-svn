/*
 * HibernateUsuarioRepositorio.java
 *
 * Created on 23 de Julho de 2007, 21:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.usuario.repositorio.jpa.hibernate;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.usuario.repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;

//org.acegisecurity.providers.dao.

/**
 * Implementacao JPA(Hibernate) da classe de persistencia do componente Usuario
 * @author pmelo
 */
public class HibernateUsuarioRepositorio extends JpaDaoSupport implements UsuarioRepositorio {
    
    /** Creates a new instance of HibernateUsuarioRepositorio */
    public HibernateUsuarioRepositorio() {
    }
    
    /**
     * Busca usuario pelo nome no repositrio
     * @param nome String contendo o nome do usuario
     * @return Instancia de Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException Quando o usuario nao e encontrado
     * @throws br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException Na ocorrencia de qualquer outra Excecao
     */
    public Usuario buscar(String nome) throws UsuarioNaoEncontradoException, UsuarioException {
        List usuarios = getJpaTemplate().find( "SELECT p FROM " + Usuario.class.getSimpleName() + " p WHERE p.usuario = ?1", nome);
        
        if(usuarios.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        
        return (Usuario) usuarios.get(0);
    }
}