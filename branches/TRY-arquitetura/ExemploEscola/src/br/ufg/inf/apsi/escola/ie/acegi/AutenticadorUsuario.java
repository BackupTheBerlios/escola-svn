/*
 * AutenticadorUsuario.java
 *
 * Created on 23 de Julho de 2007, 22:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.ie.acegi;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import br.ufg.inf.apsi.escola.componentes.autorizacao.servico.AutorizacaoService;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.usuario.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.usuario.servico.UsuarioService;
import java.util.List;

import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

/**
 * Classe implementacao de UserDetailsService
 * @author pmelo
 */
public class AutenticadorUsuario implements UserDetailsService {
    /**
     * Referencia a implementacao da classe de servico do componente Usuario
     */
    private UsuarioService usuarioService = null;
    /**
     * Referencia a implementacao da classe de servico do componente Autorizacao
     */
    private AutorizacaoService autorizacaoService = null;
    
     
    /**
     * Cria uma nova instancia de AutenticadorUsuario
     * @param usuarioService Referencia para implementacao da classe de servico do componente Usuario
     * @param autorizacaoService Referencia para implementacao da classe de servico do componente Autorizacao
     */
    public AutenticadorUsuario(UsuarioService usuarioService, AutorizacaoService autorizacaoService) {
        this.usuarioService = usuarioService;
        this.autorizacaoService = autorizacaoService;        
    }
    
    /**
     * Busca usuario pelo nome
     * @param nome Nome do usuario
     * @return Instancia de UserDetails, neste caso Usuario autenticado
     * @throws org.acegisecurity.userdetails.UsernameNotFoundException Quando nenhum usuario e encontrado com o nome passado
     * @throws org.springframework.dao.DataAccessException Na occorencia de qualquer outra excecao
     */
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException, DataAccessException {
        int i = 0;
        Usuario usuario = null;
        
        UserDetails userDetails = null;
        GrantedAuthorityImpl[] grantedAuthoritiesImpl = null;
        List<Autorizacao> autorizacoes = null;        
        
        try {
            //Busca o usuario pelo nome
            usuario = usuarioService.buscar(nome);
            
            //Busca todas as Autorizacoes do usuario
            autorizacoes = autorizacaoService.buscarPorUsuario(usuario.getId());
            
            grantedAuthoritiesImpl = new GrantedAuthorityImpl[autorizacoes.size()];
            //Cria um vetor com todos os nomes das Autorizacoes do usuario
            for(Autorizacao autorizacao : autorizacoes) {
                grantedAuthoritiesImpl[i] = new GrantedAuthorityImpl(autorizacao.getNome());
                
                i++;
            }
        } catch(UsuarioException e){
            throw new DataAccessResourceFailureException(e.getMessage(), e);
        } catch(UsuarioNaoEncontradoException e){
            throw new UsernameNotFoundException(e.getMessage(), e);
        } catch(NenhumaAutorizacaoEncontrada e){
            throw new DataAccessResourceFailureException(e.getMessage(), e);
        } catch(AutorizacaoException e){
            throw new DataAccessResourceFailureException(e.getMessage(), e);
        }
        
        userDetails = new UsuarioAutenticado(usuario.getId(),
                null,
                usuario.getUsuario(),
                usuario.getSenha(),
                true, true, true, true,
                grantedAuthoritiesImpl);
        
        return userDetails;
    }
}