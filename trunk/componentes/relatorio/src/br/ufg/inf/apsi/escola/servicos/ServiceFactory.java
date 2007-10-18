package br.ufg.inf.apsi.escola.servicos;

import br.ufg.inf.apsi.escola.componentes.relatorios.servico.RelatorioService;

public interface ServiceFactory {

	RelatorioService obterRelatorioService();
	
}
