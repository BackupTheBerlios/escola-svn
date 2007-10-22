package br.ufg.inf.apsi.escola.ie.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;

/**
 * Implementacao Spring para o AvaliacaoDocenteServiceDelegate
 * 
 * @author Rodrigo Morian Loures
 */
public class SpringEscolaServiceDelegate extends
		EscolaServiceDelegate {
	private ApplicationContext factory = null;
	private static SpringEscolaServiceDelegate springEscolaServiceDelegate = null;

	private SpringEscolaServiceDelegate() {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.ie.AvaliacaoDocenteServiceDelegate#obtemServico(java.lang.String)
	 */
	@Override
	public Object obtemServico(String nomeServico) {
		// TODO Auto-generated method stub
		return factory.getBean(nomeServico);
	}

	public synchronized static SpringEscolaServiceDelegate getInstancia() {
		if (springEscolaServiceDelegate == null)
			springEscolaServiceDelegate = new SpringEscolaServiceDelegate();

		return springEscolaServiceDelegate;
	}
}
