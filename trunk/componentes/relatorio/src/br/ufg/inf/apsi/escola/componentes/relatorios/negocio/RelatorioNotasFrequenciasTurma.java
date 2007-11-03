package br.ufg.inf.apsi.escola.componentes.relatorios.negocio;

import net.sf.jasperreports.engine.JasperPrint;
/**
 * Interface para geração de relatorio de Alunos por turma.
 * 
 * @author Yoshiyuki
 *
 */
public interface RelatorioNotasFrequenciasTurma {

	/**
	 * Gera o relatório.
	 * 
	 * @param idTurma Long com o id da turma.
	 * @return JasperPrint Instancia de relatório JasperReports.
	 * @throws Exception
	 */
	public JasperPrint gerarRelatorio(Long idTurma) throws Exception;

}
