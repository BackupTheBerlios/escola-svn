package br.ufg.inf.apsi.escola.componentes.relatorios.servico;

import net.sf.jasperreports.engine.JasperPrint;
/**
 * Interface de servi�o para o componente relatorios
 * 
 * @author sponja
 *
 */
public interface RelatorioService {

	/**
	 * Gera relat�rio de notas e freq��ncias de aluno por turma. 
	 * 
	 * @param idTurma Long contendo um id de turma.
	 * @return Objeto JasperPrint pronto para ser exportado para PDF ou HTML.
	 * @throws Exception
	 */
	public JasperPrint gerarRelNotasFrequenciasTurma(Long idTurma) throws Exception;

	/**
	 * Gera relat�rio de Avaliacao de Docente por turma. 
	 * 
	 * @param idTurma Long contendo um id de turma.
	 * @return Objeto JasperPrint pronto para ser exportado para PDF ou HTML.
	 * @throws Exception
	 */
	public JasperPrint gerarRelAvaliacaoDocenteTurma(Long idTurma) throws Exception;
	
}
