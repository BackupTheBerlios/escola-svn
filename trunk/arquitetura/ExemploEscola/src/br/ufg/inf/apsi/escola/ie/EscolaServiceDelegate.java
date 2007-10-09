/*
 * EscolaServiceDelegate.java
 *
 * Created on 27 de Junho de 2007, 16:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.ie;

import br.ufg.inf.apsi.escola.ie.spring.SpringEscolaServiceDelegate;

/**
 * Interface para o delegate de servico
 * @author agaphbm
 */
public abstract class EscolaServiceDelegate {
    /**
     * Metodo para obtencao do Servico pelo nome
     * @param nomeServico String contando o nome do servico
     * @return Instancia do objeto de servico
     */
    public abstract Object obtemServico(String nomeServico);
    
    /**
     * Retorna instancia da implementacao do delegate
     * @return 
     */
    public static EscolaServiceDelegate getInstancia() {
        //Poderia obter essa informação de um arquivo properties ou XML
        return SpringEscolaServiceDelegate.getInstancia();
    }
}