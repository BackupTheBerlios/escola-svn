package br.ufg.inf.apsi.escola.componentes.relatorios.servico.local;

import junit.framework.TestCase;
import net.sf.jasperreports.engine.JasperPrint;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioAvaliacaoDocenteTurma;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioNotasFrequenciasTurma;

/**
 * Classe de teste da classe LocalRelatorioService (Camada de Servico do Componente).
 * 
 * @author Yoshiyuki
 * 
 */
public class LocalRelatorioServiceTest extends TestCase {

	private Mockery contextoNotasFrequencias;
	private Mockery contextoAvaliacaoDocente;
	
	private RelatorioNotasFrequenciasTurma relatorioNotasFrequenciasTurma;
	private RelatorioAvaliacaoDocenteTurma relatorioAvaliacaoDocenteTurma;
	
	private LocalRelatorioService localRelatorioService;
	
	/**
	 * Inicializa��o de atributos.
	 */
	protected void setUp() throws Exception {
		contextoNotasFrequencias = new JUnit4Mockery();
		contextoAvaliacaoDocente = new JUnit4Mockery();
		
		relatorioNotasFrequenciasTurma = contextoNotasFrequencias.mock(RelatorioNotasFrequenciasTurma.class);
		relatorioAvaliacaoDocenteTurma = contextoAvaliacaoDocente.mock(RelatorioAvaliacaoDocenteTurma.class);
		
		localRelatorioService = new LocalRelatorioService();
		localRelatorioService.setRelatorioNotasFrequenciasTurma(relatorioNotasFrequenciasTurma);
		localRelatorioService.setRelatorioAvaliacaoDocenteTurma(relatorioAvaliacaoDocenteTurma);
	}

	/**
	 * Teste do m�todo GerarRelNotasFrequenciasTurma.
	 */
	public void testGerarRelNotasFrequenciasTurma() {
		
		try {
			contextoNotasFrequencias.checking(new Expectations() {
				{
					one(relatorioNotasFrequenciasTurma).gerarRelatorio(new Long(1));
					will(returnValue(new JasperPrint()));

					one(relatorioNotasFrequenciasTurma).gerarRelatorio(new Long(100));
					will(throwException(new Exception()));
				}
			});
		} catch (Exception e) {
			fail("Exce��o n�o esperada.");
		}

		try {
			JasperPrint jp = null;
			jp = localRelatorioService.gerarRelNotasFrequenciasTurma(new Long(1));
			assertNotNull(jp);
		} catch (Exception e) {
			fail("Exce��o n�o era esperada.");
		}
	
		/**
		 * Teste de retorno de excec�o no m�todo gerarRelNotasFrequenciasTurma.
		 */
		try {
			JasperPrint jp = null;
			jp = localRelatorioService.gerarRelNotasFrequenciasTurma(new Long(100));
			fail("Deveria retornar uma exce��o em gerarRelNotasFrequenciasTurma");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Teste do m�todo GerarRelAvaliacaoDocenteTurma.
	 */
	public void testGerarRelAvaliacaoDocenteTurma() {
		
		try {
			contextoAvaliacaoDocente.checking(new Expectations() {
				{
					one(relatorioAvaliacaoDocenteTurma).gerarRelatorio(new Long(1));
					will(returnValue(new JasperPrint()));

					one(relatorioAvaliacaoDocenteTurma).gerarRelatorio(new Long(100));
					will(throwException(new Exception()));
				}
			});
		} catch (Exception e) {
			fail("Exce��o n�o esperada.");
		}

		try {
			JasperPrint jp = null;
			jp = localRelatorioService.gerarRelAvaliacaoDocenteTurma(new Long(1));
			assertNotNull(jp);
		} catch (Exception e) {
			fail("Exce��o n�o era esperada.");
		}

		/**
		 * Teste de retorno de excec�o no m�todo gerarRelAvaliacaoDocenteTurma.
		 */
		try {
			JasperPrint jp = null;
			jp = localRelatorioService.gerarRelAvaliacaoDocenteTurma(new Long(100));
			fail("Deveria retornar uma exce��o em gerarRelAvaliacaoDocenteTurma.");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

}
