package br.ufg.inf.apsi.escola.servicos.local;

import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;

/**
 * Implemantacao da Interface <code>ServiceFactory</code>
 * 
 * @author Rodrigo Morian Loures
 */
public class LocalServiceFactory implements ServiceFactory {
	private EscolaServiceDelegate escolaServiceDelegate = null;

	public LocalServiceFactory() {
		escolaServiceDelegate = EscolaServiceDelegate.getInstancia();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufg.inf.apsi.escola.servicos.ServiceFactory#ObtemAvaliacaoDocenteService()
	 */
	@Override
	public AvaliacaoDocenteService ObtemAvaliacaoDocenteService() {
		return (AvaliacaoDocenteService) escolaServiceDelegate
				.obtemServico("avaliacaoDocenteService");
	}
}
