package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaDefault;
import br.ufg.inf.apsi.escola.componentes.nf.servico.ConfiguracaoNotaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class ConfiguracaoNotaController {

	private ConfiguracaoNotaService configuracaoNotaService = null;

	private LocalServiceFactory localServiceFactory = null;

	public ConfiguracaoNotaController() {
		this.localServiceFactory = new LocalServiceFactory();
		this.configuracaoNotaService = this.localServiceFactory
				.obtemConfiguracaoNotaService();
	}
	
	 public void gravar() {
	        ConfiguracaoNota configuracaoNota = new ConfiguracaoNotaDefault();
	        
	        try {
	            configuracaoNotaService.salvar(configuracaoNota);
	        } catch(Exception e){
	            e.printStackTrace();
	        }
	    }

}
