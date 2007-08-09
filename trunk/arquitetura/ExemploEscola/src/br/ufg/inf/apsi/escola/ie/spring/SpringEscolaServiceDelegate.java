/*
 * SpringServiceDelegate.java
 *
 * Created on 27 de Junho de 2007, 16:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ufg.inf.apsi.escola.ie.spring;

import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Implementacao String para o EscolaServiceDelegate
 * @author agaphbm
 */
public class SpringEscolaServiceDelegate extends EscolaServiceDelegate {
    /**
     * Factory de Beans do Spring
     */    
    private ApplicationContext factory = null;
    
    /** Creates a new instance of SpringServiceDelegate */
    public SpringEscolaServiceDelegate() {
        //factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
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