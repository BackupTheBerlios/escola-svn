package br.ufg.inf.apsi.escola.componentes.relatorios.servico.local;

import net.sf.jasperreports.engine.JasperPrint;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioAvaliacaoDocenteTurma;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioNotasFrequenciasTurma;
import br.ufg.inf.apsi.escola.componentes.relatorios.servico.RelatorioService;

/**
 * Implenta a interface RelatorioService para acesso local do componente
 * relatorios.
 * 
 * @author Yoshiyuki
 * 
 */
public class LocalRelatorioService implements RelatorioService {

	/**
	 * Refer�ncia para um objeto RelatorioNotasFrequenciasTurma, implementado na
	 * camada de neg�cio.
	 */
	RelatorioNotasFrequenciasTurma relatorioNotasFrequenciasTurma;

	/**
	 * Refer�ncia para um objeto RelatorioAvaliacaoDocenteTurma, implementado na
	 * camada de neg�cio.
	 */
	RelatorioAvaliacaoDocenteTurma relatorioAvaliacaoDocenteTurma;

	/**
	 * Cria uma inst�ncia de LocalRelatorioService.
	 */
	public LocalRelatorioService() {
	}

	/**
	 * Recebe a inje��o de depend�ncia do objeto da camada de neg�cio
	 * respons�vel por gerar o relat�rio de Notas e Freq��ncias.
	 * 
	 * @param relatorioNotasFrequenciasTurma
	 *            Inst�ncia de RelatorioNotasFrequenciasTurma.
	 */
	public void setRelatorioNotasFrequenciasTurma(
			RelatorioNotasFrequenciasTurma relatorioNotasFrequenciasTurma) {
		this.relatorioNotasFrequenciasTurma = relatorioNotasFrequenciasTurma;
	}

	/**
	 * Recebe a inje��o de depend�ncia do objeto da camada de neg�cio
	 * respons�vel por gerar o relat�rio de Avaliacao de Docente.
	 * 
	 * @param relatorioAvaliacaoDocenteTurma
	 *            Inst�ncia de RelatorioAvaliacaoDocenteTurma.
	 */
	public void setRelatorioAvaliacaoDocenteTurma(
			RelatorioAvaliacaoDocenteTurma relatorioAvaliacaoDocenteTurma) {
		this.relatorioAvaliacaoDocenteTurma = relatorioAvaliacaoDocenteTurma;
	}

	/**
	 * Invoca o m�todo da camada de neg�cio que gera o relat�rio de Notas e
	 * Freq��ncias.
	 * 
	 * @param idTurma Long contendo um id de turma.
	 * @return Objeto JasperPrint pronto para ser exportado para PDF ou HTML.
	 * @throws Exception
	 */
	public JasperPrint gerarRelNotasFrequenciasTurma(Long idTurma)
			throws Exception {
		return relatorioNotasFrequenciasTurma.gerarRelatorio(idTurma);
	}

	/**
	 * Invoca o m�todo da camada de neg�cio que gera o relat�rio de Avaliacao de
	 * Docente.
	 * 
	 * @param idTurma Long contendo um id de turma.
	 * @return Objeto JasperPrint pronto para ser exportado para PDF ou HTML.
	 * @throws Exception
	 */
	public JasperPrint gerarRelAvaliacaoDocenteTurma(Long idTurma)
			throws Exception {
		return relatorioAvaliacaoDocenteTurma.gerarRelatorio(idTurma);
	}

}
