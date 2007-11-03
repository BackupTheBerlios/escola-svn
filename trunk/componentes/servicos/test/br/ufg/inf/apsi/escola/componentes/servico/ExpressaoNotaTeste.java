package test.br.ufg.inf.apsi.escola.componentes.servico;

import static org.junit.Assert.*;

import org.junit.Test;

import src.br.ufg.inf.apsi.escola.componentes.servico.ExpressaoNotaService;

;

/**
 * Classe para testar os métodos da classe ExpressãoNotaService
 * @author Gerson Rodrigues Pereira
 */

public class ExpressaoNotaTeste {

	/**
	 * Testa metodos de ExpressaoNotaService
	 * {@link br.ufg.inf.apsi.escola.componentes.servico.ExpressaoNotaService.validar}
	 */

	@Test
	public void testValidar() {
		try {
			ExpressaoNotaService expressao = new ExpressaoNotaService();

			assertEquals(expressao.validar("(N1+N2+N3)/3"), true);
			assertEquals(expressao.validar("(N1+N2+M3)/3"), false);
			assertEquals(expressao.validar("(N1+N2+M3)/"), false);
			assertEquals(expressao.validar("N1+N2+N3)/3"), false);
			assertEquals(expressao.validar("(N1+N2+N3)/345+N4"), true);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}