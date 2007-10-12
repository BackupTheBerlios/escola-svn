package br.ufg.inf.apsi.escola.ie;

import br.ufg.inf.apsi.escola.ie.spring.SpringEscolaServiceDelegate;

public abstract class EscolaServiceDelegate {
    /**
     * Metodo para obtemcao do Servico pelo nome
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
        return new SpringEscolaServiceDelegate();
    }
}