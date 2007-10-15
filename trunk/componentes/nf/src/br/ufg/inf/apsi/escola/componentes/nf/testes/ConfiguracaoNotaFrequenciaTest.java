package br.ufg.inf.apsi.escola.componentes.nf.testes;

import br.ufg.inf.apsi.escola.componentes.nf.modelo.ConfiguracaoNotaFrequencia;
import br.ufg.inf.apsi.escola.componentes.nf.servico.NotaFrequenciaService;
import br.ufg.inf.apsi.escola.componentes.nf.servico.local.LocalNotaFrequenciaService;
import junit.framework.TestCase;

public class ConfiguracaoNotaFrequenciaTest extends TestCase {

	public void testObtemPessoaService() {
		System.out.println("obtemNotaFrequenciaService");

		LocalNotaFrequenciaService instance = new LocalNotaFrequenciaService();

		ConfiguracaoNotaFrequencia result = instance
				.obterConfiguracaoNotaFrequencia(null);

	}

}
