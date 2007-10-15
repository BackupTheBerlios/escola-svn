package br.ufg.inf.apsi.escola.ie.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;

public class SpringEscolaServiceDelegate extends EscolaServiceDelegate {
    
    private ApplicationContext factory = null;
    
    /** Creates a new instance of SpringServiceDelegate */
    public SpringEscolaServiceDelegate() {
       factory = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    /**
     * Obtem servico do Spring
     * @param nomeServico String contendo o nome do servico
     * @return Instancia da classe de servico requisitada.
     */
    public Object obtemServico(String nomeServico) {        
        return factory.getBean(nomeServico);
    }
}
