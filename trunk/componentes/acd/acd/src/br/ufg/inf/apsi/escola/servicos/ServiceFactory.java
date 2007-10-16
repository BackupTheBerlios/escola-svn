package br.ufg.inf.apsi.escola.servicos;

import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;

/**
 * Fabrica de Servicos para Avaliacao do Corpo Docente -
 * <code>AvaliacaoDocenteService</code>
 * 
 * @author Rodrigo Morian Loures
 */
public interface ServiceFactory {

	/**
	 * Metodo para obter referencia para a implementecao de
	 * <code>AvaliacaoDocenteService</code>
	 * 
	 * @return Instancia de implementacao de
	 *         <code>AvaliacaoDocenteService</code>
	 */
	public AvaliacaoDocenteService ObtemAvaliacaoDocenteService();
}
