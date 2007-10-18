/*
 * AutorizacaoRepositorio.java
 *
 * Created on 23 de Julho de 2007, 21:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.repositorio;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import java.util.List;

/**
 * Inteface para classe de Persistencia do componente Autorizacao
 * @author pmelo
 */
public interface AutorizacaoRepositorio {
    /**
     * Busca todas as autorizacoes de um Usuario
     * @param idUsuario Inteiro longo contendo o id do Usuario
     * @return Lista de Autorizacoes do Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada Caso nenhuma Autorizacao for encontrada para o usuario
     * @throws br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException Na ocorrencia de qualquer outra Excecao
     */
    public List<Autorizacao> buscarPorUsuario(long idUsuario) throws NenhumaAutorizacaoEncontrada, AutorizacaoException;
}