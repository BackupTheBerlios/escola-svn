package br.ufg.inf.apsi.escola.ie.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;

public class SpringEscolaServiceDelegate extends EscolaServiceDelegate {

	private static SpringEscolaServiceDelegate springEscolaServiceDelegate = null;

	private ApplicationContext factory = null;

	public SpringEscolaServiceDelegate() {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public Object obtemServico(String nomeServico) {
		return factory.getBean(nomeServico);
	}

	public synchronized static SpringEscolaServiceDelegate getInstancia() {
		if (springEscolaServiceDelegate == null) {
			springEscolaServiceDelegate = new SpringEscolaServiceDelegate();
		}

		return springEscolaServiceDelegate;
	}
}