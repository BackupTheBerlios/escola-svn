/*
 * HibernateAutorizacaoRepositorio.java
 *
 * Created on 23 de Julho de 2007, 21:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.repositorio.jpa.hibernate;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import br.ufg.inf.apsi.escola.componentes.autorizacao.repositorio.AutorizacaoRepositorio;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * Implementacao em JPA(Hibernate) para a classe de persistencia do componente Autorizacao
 *
 * @author pmelo
 */
public class HibernateAutorizacaoRepositorio extends JpaDaoSupport implements AutorizacaoRepositorio {
    
    /**
     * Creates a new instance of HibernateAutorizacaoRepositorio
     */
    public HibernateAutorizacaoRepositorio() {
    }
    
    /**
     * Busca todas as autorizacoes de um Usuario
     * @param idUsuario Inteiro longo contendo o id do Usuario
     * @return Lista de Autorizacoes do Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada Caso nenhuma Autorizacao for encontrada para o usuario
     * @throws br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException Na ocorrencia de qualquer outra Excecao
     */
    public List<Autorizacao> buscarPorUsuario(long idUsuario) throws NenhumaAutorizacaoEncontrada, AutorizacaoException {
        //TODO Alterar forma da Query
        List<Autorizacao> autorizacoes = (List<Autorizacao>)getJpaTemplate().find("SELECT a FROM " + Autorizacao.class.getSimpleName() + " a WHERE a.usuario.id = ?1", idUsuario);
        
        if(autorizacoes.isEmpty()) {
            throw new NenhumaAutorizacaoEncontrada();
        }
        
        return autorizacoes;
    }
}