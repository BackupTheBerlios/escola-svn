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
	 * Referência para um objeto RelatorioNotasFrequenciasTurma, implementado na
	 * camada de negócio.
	 */
	RelatorioNotasFrequenciasTurma relatorioNotasFrequenciasTurma;

	/**
	 * Referência para um objeto RelatorioAvaliacaoDocenteTurma, implementado na
	 * camada de negócio.
	 */
	RelatorioAvaliacaoDocenteTurma relatorioAvaliacaoDocenteTurma;

	/**
	 * Cria uma instância de LocalRelatorioService.
	 */
	public LocalRelatorioService() {
	}

	/**
	 * Recebe a injeção de dependência do objeto da camada de negócio
	 * responsável por gerar o relatório de Notas e Freqüências.
	 * 
	 * @param relatorioNotasFrequenciasTurma
	 *            Instância de RelatorioNotasFrequenciasTurma.
	 */
	public void setRelatorioNotasFrequenciasTurma(
			RelatorioNotasFrequenciasTurma relatorioNotasFrequenciasTurma) {
		this.relatorioNotasFrequenciasTurma = relatorioNotasFrequenciasTurma;
	}

	/**
	 * Recebe a injeção de dependência do objeto da camada de negócio
	 * responsável por gerar o relatório de Avaliacao de Docente.
	 * 
	 * @param relatorioAvaliacaoDocenteTurma
	 *            Instância de RelatorioAvaliacaoDocenteTurma.
	 */
	public void setRelatorioAvaliacaoDocenteTurma(
			RelatorioAvaliacaoDocenteTurma relatorioAvaliacaoDocenteTurma) {
		this.relatorioAvaliacaoDocenteTurma = relatorioAvaliacaoDocenteTurma;
	}

	/**
	 * Invoca o método da camada de negócio que gera o relatório de Notas e
	 * Freqüências.
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
	 * Invoca o método da camada de negócio que gera o relatório de Avaliacao de
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
