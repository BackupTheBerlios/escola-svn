package br.ufg.inf.apsi.escola.servicos.local;

import br.ufg.inf.apsi.escola.componentes.relatorios.servico.RelatorioService;
import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;

public class LocalServiceFactory implements ServiceFactory {

	/**
	 * Referencia uma implementacao de EscolaServiceDelegate
	 */
	private EscolaServiceDelegate escolaServiceDelegate = null;

	/** Creates a new instance of LocalServiceFactory */
	public LocalServiceFactory() {
		escolaServiceDelegate = EscolaServiceDelegate.getInstancia();
	}

	public RelatorioService obterRelatorioService() {
		return (RelatorioService)escolaServiceDelegate.obtemServico("localRelatorioService");
	}

}
