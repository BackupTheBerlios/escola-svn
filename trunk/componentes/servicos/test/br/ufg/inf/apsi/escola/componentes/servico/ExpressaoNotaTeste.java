package test.br.ufg.inf.apsi.escola.componentes.servico;

import static org.junit.Assert.*;

import org.junit.Test;

import src.br.ufg.inf.apsi.escola.componentes.servico.ExpressaoNotaService;

;

/**
 * Classe para testar a classe ExpressãoNotaService
 * 
 * @author Gerson Rodrigues Pereira
 * 
 */

public class ExpressaoNotaTeste {

	/**
	 * Testa metodos...
	 * {@link br.ufg.inf.apsi.escola.componentes.servico.ExpressaoNotaService.validar e calulcar média}
	 */

	@Test
	public void testValidar() {
		try {
			ExpressaoNotaService expressao = new ExpressaoNotaService();

			assertEquals(expressao.validar("(N1+N2+N3)/3"), true);
			assertEquals(expressao.validar("(N1+N2+M3)/3"), false);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
}