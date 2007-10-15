package br.ufg.inf.apsi.escola.componentes.nf.testes;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNota;
import br.ufg.inf.apsi.escola.componentes.nf.servico.local.LocalNotaFrequenciaService;
import junit.framework.TestCase;

public class ConfiguracaoNotaTest extends TestCase {

	public void testObtemPessoaService() {
		System.out.println("obtemNotaService");

		LocalNotaFrequenciaService instance = new LocalNotaFrequenciaService();

		ConfiguracaoNota result = instance
				.obterConfiguracaoNota(null);
		assertNotNull(result);

	}

}
