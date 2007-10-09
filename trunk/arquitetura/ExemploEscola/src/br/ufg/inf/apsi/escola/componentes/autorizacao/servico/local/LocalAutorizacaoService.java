/*
 * AutorizacaoServicoLocal.java
 *
 * Created on 23 de Julho de 2007, 21:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.componentes.autorizacao.servico.local;

import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.Autorizacao;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException;
import br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada;
import br.ufg.inf.apsi.escola.componentes.autorizacao.negocio.AutorizacaoNegocio;
import br.ufg.inf.apsi.escola.componentes.autorizacao.servico.AutorizacaoService;
import java.util.List;

/**
 * Implementacao local da interface de servico do componente Autorizacao
 * @author pmelo
 */
public class LocalAutorizacaoService implements AutorizacaoService {
    /**
     * Referencia a implementacao de AutorizacaoNegocio usada no componente
     */
    private AutorizacaoNegocio autorizacaoNegocio = null;
    
    /**
     * Creates a new instance of AutorizacaoServicoLocal
     * @param autorizacaoNegocio Implementacao de AutorizacaoNegocio usada no componente
     */
    public LocalAutorizacaoService(AutorizacaoNegocio autorizacaoNegocio) {
        this.autorizacaoNegocio = autorizacaoNegocio;
    }
    
    /**
     * Busca todas as autorizacoes de um Usuario
     * @param idUsuario Inteiro longo contendo o id do Usuario
     * @return Lista de Autorizacoes do Usuario
     * @throws br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.NenhumaAutorizacaoEncontrada Caso nenhuma Autorizacao for encontrada para o usuario
     * @throws br.ufg.inf.apsi.escola.componentes.autorizacao.modelo.AutorizacaoException Na ocorrencia de qualquer outra Excecao
     */
    public List<Autorizacao> buscarPorUsuario(long idUsuario) throws NenhumaAutorizacaoEncontrada, AutorizacaoException {
        return autorizacaoNegocio.buscarPorUsuario(idUsuario);
    }
}