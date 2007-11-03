package br.ufg.inf.apsi.escola.componentes.relatorios.negocio;

import net.sf.jasperreports.engine.JasperPrint;
/**
 * Interface para gera��o de relatorio de avaliacao de docente por turma.
 * 
 * @author Yoshiyuki
 *
 */
public interface RelatorioAvaliacaoDocenteTurma {

	/**
	 * Gera o relat�rio.
	 * 
	 * @param idTurma Long com o id da turma.
	 * @return JasperPrint Instancia de relat�rio JasperReports.
	 * @throws Exception
	 */
	public JasperPrint gerarRelatorio(Long idTurma) throws Exception;

}
