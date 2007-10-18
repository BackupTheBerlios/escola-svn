package br.ufg.inf.apsi.escola.ie;

import br.ufg.inf.apsi.escola.ie.spring.SpringEscolaServiceDelegate;

public abstract class EscolaServiceDelegate {
   
    public abstract Object obtemServico(String nomeServico);
    
   
    public static EscolaServiceDelegate getInstancia() {
        
        return SpringEscolaServiceDelegate.getInstancia();
    }
}
